package Person;

import java.util.StringTokenizer;


/**
 * class that extends person to construct a staff member
 */
public class Staff extends Person {

    //data fields role,logindetails and password of type Sting
    private String role;
    private String loginDetails; // two datafields for login system
    private String password;


    /**
     * Staff constructor
     * @param name - name of staff member
     * @param role- role of staff member
     * @param loginDetails- login details of staff memeber
     * @param password- password of staff member
     */
    public Staff(String name,String role, String loginDetails, String password){
        super(name);
        this.role = role;
        this.loginDetails = loginDetails;
        this.password = password;
    }


    /**
     * Constructor to break down line of data to create Staff object
     * @param line  a line containing all data to be broken down by StringTokenizer
     */
    public Staff(String line) {
        super(line);

        StringTokenizer token = new StringTokenizer(line, ",");
        token.nextToken();
        this.role = token.nextToken();
        this.loginDetails = token.nextToken();
        this.password = token.nextToken();
    }


    /**
     * @return role-role of staff memeber
     */
    public String getRole() {return role;}

    /**
     * @return loginDetails-login details of staff member
     */
    public String getLoginDetails() {
        return loginDetails;
    }

    /**
     * @return password-password of staff member
     */
    public String getPassword() {
        return password;
    }


    /**
     * @return String format of staff
     */
    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s", super.toString(), getLoginDetails(), getPassword());
    }
}