import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class SwimmerRegistration implements Actable {

    private final Club club;
    private int nextSwimmerId = 1001;

    public SwimmerRegistration(Club club) {
        this.club = club;
    }

    @Override
    public void act() {
        addSwimmer();
    }

    private String readName() {
        while (true) {
            IO.print("Enter name: ");
            String name = IO.readln().trim();

            if (!name.isEmpty()) {
                return name;
            }

            IO.println("Name cannot be empty.");
        }
    }

    private LocalDate readBirthDay() {
        while (true) {
            IO.print("Enter birth date (yyyy-mm-dd): ");
            String input = IO.readln();

            try {
                LocalDate date = LocalDate.parse(input);

                if (date.isAfter(LocalDate.now())) {
                    IO.println("Birth date cannot be in the future.");
                    continue;
                }

                return date;

            } catch (DateTimeParseException e) {
                IO.println("Invalid date. Use yyyy-mm-dd.");
            }
        }
    }

    private boolean readBoolean(String message) {
        while (true) {
            IO.print(message);
            String input = IO.readln().trim();

            if (input.equalsIgnoreCase("yes")) {
                return true;
            }

            if (input.equalsIgnoreCase("no")) {
                return false;
            }

            IO.println("Invalid input. Enter yes or no.");
        }
    }
    public void addSwimmer() {
        String name = readName();
        LocalDate birthDay = readBirthDay();
        boolean active = readBoolean("Active (yes/no): ");
        boolean competitive = active && readBoolean("Competitive (yes/no): ");

        int swimmerId = generateSwimmerId();

        Swimmer swimmer = new Swimmer(
                birthDay,
                name,
                competitive,
                active,
                new ArrayList<>(),
                0.0,
                null,
                swimmerId
        );
        club.registerSwimmer(swimmer);

        IO.println("Swimmer registered: " + swimmer);
    }
    private int generateSwimmerId() {
        return nextSwimmerId++;
    }
}