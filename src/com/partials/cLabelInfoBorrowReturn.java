package com.partials;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

/**
 *
 * @author HP
 */
public class cLabelInfoBorrowReturn extends JLabel{
    
    public cLabelInfoBorrowReturn(String text, int x, int y){
        super();
        setText(text);
        setBounds(x,y, 200, 32);
//        setHorizontalAlignment(JLabel.CENTER);
        setVerticalAlignment(JLabel.CENTER);
        setFont(new Font("Helvetica", Font.PLAIN, 24));
        setForeground(Color.BLACK);
//        setForeground(new Color(241, 246, 249));
        setBackground(new Color(229, 178, 153));
        
    }
    
}
