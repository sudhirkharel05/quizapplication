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
public class QuestionsaddTest {
    
    @Test
    public void testQuestionList() {
        //Testing if the table is getting the questions and options from the database or not
        System.out.println("questionList");
        Questionsadd instance = new Questionsadd();
        boolean expResult = true;
        ArrayList<Question> list = instance.questionList();
        
        boolean result;
        if (list.isEmpty()) {
            result = false;
        } else{
            result = true;
        }
        assertEquals(expResult, result);
    }

   
}
