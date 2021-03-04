package optional;

import optional.locations.Destination;
import optional.locations.Factory;
import optional.locations.Warehouse;
import optional.problem.Problem;
import optional.solution.Solution;

/**
 * The purpose of the class MyMain for optional is to create a instance of the transportation problem
 * and find a solution that is not optimal for the problem.
 * We create 2 different instances of the problem and solve them.
 */
public class MainOptional {
    public static void main(String[] args) {

        //create first instance of the problem and solve it
        Problem problem1 = new Problem();
        problem1.addFactory(new Factory(10, "Source1"));
        problem1.addWarehouse(new Warehouse(35, "Source2"));
        problem1.addWarehouse(new Warehouse(25, "Source3"));

        problem1.addDestination(new Destination(20, "Destination1"));
        problem1.addDestination(new Destination(25, "Destination2"));
        problem1.addDestination(new Destination(25, "Destination3"));

        int[][] costMatrix1 = {
                {2, 3, 1},
                {5, 4, 8},
                {5, 6, 8}
        };
        problem1.setCostMatrix(costMatrix1);

        Solution solution = problem1.solveNonOptimal();
        solution.printSolution();

        //the second instance of the problem
        Problem problem2 = new Problem();
        problem2.addFactory(new Factory(300, "Source1"));
        problem2.addWarehouse(new Warehouse(400, "Source2"));
        problem2.addWarehouse(new Warehouse(500, "Source3"));

        problem2.addDestination(new Destination(250, "Destination1"));
        problem2.addDestination(new Destination(350, "Destination2"));
        problem2.addDestination(new Destination(400, "Destination3"));
        problem2.addDestination(new Destination(200, "Destination4"));


        int[][] costMatrix2 = {
                {3, 1, 7, 4},
                {2, 6, 5, 9},
                {8, 3, 3, 2}
        };

        problem2.setCostMatrix(costMatrix2);

        Solution solution2 = problem2.solveNonOptimal();
        solution2.printSolution();
    }
}
