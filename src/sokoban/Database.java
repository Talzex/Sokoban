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

    private void chargerPiloteSQLite() {
        String sqlite_driver = "SQLite-jdbc-3.34.0.jar";
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException ex) {
            System.out.println("* Driver " + sqlite_driver + " introuvable.");
            System.exit(1);
        }
    }

    public void creerDB() throws SQLException {
        Statement s = c.createStatement();
        String sql = "create table if not exists boards (board_id integer PRIMARY KEY,name text NOT NULL,nb_rows integer NOT NULL, nb_cols integer NOT NULL )";
        s.execute(sql);
        String sql2 = "create table if not exists rows (board_id integer PRIMARY KEY,description text NOT NULL)";
        s.execute(sql2);
        System.out.println("Base de Données créée avec succès");

    }

    void listerBoards() throws SQLException {
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
    }

    void montrerBoard(int id) {
        
    }

    void ajouterBoard() throws BuilderException, SQLException {
        var filebuilder = new FileBoardBuilder(".\\data\\level1.txt");
        Board b = filebuilder.build();
        PreparedStatement prep = c.prepareStatement("insert into boards values (?, ?, ?, ?);");
        PreparedStatement prep2 = c.prepareStatement("insert into rows values (?,?);");
        
        prep.setInt(1, 1);
        prep.setString(2, b.nom);
        prep.setInt(3, b.ligne);
        prep.setInt(4, b.colonne);
        prep.execute();
        
        prep2.setInt(1, 1);
        //prep2.setString(2, );
        //prep2.execute();
        

    }

    void enleverBoard(int id) throws SQLException {
        PreparedStatement prep = c.prepareStatement("delete from boards where board_id = ?");
        PreparedStatement prep2 = c.prepareStatement("delete from rows where board_id = ?");
        prep.setInt(1, id);
        prep2.setInt(1, id);
        prep.execute();
        prep2.execute();
        System.out.println("Le board avec l'id " + id + " vient d'être suprimmé" );
    }
}
