package com.templates;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author HP
 */
public class ActionFrame {
    
    private JFrame frame = new JFrame();
    private JPanel background = new JPanel();
    private JPanel sidebar = new JPanel();
    private JLabel homePage = new JLabel();
    private Cursor handCursor = new Cursor(Cursor.HAND_CURSOR);
    private Cursor defaultCursor = new Cursor(Cursor.DEFAULT_CURSOR);
    
    public ActionFrame(){
        // frame
        frame.setSize(1280, 720); // kenapa ga 720? | karena kalo 720 jadi ga sesuai ukurannya ga tau aneh emang
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // background
        background.setBackground(new Color(252, 222, 192));
        background.setBounds(0, 0, 1280, 720);
        background.setLayout(null);
        
        // sidebar
        sidebar.setBackground(new Color(229, 178, 153));
        sidebar.setBounds(0, 0, 420, 720);
        sidebar.setLayout(null);
        
        // back to home page
        homePage.setText("<< HOME PAGE");
        homePage.setFont(new Font("Verdana", Font.BOLD, 25));
        homePage.setBounds(1040, 0, 220, 74);
//        homePage.setBackground(new Color(252, 222, 192));
        homePage.setForeground(new Color(180, 132, 108));
//        homePage.setOpaque(true);
        homePage.setVerticalAlignment(JLabel.CENTER);
        homePage.setHorizontalAlignment(JLabel.CENTER);
        homePage.addMouseListener(new java.awt.event.MouseAdapter(){
                
          @Override
          public void mouseEntered(MouseEvent e){
            homePage.setCursor(handCursor);
          }
          public void mouseExited(MouseEvent e){
            homePage.setCursor(defaultCursor);
          }
          public void mouseClicked(MouseEvent e){
            String [] options = {"YES", "CANCEL"};
            int confirmation = JOptionPane.showOptionDialog(null, "Are you sure you want to exit the application?", "Exit Confirmation", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if( confirmation == 0 ){
              System.exit(0);
            }
          }
          
        });
        
        background.add(homePage);
        background.add(sidebar);
        frame.add(background);
        
        frame.setVisible(true);
    }
    
}
