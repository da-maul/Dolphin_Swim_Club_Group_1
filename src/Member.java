

import java.time.LocalDate;

public class Member {

    private final int memberId;
    private String name;
    private LocalDate birthDate;
    private boolean active;
    private boolean competitive;

    public Member(int memberId, String name, LocalDate birthDate,
                  boolean active, boolean competitive) {
        this.memberId = memberId;
        this.name = name;
        this.birthDate = birthDate;
        this.active = active;
        this.competitive = competitive;
    }

    public int getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public boolean isActive() {
        return active;
    }

    public boolean isCompetitive() {
        return competitive;
    }

    public int getAge(LocalDate date) {
        return java.time.Period.between(birthDate, date).getYears();
    }

    @Override
    public String toString() {
        return "Member ID: " + memberId +
                "\nName: " + name +
                "\nBirth date: " + birthDate +
                "\nMembership: " + (active ? "Active" : "Passive") +
                "\nSwimmer type: " +
                (!active ? "None" : competitive ? "Competitive" : "Recreational");
    }
}