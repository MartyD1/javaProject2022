package Interface;

public class Main {
    public static void main(String[] args) {

        Account account = new Account();

        Login login = new Login(account.getLoginDetails()); //parameters to recieve password

    }
}
