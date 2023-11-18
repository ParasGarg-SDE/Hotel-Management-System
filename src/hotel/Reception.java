package hotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame {
    private JPanel panel;
    JButton newCustomerFormButton, roomButton, allEmployeeInfoButton, customerInfoButton, managerInfoButton, checkOutButton;
    JButton updateCheckStatusButton, updateRoomStatusButton, pickUpServiceButton, searchRoomButton, logOutButton;

    public Reception() {
        setBounds(530, 200, 850, 570);
        panel = new JPanel();
        setContentPane(panel);
        panel.setLayout(null);

        ImageIcon imageIcon1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        Image image = imageIcon1.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
        ImageIcon imageIcon2 = new ImageIcon(image);
        JLabel imageLabel = new JLabel(imageIcon2);
        imageLabel.setBounds(250, 30, 500, 470);
        add(imageLabel);

        newCustomerFormButton = new JButton("New Customer Form");
        newCustomerFormButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    NewCustomer newCustomer = new NewCustomer();
                    newCustomer.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        newCustomerFormButton.setBounds(10, 30, 200, 30);
        newCustomerFormButton.setBackground(Color.BLACK);
        newCustomerFormButton.setForeground(Color.WHITE);
        panel.add(newCustomerFormButton);

        roomButton = new JButton("Room");
        roomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    Room room = new Room();
                    room.setVisible(true);
                    setVisible(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        roomButton.setBounds(10, 70, 200, 30);
        roomButton.setBackground(Color.BLACK);
        roomButton.setForeground(Color.WHITE);
        panel.add(roomButton);

        allEmployeeInfoButton = new JButton("All Employee Info");
        allEmployeeInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    Employee employee = new Employee();
                    employee.setVisible(true);
                    setVisible(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        allEmployeeInfoButton.setBounds(10, 150, 200, 30);
        allEmployeeInfoButton.setBackground(Color.BLACK);
        allEmployeeInfoButton.setForeground(Color.WHITE);
        panel.add(allEmployeeInfoButton);

        customerInfoButton = new JButton("Customer Info");
        customerInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    CustomerInfo customer = new CustomerInfo();
                    customer.setVisible(true);
                    setVisible(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        customerInfoButton.setBounds(10, 190, 200, 30);
        customerInfoButton.setBackground(Color.BLACK);
        customerInfoButton.setForeground(Color.WHITE);
        panel.add(customerInfoButton);

        managerInfoButton = new JButton("Manager Info");
        managerInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    ManagerInfo managerInfo = new ManagerInfo();
                    managerInfo.setVisible(true);
                    setVisible(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        managerInfoButton.setBounds(10, 230, 200, 30);
        managerInfoButton.setBackground(Color.BLACK);
        managerInfoButton.setForeground(Color.WHITE);
        panel.add(managerInfoButton);

        checkOutButton = new JButton("Check Out");
        checkOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                CheckOut check = new CheckOut();
                check.setVisible(true);
                setVisible(false);
            }
        });
        checkOutButton.setBounds(10, 270, 200, 30);
        checkOutButton.setBackground(Color.BLACK);
        checkOutButton.setForeground(Color.WHITE);
        panel.add(checkOutButton);

        updateCheckStatusButton = new JButton("Update Check Status");
        updateCheckStatusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    UpdateCheck update = new UpdateCheck();
                    update.setVisible(true);
                    setVisible(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        updateCheckStatusButton.setBounds(10, 310, 200, 30);
        updateCheckStatusButton.setBackground(Color.BLACK);
        updateCheckStatusButton.setForeground(Color.WHITE);
        panel.add(updateCheckStatusButton);

        updateRoomStatusButton = new JButton("Update Room Status");
        updateRoomStatusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    UpdateRoom room = new UpdateRoom();
                    room.setVisible(true);
                    setVisible(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        updateRoomStatusButton.setBounds(10, 350, 200, 30);
        updateRoomStatusButton.setBackground(Color.BLACK);
        updateRoomStatusButton.setForeground(Color.WHITE);
        panel.add(updateRoomStatusButton);

        pickUpServiceButton = new JButton("Pick up Service");
        pickUpServiceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    PickUp pick = new PickUp();
                    pick.setVisible(true);
                    setVisible(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        pickUpServiceButton.setBounds(10, 390, 200, 30);
        pickUpServiceButton.setBackground(Color.BLACK);
        pickUpServiceButton.setForeground(Color.WHITE);
        panel.add(pickUpServiceButton);

        searchRoomButton = new JButton("Search Room");
        searchRoomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    SearchRoom search = new SearchRoom();
                    search.setVisible(true);
                    setVisible(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        searchRoomButton.setBounds(10, 430, 200, 30);
        searchRoomButton.setBackground(Color.BLACK);
        searchRoomButton.setForeground(Color.WHITE);
        panel.add(searchRoomButton);

        logOutButton = new JButton("Log Out");
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    new Login().setVisible(true);
                    setVisible(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        logOutButton.setBounds(10, 470, 200, 30);
        logOutButton.setBackground(Color.BLACK);
        logOutButton.setForeground(Color.WHITE);
        panel.add(logOutButton);

        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Reception();
    }
}