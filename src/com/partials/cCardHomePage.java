package com.partials;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author HP
 */
public class cCardHomePage extends JPanel{
    
    public cCardHomePage(int x, int y){
        super(); // to call default constructor from super class (extend)
        
        setBounds(x, y, 274, 130);
        setBackground(new Color(180, 132, 108));
        setLayout(null);
        
    }
    
}
