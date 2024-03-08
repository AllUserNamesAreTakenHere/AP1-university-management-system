import java.util.ArrayList;
import java.util.List;

public abstract class Courses {
    public String courseTitle;
    public String professorName ;
    public  String presenterCollege;
    public String courseType;
    public int courseCode;
    // courseCode= presenterCollegeCode + a randaom number
    public int courseVahed;
    public int courseCapacity;
    public int enrolledStudents;
    public String[] classDays;
    public double classBeginningHour;
    public double classEndingHour;
    public String finalExamMonth;
    public int finalExamDay;
    public double finalExamHour;



    public Courses(String courseTitle,String professorName, String presenterCollege,String courseType,int courseCode,int courseVahed,int courseCapacity,
                   int enrolledStudents,String[] classDays,double classBeginningHour,double classEndingHour,String finalExamMonth,int finalExamDay,double finalExamHour) {
        this.courseTitle=courseTitle;
        this.professorName = professorName;
        this.presenterCollege=presenterCollege;
        this.courseType = courseType;
        this.courseCode=courseCode;
        this.courseVahed=courseVahed;
        this.courseCapacity=courseCapacity;
        this.enrolledStudents=enrolledStudents;
        this.classBeginningHour =classBeginningHour;
        this.classEndingHour=classEndingHour;
        this.finalExamMonth=finalExamMonth;
        this.finalExamDay=finalExamDay;
        this.finalExamHour=finalExamHour;
        this.classDays=classDays;
    }
    public List<Student> StudentsList=new ArrayList<>();

    public List<Student> getStudentsList() {
        return StudentsList;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public String getProfessorName() {
        return professorName;
    }

    public String getPresenterCollege() {
        return presenterCollege;
    }

    public String getCourseType() {
        return courseType;
    }

    public int getCourseCode() {
        return courseCode;
    }

    public int getCourseVahed() {
        return courseVahed;
    }

    public int getCourseCapacity() {
        return courseCapacity;
    }

    public int getEnrolledStudents() {
        return enrolledStudents;
    }

    public String[] getClassDays() {
        return classDays;
    }

    public double getClassBeginningHour() {
        return classBeginningHour;
    }

    public double getClassEndingHour() {
        return classEndingHour;
    }

    public String getFinalExamMonth() {
        return finalExamMonth;
    }

    public int getFinalExamDay() {
        return finalExamDay;
    }

    public double getFinalExamHour() {
        return finalExamHour;
    }

    public void setCourseCapacity(int i) {
        courseCapacity=i;
    }

    public void setEnrolledStudents(int i) {
        enrolledStudents=i;
    }

    public void setStudentsList(List<Student> studentsList) {
        StudentsList = studentsList;
    }
}

