package com.templates;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DashboardFrame {
    
    private JFrame frame = new JFrame("Ivander Library");
    private JPanel background = new JPanel();
    private JPanel sidebar = new JPanel();
    private JPanel header = new JPanel();
    private JPanel content = new JPanel();
    private JLabel logout = new JLabel();
    private JLabel logoImage;
    private JLabel lblAdministrator = new JLabel();
    private JLabel lblHeader = new JLabel();
    
    private Cursor handCursor = new Cursor(Cursor.HAND_CURSOR);
    private Cursor defaultCursor = new Cursor(Cursor.DEFAULT_CURSOR);
    
    
    public DashboardFrame(){
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
        
        // header
        header.setBackground(new Color(180, 132, 108));
        header.setBounds(274, 0, 1006, 74);
        header.setLayout(null);
        
        // sidebar
        sidebar.setBackground(new Color(229, 178, 153));
        sidebar.setBounds(0, 0, 274, 720);
        sidebar.setLayout(null);
        
        // content
        content.setBackground(new Color(229, 178, 153));
        content.setBounds(327, 124, 920, 546);
        content.setLayout(null);
        
        // label
        lblAdministrator.setText("👨‍ Administator");
        lblAdministrator.setFont(new Font("Poppins Regular", Font.PLAIN, 20));
        lblAdministrator.setBounds(98, 41, 157, 21);
        lblAdministrator.setForeground(Color.white);
        
        lblHeader.setText("IVANDER LIBRARY | Discover New Worlds With Library");
        lblHeader.setFont(new Font("Helvetica", Font.BOLD, 26));
        lblHeader.setBounds(51, 24, 690, 31);
        lblHeader.setForeground(Color.white);
        
        // logout
        logout.setText("LOGOUT");
        logout.setFont(new Font("Poppins Bold", Font.PLAIN, 25));
        logout.setBounds(1137, 0, 143, 74);
//        logout.setBackground(new Color(252, 222, 192));
        logout.setForeground(Color.white);
//        logout.setOpaque(true);
        logout.setVerticalAlignment(JLabel.CENTER);
        logout.setHorizontalAlignment(JLabel.CENTER);
        logout.addMouseListener(new java.awt.event.MouseAdapter(){
                
          @Override
          public void mouseEntered(MouseEvent e){
            logout.setCursor(handCursor);
          }
          public void mouseExited(MouseEvent e){
            logout.setCursor(defaultCursor);
          }
          public void mouseClicked(MouseEvent e){
            String [] options = {"YES", "CANCEL"};
            int confirmation = JOptionPane.showOptionDialog(null, "Are you sure you want to exit the application?", "Exit Confirmation", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if( confirmation == 0 ){
              System.exit(0);
            }
          }
          
        });
        
        // logo
        try {
            logoImage = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("/com.logo/log00o.png")).getImage().getScaledInstance(66, 66, Image.SCALE_SMOOTH)));
            logoImage.setBounds(9, 8, 66, 66);
            sidebar.add(logoImage);
        } catch (Exception e) {
            System.out.println("Image cannot be found!");
        }
        
        //
        
        header.add(lblHeader);
        sidebar.add(lblAdministrator);
        
        frame.add(logout); // kok frame?, kenapa ga header
        frame.add(header);
        frame.add(sidebar);
        frame.add(content);
        frame.add(background);
        
        frame.setVisible(true);
    }
    
}
