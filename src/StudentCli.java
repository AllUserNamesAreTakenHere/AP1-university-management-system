import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StudentCli {
    private CliConnector cliConnector;
    DataBase dataBase;
    ManageCollegeCourses manageCollegeCourses1;
    FileManager fileManager;

    public DataBase getDataBase() {
        return dataBase;
    }

    public void setDataBase(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public CliConnector getCliConnector() {
        return cliConnector;
    }

    private final Student student;
    Scanner scanner = new Scanner(System.in);


    public StudentCli(Student student, DataBase dataBase, CliConnector cliConnector, ManageCollegeCourses manageCollegeCourses1,FileManager fileManager) {
        this.student = student;
        this.dataBase = dataBase;
        this.cliConnector = cliConnector;
        this.manageCollegeCourses1 = manageCollegeCourses1;
        this.fileManager=fileManager;
    }

    public void init() {
        System.out.println("options: \n 1. Show the list of colleges and courses\n 2. show your courses \n 3. add course \n 4.return to main menu");
        int number = scanner.nextInt();
        if (number == 1) {
            chooseCollege();
        } else if (number == 2) {
            showStudentCourses();
        } else if (number == 3) {
            addCourse();
        } else if (number == 4) {
            cliConnector.init();
        } else {
            init();
        }
    }

    private void addCourse() {
        System.out.println("Enter the code of intended course.\n Enter 0 to return to previous page.\n Enter 2 to exit program.");
        System.out.print("course code : ");
        int code = scanner.nextInt();
        scanner.nextLine();
        if (code == 0) {
            init();
        } else if (code == 2) {
            cliConnector.init();
        } else {
            coursePermission(code);
        }
    }

    private void coursePermission(int code) {
        boolean permissionGiven = true;
        boolean validCode = false;
        // tadakhol zamani
        // tadakhol emtehani
        // tadakhol rooz
        int vahedTotal = 0;
        int vahedOmoumi = 0;
        student.setEnrolledCourses(fileManager.reedTakenCoursesFromFile(student));
        if (student.getEnrolledCourses() != null) {
            for (Courses course : student.EnrolledCourses) {
                vahedTotal += course.getCourseVahed();
                if (course.getCourseType().equals("OMOUMI")) {
                    vahedOmoumi += course.getCourseVahed();
                }
            }
        }
        // student dars ro dare .
        if (student.EnrolledCourses != null) {
            for (Courses course : student.EnrolledCourses) {
                if (code == course.getCourseCode()) {
                    System.out.println("You already have this course");
                    permissionGiven = false;
                }
            }
        }
        for (Courses chosenCourse : manageCollegeCourses1.AllCourses) {
            if (code == chosenCourse.getCourseCode()) {
                validCode = true;
                // dars zarfiatesh pore.
                if (chosenCourse.getCourseCapacity() == chosenCourse.getEnrolledStudents()) {
                    System.out.println("no capacity for this course.");
                    permissionGiven = false;
                }
                // 20 vahed
                if (chosenCourse.getCourseVahed() + vahedTotal > 20) {
                    System.out.println("more than 20 vahed . ");
                    permissionGiven = false;
                }
                // 5 vahed omoumi.
                if (chosenCourse.getCourseType().equals("OMOUMI")) {
                    if (chosenCourse.getCourseVahed() + vahedOmoumi > 5) {
                        System.out.println("more than 5 vahed omoumi.");
                        permissionGiven = false;
                    }
                }
                //tadakhol rooz va saat
                if (student.EnrolledCourses != null) {
                    for (Courses takenCourse : student.EnrolledCourses) {
                        if (chosenCourse.getClassDays().length == 1) {
                            if (takenCourse.getClassDays().length == 1) {
                                if (chosenCourse.getClassDays()[0].equals(takenCourse.getClassDays()[0])) {
                                    // CB TB CE
                                    if (chosenCourse.getClassBeginningHour() <= takenCourse.getClassBeginningHour() &&
                                            takenCourse.getClassBeginningHour() < chosenCourse.getClassEndingHour()) {
                                        permissionGiven = false;
                                        System.out.println("class time is incompatible with the time of you chosen courses.");
                                    }
                                    // CB TE CE
                                    else if (chosenCourse.getClassBeginningHour() < takenCourse.getClassEndingHour() &&
                                            takenCourse.getClassEndingHour() <= chosenCourse.getClassEndingHour()) {

                                    }
                                    // TB CE TE
                                    else if (takenCourse.getClassBeginningHour() < chosenCourse.getClassEndingHour() &&
                                            chosenCourse.getClassEndingHour() <= takenCourse.getClassEndingHour()) {
                                        permissionGiven = false;
                                        System.out.println("class time is incompatible with the time of you chosen courses.");
                                    }
                                    // TB CB TE
                                    else if (takenCourse.getClassBeginningHour() <= chosenCourse.getClassBeginningHour() &&
                                            chosenCourse.getClassBeginningHour() < takenCourse.getClassEndingHour()) {
                                        permissionGiven = false;
                                        System.out.println("class time is incompatible with the time of you chosen courses.");
                                    }
                                }
                            }
                            if (takenCourse.getClassDays().length == 2) {
                                if ((chosenCourse.getClassDays()[0].equals(takenCourse.getClassDays()[0]))) {
                                    // CB TB CE
                                    if (chosenCourse.getClassBeginningHour() <= takenCourse.getClassBeginningHour() &&
                                            takenCourse.getClassBeginningHour() < chosenCourse.getClassEndingHour()) {
                                        permissionGiven = false;
                                        System.out.println("class time is incompatible with the time of you chosen courses.");
                                    }
                                    // CB TE CE
                                    else if (chosenCourse.getClassBeginningHour() < takenCourse.getClassEndingHour() &&
                                            takenCourse.getClassEndingHour() <= chosenCourse.getClassEndingHour()) {

                                    }
                                    // TB CE TE
                                    else if (takenCourse.getClassBeginningHour() < chosenCourse.getClassEndingHour() &&
                                            chosenCourse.getClassEndingHour() <= takenCourse.getClassEndingHour()) {
                                        permissionGiven = false;
                                        System.out.println("class time is incompatible with the time of you chosen courses.");
                                    }
                                    // TB CB TE
                                    else if (takenCourse.getClassBeginningHour() <= chosenCourse.getClassBeginningHour() &&
                                            chosenCourse.getClassBeginningHour() < takenCourse.getClassEndingHour()) {
                                        permissionGiven = false;
                                        System.out.println("class time is incompatible with the time of you chosen courses.");
                                    }
                                } else if ((chosenCourse.getClassDays()[0].equals(takenCourse.getClassDays()[1]))) {
                                    // CB TB CE
                                    if (chosenCourse.getClassBeginningHour() <= takenCourse.getClassBeginningHour() &&
                                            takenCourse.getClassBeginningHour() < chosenCourse.getClassEndingHour()) {
                                        permissionGiven = false;
                                        System.out.println("class time is incompatible with the time of you chosen courses.");
                                    }
                                    // CB TE CE
                                    else if (chosenCourse.getClassBeginningHour() < takenCourse.getClassEndingHour() &&
                                            takenCourse.getClassEndingHour() <= chosenCourse.getClassEndingHour()) {

                                    }
                                    // TB CE TE
                                    else if (takenCourse.getClassBeginningHour() < chosenCourse.getClassEndingHour() &&
                                            chosenCourse.getClassEndingHour() <= takenCourse.getClassEndingHour()) {
                                        permissionGiven = false;
                                        System.out.println("class time is incompatible with the time of you chosen courses.");
                                    }
                                    // TB CB TE
                                    else if (takenCourse.getClassBeginningHour() <= chosenCourse.getClassBeginningHour() &&
                                            chosenCourse.getClassBeginningHour() < takenCourse.getClassEndingHour()) {
                                        permissionGiven = false;
                                        System.out.println("class time is incompatible with the time of you chosen courses.");
                                    }
                                }
                            }
                        }
                        if (chosenCourse.getClassDays().length == 2) {
                            if (takenCourse.getClassDays().length == 1) {
                                if ((chosenCourse.getClassDays()[0].equals(takenCourse.getClassDays()[0])) || (chosenCourse.getClassDays()[1].equals(takenCourse.getClassDays()[0]))) {
                                    // CB TB CE
                                    if (chosenCourse.getClassBeginningHour() <= takenCourse.getClassBeginningHour() &&
                                            takenCourse.getClassBeginningHour() < chosenCourse.getClassEndingHour()) {
                                        permissionGiven = false;
                                        System.out.println("class time is incompatible with the time of you chosen courses.");
                                    }
                                    // CB TE CE
                                    else if (chosenCourse.getClassBeginningHour() < takenCourse.getClassEndingHour() &&
                                            takenCourse.getClassEndingHour() <= chosenCourse.getClassEndingHour()) {

                                    }
                                    // TB CE TE
                                    else if (takenCourse.getClassBeginningHour() < chosenCourse.getClassEndingHour() &&
                                            chosenCourse.getClassEndingHour() <= takenCourse.getClassEndingHour()) {
                                        permissionGiven = false;
                                        System.out.println("class time is incompatible with the time of you chosen courses.");
                                    }
                                    // TB CB TE
                                    else if (takenCourse.getClassBeginningHour() <= chosenCourse.getClassBeginningHour() &&
                                            chosenCourse.getClassBeginningHour() < takenCourse.getClassEndingHour()) {
                                        permissionGiven = false;
                                        System.out.println("class time is incompatible with the time of you chosen courses.");
                                    }
                                }
                            }
                            if (takenCourse.getClassDays().length == 2) {
                                if ((chosenCourse.getClassDays()[0].equals(takenCourse.getClassDays()[0])) || (chosenCourse.getClassDays()[0].equals(takenCourse.getClassDays()[1]))) {
                                    // CB TB CE
                                    if (chosenCourse.getClassBeginningHour() <= takenCourse.getClassBeginningHour() &&
                                            takenCourse.getClassBeginningHour() < chosenCourse.getClassEndingHour()) {
                                        permissionGiven = false;
                                        System.out.println("class time is incompatible with the time of you chosen courses.");
                                    }
                                    // CB TE CE
                                    else if (chosenCourse.getClassBeginningHour() < takenCourse.getClassEndingHour() &&
                                            takenCourse.getClassEndingHour() <= chosenCourse.getClassEndingHour()) {

                                    }
                                    // TB CE TE
                                    else if (takenCourse.getClassBeginningHour() < chosenCourse.getClassEndingHour() &&
                                            chosenCourse.getClassEndingHour() <= takenCourse.getClassEndingHour()) {
                                        permissionGiven = false;
                                        System.out.println("class time is incompatible with the time of you chosen courses.");
                                    }
                                    // TB CB TE
                                    else if (takenCourse.getClassBeginningHour() <= chosenCourse.getClassBeginningHour() &&
                                            chosenCourse.getClassBeginningHour() < takenCourse.getClassEndingHour()) {
                                        permissionGiven = false;
                                        System.out.println("class time is incompatible with the time of you chosen courses.");
                                    }
                                }
                                if ((chosenCourse.getClassDays()[1].equals(takenCourse.getClassDays()[0])) || (chosenCourse.getClassDays()[1].equals(takenCourse.getClassDays()[1]))) {
                                    // CB TB CE
                                    if (chosenCourse.getClassBeginningHour() <= takenCourse.getClassBeginningHour() &&
                                            takenCourse.getClassBeginningHour() < chosenCourse.getClassEndingHour()) {
                                        permissionGiven = false;
                                        System.out.println("class time is incompatible with the time of you chosen courses.");
                                    }
                                    // CB TE CE
                                    else if (chosenCourse.getClassBeginningHour() < takenCourse.getClassEndingHour() &&
                                            takenCourse.getClassEndingHour() <= chosenCourse.getClassEndingHour()) {

                                    }
                                    // TB CE TE
                                    else if (takenCourse.getClassBeginningHour() < chosenCourse.getClassEndingHour() &&
                                            chosenCourse.getClassEndingHour() <= takenCourse.getClassEndingHour()) {
                                        permissionGiven = false;
                                        System.out.println("class time is incompatible with the time of you chosen courses.");
                                    }
                                    // TB CB TE
                                    else if (takenCourse.getClassBeginningHour() <= chosenCourse.getClassBeginningHour() &&
                                            chosenCourse.getClassBeginningHour() < takenCourse.getClassEndingHour()) {
                                        permissionGiven = false;
                                        System.out.println("class time is incompatible with the time of you chosen courses.");
                                    }
                                }
                            }
                        }
                    }
                    for (Courses takenCourse : student.EnrolledCourses) {
                        if (takenCourse.getFinalExamMonth().equals(chosenCourse.getFinalExamMonth())) {
                            if (takenCourse.getFinalExamDay() == chosenCourse.getFinalExamDay()) {
                                if (takenCourse.getFinalExamHour() == chosenCourse.getFinalExamHour()) {
                                    System.out.println("Final exam date is incompatible with your taken courses.");
                                    permissionGiven = false;
                                }
                            }
                        }
                    }
                }
                if (permissionGiven) {
                    // afzayesh zarfiat dars.
                    // update list dars.
                    //update list student.
                    System.out.println("course added successfully!");
                   fileManager.writeStudentToCourseList(student,chosenCourse);
                   chosenCourse.setStudentsList(fileManager.reedStudentsFromFile(chosenCourse));
                    // chosenCourse.StudentsList.add(student);
                    fileManager.writeTakenCoursesToFile(student,chosenCourse);
                    student.setEnrolledCourses(fileManager.reedTakenCoursesFromFile(student));
                    //student.getEnrolledCourses().add(chosenCourse);
                    int temp = chosenCourse.getEnrolledStudents();
                    //chosenCourse.setEnrolledStudents(temp + 1);
                    System.out.println(" Enter 0 to return to previous page.\n Enter 2 to exit program.");
                    int response = scanner.nextInt();
                    scanner.nextLine();
                    if (response == 2) {
                        cliConnector.init();
                    } else {
                        addCourse();
                    }
                }
                if (!permissionGiven) {
                    System.out.println("Enter 0 to return to previous page or enter 2 to exit page.");
                    int response = scanner.nextInt();
                    scanner.nextLine();
                    switch (response) {
                        case 0:
                            addCourse();
                            break;
                        case 2:
                            cliConnector.init();
                        default:
                            System.out.println("Invalid response .Please try again .");
                            addCourse();
                    }
                }
            }
        }
        if (!validCode) {
            System.out.println("Invalid code . \n Page will be refreshed. ");
            addCourse();
        }
    }

    private void showStudentCourses() {
        int counter = 0;
        int omumi = 0;
        student.setEnrolledCourses(fileManager.reedTakenCoursesFromFile(student));
        for (Courses course : student.getEnrolledCourses()) {
            course.setStudentsList(fileManager.reedStudentsFromFile(course));
            course.setEnrolledStudents(course.getStudentsList().size());
            if (course.getCourseType().equals("OMOUMI")) {
                omumi += course.getCourseVahed();
            }
            counter += course.getCourseVahed();
            System.out.println("****************************************************************************************");
            System.out.println("course title : " + course.getCourseTitle() + " __ vahed : " + course.getCourseVahed());
            System.out.println("course code : " + course.getCourseCode() + " __ professor : " + course.getProfessorName());
            System.out.println("College : " + course.getPresenterCollege() + " __ capacity : " + course.getCourseCapacity());
            System.out.println("enrolled students : " + course.getEnrolledStudents() + " __ class days : " + Arrays.toString(course.getClassDays()));
            System.out.println("class beginning hour : " + course.getClassBeginningHour() + " __ class ending hour : " + course.getClassEndingHour());
            System.out.println("final exam date : " + course.getFinalExamMonth() + " " + course.getFinalExamDay() + "th" + " __ final exam hour : " + course.getFinalExamHour());
            System.out.println("****************************************************************************************");
        }
        System.out.println("vahed : " + counter);
        System.out.println(" omoumi : " + omumi);
        System.out.println("options : \n 1.remove a course form your list \n 2.return to menu \n 3.exit page");
        String response = scanner.next();
        scanner.nextLine();
        if (response.equals("1")) {
            removeCourse();
        } else if (response.equals("2")) {
            init();
        } else if (response.equals("3")) {
            cliConnector.init();
        } else {
            System.out.println("Enter a valid response");
            showStudentCourses();
        }

    }

    private void removeCourse() {
        boolean courseFound = false;
        boolean valid = false;
        int index = -1;
        student.setEnrolledCourses(fileManager.reedTakenCoursesFromFile(student));
        System.out.println("Enter the code of the course you want to delete ");
        System.out.println("Enter 0 to return to previous page or enter 2 to return to main menu.");
        int code = scanner.nextInt();
        scanner.nextLine();
        if (code == 0) {
            showStudentCourses();
        } else if (code == 2) {
            cliConnector.init();
        } else {
            for (Courses courses : manageCollegeCourses1.AllCourses) {
                if (courses.getCourseCode() == code) {
                    valid = true;
                }
            }
            if (!valid) {
                System.out.println("invalid code ! please try again.");
                removeCourse();

            } else {
                for (Courses course : student.getEnrolledCourses()) {
                    if (code == course.getCourseCode()) {
                        course.setStudentsList(fileManager.reedStudentsFromFile(course));
                        course.setEnrolledStudents(course.getStudentsList().size());
                        courseFound = true;
                        /*index = student.getEnrolledCourses().indexOf(course);
                        int temp=course.getEnrolledStudents();
                        course.setEnrolledStudents(temp - 1);*/
                        fileManager.removeRemovedCoursesFromFile(student,course);
                        fileManager.removeRemovedStudentsFromCourseList(student,course);
                        course.setStudentsList(fileManager.reedStudentsFromFile(course));
                        course.setEnrolledStudents(course.getStudentsList().size());
                    }

                }
                if (!courseFound) {
                    System.out.println("you do not have this course!");
                    removeCourse();
                } else if (courseFound) {
                    //student.getEnrolledCourses().remove(index);
                    System.out.println("Removed successfully");
                    System.out.println("actions :");
                    System.out.println("1.return to previous page");
                    System.out.println("2.Exit program");
                    int answer = scanner.nextInt();
                    scanner.nextLine();
                    if (answer == 1) {
                        showStudentCourses();
                    } else if (answer == 2) {
                        cliConnector.init();
                    } else {
                        showStudentCourses();
                    }
                }
            }
        }

    }


    private void chooseCollege() {
        System.out.println("college code : 20___Mathematics Sciences");
        System.out.println("college code : 23___Computer Engineering");
        System.out.println("college code : 27___Chemical Engineering");
        System.out.println("college code : 24___Physics");
        System.out.println("college code : 31___Language And Literature");
        System.out.println("Enter college code to see list of courses.");
        System.out.println("Enter 0 to return to main menu and 2 to exit page.");
        int response = scanner.nextInt();
        scanner.nextLine();
        if (response == 0) {
            init();
            return;
        }
        if (response == 2) {
            cliConnector.init();
            return;
        }
        if (response == 20) {
            showCollegeCourses(manageCollegeCourses1.getListOfMathCollegeCourses());
        }
        if (response == 23) {
            showCollegeCourses(manageCollegeCourses1.getListOfComputerEngineeringCollegeCourses());
        }
        if (response == 27) {
            showCollegeCourses(manageCollegeCourses1.getListOfPhysicsCollegeCourses());
        }
        if (response == 24) {
            showCollegeCourses(manageCollegeCourses1.getListOfChemicalEngineeringCollegeCourses());
        }
        if (response == 31) {
            showCollegeCourses(manageCollegeCourses1.getListOfLanguageAndLiteratureCollegeCourses());
        }
    }

    public void showCollegeCourses(List<Courses> collegeCourses) {
        for (Courses course : collegeCourses) {
            course.setStudentsList(fileManager.reedStudentsFromFile(course));
            course.setEnrolledStudents(course.getStudentsList().size());
            System.out.println("****************************************************************************************");
            System.out.println("course title : " + course.getCourseTitle() + " __ vahed : " + course.getCourseVahed());
            System.out.println("course code : " + course.getCourseCode() + " __ professor : " + course.getProfessorName());
            System.out.println("College : " + course.getPresenterCollege() + " __ capacity : " + course.getCourseCapacity());
            System.out.println("enrolled students : " + course.getEnrolledStudents() + " __  class days : " + Arrays.toString(course.getClassDays()));
            System.out.println("class beginning hour : " + course.getClassBeginningHour() + " __ class ending hour : " + course.getClassEndingHour());
            System.out.println("final exam date : " + course.getFinalExamMonth() + " " + course.getFinalExamDay() + "th" + " __ final exam hour : " + course.getFinalExamHour());
            System.out.println("****************************************************************************************");

        }
        System.out.println("/////////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("1.Return to previous page \n 2.Exit program");
        int num = scanner.nextInt();
        scanner.nextLine();
        if (num == 1) {
            init();
        } else if (num == 2) {
            cliConnector.init();
        } else {
            System.out.println("invalid response");
            chooseCollege();
        }
    }

}
