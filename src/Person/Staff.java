package Person;

public class Staff extends Person {

    private String loginDetails; // two datafields for login system
    private String password;
    private String role;

    public Staff(String name, String role){
        super(name);
        this.role=role;
    }


    public String getRole() {
        return role;
    public Staff(String name, String role, String loginDetails, String password){
        super(name, role);
        this.loginDetails = loginDetails;
        this.password = password;
    }

    public Staff(String line) {
        super(line);

        StringTokenizer token = new StringTokenizer(line, ",");
        token.nextToken();
        token.nextToken();
        this.loginDetails = token.nextToken();
        this.password = token.nextToken();
    }

    public void setRole(String role) {
        this.role = role;
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