public interface Actable {
    //Actable interface is applied to classes at endpoints of the UI tree
    //Actable classes are called via the UI element it belongs to.
    public default void act(){};
}
