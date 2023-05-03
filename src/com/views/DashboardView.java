package com.views;

import com.partials.cBigFont;
import com.partials.cButton;
import com.partials.cCardHomePage;
import com.partials.cComboBoxSearch;
import com.partials.cFormLabelLogin;
import com.partials.cLabelInfo;
import com.partials.cRadioButton;
import com.partials.cScrollPane;
import com.partials.cSidebarMenu;
import com.partials.cTable;
import com.partials.cTextFieldLogin;
import com.partials.cTextFieldOther;
import com.program.Controller;
import com.program.Model;
import com.views.ActionFrameView;
import com.templates.DashboardFrame;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.table.DefaultTableModel;

class Filter{
  static String radioButton = "All";
  static String comboBox = "book.title";
  static String keyword = "";

  static DefaultTableModel search(){
    DefaultTableModel tm = new DefaultTableModel();
    if( radioButton.equalsIgnoreCase("All") ){
      // memanggil dan menggantikan tm dengan return dari getSearchAllPaket
      tm = Model.getSearchAllViewAllRecord(comboBox, keyword);
    }else { // besides all
      tm = Model.getSearchStatusViewAllRecord(radioButton, comboBox, keyword);
    }

    return tm;
  }

}

/**
 *
 * @author HP
 */
public class DashboardView extends DashboardFrame implements ItemListener{
    
    // attibute
    private Integer idSelected = null; // to pull username
    String options [] = {"Book Name", "Customer Name"};
    
    
    // ============= component =============
    
    // sidebar menu (one for all) all mightyyyyyyyyyyy
    private cSidebarMenu homePage = new cSidebarMenu("Home Page", 74);
    private cSidebarMenu manageBook = new cSidebarMenu("Manage Book", 124);
    private cSidebarMenu borrowBook = new cSidebarMenu("Borrow Book", 174);
    private cSidebarMenu returnBook = new cSidebarMenu("Return Book", 224);
    private cSidebarMenu customer = new cSidebarMenu("Customer", 274);
    private cSidebarMenu viewAllRecord = new cSidebarMenu("View All Record", 324);
//    private cSidebarMenu account = new cSidebarMenu("Account", 374);
    
    // Home Page Components
    private cCardHomePage card1 = new cCardHomePage(111, 80);
    private cCardHomePage card2 = new cCardHomePage(541, 84);
    private cCardHomePage card3 = new cCardHomePage(32, 288);
    private cCardHomePage card4 = new cCardHomePage(330, 288);
    private cCardHomePage card5 = new cCardHomePage(629, 288);
    
    private cLabelInfo noOfBookslbl = new cLabelInfo("No. Of Books");
    private cLabelInfo noOfCustomerlbl = new cLabelInfo("No. Of Customer");
    private cLabelInfo noOfBorrowingslbl = new cLabelInfo("No. Of Borrowings");
    private cLabelInfo noOfReturnslbl = new cLabelInfo("No. Of Returns");
    private cLabelInfo booksOnLoanlbl = new cLabelInfo("Books On Loan");
    
    private cBigFont noOfBooksbigfont = new cBigFont("-2");
    private cBigFont noOfCustomerbigfont = new cBigFont("-2");
    private cBigFont noOfBorrowingsbigfont = new cBigFont("-2");
    private cBigFont noOfReturnsbigfont = new cBigFont("-2");
    private cBigFont booksOnLoanbigfont = new cBigFont("-2");
    
    // View All Record components
    private cComboBoxSearch searchCb = new cComboBoxSearch(64, 440, options);
    private cTextFieldOther searchTxt = new cTextFieldOther(313, 440, 334, false);
//    private cButton searchBtn = new cButton("Search", 695, 440, 162);
    private cRadioButton rdAllStatus = new cRadioButton("All", "All", 313,500, 70);
    private cRadioButton rdReturnedStatus = new cRadioButton("Returned", "Returned", 390, 500, 130);
    private cRadioButton rdIssuedStatus = new cRadioButton("Issued", "Issued", 541, 500, 100);
    private cTable tblViewAllRecord;
    private cScrollPane spViewAllRecord;
    
    // Account components
//    private cFormLabelLogin usernameUpdateAccountLabel = new cFormLabelLogin("Username", 0, 61, 920, true);
//    private cTextFieldOther usernameUpdateAccountTxt = new cTextFieldOther(293, 99, 334, true);
//    private cFormLabelLogin passwordUpdateAccountLabel = new cFormLabelLogin("Password", 0, 153, 920, true);
//    private cTextFieldOther passwordUpdateAccountTxt = new cTextFieldOther(293, 191, 334, true);
//    private cFormLabelLogin emailUpdateAccountLabel = new cFormLabelLogin("Email", 0, 245, 920, true);
//    private cTextFieldOther emailUpdateAccountTxt = new cTextFieldOther(293, 283 , 334, true);
//    private cFormLabelLogin phoneNumberUpdateAccountLabel = new cFormLabelLogin("Phone Number", 0, 336, 920, true);
//    private cTextFieldOther phoneNumberUpdateAccountTxt = new cTextFieldOther(293, 375, 334, true);
//    private cButton submitUpdateAccountBtn = new cButton("Update Account", 293, 463, 334);
    
    // ============= component =============
    
    
    // constructor
    public DashboardView(String username){
        super(); // call super must be first in constructor
        admin.setText(username);
        
        this.idSelected = null;
        
        homePage.addMouseListener( new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me){
              initsHomePage();
            }
        });
        
        manageBook.addMouseListener( new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me){
                setVisible(false);
                Controller.showManageBook();
            }
        });
        
        borrowBook.addMouseListener( new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me){
                setVisible(false);
                Controller.showBorrowBook();
            }
        });
        
        returnBook.addMouseListener( new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me){
                setVisible(false);
                Controller.showReturnBook();
            }
        });
        
        customer.addMouseListener( new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me){
                setVisible(false);
                Controller.showCustomer();
            }
        });
        
        viewAllRecord.addMouseListener( new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me){
              initsViewAllRecord();
            }
        });
        
//        account.addMouseListener( new MouseAdapter(){
//            @Override
//            public void mouseClicked(MouseEvent me){
//              initsAccount();
//            }
//        });
        
        // add component default
        sidebar.add(homePage);
        sidebar.add(manageBook);
        sidebar.add(borrowBook);
        sidebar.add(returnBook);
        sidebar.add(customer);
        sidebar.add(viewAllRecord);
//        sidebar.add(account);
        
        initsHomePage();
//        com.views.ActionFrameView.initsManageBook;
    }
    
    // action listener for radio button (window view all record)
    public void itemStateChanged(ItemEvent e) {
        JRadioButton source = (JRadioButton) e.getSource();
        if (source.isSelected()) {
//            System.out.println(source.getText());
            Filter.radioButton = source.getText();
        }
    }
    
    // method to reset/refrest Side Bar
    public void resetSideBar(){
        try {
            setVisible(false); // kenapa harus ini
//            dispose(); // kenapa bukan ini?????
            
            homePage.setDefaultColor();
            homePage.setInactiveSidebar();
            
            manageBook.setDefaultColor();
            manageBook.setInactiveSidebar();
            
            borrowBook.setDefaultColor();
            borrowBook.setInactiveSidebar();
            
            returnBook.setDefaultColor();
            returnBook.setInactiveSidebar();
            
            customer.setDefaultColor();
            customer.setInactiveSidebar();
            
            viewAllRecord.setDefaultColor();
            viewAllRecord.setInactiveSidebar();
            
//            account.setDefaultColor();
//            account.setInactiveSidebar();
            
        } catch (Exception e) {
        }
        
    }
    
    // method refresh content
    private void refreshContent(){
        try{
          content.removeAll(); // all components in the main panel are deleted
        } catch(Exception e) {
        }
    }
    
    // method to call windows
    private  void initsHomePage(){
        idSelected = null;
        resetSideBar(); //  reset component on sidebar
        refreshContent(); // all components on the main panel are deleted
        
        // set Label color to be different
        homePage.setBackground(new Color(180, 132, 108));
        homePage.setForeground(Color.WHITE);
        
        // set mouse listener so it doesn't change color
        homePage.setActiveSidebar();
        
        menuTitle.setText("Home Page");
        
        noOfBooksbigfont.setText( String.valueOf( Model.getCountNoOfBooks() ) );
        noOfCustomerbigfont.setText( String.valueOf( Model.getCountNoOfCustomers() ) );
        noOfBorrowingsbigfont.setText( String.valueOf( Model.getCountNoOfBorrowings() ) );
        noOfReturnsbigfont.setText( String.valueOf( Model.getCountNoOfReturn() ) );
        booksOnLoanbigfont.setText( String.valueOf( Model.getCountBooksOnLoan() ) );
        
        // ==== components ====
        card1.add(noOfBookslbl);
        card1.add(noOfBooksbigfont);
        card2.add(noOfCustomerlbl);
        card2.add(noOfCustomerbigfont);
        card3.add(noOfBorrowingslbl);
        card3.add(noOfBorrowingsbigfont);
        card4.add(noOfReturnslbl);
        card4.add(noOfReturnsbigfont);
        card5.add(booksOnLoanlbl);
        card5.add(booksOnLoanbigfont);
        
        content.add(card1);
        content.add(card2);
        content.add(card3);
        content.add(card4);
        content.add(card5);
        // ==== components ====
        
        setVisible(true);
    }
    
    private void initsViewAllRecord(){
        idSelected = null;
        resetSideBar(); // reset component on sidebar
        refreshContent(); // all components on the main panel are deleted
        
        // set Label color to be different
        viewAllRecord.setActiveSidebar();
        viewAllRecord.setBackground(new Color(180, 132, 108));
        
        // set mouse listener so it doesn't change color
        viewAllRecord.setForeground(Color.WHITE);
        
        menuTitle.setText("View All Record");
        // radio button
        ButtonGroup groupButtonRadio = new ButtonGroup();
        groupButtonRadio.add(rdAllStatus);
        groupButtonRadio.add(rdReturnedStatus);
        groupButtonRadio.add(rdIssuedStatus);
        
        // action listener for Group Radio Button
        rdAllStatus.addItemListener(this);
        rdReturnedStatus.addItemListener(this);
        rdIssuedStatus.addItemListener(this);
        
        
        
        rdAllStatus.setSelected(true); // Sets the default selected "All"
        
        // Table
        tblViewAllRecord = new cTable( Model.getAllViewAllRecord());
        
//        tblViewAllRecord.addMouseListener( new java.awt.event.MouseAdapter(){
//          @Override
//        public void mousePressed( java.awt.event.MouseEvent me ){
//            int selectedIndex = tblViewAllRecord.getSelectedRow();
//            // int idPaket = Integer.parseInt(tblDataDataPaket.getValueAt(selectedIndex, 0).toString());
//            int idPaket = Integer.valueOf(tblViewAllRecord.getValueAt(selectedIndex, 0).toString());
//
//            String deskripsiPaket = Model.getDetailPaket(idPaket)[2].toString();
//            valueDeskripsiPaketDataPaket.setText(deskripsiPaket);
//            }
//        });
        
        searchCb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(searchCb.getSelectedItem().toString().equalsIgnoreCase("Customer Name")){
                    Filter.comboBox = "customer.name";
                }else{
                    Filter.comboBox = "book.title";
                }
            }
        });
        
        searchTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Filter.keyword = searchTxt.getText();
                tblViewAllRecord.setModel(Filter.search());
            }
        });
        
        spViewAllRecord = new cScrollPane(tblViewAllRecord, 60, 72, 850, 290);

        // ==== components ====
        content.add(searchCb);
        content.add(searchTxt);
//        content.add(searchBtn);
        content.add(rdAllStatus);
        content.add(rdReturnedStatus);
        content.add(rdIssuedStatus);
        content.add(spViewAllRecord);
        // ==== components ====
        
        setVisible(true);
    }
    
//    private void initsAccount(){
//        idSelected = null;
//        resetSideBar(); // reset component on sidebar
//        refreshContent(); // all components on the main panel are deleted
//        
//        // set Label color to be different
//        account.setBackground(new Color(180, 132, 108));
//        account.setForeground(Color.WHITE);
//        
//        // set mouse listener so it doesn't change color
//        account.setActiveSidebar();
//        
//        menuTitle.setText("Account");
//        
//        
//        // ==== components ====
//        content.add(usernameUpdateAccountLabel);
//        content.add(usernameUpdateAccountTxt);
//        content.add(passwordUpdateAccountLabel);
//        content.add(passwordUpdateAccountTxt);
//        content.add(emailUpdateAccountLabel);
//        content.add(emailUpdateAccountTxt);
//        content.add(phoneNumberUpdateAccountLabel);
//        content.add(phoneNumberUpdateAccountTxt);
//        content.add(submitUpdateAccountBtn);
//        // ==== components ====
//        
//        setVisible(true);
//    }
    
}