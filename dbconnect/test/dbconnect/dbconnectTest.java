/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbconnect;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Slaven
 */
public class dbconnectTest {
    
    public dbconnectTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class dbconnect.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        dbconnect.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsername method, of class dbconnect.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        dbconnect instance = new dbconnect();
        String expResult = "";
        String result = instance.getUsername();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPassword method, of class dbconnect.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        dbconnect instance = new dbconnect();
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsername method, of class dbconnect.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "";
        dbconnect instance = new dbconnect();
        instance.setUsername(username);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPassword method, of class dbconnect.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "";
        dbconnect instance = new dbconnect();
        instance.setPassword(password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of init method, of class dbconnect.
     */
    @Test
    public void testInit() {
        System.out.println("init");
        dbconnect.init();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkLogin method, of class dbconnect.
     */
    @Test
    public void testCheckLogin() {
        System.out.println("checkLogin");
        dbconnect instance = new dbconnect();
        instance.checkLogin();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setInfo method, of class dbconnect.
     */
    @Test
    public void testSetInfo() {
        System.out.println("setInfo");
        dbconnect instance = new dbconnect();
        instance.setInfo();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
