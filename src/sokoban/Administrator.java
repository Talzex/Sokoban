/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokoban;

import java.util.Scanner;

/**
 *
 * @author tduthil
 */
public class Administrator {
    
    static Scanner entree = new Scanner(System.in);
    static Database db = new Database();
    
    /**
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean encore = true;
        while (encore) {
            System.out.println("ADMINISTRATION INTERFACE - USE WITH CAUTION");
            System.out.println();
            System.out.println("1. Create new database");
            System.out.println("2. List boards");
            System.out.println("3. Show board");
            System.out.println("4. Add board from file");
            System.out.println("5. Remove board from database [DANGEROUS]");
            System.out.println("6. Quit.");
            System.out.println("Votre choix ?");

            String commande = entree.nextLine();
            System.out.println();

            switch (commande) {
                case "1":
                    db.creerDB();
                    break;
                case "2":
                    db.listerBoards();
                    break;
                case "3":
                    db.monterBoard();
                    break;
                case "4":
                    db.ajouterBoard();
                    break;
                case "5":
                    db.enleverBoard();
                    break;
                case "6":
                    encore = false;
                    break;
                case "":
                    break;
                default:
                    System.out.println("commande inconnue : " + commande);
            }
        }
    }
}
