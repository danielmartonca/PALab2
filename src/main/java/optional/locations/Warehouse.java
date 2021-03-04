package optional.locations;

/**
 * The class Warehouse overrides methods of the abstract class Source
 */
public class Warehouse extends Source {

    /**
     * Constructor for the Warehouse
     *
     * @param supply the current supply
     * @param name   the warehouse name
     */
    public Warehouse(int supply, String name) {
        super(supply, name);
    }

    /**
     * Overridden method to get the type of the object
     *
     * @return the type of the object under String form
     */
    @Override
    public String getType() {
        return "WAREHOUSE";
    }

    /**
     * Overridden method toString
     *
     * @return String containing all the data members of the object
     */
    @Override
    public String toString() {
        return "Warehouse{" +
                "supply=" + getSupply() +
                ", name='" + getName() + '\'' +
                ", type=" + getType() +
                '}';
    }
}
