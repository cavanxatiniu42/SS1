package Controller;


import Model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thu Thuy Nguyen on 22/09/2016.
 */
public class StudentController extends ConnectDB{
    public StudentController(){
        super();
    }
    List<Student> studentList = new ArrayList<>();
    public boolean insertStudent(Student student){
        startConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO student (studentid, firstname, lastname, address, dateofbirth) VAlUES (?,?,?,?,?)");
            preparedStatement.setString(1, student.getStudentId());
            preparedStatement.setString(2, student.getFirstName());
            preparedStatement.setString(3, student.getLastName());
            preparedStatement.setString(4, student.getAddress());
            preparedStatement.setString(5, student.getDateOfBirth());
            preparedStatement.executeQuery();
            studentList.add(student);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return false;
    }
    public boolean editStudent (String id) throws SQLException {
        startConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE STUDENT SET firstname = ?, lastname =?, address =?, dateofbirth =? WHERE studentid = "+ id);
        for (Student student1 : studentList) {
                if (id.equals(student1.getStudentId())){
                    preparedStatement.setString(1, student1.getFirstName());
                    preparedStatement.setString(2,student1.getLastName());
                    preparedStatement.setString(3, student1.getAddress());
                    preparedStatement.setString(4, student1.getDateOfBirth());
                    preparedStatement.executeQuery();
                    return true;
                }
            }

        return false;
    }
    public boolean deleteStudent (String id) throws SQLException {
        startConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM STUDENT WHERE studentid =?");
        for (Student student : studentList) {
            if (student.getStudentId().equals(id)){
                preparedStatement.setString(1, student.getStudentId());
                preparedStatement.executeQuery();
                return true;
            }
        }
        return false;
    }
    public String displayStudent () {
        String sql = "SELECT * FROM STUDENT";
        String html = "";
        try (Statement statement = this.connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int count = resultSetMetaData.getColumnCount();
            html += "<table border=1>";
            html += "<tr>";
            for (int i = 0; i <= count; i++) {
                html += "<th>";
                html += resultSetMetaData.getColumnLabel(i);
            }
            html += "</tr>";
            while (resultSet.next()) {
                html += "<tr>";
                for (int i = 0; i <= count; i++) {
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
}
