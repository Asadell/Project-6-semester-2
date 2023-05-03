package com.program;

import com.templates.ActionFrame;
import com.templates.DashboardFrame;
import com.templates.StartFrame;
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        System.out.println("halo");
        
        // buka komennya gantian
        
//        Controller.showLogin();
//        Controller.showCreateAccount();
        
//        Controller.showHomePage();
        
        
//        Controller.showManageBook();
//        Controller.showBorrowBook();
//        Controller.showReturnBook();
//        Controller.showCustomer();
        
        // ini udah gabisa lagi, karena class template sudah jadi abstract (blum si)
        // frame start
//        new StartFrame(); 
        
        // frame dashboard
//        new DashboardFrame();

        // frame yang ketiga
        new ActionFrame();

        System.out.println("2halo");
    }
}