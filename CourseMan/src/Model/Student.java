package Model;

import java.time.LocalDate;

/**
 * Created by Thu Thuy Nguyen on 22/09/2016.
 */
public class Student {
    private String studentId;
    private String firstName;
    private String lastName;
    private String address;
    private String dateOfBirth;

    public Student(int no, String firstName, String lastName, String address, String dateOfBirth) {
        this.studentId = generateId(no);
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
    }

    public String generateId(int no){
        int number = LocalDate.now().getYear()*1000 + no +1;
        String id = "$" + number;
        return id;
    }
    public String getStudentId() {
        return studentId;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
