import java.util.ArrayList;
import java.util.List;

public class ManageCollegeCourses {
    private List<Courses> ListOfMathCollegeCourses = new ArrayList<>();
    private List<Courses> ListOfComputerEngineeringCollegeCourses = new ArrayList<>();
    private List<Courses> ListOfChemicalEngineeringCollegeCourses = new ArrayList<>();
    private List<Courses> ListOfPhysicsCollegeCourses = new ArrayList<>();
    private List<Courses> ListOfLanguageAndLiteratureCollegeCourses = new ArrayList<>();
    public List<Courses> AllCourses = new ArrayList<>();
    public ManageCollegeCourses(){
        String MathCollegeTitle ="College of mathematics sciences";
        Courses course1 = new takhasossiCourses("discrete mathematics", "Ali Mohammadi", MathCollegeTitle,"TAKHASSOSI",
                20100,3,50,0,new String[]{"یکشنبه", "سه شنبه"},10.0,12.5,"khordad",
                30,9.0);
        ListOfMathCollegeCourses.add(course1);
        Courses course2 = new takhasossiCourses("basic programming", "Alireza Tofighi", MathCollegeTitle,"TAKHASSOSI",
                20101,4,35,0,new String[]{"شنبه", "دوشنبه"},9.0,11.0,"tir",
                2,9.0);
        ListOfMathCollegeCourses.add(course2);
        Courses course3 = new takhasossiCourses("advanced programming", "Samane Amiri", MathCollegeTitle,"TAKHASSOSI",
                20102,4,40,0,new String[]{"یکشنبه", "سه شنبه"},8.0,10.0,"tir",
                2,9.0);
        ListOfMathCollegeCourses.add(course3);
        Courses course4 = new takhasossiCourses("jabr khati", "Zahra Zarandooz", MathCollegeTitle,"TAKHASSOSI",
                20103,3,10,0,new String[]{"شنبه", "چهارشنبه"},15.0,16.5,"khordad",
                30,9.0);
        ListOfMathCollegeCourses.add(course4);
        Courses course5 = new takhasossiCourses("riazi omoumi 1", "Mohammadreza Alizedeh", MathCollegeTitle,"TAKHASSOSI",
                20104,4,50,0,new String[]{"دوشنبه", "چهارشنبه"},13.0,15.0,"tir",
                4,8.0);
        ListOfMathCollegeCourses.add(course5);
        Courses course6 = new takhasossiCourses("riazi omoumi 2", "Reza Rezaie", MathCollegeTitle,"TAKHASSOSI",
                20105,4,30,0,new String[]{"یکشنبه", "سه شنبه"},9.0,11.0,"tir",
                4,8.0);
        ListOfMathCollegeCourses.add(course6);
        Courses course7 = new takhasossiCourses("riazi mohandesi", "Raha Ahmadi", MathCollegeTitle,"TAKHASSOSI",
                20106,4,40,0,new String[]{"یکشنبه", "سه شنبه"},14.0,16.0,"tir",
                5,9.0);
        ListOfMathCollegeCourses.add(course7);
        Courses course8 = new omumiCourses("falsafe riaziat", "Ali Jahromi", MathCollegeTitle,"TAKHASSOSI",
                20107,2,4,0,new String[]{"دوشنبه"},8.0,9.5,"khordad",
                30,9);
        ListOfMathCollegeCourses.add(course8);
        ////
        String ceCollegeTitle ="College of computer engineering";
        Courses course9 = new takhasossiCourses("zaban takhassosi computer", "Nima Mohammadi", ceCollegeTitle,"TAKHASSOSI",
                23100,3,30,0,new String[]{"یکشنبه", "سه شنبه"},11.0,12.5,"khordad",
                29,9.0);
        ListOfComputerEngineeringCollegeCourses.add(course9);
        Courses course10 = new takhasossiCourses("memari computer", "Kamran Kamyab", ceCollegeTitle,"TAKHASSOSI",
                23101,4,35,0,new String[]{"دوشنبه", "شنبه"},8.0,10.0,"tir",
                5,12.0);
        ListOfComputerEngineeringCollegeCourses.add(course10);
        Courses course11 = new takhasossiCourses("tarahi algorithm", "Laleh Ahmadi", ceCollegeTitle,"TAKHASSOSI",
                23102,3,40,0,new String[]{"دوشنبه", "شنبه"},10.0,12.0,"tir",
                3,12.0);
        ListOfComputerEngineeringCollegeCourses.add(course11);
        Courses course12 = new takhasossiCourses("System amel", "Fatemeh Izadi", ceCollegeTitle,"TAKHASSOSI",
                23103,4,25,0,new String[]{"سه شنبه", "یکشنبه"},9.0,11.0,"tir",
                2,12.0);
        ListOfComputerEngineeringCollegeCourses.add(course12);
        Courses course13 = new takhasossiCourses("nazarie bazi ha", "Ali Alizade", ceCollegeTitle,"TAKHASSOSI",
                23104,3,50,0,new String[]{"چهارشنبه", "شنبه"},15.0,17.5,"khordad",
                27,9.0);
        ListOfComputerEngineeringCollegeCourses.add(course13);
        //
        String s="College Of Chemical Engineering";
        Courses course14 = new takhasossiCourses("Shimi san'ati", "Kamran Amiri", s,"TAKHASSOSI",
                27100,3,60,0,new String[]{"دوشنبه", "شنبه"},9.0,10.5,"tir",
                3,12.0);
        ListOfChemicalEngineeringCollegeCourses.add(course14);
        Courses course15 = new takhasossiCourses("azmayeshgah shimi", "Zahra Nikouhar", s,"TAKHASSOSI",
                27101,2,60,0,new String[]{"دوشنبه", "شنبه"},13.0,15.0,"tir",
                3,12.0);
        ListOfChemicalEngineeringCollegeCourses.add(course15);
        Courses course16 = new takhasossiCourses("Enteghal", "Sara Karimi", s,"TAKHASSOSI",
                27102,3,60,0,new String[]{"دوشنبه", "شنبه"},9.0,10.5,"tir",
                3,9.0);
        ListOfChemicalEngineeringCollegeCourses.add(course16);
        Courses course17 = new takhasossiCourses("Mechanic_e_sayalat", "saman Shahi", s,"TAKHASSOSI",
                27103,3,50,0,new String[]{"شنبه", "سه شنبه"},10.0,12.5,"khordad",
                29,9.0);
        ListOfChemicalEngineeringCollegeCourses.add(course17);
        ////
        String str="College Of Physics";
        Courses course18 = new takhasossiCourses("Physic 1", "Amin Moghaddam", str,"TAKHASSOSI",
                24100,3,100,0,new String[]{"دوشنبه", "چهارشنبه"},15.0,17.0,"tir",
                1,9.0);
        ListOfPhysicsCollegeCourses.add(course18);
        Courses course19 = new takhasossiCourses("Physic 2", "Amin Moghaddam", str,"TAKHASSOSI",
                24101,3,40,0,new String[]{"دوشنبه", "چهارشنبه"},7.5,9.5,"khordad",
                30,9.0);
        ListOfPhysicsCollegeCourses.add(course19);
        Courses course20 = new takhasossiCourses("Electromeghnatis", "Mohsen Safari", str,"TAKHASSOSI",
                24102,3,40,0,new String[]{"سه شنبه", "یکشنبه"},13.0,14.5,"tir",
                2,12.0);
        ListOfPhysicsCollegeCourses.add(course20);
        Courses course21 = new takhasossiCourses("Mechanic quantic", "Sara Khakpour", str,"TAKHASSOSI",
                24103,4,50,0,new String[]{"سه شنبه", "یکشنبه"},15.0,17.0,"tir",
                4,9.0);
        ListOfPhysicsCollegeCourses.add(course21);
        ////
        str="college Of Language And Literature";
        Courses course22 = new omumiCourses("Adabiat farsi ", "Maryam Rostami", str,"OMOUMI",
                31100,3,35,0,new String[]{"شنبه", "چهارشنبه"},9.0,11.0,"tir",
                4,12.0);
        ListOfLanguageAndLiteratureCollegeCourses.add(course22);
        Courses course23 = new omumiCourses("Englisi ", "Hossein Rostami", str,"OMOUMI",
                31101,2,35,0,new String[]{"شنبه", "دوشنبه"},14.0,16.0,"khordad",
                28,9.0);
        ListOfLanguageAndLiteratureCollegeCourses.add(course23);
        Courses course24= new omumiCourses("Adabiat farsi pishrafte", "Maryam Rostami", str,"OMOUMI",
                31102,3,35,0,new String[]{"شنبه", "چهارشنبه"},16.0,18.0,"tir",
                3,12.0);
        ListOfLanguageAndLiteratureCollegeCourses.add(course24);
        Courses course25= new omumiCourses("Zaban takhassosi", "Nazanin Keshavarz", str,"OMOUMI",
                31103,3,10,0,new String[]{"یکشنبه", "سه شنبه"},18.0,19.5,"khordad",
                26,9.0);
        ListOfLanguageAndLiteratureCollegeCourses.add(course25);

        AllCourses.addAll(ListOfChemicalEngineeringCollegeCourses);
        AllCourses.addAll(ListOfLanguageAndLiteratureCollegeCourses);
        AllCourses.addAll(ListOfComputerEngineeringCollegeCourses);
        AllCourses.addAll(ListOfMathCollegeCourses);
        AllCourses.addAll(ListOfPhysicsCollegeCourses);

    }
    public List<Courses> getListOfMathCollegeCourses() {
        return ListOfMathCollegeCourses;
    }
    public void setListOfMathCollegeCourses(List<Courses> listOfMathCollegeCourses) {
        ListOfMathCollegeCourses = listOfMathCollegeCourses;
    }

    public List<Courses> getListOfComputerEngineeringCollegeCourses() {
        return ListOfComputerEngineeringCollegeCourses;
    }

    public void setListOfComputerEngineeringCollegeCourses(List<Courses> listOfComputerEngineeringCollegeCourses) {
        ListOfComputerEngineeringCollegeCourses = listOfComputerEngineeringCollegeCourses;
    }

    public List<Courses> getListOfChemicalEngineeringCollegeCourses() {
        return ListOfChemicalEngineeringCollegeCourses;
    }

    public void setListOfChemicalEngineeringCollegeCourses(List<Courses> listOfChemicalEngineeringCollegeCourses) {
        ListOfChemicalEngineeringCollegeCourses = listOfChemicalEngineeringCollegeCourses;
    }

    public List<Courses> getListOfPhysicsCollegeCourses() {
        return ListOfPhysicsCollegeCourses;
    }

    public void setListOfPhysicsCollegeCourses(List<Courses> listOfPhysicsCollegeCourses) {
        ListOfPhysicsCollegeCourses = listOfPhysicsCollegeCourses;
    }

    public List<Courses> getListOfLanguageAndLiteratureCollegeCourses() {
        return ListOfLanguageAndLiteratureCollegeCourses;
    }

    public void setListOfLanguageAndLiteratureCollegeCourses(List<Courses> listOfLanguageAndLiteratureCollegeCourses) {
        ListOfLanguageAndLiteratureCollegeCourses = listOfLanguageAndLiteratureCollegeCourses;
    }
}

