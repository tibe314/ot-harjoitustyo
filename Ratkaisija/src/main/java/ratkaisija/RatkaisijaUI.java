
package ratkaisija;

/**
 *
 * @author tino
 */
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class RatkaisijaUI extends Application {

    @Override
    public void start(Stage view) {
        Algorithm a = new Algorithm();
        
        //starting view
        view.setTitle("Sanajahtiratkaisija");
        BorderPane startingPane = new BorderPane();
        TextField inputText = new TextField("Syötä sanaruudukko (ilman välimerkkejä, esim. abcdefghijklmnop)");
        Button nextViewButton = new Button("Löydä sanat");
        nextViewButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                boolean validInput = a.checkInputLenght(inputText.getText());
                if (validInput) {
                    //TODO: suorita sananetsintäalgoritmi, do blackmagic
                    a.setInput(inputText.getText());
                    System.out.println("TODO");
                }
                else {
                    inputText.setText("Väärä syötteen pituus!");
                }
            }
        });
        startingPane.setCenter(inputText);
        startingPane.setBottom(nextViewButton);
        Scene myscene = new Scene(startingPane, 460, 100);
        view.setScene(myscene);

        view.show();
    }

    @Override
    public void init() throws Exception {
        // ...
    }

    public static void main(String[] args) {
        launch(args);
    }

}
