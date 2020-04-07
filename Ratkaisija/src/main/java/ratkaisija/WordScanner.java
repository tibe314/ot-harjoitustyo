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

    public WordScanner() {
        Setup();
    }

    //Creates user's own database of finnish words the first time the program is executed
    //(or if the database file 'PrivateWordList.txt' somehow gets deleted
    private void Setup() {
        File privateWordList = new File("PrivateWordList.txt");
        System.out.println("Wordscanner setup debug sout: " + privateWordList.exists());
        if (!privateWordList.exists()) {
            //create PrivateWordList.txt
            try {
                privateWordList.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

            //add the contents of WordListFinnish to a temporary ArrayList
            ArrayList<String> tempList = new ArrayList<>();
            try ( Scanner wordScanner = new Scanner(new File("WordListFinnish.txt"))) {

                while (wordScanner.hasNextLine()) {
                    tempList.add(wordScanner.nextLine());
                }
            } catch (Exception e) {
                System.out.println("Virhe tapahtui: " + e.getMessage());
            }

            //move the contents of the ArrayList to the newly created file
            try {
                FileWriter myWriter = new FileWriter("PrivateWordList.txt");
                for (String s : tempList) {
                    myWriter.write(s + "\n");
                }
                myWriter.close();
            } catch (IOException e) {
                System.out.println("Virhe tapahtui: " + e.getMessage());
                
            }
        }
        //if the file exists, nothing is done
    }
}
