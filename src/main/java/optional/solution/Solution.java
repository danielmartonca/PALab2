package optional.solution;


import javafx.util.Pair;

import java.util.LinkedList;
import java.util.List;

/**
 * The class's purpose is to store the solution calculated in the problem.
 * It has method that prints the solution and the total cost.
 * It contains a list of Pairs String and String containing combinations of form "SourceName, DestinationName" in the solution
 * and an total cost.
 */
public class Solution {

    private final List<Pair<String, String>> solutions;
    private int totalCost;

    /**
     * Constructor for solution.
     */
    public Solution() {
        this.solutions = new LinkedList<>();
        totalCost = 0;
    }

    /**
     * Method that adds another element to the solution
     *
     * @param pair Pair containing the Source and Destination in the solution
     * @param cost A cost to be added to the total cost.
     */
    public void addSolution(Pair<String, String> pair, int cost) {
        solutions.add(pair);
        totalCost += cost;
    }

    /**
     * Method that prints the solution to the screen under the form: "SourceName->DestinationName"
     * and the total cost at the end.
     */
    public void printSolution() {
        for (Pair<String, String> tuple : solutions) {
            System.out.println(tuple.getKey() + "->" + tuple.getValue());
        }
        System.out.println("Total cost: " + totalCost);
        System.out.println(" ");
    }
}
