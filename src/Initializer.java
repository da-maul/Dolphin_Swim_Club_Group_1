import java.util.ArrayList;

public class Initializer {
    //Initializer is the class that all data is initialized in, in the "initialize" class
    //this is very specifically to clean up Main and to make it have as few function calls
    //as possible

    public void initialize(){
        Club clubDolphin = new Club();
        SwimmerCsvFileHandler fileHandler = new SwimmerCsvFileHandler();
        ArrayList<Swimmer> swimmers = fileHandler.loadSwimmers();
        clubDolphin.loadSwimmers(swimmers);
        UIElement consoleRoot = new UIElement("Root");
        ConsoleUI console = new ConsoleUI(clubDolphin, consoleRoot);
        UIElement ownerElem = new UIElement("Owner", consoleRoot);
        ownerElem.addChild("Show members", new CoachShowSwimmers());
        ownerElem.addChild("Register new swimmer", new SwimmerRegistration(clubDolphin, fileHandler));
        ownerElem.addChild("Edit member details", new SwimmerEditing(fileHandler));
        //add owner children here
        UIElement treasurerElem = new UIElement("Treasurer", consoleRoot);
        //add treasurer children here
        UIElement coachElem = new UIElement("Coach", consoleRoot);
        //add coach children here
        UIElement memberElem = new UIElement("Member", consoleRoot);

        console.run();
    }
}
//wario &
