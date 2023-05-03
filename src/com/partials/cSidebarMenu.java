/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.partials;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.*;

/**
 *
 * @author HP
 */
public class cSidebarMenu extends JLabel{
    
    // constructor
    public cSidebarMenu(String text, int y){
        super();  // to call default constructor from super class (extend)
        setText("      " + text);
        setFont(new Font("Helvetica", Font.BOLD, 25));
        setBounds(0, y, 274, 50);
        setOpaque(true); // ??????????????????????????????????????
        setDefaultColor(); // call method (in this class) to set default color
        setVerticalAlignment(JLabel.CENTER);
        addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                setCursor( new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR) );
            }
            public void mouseExited(MouseEvent e){
                setCursor( new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR) );
            }
        });
        
        setInactiveSidebar();
        
    }
    
    // method to check..
    public MouseAdapter ActiveSidebar = new MouseAdapter(){
        @Override
        public void mouseEntered(MouseEvent me){
          setBackground(new Color(180, 132, 108));
          setForeground(Color.WHITE);
        }
        public void mouseExited(MouseEvent me){
          setBackground(new Color(180, 132, 108));
          setForeground(Color.WHITE);
        }
    };

    public MouseAdapter InactiveSidebar = new MouseAdapter(){
        @Override
        public void mouseEntered(MouseEvent e)
        {
          setBackground(new Color(180, 132, 108));
          setForeground(Color.WHITE);
        }
        public void mouseExited(MouseEvent e)
        {
          setBackground(new Color(229, 178, 153));
          setForeground(Color.BLACK);
        }
    };
    
    public void setActiveSidebar(){
        try {
            removeMouseListener(InactiveSidebar);
        } catch (Exception e) {
            // lorem
        }
        addMouseListener(ActiveSidebar);
    }

    public void setInactiveSidebar(){
        try {
            removeMouseListener(ActiveSidebar);
        } catch (Exception e) {
            // lorem
        }
        addMouseListener(InactiveSidebar);
    }
    
    public void setDefaultColor(){
        setBackground(new Color (229, 178, 153));
        setForeground(Color.BLACK);
    }
    
    public void setSelectedColor(){
        setBackground(new Color(180, 132, 108));
        setForeground(Color.WHITE);
    }
}
