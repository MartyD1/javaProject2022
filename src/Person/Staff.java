package Person;

import java.util.StringTokenizer;

//staff is a subclass of peron
public class Staff extends Person {

    //data fields role,logindetails and password of type Sting
    private String role;
    private String loginDetails; // two datafields for login system
    private String password;

//staff constructor
    public Staff(String name,String role, String loginDetails, String password){
        super(name);
        this.role = role;
        this.loginDetails = loginDetails;
        this.password = password;
    }


    public Staff(String line) {
        super(line);

        StringTokenizer token = new StringTokenizer(line, ",");
        token.nextToken();
        this.role = token.nextToken();
        this.loginDetails = token.nextToken();
        this.password = token.nextToken();
    }

//get and set methods for role, logindetails and password
    public String getRole() {return role;}

    public void setRole(String role) {this.role = role;}

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


//to string method for staff
    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s", super.toString(), getLoginDetails(), getPassword());
    }
}