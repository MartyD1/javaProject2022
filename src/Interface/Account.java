package Interface;

import java.util.HashMap;
import java.util.Scanner;

public class Account {

    HashMap<String, String> LoginDetails = new HashMap<String, String>();

    public Account(){

        LoginDetails.put("Marty", "Password");
        LoginDetails.put("Staff", "Password");

    }

    protected HashMap getLoginDetails(){
        return LoginDetails;
    }


}
