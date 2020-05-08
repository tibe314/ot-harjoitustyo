/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ratkaisija.datahandling;

import java.io.File;

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
     * Identical method to addWord without file as a parameter, except checks and edits a given file.
     * Exists for testing purposes and for future features.
     * 
     * @param word that gets added.
     * @param file file that gets checked and edited.
     * @return False if file contains the word, True if doesn't.
     */
    public boolean addWord(String word, File file) {
        if (ws.checkWord(word, file)) {
            return false;
        }
        return ws.addWord(word, file);
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
     * Identical method to delWord without file as a parameter, except checks and edits given file.
     * Exists for testing purposes and for future features.
     * @param word that gets removed.
     * @param file file that gets checked and edited.
     * @return False if file doesn't contain the word, True otherwise.
     */
    public boolean delWord(String word, File file) {
        if (!ws.checkWord(word, file)) {
            return false;
        }
        ws.delWord(word, file);
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
