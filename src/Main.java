import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String ans, name, dob;
        boolean inServ;
        ArrayList<Passenger> passengers = new ArrayList<>();
        ArrayList<Ship> ships = new ArrayList<>();
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
                case "1" -> {
                    System.out.print("Please enter a name for the ship: ");
                    name = input.nextLine();
                    System.out.print("Will this ship be in service immediately? (Y/N): ");
                    inServ = input.nextLine().toLowerCase(Locale.ROOT).equals("y");

                    Ship ship = new Ship(name, inServ, passengers);

                    ships.add(ship);
                }
                case "2" -> {
                    int count = 0;
                    for (Ship ship:ships) {
                        System.out.println("#" + count + " :" + ship);
                    }
                    System.out.println("Which ship would you like to edit?: ");
                    ans = input.nextLine();



                }
            }



        }
    }
}
