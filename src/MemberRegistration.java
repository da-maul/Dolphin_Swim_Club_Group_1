import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class MemberRegistration implements Actable {

    private final Club club;

    public MemberRegistration(Club club) {
        this.club = club;
    }

    @Override
    public void act() {
        IO.println("=== Register new member ===");

        String name = readName();
        LocalDate birthDate = readBirthDate();
        boolean active = readBoolean("Active member (yes/no): ");

        boolean competitive = false;

        if (active) {
            competitive = readBoolean(
                    "Competitive swimmer (yes/no): "
            );
        }

        Member member = club.addMember(
                name,
                birthDate,
                active,
                competitive
        );

        IO.println("Member successfully registered!");
        IO.println(member);
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

    private LocalDate readBirthDate() {
        while (true) {
            IO.print("Enter birth date (yyyy-MM-dd): ");
            String input = IO.readln();

            try {
                LocalDate date = LocalDate.parse(input);

                if (date.isAfter(LocalDate.now())) {
                    IO.println("Birth date cannot be in the future.");
                    continue;
                }

                return date;

            } catch (DateTimeParseException e) {
                IO.println("Invalid date. Use yyyy-MM-dd.");
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
}