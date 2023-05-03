package com.partials;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

/**
 *
 * @author HP
 */
public class cLabelTitleBorrowReturn extends JLabel{
    
    public cLabelTitleBorrowReturn(String text, int x, int y){
        super();
        setText(text);
        setBounds(x,y, 150, 32);
//        setHorizontalAlignment(JLabel.CENTER);
        setVerticalAlignment(JLabel.CENTER);
        setFont(new Font("Helvetica", Font.PLAIN, 24));
//        setForeground(Color.WHITE);
//        setForeground(new Color(241, 246, 249));
        setForeground(new Color(241, 246, 249));
        setBackground(new Color(229, 178, 153));
        
    }
    
}
