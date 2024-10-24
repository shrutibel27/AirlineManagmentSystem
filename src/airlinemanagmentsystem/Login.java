//C:\Users\TATA\Documents\NetBeansProjects\AirlineManagmentSystem\src\airlinemanagmentsystem\Login.java
package airlinemanagmentsystem;
import java.util.*;
import javax.swing.*;   // all classes strat with J later
import java.awt.*;      // including class like : color 
import java.awt.event.*;  // include actionlistener interface 
import java.sql.*; // ResultSet class
                   // JFreame class in swing package  // actionlistener is a interface in awt .event package  .. use to take action when we click on something
public class Login extends JFrame implements ActionListener {
    
    // to use buttons globally 
        JButton Submit,close,reset;
        JTextField tfusername;
        JPasswordField tfpassword;
        
    // defalut constructor
    public Login(){
        
        //step-4
        getContentPane().setBackground(Color.WHITE);
        
        //step-5
        setLayout(null);
        
        JLabel Iblusername =new JLabel("Username"); //step-6
        Iblusername.setBounds(20,20,100,20);   //step-7
        add(Iblusername); //step-8
        // step 9
        JLabel IblPassword =new JLabel("Password"); //step-6
        IblPassword.setBounds(20,90,100,20);   //step-7
        add(IblPassword); //step-8
        
        // step 10
        tfusername=new JTextField();
        tfusername.setBounds(130,20,200,20);
        add(tfusername);
        // step 11
        tfpassword=new JPasswordField();
        tfpassword.setBounds(130,90,200,20);
        add(tfpassword);
        
        // step 12 : button
//        JButton reset=new JButton("Reset"); we not need to declare this variable again , if we declare again then it take localy 
        reset=new JButton("Reset");
        reset.setBounds(20,150,80,20);
        reset.addActionListener(this); //step 16 to triger action add addActionListener function with passing current class refrance
        add(reset);
        //step 13
        Submit=new JButton("Submit");
        Submit.setBounds(130,150,80,20);
        Submit.addActionListener(this); //step 17
        add(Submit);
        //step 14
        close=new JButton("close");
        close.setBounds(240,150,90,20);
        close.addActionListener(this); //step 18
        add(close);
        
        // step 15 
        // to happen actions when user click on buttons use ActionListener interface 
        // to create ActionListner interface override actionPerformed function
        //in actionPerformed function write all actions of buttons and all th things
        
        setSize(400,250); //step-2
        setLocation(600,250); //step-3
        setVisible(true); //step-1
        

        
        //step 1 : bydefalut all created frames are invisible but by usng this method these frames are visible 
        
        // step 2
        // bydefaluts frame size is too small so for frandly visibility we
        // set size by using setSize(horizontal length,vertical height)
        
        //step-3
        //by defalut frame open in top left size becuse this is origin but 
        //if we want to change location we use setLocation(dist from left, dist from top)
        
        //step 4
        // defalut colour of frame is gray 
        // we can change colur by using function : getContentPane().setBackground(colour:color) 
        // colour class is in AWT package 
        //getContentPane() : by using this 1st we get whole frame 
        
        //step 5 : if we write setLayout(null) then we need to write self layout every time 
       // step 6: by using label, write anything on frame
       // step 7:
         // their are multiple method of layout to set his label on frame
         // if we not use any layout , they use border layout 
         // but we already write setLayout(null) so we need to write out layout
         // to set label on frame use function 
         //setBounds(distance from screen to left,distance from screen to top, length of label, height of label) 
       // step 8: using setBound , it set label but not visible so for this we use add funvtion 
       
       // step 10:
       // we want to create input boxes
       // inputField : textFiled and class for textField is JTextField()
       // when user enter text it see on screen 
       // step 11 but if user enter passwords then this is not visible in screen by using JPasswordField() class
       
    }
   
    
    //override this method to implement ActionListener interface 
    // we can define action of button in this method 
    public void actionPerformed(ActionEvent e){
        if(e.getSource()== Submit){
            String username = tfusername.getText();
            String Password= tfpassword.getText();
            
            try{
                Conn c =new Conn();
                String query="select * from login where username = '"+username+"' and password = '"+Password+"'";
                ResultSet rs=c.s.executeQuery(query);
                
                if(rs.next()){
                    new HomePage();
                    setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Invalid Username or Password !!!");
//                    setVisible(false);   
                }
                
            } catch (Exception ae){
                ae.printStackTrace();
            }
            
        }
        else if(e.getSource()== close){
            setVisible(false);
        }
        else if(e.getSource()== reset){
            tfpassword.setText("");
            tfusername.setText("");
        }
    }
    
    public static void main(String[] args){
        new Login(); //anonomus object so call defalut constructor
    }
}
