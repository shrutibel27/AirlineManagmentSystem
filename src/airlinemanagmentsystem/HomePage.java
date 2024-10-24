package airlinemanagmentsystem;
import java.util.*;
import javax.swing.*;   // all classes strat with J later
import java.awt.*;      // including class like : color 
import java.awt.event.*;  // include actionlistener interface 
import java.sql.*; // ResultSet class
                   // JFreame class in swing package  // actionlistener is a interface in awt .event package  .. use to take action when we click on something
public class HomePage extends JFrame implements ActionListener {
    
   public HomePage(){
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("airlinemanagmentsystem/icons/front.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(0,0,1600,800);
        add(image);
        
        JLabel heading=new JLabel("AIR INDIA WELCOME YOU");
        heading.setBounds(600,40,1000,40);
        heading.setForeground(Color.BLUE);
        heading.setFont(new Font("Tahoma",Font.PLAIN,36));
        image.add(heading);
        
        //1.
        JMenuBar menubar=new JMenuBar();
        setJMenuBar(menubar);
        //2.
        JMenu details=new JMenu("Details");
        menubar.add(details);
        //3.
        JMenuItem flightDetails=new JMenu("Flight Details");
        details.add(flightDetails);
        //4
        JMenuItem CustomerDetails=new JMenu("Add Customer Details");
        details.add(CustomerDetails);
        //5
        JMenuItem BookFlght=new JMenu("Book Flight");
        details.add(BookFlght);
        //6
        JMenuItem JourneyDetails=new JMenu("Journey Details");
        details.add(JourneyDetails);
        //7
        JMenuItem TicketCancellation=new JMenu("Cancel Ticket");
        details.add(TicketCancellation);
        
        JMenu ticket=new JMenu("Ticket");
        menubar.add(ticket);
        //3.
        JMenuItem boardingPass=new JMenu("Boarding Pass");
        ticket.add(boardingPass);
        

        
        
        
        setExtendedState(JFrame.MAXIMIZED_BOTH); //step-2 jframe.maximized_both use to cover  full screen
        setVisible(true); //step-1
    }
   
    
    //override this method to implement ActionListener interface 
    // we can define action of button in this method 
    public void actionPerformed(ActionEvent e){
        
    }
    
    public static void main(String[] args){
        new HomePage(); //anonomus object so call defalut constructor
    }
}
