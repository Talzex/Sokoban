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
        dessinerPlateau();
        partie();
    }
    public static  void dessinerPlateau(){
        Board b = new Board("Hard-Coded Example", 6, 9) ;
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

    private static void partie() {
        
    }
    
    void EffectuerMouvement(Board b){
        boolean continuer = false;
        do {
            System.out.println("> Quelle série de mouvements voulez-vous effectuer ? U,D,L,R ");
                String coupSaisi = LireMouvement(b);
            for(int i = 0; i < coupSaisi.length(); i++){
                switch(coupSaisi.charAt(i)){
            case 'U':
                b.joueur.row += Direction.NORD.mvtVertical();
                break;
            case 'D':
                b.joueur.row += Direction.SUD.mvtVertical();
                break;
            case 'L':
                b.joueur.col += Direction.OUEST.mvtHorizontal();
                break;
            case 'R':
                b.joueur.col += Direction.EST.mvtHorizontal();
                 break;
            default:
                System.out.println("Saisie Incorrecte");
        }
                continuer = true;
            }
        } while (!continuer);
    }
    /**
     * Méthode permettant de lire le choix du joueur.
     *
     * @param b, Board sur lequelle on joue
     * @return la Position choisit
     */
    String LireMouvement(Board b)  {
        String coupSaisi = in.nextLine();
        return coupSaisi;
    }
    
}
