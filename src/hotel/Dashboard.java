package hotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame {

    public static void main(String[] args) {
        new Dashboard().setVisible(true);
    }

    public Dashboard() {
        super("HOTEL MANAGEMENT SYSTEM");
        setForeground(Color.CYAN);
        setLayout(null);

        ImageIcon imageIcon1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image image = imageIcon1.getImage().getScaledInstance(1950, 1000, Image.SCALE_DEFAULT);
        ImageIcon imageIcon2 = new ImageIcon(image);
        JLabel imageLabel = new JLabel(imageIcon2);
        imageLabel.setBounds(0, 0, 1950, 1000);
        add(imageLabel);

        JLabel titleLabel = new JLabel("THE TAJ GROUP WELCOMES YOU");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 46));
        titleLabel.setBounds(600, 60, 1000, 85);
        imageLabel.add(titleLabel);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu hotelManagementMenu = new JMenu("HOTEL MANAGEMENT");
        hotelManagementMenu.setForeground(Color.BLUE);
        menuBar.add(hotelManagementMenu);

        JMenuItem receptionMenuItem = new JMenuItem("RECEPTION");
        hotelManagementMenu.add(receptionMenuItem);

        JMenu adminMenu = new JMenu("ADMIN");
        adminMenu.setForeground(Color.RED);
        menuBar.add(adminMenu);

        JMenuItem addEmployeeMenuItem = new JMenuItem("ADD EMPLOYEE");
        adminMenu.add(addEmployeeMenuItem);
        addEmployeeMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
//                    new AddEmployee().setVisible(true);
                } catch (Exception e) {
                }
            }
        });

        JMenuItem addRoomsMenuItem = new JMenuItem("ADD ROOMS");
        adminMenu.add(addRoomsMenuItem);
        addRoomsMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
//                    new AddRoom().setVisible(true);
                } catch (Exception e) {
                }
            }
        });

        receptionMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                new Reception();
            }
        });

        JMenuItem addDriversMenuItem = new JMenuItem("ADD DRIVERS");
        adminMenu.add(addDriversMenuItem);
        addDriversMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
//                    new AddDrivers().setVisible(true);
                } catch (Exception e) {
                }
            }
        });

        setSize(1950, 1090);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
    }
}