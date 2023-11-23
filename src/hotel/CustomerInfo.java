package hotel;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerInfo extends JFrame {

    private JPanel panel;
    private JTable customerInfoTable;
    private JLabel idLabel, numberLabel, nameLabel, genderLabel, countryLabel, roomLabel, checkInStatusLabel, depositLabel;
    JButton loadCustomersButton, backButton;

    public CustomerInfo() throws SQLException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(530, 200, 900, 600);
        panel = new JPanel();
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(panel);
        panel.setLayout(null);

        customerInfoTable = new JTable();
        customerInfoTable.setBounds(0, 40, 900, 450);
        panel.add(customerInfoTable);

        idLabel = new JLabel("ID");
        idLabel.setBounds(31, 11, 46, 14);
        panel.add(idLabel);

        numberLabel = new JLabel("Number");
        numberLabel.setBounds(150, 11, 46, 14);
        panel.add(numberLabel);

        nameLabel = new JLabel("Name");
        nameLabel.setBounds(270, 11, 65, 14);
        panel.add(nameLabel);

        genderLabel = new JLabel("Gender");
        genderLabel.setBounds(360, 11, 46, 14);
        panel.add(genderLabel);

        countryLabel = new JLabel("Country");
        countryLabel.setBounds(480, 11, 46, 14);
        panel.add(countryLabel);

        roomLabel = new JLabel("Room");
        roomLabel.setBounds(600, 11, 46, 14);
        panel.add(roomLabel);

        checkInStatusLabel = new JLabel("Check-in Status");
        checkInStatusLabel.setBounds(680, 11, 100, 14);
        panel.add(checkInStatusLabel);

        depositLabel = new JLabel("Deposit");
        depositLabel.setBounds(800, 11, 100, 14);
        panel.add(depositLabel);

        loadCustomersButton = new JButton("Load Customers");
        loadCustomersButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    Connect connect = new Connect();
                    String displayCustomerTable = "select * from Customer";
                    ResultSet rs = connect.statement.executeQuery(displayCustomerTable);
                    customerInfoTable.setModel(DbUtils.resultSetToTableModel(rs));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        loadCustomersButton.setBounds(300, 510, 120, 30);
        loadCustomersButton.setBackground(Color.BLACK);
        loadCustomersButton.setForeground(Color.WHITE);
        panel.add(loadCustomersButton);

        backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Reception().setVisible(true);
                setVisible(false);
            }
        });
        backButton.setBounds(450, 510, 120, 30);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        panel.add(backButton);

        getContentPane().setBackground(Color.WHITE);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    CustomerInfo customerInfo = new CustomerInfo();
                    customerInfo.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}