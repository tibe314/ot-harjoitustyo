package ratkaisija.datahandling;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Handles actually editing the database.
 */
public class WordScanner {
    
    File privateWordList;

    /**
     * Initializes WordScanner. Calls a setup method that creates PrivateWordList.txt if it doesn't already exist.
     */
    public WordScanner() {
        setup();
    }

    private void setup() {
        privateWordList = new File("PrivateWordList.txt");
        if (!privateWordList.exists()) {
            reset();
        }
    }
    

    /**
     * Deletes PrivateWordList, then re-creates it and copies all words from FinnishWordList to it.
     * @return Returns true if nothing goes wrong.
     */
    public boolean reset() {
        privateWordList = new File("PrivateWordList.txt");
        privateWordList.delete();
        try {
            privateWordList.createNewFile();
        } catch (IOException e) {
            return false;
        }
        ArrayList<String> tempList = getWords(new File("WordListFinnish.txt"));
        return copyWords(tempList, privateWordList);

    }

    private boolean copyWords(ArrayList<String> words, File targetFile) {
        try {
            FileWriter writer = new FileWriter(targetFile);
            for (String s : words) {
                writer.write(s + "\n");
            }
            writer.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    private ArrayList<String> getWords(File file) {
        ArrayList<String> list = new ArrayList<>();
        try (Scanner wordScanner = new Scanner(file)) {
            while (wordScanner.hasNextLine()) {
                list.add(wordScanner.nextLine());
            }
        } catch (Exception e) {
            return new ArrayList<>();
        }

        return list;
    }
    
    /**
     * Returns database content as an ArrayList.
     * @return Database as a list.
     */
    public ArrayList<String> returnWords() {
        return getWords(privateWordList);
    }

    /**
     * Method checks if a given word exists in the database.
     * @param word being checked.
     * @return True if the file contains the word, False otherwise.
     */
    public boolean checkWord(String word) {
        privateWordList = new File("PrivateWordList.txt");
        ArrayList<String> words = getWords(privateWordList);
        return words.contains(word);
    }

    /**
     * Method checks if a given word exists in a file. Exists for testing purposes and for future features.
     * @param word being checked.
     * @param file being checked.
     * @return True if the file contains the word, False otherwise.
     */
    public boolean checkWord(String word, File file) {
        ArrayList<String> words = getWords(file);
        return words.contains(word);
    }


    /**
     * Adds a word to the database.
     * @param word that gets added.
     * @return True if everything works.
     */
    public boolean addWord(String word) {
        privateWordList = new File("PrivateWordList.txt");
        try {
            FileWriter writer = new FileWriter(privateWordList, true);
            writer.write(word + "\n");
            writer.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    /**
     * Adds a word to a given file. Exists for testing and for future features.
     * @param word that gets added.
     * @param file that the word gets added to.
     * @return True if everything works.
     */
    public boolean addWord(String word, File file) {
        try {
            FileWriter writer = new FileWriter(file, true);
            writer.write(word + "\n");
            writer.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    /**
     * Deletes a word from the database.
     * @param word that gets deleted.
     */
    public void delWord(String word) {
        privateWordList = new File("PrivateWordList.txt");
        ArrayList<String> newList = getWords(privateWordList);
        newList.remove(word);
        copyWords(newList, privateWordList);
    }

    /**
     * Deleted a word from a given file. Exists for testing and for future features.
     * @param word that gets deleted.
     * @param file that the word gets deleted from.
     */
    public void delWord(String word, File file) {
        ArrayList<String> newList = getWords(file);
        newList.remove(word);
        copyWords(newList, file);
    }
}
