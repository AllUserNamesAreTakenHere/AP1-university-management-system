import java.util.Arrays;
import java.util.Scanner;

public class AdminCli {
    DataBase dataBase;
    CliConnector cliConnector;
    ManageCollegeCourses manageCollegeCourses;
    FileManager fileManager;
    Scanner scanner = new Scanner(System.in);

    public AdminCli(DataBase dataBase, CliConnector cliConnector, ManageCollegeCourses manageCollegeCourses, FileManager fileManager) {
        this.cliConnector = cliConnector;
        this.dataBase = dataBase;
        this.manageCollegeCourses = manageCollegeCourses;
        this.fileManager=fileManager;
    }

    public void init() {
        System.out.println("<< welcome administrator >>");
        System.out.println("Options : \n 1. Add a course \n 2.Remove a course \n 3.show course details. \n Enter 0 to return to the main menu");
        int response = scanner.nextInt();
        scanner.nextLine();
        switch (response) {
            case 1:
                CreateNewCourse();
                break;
            case 2:
                RemoveCourse();
                break;
            case 3:
                CourseInfo();
                break;
            case 0:
                cliConnector.init();
                break;
            default:
                System.out.println("invalid input please try again.");
                init();

        }


    }

    private void CreateNewCourse() {
        System.out.println("choose the college that presents this course.");
        System.out.println("college code : 20 ___ Mathematics Sciences");
        System.out.println("college code : 23 ___ Computer Engineering");
        System.out.println("college code : 27 ___ Chemical Engineering");
        System.out.println("college code : 24 ___ Physics");
        System.out.println("college code : 31 ___ Language And Literature");
        System.out.println("Enter college code to see list of courses.");
        System.out.println("Enter 0 to return to main menu and 2 to exit page.");
        int response = scanner.nextInt();
        scanner.nextLine();
        if (response == 0) {
            init();
        }
        if (response == 2) {
            cliConnector.init();
        }
        // check if it is gonna be added to all courses or not .
        if (response == 20 || response == 23 || response == 27 || response == 24 || response == 31) {
            System.out.println("Please fill the following fields about the new course.\n Make sure to follow the rules for setting a code for this course.");
            System.out.print("Course Title : ");
            String courseTitle = scanner.next();
            scanner.nextLine();
            System.out.print("Professor Name : ");
            String professorName = scanner.next();
            scanner.nextLine();
            System.out.print("Course Presenter College : ");
            String presenterCollege = scanner.next();
            scanner.nextLine();
            System.out.print("Course Type : ");
            String courseType = scanner.next();
            scanner.nextLine();
            System.out.print("Course Code : ");
            int courseCode = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Course Vahed : ");
            int courseVahed = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Course Capacity : ");
            int courseCapacity = scanner.nextInt();
            scanner.nextLine();
            int EnrolledStudents = 0;
            System.out.print("Class Beginning Hour : ");
            double classBeginningHour = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Class Ending Hour : ");
            double classEndingHour = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Final Exam Month : ");
            String finalExamMonth = scanner.next();
            scanner.nextLine();
            System.out.print("Final Exam Day : ");
            int finalExamDay = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Final Exam Hour : ");
            double finalExamHour = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Class Days : ");
            String[] classDays = new String[]{scanner.next()};
            scanner.nextLine();
            System.out.println("Form completed.");
            if (courseType.equals("OMOUMI")) {
                omumiCourses course = new omumiCourses(courseTitle, professorName, presenterCollege, courseType, courseCode, courseVahed, courseCapacity,
                        EnrolledStudents, classDays, classBeginningHour, classEndingHour, finalExamMonth, finalExamDay, finalExamHour);
                if (courseCode / 1000 == 31) {
                    manageCollegeCourses.getListOfLanguageAndLiteratureCollegeCourses().add(course);
                }
            } else if (courseType.equals("TAKHASSOSI")) {
                takhasossiCourses course = new takhasossiCourses(courseTitle, professorName, presenterCollege, courseType, courseCode, courseVahed, courseCapacity,
                        EnrolledStudents, classDays, classBeginningHour, classEndingHour, finalExamMonth, finalExamDay, finalExamHour);
                if (courseCode / 1000 == 20) {
                    manageCollegeCourses.getListOfMathCollegeCourses().add(course);
                } else if (courseCode / 1000 == 23) {
                    manageCollegeCourses.getListOfComputerEngineeringCollegeCourses().add(course);
                } else if (courseCode / 1000 == 27) {
                    manageCollegeCourses.getListOfChemicalEngineeringCollegeCourses().add(course);
                } else if (courseCode / 1000 == 24) {
                    manageCollegeCourses.getListOfPhysicsCollegeCourses().add(course);
                }
            }
            System.out.println("Course added to list successfully .\n Enter 0 to return to previous page \n Enter 2 to exit program.");
            int response1 = scanner.nextInt();
            scanner.nextLine();
            if (response1 == 0) {
                init();
            } else if (response1 == 2) {
                cliConnector.init();
            } else {
                System.out.println("Please enter a valid answer.");
                CreateNewCourse();
            }
        } else {
            System.out.println("Please enter a valid response !");
            CreateNewCourse();
        }
    }

    private void CourseInfo() {
        // check if such a code exits or not!
        boolean validation = false;
        System.out.println("Enter the code of the intended course.");
        System.out.println("Enter 0 to return to main menu and 2 to exit page.");
        int code = scanner.nextInt();
        scanner.nextLine();
        if (code == 0) {
            init();
        }
        if (code == 2) {
            cliConnector.init();
        } else {
            for (Courses course : manageCollegeCourses.AllCourses) {
                if (course.getCourseCode() == code) {
                    validation = true;
                }
                if (validation) {
                    course.setStudentsList(fileManager.reedStudentsFromFile(course));
                    course.setEnrolledStudents(course.getStudentsList().size());
                    System.out.println("****************************************************************************************");
                    System.out.println("course title : " + course.getCourseTitle() + "    #####   vahed : " + course.getCourseVahed());
                    System.out.println("course code : " + course.getCourseCode() + "    #####    professor : " + course.getProfessorName());
                    System.out.println("College : " + course.getPresenterCollege() + "    #####   capacity : " + course.getCourseCapacity());
                    System.out.println("enrolled students : " + course.getEnrolledStudents() + "     #####   class days : " + Arrays.toString(course.getClassDays()));
                    System.out.println("class beginning hour : " + course.getClassBeginningHour() + "     #####   class ending hour : " + course.getClassEndingHour());
                    System.out.println("final exam date : " + course.getFinalExamMonth() + " " + course.getFinalExamDay() + "th" + "     #####   final exam hour : " + course.getFinalExamHour());
                    System.out.println("****************************************************************************************");
                    System.out.println("Options : \n 1. increase/decrease course capacity \n 2.show students of the course \n Enter 0 to return to previous page and 5 to exit page.");
                    int num = scanner.nextInt();
                    scanner.nextLine();
                    switch (num) {
                        case 1:
                            ChangeCourseCapacity(course);
                            break;
                        case 2:
                            ShowStudentsList(course);
                            break;
                        case 0:
                            CourseInfo();
                            break;
                        case 5:
                            cliConnector.init();
                            break;
                        default:

                    }
                }
            }
        }
        if (!validation) {
            System.out.println("There is no course with the given code.\n Please try again. ");
            CourseInfo();
        }
    }

    private void ShowStudentsList(Courses intendedCourse) {
        intendedCourse.setStudentsList(fileManager.reedStudentsFromFile(intendedCourse));
        intendedCourse.setEnrolledStudents(intendedCourse.getStudentsList().size());
        System.out.println("List of students : ");
        for (Student student : intendedCourse.StudentsList) {
            System.out.println("Student username : "+student.getUserName() + " __ Student name : " + student.getStudentName() + " " + student.getStudentLastName());
        }
        System.out.println("Options : \n 1.Add a student to this course \n 2.Remove a student from this course \n 3.Return to previous page\n 4.Return to main menu");
        int num = scanner.nextInt();
        scanner.nextLine();
        switch (num) {
            case 1:
                AddStudentToList(intendedCourse);
            case 2:
                RemoveStudentFromList(intendedCourse);
            case 3:
                CourseInfo();
                break;
            case 4:
                cliConnector.init();
            default:
                System.out.println("Please enter a valid response.");
                ShowStudentsList(intendedCourse);
        }
    }

    private void AddStudentToList(Courses intendedCourse) {
        dataBase.setMembersList(fileManager.readStudentFromUsersText());
        System.out.println("Enter student username.");
        System.out.println("Enter 0 to return to previous page or enter 2 to exit program .");
        System.out.print("UserName : ");
        String username = scanner.next();
        scanner.nextLine();
        if (username.equals("0")) {
            ShowStudentsList(intendedCourse);
        } else if (username.equals("2")) {
            cliConnector.init();
        }
        boolean studentExistence = false;
        int index = -1;
        for (Student student : dataBase.MembersList) {
            student.setEnrolledCourses(fileManager.reedTakenCoursesFromFile(student));
            if (student.getUserName().equals(username)) {
                studentExistence = true;
                // search his/her course list.
                boolean studentHasIntendedCourse = false;
                for (Courses course : student.getEnrolledCourses()) {
                    if (intendedCourse.getCourseCode() == course.getCourseCode()) {
                        studentHasIntendedCourse = true;
                        System.out.println("Student already has the course .\n Enter 0 to try again or 1 to return to previous page or 2 to exit page.");
                        int response = scanner.nextInt();
                        scanner.nextLine();
                        switch (response) {
                            case 0:
                                AddStudentToList(intendedCourse);
                            case 1:
                                ShowStudentsList(intendedCourse);
                            case 2:
                                cliConnector.init();
                            default:
                                System.out.println("Please enter a valid response!");
                                AddStudentToList(intendedCourse);
                        }
                    }
                    if (!studentHasIntendedCourse) {
                        //TODO
                        /*student.EnrolledCourses.add(intendedCourse);
                        intendedCourse.StudentsList.add(student);
                        int temp = intendedCourse.getEnrolledStudents();*/
                        //intendedCourse.setEnrolledStudents(temp + 1);
                        // chosenCourse.StudentsList.add(student);
                        // chosenCourse.StudentsList.add(student);
                        fileManager.writeStudentToCourseList(student,intendedCourse);
                        intendedCourse.setStudentsList(fileManager.reedStudentsFromFile(intendedCourse));
                        fileManager.writeTakenCoursesToFile(student,intendedCourse);
                        student.setEnrolledCourses(fileManager.reedTakenCoursesFromFile(student));
                        System.out.println("Student was successfully added to the course .");
                        System.out.println("Options : \n  1.Enter 0 to return to previous page . \n  2.Enter 2 to exit program.");
                        int response = scanner.nextInt();
                        scanner.nextLine();
                        if (response == 0) {
                            ShowStudentsList(intendedCourse);
                        } else if (response == 2) {
                            cliConnector.init();
                        } else {
                            System.out.println("Please enter a valid response!");
                            AddStudentToList(intendedCourse);
                        }
                    }
                }
            }
        }
        if (!studentExistence) {
            System.out.println("Student with given username does not exist . Please try again.");
            RemoveStudentFromList(intendedCourse);
        }
    }

    private void RemoveStudentFromList(Courses intendedCourse) {
        dataBase.setMembersList(fileManager.readStudentFromUsersText());
        System.out.println("Enter student username.");
        System.out.println("Enter 0 to return to previous page or enter 2 to exit program .");
        System.out.print("UserName : ");
        String username = scanner.next();
        scanner.nextLine();
        if (username.equals("0")) {
            //TODO
            ShowStudentsList(intendedCourse);
        } else if (username.equals("2")) {
            cliConnector.init();
        }
        boolean studentExistence = false;
        int index = -1;
        for (Student student : dataBase.MembersList) {
            student.setEnrolledCourses(fileManager.reedTakenCoursesFromFile(student));
            if (student.getUserName().equals(username)) {
                studentExistence = true;
                // search his/her course list.
                boolean studentHasIntendedCourse = false;
                for (Courses course : student.EnrolledCourses) {
                    if (intendedCourse.getCourseCode() == course.getCourseCode()) {
                        studentHasIntendedCourse = true;
                        index = student.getEnrolledCourses().indexOf(intendedCourse);

                    }
                }
                if (studentHasIntendedCourse && index != -1) {
                    fileManager.removeRemovedCoursesFromFile(student,intendedCourse);
                    fileManager.removeRemovedStudentsFromCourseList(student,intendedCourse);
                    student.setEnrolledCourses(fileManager.reedTakenCoursesFromFile(student));
                    intendedCourse.setStudentsList(fileManager.reedStudentsFromFile(intendedCourse));
                    /*student.EnrolledCourses.remove(index);
                    int temp = intendedCourse.getEnrolledStudents();
                    intendedCourse.setEnrolledStudents(temp - 1);
                    intendedCourse.StudentsList.remove(student);*/
                    System.out.println("Options : \n  1.Enter 0 to return to previous page . \n  2.Enter 2 to exit program.");
                    int response = scanner.nextInt();
                    scanner.nextLine();
                    if (response == 0) {
                        ShowStudentsList(intendedCourse);
                    } else if (response == 2) {
                        cliConnector.init();
                    } else {
                        System.out.println("Please enter a valid response!");
                        RemoveStudentFromList(intendedCourse);
                    }

                }

                if (!studentHasIntendedCourse) {
                    System.out.println("Student does not have the course .Please try again.");
                    RemoveStudentFromList(intendedCourse);
                }
            }
        }
        if (!studentExistence) {
            System.out.println("Student with given username does not exist. Please try again.");
            RemoveStudentFromList(intendedCourse);
        }
    }

    private void ChangeCourseCapacity(Courses course) {
        System.out.println("Enter the intended number for class capacity");
        int newCapacity = scanner.nextInt();
        scanner.nextLine();
        if (course.getCourseCapacity() == newCapacity) {
            System.out.println("Course capacity is already " + newCapacity);
        }
        if (course.getCourseCapacity() < newCapacity) {
            course.setCourseCapacity(newCapacity);
        }
        if (course.getCourseCapacity() > newCapacity) {
            if (course.getEnrolledStudents() <= newCapacity) {
                course.setCourseCapacity(newCapacity);
            }
            if (course.getEnrolledStudents() > newCapacity) {
                System.out.println("more than " + newCapacity + " students are already enrolled in this course .you can not change the capacity ");
            }
        }

        System.out.println("Options : \n  1.Enter 0 to return to previous page . \n  2.Enter 2 to exit program.");
        int response = scanner.nextInt();
        scanner.nextLine();
        if (response == 0) {
            CourseInfo();
        } else if (response == 2) {
            cliConnector.init();
        } else {
            System.out.println("Please enter a valid response!");
            ChangeCourseCapacity(course);
        }
    }

    private void RemoveCourse() {
        System.out.println("Enter intended course code.");
        System.out.println("Enter 0 to return to previous page or 2 to exit program.");
        int code = scanner.nextInt();
        if (code == 0) {
            init();
        } else if (code == 2) {
            cliConnector.init();
        }
        boolean existence = false;
        int index = -1;
        for (Courses course : manageCollegeCourses.AllCourses) {
            if (course.getCourseCode() == code) {
                existence = true;
                index = manageCollegeCourses.AllCourses.indexOf(course);
                for(Student student:dataBase.MembersList){
                    for(Courses course1:student.EnrolledCourses){
                        if(course1.getCourseCode()==course.getCourseCode()){
                            student.getEnrolledCourses().remove(course1);
                            break;
                        }
                    }
                }
                if (code / 1000 == 20) {
                    manageCollegeCourses.getListOfMathCollegeCourses().remove(course);
                }
                if (code / 1000 == 23) {
                    manageCollegeCourses.getListOfComputerEngineeringCollegeCourses().remove(course);
                }
                if (code / 1000 == 27) {
                    manageCollegeCourses.getListOfChemicalEngineeringCollegeCourses().remove(course);
                }
                if (code / 1000 == 31) {
                    manageCollegeCourses.getListOfLanguageAndLiteratureCollegeCourses().remove(course);
                }
                if (code / 1000 == 24) {
                    manageCollegeCourses.getListOfPhysicsCollegeCourses().remove(course);
                }
                course.getStudentsList().clear();

            }

        }
        if (existence) {
            manageCollegeCourses.AllCourses.remove(index);
            System.out.println("Course was removed successfully.\nEnter 0 to return to previous page or enter 2 to exit program .");
            String response = scanner.next();
            scanner.nextLine();
            if (response.equals("0")) {
                init();
            } else if (response.equals("2")) {
                cliConnector.init();
            } else {
                System.out.println("Please enter a valid response.");
                RemoveCourse();
            }
        }
        if (!existence) {
            System.out.println("Course with given code does not exist . please enter to try again .");
            RemoveCourse();
        }

    }
}
