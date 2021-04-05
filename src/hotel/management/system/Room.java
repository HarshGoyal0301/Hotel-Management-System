
package hotel.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Room extends JFrame {

    Connection conn = null;
    private JPanel contentPane;
    private JTable table;
    private JLabel lb1Availability;
    private JLabel lb1CleanStatus;
    private JLabel lb1NewLabel;
    private JLabel lb1NewLabel1;
    private JLabel lb1RoomNo;
    private JLabel lb1Id;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    Room frame = new Room();
                    frame.setVisible(true);
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Room() throws SQLException {
        // conn = Javaconnect.getDBConnection();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 200, 700, 550);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

       

        table = new JTable();
        table.setBounds(0, 40, 500, 400);
        contentPane.add(table);

        JButton btnLoadData = new JButton("Load Data");
        btnLoadData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Conn c = new Conn();
                    String displayCustomerSQL = "SELECT * FROM Room";
                    // PreparedStatement pst = conn.prepareStatement(displayCustomerSQL)
                    ResultSet rs = c.s.executeQuery(displayCustomerSQL);
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                } catch(Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        btnLoadData.setBounds(100, 470, 120, 30);
        btnLoadData.setBackground(Color.BLACK);
        btnLoadData.setForeground(Color.WHITE);
        contentPane.add(btnLoadData);

        JButton btnBackButton = new JButton("Back");
        btnBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Reception().setVisible(true);
                setVisible(false);
            }
        });
        btnBackButton.setBounds(290, 470, 120, 30);
        btnBackButton.setBackground(Color.BLACK);
        btnBackButton.setForeground(Color.WHITE);
        contentPane.add(btnBackButton);

        lb1Availability = new JLabel("Availability");
        lb1Availability.setBounds(119, 15, 69, 14);
        contentPane.add(lb1Availability);

        lb1CleanStatus = new JLabel("Clean Status");
        lb1CleanStatus.setBounds(216, 15, 76, 14);
        contentPane.add(lb1CleanStatus);

        lb1NewLabel = new JLabel("Price");
        lb1NewLabel.setBounds(330, 15, 46, 14);
        contentPane.add(lb1NewLabel);

        lb1NewLabel1 = new JLabel("Room Type");
        lb1NewLabel1.setBounds(417, 15, 76, 14);
        contentPane.add(lb1NewLabel1);


        lb1Id = new JLabel("Room Number");
        lb1Id.setBounds(12, 15, 90, 14);
        contentPane.add(lb1Id);

        getContentPane().setBackground(Color.WHITE);
    }
}