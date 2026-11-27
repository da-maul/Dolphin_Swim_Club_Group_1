import java.util.ArrayList;

public class CoachShowSwimmers implements Actable{
    //technically this should just be "show swimmers" since multiple users see lists of swimmers but I'm too lazy to fix it.

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
//wario &
