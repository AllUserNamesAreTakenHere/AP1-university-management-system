import java.util.ArrayList;
import java.util.List;

public class Student extends Users {

    String studentName;
    String studentLastName;
    String userName;
    String password;
    final String userType = "Student";

    public Student(String studentName, String studentLastName, String userName, String password, String userType) {
        super(userName, userType);
        // this.userType = "Student";
        this.studentName = studentName;
        this.studentLastName = studentLastName;
        this.userName = userName;
        this.password = password;
    }

    public List<Courses> EnrolledCourses = new ArrayList<>();

    public void setEnrolledCourses(List<Courses> enrolledCourses) {
        EnrolledCourses = enrolledCourses;
    }

    public List<Courses> getEnrolledCourses() {
        return EnrolledCourses;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }


}


