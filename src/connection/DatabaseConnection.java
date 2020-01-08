package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/GLA?serverTimezone=IST";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "";

    private static Connection connection = null;
    public Connection getConnection()
    {return connection;}
        public void attemptConnection() throws ClassNotFoundException, SQLException {
        //Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(URL,
                USERNAME,PASSWORD );
        if (connection != null) {

            System.out.println("connection ok");
            //connection.close();
        }else{
            System.out.println("connection failed");
        }

    }

}
