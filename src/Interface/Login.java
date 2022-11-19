package Interface;

import java.util.HashMap;
import java.util.Scanner;

public class Login {

    String userField;
    String passField;
    HashMap<String,String> loginInfo = new HashMap<String,String>();
    Scanner scan = new Scanner(System.in);

    Login(HashMap loginDetails){
        System.out.println("Are you a (G)uest, (S)taff, (C)hef");
        String inputLogin = scan.nextLine();
        switch(inputLogin){
            case("G"):
                GuestLogin();
                break;
            case("S"):
                LoginNow(loginInfo);
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
        loginInfo = LoginInfoOrg;

        System.out.println("Welcome to Cool Restaurant Management System! \nPlease input details \n");
        System.out.println("Enter Username: ");
        userField = scan.nextLine();
        System.out.println("Enter Password: ");
        passField = scan.nextLine();

        if(loginInfo.containsKey(userField)){
            if(loginInfo.get(userField).equals(passField)){
                System.out.println("Login success.");
            } else {
                System.out.println("Wrong credentials.");
            }

        }

    }

    void GuestLogin(){
        System.out.println("Welcome guest.");
    }
}
