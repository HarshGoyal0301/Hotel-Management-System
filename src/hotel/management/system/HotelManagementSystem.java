
package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener{

        
        
        
        public HotelManagementSystem() {
		
                setBounds(200,120,1024,683);

                JLabel l1;
                
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/BITS_1.jpg"));
               l1=new JLabel(i1);
               l1.setBounds(0,0,1024,683);
               add(l1);
               
               JLabel l2 = new JLabel("DBMS PROJECT");
               l2.setBounds(280,80,1000,90);
               l2.setForeground(Color.RED);
               l2.setFont(new Font("serif",Font.PLAIN,70));
               l1.add(l2);
               JButton b1=new JButton("Next");
               b1.setBackground(Color.WHITE);
               b1.setForeground(Color.BLACK);
               b1.setBounds(850,550,120,50);
               l1.add(b1);
               b1.addActionListener(this);
               
               setLayout(null);
               setVisible(true);
        }
        public void actionPerformed(ActionEvent ae)
        {
            new Login().setVisible(true);
            this.setVisible(false);
        }
        public static void main(String[] args)
        {
          new HotelManagementSystem();
        }
                
}

