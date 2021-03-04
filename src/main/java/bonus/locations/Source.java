package bonus.locations;

/**
 * The purpose of the Source class is to store the information regarding
 * a Source in the transportation problem;
 * It has an integer supply ,a name that can't be changed,
 * and the type of the source which is a an enum;
 * It has a constructor getter and setter for demand, a getter for "name"
 * and a getter for type;
 */
public class Source {
    private int supply;
    private final String name;
    private final SourceType type;

    /**
     * Constructor for the source
     *
     * @param supply initial supply
     * @param name   the name of the source
     * @param type   the type of the source
     */
    public Source(int supply, String name, SourceType type) {
        this.supply = supply;
        this.name = name;
        this.type = type;
    }

    /**
     * Getter for supply
     *
     * @return the current supply of the source
     */
    public int getSupply() {
        return supply;
    }

    /**
     * Setter for supply
     *
     * @param supply the valued which is going to be set to the supply
     */
    public void setSupply(int supply) {
        this.supply = supply;
    }

    /**
     * Getter for name
     *
     * @return the source's name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for type
     *
     * @return the source's type
     */
    public SourceType getType() {
        return type;
    }

    /**
     * Override of the toString function of the root class Object.
     *
     * @return a string containing the class members names and values
     */
    @Override
    public String toString() {
        return "Source{" +
                "supply=" + supply +
                ", name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}
