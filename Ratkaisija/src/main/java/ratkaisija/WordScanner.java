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
    
    private void Setup() {
        File privateWordList = new File("PrivateWordList.txt");
        if (!privateWordList.exists()) {
            //create PrivateWordList.txt
            try {
                privateWordList.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

            //add the contents of WordListFinnish to a temporary ArrayList
            ArrayList<String> tempList = new ArrayList<>();
            try (Scanner tiedostonLukija = new Scanner(new File("WordListFinnish.txt"))) {

                // luetaan kaikki tiedoston rivit
                while (tiedostonLukija.hasNextLine()) {
                    tempList.add(tiedostonLukija.nextLine().substring(7));
                }
            } catch (Exception e) {
                System.out.println("Virhe: " + e.getMessage());
            }

        }
        //System.out.println(privateWordList.exists());
    }

}
