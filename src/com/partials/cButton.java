package com.partials;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import javax.swing.JButton;


public class cButton extends JButton{
    
    public cButton(String text, int x, int y, int width){
        
        super(); // to call default constructor from super class (extend)
        setText(text);
        setBounds(x, y, width, 35);
        setFont(new Font("Poppins Bold", Font.BOLD, 22));
        setBackground(new Color(180, 132, 108));
        setForeground(Color.BLACK.WHITE);
        setFocusable(false);
        addMouseListener(new java.awt.event.MouseAdapter(){
          @Override
          public void mouseEntered(MouseEvent e){
            setCursor( new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR) );
          }
          public void mouseExited(MouseEvent e){
            setCursor( new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR) );
          }
        });
        setBorder(null);
  }
    
}
