package compulsory.locations;

/**
 * The purpose of the Destination class is to store the information regarding
 * a destination in the transportation problem
 * It has an integer demand and a name that can't be changed.
 * It has a constructor getter and setter for demand and a getter for "name"
 */
public class Destination {
    private int demand;
    private final String name;

    /**
     * Constructor for the class
     *
     * @param demand starting demand for the destination
     * @param name   the name of the destination
     */
    public Destination(int demand, String name) {
        this.demand = demand;
        this.name = name;
    }

    /**
     * Getter for demand
     *
     * @return returns the current demand for the destination
     */
    public int getDemand() {
        return demand;
    }

    /**
     * Setter for demand
     *
     * @param demand the value that demand is gonna be set to
     */
    public void setDemand(int demand) {
        this.demand = demand;
    }

    /**
     * Getter for name
     *
     * @return returns the name of the destination
     */
    public String getName() {
        return name;
    }

}
