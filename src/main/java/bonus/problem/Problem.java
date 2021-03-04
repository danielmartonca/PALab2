package bonus.problem;

import bonus.locations.Destination;
import bonus.locations.Source;
import bonus.solution.Solution;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * The class Problem's purpose for bonus task is to store an instance of the transportation problem
 * print it out on the screen and solve it using an optimal method
 * It has an array of Source type objects, an array of Destination type objects
 * and an matrix of size source.length X destination.length corresponding to the cost matrix of the problem.
 */
public class Problem {
    private final Source[] sources;
    private final Destination[] destinations;
    private final int[][] costMatrix;

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
     * Method that prints to the screen the instance of the problem under the form of:
     * Destinatie1   Destinatie2   Destinatie3 ...     Supply
     * Sursa1     2              3              1       ...       10
     * Sursa2     5              4              8       ...       35
     * Sursa3     5              6              8       ...       25
     * ...
     * Demand     20             25             25      ...
     * <p>
     * I decided to implement the method print because it's much easier to read the information
     * under this form than using toString method.
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
        System.out.println(" ");
    }

    /**
     * This method find a list of pairs  < rowDifference,row > used to solve the problem
     *
     * @return an ArrayList list containing the the Column Differences values used to solve the problem
     */
    private List<Pair<Integer, Integer>> getColumnDifference() {
        //create and allocate the memory for the list
        List<Pair<Integer, Integer>> columnDifference = new ArrayList<>(destinations.length);
        //go trough each column/destination
        for (int j = 0; j < destinations.length; j++)
            if (destinations[j].getDemand() > 0) {  //if the destination's demand is not yet met
                //find the least two costs on the row
                int minValue1 = -1, minValue2 = -1;
                for (int i = 0; i < sources.length; i++) {
                    //get the cost
                    int cost = costMatrix[i][j];
                    if (sources[i].getSupply() != 0) {  //if there is still supply in the source
                        if (minValue1 == -1) {  //if we didn't set the first value yet
                            minValue1 = cost;
                        } else if (minValue2 == -1) //if we didn't set the second value yet
                        {
                            minValue2 = cost;
                            if (minValue2 < minValue1) {    //swap the values if minValue2 is lower than minValue1
                                int aux = minValue1;
                                minValue1 = minValue2;
                                minValue2 = aux;
                            }
                        } else {
                            if (cost < minValue1) {     //if the current cost is lower than the first minimum
                                minValue2 = minValue1;  //set the minimum values accordingly
                                minValue1 = cost;
                            } else if (cost < minValue2)    //if the current cost is lower than the second minimum
                                minValue2 = cost;   //the second minimum becomes the cost
                        }
                    }
                }
                //calculate absolute value
                if (minValue1 == -1 || minValue2 == -1)
                    columnDifference.add(new Pair<>(Math.abs(minValue1 - minValue2 + 1), j));  //if there is only one value
                else
                    columnDifference.add(new Pair<>(Math.abs(minValue1 - minValue2), j));
            }
        return columnDifference;
    }

    /**
     * This method is very similar to getColumnDifference, the only difference being that it calculates
     * the difference on the rows instead of the columns
     * It first goes trough the source's array then the destination's array
     *
     * @return an ArrayList list containing the the Row Differences values used to solve the problem
     */
    private List<Pair<Integer, Integer>> getRowDifference() {

        List<Pair<Integer, Integer>> rowDifference = new ArrayList<>(sources.length);

        for (int i = 0; i < sources.length; i++)
            if (sources[i].getSupply() > 0) {
                //find the least two costs on the row
                int minValue1 = -1, minValue2 = -1;
                for (int j = 0; j < destinations.length; j++) {
                    //get the cost
                    int cost = costMatrix[i][j];
                    if (destinations[j].getDemand() != 0) {
                        if (minValue1 == -1) {  //if we didn't set the first value yet
                            minValue1 = cost;
                        } else if (minValue2 == -1) //if we didn't set the second value yet
                        {
                            minValue2 = cost;
                            //swap if value2  is lower than value1
                            if (minValue2 < minValue1) {
                                int aux = minValue1;
                                minValue1 = minValue2;
                                minValue2 = aux;
                            }
                        } else {
                            if (cost < minValue1) {     //if the current cost is lower than the first minimum
                                minValue2 = minValue1;  //set the minimum values accordingly
                                minValue1 = cost;
                            } else if (cost < minValue2)    //if the current cost is lower than the second minimum
                                minValue2 = cost;   //the second minimum becomes the cost
                        }
                    }
                }
                //calculate absolute value
                if (minValue1 == -1 || minValue2 == -1)
                    rowDifference.add(new Pair<>(Math.abs(minValue1 - minValue2 + 1), i));  //if there is only one value
                else
                    rowDifference.add(new Pair<>(Math.abs(minValue1 - minValue2), i));
            }
        return rowDifference;
    }

    /**
     * This method goes trough the element's of the parameter list and finds the maximum key in the pairs
     *
     * @param list A list of Pairs < Integer,Integer > containing the penalty and the row/column it is found on
     * @return the pair where the maximum penalty is found
     */
    private Pair<Integer, Integer> findMaxPenalty(List<Pair<Integer, Integer>> list) {

        Pair<Integer, Integer> max = list.get(0);
        for (Pair<Integer, Integer> pair : list)
            if (pair.getKey() > max.getKey())
                max = pair;
        return max;
    }

    /**
     * This method finds the minimum cost column in the matrix at the row specified
     *
     * @param row the row to find the minimum cost
     * @return the column it was found on
     */
    private int getColumnOfMinCostRow(int row) {

        int min = -1, posMin = -1;
        for (int j = 0; j < destinations.length; j++)
            if (destinations[j].getDemand() > 0) {
                if (min == -1) {
                    min = costMatrix[row][j];
                    posMin = j;
                } else if (costMatrix[row][j] < min) {
                    min = costMatrix[row][j];
                    posMin = j;
                }
            }
        return posMin;
    }

    /**
     * This method finds the minimum cost row in the matrix at the column specified
     *
     * @param column the column to find the minimum cost
     * @return the row it was found on
     */
    private int getRowOfMinCostColumn(int column) {

        int min = -1, posMin = -1;
        for (int i = 0; i < sources.length; i++)
            if (sources[i].getSupply() > 0) {
                if (min == -1) {
                    min = costMatrix[i][column];
                    posMin = i;
                } else if (costMatrix[i][column] < min) {
                    min = costMatrix[i][column];
                    posMin = i;
                }
            }
        return posMin;
    }

    /**
     * This method is used to check whether we still have at least one demand to satisfy
     * It returns true if at least one demand > 0 was found
     *
     * @return true if one demand >0 was found, false otherwise
     */
    private boolean findDemandUnsatisfied() {

        for (Destination destination : destinations)
            if (destination.getDemand() != 0)
                return true;
        return false;
    }

    /**
     * This methods checks whether the sum of the demands >= the sum of the supply
     *
     * @return true if there is enough supply to satisfy the demands, false otherwise
     */
    private boolean checkIfProblemHasSolution() {
        int demandsSum = 0;

        for (Source source : sources)
            demandsSum += source.getSupply();

        for (Destination destination : destinations)
            demandsSum -= destination.getDemand();

        return demandsSum >= 0;
    }

    /**
     * Explanation of algorithm
     * pair is formed of: - difference found
     * - actual Row/Column number
     *
     * @return 1
     */
    public Solution solve() {
        Solution solution = new Solution();
        //check if problem has solution first
        if (!checkIfProblemHasSolution()) {
            solution.addSolution(new Pair<>("Problem does not have solution", " invalid input."), -1);
            return solution;
        }
        //until we satisfy all demands / solve the problem
        do {
            //find the max penalty
            Pair<Integer, Integer> maxPenaltyRow = findMaxPenalty(getRowDifference());
            Pair<Integer, Integer> maxPenaltyColumn = findMaxPenalty(getColumnDifference());

            int row, column, cost = 0;
            //if it's a row
            if (maxPenaltyRow.getKey() > maxPenaltyColumn.getKey()) {
                row = maxPenaltyRow.getValue();
                column = getColumnOfMinCostRow(row);
            } else {
                column = maxPenaltyColumn.getValue();
                row = getRowOfMinCostColumn(column);
            }

            if (sources[row].getSupply() > destinations[column].getDemand()) {
                cost += costMatrix[row][column] * destinations[column].getDemand();
                sources[row].setSupply(sources[row].getSupply() - destinations[column].getDemand());
                destinations[column].setDemand(0);
            } else {
                cost += costMatrix[row][column] * sources[row].getSupply();
                destinations[column].setDemand(destinations[column].getDemand() - sources[row].getSupply());
                sources[row].setSupply(0);
            }
            solution.addSolution(new Pair<>(sources[row].getName(), destinations[column].getName()), cost);

        }
        while (findDemandUnsatisfied());

        return solution;
    }
}
