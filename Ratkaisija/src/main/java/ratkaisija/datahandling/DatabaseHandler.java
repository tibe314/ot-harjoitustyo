
package ratkaisija.datahandling;


/**
 * Class handles editing the database in a smart way. Class checks whether the word that's being added or deleted exists and returns a boolean so that UI
 * can display a correct message.
 */
public class DatabaseHandler {
    WordScanner ws;
    
    /**
     * Initializes Databasehandler.
     */
    public DatabaseHandler() {
        ws = new WordScanner();
    }
    
    /**
     * Checks if database contains a word, and if it doesn't, adds it.
     * 
     * @param word that gets added.
     * @return False if database contains the word, True if doesn't.
     */
    public boolean addWord(String word) {
        if (ws.checkWord(word)) {
            return false;
        }
        return ws.addWord(word);
    }
    
    /**
     * Checks if database contains a word, and if it does, removes it.
     * @param word that gets removed.
     * @return False if file doesn't contain the word, True otherwise.
     */
    public boolean delWord(String word) {
        if (!ws.checkWord(word)) {
            return false;
        }
        ws.delWord(word);
        return true;
    }
    
    /**
     * Resets PrivateWordList.txt as a copy of FinnishWordList.txt.
     * @return Returns True if resetting is successful (should always be the case).
     */
    public boolean resetDB() {
        return ws.reset();
    }
    
}
