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
public class Position {
     int row, col;

    /**
     * Constructeur de la classe Position utilisant 2 paramètres entiers.
     *
     * @param row colonne de notre plateau
     * @param col ligne de notre plateau
     */
    public Position(int row, int col) {
        this.row = row;
        this.col = col;

    }
}
