package Person;

//customer subclass of person
public class Customer extends Person {

    //private data field phonenumber of type string
    private String phoneNumber;

    //customer constructor
    public Customer(String name, String phoneNumber){
        super(name);
        this.phoneNumber=phoneNumber;
    }

    //get phonenumber
    public String getPhoneNumber() {
        return phoneNumber;
    }
//set phonenumber
public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}

    //customer tostring method
    @Override
    public String toString() {
        return String.format("%s,\nPhoneNumber: %s", super.toString(),getPhoneNumber());
    }
}