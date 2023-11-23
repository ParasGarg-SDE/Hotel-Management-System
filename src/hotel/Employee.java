package hotel;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Employee extends JFrame {

    private JPanel panel;
    private JTable employeeTable;
    private JLabel nameLabel, ageLabel, genderLabel, jobLabel, salaryLabel, phoneLabel, idNumberLabel, emailLabel;

    JButton loadEmployeesButton, backButton;

    public Employee() throws SQLException {
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setBounds(430, 200, 1000, 600);
        panel = new JPanel();
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(panel);
        panel.setLayout(null);

        employeeTable = new JTable();
        employeeTable.setBounds(0, 34, 1000, 450);
        panel.add(employeeTable);

        nameLabel = new JLabel("Name");
        nameLabel.setBounds(41, 11, 46, 14);
        panel.add(nameLabel);

        ageLabel = new JLabel("Age");
        ageLabel.setBounds(159, 11, 46, 14);
        panel.add(ageLabel);

        genderLabel = new JLabel("Gender");
        genderLabel.setBounds(273, 11, 46, 14);
        panel.add(genderLabel);

        jobLabel = new JLabel("Job");
        jobLabel.setBounds(416, 11, 86, 14);
        panel.add(jobLabel);

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

        loadEmployeesButton = new JButton("Load Employees");
        loadEmployeesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    Connect connect = new Connect();
                    String displayEmployeeTable = "select * from Employee";
                    ResultSet resultSet = connect.statement.executeQuery(displayEmployeeTable);
                    employeeTable.setModel(DbUtils.resultSetToTableModel(resultSet));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        loadEmployeesButton.setBounds(350, 500, 120, 30);
        loadEmployeesButton.setBackground(Color.BLACK);
        loadEmployeesButton.setForeground(Color.WHITE);
        panel.add(loadEmployeesButton);

        backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Reception().setVisible(true);
                setVisible(false);
            }
        });
        backButton.setBounds(510, 500, 120, 30);
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
                    Employee employee = new Employee();
                    employee.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}