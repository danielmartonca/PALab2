package optional.locations;

/**
 * The class Factory overrides methods of the abstract class Source
 */
public class Factory extends Source {

    /**
     * Constructor for factory object
     *
     * @param supply the current supply
     * @param name   the name of the factory
     */
    public Factory(int supply, String name) {
        super(supply, name);
    }

    /**
     * Overridden method to get the type of the object
     *
     * @return the type of the object under String form
     */
    @Override
    public String getType() {
        return "FACTORY";
    }

    /**
     * Overridden method toString
     *
     * @return String containing all the data members of the object
     */
    @Override
    public String toString() {
        return "Factory{" +
                "supply=" + getSupply() +
                ", name='" + getName() + '\'' +
                ", type=" + getType() +
                '}';
    }
}
