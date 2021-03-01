package compulsory;

import compulsory.locations.SourceType;
import compulsory.locations.Destination;
import compulsory.problem.Problem;
import compulsory.locations.Source;

/**
 * The purpose of the class MyMain for compulsory is to create a instance of the transportation problem
 * and print it on the screen.
 * We create 3
 */
public class MyMain {
    public static void main(String[] args) {

        // create an array of object of type Source
        Source[] sources = new Source[3];
        // create 3 different Sources
        sources[0] = new Source(10, "Sursa1", SourceType.FACTORY);
        sources[1] = new Source(35, "Sursa2", SourceType.WAREHOUSE);
        sources[2] = new Source(25, "Sursa3", SourceType.WAREHOUSE);

        //  create an array of object of type Destination
        // create 3 different Destinations
        Destination[] destinations = new Destination[3];
        destinations[0] = new Destination(20, "Destinatie1");
        destinations[1] = new Destination(25, "Destinatie2");
        destinations[2] = new Destination(25, "Destinatie3");

        // create an cost matrix for that corresponds to each source and destination
        // costMatrix[i][j] -  Sursa{i-1} has the cost costMatrix[i][j] to the destination Destinatie{j-1}
        int[][] costMatrix = {
                {2, 3, 1},
                {5, 4, 8},
                {5, 6, 8}
        };

        //create an instance of the problem with the given input
        Problem problem1 = new Problem(sources, destinations, costMatrix);

        //print the problem instance on the screen
        problem1.print();
    }
}
