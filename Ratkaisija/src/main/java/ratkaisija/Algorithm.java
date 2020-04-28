package ratkaisija;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Class handles finding words in a given 2d char-array.
 */
public class Algorithm {

    private String input;
    private char[][] grid;
    private ArrayList<Character> charList;
    WordScanner ws;

    /**
     * Initializes algorithm.
     */
    public Algorithm() {
        ws = new WordScanner();
    }

    /**
     * Checks if input length is 16.
     *
     * @param userInput String
     *
     * @return True if length is 16
     */
    public boolean checkInputLenght(String userInput) {
        return userInput.length() == 16;
    }

    /**
     * Sets algorithm's input to given string.
     * @param s String
     */
    public void setInput(String s) {
        this.input = s.toLowerCase();
        charList = new ArrayList<>();
        for (char c : input.toCharArray()) {
            charList.add(c);
        }
        setGrid();
    }

    private void setGrid() {
        grid = new char[6][6];
        int k = 0;
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 4; j++) {
                grid[i][j] = input.charAt(k);
                k++;
            }
        }
    }

    /**
     * Returns set input as a 6*6 2d char-array. The 4*4 character array is surrounded by empty characters.
     * 
     * @return char[][] grid
     * 
     */
    public char[][] getGrid() {
        return grid;
    }

    /**
     * Returns input.
     * 
     * @return String
     */
    public String getInput() {
        return this.input;
    }

    /**
     * Returns list.
     * 
     * @return Returns ArrayList.
     */
    public ArrayList<String> getList() {
        if (this.input == null) {
            return new ArrayList<>();
        }
        ArrayList<String> list = findPotentialWords();
        ArrayList<String> flist = findWords(list);
        return flist;
    }

    private ArrayList<String> findPotentialWords() {
        ArrayList<String> allWords = ws.returnWords();
        ArrayList<String> potWords = new ArrayList<>();
        for (String word : allWords) {
            ArrayList<Character> usedChars = (ArrayList<Character>) charList.clone();
            boolean works = true;
            for (Character c : word.toCharArray()) {
                if (!usedChars.contains(c)) {
                    works = false;
                }
                usedChars.remove(c);
            }
            if (works) {
                potWords.add(word);
            }
        }
        return potWords;
    }

    private ArrayList<String> findWords(ArrayList<String> ilist) {
        ArrayList<String> words = new ArrayList<>();
        for (String s : ilist) {
            char first = s.charAt(0);
            for (int i = 1; i <= 4; i++) {
                for (int j = 1; j <= 4; j++) {
                    if (grid[i][j] == first) {
                        int[][] map = new int[6][6];
                        int k = 1;
                        findNextLetter(map, s, k, i, j, words);
                    }
                }
            }
        }
        sortList(words);
        return words;
    }

    private void findNextLetter(int[][] map, String s, int k, int x, int y, ArrayList<String> words) {
        if (k == s.length()) {
            if (!words.contains(s)) {
                words.add(s);
            }
            return;
        }

        map[x][y] = 1;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (grid[x + i][y + j] == s.charAt(k) && map[x + i][y + j] != 1) {
                    findNextLetter(map, s, k + 1, x + i, y + j, words);
                }
            }
        }

        map[x][y] = 0;
    }

    private void sortList(ArrayList<String> list) {
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });
    }

}
