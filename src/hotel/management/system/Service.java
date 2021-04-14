package hotel.management.system;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Service extends JFrame {
    Connection Conn = null;
    PreparedStatement pst = null;
    private JPanel contentPane;
    private JTextField t1, t2, t3;
    Choice c0, c1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Service frame = new Service();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void close() {
        this.dispose();
    }

    /**
     * Create the frame.
     * @throws SQLException
     */
    public Service() throws SQLException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 200, 800, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblServices = new JLabel("Services");
        lblServices.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblServices.setBounds(70, 20, 140, 35);
        contentPane.add(lblServices);

        JLabel lblRoomNumber = new JLabel("Room Number:");
        lblRoomNumber.setBounds(20, 70, 100, 20);
        contentPane.add(lblRoomNumber);
        c0 = new Choice();
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select room_no from customer");
            while(rs.next()) {
                c0.add(rs.getString("room_no"));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        c0.setBounds(130, 70, 150, 20);
        contentPane.add(c0);

        JLabel lblType = new JLabel("Type :");
        lblType.setBounds(20, 170, 80, 20);
        contentPane.add(lblType);
        c1 = new Choice();
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from service");
            while(rs.next()){
                c1.add(rs.getString("type"));
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        c1.setBounds(130, 170, 150, 20);
        contentPane.add(c1);

//        JLabel lblQty = new JLabel("Quantity:");
//        lblQty.setBounds(20, 170, 80, 20);
//        contentPane.add(lblQty);
//
//        t1 = new JTextField();
//        t1.setBounds(130, 170, 150, 20);
//        contentPane.add(t1);

        JLabel lblPrice = new JLabel("Price");
        lblPrice.setBounds(20, 270, 80, 20);
        contentPane.add(lblPrice);

        t2 = new JTextField();
        t2.setBounds(130, 270, 150, 20);
        contentPane.add(t2);

//        JLabel lblTotalPrice = new JLabel("Total Amount");
//        lblTotalPrice.setBounds(20, 270, 80, 20);
//        contentPane.add(lblTotalPrice);
//
//        t3 = new JTextField();
//        t3.setBounds(130, 270, 150, 20);
//        contentPane.add(t3);

//        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/tick.png"));
//        Image i5 = i4.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
//        ImageIcon i6 = new ImageIcon(i5);
//        JButton l2 = new JButton(i6);
//        l2.setBounds(290,270,20,20);
//        add(l2);

//        l2.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent ae){
//                try{
//                    Conn c = new Conn();
//                    String type = c1.getSelectedItem();
//                    ResultSet rs = c.s.executeQuery("select * from service where type = "+type);
//                    if(rs.next()){
//                        int price = Integer.parseInt(t1.getText())*Integer.parseInt(rs.getString("price"));
//                        t3.setText(String.valueOf(price));
//                    }
//                } catch(Exception e) {
//                    System.out.println(e);
//                }
//            }
//        });

        JButton btnUpdate = new JButton("Update");
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String amtDue = "";
                    String roomNo = c0.getSelectedItem();
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select amount_due from customer where room_no="+roomNo);
                    while(rs.next()) {
                        amtDue = rs.getString("amount_due");
                    }
                    String newAmtDue = String.valueOf(Integer.parseInt(amtDue) + Integer.parseInt(t2.getText()));
                    c.s.executeUpdate("update customer set amount_due="+newAmtDue+" where room_no="+roomNo);
                    JOptionPane.showMessageDialog(null, "Service Updated Successfully");
                    new Reception().setVisible(true);
                    setVisible(false);
                } catch(SQLException e1) {
                    e1.printStackTrace();
                } catch(NumberFormatException e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Please enter a valid number");
                }
            }
        });
        btnUpdate.setBounds(100, 370, 100, 30);
        btnUpdate.setBackground(Color.BLACK);
        btnUpdate.setForeground(Color.WHITE);
        contentPane.add(btnUpdate);

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Reception().setVisible(true);
                setVisible(false);
            }
        });
        btnExit.setBounds(250, 370, 100, 30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        contentPane.add(btnExit);

        getContentPane().setBackground(Color.WHITE);
    }
}
