/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.partials;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.MouseEvent;
import java.awt.Cursor;

/**
 *
 * @author HP
 */
public class cLinkStart extends JLabel{
    
    public cLinkStart(String text, int y){
        
    super(); // to call default constructor from super class (extend)
    setText(text);
    setBounds(0, y, 510, 28);
    setHorizontalAlignment(JLabel.CENTER);
    setVerticalAlignment(JLabel.CENTER);
    setFont(new Font("Poppins Regular", Font.PLAIN, 18));
    setForeground(new Color(180, 132, 108));
    addMouseListener(new java.awt.event.MouseAdapter(){
      @Override
      public void mouseEntered(MouseEvent e){
        setCursor( new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR) );
      }
      public void mouseExited(MouseEvent e){
        setCursor( new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR) );
      }
    });

  }
    
}
