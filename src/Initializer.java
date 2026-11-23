
public class Initializer {

    public void initialize() {

        // Create club
        Club club = new Club();

        // Create root menu
        UIElement consoleRoot = new UIElement("Root");

        // Create role menus
        consoleRoot.addChild("Owner");
        consoleRoot.addChild("Treasurer");
        consoleRoot.addChild("Coach");
        consoleRoot.addChild("swimmer");

        // Get owner menu
        UIElement ownerElem = consoleRoot.getChildren().get(0);

        // Add member registration to Owner
        ownerElem.addChild(
                "Register new swimmer",
                new SwimmerRegistration(club)
        );

        // Start console
        ConsoleUI console = new ConsoleUI(consoleRoot);
        console.run();
    }
}