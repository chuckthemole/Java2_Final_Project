/**
 * Program name:    ColorIcon.java
 * Discussion:      Final
 * Written by:      Charles T
 * Due Date:        2017/??/??
 */

/*
ColorIcon sets icons
*/

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import javax.swing.Icon;


class StartColorIcon implements Icon {
    Color color;
    
    public StartColorIcon(Color c) {
        color = c;
    }
    
    public int getIconWidth() {
        return 20;
    }
    
    public int getIconHeight() {
        return 20;
    }
    
    public void paintIcon(Component c, Graphics g, int x, int y) {
        g.setColor(color);
        g.fillArc(x, y, getIconWidth(), getIconHeight(), 45, 270);
    }
}