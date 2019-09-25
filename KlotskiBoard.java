/**
 * Program name:    KlotskiBoard.java
 * Discussion:      Final
 * Written by:      Charles T
 * Due Date:        
 */

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/*
KlotskiBoard sets the klotski blocks up on the board
in their initial positions.
*/

public class KlotskiBoard {           
    Pane pane = new Pane();
    KlotskiButtons buttons = new KlotskiButtons();
    MouseDrag[] mouse = new MouseDrag[10]; 

    RectangleCharlesT[] block;
    RectangleCharlesT[][] board;

    KlotskiBoard() {
        block = new RectangleCharlesT[10];
        board = new RectangleCharlesT[4][5];           
        int j;
  
        Pane p = new Pane();
        p.setPrefSize(400,100);
        p.relocate(0, 500);
        p.setBackground(new Background(new BackgroundFill(
                Color.BISQUE, CornerRadii.EMPTY, Insets.EMPTY)));
        p.getChildren().add(buttons.getHBox());
        buttons.getHBox().relocate(60, 15);
        pane.getChildren().add(p);
        
        //one by one blocks
        block[0] = new RectangleCharlesT(300, 400, 100, 100);
        block[0].getRec().setStroke(Color.BLACK);
        block[0].getRec().setFill(Color.BLUE);     
        pane.getChildren().add(block[0].getRec());
        block[1] = new RectangleCharlesT(100, 300, 100, 100);
        block[1].getRec().setStroke(Color.BLACK);
        block[1].getRec().setFill(Color.BLUE);     
        pane.getChildren().add(block[1].getRec());
        block[2] = new RectangleCharlesT(200, 300, 100, 100);
        block[2].getRec().setStroke(Color.BLACK);
        block[2].getRec().setFill(Color.BLUE);     
        pane.getChildren().add(block[2].getRec());
        block[3] = new RectangleCharlesT(0, 400, 100, 100);
        block[3].getRec().setStroke(Color.BLACK);
        block[3].getRec().setFill(Color.BLUE);     
        pane.getChildren().add(block[3].getRec());
        
        
        //one by two blocks 
        block[4] = new RectangleCharlesT(0, 0, 100, 200);
        block[4].getRec().setStroke(Color.BLACK);
        block[4].getRec().setFill(Color.RED);        
        pane.getChildren().add(block[4].getRec());
        block[5] = new RectangleCharlesT(0, 200, 100, 200);
        block[5].getRec().setStroke(Color.BLACK);
        block[5].getRec().setFill(Color.RED);        
        pane.getChildren().add(block[5].getRec());   
        block[6] = new RectangleCharlesT(300, 0, 100, 200);
        block[6].getRec().setStroke(Color.BLACK);
        block[6].getRec().setFill(Color.RED);        
        pane.getChildren().add(block[6].getRec());
        block[7] = new RectangleCharlesT(300, 200, 100, 200);
        block[7].getRec().setStroke(Color.BLACK);
        block[7].getRec().setFill(Color.RED);        
        pane.getChildren().add(block[7].getRec());
        
        //two by one block 
        block[8] = new RectangleCharlesT(100, 200, 200, 100);
        block[8].getRec().setStroke(Color.BLACK);
        block[8].getRec().setFill(Color.RED);        
        pane.getChildren().add(block[8].getRec());
        
        //two by two block        
        block[9] = new RectangleCharlesT(100, 0, 200, 200);
        block[9].getRec().setStroke(Color.BLACK);
        block[9].getRec().setFill(Color.BLACK);     
        pane.getChildren().add(block[9].getRec());
        
        //initial board positions
        board[0][0] = block[4];
        board[0][1] = block[4];
        board[0][2] = block[5];
        board[0][3] = block[5];
        board[0][4] = block[3];
        board[1][0] = block[9];
        board[1][1] = block[9];
        board[1][2] = block[8];
        board[1][3] = block[1];
        board[1][4] = null;      
        board[2][0] = block[9];
        board[2][1] = block[9];
        board[2][2] = block[8];
        board[2][3] = block[2];
        board[2][4] = null;        
        board[3][0] = block[6];
        board[3][1] = block[6];
        board[3][2] = block[7];
        board[3][3] = block[7];
        board[3][4] = block[0];

        for (j = 9; j >= 0; j--) {
            mouse[j] = new MouseDrag(block, j, board, this);                   
        }     
    }

    public void moveBlock(UndoStackBlockPosition pop) {
        int index = pop.getCurrentBlock();
        int x = pop.getOldX();
        int y = pop.getOldY();
        PointCharlesT p = pop.getOldUpperLeft();
        
        block[index].setUpLeft(p);
        board[x][y] = block[index];
        board[pop.getX()][pop.getY()] = null;
    }
    
    public Pane getPane() {
        return pane;
    }
    
    public KlotskiButtons getButtons() {
        return buttons;
    }
    
    public MouseDrag[] getMouse() {
        return mouse;
    }
    
    public RectangleCharlesT[] getBlock() {
        return block;
    }
    
    public RectangleCharlesT[][] getBoard() {
        return board;
    }
}
