package com.program;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class Model {
    
    // constructor
    public Model(){
        
    }
    
    
    private static final String DB_URL = "jdbc:mysql://localhost:3306/ivander_librarydb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    private static Connection connect;
    private static Statement statement;
    
    // method connection
    private static void connection(){
        try {
          connect = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (Exception e) {
          e.printStackTrace();
        }
    }
    
    // ========= Table =========
    public static DefaultTableModel getAllViewAllRecord(){
        connection();

        String[] dataHeader = {"Issue ID", "Book Name", "Customer Name", "Issue Date", "Due Date", "Status"};
        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        try {
          // buat object statement yang ambil dari koneksi
          statement = connect.createStatement();

          // query select
          String query = "SELECT issue_book.id_issue, book.title, customer.name, issue_book.issue_date, issue_book.due_date, issue_book.status FROM issue_book JOIN book ON issue_book.book_id = book.id_book JOIN customer ON issue_book.customer_id = customer.id_customer";

          // eksekusi query-nya
          ResultSet resultData = statement.executeQuery(query);

          // looping pengisian DefaultTableModel
          while( resultData.next() ){
            Object[] rowData = {resultData.getInt("id_issue"), resultData.getString("title"), resultData.getString("name"), resultData.getDate("issue_date"), resultData.getDate("due_date"), resultData.getString("status")};
            tm.addRow(rowData);
          }

          // close statement dan connection
          statement.close();
          connect.close();

        } catch (Exception e) {
          e.printStackTrace();
        }

        return tm;
    }

    public static DefaultTableModel getManageBook(){
        connection();

        String[] dataHeader = {"Book ID", "Title", "Author", "Publisher", "Book Type", "Quantity"};
        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        try {
          // buat object statement yang ambil dari koneksi
          statement = connect.createStatement();

          // query select
          String query = "SELECT * FROM `book`";

          // eksekusi query-nya
          ResultSet resultData = statement.executeQuery(query);

          // looping pengisian DefaultTableModel
          while( resultData.next() ){
            Object[] rowData = {resultData.getInt("id_book"), resultData.getString("title"), resultData.getString("author"), resultData.getString("publisher"), resultData.getString("book_type"), resultData.getInt("quantity")};
            tm.addRow(rowData);
          }

          // close statement dan connection
          statement.close();
          connect.close();

        } catch (Exception e) {
          e.printStackTrace();
            System.out.println("gagal manage book");
        }

        return tm;
    }
    
    public static DefaultTableModel getCustomer(){
        connection();

        String[] dataHeader = {"Customer ID", "Name", "Phone Number", "Gender", "Registration Date"};
        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        try {
          // buat object statement yang ambil dari koneksi
          statement = connect.createStatement();

          // query select
          String query = "SELECT * FROM `customer`";

          // eksekusi query-nya
          ResultSet resultData = statement.executeQuery(query);

          // looping pengisian DefaultTableModel
          while( resultData.next() ){
            Object[] rowData = {resultData.getInt("id_customer"), resultData.getString("name"), resultData.getString("phone_number"), resultData.getString("gender"), resultData.getDate("registration_date")};
            tm.addRow(rowData);
          }

          // close statement dan connection
          statement.close();
          connect.close();

        } catch (Exception e) {
          e.printStackTrace();
        }

        return tm;
    }
    // ========= Table =========
    
    // window Create Account
    public static boolean SaveCreateAccount (String username, String password, String email, String phoneNumber){
        boolean data = false;
        connection();

        try {

          // buat object statement yang ambil dari koneksi
          statement = connect.createStatement();

          // query select
          String query = "INSERT INTO `administrator`(`id_administrator`, `username`, `password`, `email`, `phone_number`) VALUES (null, '"+ username +"', '"+ password +"', '"+ email +"', '"+ phoneNumber +"')";

          if( statement.executeUpdate(query) > 0 ){
            data = true;
          }

          // close statement dan connection
          statement.close();
          connect.close();

        } catch (Exception e) {
          e.printStackTrace();
        }
        
        return data;
    }
    
    public static boolean ValidationUsernameCreateAccount(String username){
        connection();
        boolean validation = false;

        try {

          // buat object statement yang ambil dari koneksi
          statement = connect.createStatement();

          // query select
          String query = "SELECT COUNT(*) FROM `administrator` WHERE `username` = '"+ username +"'";

          // eksekusi query-nya
          ResultSet resultData = statement.executeQuery(query);

          // looping pengisian DefaultTableModel
          resultData.next();
          if(resultData.getInt(1) != 0) validation = true; // exist

          // close statement dan connection
          statement.close();
          connect.close();

        } catch (Exception e) {
          e.printStackTrace();
        }
        return validation;
    }
    
    public static boolean ValidationUsernamePasswordLogIn(String username, String password){
        connection();
        boolean validation = false;

        try {

          // buat object statement yang ambil dari koneksi
          statement = connect.createStatement();

          // query select
          String query = "SELECT COUNT(*) FROM `administrator` WHERE username = '"+ username +"' AND password = '"+ password +"'";

          // eksekusi query-nya
          ResultSet resultData = statement.executeQuery(query);

          // looping pengisian DefaultTableModel
          resultData.next();
          if(resultData.getInt(1) != 0) validation = true; // exist

          // close statement dan connection
          statement.close();
          connect.close();

        } catch (Exception e) {
          e.printStackTrace();
        }
        return validation;
    }
    
    // window manage book
    public static boolean SaveManageBook (String title, String author, String publisher, String bookType, int quantity){
        boolean data = false;
        connection();

        try {

          // buat object statement yang ambil dari koneksi
          statement = connect.createStatement();

          // query select
          String query = "INSERT INTO `book`(`id_book`, `title`, `author`, `publisher`, `book_type`, `quantity`) VALUES (null, '"+ title +"', '"+ author +"', '"+ publisher +"', '"+ bookType +"', "+ quantity +")";

          if( statement.executeUpdate(query) > 0 ){
            data = true;
          }

          // close statement dan connection
          statement.close();
          connect.close();

        } catch (Exception e) {
          e.printStackTrace();
        }
        
        return data;
    }
    
    public static boolean UpdateManageBook (int bookID, String title, String author, String publisher, String bookType, int quantity){
        boolean data = false;
        connection();

        try {

          // buat object statement yang ambil dari koneksi
          statement = connect.createStatement();

          // query select
          String query = "UPDATE `book` SET `title`='" + title + "',`author`='" + author + "',`publisher`='" + publisher + "',`book_type`='" + bookType + "',`quantity`='" + quantity + "' WHERE id_book = " +  bookID;

          if( statement.executeUpdate(query) > 0 ){
            data = true;
          }

          // close statement dan connection
          statement.close();
          connect.close();

        } catch (Exception e) {
          e.printStackTrace();
        }
        
        return data;
    }
    
    public static boolean DeleteManageBook (int bookID){
        boolean data = false;
        connection();

        try {
          // buat object statement yang ambil dari koneksi
          statement = connect.createStatement();

          // query select
          String query = "DELETE FROM `book` WHERE id_book = " + bookID;

          if( statement.executeUpdate(query) > 0 ){
            data = true;
          }

          // close statement dan connection
          statement.close();
          connect.close();

        } catch (Exception e) {
          e.printStackTrace();
        }
        
        return data;
    }
    
    // window customer
    public static boolean SaveCustomer (String name, String phoneNumber, String gender){
        boolean data = false;
        connection();

        try {

          // buat object statement yang ambil dari koneksi
          statement = connect.createStatement();

          // query select
          String query = "INSERT INTO `customer`(`id_customer`, `name`, `phone_number`, `gender`, `registration_date`) VALUES (null, '"+ name +"','"+ phoneNumber +"','"+ gender +"',CURRENT_DATE)";

          if( statement.executeUpdate(query) > 0 ){
            data = true;
          }

          // close statement dan connection
          statement.close();
          connect.close();

        } catch (Exception e) {
          e.printStackTrace();
        }
        
        return data;
    }
    
    public static boolean UpdateCustomer (int customerID, String name, String phoneNumber, String gender){
        boolean data = false;
        connection();

        try {

          // buat object statement yang ambil dari koneksi
          statement = connect.createStatement();

          // query select
          String query = "UPDATE `customer` SET `name`='"+ name +"',`phone_number`='"+ phoneNumber +"',`gender`='"+ gender +"' WHERE `id_customer`= "+  customerID;

          if( statement.executeUpdate(query) > 0 ){
            data = true;
          }

          // close statement dan connection
          statement.close();
          connect.close();

        } catch (Exception e) {
          e.printStackTrace();
        }
        
        return data;
    }
    
    public static boolean DeleteCustomer (int customerID){
        boolean data = false;
        connection();

        System.out.println("1percobaan delet");
        try {
          // buat object statement yang ambil dari koneksi
          statement = connect.createStatement();
            System.out.println("2percobaan delet");
          // query select
          String query = "DELETE FROM `customer` WHERE `id_customer` = " + customerID;

          if( statement.executeUpdate(query) > 0 ){
            data = true;
          }

          // close statement dan connection
          statement.close();
          connect.close();

        } catch (Exception e) {
          e.printStackTrace();
        }
        
        return data;
    }
    
    // window view all record (search)
    public static DefaultTableModel getSearchAllViewAllRecord( String comboBox, String keyword){
        connection();

        String[] dataHeader = {"Issue ID", "Book Name", "Customer Name", "Issue Date", "Due Date", "Status"};
        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        try {
          // buat object statement yang ambil dari koneksi
          statement = connect.createStatement();

          // query select
          String query = "SELECT issue_book.id_issue, book.title, customer.name, issue_book.issue_date, issue_book.due_date, issue_book.status FROM issue_book JOIN book ON issue_book.book_id = book.id_book JOIN customer ON issue_book.customer_id = customer.id_customer WHERE "+ comboBox +" LIKE '%"+ keyword +"%'";
          // eksekusi query-nya
          ResultSet resultData = statement.executeQuery(query);

          // looping pengisian DefaultTableModel
          while( resultData.next() ){
            Object[] rowData = {resultData.getInt("id_issue"), resultData.getString("title"), resultData.getString("name"), resultData.getDate("issue_date"), resultData.getDate("due_date"), resultData.getString("status")};
            tm.addRow(rowData);
          }

          // close statement dan connection
          statement.close();
          connect.close();

        } catch (Exception e) {
          e.printStackTrace();
        }

        return tm;

      }
    
    public static DefaultTableModel getSearchStatusViewAllRecord(String status, String comboBox, String keyword){
        connection();

        String[] dataHeader = {"Issue ID", "Book Name", "Customer Name", "Issue Date", "Due Date", "Status"};
        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        try {
          // buat object statement yang ambil dari koneksi
          statement = connect.createStatement();

          // query select
          String query = "SELECT issue_book.id_issue, book.title, customer.name, issue_book.issue_date, issue_book.due_date, issue_book.status FROM issue_book JOIN book ON issue_book.book_id = book.id_book JOIN customer ON issue_book.customer_id = customer.id_customer "+ comboBox +" LIKE '%"+ keyword +"%' AND issue_book.status = '"+ status +"'";
          // eksekusi query-nya
          ResultSet resultData = statement.executeQuery(query);

          // looping pengisian DefaultTableModel
          while( resultData.next() ){
            Object[] rowData = {resultData.getInt("id_issue"), resultData.getString("title"), resultData.getString("name"), resultData.getDate("issue_date"), resultData.getDate("due_date"), resultData.getString("status")};
            tm.addRow(rowData);
          }

          // close statement dan connection
          statement.close();
          connect.close();

        } catch (Exception e) {
          e.printStackTrace();
        }

        return tm;

      }
    
    // window manage book (search)
    public static DefaultTableModel getSearchManageBook( String comboBox, String keyword){
        connection();

        String[] dataHeader = {"Book ID", "Title", "Author", "Publisher", "Book Type", "Quantity"};
        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);
        
        try {
          // buat object statement yang ambil dari koneksi
          statement = connect.createStatement();

          // query select 
          String query = "SELECT * FROM `book` WHERE "+ comboBox +" LIKE '%"+ keyword +"%'";
          // eksekusi query-nya
          ResultSet resultData = statement.executeQuery(query);

          // looping pengisian DefaultTableModel
          while( resultData.next() ){
            Object[] rowData = {resultData.getInt("id_book"), resultData.getString("title"), resultData.getString("author"), resultData.getString("publisher"), resultData.getString("book_type"), resultData.getInt("quantity")};
            tm.addRow(rowData);
          }

          // close statement dan connection
          statement.close();
          connect.close();

        } catch (Exception e) {
          e.printStackTrace();
        }

        return tm;

    }
    
    // window customer (search)
    public static DefaultTableModel getSearchCustomer( String comboBox, String keyword){
        connection();

        String[] dataHeader = {"Customer ID", "Name", "Phone Number", "Gender", "Registration Date"};
        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        try {
          // buat object statement yang ambil dari koneksi
          statement = connect.createStatement();

          // query select
          String query = "SELECT * FROM `customer` WHERE "+ comboBox +" LIKE '%"+ keyword +"%'";
          // eksekusi query-nya
          ResultSet resultData = statement.executeQuery(query);

          // looping pengisian DefaultTableModel
          while( resultData.next() ){
            Object[] rowData = {resultData.getInt("id_customer"), resultData.getString("name"), resultData.getString("phone_number"), resultData.getString("gender"), resultData.getDate("registration_date")};
            tm.addRow(rowData);
          }

          // close statement dan connection
          statement.close();
          connect.close();

        } catch (Exception e) {
          e.printStackTrace();
        }

        return tm;

    }
    
    // count for  window home page
      public static int getCountNoOfBooks(){
        connection();
        int count = -1;

        try {

          // buat object statement yang ambil dari koneksi
          statement = connect.createStatement();

          // query select
          String query = "SELECT COUNT(*) FROM `book`";

          // eksekusi query-nya
          ResultSet resultData = statement.executeQuery(query);

          // looping pengisian DefaultTableModel
          resultData.next();
          count = resultData.getInt(1);

          // close statement dan connection
          statement.close();
          connect.close();

        } catch (Exception e) {
          e.printStackTrace();
        }
        return count;
      }
      
      public static int getCountNoOfCustomers(){
        connection();
        int count = -1;

        try {

          // buat object statement yang ambil dari koneksi
          statement = connect.createStatement();

          // query select
          String query = "SELECT COUNT(*) FROM `customer`";

          // eksekusi query-nya
          ResultSet resultData = statement.executeQuery(query);

          // looping pengisian DefaultTableModel
          resultData.next();
          count = resultData.getInt(1);

          // close statement dan connection
          statement.close();
          connect.close();

        } catch (Exception e) {
          e.printStackTrace();
        }
        return count;
      }
    
      public static int getCountNoOfBorrowings(){
        connection();
        int count = -1;

        try {

          // buat object statement yang ambil dari koneksi
          statement = connect.createStatement();

          // query select
          String query = "SELECT COUNT(*) FROM `issue_book`";

          // eksekusi query-nya
          ResultSet resultData = statement.executeQuery(query);

          // looping pengisian DefaultTableModel
          resultData.next();
          count = resultData.getInt(1);

          // close statement dan connection
          statement.close();
          connect.close();

        } catch (Exception e) {
          e.printStackTrace();
        }
        return count;
      }
    
      public static int getCountNoOfReturn(){
        connection();
        int count = -1;

        try {

          // buat object statement yang ambil dari koneksi
          statement = connect.createStatement();

          // query select
          String query = "SELECT COUNT(*) FROM `issue_book` WHERE status ='Issued'";

          // eksekusi query-nya
          ResultSet resultData = statement.executeQuery(query);

          // looping pengisian DefaultTableModel
          resultData.next();
          count = resultData.getInt(1);

          // close statement dan connection
          statement.close();
          connect.close();

        } catch (Exception e) {
          e.printStackTrace();
        }
        return count;
      }
    
      public static int getCountBooksOnLoan(){
        connection();
        int count = -1;

        try {

          // buat object statement yang ambil dari koneksi
          statement = connect.createStatement();

          // query select
          String query = "SELECT COUNT(*) FROM `issue_book` WHERE status ='Returned'";

          // eksekusi query-nya
          ResultSet resultData = statement.executeQuery(query);

          // looping pengisian DefaultTableModel
          resultData.next();
          count = resultData.getInt(1);

          // close statement dan connection
          statement.close();
          connect.close();

        } catch (Exception e) {
          e.printStackTrace();
        }
        return count;
      }
    
}
