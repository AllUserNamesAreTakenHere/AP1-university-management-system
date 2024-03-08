

public class takhasossiCourses extends Courses {
    final String  typeOfThisCourse="TAKHASSOSI";


    public takhasossiCourses(String courseTitle, String professorName, String presenterCollege, String courseType, int courseCode, int courseVahed, int courseCapacity, int enrolledStudents,String[] classDays, double classBeginingHour, double classEndingHour, String finalExamMonth, int finalExamDay, double finalExamHour) {
        super(courseTitle, professorName, presenterCollege, courseType, courseCode, courseVahed, courseCapacity, enrolledStudents,classDays, classBeginingHour, classEndingHour, finalExamMonth, finalExamDay, finalExamHour);
        this.courseType=typeOfThisCourse;
    }
}


