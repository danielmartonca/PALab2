package optional.locations;

public class Factory extends Source {

    public Factory(int supply, String name) {
        super(supply, name);
    }

    @Override
    public String getType() {
        return "FACTORY";
    }

    @Override
    public String toString() {
        return "Source{" +
                "supply=" + getSupply() +
                ", name='" + getName() + '\'' +
                ", type=" + getType() +
                '}';
    }
}
