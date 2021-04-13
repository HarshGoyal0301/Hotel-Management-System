
package hotel.management.system;


import java.awt.EventQueue;


import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class AddEmployee extends JFrame implements ActionListener{ 

    
	JTextField textField,textField_1,textField_2,textField_3,textField_4,textField_5,textField_6;
        JComboBox c1;
        JRadioButton male,female;

        public AddEmployee(){
            getContentPane().setForeground(Color.BLUE);
            getContentPane().setBackground(Color.WHITE);
            setTitle("ADD EMPLOYEE DETAILS");
		 
            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            setSize(778,486);
            getContentPane().setLayout(null);
			
            JLabel name = new JLabel("NAME");
            name.setFont(new Font("Tahoma", Font.PLAIN, 17));
            name.setBounds(60, 30, 150, 27);
            add(name);
            
            textField = new JTextField();
            textField.setBounds(200, 30, 150, 27);
            add(textField);
			
            JButton Next = new JButton("SAVE");
            Next.setBounds(200, 420, 150, 30);
            Next.setBackground(Color.BLACK);
            Next.setForeground(Color.WHITE);
            Next.addActionListener(this);
            add(Next);
			
            JLabel age = new JLabel("AGE");
            age.setFont(new Font("Tahoma", Font.PLAIN, 17));
            age.setBounds(60, 80, 150, 27);
            add(age);
			
            textField_1 = new JTextField();
            textField_1.setBounds(200, 80, 150, 27);
            add(textField_1);
            
            JLabel Gender = new JLabel("GENDER");
            Gender.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Gender.setBounds(60, 120, 150, 27);
            add(Gender);
		
          male = new JRadioButton("MALE");
            male.setBackground(Color.WHITE);
            male.setBounds(200, 120, 70, 27);
            add(male);
	
             female = new JRadioButton("FEMALE");
            female.setBackground(Color.WHITE);
            female.setBounds(280, 120, 100, 27);
            add(female);
            
            
            JLabel Address = new JLabel("JOB");
            Address.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Address.setBounds(60, 170, 150, 27);
            add(Address);
			
            String course[] = {"Front Desk Clerks","Porters","Housekeeping","Kitchen Staff","Room Service","Waiter/Waitress","Manager","Accountant","Chef"};
            c1 = new JComboBox(course);
            c1.setBackground(Color.WHITE);
            c1.setBounds(200,170,150,30);
            add(c1);
            		
            JLabel salary = new JLabel("SALARY");
            salary.setFont(new Font("Tahoma", Font.PLAIN, 17));
            salary.setBounds(60, 220, 150, 27);
            add(salary);
			
            textField_3 = new JTextField();
            textField_3.setBounds(200, 220, 150, 27);
            add(textField_3);
	
            JLabel pno = new JLabel("PHONE");
            pno.setFont(new Font("Tahoma", Font.PLAIN, 17));
            pno.setBounds(60, 270, 150, 27);
            add(pno);
	
            textField_4 = new JTextField();
            textField_4.setBounds(200, 270, 150, 27);
            add(textField_4);
	
            JLabel aid = new JLabel("AADHAR");
            aid.setFont(new Font("Tahoma", Font.PLAIN, 17));
            aid.setBounds(60, 320, 150, 27);
            add(aid);
			
            textField_5 = new JTextField();
            textField_5.setBounds(200, 320, 150, 27);
            add(textField_5);
            
	
            
           
	
        
	
            JLabel Addemp = new JLabel("ADD EMPLOYEE DETAILS");
            Addemp.setForeground(Color.BLUE);
            Addemp.setFont(new Font("Tahoma", Font.PLAIN, 31));
            Addemp.setBounds(450, 24, 442, 35);
            add(Addemp);
			
     
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/tenth.jpg"));
            Image i3 = i1.getImage().getScaledInstance(500, 500,Image.SCALE_DEFAULT);
            ImageIcon i2 = new ImageIcon(i3);
            JLabel image = new JLabel(i2);
            image.setBounds(410,80,480,410);
            add(image);
           
              setSize(900,600);
            setVisible(true);
            setLocation(530,200);
			
                

        }
            
                public void actionPerformed(ActionEvent ae){
                    String name = textField.getText();
                    String age = textField_1.getText();
                    String salary = textField_3.getText();
                    String phone = textField_4.getText();
                    String aadhar = textField_5.getText();
                   
                   
                    String gender = null;
                    
                    if(male.isSelected()){
                        gender = "male";
                    
                    }else if(female.isSelected()){
                        gender = "female";
                    }

                            
                    String s6 = (String)c1.getSelectedItem();
                    
                if(name.equals("")||age.equals("")||salary.equals("")||phone.equals("")||aadhar.equals(""))
                    {
                        JOptionPane.showMessageDialog(null, "Please enter all Details");
                    }
                 else{
                    try {
                        Conn c = new Conn();
                       
                        String str = "INSERT INTO employee values( '"+name+"', '"+age+"', '"+gender+"','"+s6+"', '"+salary+"', '"+phone+"','"+aadhar+"')";
                        
                        c.s.executeUpdate(str);
                        JOptionPane.showMessageDialog(null,"Employee Added");
                        setVisible(false);
                         
                    } catch (Exception e) {
                        e.printStackTrace();
        	    }
                    }
		}

           
			
          
	
        
    public static void main(String[] args){
        new AddEmployee();
    }   


}