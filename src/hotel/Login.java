package hotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JLabel usernameLabel, passwordLabel;
    JTextField usernameTextField;
    JPasswordField passwordField;
    JButton loginButton, cancelButton;

    Login() {
        super("Login");
        setLayout(null);

        usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(40, 20, 100, 30);
        add(usernameLabel);

        usernameTextField = new JTextField();
        usernameTextField.setBounds(150, 20, 150, 30);
        add(usernameTextField);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(40, 70, 100, 30);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 70, 150, 30);
        add(passwordField);

        ImageIcon imageIcon1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image image = imageIcon1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon imageIcon2 = new ImageIcon(image);
        JLabel imageLabel = new JLabel(imageIcon2);
        imageLabel.setBounds(350, 10, 150, 150);
        add(imageLabel);

        loginButton = new JButton("Login");
        loginButton.setBounds(40, 140, 120, 30);
        loginButton.setFont(new Font("serif", Font.BOLD, 15));
        loginButton.addActionListener(this);
        loginButton.setBackground(Color.BLACK);
        loginButton.setForeground(Color.WHITE);
        add(loginButton);


        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(180, 140, 120, 30);
        cancelButton.setFont(new Font("serif", Font.BOLD, 15));
        cancelButton.setBackground(Color.BLACK);
        cancelButton.setForeground(Color.WHITE);
        add(cancelButton);

        cancelButton.addActionListener(this);


        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        setSize(600, 300);
        setLocation(600, 350);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == loginButton) {
            try {
                Connect connect = new Connect();
                String username = usernameTextField.getText();
                String password = passwordField.getText();

                String sqlQuery = "select * from login where username = '" + username + "' and password = '" + password + "'";
                ResultSet resultSet = connect.statement.executeQuery(sqlQuery);
                if (resultSet.next()) {
                    new Dashboard().setVisible(true);
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Login");
                    usernameTextField.setText("");
                    passwordField.setText("");
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("error: " + e);
            }
        } else if (actionEvent.getSource() == cancelButton) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Login().setVisible(true);
    }
}