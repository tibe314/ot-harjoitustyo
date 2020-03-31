
package ratkaisija;

/**
 *
 * @author tino
 */
public class Algorithm {
    
    private String input;
    
    public void setInput(String s) {
        this.input = s;
    }
    
    public boolean checkInputLenght() {
        return input.length() == 16;
    }
    
}
