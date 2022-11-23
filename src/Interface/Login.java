package Interface;

import Person.Owner;
import ReservationSystem.Booking;
import ReservationSystem.BookingDate;
import ReservationSystem.BookingTime;
import RestaurantSystem.Menu;
import RestaurantSystem.Restaurant;

import java.util.ArrayList;
import java.util.Scanner;

import static CSV.GeneralCSV.readCSV;
import static ReservationSystem.BookingsCSV.createBookingsCSV;

public class Login {
    private Scanner in;
    String userField;
    String passField;

    Owner owner = new Owner("Name", "Owner");
    Menu menu = new Menu();

    Restaurant restaurant = new Restaurant("Yum Restaurant", owner, menu);
    Scanner scan = new Scanner(System.in);

    Login(){
        System.out.println("Enter Username: ");
        userField = scan.nextLine();
        System.out.println("Enter Password: ");
        passField = scan.nextLine();

        if(userField.equals("Guest") && passField.equals("Password")){
            GuestLogin();

        } else if (userField.equals("Staff") && (passField.equals("Password"))) {
            staffMenu();

        } else if (userField.equals("Management") && (passField.equals("Password"))) {
            managementOptions();

        }else {
            System.out.println("Incorrect Login");
            new Login();

        }


    }

    private void managementOptions() {
        System.out.println("(M)anage employees, (V)iew records");
        String input = scan.nextLine().toUpperCase();
        switch(input){
            case("M"):

        }
    }


    void restaurantMenu(){
        System.out.println("Would you like to (C)reate restaurants, (V)iew restaurants?");
        String input = scan.nextLine().toUpperCase();
        switch(input){
            case("C"):
                createRestaurant();
                break;
            case("V"):
                viewRestaurants();
                break;
        }
    }

    /* WORK IN PROGRESS!!! */
    private void createRestaurant() {

    }

    private void viewRestaurants() {

    }

    private Object getChoice(Object[] choices) {
        if (choices.length == 0) return null;
        while (true) {
            char c = 'A';
            for (Object choice : choices) {
                System.out.println(c + ") " + choice);
                c++;
            }
            String input = scan.nextLine();
            int n = input.toUpperCase().charAt(0) - 'A';
            if (0 <= n && n < choices.length)
                return choices[n];
        }
    }



    private void chefOptions() {
        System.out.println("Chef options");
    }


    private void staffMenu() {
        System.out.println("(M)anagement, (R)eservations, (F)ood");
        String staffMenu = scan.nextLine().toUpperCase();
        switch(staffMenu){
            case("M"):
                System.out.println("Work in progress");
                break;
            case("R"):
                System.out.println("Work in progress");
                break;
            case("F"):
                System.out.println("Work in progress");
                break;
        }
    }

    void GuestLogin(){
        System.out.println("Welcome Guest.");
        System.out.println("(B)ook a reservation, (V)iew menu, (P)ay a bill");
        String guestIn = scan.nextLine().toUpperCase();
        switch(guestIn){
            case("B"):
                addBooking();
                break;
            case("V"):
                showMenu();
                break;
            case("P"):
                System.out.println("wip");
                break;
        }
    }

    private void addBooking() {
        in = new Scanner(System.in);

        System.out.println("""
                           Date of booking
                           (yyyy-mm-dd)""");
        String dateString = in.nextLine();
        BookingDate d = new BookingDate(dateString);

        System.out.println("""
                           Time of booking
                           (hh:mm)""");
        String timeString = in.nextLine();
        BookingTime t = new BookingTime(timeString);

        System.out.println("Name of booking: "); // name could be changed to use getName() method of Customer object down the line
        String nameString = in.nextLine();

        System.out.println("Number of guests: ");
        String numberOfGuests = in.nextLine();

        System.out.println("Phone number: ");
        String phoneNumber = in.nextLine();

        System.out.println("Special comments: ");
        String comments = in.nextLine();

        System.out.println();

        Booking booking = new Booking(d, t, nameString, numberOfGuests, phoneNumber, comments);
        createBookingsCSV(booking); // added booking to CSV file
    }

    private void showMenu() {
        ArrayList<String> menuItems = readCSV("menuRecord.csv");

        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println(menuItems.get(i));
        }
    }
}
