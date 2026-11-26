import java.util.ArrayList;

public class UIElement {
    //UI elements have a reference to the parent they belong to and also to their
    //children (stored in an arraylist)
    //UI elements are parsed through by the ConsoleUI class, moving up and down the
    //"tree" to get the user to the desired function which is an "Actable" object

    private UIElement parent;
    private ArrayList<UIElement> children = new ArrayList<>();

    private final String displayText;
    private Actable actMethod;

    //constructor may be initialized with or without a defined parent
    public UIElement(String displayText, UIElement parent){
        // this constructor has a defined parent
        this.parent = parent;
        this.displayText = displayText;
        parent.addChild(this);
    }
    public UIElement(String displayText, Actable actMethod){
        // this constructor does not have a defined parent (parent must be added later)
        this.displayText = displayText;
        this.actMethod = actMethod;
    }
    public UIElement(String displayText){
        // this constructor does not have a defined parent (parent must be added later)
        this.displayText = displayText;
    }


    //getters
    public UIElement getParent() {return parent;}
    public ArrayList<UIElement> getChildren() {return children;}
    public boolean hasActable(){return actMethod != null;}

    public void addParent(UIElement parent){
        this.parent = parent;
    }

    public void addChild(UIElement child){
        //method for acting pre-existing children
        children.add(child);
        child.addParent(this);
    }
    public void addChild(String displayText, Actable actMethod){
        //method for constructing new children WITH an Actable
        UIElement child = new UIElement(displayText, actMethod);
        children.add(child);
        child.addParent(this);
    }
    public void addChild(String displayText){
        //method for constructing new children WITHOUT an Actable
        UIElement child = new UIElement(displayText);
        children.add(child);
        child.addParent(this);
    }

    public void act(Club club){
        // calls the Actable class attached to tree endpoints
        // do not edit to prevent a crash here, edit consoleUI so that this method is
        // never called if actMethod is NULL
        actMethod.act(club);
    }

    @Override
    public String toString() {
        return displayText;
    }
}
//wario
