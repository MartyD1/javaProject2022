package Person;

import ReservationSystem.Booking;

public class Customer extends Person {

    private Booking booking;
    private String phoneNumber;

    public Customer(String name, String phoneNumber){
        super(name);
        this.phoneNumber=phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return String.format("%s,\nPhoneNumber: %s", super.toString(),getPhoneNumber());
    }


    /*
    These methods do not need to be here.
    Customer extends Person so Customer class already has
    access to methods from Person.
     */
//    public void pay(){
//        super.orderPaid();
//    }
//
//    public void tip(double tips){
//        super.setTips(tips);
//    }
}