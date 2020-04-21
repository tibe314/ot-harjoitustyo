package ratkaisija;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author tino
 */
public class WordScanner {
    
    File privateWordList;

    public WordScanner() {
        setup();
    }

    //Creates user's own database of finnish words the first time the program is executed
    //(or if the database file 'PrivateWordList.txt' somehow gets deleted
    private void setup() {
        privateWordList = new File("PrivateWordList.txt");
        if (!privateWordList.exists()) {
            //create PrivateWordList.txt
            reset();
        }
        //if the file exists, nothing is done
    }

    public boolean reset() {
        File privateWordList = new File("PrivateWordList.txt");
        privateWordList.delete();
        try {
            privateWordList.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<String> tempList = getWords(new File("WordListFinnish.txt"));
        copyWords(tempList, privateWordList);
        return true;

    }

    private void copyWords(ArrayList<String> words, File targetFile) {
        try {
            FileWriter writer = new FileWriter(targetFile);
            for (String s : words) {
                writer.write(s + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Virhe tapahtui: " + e.getMessage());
        }
    }

    private ArrayList<String> getWords(File file) {
        ArrayList<String> list = new ArrayList<>();
        try (Scanner wordScanner = new Scanner(file)) {
            while (wordScanner.hasNextLine()) {
                list.add(wordScanner.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Virhe tapahtui: " + e.getMessage());
        }

        return list;
    }
    
    public ArrayList<String> returnWords() {
        return getWords(privateWordList);
    }

    public boolean checkWord(String word) {
        //method checks if a given word exists in the database
        File privateWordList = new File("PrivateWordList.txt");
        ArrayList<String> words = getWords(privateWordList);
        return words.contains(word);
    }

    public boolean checkWord(String word, File file) {
        ArrayList<String> words = getWords(file);
        return words.contains(word);
    }

    public void addWord(String word) {
        File privateWordList = new File("PrivateWordList.txt");
        try {
            FileWriter writer = new FileWriter(privateWordList, true);
            writer.write(word + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Virhe tapahtui: " + e.getMessage());
        }
    }

    public void addWord(String word, File file) {
        try {
            FileWriter writer = new FileWriter(file, true);
            writer.write(word + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Virhe tapahtui: " + e.getMessage());
        }
    }

    public void delWord(String word) {
        privateWordList = new File("PrivateWordList.txt");
        ArrayList<String> newList = getWords(privateWordList);
        newList.remove(word);
        copyWords(newList, privateWordList);
    }

    public void delWord(String word, File file) {
        ArrayList<String> newList = getWords(file);
        newList.remove(word);
        copyWords(newList, file);
    }
}
