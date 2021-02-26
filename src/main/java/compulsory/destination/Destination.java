package compulsory.destination;

import compulsory.SourceType;

public class Destination {
    private int demand;
    private final String name;

    public Destination(int demand, String name) {
        this.demand = demand;
        this.name = name;
    }

    public int getDemand() {
        return demand;
    }

    public void setDemand(int demand) {
        this.demand = demand;
    }

    public String getName() {
        return name;
    }

}
