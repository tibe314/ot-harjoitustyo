
package ratkaisija;

import ratkaisija.datahandling.WordScanner;
import ratkaisija.datahandling.DatabaseHandler;
import ratkaisija.solver.Algorithm;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tino
 */
public class AlgorithmTest {
    
    Algorithm a;
    
    public AlgorithmTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        a = new Algorithm();
    }
    
    @After
    public void tearDown() {
        
    }
    
    // Write tests here
    
    @Test
    public void algorithmRecognizesIncorrectInputs() {
        assertEquals(false, a.checkInputLength("this should be false"));
    }
    
    @Test
    public void algorithmRecognizesCorrectInputs() {
        assertEquals(true, a.checkInputLength("aaaaaaaaaaaaaaaa")); //16 a's -> true
    }
    
    @Test
    public void algorithmSetsInputCorrectly() {
        String testString = "kuustoistacharia";
        if (a.checkInputLength(testString)) { //check if test input is of correct lenght (it is), pretty redundant given
            a.setInput(testString);           //test no. 2 but eh
        }
        assertEquals(testString, a.getInput());
    }
    
    @Test
    public void algorithmSetsGrid() {
        a.setInput("ohjrkojeiioentlm");
        char[][] testGrid = { // /0 is null character
            {'\0','\0','\0','\0','\0','\0'},
            {'\0','o','h','j','r','\0'},
            {'\0','k','o','j','e','\0'},
            {'\0','i','i','o','e','\0'},
            {'\0','n','t','l','m','\0'},
            {'\0','\0','\0','\0','\0','\0'}
        };
        Assert.assertArrayEquals(a.getGrid(), testGrid);
    }
    
        @Test
    public void algorithmFindsWords() {
        a.setInput("ohjrkojeiioentlm");
        ArrayList<String> list = a.getList();
        assertTrue(list.contains("ohjelmointi"));
    }
    
    @Test
    public void algorithmDoesntFindWords() {
        a.setInput("ohjrkojeiioentlm");
        ArrayList<String> list = a.getList();
        assertFalse(list.contains("onkiliero"));
    }
    
    @Test
    public void algorithmReturnsEmptyListWhenNoInput() {
        ArrayList<String> list = a.getList();
        assertTrue(list.isEmpty());
    }
    
}
