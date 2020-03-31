
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
        BorderPane first = new BorderPane();
        TextField text = new TextField("Syötä sanaruudukko (ilman välimerkkejä, esim. abcdefghijklmnop)");
        Button nextview = new Button("Löydä sanat");
        nextview.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                a.setInput(text.getText());
                if (a.checkInputLenght()) {
                    //TODO: suorita sananetsintäalgoritmi, do blackmagic
                    System.out.println("TODO");
                }
                else {
                    text.setText("Väärä syötteen pituus!");
                }
            }
        });
        first.setCenter(text);
        first.setBottom(nextview);
        Scene myscene = new Scene(first, 460, 100);
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
