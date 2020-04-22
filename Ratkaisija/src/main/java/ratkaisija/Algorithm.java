
package ratkaisija;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Algorithm {
    
    private String input;
    private char[][] grid;
    private ArrayList<Character> charList;
    WordScanner ws;
    
    public Algorithm() {
        ws = new WordScanner();
    }
    
    public boolean checkInputLenght(String userInput) {
        return userInput.length() == 16;
    }
    
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
    
    public char[][] getGrid() {
        return grid;
    }
    
    public String getInput() {
        return this.input;
    }  
    
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
        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });
        return words;
    }
    
    private void findNextLetter(int[][] map, String s, int k, int x, int y, ArrayList<String> words) {
        if (k == s.length()) {
            if (!words.contains(s)) words.add(s);
            return;
        }

        map[x][y] = 1;
        //left up
        if (grid[x-1][y-1] == s.charAt(k) && map[x-1][y-1] != 1) {
            findNextLetter(map, s, k+1, x-1, y-1, words);
        }
        
        //same up
        if (grid[x][y-1] == s.charAt(k) && map[x][y-1] != 1) {
            findNextLetter(map, s, k+1, x, y-1, words);
        }
        
        //right up
        if (grid[x+1][y-1] == s.charAt(k) && map[x+1][y-1] != 1) {
            findNextLetter(map, s, k+1, x+1, y-1, words);
        }
        
        //same left
        if (grid[x-1][y] == s.charAt(k) && map[x-1][y] != 1) {
            findNextLetter(map, s, k+1, x-1, y, words);
        }
        
        //same right
        if (grid[x+1][y] == s.charAt(k) && map[x+1][y] != 1) {
            findNextLetter(map, s, k+1, x+1, y, words);
        }
        
        //down left
        if (grid[x-1][y+1] == s.charAt(k) && map[x-1][y+1] != 1) {
            findNextLetter(map, s, k+1, x-1, y+1, words);
        }
        
        //same down
        if (grid[x][y+1] == s.charAt(k) && map[x][y+1] != 1) {
            findNextLetter(map, s, k+1, x, y+1, words);
        }
        
        //down right
        if (grid[x+1][y+1] == s.charAt(k) && map[x+1][y+1] != 1) {
            findNextLetter(map, s, k+1, x+1, y+1, words);
        }
        
        map[x][y] = 0;
    }
    
    
}
