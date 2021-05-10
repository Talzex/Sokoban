/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokoban;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author tduthil
 */
public class Board {

    String nom;
    int ligne;
    int colonne;
    
    public Set<Position> mur = new HashSet<>();
    public Set<Position> caisse = new HashSet<>();
    public Set<Position> cibles = new HashSet<>();
    
    public Position joueur;
    

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
     * Méthode permettant d'afficher les positions contenu dans nos ensemble
     */
    void dessinerContenu(){
        String[][]content = new String[ligne][colonne];
        for (String[] row : content) {
            Arrays.fill(row, ".");
        }
        mur.forEach((Position condition) -> {
            content[condition.row][condition.col] = "#";
        });
        cibles.forEach((Position condition) -> {
            content[condition.row][condition.col] = "x";
        });
        caisse.forEach((Position condition) -> {
            content[condition.row][condition.col] = "C";
        });
        content[joueur.row][joueur.col] = "P";
        for(int i = 0; i < ligne; i++){
             System.out.print(i + " ");
            for(int u = 0; u < colonne; u++){
                System.out.print(content[i][u] + " ");
            }
            System.out.println("");
        }
   
    }
    /**
     * Méthode permettant d'afficher les colonnes sur le haut de notre Board
     */
    void dessinerLigne() {
        System.out.print("  ");
        for(int i = 0; i < colonne; i ++){
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println("");
    }
    /**
     * Méthode permettant d'ajouter dans notre ensemble mur les positions des murs horizontaux
     */
    void addHorizontalWall(int lig, int col, int length) {
        for(int i = 0; i < length; i++){
           mur.add(new Position(lig, col+i));
       }
    }
    /**
     * Méthode permettant d'ajouter dans notre ensemble mur les positions des murs verticaux
     */
    void addVerticalWall(int lig, int col, int length){
        for(int i = 0; i < length; i++){
            mur.add(new Position(lig+i, col));
        }
    }
    /**
     * Méthode permettant d'ajouter dans notre ensemble caisse les positions des caisses
     */
    void addBox(int lig, int col){
        caisse.add(new Position(lig,col));
    }
    /**
     * Méthode permettant d'ajouter dans notre ensemble cibles les positions des cibles
     */
    void addTarget(int lig, int col){
        cibles.add(new Position(lig,col));
    }
    /**
     * Méthode permettant d'initialiser la position du Joueur
     */
    void setPosition(int lig, int col){
        joueur = new Position(lig,col);
    }
    
    /**
     * Méthode vérifiant si la Position est dans le Board
     * @param p, la Position
     * @return true si dans le Board, faux sinon
     */
    public  boolean DansBoard( Position p) {
        return p.row >= 0 && p.row < ligne && p.col >= 0 && p.col < colonne;
    }
    
    
}
