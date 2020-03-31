
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void algorithmRecognizesIncorrectInputs() {
        a.setInput("this should be false"); //20 characters
        Boolean result = a.checkInputLenght();
        assertEquals(false, result);
    }
    
    @Test
    public void algorithmRecognizesCorrectInputs() {
        a.setInput("aaaaaaaaaaaaaaaa"); //16 a's, -> true
        Boolean result = a.checkInputLenght();
        assertEquals(true, result);
    }
}
