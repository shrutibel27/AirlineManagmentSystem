package airlinemanagmentsystem;
import java.util.*;
import javax.swing.*;   
import java.awt.*;       
import java.awt.event.*;  
import java.sql.*; 
import net.proteanit.sql.DbUtils;


public class JourneyDetails extends JFrame implements ActionListener{
    public JourneyDetails(){
        //2
        getContentPane().setBackground(Color.GRAY);
        setLayout(null);
        
        //3
        JTable  table=new JTable();
        try{
            Conn conn=new Conn();
            ResultSet rs=conn.s.executeQuery("select * from FlightDetails");
            //use jarfile to print result in table format 

            
            //method 
//            int rows=0,colms=0;
//             int array_2D [rows][colms];
//             for(){
//                 for(){
//                     arr[rows][colm]=data;
//                     colm++;
//                 }
//             }
             
            
        }catch(Exception ae){
            ae.printStackTrace();
        }
        
        
        //1
        setSize(800,500);
        setLocation(400,200);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        
    }
    public static void main(String[] args){
        new JourneyDetails();
    }
}
