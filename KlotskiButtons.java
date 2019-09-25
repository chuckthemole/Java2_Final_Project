/**
 * Program name:    KlotskiButtons.java
 * Discussion:      Final
 * Written by:      Charles T
 * Due Date:        
 */

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

/*
Buttons placed in the pane while playing the game
*/

public class KlotskiButtons {
    HBox hbox = new HBox();
    Button restart = new Button("Restart"); //create butons
    Button solve = new Button("Solve");
    Button quit = new Button("Quit"); 
    Button undo = new Button("Undo");

    KlotskiButtons() {     
        quit.setOnAction(new EventHandler<ActionEvent>() {  //handle button events
            @Override
            public void handle(ActionEvent event) {
                Platform.exit();
                System.exit(0);
            }
        });
        
        solve.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            }
        });
        
        hbox.setSpacing(10);
        hbox.setPadding(new Insets(0, 20, 10, 20));
        hbox.getChildren().addAll(restart, solve, quit, undo);
        
        hbox.setStyle("-fx-padding: 10;" + 
                      "-fx-border-style: solid inside;" + 
                      "-fx-border-width: 2;" +
                      "-fx-border-insets: 5;" + 
                      "-fx-border-radius: 5;" + 
                      "-fx-border-color: blue;");
       
        hbox.setLayoutX(50);
        hbox.setLayoutY(550);
    }
    
    public HBox getHBox() {
        return hbox;
    }
    
    public Button getRestart() {
        return restart;
    }
    
    public Button getUndo() {
        return undo;
    }
}
