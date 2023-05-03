package com.partials;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JRadioButton;

/**
 *
 * @author HP
 */
public class cRadioButton extends JRadioButton{
    
    public cRadioButton(String text, String value, int x, int y, int width){
        super();
        setBounds(x, y, width, 20);
        setFont(new Font("Poppins Light", Font.PLAIN, 25));
        setForeground(new Color(69, 69, 69));
        setBackground(new Color(229, 178, 153));
        setFocusable(false);
        setVerticalAlignment(JRadioButton.CENTER);
        setActionCommand(value);
        setText(text);
  }
    
}
