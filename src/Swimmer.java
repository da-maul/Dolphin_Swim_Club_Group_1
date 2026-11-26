import java.time.LocalDate;

public class Swimmer {

    private final int swimmerId;
    private String name;
    private LocalDate birthDate;
    private boolean active;
    private boolean competitive;

    public Swimmer(int swimmerId, String name, LocalDate birthDate,
                   boolean active, boolean competitive) {
        this.swimmerId = swimmerId;
        this.name = name;
        this.birthDate = birthDate;
        this.active = active;
        this.competitive = competitive;
    }

    public int getSwimmerId() {
        return swimmerId;
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
//Allows the details to be changed without changing the swimmer ID
    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setCompetitive(boolean competitive) {
        this.competitive = competitive;
    }

    @Override
    public String toString() {
        return "Swimmer ID: " + swimmerId +
                "\nName: " + name +
                "\nBirth date: " + birthDate +
                "\nMembership: " + (active ? "Active" : "Passive") +
                "\nSwimmer type: " +
                (!active ? "None" : competitive ? "Competitive" : "Casual");
    }
}
