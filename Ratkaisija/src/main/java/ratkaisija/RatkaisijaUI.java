/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        view.setTitle("Sanajahtiratkaisija");
        BorderPane first = new BorderPane();
        TextField text = new TextField("Syötä sanaruudukko (ilman välimerkkejä, esim. abcdefghijklmnop)");
        Button nextview = new Button("Löydä sanat");
        nextview.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (text.getText().length() == 16) {
                    //TODO: lähetä .getText() algoritmille, ja siirry seuraavaan näkymään
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
