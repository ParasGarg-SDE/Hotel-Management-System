package hotel;

import java.sql.*;

public class Connect {

    Connection connection;
    Statement statement;

    public Connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql:///hms", "root", "Password");
            statement = connection.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}