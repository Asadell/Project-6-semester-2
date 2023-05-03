/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.partials;

import java.awt.Color;
import javax.swing.JScrollPane;

/**
 *
 * @author HP
 */
public class cScrollPane extends JScrollPane{
    
    public cScrollPane(java.awt.Component view, int x, int y, int width, int height){
        super(view);
        setBounds(x, y, width, height);
        getViewport().setBackground(new Color(252, 222, 192));
        setBorder(new javax.swing.border.LineBorder(new Color(180, 132, 108), 1));
    }
    
}
