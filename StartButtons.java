/**
 * Program name:    StartButtons.java
 * Discussion:      Final
 * Written by:      Charles T
 * Due Date:        2017/??/??
 */

/*
StartButtons Class creates buttons
*/

/*
These buttons are added to the start menu GUI
*/

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class StartButtons {
    JButton start;
    JButton solve;
    JButton quit;
    
    JPanel buttonPanel;

    public StartButtons() {
        Cis36BFinal2017_04_13 actionEvent;
        Icon icon = new StartColorIcon(Color.red);
        start = new JButton("Start Playing", icon);
        start.setFont(new Font("Serif", Font.PLAIN, 60));
        solve = new JButton("Solve Puzzle", icon);
        solve.setFont(new Font("Serif", Font.PLAIN, 60));
        quit = new JButton("Quit Game", icon);
        quit.setFont(new Font("Serif", Font.PLAIN, 60));
        
        buttonPanel = new JPanel();
        buttonPanel.setVisible(true);    
        buttonPanel.add(start);   //, BorderLayout.WEST);
        buttonPanel.add(solve);
        buttonPanel.add(quit);

        buttonPanel.setPreferredSize(new Dimension(0, 100));
        
        actionEvent = new Cis36BFinal2017_04_13();
        start.addActionListener(actionEvent);
        solve.addActionListener(actionEvent);
        quit.addActionListener(actionEvent);       
        start.setActionCommand("1");
        solve.setActionCommand("2");
        quit.setActionCommand("3");
    }

    public JButton getStart() {
        return start;
    }
    
    public JButton getSolve() {
        return solve;
    }
    
    public JButton getQuit() {
        return quit;
    }
    
    public JPanel getButtonPanel() {
        return buttonPanel;
    }
}
