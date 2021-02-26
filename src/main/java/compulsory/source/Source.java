package compulsory.source;

import compulsory.SourceType;

public class Source {
    private int supply;
    private final String name;
    private SourceType type;

    public Source(int supply, String name, SourceType type) {
        this.supply = supply;
        this.name = name;
        this.type = type;
    }

    public int getSupply() {
        return supply;
    }

    public void setSupply(int supply) {
        this.supply = supply;
    }

    public String getName() {
        return name;
    }

    public SourceType getType() {
        return type;
    }

    public void setType(SourceType type) {
        this.type = type;
    }
}
