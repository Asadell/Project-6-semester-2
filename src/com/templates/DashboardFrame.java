package com.templates;

import com.partials.cBigFont;
import com.partials.cCardHomePage;
import com.partials.cLabelInfo;
import com.partials.cSidebarMenu;
import com.program.Controller;
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

public class DashboardFrame extends JFrame{
    //public
    public JPanel sidebar = new JPanel();
    public JPanel content = new JPanel();
    public JLabel menuTitle = new JLabel();
    public JLabel admin = new JLabel();
    
    // ========= percobaan =========
//    private cCardHomePage card = new cCardHomePage(111,80);
//    private cLabelInfo lblInfo = new cLabelInfo("No. Of Books");
//    private cBigFont lblBigFont = new cBigFont("5");
    
    
    // ========= percobaan =========
    
    // private
//    private JFrame frame = new JFrame("Ivander Library"); // gadipake, karna mau jadi abstract, jadi gaperlu instansiasi object, dan juga kalo instansiasi object di class ini, pasa dipanggil di class lain malah gabias, karena di set nya untuk object tersebut
    private JPanel background = new JPanel();
    private JPanel header = new JPanel();
    private JLabel logout = new JLabel();
    private JLabel logoImage;
    private JLabel lblHeader = new JLabel();
    private JLabel copyRight = new JLabel();
    private JLabel lblAdministrator = new JLabel();
//    private cSidebarMenu homePage = new cSidebarMenu("Home Page", 74);
    
    private Cursor handCursor = new Cursor(Cursor.HAND_CURSOR);
    private Cursor defaultCursor = new Cursor(Cursor.DEFAULT_CURSOR);
    
    
    public DashboardFrame(){
        // frame
        setSize(1280, 720); // kenapa ga 720? | karena kalo 720 jadi ga sesuai ukurannya ga tau aneh emang
        setLocationRelativeTo(null);
        setLayout(null);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
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
        content.setBounds(317, 124, 920, 546);
        content.setLayout(null);
        
        // label
        lblAdministrator.setText("👨‍ Administator");
        lblAdministrator.setFont(new Font("Poppins Regular", Font.BOLD, 20));
        lblAdministrator.setBounds(98, 41, 157, 21);
        lblAdministrator.setForeground(new Color(69, 69, 69));
        
        admin.setText("Naruto Uzumaki");
        admin.setFont(new Font("Poppins Regular", Font.BOLD, 20));
        admin.setBounds(96, 13, 157, 21);
        admin.setForeground(new Color(69, 69, 69));
        
        lblHeader.setText("IVANDER LIBRARY | Discover New Worlds With Library");
        lblHeader.setFont(new Font("Helvetica", Font.BOLD, 26));
        lblHeader.setBounds(51, 24, 690, 31);
        lblHeader.setForeground(Color.white);
        
        copyRight.setText("© 2023 Group 3_2SE2_CCT-FTUI");
        copyRight.setFont( new Font("Tahoma", Font.PLAIN, 12));
        copyRight.setBounds(274, 675, 1006, 41);
        copyRight.setForeground(Color.BLACK);
        copyRight.setHorizontalAlignment(JLabel.CENTER);
        
//        menuTitle.setText("Home Page"); // will be edited in views package
        menuTitle.setFont(new Font("Arial", Font.BOLD, 36));
        menuTitle.setBounds(327, 80, 400, 40);
        menuTitle.setForeground(Color.BLACK);
        
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
            int confirmation = JOptionPane.showOptionDialog(null, "Are you sure you want logout?", "Logout Confirmation", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if( confirmation == 0 ){
                Controller.showLogin();
//              System.exit(0);
            }
          }
          
        });
        
        // logo
        try {
            logoImage = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("/com.logo/log00o.png")).getImage().getScaledInstance(66, 66, Image.SCALE_SMOOTH)));
            logoImage.setBounds(9, 7, 66, 66);
            sidebar.add(logoImage);
        } catch (Exception e) {
            System.out.println("Image cannot be found!");
        }
        
        // ============= nanti bakal diapus =============
//        sidebar.add(homePage);
        
//        card.add(lblInfo);
//        card.add(lblBigFont);
//        
//        content.add(card);
        
        
        // ============= nanti bakal diapus =============
        
        // adding component
        header.add(lblHeader);
        
        sidebar.add(lblAdministrator);
        sidebar.add(admin);
        
        background.add(copyRight);
        background.add(menuTitle);
        
        add(logout); // kok frame?, kenapa ga header
        add(header);
        add(sidebar);
        add(content);
        add(background);
        
//        setVisible(true);
    }
    
}
