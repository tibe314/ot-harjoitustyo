
package ratkaisija;

/**
 *
 * @author tino
 */
public class Algorithm {
    
    private String input;
    
    public Algorithm() {
        //WordScanner myWS = new WordScanner();
    }
    
    public boolean checkInputLenght(String userInput) {
        return userInput.length() == 16;
    }
    
    public void setInput(String s) {
        this.input = s;
    }
    
    public String getInput() {
        return this.input;
    }  
    
}
