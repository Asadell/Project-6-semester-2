package com.templates;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * mulai 25 april
 * 
 */
public class StartFrame{
    
    private JFrame frame = new JFrame("Ivander Library");
    private JPanel background = new JPanel();
    private JPanel cardLeft = new JPanel();
    private JPanel cardRight = new JPanel();
    private JLabel logoImage;
    private JLabel exit = new JLabel();
    private Cursor handCursor = new Cursor(Cursor.HAND_CURSOR);
    private Cursor defaultCursor = new Cursor(Cursor.DEFAULT_CURSOR);
    
    public StartFrame(){
        
        // frame
        frame.setSize(1280, 720); // kenapa ga 720? | karena kalo 720 jadi ga sesuai ukurannya ga tau aneh emang
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // background
        background.setBackground(new Color(180, 132, 108));
        background.setBounds(0, 0, 1280, 720);
        background.setLayout(null);
        
        // card
        cardLeft.setBackground(new Color(252, 222, 192));
        cardLeft.setBounds(130, 85, 510, 550);
        cardLeft.setLayout(null);
        
        cardRight.setBackground(new Color(229, 178, 153));
        cardRight.setBounds(640, 85, 510, 550);
        cardRight.setLayout(null);
        
        // logo
        try {
            logoImage = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("/com.logo/log00.png")).getImage().getScaledInstance(510, 510, Image.SCALE_SMOOTH)));
            logoImage.setBounds(0, 20, 510, 510);
            cardRight.add(logoImage);
        } catch (Exception e) {
            System.out.println("Image cannot be found!");
        }
        
        // exit
        exit.setText("EXIT");
        exit.setFont(new Font("Poppins Bold", Font.PLAIN, 25));
        exit.setBounds(1188, 0, 92, 51);
        exit.setBackground(new Color(252, 222, 192));
        exit.setForeground(new Color(180, 132, 108));
        exit.setOpaque(true);
        exit.setHorizontalAlignment(JLabel.CENTER);
        exit.addMouseListener(new java.awt.event.MouseAdapter(){
                
          @Override
          public void mouseEntered(MouseEvent e){
            exit.setCursor(handCursor);
          }
          public void mouseExited(MouseEvent e){
            exit.setCursor(defaultCursor);
          }
          public void mouseClicked(MouseEvent e){
            String [] options = {"YES", "CANCEL"};
            int confirmation = JOptionPane.showOptionDialog(null, "Are you sure you want to exit the application?", "Exit Confirmation", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if( confirmation == 0 ){
              System.exit(0);
            }
          }
          
        });
        
        // add component
        background.add(cardLeft);
        background.add(cardRight);
        background.add(exit);
        frame.add(background);
        
        frame.setVisible(true);
    }
    
}
