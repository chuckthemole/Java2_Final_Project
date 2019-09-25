/**
 * Program name:    UndoStack.java
 * Discussion:      Final
 * Written by:      Charles T
 * Due Date:        2017/??/??
 */

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.EmptyStackException;
import javafx.scene.text.Text;

/*
Class that handles the stack as each block is moved, creating
a push, and each time the undo button is pressed, creating a pop.
*/

class UndoStack extends ArrayList<UndoStackBlockPosition> implements MouseListener {
    private ArrayList<UndoStackBlockPosition> stack;
    private int moveNumber; 
    private Text moves;

    public UndoStack() {
        stack = new ArrayList<>();
        moveNumber = stack.size(); 
        moves = new Text("Number of moves: " + moveNumber);
    }

    public void push(MouseDrag item) {
        UndoStackBlockPosition blockPosition = 
                new UndoStackBlockPosition(item);
        System.out.print("\nStack size before: " + stack.size());
        
        stack.add(blockPosition);

        if (stack.get(stack.size() - 1).getOldUpperLeft().getX() == 
                stack.get(stack.size() - 1).getUpperLeft().getX() &&
                stack.get(stack.size() - 1).getOldUpperLeft().getY() ==
                stack.get(stack.size() - 1).getUpperLeft().getY())
            stack.remove(stack.size() - 1);
        
        moveNumber = stack.size();
        moves = new Text("Number of moves: " + moveNumber);
        
        System.out.print("\nStack size after: " + stack.size() +
                "\nMove number: " + moveNumber);
    }

    public UndoStackBlockPosition pop() {
        UndoStackBlockPosition top = peek();
        stack.remove(stack.size() - 1);
 
        moveNumber = stack.size();
        moves = new Text("Number of moves: " + moveNumber);
        
        return top;
    }

    public UndoStackBlockPosition peek() {
        if (stack.size() == 0) {
            throw new EmptyStackException();
        }
        
        return stack.get(stack.size() - 1);
    }

    public boolean empty() {
        return stack.size() == 0;
    }

    public int search(UndoStackBlockPosition o) {
        int i = lastIndexOf(o);
        if (i >= 0) {
            return size() - i;
        }
        
        return -1;
    }
    
    public ArrayList<UndoStackBlockPosition> getStack() {
        return stack;
    }
    
    public Text getMoves() {
        return moves;
    }
    
    public int getMoveNumber() {
        return moveNumber;
    }
    
    public void setMoveNumber(int n) {
        moveNumber = n;
    }

    public void setMoves(String s) {
        moves  = new Text(s);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.print("\nmouseClicked");
        moveNumber = stack.size();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.print("\nmousePressed");
        moveNumber = stack.size();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.print("\nmouseReleased");
        moveNumber = stack.size();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.print("\nmouseEntered");
        moveNumber = stack.size();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        moveNumber = stack.size();
    }
}