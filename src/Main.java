import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String ans, name, dob;
        ArrayList<Ship> ships = new ArrayList<>();
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
                case "1" -> {
                    ships.add(createNewShip(input));
                }
                case "2" -> {
                    int count = 0;
                    for (Ship ship:ships) {
                        System.out.println("#" + count + "" + ship);
                        count++;
                    }
                    System.out.print("Which ship would you like to edit?: ");
                    int edit = Integer.parseInt(input.nextLine());

                    ships.remove(edit);

                    ships.add(edit, createNewShip(input));
                }
                case "3" -> {

                }
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
                    for (Ship ship:ships) {
                        if (ship.inService)
                            System.out.println(ship.getShipName());
                    }
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

    public static Ship createNewShip(Scanner input) {
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

        return new Ship(name, inServ, passengerLimit);
    }
}
