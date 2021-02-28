package compulsory.problem;

import compulsory.locations.Destination;
import compulsory.locations.Source;

/**
 * The class Problem's purpose for compulsory task is only to store an instance of the transportation problem
 * and print it out on the screen.
 * It has an array of Source type objects, an array of Destination type objects
 * and an matrix of size source.length X destination.length corresponding to the cost matrix of the problem.
 */
public class Problem {
    private Source[] sources;
    private Destination[] destinations;
    private int[][] costMatrix;

    /**
     * Constructor for the Problem object
     *
     * @param sources      array of Source type objects used to store the sources
     * @param destinations array of Destination type objects used to store the destinations
     * @param costMatrix   matrix containing the cost from each source to each destination
     */
    public Problem(Source[] sources, Destination[] destinations, int[][] costMatrix) {

        this.sources = new Source[sources.length];
        System.arraycopy(sources, 0, this.sources, 0, sources.length);


        this.destinations = new Destination[destinations.length];
        System.arraycopy(destinations, 0, this.destinations, 0, destinations.length);

        this.costMatrix = new int[sources.length][destinations.length];
        //copy each line of costMatrix to this.costMatrix
        for (int i = 0; i < sources.length; i++)
            System.arraycopy(costMatrix[i], 0, this.costMatrix[i], 0, destinations.length);
    }

    /**
     * Returns the number of sources in the problem
     *
     * @return the number of sources in the problem
     */
    public int getNrSources() {
        return sources.length;
    }

    /**
     * Returns the source at position i
     *
     * @param i the position of the source in the array
     * @return the Source object stored in the array at position i
     */
    public Source getSource(int i) {
        return sources[i];
    }

    /**
     * Setter for the sources array.
     *
     * @param sources the new Sources array for the problem.
     */
    public void setSources(Source[] sources) {
        this.sources = sources;
    }

    /**
     * Returns the number of destinations in the problem
     *
     * @return the number of destinations in the problem
     */
    public int getNrDestinations() {
        return destinations.length;
    }

    /**
     * Returns the destinations at position i
     *
     * @param i the position of the destinations in the array
     * @return the destinations object stored in the array at position i
     */
    public Destination getDestination(int i) {
        return destinations[i];
    }

    /**
     * Setter for the destinations array.
     *
     * @param destinations the new destinations array for the problem.
     */
    public void setDestinations(Destination[] destinations) {
        this.destinations = destinations;
    }

    /**
     * Getter for the cost matrix
     *
     * @return returns the cost matrix of the instance
     */
    public int[][] getCostMatrix() {
        return costMatrix;
    }

    /**
     * Setter for the cost matrix
     *
     * @param costMatrix the new cost matrix for the problem
     */
    public void setCostMatrix(int[][] costMatrix) {
        this.costMatrix = costMatrix;
    }

    /**
     * Method that prints to the screen the instance of the problem under the form of:
     *          Destinatie1   Destinatie2   Destinatie3 ...     Supply
     * Sursa1     2              3              1       ...       10
     * Sursa2     5              4              8       ...       35
     * Sursa3     5              6              8       ...       25
     * ...
     * Demand     20             25             25      ...
     */
    public void print() {
        System.out.print("        ");
        for (Destination value : destinations) System.out.print(value.getName() + "   ");

        System.out.println("    Supply");

        for (int i = 0; i < sources.length; i++) {
            System.out.print(sources[i].getName() + "     ");

            for (int j = 0; j < destinations.length; j++)
                System.out.print(costMatrix[i][j] + "              ");

            System.out.println(sources[i].getSupply());
        }

        System.out.print("Demand     ");
        for (Destination destination : destinations) System.out.print(destination.getDemand() + "             ");
    }

}
