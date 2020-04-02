
package ratkaisija;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tino
 */
public class RatkaisijaTest {
    
    Algorithm a;

    public RatkaisijaTest() {
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


    //Write tests here:
    
    @Test
    public void algorithmRecognizesIncorrectInputs() {
        assertEquals(false, a.checkInputLenght("this should be false"));
    }
    
    @Test
    public void algorithmRecognizesCorrectInputs() {
        assertEquals(true, a.checkInputLenght("aaaaaaaaaaaaaaaa")); //16 a's -> true
    }
    
    @Test
    public void algorithmSetsInputCorrectly() {
        String testString = "kuustoistacharia";
        if (a.checkInputLenght(testString)) { //check if test input is of correct lenght (it is), pretty redundant given
            a.setInput(testString);           //test no. 2 but eh
        }
        assertEquals(testString, a.getInput());
    }
}
