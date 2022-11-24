package Person;

import java.util.StringTokenizer;

public class Staff extends Person {

    //data fields role,logindetails and password of type Sting
    private String role;
    private String loginDetails; // two datafields for login system
    private String password;



    public Staff(String name, String loginDetails, String password){
        super(name);
        this.loginDetails = loginDetails;
        this.password = password;

    }

    public Staff(String line) {
        super(line);

        StringTokenizer token = new StringTokenizer(line, ",");
        token.nextToken();
        this.loginDetails = token.nextToken();
        this.password = token.nextToken();
    }





    public String getLoginDetails() {
        return loginDetails;
    }

    public void setLoginDetails(String loginDetails) {
        this.loginDetails = loginDetails;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s", super.toString(), getLoginDetails(), getPassword());
    }
}