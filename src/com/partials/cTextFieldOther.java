package com.partials;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;

/**
 *
 * @author HP
 */
public class cTextFieldOther extends JTextField{
    
    public cTextFieldOther(int x, int y, int width, boolean centerAlignment){
        
        super(); // to call default constructor from super class (extend)
        setBounds(x, y, width, 35);
        if(centerAlignment){
          setHorizontalAlignment(JTextField.CENTER);
        }
        setFont(new Font("Poppins Regular", Font.PLAIN, 20));
        setBackground(new Color(229, 178, 153));
        setForeground(Color.BLACK);
        setBorder(new javax.swing.border.LineBorder(new Color(180, 132, 108), 2));

    }
    
}
