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
    
    public PlayerNGTest() {
    }

    /**
     * Test of textbuilder method, of class Player.
     */
    @Test
    public void testTextbuilder() throws Exception {
        System.out.println("textbuilder");
        Board expResult = null;
        Board result = Player.textbuilder();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of filebuilder method, of class Player.
     */
    @Test
    public void testFilebuilder() throws Exception {
        System.out.println("filebuilder");
        Board expResult = null;
        Board result = Player.filebuilder();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of EffectuerMouvement method, of class Player.
     */
    @Test
    public void testEffectuerMouvement() {
        System.out.println("EffectuerMouvement");
        Board b = null;
        Player.EffectuerMouvement(b);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Deplacement method, of class Player.
     */
    @Test
    public void testDeplacement() {
        System.out.println("Deplacement");
        Board b = null;
        Direction d = null;
        Player.Deplacement(b, d);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BougerCaisse method, of class Player.
     */
    @Test
    public void testBougerCaisse() {
        System.out.println("BougerCaisse");
        Board b = null;
        Position p = null;
        Position p2 = null;
        Direction d = null;
        Player.BougerCaisse(b, p, p2, d);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CollisionMur method, of class Player.
     */
    @Test
    public void testCollisionMur() {
        System.out.println("CollisionMur");
        Board b = null;
        Position p = null;
        boolean expResult = false;
        boolean result = Player.CollisionMur(b, p);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CollisionCaisse method, of class Player.
     */
    @Test
    public void testCollisionCaisse() {
        System.out.println("CollisionCaisse");
        Board b = null;
        Position p = null;
        boolean expResult = false;
        boolean result = Player.CollisionCaisse(b, p);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of VerifVictoire method, of class Player.
     */
    @Test
    public void testVerifVictoire() {
        System.out.println("VerifVictoire");
        Board b = null;
        boolean expResult = false;
        boolean result = Player.VerifVictoire(b);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
