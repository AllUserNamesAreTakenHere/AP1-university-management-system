import java.util.Scanner;

public class CliConnector {

    private StudentCli studentCli;
    private DataBase dataBase = new DataBase();
    ManageCollegeCourses manageCollegeCourses = new ManageCollegeCourses();
    FileManager fileManager=new FileManager(manageCollegeCourses,dataBase);

    private AdminCli adminCli = new AdminCli(dataBase, this, manageCollegeCourses,fileManager);


    Scanner scanner = new Scanner(System.in);


    public void init() {
        while (true) {
            System.out.println("Already a member?  =>   1.sign in");
            System.out.println("Don't have an account?  =>   2.sign up");
            String number = scanner.next();
            scanner.nextLine();
            if (number.equals("1")) {
                signIn();
            } else if (number.equals("2")) {
                signUp();
            } else {
                System.out.println("Please enter a valid response");
                init();
            }
        }
    }

    private void signUp() {
        dataBase.setMembersList(fileManager.readStudentFromUsersText());
        System.out.println("please enter your username");
        String username = scanner.next();
        scanner.nextLine();
        if (username.equalsIgnoreCase("back")) {
            init();
        } else {
            for (Student student : dataBase.MembersList) {
                if (student.getUserName().equals(username)) {
                    System.out.println("you already have an account. please sign in or try again . ");
                    init();
                }
            }
        }
        System.out.println("Please enter your password");
        String password = scanner.next();
        scanner.nextLine();
        System.out.println("Enter your first name and lastname");
        System.out.print("First Name : ");
        String firstName = scanner.next();
        scanner.nextLine();
        System.out.print("Last Name :");
        String lastName = scanner.next();
        Student student = new Student(firstName, lastName, username, password, "Student");
        fileManager.createUserFolderOnUserSignup(firstName,lastName,username,password);
       // dataBase.MembersList.add(student);
        System.out.println("Account created !   1. sign in    2.exit");
        String response = scanner.next();
        scanner.nextLine();
        if (response.equals("1")) {
            signIn();
        } else if (response.equals("2")) {
            init();
        } else {
            System.out.println("invalid response . ");
        }
    }

    private void signIn() {
        dataBase.setMembersList(fileManager.readStudentFromUsersText());
        System.out.println("Enter your username");
        System.out.println("Enter back to exit this page");
        String username = scanner.next();
        scanner.nextLine();
        if (username.equals("back")) {
            init();
        } else if (username.equals("Admin")) {
            System.out.println("Enter password : ");
            String password = scanner.next();
            if (password.equals("999999999")) {
                adminCli.init();
            } else {
                System.out.println("Wrong password please try again.");
                signIn();
            }
        } else {
            boolean studentFound = false;
            for (Student student : dataBase.MembersList) {
                if (student.getUserName().equals(username)) {
                    studentFound = true;
                    System.out.println("Enter your password");
                    String password = scanner.next();
                    if (student.getPassword().equals(password)) {
                        System.out.println("Hello " + student.getStudentName() + " " + student.getStudentLastName());
                        studentCli = new StudentCli(student, dataBase, this, manageCollegeCourses,fileManager);
                        studentCli.init();
                    } else {
                        System.out.println("Wrong password ! please try again ");
                        signIn();
                    }
                }
            }
            if (!studentFound) {
                System.out.println("Username was not found .");
                System.out.println(" Enter 1 to try again or enter 2 to exit.");
                int response = scanner.nextInt();
                scanner.nextLine();
                if (response == 1) {
                    signIn();
                } else if (response == 2) {
                    init();
                } else {
                    System.out.println("invalid response . please try again.");
                    signIn();
                }
            }
        }
    }
}
