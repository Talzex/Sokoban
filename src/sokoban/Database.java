/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokoban;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author tduthil
 */
public class Database {
    public static Connection c;
    
    public Database(){
        String chemin = "data/librairie.sqlite3";
        String URL = "jdbc:sqlite:" + chemin;
        chargerPiloteSQLite();
        try (Connection connexion = DriverManager.getConnection(URL)) {
            this.c = connexion;
            createtable(connexion);
        } catch (SQLException ex) {
            System.err.println("* Base " + URL + " introuvable.");
        }
    }

    private void chargerPiloteSQLite() {
        String sqlite_driver = "SQLite-jdbc-3.34.0.jar";
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException ex) {
            System.err.println("* Driver " + sqlite_driver + " introuvable.");
            System.exit(1);
        }
    }

    private void createtable(Connection c) throws SQLException {
        Statement s = c.createStatement();
        String sql = "CREATE TABLE IF NOT EXISTS BOARDS (\n"
                + "	board_id integer PRIMARY KEY,\n"
                + "	name text NOT NULL,\n"
                + "	nb_rows integer NOT NULL\n"
                + "	nb_cols integer NOT NULL\n"
                + ");";
        s.execute(sql);
        
        String sql2 = "CREATE TABLE IF NOT EXISTS ROWS (\n"
                + "	board_id integer PRIMARY KEY,\n"
                + "	description text NOT NULL,\n"
                + ");";
        s.execute(sql2);
        
    }

     void creerDB() {
        
    }
    
     void listerBoards() {
        
    }

     void monterBoard() {
        
    }

     void ajouterBoard() {
        
    }

     void enleverBoard() {
        
    }
}
