package com.partials;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

/**
 *
 * @author HP
 */
public class cLabelInfo extends JLabel{
    
    public cLabelInfo(String text){
        super();
        setText(text);
        setBounds(0,0, 274, 41);
        setHorizontalAlignment(JLabel.CENTER);
        setVerticalAlignment(JLabel.CENTER);
        setFont(new Font("Helvetica", Font.PLAIN, 30));
        setForeground(Color.WHITE);
//        setForeground(new Color(241, 246, 249));
        setForeground(new Color(230, 230, 230));
        
    }
    
    
}
