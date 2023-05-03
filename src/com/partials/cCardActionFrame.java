package com.partials;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author HP
 */
public class cCardActionFrame extends JPanel{
    
    public cCardActionFrame(int x, int y){
        super(); // to call default constructor from super class (extend)
        
        setBounds(x, y, 382, 420);
        setBackground(new Color(229, 178, 153));
        setLayout(null);
        
    }
    
}
