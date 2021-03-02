package optional.locations;

/**
 * The purpose of the Source class is to store the information regarding
 * a Source in the transportation problem;
 * It has an integer supply ,a name that can't be changed,
 * and the type of the source which is a an enum;
 * It has a constructor getter and setter for demand, a getter for "name"
 * and a getter for type;
 */
public abstract class Source {
    private int supply;
    private final String name;

    public Source(int supply, String name) {
        this.supply = supply;
        this.name = name;
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
     * Abstract method that returns what type the Source is
     *
     * @return the source's type
     */
    public abstract String getType();

    /**
     * Abstract override of the toString function of the root class Object.
     *
     * @return a string containing the class members names and values
     */
    @Override
    public abstract String toString();

    @Override
    public boolean equals(Object obj) {
        //if the reference is the same
        if (this == obj)
            return true;

        //alternative way of testing if two Source objects are the same
        //return (((Source) obj).name.equals(this.name) && ((Source)obj).supply==this.supply && ((Source) obj).type==this.type);

        //if they have the same toString value, it means they are equal
        //convert obj to Destination and test their toString value
        return this.toString().equals(((Source) obj).toString());
    }
}
