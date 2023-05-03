package com.views;

import com.partials.*;
import com.program.Controller;
import com.program.Model;
import com.templates.StartFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

/**
 * di class ini akan dibuat semua komponen yang dibutuhkan 
 * dimasing-masing window yang menggunakan template StartFrame.java
 * 
 */
public class StartView extends StartFrame{
    public static String usernameLogin;
    
    // ============= component =============
    // component of login admin
    private cFormLabelLogin usernameLoginLabel = new cFormLabelLogin("Username", 0, 140, 510, true);
    private cTextFieldLogin usernameLoginTxt = new cTextFieldLogin(88, 173, 334, true);
    private cFormLabelLogin passwordLoginLabel = new cFormLabelLogin("Password", 0, 224, 510, true);
    private cPasswordField passwordLoginTxt = new cPasswordField(88, 257, 334, true);
    private cButton submitLoginBtn = new cButton("Submit", 88, 338, 334);
    private cLinkStart toCreateAccountFromLogin = new cLinkStart("Create Account", 459);
    
    // component of create account
    private cFormLabelLogin usernameCreateAccountLabel = new cFormLabelLogin("Username", 0, 98, 510, true);
    private cTextFieldLogin usernameCreateAccountTxt = new cTextFieldLogin(88, 131, 334, true);
    private cFormLabelLogin passwordCreateAccountLabel = new cFormLabelLogin("Password", 0, 184, 510, true);
    private cTextFieldLogin passwordCreateAccountTxt = new cTextFieldLogin(88, 215, 334, true);
    private cFormLabelLogin emailCreateAccountLabel = new cFormLabelLogin("Email", 0, 270, 510, true);
    private cTextFieldLogin emailCreateAccountTxt = new cTextFieldLogin(88, 301, 334, true);
    private cFormLabelLogin phoneNumberCreateAccountLabel = new cFormLabelLogin("Phone Number", 0, 355, 510, true);
    private cTextFieldLogin phoneNumberCreateAccountTxt = new cTextFieldLogin(88, 385, 334, true);
    private cButton submitCreateAccountBtn = new cButton("Submit", 88, 456, 334);
    private cButton toLoginBtn = new cButton("Login", 88, 501, 334);
    // ============= component =============
    
    // ============= constructor =============
    public StartView(){
        super(); // to call default constructor from super class (extend)
        
        toCreateAccountFromLogin.addMouseListener( new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me){
                Controller.showCreateAccount();
            }
        });
        
    }
    // ============= constructor =============
    
    
    // method to call windows
    public void initsLogin(){
        cardLeft.removeAll(); // to clean up all the components in the cardleft panel
//        this.setTitle("Login"); // percuma ga keliatan juga karena pake .setUndecorated
        titleStart.setText("LOGIN");
        cardLeft.add(titleStart);
        
        cardLeft.add(usernameLoginLabel);
        cardLeft.add(usernameLoginTxt);
        cardLeft.add(passwordLoginLabel);
        cardLeft.add(passwordLoginTxt);
        cardLeft.add(submitLoginBtn);
        cardLeft.add(toCreateAccountFromLogin);
        
        submitLoginBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                
                usernameLogin = usernameLoginTxt.getText().trim();
                String password = new String(passwordLoginTxt.getPassword());
                    
                
                if(usernameLoginTxt.getText().isEmpty() || password.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Field cannot be empty", "Empty", JOptionPane.WARNING_MESSAGE);
                }
                else if(Model.ValidationUsernamePasswordLogIn(usernameLogin, password)){
                    //==
                    dispose(); // close frame
                    Controller.showHomePage();
                }else{
                    JOptionPane.showMessageDialog(null, "The username or password you entered is incorrect", "Message", JOptionPane.ERROR_MESSAGE);
                }
                
            }
        });
    }
    
    public void initsCreateAccount(){
        cardLeft.removeAll(); // to clean up all the components in the cardleft panel
//        this.setTitle("Login"); // percuma ga keliatan juga karena pake .setUndecorated
        titleStart.setText("CREATE ACCOUNT");
        
        cardLeft.add(titleStart);
        cardLeft.add(usernameCreateAccountLabel);
        cardLeft.add(usernameCreateAccountTxt);
        cardLeft.add(passwordCreateAccountLabel);
        cardLeft.add(passwordCreateAccountTxt);
        cardLeft.add(emailCreateAccountLabel);
        cardLeft.add(emailCreateAccountTxt);
        cardLeft.add(phoneNumberCreateAccountLabel);
        cardLeft.add(phoneNumberCreateAccountTxt);
        cardLeft.add(submitCreateAccountBtn);
        cardLeft.add(toLoginBtn);
        
        submitCreateAccountBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                String username = usernameCreateAccountTxt.getText().trim();
                // ==
                if(usernameCreateAccountTxt.getText().isEmpty() || passwordCreateAccountTxt.getText().isEmpty() || emailCreateAccountTxt.getText().isEmpty() || phoneNumberCreateAccountTxt.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Field cannot be empty", "Empty", JOptionPane.WARNING_MESSAGE);
                }else if(Model.ValidationUsernameCreateAccount(username)){
                    JOptionPane.showMessageDialog(null, "Username is already in use", "Validation", JOptionPane.WARNING_MESSAGE);
                }else{  
                    String password = passwordCreateAccountTxt.getText().trim();
                    String email = emailCreateAccountTxt.getText().trim();
                    String phoneNumber = phoneNumberCreateAccountTxt.getText().trim();

                    if(Model.SaveCreateAccount(username, password, email, phoneNumber)){
                        // Refresh table
                        dispose(); // close window
                        Controller.showLogin(); // open window again to refresh table
                        clearTextField(); // Delete the text in text field
                        JOptionPane.showMessageDialog(null, "Successfully created account", "Message", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(null, "Failed to create account", "Message", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        
        toLoginBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                dispose(); // menutup frame
                Controller.showLogin();  // just back to login window
            }
        });
    }
    
    public void clearTextField(){
        usernameLoginTxt.setText(null);
        passwordLoginTxt.setText(null);
        passwordCreateAccountTxt.setText(null);
        usernameCreateAccountTxt.setText(null);
        emailCreateAccountTxt.setText(null);
        phoneNumberCreateAccountTxt.setText(null);
    }
    
}
