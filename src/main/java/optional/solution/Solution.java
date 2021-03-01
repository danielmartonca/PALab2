package optional.solution;


import javafx.util.Pair;

import java.util.LinkedList;
import java.util.List;

/**
 * The class's purpose is to store the solution calculated in the problem.
 * It has method that prints the solution and the total cost.
 */
public class Solution {

    private final List<Pair<String, String>> solutions;
    private int totalCost;

    public Solution() {
        this.solutions = new LinkedList<>();
        totalCost = 0;
    }

    public void addSolution(Pair<String, String> pair, int cost) {
        solutions.add(pair);
        totalCost += cost;
    }

    public void printSolution() {
        for (Pair<String, String> tuple : solutions) {
            System.out.println(tuple.getKey() + "->" + tuple.getValue());
        }
        System.out.println("Total cost: " + Integer.toString(totalCost));
    }
}
