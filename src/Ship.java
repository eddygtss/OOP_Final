import java.util.ArrayList;

public class Ship {
    String name;
    Boolean inService;
    ArrayList<Passenger> passengers;

    public Ship(String name, Boolean inService, ArrayList<Passenger> passengers) {
        this.name = name;
        this.inService = inService;
        this.passengers = passengers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getInService() {
        return inService;
    }

    public void setInService(Boolean inService) {
        this.inService = inService;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(ArrayList<Passenger> passengers) {
        this.passengers = passengers;
    }

    @Override
    public String toString() {
        return "Ship " +
                "name: " + name +
                ", in service: " + inService;
    }
}
