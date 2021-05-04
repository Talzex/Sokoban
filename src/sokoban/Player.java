/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokoban;

/**
 *
 * @author tduthil
 */
public class Player {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Board b = new Board("Hard-Coded Example", 6, 9) ;
        b.dessinerColonne();
        b.dessinerLigne();
        b.addHorizontalWall(0, 0, 6);
        
    }
    
}
