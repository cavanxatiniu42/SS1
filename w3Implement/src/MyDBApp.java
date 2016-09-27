import java.sql.*;
import java.util.Properties;

public class MyDBApp {
    private Connection connection;
    private String dbType;

    public MyDBApp(String dbType) {}

    /**
     * This method is used to connect to the database
     * @require
     * @param dbName String cannot be null
     * @param userName String cannot be null
     * @param password String cannot be null
     *
     * @effect
     *  Connect to database and return true if succeed and false if failed
     *
     * @modify
     *  this.connection
     *
     * @return boolean
     */
    public boolean connect (String dbName, String userName, String password) throws SQLException{
        connection = null;
        try {
            Class.forName(dbType);
            connection = DriverManager.getConnection(dbName, userName, password);
            return true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * This method is used to get rows and columns of the database according to sql statement
     * @require
     * @param sql String cannot be null
     *
     * @effect
     *  if sql is invalid
     *      throws exception
     *  else
     *      get data from database and transmit to ResultSet and display on html page
     *
     * @modify resultSet
     *
     * @return String
     */
    public String select (String sql){
        String html ="";
        try(Statement statement = this.connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(sql);
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int count = resultSetMetaData.getColumnCount();
            html += "<table border=1>";
            html += "<tr>";
            for (int i = 0; i <= count ; i++) {
                html += "<th>";
                html += resultSetMetaData.getColumnLabel(i);
            }
            html += "</tr>";
            while (resultSet.next()){
                html += "<tr>";
                for (int i = 0; i <= count ; i++) {
                    html += "<td>";
                    html += resultSet.getString(i);
                    html += "</td>";
                }
                html += "</tr>";
                html += "</table>";
                return html;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * This method is used to update data in the database
     * @require
     * @param sql String cannot be null
     *
     * @effect
     *  if sql is invalid
     *      throws exception
     *      return false
     *  else
     *      update data in the database
     *      return true
     *
     * @modify data
     *
     * @return boolean
     */
    public boolean update (String sql){
        try(Statement statement = this.connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Failed to update");
            e.printStackTrace();
        }
        return false;
    }

    /**
     * This method is used to delete data in the database
     * @param sql String cannot be null
     *
     * @effect
     *  if sql is invalid
     *      throws exception
     *      return false
     *  else
     *      delete data in the database
     *      return true
     *
     * @modify data
     * @return boolean
     */
    public boolean delete (String sql){
        try(Statement statement = this.connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Failed to delete");
            e.printStackTrace();
        }
        return false;
    }

    /**
     * This method is used to insert data into the database
     * @require
     * @param sql String cannot be null
     *
     * @effect
     *  if sql is invalid
     *      throws exception
     *      return false
     *  else
     *      insert data into the database
     *      return true
     *
     * @modify data
     * @return boolean
     */
    public boolean insert (String sql){

        try(Statement statement = this.connection.createStatement()){
            statement.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            System.out.println("Failed to insert into database");
            e.printStackTrace();
        }
        return false;
    }

    /**
     * This method is used to close the database
     * @modify this.connection
     *
     */
    public void close(){
        try {
            this.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
