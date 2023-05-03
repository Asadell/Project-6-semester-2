/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.partials;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

/**
 *
 * @author HP
 */
public class cBigFont extends JLabel{
    
    public cBigFont(String text){
        super();
        setText(text);
        setBounds(0, 38, 274, 75);
        setHorizontalAlignment(JLabel.CENTER);
        setVerticalAlignment(JLabel.CENTER);
        setFont(new Font("Poppins Light", Font.PLAIN, 64));
//        setForeground(new Color(255, 243, 226));
//        setForeground(new Color(249, 217, 73));
//        setForeground(new Color(241, 246, 249));
//        setForeground(new Color (246, 255, 222));
//        setForeground(new Color (238, 130, 238));
        setForeground(Color.WHITE);
        
    }
    
}
