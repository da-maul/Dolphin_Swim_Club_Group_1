import java.util.ArrayList;

public class ConsoleUI {
    //parses through UI Elements and acts on tree endpoints, main loop for the program.
    final private UIElement root; // root is root node of UI tree
    private UIElement pointer; // pointer is the UI Element currently being displayed

    public ConsoleUI(UIElement root){
        this.root = root;
        this.pointer = root;
    }

    public void run(){
        // main loop, no code, method calls ONLY
        displayMenu();
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
        ArrayList<UIElement> elements = pointer.getChildren();
        int userChoice = Integer.parseInt(IO.readln());
        if (userChoice > elements.size() || userChoice < 1){
            IO.println("Invalid ");
        }
    }
}
