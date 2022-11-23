package RestaurantSystem;

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
            String location = in.nextLine();

            System.out.println("Create employee database: ");

            System.out.println("Create table database: ");

            System.out.println("Enter owner details: ");

            System.out.println("Create new menu: ");
        }
    }
}
