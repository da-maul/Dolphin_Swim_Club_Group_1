import java.util.ArrayList;

public class ConsoleUI {
    //parses through UI Elements and acts on tree endpoints, main loop for the program.
    final private UIElement root; // root is root node of UI tree
    //TODO add UI element for returning to previous menu
    //TODO add UI element for option to exit program
    private UIElement pointer; // pointer is the UI Element currently being displayed

    public ConsoleUI(UIElement root){
        this.root = root;
        this.pointer = root;
    }

    public void run(){
        // main loop, no code, method calls ONLY
        displayMenu();
        parseChoice();
    }

    void displayMenu(){
        ArrayList<UIElement> elements = pointer.getChildren();
        int increment = 1;
        for (UIElement element : elements){
            IO.println(increment +"): " + element);
            increment++;
        }
        IO.println();
    }

    void parseChoice(){
        //TODO this method is kinda lazy and sloppy and needs a second look
        ArrayList<UIElement> elements = pointer.getChildren();
        boolean invalidChoice = true;
        int userChoice = -1;
        while (invalidChoice){
            userChoice= Integer.parseInt(IO.readln());
            if (userChoice > elements.size() || userChoice < 1){
                IO.println("Invalid input, please input a valid number...");
            }
            else invalidChoice = false;
        }
        UIElement chosenElement = elements.get(userChoice-1);
        //TODO may be worth a second look at how this bit works
        if (chosenElement.hasActable()) chosenElement.act();
        else pointer = chosenElement;
    }
}
