package hotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRoom extends JFrame implements ActionListener {

    private JPanel panel;
    JLabel addRoomsLabel, roomNoLabel, availabilityLabel, cleaningStatusLabel, priceLabel, bedTypeLabel;
    private JTextField roomNoTextField, priceTextField;
    private JComboBox availabilityComboBox, cleaningStatusComboBox, bedTypeComboBox;
    JButton addButton, backButton;

    public AddRoom() {
        setBounds(450, 200, 1000, 450);
        panel = new JPanel();
        setContentPane(panel);
        panel.setLayout(null);

        ImageIcon imageIcon1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        Image image = imageIcon1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon imageIcon2 = new ImageIcon(image);
        JLabel imageLabel = new JLabel(imageIcon2);
        imageLabel.setBounds(400, 30, 500, 370);
        add(imageLabel);

        addRoomsLabel = new JLabel("Add Rooms");
        addRoomsLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        addRoomsLabel.setBounds(194, 10, 120, 22);
        panel.add(addRoomsLabel);

        roomNoLabel = new JLabel("Room Number");
        roomNoLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        roomNoLabel.setForeground(new Color(25, 25, 112));
        roomNoLabel.setBounds(64, 70, 102, 22);
        panel.add(roomNoLabel);

        roomNoTextField = new JTextField();
        roomNoTextField.setBounds(174, 70, 156, 20);
        panel.add(roomNoTextField);

        availabilityLabel = new JLabel("Availability");
        availabilityLabel.setForeground(new Color(25, 25, 112));
        availabilityLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        availabilityLabel.setBounds(64, 110, 102, 22);
        panel.add(availabilityLabel);

        availabilityComboBox = new JComboBox(new String[]{"Available", "Occupied"});
        availabilityComboBox.setBounds(176, 110, 154, 20);
        panel.add(availabilityComboBox);


        cleaningStatusLabel = new JLabel("Cleaning Status");
        cleaningStatusLabel.setForeground(new Color(25, 25, 112));
        cleaningStatusLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        cleaningStatusLabel.setBounds(64, 150, 102, 22);
        panel.add(cleaningStatusLabel);

        cleaningStatusComboBox = new JComboBox(new String[]{"Cleaned", "Dirty"});
        cleaningStatusComboBox.setBounds(176, 150, 154, 20);
        panel.add(cleaningStatusComboBox);

        priceLabel = new JLabel("Price");
        priceLabel.setForeground(new Color(25, 25, 112));
        priceLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        priceLabel.setBounds(64, 190, 102, 22);
        panel.add(priceLabel);

        priceTextField = new JTextField();
        priceTextField.setBounds(174, 190, 156, 20);
        panel.add(priceTextField);

        bedTypeLabel = new JLabel("Bed Type");
        bedTypeLabel.setForeground(new Color(25, 25, 112));
        bedTypeLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        bedTypeLabel.setBounds(64, 230, 102, 22);
        panel.add(bedTypeLabel);

        bedTypeComboBox = new JComboBox(new String[]{"Single Bed", "Double Bed"});
        bedTypeComboBox.setBounds(176, 230, 154, 20);
        panel.add(bedTypeComboBox);


        addButton = new JButton("Add");
        addButton.addActionListener(this);
        addButton.setBounds(64, 321, 111, 33);
        addButton.setBackground(Color.BLACK);
        addButton.setForeground(Color.WHITE);
        panel.add(addButton);

        backButton = new JButton("Back");
        backButton.addActionListener(this);
        backButton.setBounds(198, 321, 111, 33);
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
                    String roomNumber = roomNoTextField.getText();
                    String availability = (String) availabilityComboBox.getSelectedItem();
                    String cleanStatus = (String) cleaningStatusComboBox.getSelectedItem();
                    String price = priceTextField.getText();
                    String bedType = (String) bedTypeComboBox.getSelectedItem();

                    String insertQuery = "INSERT INTO room values( '" + roomNumber + "', '" + availability + "', '" + cleanStatus + "','" + price + "', '" + bedType + "')";

                    connect.statement.executeUpdate(insertQuery);
                    JOptionPane.showMessageDialog(null, "Room Successfully Added");
                    this.setVisible(false);
                } catch (Exception e) {
                    System.out.println(e);
                }
            } else if (actionEvent.getSource() == backButton) {
                this.setVisible(false);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new AddRoom().setVisible(true);
    }
}