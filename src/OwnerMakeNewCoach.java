import java.util.ArrayList;

public class OwnerMakeNewCoach implements Actable{

    private Coach makeCoach(){
        String coachName = IO.readln("Input New Coach's name...");
        return new Coach(coachName);
    }

    @Override
    public void act(Club club) {
        Coach coachToAdd = makeCoach();
        if (!club.getCoaches().contains(coachToAdd)){
            club.addCoach(coachToAdd);
        }
        else IO.println("That coach already exists.");
    }
}
//Wario