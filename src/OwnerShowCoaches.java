import java.util.ArrayList;

public class OwnerShowCoaches implements Actable{

//lazy copy of "CoachShowSwimmers" (doesn't need to be more complicated than it is)
    private void showAllCoaches(ArrayList<Coach> coachesList){
        for (Coach coach : coachesList){
            IO.println(coach);
        }
    }

    @Override
    public void act(Club club) {
         showAllCoaches(club.getCoaches());
    }
}
//Wario