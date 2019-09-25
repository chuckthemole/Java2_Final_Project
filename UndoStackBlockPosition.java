/**
 * Program name:    UndoStackBlockPosition.java
 * Discussion:      Final
 * Written by:      Charles T
 * Due Date:        2017/??/??
 */

/*
This class works in unison with UndoStack to keep track
of block positions, old and new.
*/

public class UndoStackBlockPosition {
    final private int newX;
    final private int newY;
    final private int oldX;
    final private int oldY;
    final private PointCharlesT newUpperLeft;
    final private PointCharlesT oldUpperLeft;
    final private int currentBlock;
    
    UndoStackBlockPosition(MouseDrag item) {
        newUpperLeft = item.getCurrentBlock().getUpLeft();
        newX = item.getNewX();
        newY = item.getNewY(); 
        currentBlock = item.getCurrentBlockIndex();
        oldX = item.getOldX();
        oldY = item.getOldY();
        oldUpperLeft = item.getOldUpperLeft();
    }
    
    public int getX() {
        return newX;
    }
    
    public int getY() {
        return newY;
    }
    
    public PointCharlesT getUpperLeft() {
        return newUpperLeft;
    }
    
    public int getCurrentBlock() {
        return currentBlock;
    }
    
    public int getOldX() {
        return oldX;
    }
    
    public int getOldY() {
        return oldY;
    }
    
    public PointCharlesT getOldUpperLeft() {
        return oldUpperLeft;
    }
}
