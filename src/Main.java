import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String ans, name, dob;
        ArrayList<Ship> ships = new ArrayList<>();
        ArrayList<Ship> shipsInServ = new ArrayList<>();
        ArrayList<Cruise> cruises = new ArrayList<>();
        ArrayList<Passenger> passengers = new ArrayList<>();

        Scanner input = new Scanner(System.in);

        while (true){
            System.out.print("""
                            Luxury Vacation Cruise
                                System Menu
                                        
                    [1] Add Ship        [A] Print Ship Names
                    [2] Edit Ship       [B] Print Ship In Service List
                    [3] Add Cruise      [C] Print Ship Full List
                    [4] Edit Cruise     [D] Print Cruise List
                    [5] Add Passenger   [E] Print Cruise Details
                    [6] Edit Passenger  [F] Print Passenger List
                    [x] Exit System
                    
                    
                    Please enter a selection:\s""");

            ans = input.nextLine();

            if (ans.toLowerCase(Locale.ROOT).equals("x")) {
                System.out.println();
                break;
            }

            switch (ans){
                case "1" -> ships.add(createNewShip(input, shipsInServ));
                case "2" -> {
                    if (ships.isEmpty()) {
                        System.out.println("Error! There are currently no ships registered, please add a ship!");
                    } else {

                        int count = 1;
                        for (Ship ship : ships) {
                            System.out.println("#" + count + " " + ship);
                            count++;
                        }
                        System.out.print("Which ship would you like to edit?: ");
                        int selection = Integer.parseInt(input.nextLine()) - 1;

                        Ship selectedShip = ships.get(selection);

                        System.out.print("Update Ship Name? (Y/N):");
                        ans = input.nextLine();
                        if (ans.toLowerCase(Locale.ROOT).equals("y")) {
                            System.out.print("Please enter a ship name: ");
                            selectedShip.setShipName(input.nextLine());
                        }
                        System.out.print("Update in service status? (Y/N):");
                        ans = input.nextLine();
                        if (ans.toLowerCase(Locale.ROOT).equals("y")) {
                            System.out.print("Will this ship be in service immediately? (Y/N): ");
                            ans = input.nextLine();
                            if (ans.toLowerCase(Locale.ROOT).equals("y")) {
                                selectedShip.setInService(true);
                                if (!shipsInServ.contains(selectedShip)){
                                    shipsInServ.add(selectedShip);
                                }
                            } else {
                                selectedShip.setInService(false);
                                shipsInServ.remove(selectedShip);
                            }
                        }
                        System.out.print("Update passenger cabin space? (Y/N):");
                        ans = input.nextLine();
                        if (ans.toLowerCase(Locale.ROOT).equals("y")) {
                            System.out.print("Please enter the amount of passenger cabins available on this ship: ");
                            selectedShip.setAvailableCabin(input.nextInt());
                            input.nextLine();
                        }

                    }
                }
                case "3" -> cruises.add(createNewCruise(input, shipsInServ));
                case "4" -> {
                    if (cruises.isEmpty()) {
                        System.out.println("Error! There are currently no cruises registered, please add one!");
                    }
                    else {
                        int count = 1;
                        for (Cruise cruise : cruises) {
                            System.out.println("#" + count + " " + cruise);
                            count++;
                        }
                        System.out.print("Which cruise would you like to edit?: ");
                        int selection = Integer.parseInt(input.nextLine()) - 1;

                        Cruise selectedCruise = cruises.get(selection);

                        System.out.print("Update Cruise Name? (Y/N):");
                        ans = input.nextLine();
                        if (ans.toLowerCase(Locale.ROOT).equals("y")) {
                            System.out.print("Please enter a cruise name: ");
                            selectedCruise.setCruiseName(input.nextLine());
                        }
                        System.out.print("Reassign the cruise? (Y/N):");
                        ans = input.nextLine();
                        if (ans.toLowerCase(Locale.ROOT).equals("y")) {
                            if (shipsInServ.isEmpty()) {
                                System.out.println("Currently there are no ships in service, edit the cruise later to assign it to a ship.");
                            }
                            else {
                                for (Ship ship : ships) {
                                    ship.getCruises().remove(selectedCruise);
                                }
                                System.out.println("-------------------------------------");
                                System.out.println("Current Ships In Service");

                                // We want to display all of the ships currently in service
                                count = 1;
                                for (Ship ship : shipsInServ) {
                                    System.out.println("#" + count + " " + ship);
                                    count++;
                                }
                                System.out.println("-------------------------------------");

                                System.out.print("Please enter your selection: ");
                                selection = input.nextInt() - 1;
                                input.nextLine();

                                // Here we add the cruise to the ship by pulling the ships Cruise ArrayList and then adding the modified cruise to it.
                                ArrayList<Cruise> shipsCruises = shipsInServ.get(selection).getCruises();
                                shipsCruises.add(selectedCruise);

                            }
                        }
                    }
                }
                case "5" -> passengers.add(createNewPassenger(input, cruises, ships));
                case "6" -> {
                    if (passengers.isEmpty()) {
                        System.out.println("Error! There are currently no passengers registered, please add one!");
                    }
                    else {
                        int count = 1;
                        for (Passenger passenger : passengers) {
                            System.out.println("#" + count + " " + passenger);
                            count++;
                        }
                        System.out.print("Which passenger would you like to edit?: ");
                        int selection = Integer.parseInt(input.nextLine()) - 1;

                        passengers.remove(passengers.get(selection));

                        passengers.add(selection, createNewPassenger(input, cruises, ships));
                    }
                }
                case "A" -> {
                    if (ships.isEmpty()) {
                        System.out.println("No ships currently registered, please add a ship first.");
                        break;
                    }
                    for (Ship ship:ships) {
                        System.out.println(ship.getShipName());
                    }
                }
                case "B" -> {
                    if (ships.isEmpty()) {
                        System.out.println("No ships currently registered, please add a ship first.");
                        break;
                    }
                    System.out.println("-------------------------------------");
                    System.out.println("Ships Currently In Service");
                    for (Ship ship:shipsInServ) {
                        System.out.println(ship);
                    }
                    System.out.println("-------------------------------------");
                }
                case "C" -> {
                    if (ships.isEmpty()) {
                        System.out.println("No ships currently registered, please add a ship first.");
                        break;
                    }
                    for (Ship ship:ships) {
                        System.out.println(ship);
                    }
                }
                case "D" -> {
                    if (cruises.isEmpty()) {
                        System.out.println("No cruises are currently registered, please add a cruise first.");
                        break;
                    }
                    for (Cruise cruise:cruises) {
                        System.out.println(cruise.getCruiseName());
                    }
                }
                case "E" -> {
                    if (cruises.isEmpty()) {
                        System.out.println("No cruises are currently registered, please add a cruise first.");
                        break;
                    }
                    for (Cruise cruise:cruises) {
                        System.out.println(cruise);
                    }
                }
                case "F" -> {
                    if (passengers.isEmpty()) {
                        System.out.println("No passengers are currently registered, please add a passenger first.");
                        break;
                    }
                    for (Passenger passenger:passengers) {
                        System.out.println(passenger);
                    }
                }
            }



        }
    }

    public static Ship createNewShip(Scanner input, ArrayList<Ship> shipsInService) {
        String name;
        boolean inServ;
        int passengerLimit;
        System.out.print("Please enter a name for the ship: ");
        name = input.nextLine();
        System.out.print("Will this ship be in service immediately? (Y/N): ");
        inServ = input.nextLine().toLowerCase(Locale.ROOT).equals("y");
        System.out.print("Please enter the amount of passenger cabins available on this ship: ");
        passengerLimit = input.nextInt();
        input.nextLine();

        Ship newShip = new Ship(name, inServ, passengerLimit);

        if (inServ)
            shipsInService.add(newShip);

        return newShip;
    }

    public static Cruise createNewCruise(Scanner input, ArrayList<Ship> shipsInService) {
        String name;
        System.out.print("Please enter a name for the cruise: ");
        name = input.nextLine();

        Cruise newCruise = new Cruise(name);

        if (shipsInService.isEmpty()) {
            System.out.println("Currently there are no ships in service, edit the cruise later to assign it to a ship.");
        }
        else {
            System.out.println("-------------------------------------");
            System.out.println("Current Ships In Service");

            // We want to display all of the ships currently in service
            int count = 1;
            for (Ship ship : shipsInService) {
                System.out.println("#" + count + " " + ship);
                count++;
            }
            System.out.println("-------------------------------------");

            System.out.print("Please enter your selection: ");
            int selection = input.nextInt() - 1;
            input.nextLine();

            // Here we add the cruise to the ship by pulling the ships Cruise ArrayList and then adding the Cruise to it.
            ArrayList<Cruise> shipsCruises = shipsInService.get(selection).getCruises();
            shipsCruises.add(newCruise);

        }

        return newCruise;
    }

    public static Passenger createNewPassenger(Scanner input, ArrayList<Cruise> cruises, ArrayList<Ship> ships) {
        String name, dob;
        System.out.print("Please enter first and last name: ");
        name = input.nextLine();
        System.out.print("Please enter date of birth (MM/DD/YYY): ");
        dob = input.nextLine();

        Passenger newPassenger = new Passenger(name, dob);

        if (cruises.isEmpty()){
            System.out.println("There are currently no available cruises to add the passenger to.\n" +
                    "Please add a new cruise and then edit the passenger.");
        } else {
            outer:
            while (true) {
                System.out.println("-------------------------------------");
                System.out.println("Currently Available Cruises");

                // We want to display all of the cruises available
                int count = 1;
                for (Cruise cruise : cruises) {
                    System.out.println("#" + count + " " + cruise);
                    count++;
                }
                System.out.println("Enter 0 to continue without assigning a cruise.");
                System.out.println("-------------------------------------");

                System.out.print("Please enter your selection: ");
                int selection = input.nextInt();
                input.nextLine();
                if (selection == 0) {
                    break;
                }
                selection--;
                ArrayList<Passenger> cruisesPassengers = cruises.get(selection).getPassengers();

                // Here we add the passenger to the cruise by first checking if there's available room on the ship.
                for (Ship ship : ships) {
                    if (ship.getCruises().contains(cruises.get(selection))) {
                        if (ship.getCurrentCabin() < ship.getAvailableCabin()) {
                            cruisesPassengers.add(newPassenger);
                            ship.setCurrentCabin(ship.getCurrentCabin() + 1);   // Here we add passenger to the cabin count.
                            break outer;
                        } else {
                            System.out.println("Error: Currently there is no more available cabin space on this cruise.");
                        }
                    }
                }

            }


        }

        return newPassenger;
    }
}
