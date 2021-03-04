package bonus;

import bonus.locations.Destination;
import bonus.locations.Source;
import bonus.locations.SourceType;
import bonus.problem.Problem;
import bonus.solution.Solution;

/**
 * The purpose of the class MyMain for bonus is to create a instance of the transportation problem and
 * and find the lowest cost solution to the problem.
 * We create 3
 */
public class MyMain {
    public static void main(String[] args) {

        // create an array of object of type Source
        Source[] sources = new Source[3];
        // create 3 different Sources
        sources[0] = new Source(300, "Sursa1", SourceType.FACTORY);
        sources[1] = new Source(400, "Sursa2", SourceType.WAREHOUSE);
        sources[2] = new Source(500, "Sursa3", SourceType.WAREHOUSE);

        //  create an array of object of type Destination
        // create 3 different Destinations
        Destination[] destinations = new Destination[4];
        destinations[0] = new Destination(250, "Destinatie1");
        destinations[1] = new Destination(350, "Destinatie2");
        destinations[2] = new Destination(400, "Destinatie3");
        destinations[3] = new Destination(200, "Destinatie3");

        // create an cost matrix for that corresponds to each source and destination
        // costMatrix[i][j] -  Sursa{i-1} has the cost costMatrix[i][j] to the destination Destinatie{j-1}
        int[][] costMatrix = {
                {3, 1, 7, 4},
                {2, 6, 5, 9},
                {8, 3, 3, 2}
        };

        //create an instance of the problem with the given input
        Problem problem1 = new Problem(sources, destinations, costMatrix);

        //print the problem instance on the screen
        problem1.print();
        //solve it
        Solution solution = problem1.solve();
        //print solution to the screen
        solution.printSolution();
    }
}
