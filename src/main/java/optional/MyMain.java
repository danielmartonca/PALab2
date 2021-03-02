package optional;

import optional.locations.Destination;
import optional.locations.Factory;
import optional.locations.Warehouse;
import optional.problem.Problem;
import optional.solution.Solution;

/**
 * The purpose of the class MyMain for optional is to create a instance of the transportation problem
 * and print it on the screen.
 * We create 3
 */
public class MyMain {
    public static void main(String[] args) {

        Problem problem = new Problem();
        problem.addFactory(new Factory(10, "Source1"));
        problem.addWarehouse(new Warehouse(35, "Source2"));
        problem.addWarehouse(new Warehouse(25, "Source3"));

        problem.addDestination(new Destination(20, "Destination1"));
        problem.addDestination(new Destination(25, "Destination2"));
        problem.addDestination(new Destination(25, "Destination3"));

        int[][] costMatrix = {
                {2, 3, 1},
                {5, 4, 8},
                {5, 6, 8}
        };
        problem.setCostMatrix(costMatrix);

        Solution solution = problem.solveNonOptimal();
        solution.printSolution();
    }
}
