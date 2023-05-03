package com.templates;

import com.partials.cButton;
import com.partials.cFormLabelLogin;
import com.partials.cLinkStart;
import com.partials.cPasswordField;
import com.partials.cTextFieldLogin;
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
//public abstract class StartFrame extends JFrame{ // kalo mau abstract
public class StartFrame extends JFrame{ // kalo ga mau abstract
    
    private JPanel background = new JPanel();
    private JLabel logoImage;
    private JLabel titleLogo = new JLabel();
    private JLabel sloganLogo = new JLabel();
    private JPanel cardRight = new JPanel();
    public JPanel cardLeft = new JPanel();
    public JLabel titleStart = new JLabel();
    
    private JLabel exit = new JLabel();
    private Cursor handCursor = new Cursor(Cursor.HAND_CURSOR);
    private Cursor defaultCursor = new Cursor(Cursor.DEFAULT_CURSOR);
    
    public StartFrame(){
        super(); // to call default constructor from JFrame
        
        // frame
        setSize(1280, 720); // kenapa ga 720? | karena kalo 720 jadi ga sesuai ukurannya ga tau aneh emang
        setLocationRelativeTo(null);
        setLayout(null);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.
        
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
        
        // label title
//        titleStart.setText("TITLE"); // nanti diisi dari masing2 frame
        titleStart.setFont(new Font("Arial", Font.BOLD, 40));
        titleStart.setForeground(Color.BLACK);
        titleStart.setBounds(0, 33, 510, 56);
        titleStart.setHorizontalAlignment(JLabel.CENTER);
        titleStart.setVerticalAlignment(JLabel.CENTER);
        
        titleLogo.setText("INVANDER LIBRARY"); 
        titleLogo.setFont(new Font("Times New Roman", Font.PLAIN, 42));
        titleLogo.setForeground(Color.BLACK);
        titleLogo.setBounds(0, 377, 510, 62);
        titleLogo.setHorizontalAlignment(JLabel.CENTER);
        titleLogo.setVerticalAlignment(JLabel.CENTER);
        
        sloganLogo.setText("DISCOVER NEW WORLDS WITH LIBRARY"); 
        sloganLogo.setFont(new Font("Times New Roman", Font.ITALIC, 12));
        sloganLogo.setForeground(Color.BLACK);
        sloganLogo.setBounds(0, 439, 510, 17);
        sloganLogo.setHorizontalAlignment(JLabel.CENTER);
        sloganLogo.setVerticalAlignment(JLabel.CENTER);
    
        // logo
        try {
            logoImage = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("/com.logo/log00o.png")).getImage().getScaledInstance(310, 310, Image.SCALE_SMOOTH)));
            logoImage.setBounds(101, 69, 310, 310);
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
        
        // ============= nanti bakal diapus =============
//        cFormLabel username = new cFormLabel("Username", 0, 140, 510, true);
//        
//        cTextField txtField = new cTextField(88, 173, 334, false);
//        
//        cButton bigButton = new cButton("Submit", 88, 338, 334);
//        
//        cLinkStart textLink = new cLinkStart("Create Account", 459);
//        
//        cPasswordField pw = new cPasswordField(88, 257, 334, true);
        // ============= nanti bakal diapus =============
        
        
        // add component
        cardLeft.add(titleStart);
//        cardLeft.add(username);
//        cardLeft.add(txtField);
//        cardLeft.add(bigButton);
//        cardLeft.add(textLink);
//        cardLeft.add(pw);
        
        cardRight.add(titleLogo);
        cardRight.add(sloganLogo);
        
        background.add(cardLeft);
        background.add(cardRight);
        background.add(exit);
        
        add(background);
        
//        setVisible(true); // ga perlu, karena akan di sett di views
    }
    
}
