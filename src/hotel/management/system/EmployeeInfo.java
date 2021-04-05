
package hotel.management.system;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class EmployeeInfo extends JFrame {

    Connection conn = null;
    private JPanel contentPane;
    private JTable table;
    private JLabel lb1Name;
    private JLabel lb1Age;
    private JLabel lb1Gender;
    private JLabel lb1Department;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            
            public void run() {
                try {
                    EmployeeInfo frame = new EmployeeInfo();
                    frame.setVisible(true);
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void close() {
        this.dispose();
    }

    public EmployeeInfo() throws SQLException {
        //conn = Javaconnect.getDBConnection();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(430, 200, 1000, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        table = new JTable();
        table.setBounds(0, 34, 1000, 450);
        contentPane.add(table);

        JButton btnLoadData = new JButton("Load Data");
        btnLoadData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Conn c = new Conn();
                    String displayCustomerSQL = "SELECT * FROM Employee";
                    ResultSet rs = c.s.executeQuery(displayCustomerSQL);
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                } catch(Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        btnLoadData.setBounds(350, 500, 120, 30);
        btnLoadData.setBackground(Color.BLACK);
        btnLoadData.setForeground(Color.WHITE);
        contentPane.add(btnLoadData);

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Reception().setVisible(true);
                setVisible(false);
            }
        });
        btnExit.setBounds(510, 500, 120, 30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        contentPane.add(btnExit);

        lb1Name = new JLabel("Name");
        lb1Name.setBounds(41, 11, 46, 14);
        contentPane.add(lb1Name);

        lb1Age = new JLabel("Age");
        lb1Age.setBounds(159, 11, 46, 14);
        contentPane.add(lb1Age);

        lb1Gender = new JLabel("Gender");
        lb1Gender.setBounds(293, 11, 46, 14);
        contentPane.add(lb1Gender);

        lb1Department = new JLabel("Job");
        lb1Department.setBounds(440, 11, 86, 14);
        contentPane.add(lb1Department);

        JLabel sal = new JLabel("Salary");
        sal.setBounds(585, 11, 86, 14);
        contentPane.add(sal);

        JLabel pno = new JLabel("Phone");
        pno.setBounds(730, 11, 86, 14);
        contentPane.add(pno);

        JLabel aadhar = new JLabel("Aadhar");
        aadhar.setBounds(865, 11, 86, 14);
        contentPane.add(aadhar);

   

        getContentPane().setBackground(Color.WHITE);
    }
}
