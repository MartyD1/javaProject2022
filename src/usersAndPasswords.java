import java.util.HashMap;

/* This class will store usernames and passwords in pairs using a hashmap*/
public class usersAndPasswords {

    HashMap<String, String> loginInformation = new HashMap<String, String>();

    usersAndPasswords(){

        // Hash map can link 2 values together, in this case a user with a password

        loginInformation.put("Admin", "Password");
        loginInformation.put("Staff", "Password");
    }

    protected HashMap getLogin(){
        return loginInformation;
    }
}
