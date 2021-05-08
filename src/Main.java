import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String ans, name, dob;
        ArrayList<Ship> ships = new ArrayList<>();
        ArrayList<Ship> shipsInServ = new ArrayList<>();
        ArrayList<Cruise> cruises = new ArrayList<>();

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
                    int count = 0;
                    for (Ship ship:ships) {
                        System.out.println("#" + count + " " + ship);
                        count++;
                    }
                    System.out.print("Which ship would you like to edit?: ");
                    int selection = Integer.parseInt(input.nextLine());

                    shipsInServ.remove(ships.get(selection));

                    ships.remove(selection);


                    ships.add(selection, createNewShip(input, shipsInServ));
                }
                case "3" -> cruises.add(createNewCruise(input, shipsInServ));
                case "4" -> {

                }
                case "5" -> {

                }
                case "6" -> {

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

                }
                case "E" -> {

                }
                case "F" -> {

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

        System.out.println("Please assign this cruise to a ship");
        System.out.println("-------------------------------------");
        System.out.println("Current Ships In Service");

        int count = 0;
        for (Ship ship:shipsInService) {
            System.out.println("#" + count + " " + ship);
            count++;
        }
        System.out.println("-------------------------------------");

        System.out.println("Please enter your selection: ");
        int selection = input.nextInt();
        input.nextLine();

        ArrayList<Cruise> shipsCruises = shipsInService.get(selection).getCruises();
        shipsCruises.add(newCruise);

        return newCruise;
    }
}
