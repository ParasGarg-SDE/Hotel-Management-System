package hotel;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManagerInfo extends JFrame {
    private JPanel panel;
    private JTable managerInfoTable;
    private JLabel nameLabel, ageLabel, genderLabel, joblabel, salaryLabel, phoneLabel, idNumberLabel, emailLabel;
    JButton loadManagersButton, backButton;

    public ManagerInfo() throws SQLException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(430, 200, 1000, 600);
        panel = new JPanel();
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(panel);
        panel.setLayout(null);

        managerInfoTable = new JTable();
        managerInfoTable.setBounds(0, 34, 1000, 450);
        panel.add(managerInfoTable);

        loadManagersButton = new JButton("Load Managers");
        loadManagersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    Connect connect = new Connect();
                    String displayManagerTable = "select * from Employee where job = 'Manager'";
                    ResultSet resultSet = connect.statement.executeQuery(displayManagerTable);
                    managerInfoTable.setModel(DbUtils.resultSetToTableModel(resultSet));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        loadManagersButton.setBounds(350, 500, 120, 30);
        loadManagersButton.setBackground(Color.BLACK);
        loadManagersButton.setForeground(Color.WHITE);
        panel.add(loadManagersButton);

        backButton = new JButton("Back Button");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Reception().setVisible(true);
                setVisible(false);
            }
        });
        backButton.setBounds(510, 500, 120, 30);
        backButton.setForeground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        panel.add(backButton);

        nameLabel = new JLabel("Name");
        nameLabel.setBounds(41, 11, 46, 14);
        panel.add(nameLabel);

        ageLabel = new JLabel("Age");
        ageLabel.setBounds(159, 11, 46, 14);
        panel.add(ageLabel);

        genderLabel = new JLabel("Gender");
        genderLabel.setBounds(273, 11, 46, 14);
        panel.add(genderLabel);

        joblabel = new JLabel("Job");
        joblabel.setBounds(416, 11, 86, 14);
        panel.add(joblabel);

        salaryLabel = new JLabel("Salary");
        salaryLabel.setBounds(536, 11, 86, 14);
        panel.add(salaryLabel);

        phoneLabel = new JLabel("Phone");
        phoneLabel.setBounds(656, 11, 86, 14);
        panel.add(phoneLabel);

        idNumberLabel = new JLabel("ID Number");
        idNumberLabel.setBounds(786, 11, 86, 14);
        panel.add(idNumberLabel);

        emailLabel = new JLabel("Email");
        emailLabel.setBounds(896, 11, 86, 14);
        panel.add(emailLabel);

        getContentPane().setBackground(Color.WHITE);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    ManagerInfo managerInfo = new ManagerInfo();
                    managerInfo.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}