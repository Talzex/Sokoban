package sokoban.Board;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author tduthil
 */
public class Board {

    public String nom;
    public int ligne;
    public int colonne;

    public Set<Position> mur = new HashSet<>();
    public Set<Position> caisse = new HashSet<>();
    public Set<Position> cibles = new HashSet<>();

    public Position joueur;
    
    public String[][] content;

    /**
     * Constructeur de la classe Board
     *
     * @param nom, le nom du Board
     * @param ligne, le nombre de ligne
     * @param colonne,le nombre de colonnes
     */
    public Board(String nom, int ligne, int colonne) {
        this.nom = nom;
        this.ligne = ligne;
        this.colonne = colonne;
    }

    /**
     * Méthode permettant de remplir le tableau d'affichage des éléments à
     * partir des Ensembles.
     */
    public void RemplirTableau(){
        content =  new String[ligne][colonne];
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
    }
    /**
     * Méthode permettant d'afficher le board
     */
    public void dessinerContenu() {
        RemplirTableau();
        for (int i = 0; i < ligne; i++) {
            System.out.print(i + " ");
            for (int u = 0; u < colonne; u++) {
                System.out.print(content[i][u] + " ");
            }
            System.out.println("");
        }
    }
    
    /**
     * Méthode permettant d'afficher les colonnes sur le haut de notre Board
     */
    public void dessinerLigne() {
        System.out.print("  ");
        for (int i = 0; i < colonne; i++) {
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println("");
    }
    /**
     * Méthode permettant d'ajouter dans notre ensemble mur les positions des
     * murs horizontaux
     * @param lig, la ligne
     * @param col, la colonne
     * @param length, la colonne
     */
    public void addHorizontalWall(int lig, int col, int length) {
        for (int i = 0; i < length; i++) {
            mur.add(new Position(lig, col + i));
        }
    }

    /**
     * Méthode permettant d'ajouter dans notre ensemble mur les positions des
     * murs verticaux
     * @param lig, la ligne
     * @param col, la colonne
     * @param length, la longueur
     */
    public void addVerticalWall(int lig, int col, int length) {
        for (int i = 0; i < length; i++) {
            mur.add(new Position(lig + i, col));
        }
    }

    /**
     * Méthode permettant d'ajouter dans notre ensemble caisse les positions des
     * caisses
     * @param lig, la ligne
     * @param col, la colonne
     */
    public void addBox(int lig, int col) {
        caisse.add(new Position(lig, col));
    }

    /**
     * Méthode permettant d'ajouter dans notre ensemble cibles les positions des
     * cibles
     * @param lig, la ligne
     * @param col, la colonne
     */
    public void addTarget(int lig, int col) {
        cibles.add(new Position(lig, col));
    }

    /**
     * Méthode permettant d'initialiser la position du Joueur
     * @param lig, la ligne
     * @param col, la colonne
     */
    public void setPosition(int lig, int col) {
        joueur = new Position(lig, col);
    }

    /**
     * Méthode vérifiant si la Position est dans le Board
     *
     * @param p, la Position
     * @return true si dans le Board, faux sinon
     */
    public boolean DansBoard(Position p) {
        return p.row >= 0 && p.row < ligne && p.col >= 0 && p.col < colonne;
    }
}
