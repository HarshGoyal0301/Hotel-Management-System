package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Reception extends JFrame {

    private JPanel contentPane;

    public static void main(String[] args) {
        new Reception();
    }

    public Reception() {

        setBounds(530, 200, 850, 470);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/fourth.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(250, 30, 500, 470);
        add(l1);

        JButton btnNewCustomerForm = new JButton("New Customer Form");
        btnNewCustomerForm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    AddNewCustomer custom = new AddNewCustomer();
                    custom.setVisible(true);
                    setVisible(false);
                } catch(Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        btnNewCustomerForm.setBounds(10, 30, 200, 30);
        btnNewCustomerForm.setBackground(Color.BLACK);
        btnNewCustomerForm.setForeground(Color.WHITE);
        contentPane.add(btnNewCustomerForm);

        JButton btnRoom = new JButton("Room");
        btnRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Room room = new Room();
                    room.setVisible(true);
                    setVisible(false);
                } catch(Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        btnRoom.setBounds(10, 70, 200, 30);
        btnRoom.setBackground(Color.BLACK);
        btnRoom.setForeground(Color.WHITE);
        contentPane.add(btnRoom);

        JButton btnEmployeeInfo = new JButton("All Employee Info");
        btnEmployeeInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    EmployeeInfo emp = new EmployeeInfo();
                    emp.setVisible(true);
                    setVisible(false);
                } catch(Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        btnEmployeeInfo.setBounds(10, 110, 200, 30);
        btnEmployeeInfo.setBackground(Color.BLACK);
        btnEmployeeInfo.setForeground(Color.WHITE);
        contentPane.add(btnEmployeeInfo);

        JButton btnCustomerInfo = new JButton("Customer Info");
        btnCustomerInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    CustomerInfo customer = new CustomerInfo();
                    customer.setVisible(true);
                    setVisible(false);
                } catch(Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        btnCustomerInfo.setBounds(10, 150, 200, 30);
        btnCustomerInfo.setBackground(Color.BLACK);
        btnCustomerInfo.setForeground(Color.WHITE);
        contentPane.add(btnCustomerInfo);

        JButton btnCheckout = new JButton("Check Out");
        btnCheckout.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                CheckOut check;
                try {
                    check = new CheckOut();
                    check.setVisible(true);
                    setVisible(false);
                } catch(SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        btnCheckout.setBounds(10, 190, 200, 30);
        btnCheckout.setBackground(Color.BLACK);
        btnCheckout.setForeground(Color.WHITE);
        contentPane.add(btnCheckout);

        JButton btnUpdateCheckStatus = new JButton("Update Check Status");
        btnUpdateCheckStatus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    UpdateCheck update = new UpdateCheck();
                    update.setVisible(true);
                    setVisible(false);
                } catch(Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        btnUpdateCheckStatus.setBounds(10, 230, 200, 30);
        btnUpdateCheckStatus.setBackground(Color.BLACK);
        btnUpdateCheckStatus.setForeground(Color.WHITE);
        contentPane.add(btnUpdateCheckStatus);

        JButton btnRoomStatus = new JButton("Update Room Status");
        btnRoomStatus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    UpdateRoom room = new UpdateRoom();
                    room.setVisible(true);
                    setVisible(false);
                } catch(Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        btnRoomStatus.setBounds(10, 270, 200, 30);
        btnRoomStatus.setBackground(Color.BLACK);
        btnRoomStatus.setForeground(Color.WHITE);
        contentPane.add(btnRoomStatus);

        JButton btnServices = new JButton("Services");
        btnServices.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Services service = new Services();
                    service.setVisible(true);
                    setVisible(false);
                } catch(Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        btnServices.setBounds(10, 310, 200, 30);
        btnServices.setBackground(Color.BLACK);
        btnServices.setForeground(Color.WHITE);
        contentPane.add(btnServices);

        JButton btnSearchRoom = new JButton("Search Room");
        btnSearchRoom.addActionListener(new ActionListener() {
      
            public void actionPerformed(ActionEvent e) {
                try {
                    SearchRoom search = new SearchRoom();
                    search.setVisible(true);
                    setVisible(false);
                } catch(Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        btnSearchRoom.setBounds(10, 350, 200, 30);
        btnSearchRoom.setBackground(Color.BLACK);
        btnSearchRoom.setForeground(Color.WHITE);
        contentPane.add(btnSearchRoom);

        JButton btnLogout = new JButton("Log Out");
        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new Login().setVisible(true);
                    setVisible(false);
                } catch(Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        btnLogout.setBounds(10, 390, 200, 30);
        btnLogout.setBackground(Color.BLACK);
        btnLogout.setForeground(Color.WHITE);
        contentPane.add(btnLogout);

        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
}
