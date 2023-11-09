package hotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmployee extends JFrame {

    JLabel nameLabel, ageLabel, genderLabel, jobLabel, salaryLabel, phoneLabel, aadharLabel, emailLabel, addEmployeeDetailsLabel;
    JTextField nameTextField, ageTextField, salaryTextField, phoneTextField, aadharTextField, emailTextField;
    JRadioButton maleRadioButton, femaleRadiaButton;
    JComboBox jobTypeComboBox;
    JButton saveButton;

    public AddEmployee() {
        getContentPane().setForeground(Color.BLUE);
        getContentPane().setForeground(Color.WHITE);
        setTitle("ADD EMPLOYEE DETAILS");

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(778, 486);
        getContentPane().setLayout(null);

        nameLabel = new JLabel("NAME");
        nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        nameLabel.setBounds(60, 30, 150, 27);
        add(nameLabel);

        nameTextField = new JTextField();
        nameTextField.setBounds(200, 30, 150, 27);
        add(nameTextField);

        ageLabel = new JLabel("AGE");
        ageLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        ageLabel.setBounds(60, 80, 150, 27);
        add(ageLabel);

        ageTextField = new JTextField();
        ageTextField.setBounds(200, 80, 150, 27);
        add(ageTextField);

        genderLabel = new JLabel("GENDER");
        genderLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        genderLabel.setBounds(60, 120, 150, 27);
        add(genderLabel);

        maleRadioButton = new JRadioButton("MALE");
        maleRadioButton.setBackground(Color.WHITE);
        maleRadioButton.setBounds(200, 120, 70, 27);
        add(maleRadioButton);

        femaleRadiaButton = new JRadioButton("FEMALE");
        femaleRadiaButton.setBackground(Color.WHITE);
        femaleRadiaButton.setBounds(280, 120, 70, 27);
        add(femaleRadiaButton);

        jobLabel = new JLabel("JOB");
        jobLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        jobLabel.setBounds(60, 170, 150, 27);
        add(jobLabel);

        String jobType[] = {"Front Desk Clerks", "Porters", "Housekeeping", "Kitchen Staff", "Room Service", "Waiter/Waitress", "Manager", "Accountant", "Chef"};
        jobTypeComboBox = new JComboBox(jobType);
        jobTypeComboBox.setBackground(Color.WHITE);
        jobTypeComboBox.setBounds(200, 170, 150, 30);
        add(jobTypeComboBox);

        salaryLabel = new JLabel("SALARY");
        salaryLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        salaryLabel.setBounds(60, 220, 150, 27);
        add(salaryLabel);

        salaryTextField = new JTextField();
        salaryTextField.setBounds(200, 220, 150, 27);
        add(salaryTextField);

        phoneLabel = new JLabel("PHONE");
        phoneLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        phoneLabel.setBounds(60, 270, 150, 27);
        add(phoneLabel);

        phoneTextField = new JTextField();
        phoneTextField.setBounds(200, 270, 150, 27);
        add(phoneTextField);

        aadharLabel = new JLabel("AADHAR");
        aadharLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        aadharLabel.setBounds(60, 320, 150, 27);
        add(aadharLabel);

        aadharTextField = new JTextField();
        aadharTextField.setBounds(200, 320, 150, 27);
        add(aadharTextField);

        emailLabel = new JLabel("EMAIL");
        emailLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        emailLabel.setBounds(60, 370, 150, 27);
        add(emailLabel);

        emailTextField = new JTextField();
        emailTextField.setBounds(200, 370, 150, 27);
        add(emailTextField);

        setVisible(true);

        addEmployeeDetailsLabel = new JLabel("ADD EMPLOYEE DETAILS");
        addEmployeeDetailsLabel.setForeground(Color.BLUE);
        addEmployeeDetailsLabel.setFont(new Font("Tahoma", Font.PLAIN, 31));
        addEmployeeDetailsLabel.setBounds(450, 24, 442, 35);
        add(addEmployeeDetailsLabel);

        ImageIcon imageIcon1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image image = imageIcon1.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
        ImageIcon imageIcon2 = new ImageIcon(image);
        JLabel imageLabel = new JLabel(imageIcon2);
        imageLabel.setBounds(410, 80, 480, 410);
        add(imageLabel);

        saveButton = new JButton("SAVE");
        saveButton.setBounds(200, 420, 150, 30);
        saveButton.setBackground(Color.BLACK);
        saveButton.setForeground(Color.WHITE);
        add(saveButton);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String name = nameTextField.getText();
                String age = ageTextField.getText();
                String salary = salaryTextField.getText();
                String phone = phoneTextField.getText();
                String aadhar = aadharTextField.getText();
                String email = emailTextField.getText();
                String gender = null;

                if (maleRadioButton.isSelected()) {
                    gender = "male";
                } else if (femaleRadiaButton.isSelected()) {
                    gender = "female";
                }

                String jobTypeSelected = (String) jobTypeComboBox.getSelectedItem();
                try {
                    Connect connect = new Connect();
                    String insertQuery = "INSERT INTO employee values( '" + name + "', '" + age + "', '" + gender + "','" + jobTypeSelected + "', '" + salary + "', '" + phone + "','" + aadhar + "', '" + email + "')";
                    connect.statement.executeUpdate(insertQuery);
                    JOptionPane.showMessageDialog(null, "Employee Added");
                    setVisible(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        setSize(900, 600);
        setVisible(true);
        setLocation(530, 200);
    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}