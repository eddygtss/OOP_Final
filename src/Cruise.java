import java.util.ArrayList;

public class Cruise {
    String cruiseName;
    ArrayList<Passenger> passengers;

    public Cruise(String cruiseName, ArrayList<Passenger> passengers) {
        this.cruiseName = cruiseName;
        this.passengers = passengers;
    }

    public String getCruiseName() {
        return cruiseName;
    }

    public void setCruiseName(String cruiseName) {
        this.cruiseName = cruiseName;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(ArrayList<Passenger> passengers) {
        this.passengers = passengers;
    }

    @Override
    public String toString() {
        return "Cruise{" +
                "cruiseName='" + cruiseName + '\'' +
                ", passengers=" + passengers +
                '}';
    }
}
