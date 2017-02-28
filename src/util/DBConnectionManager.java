package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionManager {
    private static Connection connection;

    public DBConnectionManager(String dbURL, String user, String pwd) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(dbURL, user, pwd);
        System.out.println(connection);
        System.out.println("connection has been set up");
    }

    public static Connection getConnection(){
        return connection;
    }
}
