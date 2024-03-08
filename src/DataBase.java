import java.util.HashSet;
import java.util.Set;

public class DataBase {
    public  Set<Student> MembersList=new HashSet<>();

    public Set<Student> getMembersList() {
        return MembersList;
    }

    public void setMembersList(Set<Student> membersList) {
        MembersList = membersList;
    }
}
