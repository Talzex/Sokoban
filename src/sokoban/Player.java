/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokoban;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author tduthil
 */
public class Player {

    static Scanner in = new Scanner(System.in);
    public static ArrayList<Position> coupsjoues = new ArrayList<>();
    /**
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Board b = new Board("Hard-Coded Example", 6, 9) ;
        boolean win = false;
        dessinerPlateau(b);
        do{
            EffectuerMouvement(b);
            b.dessinerLigne();
            b.dessinerContenu();
        } while (!win);
    }
    public static  void dessinerPlateau(Board b){
        
        b.dessinerLigne();
        b.addHorizontalWall(0, 2, 4);
        b.addHorizontalWall(1, 0, 3);
        b.addHorizontalWall(1, 5, 4);
        b.addVerticalWall(2, 0, 4);
        b.addVerticalWall(2, 8, 4);
        b.addHorizontalWall(5, 1, 7);
        b.addVerticalWall(3, 2, 1);
        b.addVerticalWall(3, 5, 2);
        b.addBox(2, 6);
        b.addBox(3, 6);
        b.addTarget(4, 2);
        b.addTarget(4, 4);
        b.setPosition(4, 6);
        b.dessinerContenu();
    }
    
   static void  EffectuerMouvement(Board b){
            System.out.println("> Quelle série de mouvements voulez-vous effectuer ? U,D,L,R ");
            String coupSaisi = LireSaisieMouvement(b);
            for(int i = 0; i < coupSaisi.length(); i++){
                switch(coupSaisi.charAt(i)){
            case 'U':
                Mouvement(b, Direction.NORD);
                break;
            case 'D':
                Mouvement(b, Direction.SUD);
                break;
            case 'L':
                Mouvement(b, Direction.OUEST);
                break;
            case 'R':
                Mouvement(b, Direction.EST);
                 break;
            default:
                System.out.println("Saisie Incorrecte");
                }
            }
    }
   
   public static void Mouvement(Board b, Direction d) {
    boolean mur = false;
    Position nextPosition;
    if (d.equals(Direction.NORD) || d.equals(Direction.SUD)) {
        nextPosition = new Position(b.joueur.row + d.mvtVertical(), b.joueur.col);
        mur = CollisionMur(b, nextPosition, d);
        if (!mur) {
            b.joueur.row += d.mvtVertical();
        }
    } else if (d.equals(Direction.EST) || d.equals(Direction.OUEST)) {
        nextPosition = new Position(b.joueur.row, b.joueur.col + d.mvtHorizontal());
        mur = CollisionMur(b, nextPosition, d);
        if (!mur) {
            b.joueur.col += d.mvtHorizontal();
        }
    }
    /*if (d.equals(Direction.NORD) || d.equals(Direction.SUD)) {
        nextPosition = new Position(b.joueur.row + d.mvtVertical(), b.joueur.col);
        if (!b.mur.equals(nextPosition)) {
            b.joueur.row += d.mvtVertical();
        } else {
            System.out.println("Erreur");
    }
    } else if (d.equals(Direction.EST) || d.equals(Direction.OUEST)) {
        nextPosition = new Position(b.joueur.row, b.joueur.col + d.mvtHorizontal());
        if (!b.mur.equals(nextPosition)) {
            b.joueur.row += d.mvtVertical();
        } else {
            System.out.println("Erreur");
        }
    }*/
}   
   
   public static  boolean CollisionMur(Board b, Position p, Direction d){
       boolean mur = false;
       for(Position pmur : b.mur){
            if(pmur.row == p.row && pmur.col == p.col){
                 mur = true;
            }
        }
        return mur;
   }
   
   public static boolean CollisionCaisse(Board b, Position p, Direction d){
       boolean caisse = false;
       for(Position pbox : b.caisse){
           if(pbox.row == p.row && pbox.col == p.col){
               caisse = true;
           }
       }
       return caisse;
   }
    /**
     * Méthode permettant de lire le choix du joueur.
     *
     * @param b, Board sur lequelle on joue
     * @return la Position choisit
     */
    static String  LireSaisieMouvement(Board b)  {
        String coupSaisi = in.nextLine();
        return coupSaisi;
    }
}
