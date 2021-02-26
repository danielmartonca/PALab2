package compulsory.main;

import compulsory.SourceType;
import compulsory.destination.Destination;
import compulsory.problem.Problem;
import compulsory.source.Source;

public class MyMain {
    public static void main(String[] args) {
        Source[] sources = new Source[3];
        sources[0] = new Source(10, "Sursa1", SourceType.FACTORY);
        sources[1] = new Source(35, "Sursa2", SourceType.WAREHOUSE);
        sources[2] = new Source(25, "Sursa3", SourceType.WAREHOUSE);

        Destination[] destinations = new Destination[3];
        destinations[0] = new Destination(20, "Destinatie1");
        destinations[1] = new Destination(25, "Destinatie2");
        destinations[2] = new Destination(25, "Destinatie3");

        int[][] matrix = {
                {2, 3, 1},
                {5, 4, 8},
                {5, 6, 8}
        };

        Problem problem1=new Problem(3,sources,3,destinations,matrix);

        problem1.print();
    }
}
