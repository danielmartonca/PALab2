package compulsory.problem;

import compulsory.destination.Destination;
import compulsory.source.Source;

import java.util.Arrays;

public class Problem {
    private final int nrSources;
    private Source[] sources;
    private final int nrDestinations;
    private Destination[] destinations;
    private final int[][] matrix;

    public Problem(int nrSources, Source[] sources, int nrDestinations, Destination[] destinations, int[][] matrix) {
        this.nrSources = nrSources;
        this.sources = new Source[nrSources];
        System.arraycopy(sources, 0, this.sources, 0, nrSources);

        this.nrDestinations = nrDestinations;
        this.destinations = new Destination[nrDestinations];
        System.arraycopy(destinations, 0, this.destinations, 0, nrDestinations);

        this.matrix = new int[nrSources][nrDestinations];
        for (int i = 0; i < nrSources; i++)
            System.arraycopy(matrix[i], 0, this.matrix[i], 0, nrDestinations);
    }

    public int getNrSources() {
        return nrSources;
    }

    public Source getSource(int i) {
        return sources[i];
    }

    public void setSources(Source[] sources) {
        this.sources = sources;
    }

    public int getNrDestinations() {
        return nrDestinations;
    }

    public Destination getDestination(int i) {
        return destinations[i];
    }

    public void setDestinations(Destination[] destinations) {
        this.destinations = destinations;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void print()
    {
        System.out.print("        ");
        for(int i=0;i<nrDestinations;i++)
            System.out.print(destinations[i].getName()+"   ");

        System.out.println("    Supply");

        for(int i=0;i<nrSources;i++)
        {
            System.out.print(sources[i].getName()+"     ");

            for(int j=0;j<nrDestinations;j++)
                System.out.print(matrix[i][j]+"              ");

            System.out.println(sources[i].getSupply());
        }

        System.out.print("Demand     ");
        for(int i=0;i<nrDestinations;i++)
            System.out.print(destinations[i].getDemand()+"             ");
    }

}
