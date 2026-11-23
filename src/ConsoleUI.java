import java.util.ArrayList;

public class ConsoleUI {
    //parses through UI Elements and acts on tree endpoints, main loop for the program.
    final private UIElement root; // root is root node of UI tree
    //TODO add UI element for returning to previous menu
    //TODO add UI element for option to exit program
    private UIElement pointer; // pointer is the UI Element currently being displayed
    private Club club;
    public ConsoleUI(Club club, UIElement root){
        this.root = root;
        this.pointer = root;
        this.club = club;

    }
    private boolean running = true;

    public void run() {
        while (running) {
            displayMenu();
            parseChoice();
        }
    }

    void displayMenu() {
        ArrayList<UIElement> elements = pointer.getChildren();

        IO.println("\n=== " + pointer + " ===");

        int increment = 1;

        for (UIElement element : elements) {
            IO.println(increment + ": " + element);
            increment++;
        }

        if (pointer.getParent() != null) {
            IO.println("0: Back");
        } else {
            IO.println("0: Exit");
        }

        IO.println();
    }

    void parseChoice() {
        ArrayList<UIElement> elements = pointer.getChildren();

        while (true) {
            IO.print("Choose an option: ");
            String input = IO.readln();

            int userChoice;

            try {
                userChoice = Integer.parseInt(input.trim());
            } catch (NumberFormatException e) {
                IO.println("Invalid input. Enter a number.");
                continue;
            }

            if (userChoice == 0) {
                if (pointer.getParent() == null) {
                    running = false;
                    IO.println("Exiting program...");
                } else {
                    pointer = pointer.getParent();
                }
                return;
            }

            if (userChoice < 1 || userChoice > elements.size()) {
                IO.println("Invalid option. Try again.");
                continue;
            }

            UIElement chosenElement = elements.get(userChoice - 1);

            if (chosenElement.hasActable()) {
                chosenElement.act(club);
            } else {
                pointer = chosenElement;
            }

            return;
        }
    }
}
//wa
