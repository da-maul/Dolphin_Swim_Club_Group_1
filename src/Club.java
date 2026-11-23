
import java.util.ArrayList;

public class Club {

    private final ArrayList<Swimmer> swimmers;
    private int nextSwimmerId;

    public Club() {
        swimmers = new ArrayList<>();
        nextSwimmerId = 1001;
    }

    public void registerSwimmer(Swimmer swimmer) {
        swimmers.add(swimmer);
    }

    public ArrayList<Swimmer> getSwimmers() {
        return new ArrayList<>(swimmers);
    }

    public Swimmer findSwimmerById(int swimmerId) {
        for (Swimmer swimmer : swimmers) {
            if (swimmer.getSwimmerId() == swimmerId) {
                return swimmer;
            }
        }
        return null;
    }
}
//wa