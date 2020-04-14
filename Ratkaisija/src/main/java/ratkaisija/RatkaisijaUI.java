
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class RatkaisijaUI extends Application {

    @Override
    public void start(Stage view) {
        Algorithm a = new Algorithm();
        DatabaseHandler dbh = new DatabaseHandler();
        
        //1. starting view
        //1.1 make elements
        view.setTitle("Sanajahtiratkaisija");
        TextField inputText = new TextField("Syötä sanaruudukko (ilman välimerkkejä, esim. abcdefghijklmnop)");
        Button nextViewButton = new Button("Löydä sanat");
        Button dataBaseEdit = new Button("Muokkaa tietokantaa");
        
        //1.2 make pane and add elements
        BorderPane startingPane = new BorderPane();
        
        startingPane.setTop(inputText);
        startingPane.setLeft(nextViewButton);
        startingPane.setRight(dataBaseEdit);
        
        //1.3 make the scene
        Scene startingScene = new Scene(startingPane, 460, 100);
        
        
        //2. database edit view
        //2.1 make elements
        TextField dbInputField = new TextField();
        Label message = new Label("Syötä sana jonka haluat poistaa tai lisätä tietokantaan");
        Button addButton = new Button("Lisää sana");
        Button delButton = new Button("Poista sana");
        Button resetButton = new Button("Palauta tietokanta");
        
        //2.2 make pane and add elements
        BorderPane dbEditPane = new BorderPane();
        
        dbEditPane.setTop(message);
        dbEditPane.setLeft(addButton);
        dbEditPane.setCenter(delButton);
        dbEditPane.setRight(resetButton);
        dbEditPane.setBottom(dbInputField);
        
        //2.3 make the scene
        Scene dbEditScene = new Scene(dbEditPane, 460, 100);
        
        
        //3. buttons
        //3.1 starting view buttons
        //3.1.1 nextview button
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
        
        //3.1.2 dataBaseEdit button
        dataBaseEdit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                view.setScene(dbEditScene);
            }
        });
        
        //3.2 Database edit view buttons
        //3.2.1 addButton
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (dbh.addWord(dbInputField.getText())) {
                    message.setText("Sana '" + dbInputField.getText() + "' lisätty onnistuneesti :D");
                } else {
                    message.setText("Sana '" + dbInputField.getText() + "' löytyy jo tietokannasta!");
                }
            }
        });
        
        //3.2.2 delButton
        delButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (dbh.delWord(dbInputField.getText())) {
                    message.setText("Sana '" + dbInputField.getText() + "' poistettu onnistuneesti");
                } else {
                    message.setText("Sanaa '" + dbInputField.getText() + "' ei löydy tietokannasta :thonk:");
                }
            }
        });
        
        //3.2.3 resetButton
        resetButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (dbh.resetDB()) {
                    message.setText("Tietokanta palautettu onnistuneesti");
                } else {
                    message.setText("Jotain meni pieleen");
                }
            }
        });

        //4. set the starting scene
        view.setScene(startingScene);
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
