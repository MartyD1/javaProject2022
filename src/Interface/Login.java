package Interface;

import FinanceHistory.DetailsBooking;
import FinanceHistory.SetFinanceRecords;
import Person.Customer;
import Person.Owner;
import Person.Staff;
import ReservationSystem.Booking;
import ReservationSystem.BookingCalendar;
import ReservationSystem.BookingDate;
import ReservationSystem.BookingTime;
import RestaurantSystem.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
            guestLogin();
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

    void guestLogin() {
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
                pay();
                System.out.println();
            } else if (command.equals("Q")) {
                cont = false;
            }
        }
    }

    private void pay() {
        boolean cont = true;

        while (cont) {
            System.out.println("Enter name to pay: ");
            String name = scan.nextLine();

            ArrayList<String> orderRecord = readCSV("FinanceRecord.csv");
            for (int i = 0; i < orderRecord.size(); i++) {
                DetailsBooking details = new DetailsBooking(orderRecord.get(i));

                if (name.equals((details.getName().trim()))) {
                    System.out.println(details);
                }
            }

            System.out.println("Agree to pay?");
            System.out.println("(Y)/(N)");
            String agreement = scan.nextLine();
            cont = false;
        }
    }

    
    


    public void  completeFoodMenu() throws IOException {
        boolean cont = true;

        while (cont) {
            System.out.println("A)dd an order\nC)ancel order\nQ)uit");
            String command = scan.nextLine().toUpperCase();

            if (command.equals("A"))
            {
                addOrder();
            }
            else if (command.equals("C"))
            {
                cancelOrder();
            }
            else if (command.equals("Q"))
            {
                cont = false;
            }
        }
    }

    private void addOrder() {
        ArrayList<String> starterArray = getFoodType("S");
        ArrayList<String> mainArray = getFoodType("M");
        ArrayList<String> dessertArray = getFoodType("D");
        ArrayList<String> beverageArray = getFoodType("B");

        System.out.println("Enter customers name: ");
        String name = scan.nextLine();
        System.out.println("Enter how many people: ");
        String numString = scan.nextLine();
        int numPeople = Integer.parseInt(numString);


        double finalBill = 0;
        for (int i = 0; i < numPeople; i++) {
            String starterChoice = getChoice(starterArray);
            FoodItem starter = new FoodItem(starterChoice);

            double price = starter.getPrice();
            finalBill += price;
        }
        for (int i = 0; i < numPeople; i++) {
            String mainChoice = getChoice(mainArray);
            FoodItem main = new FoodItem(mainChoice);

            double price = main.getPrice();
            finalBill += price;
        }
        for (int i = 0; i < numPeople; i++) {
            String dessertChoice = getChoice(dessertArray);
            FoodItem dessert = new FoodItem(dessertChoice);

            double price = dessert.getPrice();
            finalBill += price;
        }
        for (int i = 0; i < numPeople; i++) {
            String beverageChoice = getChoice(beverageArray);
            FoodItem beverage = new FoodItem(beverageChoice);

            double price = beverage.getPrice();
            finalBill += price;
        }
        System.out.println(finalBill);
        Order addOrder = new Order(name, finalBill);
        createOrderCSV(addOrder);
    }

    private void cancelOrder() throws IOException {
        System.out.println("Select order to remove: ");
        ArrayList<String> allOrders = readCSV("orderRecord.csv");

        String removeOrder = getChoice(allOrders);
        if (removeOrder != null) {
            allOrders.remove(removeOrder);
        }
        clearCSV("orderRecord.csv");

        for (int i = 0; i < allOrders.size(); i++) {
            Order tempOrder = new Order(allOrders.get(i));
            createOrderCSV(tempOrder);
        }
    }




    public void tableMenu() throws IOException {
        boolean cont = true;
        while (cont) {
            System.out.println("A)dd table\nR)emove table\nV)iew tables\nR)eturn");
            String command = scan.nextLine().toUpperCase();

            if (command.equals("A")) {
                addTable();

            } else if (command.equals("R")) {
                removeTable();

            } else if (command.equals("V")) {
                viewTables();

            } else if (command.equals("Q")) {
                cont = false;
            }
        }
    }
    
    private void addTable() {
        System.out.println("Enter table number:");
        String num = scan.nextLine();

        System.out.println("Enter number of seats:");
        String seats = scan.nextLine();

        Table table = new Table(num, seats);
        createTableCSV(table);
    }

    private void removeTable() throws IOException { // marty
        System.out.println("Select table to remove: ");
        ArrayList<String> allTables = readCSV("table.csv");

        String removeTable = getChoice(allTables);
        if (removeTable != null) {
            allTables.remove(removeTable);
        }
        clearCSV("table.csv");

        for (int x = 0; x < allTables.size(); x++) {
            Table tempTable = new Table(allTables.get(x));
            createTableCSV(tempTable);

        }
    }
    
    private void viewTables() {
        ArrayList<String> tables = readCSV("table.csv");

        for (int i = 0; i < tables.size(); i++) {
            System.out.println(tables.get(i));
        }
    }

    
    
    
    
    public void completeBookingMenu() throws IOException {
        boolean cont = true;
        BookingCalendar calendar = new BookingCalendar();
        while (cont) {
            System.out.println("A)dd booking\nC)ancel booking\nS)how booking\nR)eturn");
            String command = scan.nextLine().toUpperCase(); // if user inputs lowercase command, it will still be read

            if (command.equals("A")) { // add booking function follows
                addBooking();

            } else if (command.equals("C")) {
                cancelBooking();

            } else if (command.equals("S")) {
                showBooking();

            } else if (command.equals("R")) {
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

        System.out.println("Name: ");
        String nameString = scan.nextLine();

        System.out.println("Phone number: ");
        String phoneString = scan.nextLine();
        Customer customer = new Customer(nameString, phoneString);

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
            System.out.println(menuItems.get(i));
        }
    }

    public void start() {

        boolean view = true;

        while (view) {
            System.out.println("V)iew Records\nE)xit");
            String action = scan.nextLine().toUpperCase();

            if (action.equals("V")) {
                System.out.println("Enter Dates (from to) (yyyy-mm-dd) :");
                String breakUp = scan.nextLine();
                String[] dates = breakUp.split(" ");
                String from = dates[0];
                String to = dates[1];

                int[] dateArrayFrom=getIntDate(from); //getIntDate()- method to return int array of date from string of date .

                 int numOfPeople=1;

                if(from.equals(to)){
                    double madeOnDay =billOnDay(dateArrayFrom[0], dateArrayFrom[1], dateArrayFrom[2]);

                    System.out.println("Gross Profit $"+madeOnDay);
                    System.out.println("Date, time, Name, phoneNumber, FinalBill");
                    printDate(dateArrayFrom[0], dateArrayFrom[1], dateArrayFrom[2]);
                }
                else {
                    String[] numsFrom=from.split("-"); //split up from date into numsFrom[] dd mm yyyy
                    String[] numsTo=to.split("-");


                    int fDay=Integer.parseInt( numsFrom[2] ); // from this day
                    int tDay=Integer.parseInt( numsTo[2] ); //to this day
                    int fMonth=Integer.parseInt( numsFrom[1] );
                    int tMonth=Integer.parseInt( numsTo[1] );
                    int fYear=Integer.parseInt( numsFrom[0] );
                    int tYear=Integer.parseInt( numsTo[0] );

                    LocalDate fDate;fDate= LocalDate.of(fYear, fMonth, fDay);
                    LocalDate tDate=LocalDate.of(tYear, tMonth, tDay);

                    ArrayList<LocalDate> inbetweenDates=new ArrayList<>();
                    while(!(fDate.equals(tDate))){                          //try .equals()
                        inbetweenDates.add(fDate);
                        fDate=fDate.plusDays(1);
                    }
                    inbetweenDates.add(tDate);

                    String localDateString;
                    String[] splitUp;
                    DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd MM yyyy");

                    double madeOverDays=0;
                    for (LocalDate inbetweenDate : inbetweenDates) {
                        localDateString = inbetweenDate.format(formatter);
                        splitUp = localDateString.split(" ");
                        madeOverDays += billOnDay(
                                Integer.parseInt(splitUp[2]),
                                Integer.parseInt(splitUp[1]),
                                Integer.parseInt(splitUp[0]));
                    }
                    System.out.println("Gross Profit $"+madeOverDays);
                    System.out.println("Date, time, Name, phoneNumber, FinalBill");


                    for (LocalDate inbetweenDate : inbetweenDates) {
                        localDateString = inbetweenDate.format(formatter);
                        //System.out.println("localDateString: "+localDateString);
                        splitUp = localDateString.split(" ");
                        printDate(
                                Integer.parseInt(splitUp[2]),
                                Integer.parseInt(splitUp[1]),
                                Integer.parseInt(splitUp[0]));

                    }

                }
            }
            else
                view = false;
        }


    }


}