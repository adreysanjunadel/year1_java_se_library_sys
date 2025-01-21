package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;

/**
 *
 * @author Sanjuna
 */
public class MySQL {

    public static Connection connection;

    public static final String URL = "jdbc:mysql://localhost:3306/library_db";
    public static final String username = "root";
    public static final String password = "YOUR_PASSWORD_HERE";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ResultSet execute(String query) throws Exception {
        Statement statement = connection.createStatement();

        if (query.startsWith("SELECT")) {
            ResultSet resultSet = statement.executeQuery(query);
            return resultSet;
        } else {
            int resultSet = statement.executeUpdate(query);
            return null;
        }
    }
    
    // New method for creating a prepared statement
    public static PreparedStatement prepareStatement(String query) throws Exception {
        return connection.prepareStatement(query);
    }

}
