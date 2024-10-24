package airlinemanagmentsystem;
import java.sql.*;

public class Conn {
    Connection c;
    Statement s;
    
    public Conn(){
        try{
            // step 1: register driver 
            Class.forName("com.mysql.cj.jdbc.Driver");
            // step 2 create the connection string 
            c=DriverManager.getConnection("jdbc:mysql:///airlinemanagementsystem","root","zxcvbnm,./123");
            //step 3 : create stament
            s=c.createStatement();
            // step 4 : run sql query
            
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] main){
        new Conn();
    }
}



//
//package airlinemanagmentsystem;
//import java.sql.*;
//
//public class Conn {
//    Connection c;
//    Statement s;
//    
//    public Conn() {
//        try {
//            // Step 1: Register driver
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            // Step 2: Create the connection string (adjust the URL if needed)
//            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlinemanagementsystem", "root", "zxcvbnm,./123");
//            // Step 3: Create statement
//            s = c.createStatement();
//        } catch (ClassNotFoundException e) {
//            System.out.println("MySQL JDBC Driver not found!");
//            e.printStackTrace();
//        } catch (SQLException e) {
//            System.out.println("Failed to connect to the database!");
//            e.printStackTrace();
//        }
//    }
//
//    public static void main(String[] args) {
//        new Conn(); // Test the connection when running this class
//    }
//}
//