
package ratkaisija;

import ratkaisija.datahandling.WordScanner;
import ratkaisija.datahandling.DatabaseHandler;
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
public class DatabaseTest {
    
    WordScanner wc;
    DatabaseHandler dbh;

    public DatabaseTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        wc = new WordScanner();
        dbh = new DatabaseHandler();
    }

    @After
    public void tearDown() {
        wc.delWord("aaa");
    }


    //Write tests here:
    
    @Test
    public void wordsCanBeAddedAndChecked() {
        wc.addWord("aaa");
        assertTrue(wc.checkWord("aaa"));
    }
    
    @Test
    public void nonexistentWordsArentFound() {
        assertFalse(wc.checkWord("bbb"));
    }
    
    @Test
    public void databaseHandlerDoesntAddExistingWords() {
        wc.addWord("aaa");
        assertFalse(dbh.addWord("aaa"));
    }
    
    @Test
    public void databaseHandlerCanAddWords() {
        assertTrue(dbh.addWord("aaa"));
        assertFalse(dbh.addWord("aaa"));
    }
    
    @Test
    public void wordsCanBeDeleted() {
        wc.addWord("aaa");
        wc.delWord("aaa");
        assertFalse(wc.checkWord("aaa"));
    }
    
    @Test
    public void databaseHandlerDeletesWord() {
        assertTrue(dbh.addWord("aaa"));
        assertTrue(dbh.delWord("aaa"));
    }
    
    @Test
    public void databaseHandlerReturnsFalseWhenDeletingNonexistentWord() {
        assertFalse(dbh.delWord("asdasdasdasd"));
    }
}
