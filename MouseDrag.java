/**
 * Program name:    MouseDrag.java
 * Discussion:      Final
 * Written by:      Charles T
 * Due Date:        
 */

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/*
MouseDrag handles each block's mouse event. 
*/

public class MouseDrag implements MouseMotionListener {
    private RectangleCharlesT[] blocks;
    private int index;
    
    private int oldX, oldY;
    private int newX, newY;
    private PointCharlesT oldPoint;
    private PointCharlesT newPoint;
    private RectangleCharlesT currentBlock;
    private int currentBlockIndex;
    private RectangleCharlesT[][] b;

    MouseDrag(RectangleCharlesT[] block, int i,
            RectangleCharlesT[][] board, KlotskiBoard klotskiBoard) {
        currentBlock = block[i];
        currentBlockIndex = i;
        
        newX = currentBlock.getUpLeft().getX().getNum() / 100;
        newY = currentBlock.getUpLeft().getY().getNum() / 100;

        currentBlock.getRec().setOnMousePressed(e -> {
            oldX = block[i].getUpLeft().getX().getNum() / 100;
            oldY = block[i].getUpLeft().getY().getNum() / 100;
            oldPoint = new PointCharlesT(oldX * 100, oldY * 100); 
        });

        currentBlock.getRec().setOnMouseDragged(e -> {           
            double x, y;          

            b = board;          

            x = e.getX();
            y = e.getY();
            
            if (x >= 0 && x < 100) 
                newX = 0;
            else if (x >= 100 && x < 200) 
                newX = 1;
            else if (x >= 200 && x < 300) 
                newX = 2;
            else if (x >= 300 && x < 400 && i != 8 && i != 9) 
                newX = 3;
            else
                newX = oldX;
            
            if (y >= 0 && y < 100) 
                newY = 0;
            else if (y >= 100 && y < 200) 
                newY = 1;
            else if (y >= 200 && y < 300) 
                newY = 2;
            else if (y >= 300 && y < 400) 
                newY = 3;
            else if (y >= 400 && y < 500 && i != 4 &&
                    i != 5 && i != 6 && i != 7 && i != 9) 
                newY = 4;
            else
                newY = oldY;
            
            if (newX == oldX && newY == oldY) 
                System.out.print("\nNo movement");
            else {
            if (i == 0 || i == 1 || i == 2 || i == 3) {
                if (board[newX][newY] == null) {

                    if (oldX - newX < 0) {//checkSkippedBlocks function//maybe make class variables
                        if (board[oldX + 1][oldY] != null) {
                            newX = oldX;
                            newY = oldY;
                        }
                    }
                    else if (oldX - newX > 0) {
                        if (board[oldX - 1][oldY] != null) {
                            newX = oldX;
                            newY = oldY;
                        }
                    }
                    else if (oldY - newY < 0) {
                        if (board[oldX][oldY + 1] != null) {
                            newX = oldX;
                            newY = oldY;
                        }
                    }
                    else {
                        if (board[oldX][oldY - 1] != null) {
                            newX = oldX;
                            newY = oldY;
                        }
                    }
                    
                    board[oldX][oldY] = null;
                    board[newX][newY] = block[i];
                    newPoint = new PointCharlesT(newX * 100, newY * 100);
                    currentBlock.setUpLeft(newPoint); 
                }
            }
            else if (i == 4 || i == 5 || i == 6 || i == 7) {
                if ((board[newX][newY] == null || 
                        board[newX][newY] == board[oldX][oldY + 1]) &&
                        (board[newX][newY + 1] == null || 
                        board[newX][newY + 1] == board[oldX][oldY])) {

                    if (oldX - newX < 0) {//checkSkippedBlocks function//maybe make class variables
                        if (board[oldX + 1][oldY] != null) {
                            newX = oldX;
                            newY = oldY;
                        }
                    }
                    else if (oldX - newX > 0) {
                        if (board[oldX - 1][oldY] != null) {
                            newX = oldX;
                            newY = oldY;
                        }
                    }
                    else if (oldY - newY < 0) {
                        if (board[oldX][oldY + 2] != null) {
                            newX = oldX;
                            newY = oldY;
                        }
                    }
                    else {
                        if (board[oldX][oldY - 1] != null) {
                            newX = oldX;
                            newY = oldY;
                        }
                    }

                    if (newX != oldX) {
                        board[oldX][oldY] = null;
                        board[oldX][oldY + 1] = null;
                        board[newX][newY] = block[i];
                        board[newX][newY + 1] = block[i];
                        newPoint = new PointCharlesT(newX * 100, newY * 100);
                        currentBlock.setUpLeft(newPoint);
                    }
                    else if (newY > oldY) {
                        board[oldX][oldY] = null;
                        board[newX][newY + 1] = block[i];
                        newPoint = new PointCharlesT(newX * 100, newY * 100);
                        currentBlock.setUpLeft(newPoint);
                    }
                    else if (newY < oldY) {
                        board[oldX][oldY + 1] = null;
                        board[newX][newY] = block[i];
                        newPoint = new PointCharlesT(newX * 100, newY * 100);
                        currentBlock.setUpLeft(newPoint);
                    }
                    else {
                        newPoint = new PointCharlesT(newX * 100, newY * 100);
                        currentBlock.setUpLeft(newPoint);
                    }
                }
            }
            else if (i == 8) {
                if ((board[newX][newY] == null || 
                        board[newX][newY] == board[oldX + 1][oldY]) &&
                        (board[newX + 1][newY] == null || 
                        board[newX + 1][newY] == board[oldX][oldY])) {
                    
                    if (oldX - newX < 0) {//checkSkippedBlocks function//maybe make class variables
                        if (board[oldX + 2][oldY] != null) {
                            newX = oldX;
                            newY = oldY;
                        }
                    }
                    else if (oldX - newX > 0) {
                        if (board[oldX - 1][oldY] != null) {
                            newX = oldX;
                            newY = oldY;
                        }
                    }
                    else if (oldY - newY < 0) {
                        if (board[oldX][oldY + 1] != null) {
                            newX = oldX;
                            newY = oldY;
                        }
                    }
                    else {
                        if (board[oldX][oldY - 1] != null) {
                            newX = oldX;
                            newY = oldY;
                        }
                    }
                    
                    if (newY != oldY) {
                        board[oldX][oldY] = null;
                        board[oldX + 1][oldY] = null;
                        board[newX][newY] = block[i];
                        board[newX + 1][newY] = block[i];
                        newPoint = new PointCharlesT(newX * 100, newY * 100);
                        currentBlock.setUpLeft(newPoint);
                    }
                    else if (newX > oldX) {
                        board[oldX][oldY] = null;
                        board[newX + 1][newY] = block[i];
                        newPoint = new PointCharlesT(newX * 100, newY * 100);
                        currentBlock.setUpLeft(newPoint);
                    }
                    else if (newX < oldX) {
                        board[oldX + 1][oldY] = null;
                        board[newX][newY] = block[i];
                        newPoint = new PointCharlesT(newX * 100, newY * 100);
                        currentBlock.setUpLeft(newPoint);
                    }
                    else {
                        newPoint = new PointCharlesT(newX * 100, newY * 100);
                        currentBlock.setUpLeft(newPoint);
                    }
                }
            }
            else {
                if ((board[newX][newY] == null || 
                        board[newX][newY] == board[oldX + 1][oldY] ||
                        board[newX][newY] == board[oldX][oldY + 1]) &&
                        (board[newX + 1][newY] == null || 
                        board[newX + 1][newY] == board[oldX][oldY] ||
                        board[newX + 1][newY] == board[oldX + 1][oldY + 1]) &&
                        (board[newX][newY + 1] == null ||
                        board[newX][newY + 1] == board[oldX][oldY] ||
                        board[newX][newY + 1] == board[oldX + 1][oldY + 1]) &&
                        (board[newX + 1][newY + 1] == null ||
                        board[newX + 1][newY + 1] == board[oldX][oldY + 1] ||
                        board[newX + 1][newY + 1] == board[oldX + 1][oldY])) {
                    if (board[newX][newY] == null && 
                            board[newX][newY + 1] == null &&
                            newX + 1 == oldX && oldY == newY) {
                        board[oldX + 1][oldY] = null;
                        board[oldX + 1][oldY + 1] = null;
                        board[newX][newY] = block[i];
                        board[newX][newY + 1] = block[i];
                        newPoint = new PointCharlesT(newX * 100, newY * 100);
                        currentBlock.setUpLeft(newPoint);
                    }
                    else if (board[newX][newY] == block[i] &&
                            board[newX][newY + 1] == block[i] &&
                            newX == oldX + 1 && oldY == newY) {
                        board[oldX][oldY] = null;
                        board[oldX][oldY + 1] = null;
                        board[newX + 1][newY] = block[i];
                        board[newX + 1][newY + 1] = block[i];
                        newPoint = new PointCharlesT(newX * 100, newY * 100);
                        currentBlock.setUpLeft(newPoint);
                    }
                    else if (board[newX][newY] == block[i] &&
                            board[newX + 1][newY] == block[i] &&
                            newX == oldX && newY == oldY + 1) {
                        board[oldX][oldY] = null;
                        board[oldX + 1][oldY] = null;
                        board[newX][newY + 1] = block[i];
                        board[newX + 1][newY + 1] = block[i];
                        newPoint = new PointCharlesT(newX * 100, newY * 100);
                        currentBlock.setUpLeft(newPoint);
                    }          
                    else if (board[newX][newY] == null &&
                            board[newX + 1][newY] == null &&
                            newX == oldX && newY == oldY - 1) {
                        board[oldX][oldY + 1] = null;
                        board[oldX + 1][oldY + 1] = null;
                        board[newX][newY] = block[i];
                        board[newX + 1][newY] = block[i];
                        newPoint = new PointCharlesT(newX * 100, newY * 100);
                        currentBlock.setUpLeft(newPoint);
                    }
                    else {
                        newPoint = new PointCharlesT(newX * 100, newY * 100);
                        currentBlock.setUpLeft(newPoint);
                    }
                }
            }
            }
        });     
    }
 
    public RectangleCharlesT getCurrentBlock() {
        return currentBlock;
    }
    
    public int getCurrentBlockIndex() {
        return currentBlockIndex;
    }
    
    public int getOldX() {
        return oldX;
    }
    
    public int getOldY() {
        return oldY;
    }
    
    public int getNewX() {
        return newX;
    }
    
    public int getNewY() {
        return newY;
    }
    
    public PointCharlesT getOldUpperLeft() {
        return oldPoint;
    }
    
    public PointCharlesT getNewUpperLeft() {
        return oldPoint;
    }
    
    public RectangleCharlesT[][] getBoard() {
        return b;
    }
    
    public void setCurrentBlockPosition(PointCharlesT p) {
        currentBlock.setUpLeft(p);
    }
    
    public void setOldX(int x) {
        oldX = x;
    }
    
    public void setOldY(int y) {
        oldY = y;
    }
    
    public void setNewX(int x) {
        newX = x;
    }
    
    public void setNewY(int y) {
        newY = y;
    }
    
    public void setOldUpperLeft(PointCharlesT p) {
        oldPoint = p;
    }
    
    public void setNewUpperLeft(PointCharlesT p) {
        newPoint = p;
    }
    
    public void setBoard(RectangleCharlesT[][] board) {
        b = board;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}