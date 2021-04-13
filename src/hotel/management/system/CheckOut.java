
package hotel.management.system;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.EventQueue;


import java.sql.*;	
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.event.*;
import java.awt.event.ActionEvent;

public class CheckOut extends JFrame{
	Connection Conn = null;
	PreparedStatement pst = null;
	private JPanel contentPane;
	private JTextField t1;
        Choice c1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckOut frame = new CheckOut();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void close(){
		this.dispose();
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public CheckOut() throws SQLException {
		//conn = Javaconnect.getDBConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(530, 200, 800, 294);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
                
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/sixth.jpg"));
                Image i3 = i1.getImage().getScaledInstance(400, 225,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l1 = new JLabel(i2);
                l1.setBounds(300,0,500,225);
                add(l1);
		
		JLabel lblCheckOut = new JLabel("Check Out ");
		lblCheckOut.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCheckOut.setBounds(70, 11, 140, 35);
		contentPane.add(lblCheckOut);
		
		JLabel lblName = new JLabel("Aadhar :");
		lblName.setBounds(20, 85, 80, 14);
		contentPane.add(lblName);
                
                c1 = new Choice();
                try{
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from customer");
                    while(rs.next()){
                        c1.add(rs.getString("aadhar"));    
                    }
                }catch(Exception e){ }
                c1.setBounds(130, 82, 150, 20);
		contentPane.add(c1);
                
                ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/tick.png"));
                Image i5 = i4.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
                ImageIcon i6 = new ImageIcon(i5);
                JButton l2 = new JButton(i6);
                l2.setBounds(290,82,20,20);
                add(l2);
                
                l2.addActionListener(new ActionListener(){
                    
                    public void actionPerformed(ActionEvent ae){
                       
                        try{
                            
                            
                            Conn c = new Conn();
                            String aadhar = c1.getSelectedItem();
                            ResultSet rs = c.s.executeQuery("select * from customer where aadhar = "+aadhar);
                            
                            if(rs.next()){
                              
                                t1.setText(rs.getString("room_no"));    
                            }
                        }catch(Exception e){System.out.println(e); }
                    }
                });

		
		JLabel lblRoomNumber = new JLabel("Room Number:");
		lblRoomNumber.setBounds(20, 132, 86, 20);
		contentPane.add(lblRoomNumber);
		
		t1 = new JTextField();
                t1.setBounds(130, 132, 150, 20);
		contentPane.add(t1);
                
                
                
                
                
		
                
		JButton btnCheckOut = new JButton("Check Out");
		btnCheckOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                                String id = c1.getSelectedItem();
                                String s1 = t1.getText();
				String deleteSQL = "Delete from customer where aadhar = '"+id+"'";
                                String q2 = "update room set available = 'Available' where room_number = "+s1;
                                
                                
				Conn c = new Conn();

	    		try{
                            
                             String total = "";
                             String paid="";
                                
                                ResultSet rs2 = c.s.executeQuery("select * from room where room_number = "+s1);
                           
                                while(rs2.next()){
                                    total = rs2.getString("price"); 
                                    
                                    
                                }
                                 ResultSet rs3=c.s.executeQuery("Select * from customer where room_no = "+s1);
                                while(rs3.next()){
                                    paid=rs3.getString("amount_deposit");
                                }
                               
                                int pending = Integer.parseInt(total)- Integer.parseInt(paid);
                                
	    			  if(pending==0){
	    			c.s.executeUpdate(deleteSQL);
	    			c.s.executeUpdate(q2);
	    			JOptionPane.showMessageDialog(null, "Check Out Successful");
	    			new Reception().setVisible(true);
                                setVisible(false);
                                  }
                                  else {
                                      JOptionPane.showMessageDialog(null, "Amount Due ");
                                      new Reception().setVisible(true);
                                      setVisible(false);
                                      
                                  }
                                  
	    		}catch(Exception e1){
	    			System.out.println(e1.getMessage());
	    		}
			}
		});
		btnCheckOut.setBounds(50, 200, 100, 25);
                btnCheckOut.setBackground(Color.BLACK);
                btnCheckOut.setForeground(Color.WHITE);
		contentPane.add(btnCheckOut);
		
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reception().setVisible(true);
                                setVisible(false);
			}
		});
		btnExit.setBounds(160, 200, 100, 25);
                btnExit.setBackground(Color.BLACK);
                btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);
                
                
                getContentPane().setBackground(Color.WHITE);
	}

}