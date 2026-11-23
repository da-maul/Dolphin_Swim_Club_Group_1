import java.util.ArrayList;

public class CoachShowSwimmers implements Actable{

    //function so that this class can also act as a helper class
    public void showAllSwimmers(ArrayList<Swimmer> swimmerList){
        for (Swimmer swimmer : swimmerList){
            IO.println(swimmer);
        }
    }

    @Override
    public void act(Club club) {
        showAllSwimmers(club.getSwimmers());
    }
}
