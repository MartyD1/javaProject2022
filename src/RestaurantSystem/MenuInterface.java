package RestaurantSystem;

import RestaurantSystem.FoodItem;
import RestaurantSystem.Menu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static CSV.GeneralCSV.clearCSV;
import static CSV.GeneralCSV.readCSV;
import static RestaurantSystem.MenuCSV.createMenuCSV;

public class MenuInterface {

    private Scanner in;

    public MenuInterface() {
        in = new Scanner(System.in);
    }

    public void run() throws IOException {
        boolean cont = true;
        Menu menu = new Menu();
        while (cont) {
            System.out.println("A)dd menu item\nR)emove menu time\nS)how menu\nQ)uit system");
            String command = in.nextLine().toUpperCase();

            if (command.equals("A")) {
                System.out.println("Enter type (S/M/D): ");
                String type = in.nextLine();

                System.out.println("Enter food name: ");
                String name = in.nextLine();

                System.out.println("Enter description: ");
                String description = in.nextLine();

                System.out.println("Enter price: ");
                double price = in.nextDouble();

                System.out.println();

                FoodItem newItem = new FoodItem(type.charAt(0), name, description, price);

                createMenuCSV(newItem);
                menu.addToMenu(newItem);


            } else if (command.equals("R")) {
                System.out.println("List of menu items");
                ArrayList<String> menuItems = readCSV("menuRecord.csv");

                String cancelItem = getChoice(menuItems);
                if (cancelItem != null) {
                    menuItems.remove(cancelItem);
                }

                clearCSV("menuRecord.csv");

                for (int i = 0; i < menuItems.size(); i++) {
                    FoodItem tempItem = new FoodItem(menuItems.get(i));
                    createMenuCSV(tempItem);
                }


            } else if (command.equals("S")) {
                ArrayList<String> menuItems = readCSV("menuRecord.csv");
                for (int i = 0; i < menuItems.size(); i++) {
                    System.out.println(menuItems.get(i));
                }


            } else if (command.equals("Q")) {
                cont = false;
            }
        }
    }

    private String getChoice(ArrayList<String> choices) {
        if (choices.size() == 0) return null;
        while (true) {
            char c = 'A';
            for (String choice : choices) {
                System.out.println(c + ") " + choice);
                c++;
            }
            String input = in.nextLine();
            int n = input.toUpperCase().charAt(0) - 'A';
            if (0 <= n && n < choices.size())
                return choices.get(n);
        }
    }
}
