package airlinemanagmentsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.EventListener;
import java.sql.*;

public class AddCustomer extends JFrame implements ActionListener{
    
    JLabel heading,lbphn,lbname,lbnationality,lbadhar,lbgender,lbaddress,ibimage;
    JTextField tfnationality,tfname,tfAdhar,tfaddress,tfphn;
    ImageIcon image;
    JRadioButton rbmale,rbfemale;
    JButton save;
            
    public AddCustomer(){
        //2
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        //3
        heading=new JLabel("ADD CUSTOMER DETAILS");
        heading.setBounds(220,20,500,35);
        heading.setFont(new Font("Tahoma",Font.PLAIN,32));
        heading.setForeground(Color.BLUE);
        add(heading);
        
        
        //4.1 enter name
        lbname=new JLabel("Name:");
        lbname.setBounds(80,80,200,25);
        lbname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbname);
        //4.2
        tfname=new JTextField();
        tfname.setBounds(210,80,300,25);
        add(tfname);
        
        //5.1 enter nationality
        lbnationality=new JLabel("Nationality:");
        lbnationality.setBounds(80,130,200,25);
        lbnationality.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbnationality);
        //5.2
        tfnationality=new JTextField();
        tfnationality.setBounds(210,130,150,25);
        add(tfnationality);
        
        //6.1 enter adhar number
        lbadhar=new JLabel("Adhar Number :");
        lbadhar.setBounds(80,180,200,25);
        lbadhar.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbadhar);
        //6.2
        tfAdhar=new JTextField();
        tfAdhar.setBounds(210,180,150,25);
        add(tfAdhar);
        
        
        //7.1 enter address
        lbaddress=new JLabel("Address:");
        lbaddress.setBounds(80,230,200,25);
        lbaddress.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbaddress);
        //7.2
        tfaddress=new JTextField();
        tfaddress.setBounds(210,230,150,25);
        add(tfaddress);
        
        //8.1 enter gender (radio button : male or female)
        lbgender=new JLabel("Gender");
        lbgender.setBounds(80,280,200,25);
        lbgender.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbgender);
        // use to group female and male 
        ButtonGroup gendergroup=new ButtonGroup();
        //8.2
        rbmale=new JRadioButton("Male");
        rbmale.setBounds(210,280,70,25);
        rbmale.setBackground(Color.WHITE);
        add(rbmale);
        //8.3
        rbfemale=new JRadioButton("Female");
        rbfemale.setBounds(310,280,70,25);
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);
        //8.4
        gendergroup.add(rbmale); 
        gendergroup.add(rbfemale);
        
        //9
        lbphn=new JLabel("phone number: ");
        lbphn.setBounds(80,330,200,25);
        lbphn.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbphn);
        //9.2
        tfphn=new JTextField();
        tfphn.setBounds(210,330,150,25);
        add(tfphn);
        
        //10
        save=new JButton("Save: ");
        save.setBackground(Color.BLACK);
        save.setForeground(Color.WHITE);
        save.setBounds(220,380,150,30);
        add(save);
        save.addActionListener(this);
        add(save);
        
        //11 add image
        image=new ImageIcon(ClassLoader.getSystemResource("airlinemanagmentsystem/icons/emp.png"));
        ibimage=new JLabel(image);
        ibimage.setBounds(500,80,280,400);
        add(ibimage);
        
        //1
        setSize(900,600);
        setLocation(300,150);
        setVisible(true);
    }
    

    public void actionPerformed(ActionEvent e){
        String name=tfname.getText();
        String nationality=tfnationality.getText();
        String phone=tfphn.getText();
        String address=tfaddress.getText();
        String aadhar=tfAdhar.getText();
        String gender=null;
        if(rbmale.isSelected()){
            gender="Male";
        }
        else{
            gender="Female";
        }
        
        
        
        try{
            Conn conn=new Conn();
            String query="insert into passenger values('"+name+"','"+nationality+"','"+phone+"','"+address+"','"+aadhar+"','"+gender+"')";
            conn.s.executeUpdate(query);  // bex insert is dml query
//            JOptionPane.showMessageDialog(null,"Customer Details Added Sucessfullt!!");
            int choice = JOptionPane.showOptionDialog(
                null, 
                "Customer Details Added Successfully!!", 
                "Confirmation", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.INFORMATION_MESSAGE, 
                null, 
                new String[]{"Add Customer", "Close"}, 
                null
            );

            if (choice == JOptionPane.YES_OPTION) {
                // If "Add Customer" is clicked, reset the form
//                new AddCustomer();
//                  setVisible(false);
                    resetForm();
            } else {
                // If "Close" is clicked, close the frame and go back to HomePage
                this.dispose();
                setVisible(false);
            }
            
        }catch(Exception ae){
            ae.printStackTrace();
        }
    }
    
    
     // Method to reset the form fields
    public void resetForm() {
        tfname.setText("");
        tfnationality.setText("");
        tfphn.setText("");
        tfaddress.setText("");
        tfAdhar.setText("");
        rbmale.setSelected(false);
        rbfemale.setSelected(false);
    }

    public static void main(String[] args){
        new AddCustomer();
    }
}
