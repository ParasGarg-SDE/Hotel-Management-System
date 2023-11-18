package hotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDrivers extends JFrame implements ActionListener {

    private JPanel panel;
    private JLabel addDriversLabel, nameLabel, ageLabel, genderLabel, carCompanyLabel, carBrandLabel, availableLabel, locationLabel;
    private JTextField nameTextField, ageTextField, carCompanyTextField, carBrandTextField, locationTextField;
    private JComboBox genderComboBox, availableComboBox;
    JButton addButton, backButton;

    AddDrivers() {
        setBounds(450, 200, 1000, 500);
        panel = new JPanel();
        setContentPane(panel);
        panel.setLayout(null);

        ImageIcon imageIcon1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image image = imageIcon1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon imageIcon2 = new ImageIcon(image);
        JLabel imageLabel = new JLabel(imageIcon2);
        imageLabel.setBounds(400, 30, 500, 370);
        add(imageLabel);

        addDriversLabel = new JLabel("Add Drivers");
        addDriversLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        addDriversLabel.setBounds(194, 10, 120, 22);
        panel.add(addDriversLabel);

        nameLabel = new JLabel("Name");
        nameLabel.setForeground(new Color(25, 25, 112));
        nameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        nameLabel.setBounds(64, 70, 102, 22);
        panel.add(nameLabel);

        nameTextField = new JTextField();
        nameTextField.setBounds(174, 70, 156, 20);
        panel.add(nameTextField);

        ageLabel = new JLabel("Age");
        ageLabel.setForeground(new Color(25, 25, 112));
        ageLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        ageLabel.setBounds(64, 110, 102, 22);
        panel.add(ageLabel);

        ageTextField = new JTextField();
        ageTextField.setBounds(174, 110, 156, 20);
        panel.add(ageTextField);

        genderLabel = new JLabel("Gender");
        genderLabel.setForeground(new Color(25, 25, 112));
        genderLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        genderLabel.setBounds(64, 150, 102, 22);
        panel.add(genderLabel);

        genderComboBox = new JComboBox<>(new String[]{"Male", "Female"});
        genderComboBox.setBounds(176, 150, 154, 20);
        panel.add(genderComboBox);

        carCompanyLabel = new JLabel("Car Company");
        carCompanyLabel.setForeground(new Color(25, 25, 112));
        carCompanyLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        carCompanyLabel.setBounds(64, 190, 102, 22);
        panel.add(carCompanyLabel);

        carCompanyTextField = new JTextField();
        carCompanyTextField.setBounds(174, 190, 156, 20);
        panel.add(carCompanyTextField);

        carBrandLabel = new JLabel("Car Brand");
        carBrandLabel.setForeground(new Color(25, 25, 112));
        carBrandLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        carBrandLabel.setBounds(64, 230, 102, 22);
        panel.add(carBrandLabel);

        carBrandTextField = new JTextField();
        carBrandTextField.setBounds(174, 230, 156, 20);
        panel.add(carBrandTextField);

        availableLabel = new JLabel("Available");
        availableLabel.setForeground(new Color(25, 25, 112));
        availableLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        availableLabel.setBounds(64, 270, 102, 22);
        panel.add(availableLabel);

        availableComboBox = new JComboBox(new String[]{"Yes", "No"});
        availableComboBox.setBounds(176, 270, 154, 20);
        panel.add(availableComboBox);

        locationLabel = new JLabel("Location");
        locationLabel.setForeground(new Color(25, 25, 112));
        locationLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        locationLabel.setBounds(64, 310, 102, 22);
        panel.add(locationLabel);

        locationTextField = new JTextField();
        locationTextField.setBounds(174, 310, 156, 20);
        panel.add(locationTextField);

        addButton = new JButton("Add");
        addButton.addActionListener(this);
        addButton.setBounds(198, 380, 111, 33);
        addButton.setBackground(Color.BLACK);
        addButton.setForeground(Color.WHITE);
        panel.add(addButton);

        backButton = new JButton("Back");
        backButton.addActionListener(this);
        backButton.setBounds(198, 380, 111, 33);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        panel.add(backButton);

        panel.setBackground(Color.WHITE);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        try {
            if (actionEvent.getSource() == addButton) {
                try {
                    Connect connect = new Connect();
                    String name = nameTextField.getText();
                    String age = ageTextField.getText();
                    String gender = (String) genderComboBox.getSelectedItem();
                    String company = carCompanyTextField.getText();
                    String brand = carBrandTextField.getText();
                    String available = (String) availableComboBox.getSelectedItem();
                    String location = locationTextField.getText();

                    String insertQuery = "INSERT INTO driver values( '" + name + "', '" + age + "', '" + gender + "','" + company + "', '" + brand + "', '" + available + "','" + location + "')";

                    connect.statement.executeUpdate(insertQuery);
                    JOptionPane.showMessageDialog(null, "Driver Successfully Added");
                    this.setVisible(false);
                } catch (Exception e) {
                    System.out.println(e);
                }
            } else if (actionEvent.getSource() == backButton) {
                this.setVisible(false);
            }
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        new AddDrivers().setVisible(true);
    }
}