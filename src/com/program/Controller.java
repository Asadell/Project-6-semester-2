package com.program;


import com.views.ActionFrameView;
import com.views.DashboardView;
import com.views.StartView;
import static com.views.StartView.usernameLogin;

/**
 *
 * @author HP
 */
public class Controller {

    private static StartView frameLoginAndCreateAccount = new StartView();
    private static ActionFrameView actionFrame = new ActionFrameView();
    private static String username;
    
    public static void showLogin(){
        frameLoginAndCreateAccount.setVisible(false);
        frameLoginAndCreateAccount.initsLogin();
        frameLoginAndCreateAccount.setVisible(true);
    }
    
    public static void showCreateAccount(){
        frameLoginAndCreateAccount.setVisible(false);
        frameLoginAndCreateAccount.initsCreateAccount();
        frameLoginAndCreateAccount.setVisible(true);
    }
    
    public static void showHomePage(){
        username = frameLoginAndCreateAccount.usernameLogin;
        DashboardView dashboardView = new DashboardView(username);
        dashboardView.setVisible(true);
    }
    
    // ===
    public static void showManageBook(){
        actionFrame.setVisible(false);
        actionFrame.initsManageBook();
        actionFrame.setVisible(true);
    }
    
    public static void showBorrowBook(){
        actionFrame.setVisible(false);
        actionFrame.initsBorrowBook();
        actionFrame.setVisible(true);
    }
    
    public static void showReturnBook(){
        actionFrame.setVisible(false);
        actionFrame.initsReturnBook();
        actionFrame.setVisible(true);
    }
    
    public static void showCustomer(){
        actionFrame.setVisible(false);
        actionFrame.initsCustomer();
        actionFrame.setVisible(true);
    }
    
}
