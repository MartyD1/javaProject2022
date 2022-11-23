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
import static ReservationSystem.BookingsCSV.createBookingsCSV;
import static ReservationSystem.BookingsCSV.getBookingsForDay;
import static RestaurantSystem.TableCSV.createTableCSV;

public class Login {
    String userField;
    String passField;

    Owner owner = new Owner("Name");
    Menu menu = new Menu();

    Restaurant restaurant = new Restaurant("Yum Restaurant", owner, menu);
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

        } else {
            System.out.println("Incorrect Login");
            new Login();

        }


    }

    private void managementOptions() {
        System.out.println("(M)anage employees, (V)iew records, (T)ables ");
        String input = scan.nextLine().toUpperCase();
        switch (input) {
            case ("M"):
                System.out.println("Placeholer, Manage employees");
                break;
            case("V"):
                System.out.println("Placeholder, View records");
                break;
            case("T"):
                TableMenu();
                break;

        }
    }


    void restaurantMenu() {
        System.out.println("Would you like to (C)reate restaurants, (V)iew restaurants?");
        String input = scan.nextLine().toUpperCase();
        switch (input) {
            case ("C"):
                createRestaurant();
                break;
            case ("V"):
                viewRestaurants();
                break;
        }
    }

    public void TableMenu() {

        // Scanner object
        Scanner scan = new Scanner(System.in);

        boolean cont = true;

        while (cont) {


            System.out.println("(A)dd table, (R)emove table, (V)iew tables");
            String command = scan.nextLine();

            if (command.equals("A")) {
                System.out.println("Enter table number:");
                int num = scan.nextInt();
                System.out.println("Enter number of seats:");
                int seats = scan.nextInt();

                Table table = new Table(num, seats);
                createTableCSV(table);

            } else if (command.equals("R")) {


            } else if (command.equals("V")) {
                ArrayList<String> tables = readCSV("table.csv");

                for (int i = 0; i < tables.size(); i++) {
                    System.out.println(tables.get(i));

                }


            }

        }
    }

    /* WORK IN PROGRESS!!! */
    private void createRestaurant() {

    }

    private void viewRestaurants() {

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
            System.out.println("(R)eservations, (F)ood (Q)uit system");
            String command = scan.nextLine().toUpperCase();

            if (command.equals("R")) {
                completeBookingMenu();

            } else if (command.equals("F")) {

            } else if (command.equals("Q")) {
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


    public void showMenu() {
        ArrayList<String> menuItems = readCSV("menuRecord.csv");

        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println(menuItems.get(i));}
    }
}