import java.util.ArrayList;

public class Ship {
    private String shipName;
    private Boolean inService;
    private int passengerCabin;
    private ArrayList<Cruise> cruises = new ArrayList<>();

    public Ship(String shipName, Boolean inService, int passengerCabin) {
        this.shipName = shipName;
        this.inService = inService;
        this.passengerCabin = passengerCabin;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public Boolean getInService() {
        return inService;
    }

    public void setInService(Boolean inService) {
        this.inService = inService;
    }

    public int getPassengerCabin() {
        return passengerCabin;
    }

    public void setPassengerCabin(int passengerCabin) {
        this.passengerCabin = passengerCabin;
    }

    public ArrayList<Cruise> getCruises() {
        return cruises;
    }

    public void setCruises(ArrayList<Cruise> cruises) {
        this.cruises = cruises;
    }

    @Override
    public String toString() {
        return "Ship name: " + shipName +
                ", in service: " + inService +
                ", Available Cabin: " + passengerCabin +
                ", Cruises: " + cruises;
    }
}
