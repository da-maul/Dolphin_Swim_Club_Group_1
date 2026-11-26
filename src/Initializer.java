public class Initializer {
    //Initializer is the class that all data is initialized in, in the "initialize" class
    //this is very specifically to clean up Main and to make it have as few function calls
    //as possible

    public void initialize(){
        Club clubDolphin = new Club();
        UIElement consoleRoot = new UIElement("Root");
        ConsoleUI console = new ConsoleUI(clubDolphin, consoleRoot);
        UIElement ownerElem = new UIElement("Owner", consoleRoot);
        //connects the owner menu to its actions
        ownerElem.addChild("Register member", new SwimmerRegistration(clubDolphin));
        ownerElem.addChild("Show members", new CoachShowSwimmers());
        ownerElem.addChild("Edit member details", new SwimmerEditing());
        UIElement treasurerElem = new UIElement("Treasurer", consoleRoot);
        //add treasurer children here
        UIElement coachElem = new UIElement("Coach", consoleRoot);
        //add coach children here
        UIElement memberElem = new UIElement("Member", consoleRoot);

        console.run();
    }
}
