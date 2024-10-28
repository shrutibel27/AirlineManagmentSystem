//package airlinemanagmentsystem;
//import java.util.*;
//import javax.swing.*;   // all classes strat with J later
//import java.awt.*;       // including class like : color 
//import java.awt.event.*;  // include actionlistener interface 
//import java.sql.*; // ResultSet class
////from AddCustomer import AddCustomer;
//// JFreame class in swing package  // actionlistener is a interface in awt .event package  .. use to take action when we click on something
//public class HomePage extends JFrame implements ActionListener {
//
//    JMenuItem CustomerDetails;
//   public HomePage(){
//        setLayout(null);
//        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("airlinemanagmentsystem/icons/front.jpg"));
//        JLabel image=new JLabel(i1);
//        image.setBounds(0,0,1600,800);
//        add(image);
//        
//        JLabel heading=new JLabel("AIR INDIA WELCOME YOU");
//        heading.setBounds(600,40,1000,40);
//        heading.setForeground(Color.BLUE);
//        heading.setFont(new Font("Tahoma",Font.PLAIN,36));
//        image.add(heading);
//        
//        //1.
//        JMenuBar menubar=new JMenuBar();
//        setJMenuBar(menubar);
//        //2.
//        JMenu details=new JMenu("Details");
//        menubar.add(details);
//        //3.
//        JMenuItem flightDetails=new JMenu("Flight Details");
//        details.add(flightDetails);
//        //4
//        CustomerDetails=new JMenu("Add Customer Details");
//        details.add(CustomerDetails);
//        
//        //5
//        JMenuItem BookFlght=new JMenu("Book Flight");
//        details.add(BookFlght);
//        //6
//        JMenuItem JourneyDetails=new JMenu("Journey Details");
//        details.add(JourneyDetails);
//        //7
//        JMenuItem TicketCancellation=new JMenu("Cancel Ticket");
//        details.add(TicketCancellation);
//        
//        JMenu ticket=new JMenu("Ticket");
//        menubar.add(ticket);
//        //3.
//        JMenuItem boardingPass=new JMenu("Boarding Pass");
//        ticket.add(boardingPass);
//        
//
//        
//        
//        
//        setExtendedState(JFrame.MAXIMIZED_BOTH); //step-2 jframe.maximized_both use to cover  full screen
//        setVisible(true); //step-1
//    }
//   
//    
//    //override this method to implement ActionListener interface 
//    // we can define action of button in this method 
//    public void actionPerformed(ActionEvent e){
//        if(e.getSource()==CustomerDetails){
//            new AddCustomer();
//        }
//    }
//    
//    public static void main(String[] args){
//        new HomePage(); //anonomus object so call defalut constructor
//    }
//}

package airlinemanagmentsystem;

import java.util.*;
import javax.swing.*;   
import java.awt.*;       
import java.awt.event.*;  
import java.sql.*; 

public class HomePage extends JFrame implements ActionListener {

    JMenuItem customerDetails;  // Declare customerDetails as a global variable

    public HomePage() {
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagmentsystem/icons/front.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1600, 800);
        add(image);

        JLabel heading = new JLabel("AIR INDIA WELCOMES YOU");
        heading.setBounds(600, 40, 1000, 40);
        heading.setForeground(Color.BLUE);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 36));
        image.add(heading);

        //1. Create the menu bar
        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);

        //2. Add "Details" menu
        JMenu details = new JMenu("Details");
        menubar.add(details);

        //3. Create menu items
        JMenuItem flightDetails = new JMenuItem("Flight Details");
        flightDetails.addActionListener(this);
        details.add(flightDetails);
        
        //3.1
        customerDetails = new JMenuItem("Add Customer Details"); // Rename for consistency
        customerDetails.addActionListener(this); // Add action listener for this item
        details.add(customerDetails);
        //3.2
        JMenuItem bookFlight = new JMenuItem("Book Flight");
        details.add(bookFlight);

        JMenuItem journeyDetails = new JMenuItem("Journey Details");
        details.add(journeyDetails);

        JMenuItem ticketCancellation = new JMenuItem("Cancel Ticket");
        details.add(ticketCancellation);

        // Add "Ticket" menu
        JMenu ticket = new JMenu("Ticket");
        menubar.add(ticket);

        JMenuItem boardingPass = new JMenuItem("Boarding Pass");
        ticket.add(boardingPass);

        setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximizes the window
        setVisible(true); // Makes the window visible
    }

    // Implement the actionPerformed method to handle menu clicks
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == customerDetails) {
            // Open AddCustomer page when "Add Customer Details" is clicked
            new AddCustomer();  // Assuming AddCustomer.java has a constructor to open its frame
        }
    }

    public static void main(String[] args) {
        new HomePage(); // Create the HomePage window
    }
}
