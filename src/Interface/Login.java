package Interface;

import java.util.HashMap;
import java.util.Scanner;

public class Login {

    String userField;
    String passField;
    HashMap<String,String> loginInfo = new HashMap<String,String>();
    Scanner scan = new Scanner(System.in);
    Login(HashMap<String, String> LoginInfoOrg) {
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
}
