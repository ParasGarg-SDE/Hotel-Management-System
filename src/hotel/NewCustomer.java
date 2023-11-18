package hotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NewCustomer extends JFrame {
    private JPanel panel;
    private JLabel nameLabel, idLabel, idNumberLabel, genderLabel, countryLabel, allocatedRoomNoLabel;
    private JLabel checkInStatusLabel, depositLabel;
    private JTextField idNumberTextField, nameTextField, countryTextField, checkedInTextField, depositAmountTextField;
    JComboBox idTypeComboBox;
    JRadioButton maleRadioButton, femaleRadioButton;

    JButton addButton, backButton;
    Choice allocatedRoomNoChoice;

    public NewCustomer() throws SQLException {
        setBounds(530, 200, 850, 550);
        panel = new JPanel();
        setContentPane(panel);
        panel.setLayout(null);

        ImageIcon imageIcon1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image image = imageIcon1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
        ImageIcon imageIcon2 = new ImageIcon(image);
        JLabel imageLabel = new JLabel(imageIcon2);
        imageLabel.setBounds(480, 10, 300, 500);
        add(imageLabel);

        nameLabel = new JLabel("NEW CUSTOMER FORM");
        nameLabel.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
        nameLabel.setBounds(118, 11, 260, 53);
        panel.add(nameLabel);

        idLabel = new JLabel("ID :");
        idLabel.setBounds(35, 76, 200, 14);
        panel.add(idLabel);

        idTypeComboBox = new JComboBox(new String[]{"Passport", "Aadhar Card", "Voter Id", "Driving license"});
        idTypeComboBox.setBounds(271, 73, 150, 20);
        panel.add(idTypeComboBox);

        idNumberLabel = new JLabel("ID Number :");
        idNumberLabel.setBounds(35, 111, 200, 14);
        panel.add(idNumberLabel);

        idNumberTextField = new JTextField();
        idNumberTextField.setBounds(271, 111, 150, 20);
        panel.add(idNumberTextField);
        idNumberTextField.setColumns(10);

        nameLabel = new JLabel("Name :");
        nameLabel.setBounds(35, 151, 200, 14);
        panel.add(nameLabel);

        nameTextField = new JTextField();
        nameTextField.setBounds(271, 151, 150, 20);
        panel.add(nameTextField);
        nameTextField.setColumns(10);

        genderLabel = new JLabel("Gender :");
        genderLabel.setBounds(35, 191, 200, 14);
        panel.add(genderLabel);

        maleRadioButton = new JRadioButton("Male");
        maleRadioButton.setFont(new Font("Raleway", Font.BOLD, 14));
        maleRadioButton.setBackground(Color.WHITE);
        maleRadioButton.setBounds(271, 191, 80, 12);
        add(maleRadioButton);

        femaleRadioButton = new JRadioButton("Female");
        femaleRadioButton.setFont(new Font("Raleway", Font.BOLD, 14));
        femaleRadioButton.setBackground(Color.WHITE);
        femaleRadioButton.setBounds(350, 191, 100, 12);
        add(femaleRadioButton);

        countryLabel = new JLabel("Country :");
        countryLabel.setBounds(35, 231, 200, 14);
        panel.add(countryLabel);

        countryTextField = new JTextField();
        countryTextField.setBounds(271, 231, 150, 20);
        panel.add(countryTextField);
        countryTextField.setColumns(10);

        allocatedRoomNoLabel = new JLabel("Allocated Room Number :");
        allocatedRoomNoLabel.setBounds(35, 274, 200, 14);
        panel.add(allocatedRoomNoLabel);

        allocatedRoomNoChoice = new Choice();
        try {
            Connect connect = new Connect();
            ResultSet resultSet = connect.statement.executeQuery("select * from room");
            while (resultSet.next()) {
                allocatedRoomNoChoice.add(resultSet.getString("room_number"));
            }
        } catch (Exception e) {
        }
        allocatedRoomNoChoice.setBounds(271, 274, 150, 20);
        panel.add(allocatedRoomNoChoice);

        checkInStatusLabel = new JLabel("Checked-In :");
        checkInStatusLabel.setBounds(35, 316, 200, 14);
        panel.add(checkInStatusLabel);

        checkedInTextField = new JTextField();
        checkedInTextField.setBounds(271, 316, 150, 20);
        panel.add(checkedInTextField);
        checkedInTextField.setColumns(10);

        depositLabel = new JLabel("Deposit Amount :");
        depositLabel.setBounds(35, 359, 200, 14);
        panel.add(depositLabel);

        depositAmountTextField = new JTextField();
        depositAmountTextField.setBounds(271, 359, 150, 20);
        panel.add(depositAmountTextField);
        depositAmountTextField.setColumns(10);

        addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Connect connect = new Connect();
                String gender = null;

                if (maleRadioButton.isSelected()) {
                    gender = "Male";
                } else if (femaleRadioButton.isSelected()) {
                    gender = "Female";
                }

                String allocatedRoomNo = allocatedRoomNoChoice.getSelectedItem();

                try {
                    String idType = (String) idTypeComboBox.getSelectedItem();
                    String idNumber = idNumberTextField.getText();
                    String name = nameTextField.getText();
                    String country = countryTextField.getText();
                    String checkedIn = checkedInTextField.getText();
                    String depositAmount = depositAmountTextField.getText();

                    String insertQuery = "insert into customer values('" + idType + "','" + idNumber + "','" + name + "','" + gender + "','" + country + "','" + allocatedRoomNo + "','" + checkedIn + "','" + depositAmount + "')";
                    connect.statement.executeUpdate(insertQuery);

                    String updateQuery = "update room set availability = 'Occupied' where room_number = " + allocatedRoomNo;
                    connect.statement.executeUpdate(updateQuery);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        });
        addButton.setBounds(100, 430, 120, 30);
        addButton.setBackground(Color.BLACK);
        addButton.setForeground(Color.WHITE);
        panel.add(addButton);

        backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new Reception().setVisible(true);
                setVisible(false);
            }
        });
        backButton.setBounds(260, 430, 120, 30);
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
                    NewCustomer newCustomer = new NewCustomer();
                    newCustomer.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}