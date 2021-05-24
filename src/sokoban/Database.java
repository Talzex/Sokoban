/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokoban;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author tduthil
 */
public class Database {

    public Connection c;

    /**
     * Constructeur de la classe Database
     */
    public Database() {
        String chemin = "data/librairie.sqlite3";
        String URL = "jdbc:sqlite:" + chemin;
        chargerPiloteSQLite();
        try {
            Connection connexion = DriverManager.getConnection(URL);
            this.c = connexion;
        } catch (SQLException ex) {
            System.out.println(" Base " + URL + " introuvable.");
        }
    }

    /**
     * Méthode permettant de charger le pilote SqLite
     */
    private void chargerPiloteSQLite() {
        String sqlite_driver = "SQLite-jdbc-3.34.0.jar";
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException ex) {
            System.out.println("* Driver " + sqlite_driver + " introuvable.");
            System.exit(1);
        }
    }

    /**
     * Méthode permettant de créér une base de données
     */
     void creerDB() {
        try {
            Statement s = c.createStatement();
            String sql = "create table if not exists boards (board_id integer PRIMARY KEY,name text NOT NULL,nb_rows integer NOT NULL, nb_cols integer NOT NULL )";
            s.execute(sql);
            String sql2 = "create table if not exists rows (board_id integer , row_num integer NOT NULL, description text NOT NULL)";
            s.execute(sql2);
            System.out.println("Base de Données créée avec succès");
        } catch (SQLException ex) {
            System.out.println("La base de données n'existe pas");
        }
    }

    /**
     * Méthode permettant de supprimer la base de données
     */
    void supprimerDB() {
        try {
            Statement s = c.createStatement();
            String sql = "drop table if exists boards";
            s.execute(sql);
            String sql2 = "drop table if exists rows";
            s.execute(sql2);
            System.out.println("Base de Données supprimé avec succès");
        } catch (SQLException ex) {
            System.out.println("La base de données n'existe pas");
        }
    }

    /**
     * Méthode permettant de lister les différents Boards
     */
    void listerBoards() {
        try {
            Statement statement = c.createStatement();
            ResultSet resultats = statement.executeQuery("select * from boards");
            while (resultats.next()) {
                int id = resultats.getInt("board_id");
                String name = resultats.getString("name");
                int nblig = resultats.getInt("nb_rows");
                int nbcol = resultats.getInt("nb_cols");
                System.out.format("%d - %s %s %s", id, name, nblig, nbcol);
                System.out.println("");
            }
            resultats.close();
        } catch (SQLException ex) {
            System.out.println("La base de données n'existe pas.");
        }
    }

    /**
     * Méthode permettant de créer un Board à partir des données
     * de la base.
     *
     * @param id, le Board choisi
     * @return b, le Board créer
     * @throws sokoban.BuilderException
     */
     Board get(int id) throws BuilderException {
        var builder = new TextBoardBuilder("" + id);
        Board b = null;
        try {
            PreparedStatement prep = c.prepareStatement("select description from rows where board_id = ?");
            prep.setInt(1, id);
            ResultSet r = prep.executeQuery();
            while (r.next()) {
                String desc = r.getString("description");
                builder.addRow(desc);
            }
            b = builder.build();
        } catch (SQLException ex) {
            System.out.println("La base de données n'existe pas");
        }
        return b;
    }

    /**
     * Méthode permettant d'ajouter un Board à la base
     */
    void ajouterBoard(Board b) {
        try {
            boolean exist = false;
            int id = 0;
            Statement statement = c.createStatement();
            PreparedStatement prep = c.prepareStatement("insert into boards values (?, ?, ?, ?)");
            PreparedStatement prep2 = c.prepareStatement("insert into rows values (?,?,?) ");
            ResultSet resultats = statement.executeQuery("select * from boards");
            while (resultats.next()) {
                if (b.nom.equals(resultats.getString("name"))) {
                    exist = true;
                }
                if (id <= resultats.getInt("board_id")) {
                    id = resultats.getInt("board_id") + 1;
                }
            }
            prep.setInt(1, id);
            prep.setString(2, b.nom);
            prep.setInt(3, b.ligne);
            prep.setInt(4, b.colonne);
            prep.execute();

            prep2.setInt(1, id);
            String row;
            for (int i = 0; i < b.ligne; i++) {
                row = "";
                for (int u = 0; u < b.colonne; u++) {
                    row = row.concat(b.content[i][u]);
                }

                prep2.setInt(2, i);
                prep2.setString(3, row);
                prep2.execute();
            }
        } catch (SQLException ex) {
            System.out.println("La base de données n'existe pas.");
        }
    }

    /**
     * Méthode permettant d'enlever un Board de la base
     */
    void enleverBoard(int id) {
        try {
            PreparedStatement prep = c.prepareStatement("delete from boards where board_id = ?");
            PreparedStatement prep2 = c.prepareStatement("delete from rows where board_id = ?");
            prep.setInt(1, id);
            prep2.setInt(1, id);
            prep.execute();
            prep2.execute();
            System.out.println("Le board avec l'id " + id + " vient d'être suprimmé");
        } catch (SQLException ex) {
            System.out.println("La base de données n'existe pas.");
        }
    }

}
