package com.views;

import com.partials.cButton;
import com.partials.cCardActionFrame;
import com.partials.cComboBoxCustomer;
import com.partials.cComboBoxSearch;
import com.partials.cFormLabelLogin;
import com.partials.cScrollPane;
import com.partials.cTable;
import com.partials.cTextFieldOther;
import com.program.Controller;
import com.program.Model;
import com.templates.ActionFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

class Filter{
  static String comboBoxManageBook = "title";
  static String comboBoxCustomer = "name";
  static String keyword = "";

  static DefaultTableModel searchManageBook(){
    DefaultTableModel tm = new DefaultTableModel();

    tm = Model.getSearchManageBook(comboBoxManageBook, keyword);

    return tm;
  }
  static DefaultTableModel searchCustomer(){
    DefaultTableModel tm = new DefaultTableModel();

    tm = Model.getSearchCustomer(comboBoxCustomer, keyword);

    return tm;
  }

}

/**
 *
 * @author HP
 */
public class ActionFrameView extends ActionFrame{
    
    // attribute
    String optionsManageBooktbl [] = {"Title", "Author", "Publisher", "Book Type"};
    String optionsCustomertbl [] = {"Name", "Phone Number", "Gender"};
    String optionsCustomercmb [] = {"Male", "Female"};
    
    
    // ============= component =============
    
    // component of Manage Book
    private cFormLabelLogin bookIdManageBookLabel = new cFormLabelLogin("Book ID", 45, 34, 150, false);
    private cTextFieldOther bookIdManageBookTxt = new cTextFieldOther(45, 72, 334, false);
    private cFormLabelLogin titleManageBookLabel = new cFormLabelLogin("Title", 45, 126, 150, false);
    private cTextFieldOther titleManageBookTxt = new cTextFieldOther(45, 164, 334, false);
    private cFormLabelLogin authorManageBookLabel = new cFormLabelLogin("Author", 45, 218, 150, false);
    private cTextFieldOther authorManageBookTxt = new cTextFieldOther(45, 256, 334, false);
    private cFormLabelLogin publisherManageBookLabel = new cFormLabelLogin("Publisher", 45, 310, 150, false);
    private cTextFieldOther publisherManageBookTxt = new cTextFieldOther(45, 348, 334, false);
    private cFormLabelLogin bookTypeManageBookLabel = new cFormLabelLogin("Book Type", 45, 402, 150, false);
    private cTextFieldOther bookTypeManageBookTxt = new cTextFieldOther(45, 440, 334, false);
    private cFormLabelLogin quantityManageBookLabel = new cFormLabelLogin("Quantity", 45, 494, 150, false);
    private cTextFieldOther quantityManageBookTxt = new cTextFieldOther(45, 532, 334, false);
    private cButton saveBookManageBookBtn = new cButton("Save", 45, 597, 334);
    private cButton deleteBookManageBookBtn = new cButton("Delete", 45, 642, 334);
    private cComboBoxSearch searchManageBookCb = new cComboBoxSearch(66, 0, optionsManageBooktbl);
    private cTextFieldOther searchManageBookTxt = new cTextFieldOther(323, 0, 334, false);
//    private cButton searchManageBookBtn = new cButton("Search", 663, 10, 162);
    private cTable tblManageBook;
    private cScrollPane spManageBook;
    
    // component of Borrow Book
    private cFormLabelLogin bookIdBorrowBookLabel = new cFormLabelLogin("Book ID", 45, 126, 150, false);
    private cTextFieldOther bookIdBorrowBookTxt = new cTextFieldOther(45, 164, 334, false);
    private cFormLabelLogin customerIdBorrowBookLabel = new cFormLabelLogin("Customer ID", 45, 218, 150, false);
    private cTextFieldOther customerIdBorrowBookTxt = new cTextFieldOther(45, 256, 334, false);
    private cFormLabelLogin issueDateBorrowBookLabel = new cFormLabelLogin("Issue Date", 45, 310, 150, false);
    private cTextFieldOther issueDateBorrowBookTxt = new cTextFieldOther(45, 348, 334, false);
    private cFormLabelLogin dueDateBorrowBookLabel = new cFormLabelLogin("Due Date", 45, 402, 150, false);
    private cTextFieldOther dueDateBorrowBookTxt = new cTextFieldOther(45, 440, 334, false);
    private cButton issueBookBorrowBookBtn = new cButton("Issue Date", 45, 540, 334);
    private cCardActionFrame card1BorrowBook = new cCardActionFrame(29, 0);
    private cCardActionFrame card2BorrowBook = new cCardActionFrame(452, 0);
    
    // component of Return Book
    private cFormLabelLogin bookIdReturnBookLabel = new cFormLabelLogin("Book ID", 45, 218, 150, false);
    private cTextFieldOther bookIdReturnBookTxt = new cTextFieldOther(45, 256, 334, false);
    private cFormLabelLogin customerIdReturnBookLabel = new cFormLabelLogin("Customer ID", 45, 310, 150, false);
    private cTextFieldOther customerIdReturnBookTxt = new cTextFieldOther(45, 348, 334, false);
    private cButton returnBookReturnBookBtn = new cButton("Return Book", 45, 440, 334);
    private cCardActionFrame card1ReturnBook = new cCardActionFrame(29, 0);
    private cCardActionFrame card2ReturnBook = new cCardActionFrame(452, 0);
    
    // component of Customer
    private cFormLabelLogin customerIdCustomerLabel = new cFormLabelLogin("Customer ID", 45, 126, 150, false);
    private cTextFieldOther customerIdCustomerTxt = new cTextFieldOther(45, 164, 334, false);
    private cFormLabelLogin nameCustomerLabel = new cFormLabelLogin("Name", 45, 218, 150, false);
    private cTextFieldOther nameCustomerTxt = new cTextFieldOther(45, 256, 334, false);
    private cFormLabelLogin phoneNumberCustomerLabel = new cFormLabelLogin("Phone Number", 45, 310, 190, false);
    private cTextFieldOther phoneNumberCustomerTxt = new cTextFieldOther(45, 348, 334, false);
    private cFormLabelLogin genderCustomerLabel = new cFormLabelLogin("Gender", 45, 402, 150, false);
    private cComboBoxCustomer genderCustomercmb = new cComboBoxCustomer(45, 440, optionsCustomercmb);
//    private cTextFieldOther genderCustomerTxt = new cTextFieldOther(45, 440, 334, false);
    private cButton saveCustomerBtn = new cButton("Save", 45, 520, 334);
    private cButton deleteCustomerBtn = new cButton("Delete", 45, 565, 334);
    private cComboBoxSearch searchCustomerCb = new cComboBoxSearch(66, 0, optionsCustomertbl);
    private cTextFieldOther searchCustomerTxt = new cTextFieldOther(323, 0, 334, false);
//    private cButton searchCustomerBtn = new cButton("Search", 663, 400, 162);
    private cTable tblCustomer;
    private cScrollPane spCustomer;
    
    // constructor
    public ActionFrameView(){
        super(); // to call constructor in parent classr
        
    }
    
    // method
    public void initsManageBook(){
        sidebar.removeAll();
        backgroundComboBox.removeAll();
        backgroundTable.removeAll();
        clearTextField();
        title.setText("Manage Book");
        saveBookManageBookBtn.setText("Save");
        
        tblManageBook = new cTable( Model.getManageBook() );
        tblManageBook.getColumnModel().getColumn(0).setPreferredWidth(10);
        tblManageBook.getColumnModel().getColumn(1).setPreferredWidth(150);
        tblManageBook.getColumnModel().getColumn(2).setPreferredWidth(100);
        tblManageBook.getColumnModel().getColumn(5).setPreferredWidth(10);

        tblManageBook.addMouseListener( new java.awt.event.MouseAdapter(){
        @Override
        public void mousePressed( MouseEvent me ){
            
            bookIdManageBookTxt.setText(tblManageBook.getValueAt(tblManageBook.getSelectedRow(), 0).toString());
            titleManageBookTxt.setText(tblManageBook.getValueAt(tblManageBook.getSelectedRow(), 1).toString());
            authorManageBookTxt.setText(tblManageBook.getValueAt(tblManageBook.getSelectedRow(), 2).toString());
            publisherManageBookTxt.setText(tblManageBook.getValueAt(tblManageBook.getSelectedRow(), 3).toString());
            bookTypeManageBookTxt.setText(tblManageBook.getValueAt(tblManageBook.getSelectedRow(), 4).toString());
            quantityManageBookTxt.setText(tblManageBook.getValueAt(tblManageBook.getSelectedRow(), 5).toString());
            
            saveBookManageBookBtn.setText("Update");
            }
        });
        
        searchManageBookCb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(searchManageBookCb.getSelectedItem().toString().equalsIgnoreCase("Title")){
                    Filter.comboBoxManageBook = "title";
                }else if(searchManageBookCb.getSelectedItem().toString().equalsIgnoreCase("Author")){
                    Filter.comboBoxManageBook = "author";
                }else if(searchManageBookCb.getSelectedItem().toString().equalsIgnoreCase("Publisher")){
                    Filter.comboBoxManageBook = "publisher";
                }else if(searchManageBookCb.getSelectedItem().toString().equalsIgnoreCase("Book Type")){
                    Filter.comboBoxManageBook = "book_type";
                }
            }//"Title", "Author", "Publisher", "Book Type"
        });
        
        searchManageBookTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Filter.keyword = searchManageBookTxt.getText();
                tblManageBook.setModel(Filter.searchManageBook());
            }
        });

        spManageBook = new cScrollPane(tblManageBook, 20, 0, 820, 330);
        bookIdManageBookTxt.setEditable(false);
        
        // add component
        sidebar.add(bookIdManageBookLabel);
        sidebar.add(bookIdManageBookTxt);
        sidebar.add(titleManageBookLabel);
        sidebar.add(titleManageBookTxt);
        sidebar.add(authorManageBookLabel);
        sidebar.add(authorManageBookTxt);
        sidebar.add(publisherManageBookLabel);
        sidebar.add(publisherManageBookTxt);
        sidebar.add(bookTypeManageBookLabel);
        sidebar.add(bookTypeManageBookTxt);
        sidebar.add(quantityManageBookLabel);
        sidebar.add(quantityManageBookTxt);
        sidebar.add(saveBookManageBookBtn);
        sidebar.add(deleteBookManageBookBtn);
        
        backgroundComboBox.add(searchManageBookCb);
        backgroundComboBox.add(searchManageBookTxt);
//        backgroundComboBox.add(searchManageBookBtn);
        backgroundTable.add(spManageBook);
        
        // action listener (button)
        saveBookManageBookBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                if(titleManageBookTxt.getText().isEmpty() || authorManageBookTxt.getText().isEmpty() || publisherManageBookTxt.getText().isEmpty() || bookTypeManageBookTxt.getText().isEmpty() || quantityManageBookTxt.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Field cannot be empty, except for Book ID", "Empty", JOptionPane.WARNING_MESSAGE);
                }else{
                    String title = titleManageBookTxt.getText().trim();
                    String author = authorManageBookTxt.getText().trim();
                    String publisher = publisherManageBookTxt.getText().trim();
                    String bookType = bookTypeManageBookTxt.getText().trim();
                    int quantity = Integer.valueOf(quantityManageBookTxt.getText().trim());

                    if(saveBookManageBookBtn.getText() == "Save"){
                        if(Model.SaveManageBook(title, author, publisher, bookType, quantity)){
                            // Refresh table
                            dispose();
                            Controller.showManageBook();
                            clearTextField(); // Delete the text in the text field
                            JOptionPane.showMessageDialog(null, "Successfully added book", "Message", JOptionPane.INFORMATION_MESSAGE);
                        }else{
                            JOptionPane.showMessageDialog(null, "Failed to add book", "Message", JOptionPane.ERROR_MESSAGE);
                        }
                    }else{  // saveBookManageBookBtn.getText() == "Update"
                        int bookID = Integer.valueOf(bookIdManageBookTxt.getText());
                        if(Model.UpdateManageBook(bookID, title, author, publisher, bookType, quantity)){
                            // Refresh table
                            dispose();
                            Controller.showManageBook();
                            clearTextField(); // Delete the text in the text field
                            JOptionPane.showMessageDialog(null, "Successfully updated book", "Message", JOptionPane.INFORMATION_MESSAGE);
                        }else{
                            JOptionPane.showMessageDialog(null, "Failed to update book", "Message", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        });
        
        deleteBookManageBookBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                
                if(bookIdManageBookTxt.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Please select the book from the table first", "Book ID", JOptionPane.WARNING_MESSAGE);
                    
                }else{
                    // validation
                    int answer = JOptionPane.showConfirmDialog(null, "Are you sure you want to continue deleting the book?", "Message", JOptionPane.YES_NO_OPTION);
                    if(answer == 0) {
                        int bookID = Integer.valueOf(bookIdManageBookTxt.getText());

                        if(Model.DeleteManageBook(bookID)){
                            // Refresh table
                            dispose();
                            Controller.showManageBook();
                            clearTextField(); // Delete the text in the text field
                            JOptionPane.showMessageDialog(null, "Successfully deleted the book", "Message", JOptionPane.INFORMATION_MESSAGE);
                        }else{
                            JOptionPane.showMessageDialog(null, "Failed to delete the book", "Message", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        });
    }
    
    public void initsBorrowBook(){
        sidebar.removeAll();
        backgroundComboBox.removeAll();
        backgroundTable.removeAll();
        clearTextField();
        title.setText("Borrow Book");
        
        // add component
        sidebar.add(bookIdBorrowBookLabel);
        sidebar.add(bookIdBorrowBookTxt);
        sidebar.add(customerIdBorrowBookLabel);
        sidebar.add(customerIdBorrowBookTxt);
        sidebar.add(issueDateBorrowBookLabel);
        sidebar.add(issueDateBorrowBookTxt);
        sidebar.add(dueDateBorrowBookLabel);
        sidebar.add(dueDateBorrowBookTxt);
        sidebar.add(issueBookBorrowBookBtn);
        
        
//        card1BorrowBook.add($);
//        card2BorrowBook.add($);
        
        backgroundTable.add(card1BorrowBook);
        backgroundTable.add(card2BorrowBook);
        
        // action listener (button)
        issueBookBorrowBookBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                /**
                 * action
                 */
            }
        });
        
    }
    
    public void initsReturnBook(){
        sidebar.removeAll();
        backgroundComboBox.removeAll();
        backgroundTable.removeAll();
        clearTextField();
        title.setText("Return Book");
        
        // add component
        sidebar.add(bookIdReturnBookLabel);
        sidebar.add(bookIdReturnBookTxt);
        sidebar.add(customerIdReturnBookLabel);
        sidebar.add(customerIdReturnBookTxt);
        sidebar.add(returnBookReturnBookBtn);
        
        
//        card1ReturnBook.add($);
//        card2ReturnBook.add($);
        
        backgroundTable.add(card1ReturnBook);
        backgroundTable.add(card2ReturnBook);
        
        // action listener (button)
        returnBookReturnBookBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                /**
                 * action
                 */
            }
        });
    }
    
    public void initsCustomer(){
        sidebar.removeAll();
        backgroundComboBox.removeAll();
        backgroundTable.removeAll();
        clearTextField();
        title.setText("Customer");
        saveCustomerBtn.setText("Save");
        
        tblCustomer = new cTable( Model.getCustomer());
        tblCustomer.getColumnModel().getColumn(0).setPreferredWidth(10);
        tblCustomer.getColumnModel().getColumn(1).setPreferredWidth(100);


        tblCustomer.addMouseListener( new java.awt.event.MouseAdapter(){
        @Override
        public void mousePressed( MouseEvent me ){
            customerIdCustomerTxt.setText(tblCustomer.getValueAt(tblCustomer.getSelectedRow(), 0).toString());
            nameCustomerTxt.setText(tblCustomer.getValueAt(tblCustomer.getSelectedRow(), 1).toString());
            phoneNumberCustomerTxt.setText(tblCustomer.getValueAt(tblCustomer.getSelectedRow(), 2).toString());
            genderCustomercmb.setSelectedItem(tblCustomer.getValueAt(tblCustomer.getSelectedRow(), 3).toString());
            saveCustomerBtn.setText("Update");
          }
        } );
        
        searchCustomerCb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(searchCustomerCb.getSelectedItem().toString().equalsIgnoreCase("Name")){
                    Filter.comboBoxCustomer = "name";
                }else if(searchCustomerCb.getSelectedItem().toString().equalsIgnoreCase("Phone Number")){
                    Filter.comboBoxCustomer = "phone_number";
                }else if(searchCustomerCb.getSelectedItem().toString().equalsIgnoreCase("Gender")){
                    Filter.comboBoxCustomer = "gender";
                }
            } // "Name", "Phone Number", "Gender"
        });
        
        searchCustomerTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Filter.keyword = searchCustomerTxt.getText();
                tblCustomer.setModel(Filter.searchCustomer());
            }
        });

        spCustomer = new cScrollPane(tblCustomer, 20, 0, 820, 330);
        customerIdCustomerTxt.setEditable(false);
        
        // add component
        sidebar.add(customerIdCustomerLabel);
        sidebar.add(customerIdCustomerTxt);
        sidebar.add(nameCustomerLabel);
        sidebar.add(nameCustomerTxt);
        sidebar.add(phoneNumberCustomerLabel);
        sidebar.add(phoneNumberCustomerTxt);
        sidebar.add(genderCustomerLabel);
        sidebar.add(genderCustomercmb);
        sidebar.add(saveCustomerBtn);
        sidebar.add(deleteCustomerBtn);
        
        backgroundComboBox.add(searchCustomerCb);
        backgroundComboBox.add(searchCustomerTxt);
//        backgroundComboBox.add(searchCustomerBtn);
        backgroundTable.add(spCustomer);

        // action listener (button)
        saveCustomerBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                
                if(nameCustomerTxt.getText().isEmpty() || phoneNumberCustomerTxt.getText().isEmpty() ){
                    JOptionPane.showMessageDialog(null, "Field cannot be empty, except for Customer ID", "Empty", JOptionPane.WARNING_MESSAGE);
                }else{  
                    String name = nameCustomerTxt.getText().trim();
                    String phoneNumber = phoneNumberCustomerTxt.getText().trim();
                    String gender = genderCustomercmb.getSelectedItem().toString();

                    if(saveCustomerBtn.getText() == "Save"){
                        if(Model.SaveCustomer(name, phoneNumber, gender)){
                            // Refresh table
                            dispose(); // close window
                            Controller.showCustomer(); // open window again to refresh table
                            clearTextField(); // Delete the text in text field
                            JOptionPane.showMessageDialog(null, "Successfully added Customer", "Message", JOptionPane.INFORMATION_MESSAGE);
                        }else{
                            JOptionPane.showMessageDialog(null, "Failed to add Customer", "Message", JOptionPane.ERROR_MESSAGE);
                        }
                    }else{ // saveCustomerBtn.getText() == "Update"
                        int customerID = Integer.valueOf(customerIdCustomerTxt.getText());
                        if(Model.UpdateCustomer(customerID, name, phoneNumber, gender)){
                            // Refresh table
                            dispose(); // close window
                            Controller.showCustomer(); // open window again to refresh table
                            clearTextField(); // Delete the text in the text field
                            JOptionPane.showMessageDialog(null, "Successfully updated customer data", "Message", JOptionPane.INFORMATION_MESSAGE);
                        }else{
                            JOptionPane.showMessageDialog(null, "Failed to update customer data", "Message", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        });
        
        deleteCustomerBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                
                if(customerIdCustomerTxt.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Please select customer data from the table first", "Book ID", JOptionPane.WARNING_MESSAGE);
                }else{
                    // validation
                    int answer = JOptionPane.showConfirmDialog(null, "Are you sure you want to continue deleting customer data?", "Message", JOptionPane.YES_NO_OPTION);
                    if(answer == 0){
                        int customerID = Integer.valueOf(customerIdCustomerTxt.getText());

                        if(Model.DeleteCustomer(customerID)){
                            // Refresh table
                            dispose(); // close window
                            Controller.showCustomer(); // open window again to refresh table
                            clearTextField(); // Delete the text in the text field
                            JOptionPane.showMessageDialog(null, "Successfully deleted customer data", "Message", JOptionPane.INFORMATION_MESSAGE);
                        }else{
                            JOptionPane.showMessageDialog(null, "Failed to delete customer data", "Message", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        });
        
//        addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosed(WindowEvent e) {
//                remove(searchCustomerCb);
//                remove(searchCustomerTxt);
//                remove(searchCustomerBtn);
//                revalidate();
//                repaint();
//            }
//        });
    }
    
    public void clearTextField(){
        bookIdManageBookTxt.setText(null);
        titleManageBookTxt.setText(null);
        authorManageBookTxt.setText(null);
        publisherManageBookTxt.setText(null);
        bookTypeManageBookTxt.setText(null);
        quantityManageBookTxt.setText(null);
        bookIdBorrowBookTxt.setText(null);
        customerIdBorrowBookTxt.setText(null);
        issueDateBorrowBookTxt.setText(null);
        dueDateBorrowBookTxt.setText(null);
        bookIdReturnBookTxt.setText(null);
        customerIdReturnBookTxt.setText(null);
        customerIdCustomerTxt.setText(null);
        nameCustomerTxt.setText(null);
        phoneNumberCustomerTxt.setText(null);
    }
    
    
    
}
