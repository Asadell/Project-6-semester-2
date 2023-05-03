package com.partials;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;

/**
 *
 * @author HP
 */
public class cComboBoxSearch extends JComboBox<String>{
    
    // attribute
//    String options [] = {"Book Name", "Customer Name", "Status"};
    
    public cComboBoxSearch(int x, int y, String[] options){
        super();
        for(var value : options){
            addItem(value);
        }
        setBounds(x, y, 232, 35);
        setForeground(new Color(69, 69, 69));
        setBackground(new Color(229, 178, 153));
        setBorder(BorderFactory.createLineBorder(new Color(180, 132, 108)));
        setFont(new Font("Arial", Font.PLAIN, 25));
    }
    
}
