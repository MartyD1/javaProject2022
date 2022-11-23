package Interface;

import java.util.HashMap;
import java.util.Scanner;

public class Login {

    String userField;
    String passField;
    Scanner scan = new Scanner(System.in);

    Login(){

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

    private void optionMenu(){
        System.out.println("Are you a (G)uest, (S)taff, (C)hef");
        String inputLogin = scan.nextLine().toUpperCase();
        switch(inputLogin){
            case("G"):
                GuestLogin();
                break;
            case("S"):
                LoginNow();
                break;
            case("C"):
                chefOptions();
        }

    }


    private void chefOptions() {
        System.out.println("Chef options");
    }


    void LoginNow() {
        // making a copy of hashmap, globally available

        System.out.println("Welcome to Cool Restaurant Management System! \nPlease input details \n");
        System.out.println("Enter Username: ");
        userField = scan.nextLine();
        System.out.println("Enter Password: ");
        passField = scan.nextLine();

        if(userField.equals("Marty") & passField.equals("Password")){
            System.out.println("Login Success");
            System.out.println("Proceed? (Y) / (N)");
            String d = scan.nextLine().toUpperCase();
            switch (d) {
                case ("Y") -> staffMenu();
                case ("N") -> new Login(); // Method call to original input
            }
        } else {
            System.out.println("Incorrect Login, Return? (Y)");
            if(scan.nextLine().equals("Y")){
                new Login();
            }

        }


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
                System.out.println("Enter date in format DD/MM/YY");
                System.out.println("Work in progress");
                break;
            case("V"):
                System.out.println("work in progress");
                break;
            case("P"):
                System.out.println("wip");
                break;
        }
    }
}
