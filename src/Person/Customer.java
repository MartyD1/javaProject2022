package Person;


/**
 * class that extends person to construct a customer
 */
public class Customer extends Person {

    //private data field phoneNumber of type string
    private String phoneNumber;

    /**
     * Customer constructor
     * @param name - name of customer
     * @param phoneNumber- phoneNumber of customer
     */
       public Customer(String name, String phoneNumber){
        super(name);
        this.phoneNumber=phoneNumber;
    }


    /**
     * @return phoneNumber-phone number of customer
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }


    /**
     * @return String format of customer
     */
    @Override
    public String toString() {
        return String.format("%s,\nPhoneNumber: %s", super.toString(),getPhoneNumber());
    }
}