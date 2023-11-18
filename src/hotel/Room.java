package hotel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import net.proteanit.sql.DbUtils;

public class Room extends JFrame {

    private JPanel panel;
    private JTable roomTable;
    private JLabel availabilityLabel, cleanStatusLabel, priceLabel, bedTypeLabel, roomNumberLabel;
    JButton loadDataButton, backButton;

    public Room() throws SQLException {
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setBounds(450, 200, 1100, 600);
        panel = new JPanel();
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(panel);
        panel.setLayout(null);

        ImageIcon imageIcon1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image image = imageIcon1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
        ImageIcon imageIcon2 = new ImageIcon(image);
        JLabel imageLabel = new JLabel(imageIcon2);
        imageLabel.setBounds(500, 0, 600, 600);
        add(imageLabel);

        roomTable = new JTable();
        roomTable.setBounds(0, 40, 500, 400);
        panel.add(roomTable);

        loadDataButton = new JButton("Load Data");
        loadDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    Connect connect = new Connect();
                    String displayRoomsSQL = "select * from Room";
                    ResultSet resultSet = connect.statement.executeQuery(displayRoomsSQL);
                    roomTable.setModel(DbUtils.resultSetToTableModel(resultSet));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        loadDataButton.setBounds(100, 470, 120, 30);
        loadDataButton.setBackground(Color.BLACK);
        loadDataButton.setForeground(Color.WHITE);
        panel.add(loadDataButton);

        backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Reception().setVisible(true);
                setVisible(false);
            }
        });
        backButton.setBounds(290, 470, 120, 30);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        panel.add(backButton);

        availabilityLabel = new JLabel("Availability");
        availabilityLabel.setBounds(119, 15, 69, 14);
        panel.add(availabilityLabel);

        cleanStatusLabel = new JLabel("Clean Status");
        cleanStatusLabel.setBounds(216, 15, 76, 14);
        panel.add(cleanStatusLabel);

        priceLabel = new JLabel("Price");
        priceLabel.setBounds(330, 15, 46, 14);
        panel.add(priceLabel);

        bedTypeLabel = new JLabel("Bed Type");
        bedTypeLabel.setBounds(417, 15, 76, 14);
        panel.add(bedTypeLabel);

        roomNumberLabel = new JLabel("Room Number");
        roomNumberLabel.setBounds(12, 15, 90, 14);
        panel.add(roomNumberLabel);

        getContentPane().setBackground(Color.WHITE);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    Room room = new Room();
                    room.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}