import java.time.LocalDate;
import java.util.ArrayList;
//Swimmer holds all data regarding members of the swim club
//remember to NOT store derived statistics like age or membership fee
public record Swimmer(
        LocalDate birthDay,
        String name,
        boolean isCompetitive, //may be better as an Enum
        boolean isActive, //may be better as an Enum
        ArrayList<Discipline> disciplines,
        double unpaidDues,
        Coach coach
) {}
