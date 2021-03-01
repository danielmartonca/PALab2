package optional.locations;

public class Warehouse extends Source{

    public Warehouse(int supply,String name) {
        super(supply,name);
    }

    @Override
    public String getType() {
        return "WAREHOUSE";
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
