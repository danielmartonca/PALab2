package optional.problem;

import javafx.util.Pair;
import optional.locations.Destination;
import optional.locations.Factory;
import optional.locations.Source;
import optional.locations.Warehouse;
import optional.solution.Solution;

import java.util.LinkedList;
import java.util.List;

/**
 * The class Problem's purpose for compulsory task is only to store an instance of the transportation problem
 * and print it out on the screen.
 * It has two Lists of Factory and Warehouse type objects, an List of Destination type objects
 * and a cost matrix.
 */
public class Problem {
    private final List<Factory> factories;
    private final List<Warehouse> warehouses;
    private final List<Destination> destinations;
    private int[][] costMatrix;

    /**
     * Constructor allocating memory
     */
    public Problem() {
        factories = new LinkedList<>();
        warehouses = new LinkedList<>();
        destinations = new LinkedList<>();
        costMatrix = new int[1][1];
    }

    /**
     * Method to add object in the list of factories.
     *
     * @param obj the object to be added to the linked list.
     */
    public void addFactory(Factory obj) {
        factories.add(obj);
    }

    /**
     * Method to add object in the list of warehouses.
     *
     * @param obj the object to be added to the linked list.
     */
    public void addWarehouse(Warehouse obj) {
        warehouses.add(obj);
    }

    /**
     * Method to add object in the list of destinations.
     *
     * @param obj the object to be added to the linked list.
     */
    public void addDestination(Destination obj) {
        destinations.add(obj);
    }

    /**
     * Method to set the cost matrix
     *
     * @param costMatrix the new cost matrix.
     */
    public void setCostMatrix(int[][] costMatrix) {
        this.costMatrix = new int[factories.size() + warehouses.size()][destinations.size()];
        //copy each line of costMatrix to this.costMatrix
        int i = 0;
        for (; i < factories.size(); i++)
            System.arraycopy(costMatrix[i], 0, this.costMatrix[i], 0, destinations.size());
        for (; i < warehouses.size() + factories.size(); i++)
            System.arraycopy(costMatrix[i], 0, this.costMatrix[i], 0, destinations.size());
    }

    /**
     * Method that finds the minimum cost for the specified column
     *
     * @param column the column in which to find the minimum cost
     * @return the line where the minimum cost was found
     */
    private int findMinimumCostLineNr(int column) {
        int minimumCostLine = 0;
        int minimumCost = Integer.MAX_VALUE;

        //find minimum cost
        int line = -1;
        for (Factory factory : factories) {
            line++;
            //if we found a lower value update minimum cost
            if (factory.getSupply() > 0 && costMatrix[line][column] < minimumCost) {
                minimumCost = costMatrix[line][column];
                minimumCostLine = line;
            }
        }
        for (Warehouse warehouse : warehouses) {
            line++;
            //if we found a lower value update minimum cost
            if (warehouse.getSupply() > 0 && costMatrix[line][column] < minimumCost) {
                minimumCost = costMatrix[line][column];
                minimumCostLine = line;
            }

        }
        return minimumCostLine;
    }

    /**
     * This method solves the problem and returns an object of type Solution to store the solution.
     *
     * @return An object of type Solution which stores a list of strings and a total cost
     */
    public Solution solveNonOptimal() {
        Solution solution = new Solution();


        // Create a Linked list of Source object to store all factories and warehouses as Source objects and call overridden methods
        List<Source> sources = new LinkedList<>();
        sources.addAll(factories);
        sources.addAll(warehouses);


        //For each destination
        int nrDestination = -1;
        for (Destination destination : destinations) {
            nrDestination++;
            //as long as the demand is higher than 0
            while (destination.getDemand() > 0) {
                //find the minimum cost source index for the destination
                int minCostLine = findMinimumCostLineNr(nrDestination);
                Source sourceMin = sources.get(minCostLine);

                Pair<String, String> pair = new Pair<>(sourceMin.getName(), destination.getName());
                int cost = 0;

                //if the supply is higher than the demand, fill the whole demand from the supply and set demand to 0
                if (sourceMin.getSupply() > destination.getDemand()) {
                    cost += costMatrix[minCostLine][nrDestination] * destination.getDemand();   // calculate the cost
                    sourceMin.setSupply(sourceMin.getSupply() - destination.getDemand());
                    destination.setDemand(0);
                } else { //else use all the supply and set the demand correspondingly
                    cost += costMatrix[minCostLine][nrDestination] * sourceMin.getSupply();    // calculate the cost
                    destination.setDemand(destination.getDemand() - sourceMin.getSupply());
                    sourceMin.setSupply(0);
                }
                solution.addSolution(pair, cost);   //add the pair and cost to the solution
            }

        }
        return solution;
    }
}
