/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ratkaisija;

import java.io.File;

/**
 *
 * @author tino
 */
public class DatabaseHandler {
    WordScanner ws;
    
    public DatabaseHandler() {
        ws = new WordScanner();
    }
    
    public boolean addWord(String word) {
        if (ws.checkWord(word)) {
            return false;
        }
        ws.addWord(word);
        return true;
    }
    
    public boolean addWord(String word, File file) {
        if (ws.checkWord(word, file)) {
            return false;
        }
        ws.addWord(word, file);
        return true;
    }
    
    public boolean delWord(String word) {
        if (!ws.checkWord(word)) {
            return false;
        }
        ws.delWord(word);
        return true;
    }
    
    public boolean delWord(String word, File file) {
        if (!ws.checkWord(word, file)) {
            return false;
        }
        ws.delWord(word, file);
        return true;
    }
    
    public boolean resetDB() {
        return ws.reset();
    }
    
}
