/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokoban;

import sokoban.Board.Position;
import sokoban.Board.Board;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author tduthil
 */
public class BoardNGTest {
    
    public BoardNGTest() {
    }

    /**
     * Test of addHorizontalWall method, of class Board.
     */
    @Test
    public void testAddHorizontalWall() {
        System.out.println("addHorizontalWall");
        int lig = 2;
        int col = 4;
        int length = 1;
        Board instance = new Board("addHorizontalWall", 6, 9);
        instance.addHorizontalWall(lig, col, length);
        assertTrue(!(instance.mur.isEmpty()));
    }

    /**
     * Test of addVerticalWall method, of class Board.
     */
    @Test
    public void testAddVerticalWall() {
        System.out.println("addVerticalWall");
        int lig = 4;
        int col = 2;
        int length = 1;
        Board instance = new Board("addVerticalWall", 6, 9);
        instance.addVerticalWall(lig, col, length);
        assertTrue(!(instance.mur.isEmpty()));
    }

    /**
     * Test of addBox method, of class Board.
     */
    @Test
    public void testAddBox() {
        System.out.println("addBox");
        int lig = 1;
        int col = 1;
        Board instance = new Board("addBox", 6, 9);
        instance.addBox(lig, col);
        assertTrue(instance.caisse.contains(new Position(lig,col)));
    }

    /**
     * Test of addTarget method, of class Board.
     */
    @Test
    public void testAddTarget() {
        System.out.println("addTarget");
        int lig = 2;
        int col = 2;
        Board instance = new Board("addTarget", 6, 9);
        instance.addTarget(lig, col);
        assertTrue(instance.cibles.contains(new Position(lig,col)));
    }

    /**
     * Test of setPosition method, of class Board.
     */
    @Test
    public void testSetPosition() {
        System.out.println("setPosition");
        int lig = 3;
        int col = 3;
        Board instance = new Board("addTarget", 6, 9);
        instance.setPosition(lig, col);
        assertTrue(instance.joueur.equals(new Position(lig,col)));
    }

    /**
     * Test of DansBoard method, of class Board.
     */
    @Test
    public void testDansBoard() {
        System.out.println("DansBoard");
        Position p = new Position(2,5);
        Position p2 = new Position(10,8);
        Board instance = new Board("addTarget", 6, 9);
        boolean expResult = true;
        boolean result = instance.DansBoard(p);
        assertEquals(result, expResult);
        boolean expResult2 = false;
        boolean result2 = instance.DansBoard(p2);
        assertEquals(result, expResult);
    }
    
}
