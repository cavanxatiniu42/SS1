import Controller.StudentController;
import Model.Student;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by Thu Thuy Nguyen on 27/09/2016.
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        int option;
        StudentController studentController = new StudentController();
        do {
            TextIO.putln("CourseMan Application");
            TextIO.putln("==========================");
            TextIO.putln("Choose your selection");
            TextIO.putln("1. Manage Student");
            TextIO.putln("2. Manage Course");
            TextIO.putln("3. Manage Enrolment");
            TextIO.putln("4. Reports");
            TextIO.putln("0. Quit");
            switch (option = TextIO.getInt()){
                case 1:
                    do {
                        TextIO.putln("1. Add a student");
                        TextIO.putln("2. Edit student profile");
                        TextIO.putln("3. Delete a student");
                        TextIO.putln("4. Display all students");
                        TextIO.putln("5. Quit");
                        switch (option = TextIO.getInt()){
                            case 1:
                                TextIO.putln("Input number of student in currency");
                                int number = TextIO.getInt();
                                TextIO.putln("Input first name: ");
                                String firstName = TextIO.getlnString();
                                TextIO.putln("Input last name");
                                String lastName = TextIO.getlnString();
                                TextIO.putln("Input address: ");
                                String address = TextIO.getlnString();
                                TextIO.putln("Input date of birth");
                                String dateOfBirth = TextIO.getlnString();
                                Student student = new Student(number,firstName, lastName, address, dateOfBirth);
                                if (studentController.insertStudent(student)){
                                    TextIO.putln("successful");
                                } else {
                                    TextIO.putln("Failed");
                                }
                                break;
                            case 2:
                                TextIO.putln("Input student Id want to edit");
                                String studentId = TextIO.getlnString();
                                if (studentController.editStudent(studentId)){
                                    TextIO.putln("successful");
                                } else {
                                    TextIO.putln("failed");
                                }
                                break;
                            case 3:
                                TextIO.putln("Input Id of student want to delete");
                                String studentDeleteId = TextIO.getlnString();
                                if (studentController.deleteStudent(studentDeleteId)){
                                    TextIO.putln("successful");
                                } else {
                                    TextIO.putln("Failed");
                                }
                                break;
                            case 4:
                                TextIO.putln("Display all students in html file");
                                studentController.displayStudent();




                        }
                    }while (option != 0);
            }
        } while (option != 0);
    }
}
