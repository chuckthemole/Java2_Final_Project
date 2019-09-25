/**
 * Program name:    StartMenuText.java
 * Discussion:      Final
 * Written by:      Charles T
 * Due Date:        2017/??/??
 */

/*
StartmenuText Class creates JLabels
*/

import java.awt.Font;
import javax.swing.JLabel;

public class StartMenuText {
    JLabel[] title = new JLabel[3];
    
    StartMenuText() {       
        title[0] = new JLabel("KLOTSKI");
        title[0].setFont(new Font("Serif", Font.PLAIN, 100));
    }
    
    public JLabel[] getTitle() {
        return title;
    }
}
