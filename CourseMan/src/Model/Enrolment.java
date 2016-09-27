package Model;

/**
 * Created by Thu Thuy Nguyen on 22/09/2016.
 */
public class Enrolment {
    private Student student;
    private Course course;
    private int semester;
    private char finalGrade;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public char getFinalGrade() {
        return finalGrade;
    }

    public void setFinalGrade(char finalGrade) {
        this.finalGrade = finalGrade;
    }
}
