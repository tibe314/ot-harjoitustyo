package ratkaisija.datahandling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 * Handles actually editing the database.
 */
public class WordScanner {

    File privateWordList;

    /**
     * Initializes WordScanner. Calls a setup method that creates
     * PrivateWordList.txt if it doesn't already exist.
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
     * Deletes PrivateWordList, then re-creates it and copies all words from
     * FinnishWordList to it.
     *
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

        ArrayList<String> tempList = new ArrayList<>();

        /*
        //ugly spaghetti code to get the program to read WordListFinnish from the resources folder
        //janky way to check whether it's run from IDE or from a JAR file, and different methods to get
        //the ArrayList<String> used to reset private database using copyWords method
        //but hey, it works! just don't look too closely at the getJARWords and getFileFromResources methods
        */
        String protocol = this.getClass().getResource("").getProtocol();
        if (Objects.equals(protocol, "jar")) {
            try {
                tempList = getJARWords();
            } catch (IOException ex) {
            }
        } else {
            File wordList = getFileFromResources("WordListFinnish.txt");
            tempList = getWords(wordList);
        }

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
    
    private File getFileFromResources(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            return null;
        } else {
            return new File(resource.getFile());
        }
    }

    private ArrayList<String> getWords(File file) {
        ArrayList<String> list = new ArrayList<>();
        try ( Scanner wordScanner = new Scanner(file)) {
            while (wordScanner.hasNextLine()) {
                list.add(wordScanner.nextLine());
            }
        } catch (Exception e) {
            return new ArrayList<>();
        }
        return list;
    }

    private ArrayList<String> getJARWords() throws IOException {
        InputStream in = getClass().getResourceAsStream("/WordListFinnish.txt"); 
        BufferedReader txtReader = new BufferedReader(new InputStreamReader(in));
        ArrayList<String> words = new ArrayList<>();
        String line;
        while ((line = txtReader.readLine()) != null) {
            words.add(line);
        }
        txtReader.close();
        return words;
    }

    /**
     * Returns database content as an ArrayList.
     *
     * @return Database as a list.
     */
    public ArrayList<String> returnWords() {
        return getWords(privateWordList);
    }

    /**
     * Method checks if a given word exists in the database.
     *
     * @param word being checked.
     * @return True if the file contains the word, False otherwise.
     */
    public boolean checkWord(String word) {
        privateWordList = new File("PrivateWordList.txt");
        ArrayList<String> words = getWords(privateWordList);
        return words.contains(word);
    }

    /**
     * Method checks if a given word exists in a file. Exists for testing
     * purposes and for future features.
     *
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
     *
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
     * Deletes a word from the database.
     *
     * @param word that gets deleted.
     */
    public void delWord(String word) {
        privateWordList = new File("PrivateWordList.txt");
        ArrayList<String> newList = getWords(privateWordList);
        newList.remove(word);
        copyWords(newList, privateWordList);
    }
}
