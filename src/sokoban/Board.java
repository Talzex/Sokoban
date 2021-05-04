/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokoban;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author tduthil
 */
public class Board {

    String nom;
    int ligne;
    int colonne;
    
    Set<Position> wall = new HashSet<>();
    Set<Position> caisse = new HashSet<>();
    Set<Position> target = new HashSet<>();
    Set<Position> vide = new HashSet<>();
    Set<Position> joueur = new HashSet<>();
    

    /**
     * Constructeur de la classe Board
     *
     * @param nom, le nom du Board
     * @param ligne, le nombre de ligne
     * @param colonne,le nombre de colonnes
     */
    Board(String nom, int ligne, int colonne) {
        this.nom = nom;
        this.ligne = ligne;
        this.colonne = colonne;
    }

    /**
     * Méthode permettant d'afficher les lignes des côtés de notre Board
     */
    void dessinerLigne() {
        for (int i = 0; i < ligne; i++) {
            System.out.print(i);
            System.out.println(" ");
        }
    }

    /**
     * Méthode permettant d'afficher les colonnes sur le haut de notre Board
     */
    void dessinerColonne() {
        System.out.print("  ");
        for (int i = 0; i < colonne; i++) {
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println("");
    }

    void addHorizontalWall(int lig, int col, int length) {
       
        for(int i = 0; i < length; i++){
           wall.add(new Position(lig, col+i));
       }
        
        for (Position s : wall)
            System.out.print(s.col + " " + s.row);
        System.out.println();
    }
    
    void addVerticalWall(int lig, int col, int length){
        
    }
    
    void addBox(int lig, int col){
        
    }
    
    void addTarget(int lig, int col){
        
    }
    
    void setPosition(int lig, int col){
        
    }
}
