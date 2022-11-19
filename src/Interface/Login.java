package Interface;

import java.util.HashMap;
import java.util.Scanner;

public class Login {

    String userField;
    String passField;
    HashMap<String,String> LoginDetails = new HashMap<String,String>();
    Scanner scan = new Scanner(System.in);

    Login(HashMap loginDetails){
        System.out.println("Are you a (G)uest, (S)taff, (C)hef");
        String inputLogin = scan.nextLine().toUpperCase();
        switch(inputLogin){
            case("G"):
                GuestLogin();
                break;
            case("S"):
                LoginNow(LoginDetails);
                break;
            case("C"):
                chefOptions();
        }


    }


    private void chefOptions() {
        System.out.println("Chef options");
    }


    void LoginNow(HashMap<String, String> LoginInfoOrg) {
        // making a copy of hashmap, globally available
        LoginDetails = LoginInfoOrg;

        System.out.println("Welcome to Cool Restaurant Management System! \nPlease input details \n");
        System.out.println("Enter Username: ");
        userField = scan.nextLine().toUpperCase();
        System.out.println("Enter Password: ");
        passField = scan.nextLine().toUpperCase();

        if(userField.equals("Marty") & passField.equals("Password")){
            System.out.println("Login Success");
            System.out.println("Proceed? (Y) / (N)");
            String descision = scan.nextLine().toUpperCase();
            switch (descision) {
                case ("Y") -> staffMenu();
                case ("N") -> LoginNow(LoginDetails);
            }
        } else {
            System.out.println("Incorrect Login");
        }


    }

    private void staffMenu() {
        System.out.println("Options A B C");
    }

    void GuestLogin(){

        System.out.println("Welcome Guest. Options A B C");
    }
}
