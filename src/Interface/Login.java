package Interface;

import Person.Customer;
import Person.Owner;
import ReservationSystem.Booking;
import ReservationSystem.BookingCalendar;
import ReservationSystem.BookingDate;
import ReservationSystem.BookingTime;
import RestaurantSystem.Menu;
import RestaurantSystem.Restaurant;
import RestaurantSystem.Table;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static CSV.GeneralCSV.clearCSV;
import static CSV.GeneralCSV.readCSV;
import static Person.PersonCSV.createPersonCSV;
import static Person.PersonCSV.getChosenStaff;
import static ReservationSystem.BookingsCSV.createBookingsCSV;
import static ReservationSystem.BookingsCSV.getBookingsForDay;
import static RestaurantSystem.MenuCSV.createMenuCSV;
import static RestaurantSystem.OrderCSV.createOrderCSV;
import static RestaurantSystem.OrderCSV.getFoodType;
import static RestaurantSystem.TableCSV.createTableCSV;

public class Login {
    String userField;
    String passField;

    Owner owner = new Owner("Name");


    Restaurant restaurant = new Restaurant("Yum Restaurant", owner);
    Scanner scan = new Scanner(System.in);

    Login() throws IOException {
        System.out.println("Enter Username: ");
        userField = scan.nextLine();
        System.out.println("Enter Password: ");
        passField = scan.nextLine();

        if (userField.equals("Guest") && passField.equals("Password")) {
            GuestLogin();
        } else if (userField.equals("Staff") && (passField.equals("Password"))) {
            staffMenu();
        } else if (userField.equals("Management") && (passField.equals("Password"))) {
            managementOptions();
        } else if(userField.equals("Owner") && (passField.equals("Password"))) {
            ownerOptions();
        } else {
            new Login();
        }


    }

    private void ownerOptions() throws IOException {
        boolean cont = true;
        while(cont){
            System.out.println("(B)ookings, (R)estaurant, (F)ood, (V)iew records, (Q)uit");
            String command = scan.nextLine();
            if(command.equals("B")){
                completeBookingMenu();

            } else if (command.equals("R")) {
                ownerRestaurantManagement();

            } else if (command.equals("F")) {
                completeMenu();

            } else if (command.equals("V")) {
                Records();

            } else if (command.equals("Q")) {
                cont = false;
            }
        }

    }

    private void Records() {
        readCSV("orderRecord.csv");

        boolean cond = true;


    }

    private void ownerRestaurantManagement() throws IOException {
        boolean cont = true;
        System.out.println("M)anagement options\nR)eturn");
        String command = scan.nextLine();

        while(cont){
            if(command.equals("M")){
                managementOptions();
            } else if (command.equals("R")) {
                cont = false;
            }

        }
    }

    private void managementOptions() throws IOException {
        boolean cont = true;

        while (cont) {
            System.out.println("(M)anage employees, (V)iew records, (O)rder, (Q)uit system");
            String command = scan.nextLine();

            if (command.equals("M")) {
                completeStaffMenu();
            } else if (command.equals("V")) {


            } else if (command.equals("T")) {
                tableMenu();

            } else if (command.equals("O")) {
                completeFoodMenu();

            } else if (command.equals("Q")) {
                cont = false;
            }
        }
    }
    

    private String getChoice(ArrayList<String> choices) {
        if (choices.size() == 0) return null;
        while (true) {
            char c = 'A';
            for (Object choice : choices) {
                System.out.println(c + ") " + choice);
                c++;
            }
            String input = scan.nextLine();
            int n = input.toUpperCase().charAt(0) - 'A';
            if (0 <= n && n < choices.size())
                return choices.get(n);
        }
    }


    private void chefOptions() {
        System.out.println("Chef options");
    }


    private void staffMenu() throws IOException {
        boolean cont = true;
        System.out.println("Welcome to the Staff Menu!\n" +
                "Please enter a command to continue.");

        while (cont) {
            System.out.println("(R)eservations, (O)rder, (Q)uit system");
            String command = scan.nextLine().toUpperCase();

            if (command.equals("R")) {
                completeBookingMenu();
            }
            else if (command.equals("O")) {
                completeFoodMenu();
            }
            else if (command.equals("Q")) {
                cont = false;
            }

        }
    }

    void GuestLogin() {
        boolean cont = true;
        System.out.println("Welcome to the Yum Restaurant Chain!\n" +
                "Please enter a command to continue.");

        while (cont) {
            System.out.println("(B)ook a reservation, (V)iew menu, (P)ay a bill, (Q)uit system");
            String command = scan.nextLine().toUpperCase();

            if (command.equals("B")) {
                addBooking();
                System.out.println();
            } else if (command.equals("V")) {
                showMenu();
                System.out.println();
            } else if (command.equals("P")) {
                System.out.println("WIP");
                System.out.println();
            } else if (command.equals("Q")) {
                cont = false;
            }
        }
    }

    public void completeBookingMenu() throws IOException {
        boolean cont = true;
        BookingCalendar calendar = new BookingCalendar();
        while (cont) {
            System.out.println("A)dd booking\nC)ancel booking\nS)how booking\nQ)uit system");
            String command = scan.nextLine().toUpperCase(); // if user inputs lowercase command, it will still be read

            if (command.equals("A")) { // add booking function follows
                addBooking();

            } else if (command.equals("C")) {
                cancelBooking();

            } else if (command.equals("S")) {
                showBooking();

            } else if (command.equals("Q")) {
                cont = false;
            }
        }
    }

    private void addBooking() {
        System.out.println("""
                Date of booking
                (yyyy-mm-dd)""");
        String dateString = scan.nextLine();
        BookingDate d = new BookingDate(dateString);

        System.out.println("""
                Time of booking
                (hh:mm)""");
        String timeString = scan.nextLine();
        BookingTime t = new BookingTime(timeString);

        System.out.println("Customer: ");
        Customer customer = new Customer(scan.nextLine(), scan.nextLine());

        System.out.println("Number of guests: ");
        String numberOfGuests = scan.nextLine();

        System.out.println("Special comments: ");
        String comments = scan.nextLine();

        System.out.println();

        Booking booking = new Booking(d, t, customer, numberOfGuests, comments);
        System.out.println("New booking added: ");
        System.out.println(booking);

        createBookingsCSV(booking); // added booking to CSV file
    }

    private void cancelBooking() throws IOException {
        System.out.println("\nEnter booking details to cancel: ");
        System.out.println("""
                Enter date:
                (yyyy-mm-dd)""");
        String dateLine = scan.nextLine();

        ArrayList<String> allBookings = readCSV("bookingsRecord.csv");
        ArrayList<String> choices = getBookingsForDay(dateLine);

        String cancelBooking = getChoice(choices);
        if (cancelBooking != null) {
            allBookings.remove(cancelBooking);
        }

        clearCSV("bookingsRecord.csv");

        for (int i = 0; i < allBookings.size(); i++) {
            Booking tempBooking = new Booking(allBookings.get(i));
            createBookingsCSV(tempBooking);
        }
    }

    private void showBooking() {
        System.out.println("""
                Display what date:
                (yyyy-mm-dd)""");
        String showDate = scan.nextLine();
        ArrayList<String> bookingsForDay = getBookingsForDay(showDate);

        for (int i = 0; i < bookingsForDay.size(); i++) {
            System.out.println(bookingsForDay.get(i));
        }
    }

    
    
    
    
    private void completeStaffMenu() throws IOException {
        boolean cont = true;

        while (cont) {
            System.out.println("A)dd a staff member\nR)emove a staff member\nS)how staff members\nQ)uit system");
            String command = scan.nextLine().toUpperCase();

            if (command.equals("A")) {
                addStaff();
            }
            else if (command.equals("R")) {
                removeStaff();
            }
            else if (command.equals("S")) {
                showStaff();
            }
            else if (command.equals("Q")) {
                cont = false;
            }
        }
    }

    private void addStaff() {
        System.out.println("Enter name: ");
        String name = scan.nextLine();

        System.out.println("Enter role: ");
        String role = scan.nextLine();

        System.out.println("Enter login details: ");
        String login = scan.nextLine();

        System.out.println("Enter password");
        String password = scan.nextLine();

        System.out.println();

        Staff staff = new Staff(name, role, login, password);
        createPersonCSV(staff);
    }

    private void removeStaff() throws IOException{
        System.out.println("\nEnter staff name to remove: ");
        String name = scan.nextLine();

        ArrayList<String> allStaff = readCSV("peopleRecord.csv");
        ArrayList<String> choices = getChosenStaff(name);

        String removeStaff = getChoice(choices);
        if (removeStaff != null) {
            allStaff.remove(removeStaff);
        }

        clearCSV("peopleRecord.csv");

        for (int i = 0; i < allStaff.size(); i++) {
            Staff tempStaff = new Staff(allStaff.get(i));
            createPersonCSV(tempStaff);
        }
    }

    private void showStaff() {
        boolean cont = true;
        while (cont) {

            System.out.println("Show\nS)erver\nM)anager\nC)hef");
            String command = scan.nextLine().toUpperCase();
            if (command.equals("S")) {
                ArrayList<String> chosenStaff = getChosenStaff("Server");
                for (int i = 0; i < chosenStaff.size(); i++)
                    System.out.println(chosenStaff.get(i));
            } else if (command.equals("M")) {
                ArrayList<String> chosenStaff = getChosenStaff("Manager");
                for (int i = 0; i < chosenStaff.size(); i++)
                    System.out.println(chosenStaff.get(i));
            } else if (command.equals("C")) {
                ArrayList<String> chosenStaff = getChosenStaff("Chef");
                for (int i = 0; i < chosenStaff.size(); i++)
                    System.out.println(chosenStaff.get(i));

                cont=false;
            }
        }
    }

    public void completeMenu() throws IOException {
        boolean cont = true;
        Menu menu = new Menu();
        while (cont) {
            System.out.println("A)dd menu item\nR)emove menu time\nS)how menu\nQ)uit system");
            String command = scan.nextLine().toUpperCase();

            if (command.equals("A")) {
                System.out.println("Enter type (S/M/D): ");
                String type = scan.nextLine();

                System.out.println("Enter food name: ");
                String name = scan.nextLine();

                System.out.println("Enter description: ");
                String description = scan.nextLine();

                System.out.println("Enter price: ");
                double price = Double.parseDouble(scan.nextLine());

                System.out.println();

                FoodItem newItem = new FoodItem(type.charAt(0), name, description, price);

                createMenuCSV(newItem);
                menu.addToMenu(newItem);

            }
            else if (command.equals("R")) {
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


            }
            else if (command.equals("S")) {
                ArrayList<String> menuItems = readCSV("menuRecord.csv");

                for (int i = 0; i < menuItems.size(); i++) {
                    System.out.println(menuItems.get(i));
                }


            }
            else if (command.equals("Q")) {
                cont = false;
            }
        }
    }


    public void showMenu() {
        ArrayList<String> menuItems = readCSV("menuRecord.csv");

        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println(menuItems.get(i));}
    }
}