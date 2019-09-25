/**
 * Program name:    Cis36BFall2017CharlesTAssignment11StartMenu.java
 * Discussion:      Final
 * Written by:      Charles T
 * Due Date:        2017/??/??
 */

import java.awt.BorderLayout;
import javax.swing.JFrame;

/*
This GUI appears at the start of the game
*/

public class StartGUI {
    StartGUI() {
        JFrame frame = new JFrame("Klotski Start Menu");
        StartButtons butns = new StartButtons();
        StartMenuText text = new StartMenuText();
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.add(butns.getButtonPanel(), BorderLayout.SOUTH, 0);     
        frame.add(text.getTitle()[0], BorderLayout.WEST, 0);

        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(1300, 400);
        frame.setLocationRelativeTo(null);
        
        butns.getStart().addActionListener(e-> {
           frame.setVisible(false);
        });
        
        butns.getSolve().addActionListener(e-> {
           frame.setVisible(false);
        });
        
        butns.getQuit().addActionListener(e -> System.exit(0));
    }
}
