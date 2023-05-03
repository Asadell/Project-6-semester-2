package com.partials;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;

/**
 *
 * @author HP
 */
public class cComboBoxCustomer extends JComboBox{
    
    public cComboBoxCustomer(int x, int y, String[] options){
        super();
        for(var value : options){
            addItem(value);
        }
        setBounds(x, y, 334, 33);
        setFont(new Font("Poppins Regular", Font.PLAIN, 20));
        setBackground(new Color(229, 178, 153));
        setForeground(Color.BLACK);
        setBorder(new javax.swing.border.LineBorder(new Color(180, 132, 108), 2));
    }
    
}
