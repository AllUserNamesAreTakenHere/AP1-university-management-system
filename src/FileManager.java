import java.io.*;
import java.util.*;

public class FileManager {
    ManageCollegeCourses manageCollegeCourses;
    DataBase dataBase;

    public FileManager(ManageCollegeCourses manageCollegeCourses, DataBase dataBase) {
        this.manageCollegeCourses = manageCollegeCourses;
        this.dataBase = dataBase;
    }

    private final String relativePath = "src\\MyFiles";
    // former address:
    //C:\Users\ASUS\IdeaProjects\my code  back up\src\MyFiles
    private final File studentsTextFile = new File(relativePath + "/students.txt");
    private final File studentsCoursesTextFile = new File(relativePath + "/studentsCourses.txt");
    private final File courseStudentsList = new File(relativePath + "/courseStudents.txt");
    private final File newAddedCoursesFile = new File(relativePath + "/newCourses.txt");

    public void createUserFolderOnUserSignup(String name, String lastName, String username, String password) {
        try (FileWriter writer = new FileWriter(studentsTextFile, true)) {
            writer.write(name + "/" + lastName + "/" + username + "/" + password + "/" + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Set<Student> readStudentFromUsersText() {
        try {
            Set<Student> students = new HashSet<>();
            FileReader fileReader = new FileReader(studentsTextFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] strings = line.split("/");
                students.add(new Student(strings[0], strings[1], strings[2], strings[3], "Student"));
            }

            bufferedReader.close();
            fileReader.close();
            return students;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void writeTakenCoursesToFile(Student student, Courses chosenCourse) {
        try (FileWriter writer = new FileWriter(relativePath + "/studentsCourses.txt", true)) {
            writer.write(student.getUserName() + "/" + chosenCourse.getCourseTitle() + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Courses> reedTakenCoursesFromFile(Student student) {
        try {
            List<Courses> studentsCourses = new ArrayList<>();
            FileReader fileReader = new FileReader(studentsCoursesTextFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String string[] = line.split("/");
                if (string[0].equals(student.getUserName())) {
                    for (Courses courses : manageCollegeCourses.AllCourses) {
                        if (courses.getCourseTitle().equals(string[1])) {
                            studentsCourses.add(courses);
                        }
                    }
                }
            }
            bufferedReader.close();
            fileReader.close();
            return studentsCourses;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void removeRemovedCoursesFromFile(Student student, Courses course) {
        File studentsCoursesTextFile = new File(relativePath + "/studentsCourses.txt");
        List<String> linesToKeep = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(studentsCoursesTextFile))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split("/");
                if (parts[0].equals(student.getUserName()) && parts[1].equals(course.getCourseTitle())) {
                } else {
                    linesToKeep.add(line);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (FileWriter writer = new FileWriter(studentsCoursesTextFile)) {
            for (String line : linesToKeep) {
                writer.write(line + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeStudentToCourseList(Student student, Courses course) {
        try (FileWriter writer = new FileWriter(relativePath + "/courseStudents.txt", true)) {
            writer.write(student.getUserName() + "/" + course.getCourseTitle() + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Student> reedStudentsFromFile(Courses course) {
        try {
            List<Student> coursesStudents = new ArrayList<>();
            FileReader fileReader = new FileReader(courseStudentsList);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String string[] = line.split("/");
                if (string[1].equals(course.getCourseTitle())) {
                    for (Student student : dataBase.getMembersList()) {
                        if (student.getUserName().equals(string[0])) {
                            coursesStudents.add(student);
                            // System.out.println(student.getUserName());
                        }
                    }
                }
            }
            bufferedReader.close();
            fileReader.close();
            return coursesStudents;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void removeRemovedStudentsFromCourseList(Student student, Courses course) {
        File studentsCoursesTextFile = new File(relativePath + "/courseStudents.txt");
        List<String> linesToKeep = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(studentsCoursesTextFile))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split("/");
                if (parts[0].equals(student.getUserName()) && parts[1].equals(course.getCourseTitle())) {
                } else {
                    linesToKeep.add(line);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (FileWriter writer = new FileWriter(studentsCoursesTextFile)) {
            for (String line : linesToKeep) {
                writer.write(line + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    /*public void addedCoursesFromCenter(Courses course) {
        try (FileWriter writer = new FileWriter(relativePath  + "/new courses.txt", true)) {
            writer.write(course.getCourseTitle() + "/" + course.getProfessorName() + "/" + course.getPresenterCollege() + "/" +
                    course.getCourseType() + "/" + course.getCourseCode() + "/" + course.getCourseVahed() + "/" + course.getCourseCapacity() + "/" +
                    course.getEnrolledStudents() + "/" + Arrays.toString(course.getClassDays()) + "/" + course.getClassBeginningHour() + "/" +
                    course.getClassEndingHour() + "/" + course.getFinalExamMonth() + "/" + course.getFinalExamDay() + "/" + course.getFinalExamHour() + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        File newCourseFolder = new File(relativePath + course.getCourseCode());
        if (!newCourseFolder.mkdir()) return;
        File file = new File(relativePath + "/" + course.getCourseCode() + "/" + "newCourses.txt");
        try (FileWriter writer = new FileWriter(file)) {
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Courses> reedNewAddedCourses(){
        try {
            List<Courses> newCourses = new ArrayList<>();
            FileReader fileReader = new FileReader(newAddedCoursesFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String string[] = line.split("/");
                if(string[3].equals("OMOUMI")){
                    omumiCourses course=new omumiCourses(string[0],string[1],string[2],string[3],string[4],string[5],string[6],string[7],
                            string[8],string[9],string[10],string[11],string[12],string[13]);
                }
            }
            bufferedReader.close();
            fileReader.close();
            return newCourses;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }*/
}
