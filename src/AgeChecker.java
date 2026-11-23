import java.time.LocalDate;

public class AgeChecker {

    public boolean checkAge(LocalDate birthday){
        //this is the dumbest fucking function on earth
        return  LocalDate.now().isAfter(birthday.plusYears(18));
    }
}