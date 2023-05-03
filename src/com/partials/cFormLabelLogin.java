package com.partials;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

/**
 *
 * @author HP
 */
public class cFormLabelLogin extends JLabel{
    
    public cFormLabelLogin(String text, int x, int y, int width, boolean centerAlignment){
        
        super();
        setText(text); // to call default constructor from super class (extend)
        setBounds(x, y, width, 28);
        if(centerAlignment){
          setHorizontalAlignment(JLabel.CENTER);
        }
        setVerticalAlignment(JLabel.CENTER);
        setFont(new Font(new Font("Poppins Medium", Font.BOLD, 24)) {
        });
        setForeground(Color.BLACK);
        
    }
    
}
