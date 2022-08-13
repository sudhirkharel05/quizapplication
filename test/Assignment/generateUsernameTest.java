/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author SUDHIR
 */
public class generateUsernameTest {
    
    public generateUsernameTest() {
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
     * Test of studentList method, of class generateUsername.
     */
    @Test
    public void testStudentList() {
       System.out.println("studentList");
        generateUsername instance = new generateUsername();
        boolean expResult = true;
        ArrayList<Student> demo = instance.studentList();
        boolean result;
        if (demo.isEmpty()) {
            result = false;
        } else{
            result = true;
        }
        assertEquals(expResult, result);
    }
    
}
