/**
 * Program name:    Cis36BFinal2017_04_13.java
 * Discussion:      Final
 * Written by:      Charles T
 * Due Date:        
 */

import java.awt.event.ActionListener;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class Cis36BFinal2017_04_13 extends Application implements ActionListener {
    KlotskiBoard pane = new KlotskiBoard();

    @Override
    public void start(Stage primaryStage) {
        startGame(primaryStage);
    }

    public void startGame(Stage stage) {
        UndoStack undoStack = new UndoStack();
        Group root = new Group(pane.getPane());
        Scene scene = new Scene(root, 400, 600, Color.BEIGE);

        Text moves = undoStack.getMoves();
        Pane p = new Pane();
        p.getChildren().add(moves);
        root.getChildren().add(p);
        p.relocate(135, 515);
        
        stage.setOnCloseRequest(e -> System.exit(0));       
        stage.setTitle("Klotski");
        stage.setScene(scene);
        
        stage.setResizable(false);
        stage.show(); 
        
        pane.getButtons().getRestart(). //restarts game
                setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) { 
                stage.close();
                restart();
            }
        });
        
        pane.getButtons().getUndo().setOnMouseClicked(e -> { //controls undo stack pop
            if (undoStack.getStack().size() != 0) {
                UndoStackBlockPosition pop = undoStack.pop();
                pane.moveBlock(pop);  
                
                Text t = undoStack.getMoves();  //handles move number
                p.getChildren().clear();
                p.getChildren().add(t);
            }

            System.out.print("\nUndo Pressed Stack size: " + undoStack.getStack().size());
        });
        
        MouseDrag[] m = pane.getMouse();    //pushes each move onto the stack
        for (int i = 9; i >= 0; i--) {                  
            MouseDrag mouse = m[i];
            
            pane.getMouse()[i].getCurrentBlock().getRec().setOnMouseClicked(e -> {           
                undoStack.push(mouse);
                
                Text t = undoStack.getMoves();  //handles move number
                p.getChildren().clear();
                p.getChildren().add(t);

                System.out.print("\n***STACK****");
                for (int j = 0; j < undoStack.getStack().size(); j++) {
                    System.out.print("\nBlock" + 
                            undoStack.getStack().get(j).getCurrentBlock() + 
                            "  (" + undoStack.getStack().get(j).getX() +
                            ", " + undoStack.getStack().get(j).getY() + ")" +
                            "\nOld Position (" + undoStack.getStack().get(j).getOldX() +
                            ", " + undoStack.getStack().get(j).getOldY() + ")");                  
                }
                System.out.print("\n************"); 
            });
        }      
    }
    
    public void restart() {
        Stage stage = new Stage();
        pane = new KlotskiBoard();
        startGame(stage);
    }    

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {        //menu based on button pressed
        int action = Integer.parseInt(e.getActionCommand()); 
        
        switch (action) {
            case 1:
                Application.launch();
                break;
            case 2:
                
                break;  
            case 3:
                
                break;
            default:
                System.out.print("\nInvalid option!!!");
        }
    }   

    public static void main(String[] args) {
        StartGUI start = new StartGUI();
    }
}