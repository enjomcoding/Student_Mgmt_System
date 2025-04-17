package myproject.tijada_oop.SMS_DB;
import java.sql.*;

public class Connect_DB {
    private final static String DB_URL = "jdbc:mysql://localhost:3306/sms";
    private final static String USER = "root";
    private final static String PASS = "9eC0H84";
    
    public static Connection connect(){// Connect to the Database
        try {
            return DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println("Connection failed.");
            e.printStackTrace();
            return null;
        }
    }
}
