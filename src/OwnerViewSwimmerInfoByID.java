import java.util.ArrayList;

public class OwnerViewSwimmerInfoByID implements Actable{

    @Override
    public void act(Club club) {
        displaySwimmerInfoByID(club);
    }

    private void displaySwimmerInfoByID(Club club) {
        ArrayList<Swimmer> swimmersList = club.getSwimmers();
        int searchID = readID();

        for (Swimmer swimmer : swimmersList) {
            if (swimmer.getSwimmerId() == searchID) {
                IO.println(
                        "Name: " + swimmer.name + "\n" +
                                "ID: " + swimmer.getSwimmerId() + "\n" +
                                (swimmer.isActive ? "Active" : "Inactive") + "\n" +
                                (swimmer.isCompetitive ? "Coach: " + swimmer.coach + "\n" : "") +
                                (swimmer.isCompetitive ? "Competitive" : "Casual") + "\n" +
                                (swimmer.isCompetitive ? "Disciplines: " + swimmer.disciplines + "\n" : "")
                );
                return;
            }
        }

        IO.println("Swimmer not found.");
    }
    private int readID() {
        while (true) {
            IO.print("Enter ID to search: ");
            String idS = IO.readln().trim();
            if (!idS.isEmpty()) {
                try {return Integer.parseInt(idS);}
                catch (NumberFormatException e) {
                    IO.println("IDs only consist of numbers, try again...");
                }
            }
        }
    }

}
//wario