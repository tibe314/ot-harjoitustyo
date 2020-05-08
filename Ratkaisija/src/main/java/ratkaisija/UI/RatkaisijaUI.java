package ratkaisija.UI;

/**
 *
 * @author tino
 */
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import javafx.scene.text.Font;
import ratkaisija.solver.Algorithm;
import ratkaisija.solver.Algorithm;
import ratkaisija.datahandling.DatabaseHandler;
import ratkaisija.datahandling.DatabaseHandler;

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
        Button backButton = new Button("Takaisin");
        Button backButton2 = new Button("Takaisin");

        //2.2 make pane and add elements
        BorderPane dbEditPane = new BorderPane();
        HBox pane2 = new HBox();

        dbEditPane.setBottom(pane2);
        pane2.setAlignment(Pos.CENTER);

        dbEditPane.setTop(message);
        dbEditPane.setCenter(dbInputField);

        pane2.getChildren().add(addButton);
        pane2.getChildren().add(delButton);
        pane2.getChildren().add(resetButton);
        pane2.getChildren().add(backButton);

        //2.3 make the scene
        Scene dbEditScene = new Scene(dbEditPane, 460, 100);

        //3. Make solver screen
        BorderPane solverPane = new BorderPane();
        GridPane charGrid = new GridPane();
        solverPane.setLeft(charGrid);

        //3.1 setup the grid
        charGrid.setHgap(20);
        charGrid.setVgap(20);
        charGrid.setPadding(new Insets(10, 75, 10, 10));
        //see 4.1.1

        //3.2 make and add elements
        solverPane.setBottom(backButton2);

        //3.3 make the scene
        Scene solverScene = new Scene(solverPane, 460, 600);

        //4. buttons
        //4.1 starting view buttons
        //4.1.1 nextview button
        nextViewButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                boolean validInput = a.checkInputLength(inputText.getText());
                if (validInput) {
                    //TODO: suorita sananetsintäalgoritmi, do blackmagic
                    a.setInput(inputText.getText());
                    char[][] grid = a.getGrid();

                    //drawing the charGrid
                    charGrid.getChildren().clear();
                    for (int i = 1; i <= 4; i++) {
                        for (int j = 1; j <= 4; j++) {
                            Label character = new Label(String.valueOf(grid[i][j]));
                            character.setFont(new Font("Arial", 40));
                            charGrid.add(character, j, i);
                        }
                    }

                    ObservableList<String> words = FXCollections.observableArrayList(a.getList());
                    ListView<String> list = new ListView<>(words);

                    solverPane.setCenter(list);

                    view.setScene(solverScene);
                } else {
                    inputText.setText("Väärä syötteen pituus!");
                }
            }
        });

        //4.1.2 dataBaseEdit button
        dataBaseEdit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                view.setScene(dbEditScene);
            }
        });

        //4.2 Database edit view buttons
        //4.2.1 addButton
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

        //4.2.2 delButton
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

        //4.2.3 resetButton
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

        //4.2.4 backButton
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                view.setScene(startingScene);
            }
        });
        
        //4.2.4 backButton2
        backButton2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                view.setScene(startingScene);
            }
        });

        //5. set the starting scene
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
