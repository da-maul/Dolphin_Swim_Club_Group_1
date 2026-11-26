
import java.util.ArrayList;

public class Club {
    //Club is responsible for holding all "soft" (unsaved) user data which is operated on by Actable classes
    private ArrayList<Swimmer> swimmers;
    private ArrayList<Coach> coaches;
    private ArrayList<SwimResult> swimResults;
    private int nextSwimmerId;

    public Club() {
        swimmers = new ArrayList<>();
        coaches = new ArrayList<>();
        swimResults = new ArrayList<>();
        //TODO have Club read data from CSV files when initializing the program
        nextSwimmerId = 1001;
    }

    public void registerSwimmer(Swimmer swimmer) {
        swimmers.add(swimmer);
    }
    public void addCoach(Coach coach){
        coaches.add(coach);
    }

    public void loadSwimmers(ArrayList<Swimmer> swimmers) {
        this.swimmers = new ArrayList<>(swimmers);
    }
    //getters
    public ArrayList<Swimmer> getSwimmers() { return new ArrayList<>(swimmers);}
    public ArrayList<Coach> getCoaches() {return coaches;}
    public ArrayList<SwimResult> getSwimResults() {return swimResults;}

    public Swimmer findSwimmerById(int swimmerId) {
        for (Swimmer swimmer : swimmers) {
            if (swimmer.getSwimmerId() == swimmerId) {
                return swimmer;
            }
        }
        return null;
    }
}
//wario