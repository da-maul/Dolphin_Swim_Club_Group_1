import java.time.LocalDate;
import java.util.ArrayList;

public class Club {

    private final ArrayList<Member> members;
    private int nextMemberId;

    public Club() {
        members = new ArrayList<>();
        nextMemberId = 1001;
    }

    public Member addMember(String name, LocalDate birthDate,
                            boolean active, boolean competitive) {

        Member member = new Member(
                nextMemberId,
                name,
                birthDate,
                active,
                competitive
        );

        members.add(member);
        nextMemberId++;

        return member;
    }

    public ArrayList<Member> getMembers() {
        return new ArrayList<>(members);
    }

    public Member findMemberById(int memberId) {
        for (Member member : members) {
            if (member.getMemberId() == memberId) {
                return member;
            }
        }
        return null;
    }
}