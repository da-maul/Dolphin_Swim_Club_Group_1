import java.util.ArrayList;

public class CoachShowSwimmers implements Actable{


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
