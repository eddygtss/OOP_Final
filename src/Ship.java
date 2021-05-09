import java.util.ArrayList;

public class Ship {
    private String shipName;
    private Boolean inService;
    private int availableCabin, currentCabin = 0;
    private ArrayList<Cruise> cruises = new ArrayList<>();

    public Ship(String shipName, Boolean inService, int availableCabin) {
        this.shipName = shipName;
        this.inService = inService;
        this.availableCabin = availableCabin;
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

    public int getAvailableCabin() {
        return availableCabin;
    }

    public void setAvailableCabin(int availableCabin) {
        this.availableCabin = availableCabin;
    }

    public int getCurrentCabin() {
        return currentCabin;
    }

    public void setCurrentCabin(int currentCabin) {
        this.currentCabin = currentCabin;
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
                ", Available Cabin: " + (availableCabin - currentCabin) +
                ", Cruises: " + cruises;
    }
}
