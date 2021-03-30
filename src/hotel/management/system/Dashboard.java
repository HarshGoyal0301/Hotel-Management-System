
package hotel.management.system;

import java.awt.*;
import javax.swing.*;
public class Dashboard extends JFrame {
    JMenuBar mb;
    JMenu m1,m2;
    JMenuItem i1,i2,i3;

    public Dashboard()
     {
         mb=new JMenuBar();
         add(mb);
         m1=new JMenu("Hotel Management");
         mb.add(m1);
          m2=new JMenu("Admin");
         mb.add(m2);
         
         i1=new JMenuItem("RECEPTION");
         m1.add(i1);
         i2=new JMenuItem("Add Employee");
         m2.add(i2);
         
          i3=new JMenuItem("Add Room");
         m2.add(i3);
         
         setLayout(null);
         setBounds(0,0,1750,850);
         
         
          JLabel l1;
                
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/Hotelimage.jpg"));
                Image i2=i1.getImage().getScaledInstance(1750, 820, Image.SCALE_DEFAULT);
                ImageIcon i3=new ImageIcon(i2);
               l1=new JLabel(i3);
               l1.setBounds(0,0,1750,820);
               add(l1);
            
         mb.setBounds(0,0,1750,30);
         
      
         setVisible(true);
         
     }
     public static void main(String args[])
     {
         new Dashboard().setVisible(true);
     }
}
