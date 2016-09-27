package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Thu Thuy Nguyen on 22/09/2016.
 */
public class ConnectDB {
    private final String DB_TYPE = "org.postgresql.Driver";
    private final String URL ="jdbc:postgresql://localhost:5432/courseman";
    private final String USER_NAME = "postgres";
    private final String PASSWORD = "123456";
    protected Connection connection;

    public ConnectDB(){
        try {
            Class.forName(DB_TYPE);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void startConnection(){
        try {
            connection = DriverManager.getConnection(URL,USER_NAME,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void closeConnection(){
        try {
            this.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
