package optional.locations;

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

    /**
     * Override of the toString function of the root class Object.
     * @return a string containing the class members names and values
     */
    @Override
    public String toString() {
        return "Destination{" +
                "demand=" + demand +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     * Override of the method equals of class Object. This method tests if two objects are the same.
     * I assumed that two objects of type Destination are the same if they have the same toString value.
     * This means that two objects of type Destination can have the same name as long that their demand is different.
     * @param obj the object to check whether it's equal to this or not
     * @return  true if they are equal; false if they are not equal
     */
    @Override
    public boolean equals(Object obj) {

        //if the reference is the same
        if (this==obj)
            return true;

        //if they have the same toString value, it means they are equal
        //convert obj to Destination and test their toString value
        return this.toString().equals(((Destination) obj).toString());
    }
}
