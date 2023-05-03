package com.templates;

import com.partials.cCardActionFrame;
import com.partials.cLabelInfoBorrowReturn;
import com.partials.cLabelTitleBorrowReturn;
import com.program.Controller;
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
public class ActionFrame extends JFrame{
    
    public JPanel sidebar = new JPanel();
    public JLabel title = new JLabel();
    public JPanel background = new JPanel();
    public JPanel backgroundComboBox = new JPanel();
    public JPanel backgroundTable = new JPanel();
    
    //hapus ====
//    private cCardActionFrame card1BorrowBook = new cCardActionFrame(29, 0);
//    private cCardActionFrame card2BorrowBook = new cCardActionFrame(452, 0);
    
    // borrow book
//    private cLabelTitleBorrowReturn labelTitleBorrowReturn = new cLabelTitleBorrowReturn("Book ID", 20, 33);
//    private cLabelInfoBorrowReturn labelInfoBorrowReturn = new cLabelInfoBorrowReturn("Crown Publishing",172,32);
    
    // hapus ====
    
//    private JFrame frame = new JFrame();
    private JLabel homePage = new JLabel();
    private Cursor handCursor = new Cursor(Cursor.HAND_CURSOR);
    private Cursor defaultCursor = new Cursor(Cursor.DEFAULT_CURSOR);
    
    public ActionFrame(){
        // frame
        setSize(1280, 720); // kenapa ga 720? | karena kalo 720 jadi ga sesuai ukurannya ga tau aneh emang
        setLocationRelativeTo(null);
        setLayout(null);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // background
        background.setBackground(new Color(252, 222, 192));
        background.setBounds(420, 0, 860, 720);
        background.setLayout(null);
        
        // background combo box
        backgroundComboBox.setBackground(new Color(252, 222, 192));
        backgroundComboBox.setBounds(0, 610, 860, 110);
        backgroundComboBox.setLayout(null);
        
        // background table
        backgroundTable.setBackground(new Color(252, 222, 192));
//        backgroundTable.setBackground(Color.WHITE);
        backgroundTable.setBounds(0, 180, 860, 420);
        backgroundTable.setLayout(null);
        
        // sidebar
        sidebar.setBackground(new Color(229, 178, 153));
        sidebar.setBounds(0, 0, 420, 720);
        sidebar.setLayout(null);
        
        // label title
//        title.setText("TITLE"); // nanti diisi dari masing2 frame
        title.setFont(new Font("Arial", Font.BOLD, 40));
        title.setForeground(Color.BLACK);
        title.setBounds(0, 110, 860, 47);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.CENTER);
        
        // back to home page
        homePage.setText("<< HOME PAGE");
        homePage.setFont(new Font("Verdana", Font.BOLD, 25));
        homePage.setBounds(620, 0, 220, 74);
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
            int confirmation = JOptionPane.showOptionDialog(null, "Are you sure you want to return to the Home Page?", "Exit Confirmation", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if( confirmation == 0 ){
                dispose();
                Controller.showHomePage();
            }
        }
          
        });
        
        // hapus ===
//        card1BorrowBook.add(labelTitleBorrowReturn);
//        card1BorrowBook.add(labelInfoBorrowReturn);
//        backgroundTable.add(card1BorrowBook);
//        backgroundTable.add(card2BorrowBook);
        
        
        // hapus ===
        
        background.add(homePage);
        background.add(title);
        background.add(backgroundComboBox);
        background.add(backgroundTable);
        add(sidebar);
        add(background);
        
        setVisible(true);
    }
    
}
