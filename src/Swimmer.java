import java.time.LocalDate;
import java.util.ArrayList;
//Swimmer holds all data regarding members of the swim club
//remember to NOT store derived statistics like age or membership fee

//In other classes, please refer to SWIMMERS as SWIMMERS and NOT MEMBERS
public record Swimmer(
        LocalDate birthDay,
        String name,
        boolean isCompetitive,
        boolean isActive,
        ArrayList<Discipline> disciplines,
        double unpaidDues,
        Coach coach,
        int swimmerId
) {
  public int getSwimmerId() {
        return swimmerId;
    }
    private String displayDisciplines(){
        //this may be dumb
        StringBuilder returnString;
        if (disciplines != null){
            returnString = new StringBuilder(", disciplines: ");
            for (Discipline discipline : disciplines){
                returnString.append(discipline+", ");
            }
            return returnString.toString();
        }
        else return "";
    }

    private String displayDues(){
        if (unpaidDues > 0){
            return """
                    owes: $%.2f
                    """.formatted(unpaidDues);
        }
        else return "";
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
        //this is very dumb and hacked together
        return swimmerId +": "+ name ;
    }
}
//wa