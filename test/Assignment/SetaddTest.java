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
public class SetaddTest {
    
   @Test
    public void testNameList() {
        //testing if the table is getting the value from the database or not
        System.out.println("nameList");
        Setadd instance = new Setadd();
        boolean expResult = true;
        ArrayList<Set> demo = instance.nameList();
        
        boolean result;
        if (demo.isEmpty()) {
            result = false;
        } else{
            result = true;
        }
        assertEquals(expResult, result);
       
    }
}
