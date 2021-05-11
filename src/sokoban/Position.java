/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokoban;

import java.util.Objects;

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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.row;
        hash = 53 * hash + this.col;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Position other = (Position) obj;
        if (this.row != other.row) {
            return false;
        }
        if (this.col != other.col) {
            return false;
        }
        return true;
    }
    
}
