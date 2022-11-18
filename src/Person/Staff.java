package Person;

public class Staff extends Person{

    private String loginDetails; // two datafields for login system
    private String password;

    public Staff(String name, String role){
        super(name, role);

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