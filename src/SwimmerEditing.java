import java.time.LocalDate;
import java.time.format.DateTimeParseException;
//Handless user input for editing an existing member
public class SwimmerEditing implements Actable {

    @Override
    public void act (Club club){
        IO.print("Enter member ID: ");
        int swimmerId;
//Convert the input to a swimmerID. Invalid if the input is wrong
        try {2
            swimmerId = Integer.parseInt(IO.readln().trim());
        } catch (NumberFormatException e) {
            IO.println("Please enter a whole number.");
            return;
        }
//finding the swimmer in the clubs swimmer list
        Swimmer swimmer = club.findSwimmerById(swimmerId);
//Stops if swimmerID isn't found
        if (swimmer == null) {
            IO.println("Member not found.");
            return;
        }

        IO.println(swimmer);
        IO.println("1: Change name");
        IO.println("2: Change birth date");
        IO.println("3: Change membership type");
        IO.println("0: Cancel");

        String choice = IO.readln().trim();

        if (choice.equals("1")) {
            IO.print("Enter new name: ");
            String name = IO.readln().trim();

            if (name.isEmpty()) {
                IO.println("Name cannot be empty.");
                return;
            }

            swimmer.setName(name);

        } else if (choice.equals("2")) {
            IO.print("Enter birth date (yyyy-mm-dd): ");
            String input = IO.readln().trim();

            try {
                LocalDate birthDate = LocalDate.parse(input);

                if (birthDate.isAfter(LocalDate.now())) {
                    IO.println("Birth date cannot be in the future.");
                    return;
                }

                swimmer.setBirthDate(birthDate);

            } catch (DateTimeParseException e) {
                IO.println("Invalid date. Use yyyy-mm-dd, for example 2000-05-12.");
                return;
            }

        } else if (choice.equals("3")) {
            IO.println("1: Passive member");
            IO.println("2: Active casual swimmer");
            IO.println("3: Active competitive swimmer");

            String membership = IO.readln().trim();

            if (membership.equals("1")) {
                //passive members can't be registered as competitive
                swimmer.setActive(false);
                swimmer.setCompetitive(false);

            } else if (membership.equals("2")) {
                swimmer.setActive(true);
                swimmer.setCompetitive(false);

            } else if (membership.equals("3")) {
                swimmer.setActive(true);
                swimmer.setCompetitive(true);

            } else {
                IO.println("Invalid option.");
                return;
            }

        } else if (choice.equals("0")) {
            IO.println("Changes cancelled.");
            return;

        } else {
            IO.println("Invalid option.");
            return;
        }

        IO.println("Member details updated:");
        IO.println(swimmer);
    }
}