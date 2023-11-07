package hotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HotelManagementSystem extends JFrame implements ActionListener {

    JLabel label;
    JButton nextButton;

    public HotelManagementSystem() {
        setSize(1366, 430);
        setLayout(null);
        setLocation(300, 300);

        ImageIcon imageIcon1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        Image image = imageIcon1.getImage().getScaledInstance(1366, 390, Image.SCALE_DEFAULT);
        ImageIcon imageIcon2 = new ImageIcon(image);
        label = new JLabel(imageIcon2);

        JLabel titleLabel = new JLabel("HOTEL MANAGEMENT SYSTEM");
        titleLabel.setBounds(30, 300, 1500, 100);
        titleLabel.setFont(new Font("serif", Font.PLAIN, 70));
        titleLabel.setForeground(Color.RED);
        label.add(titleLabel);

        nextButton = new JButton("Next");
        nextButton.setBackground(Color.WHITE);
        nextButton.setForeground(Color.BLACK);
        nextButton.setBounds(1170, 325, 150, 50);
        label.setBounds(0, 0, 1366, 390);
        label.add(nextButton);
        add(label);

        nextButton.addActionListener(this);
        setVisible(true);

        while (true) {
            titleLabel.setVisible(false);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
            titleLabel.setVisible(true);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new Login().setVisible(true);
        this.setVisible(false);
    }

    public static void main(String[] args) {
        HotelManagementSystem hotelManagementSystem = new HotelManagementSystem();
        hotelManagementSystem.setVisible(true);
    }
}