/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokoban;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author tduthil
 */
public class PlayerNGTest {
    
       static Board textbuilder() throws BuilderException {
        var builder = new TextBoardBuilder("A Simple Board");
        builder.addRow("##########");
        builder.addRow("#.x.x#...#");
        builder.addRow("#...CC..P#");
        builder.addRow("#........#");
        builder.addRow("##########");
        Board b = builder.build();
        return b;
    }

    /**
     * Test of Deplacement method, of class Player.
     * @throws sokoban.BuilderException
     */
    @Test
    public void testDeplacement() throws BuilderException {
        System.out.println("Deplacement");
        Board b = textbuilder();
        Direction d = Direction.NORD;
        Player.Deplacement(b, d);
        assertEquals(b.joueur, new Position(1,8));
    }

    /**
     * Test of CollisionMur method, of class Player.
     * @throws sokoban.BuilderException
     */
    @Test
    public void testCollisionMur() throws BuilderException {
        System.out.println("CollisionMur");
        Board b =  textbuilder();
        Position p = b.joueur;
        boolean expResult = false;
        boolean result = Player.CollisionMur(b, p);
        assertEquals(result, expResult);
        Position p2 = new Position(0,0);
        boolean expResult2 = true;
        boolean result2 = Player.CollisionMur(b, p2);
        assertEquals(result2, expResult2);
        
    }

    /**
     * Test of CollisionCaisse method, of class Player.
     * @throws sokoban.BuilderException
     */
    @Test
    public void testCollisionCaisse() throws BuilderException {
        System.out.println("CollisionCaisse");
        Board b = textbuilder();
        Position p = b.joueur;
        boolean expResult = false;
        boolean result = Player.CollisionCaisse(b, p);
        assertEquals(result, expResult);
        Position p2 = new Position(2,5);
        boolean expResult2 = true;
        boolean result2 = Player.CollisionCaisse(b, p2);
        assertEquals(result2, expResult2);
    }
}
