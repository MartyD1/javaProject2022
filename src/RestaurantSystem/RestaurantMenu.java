package RestaurantSystem;

import Person.Owner;
import static RestaurantSystem.RestaurantCSV.createRestaurantCSV;

import java.io.IOException;
import java.util.Scanner;

public class RestaurantMenu {
    private Scanner in;

    public RestaurantMenu() {
        in = new Scanner(System.in);
    }


    public void run() throws IOException {
        boolean cont = true;
        System.out.println("A)dd new restaurant\nR)emove restaurant\nS)how restaurant chain");
        String command = in.nextLine().toUpperCase();

        if (command.equals("A")) {
            System.out.println("Enter new restaurant location: ");
            String loc= in.nextLine();

            System.out.println("Enter owner details: ");
            Owner owner=new Owner(in.nextLine());

            Restaurant restaurant=new Restaurant(loc,owner);

            createRestaurantCSV(restaurant);


        }
    }
}
