/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.partials;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JPasswordField;


public class cPasswordField extends JPasswordField{
    
    public cPasswordField(int x, int y, int width, boolean centerAlignment){
        
    super(); // to call default constructor from super class (extend)
    setBounds(x, y, width, 35);
    if(centerAlignment){
      setHorizontalAlignment(JPasswordField.CENTER);
    }
    setFont(new Font("Poppins Regular", Font.PLAIN, 20));
    setBackground(new Color(252, 222, 192));
    setForeground(Color.BLACK);
    setBorder(new javax.swing.border.LineBorder(new Color(180, 132, 108), 2));

    }
    
}
