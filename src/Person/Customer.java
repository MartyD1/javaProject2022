//package Person;
//
//import ReservationSystem.Booking;
//
//public class Customer extends Person {
//
//    private Booking booking;
//
//    public Customer(String name, String role, Booking booking) {
//        super(name, role);
//        this.booking = booking;
//    }
//
//    @Override
//    public String toString() {
//        return String.format("%s,\nBooking details: %s", super.toString(), this.booking.toString());
//    }
//
//
//    /*
//    These methods do not need to be here.
//    Customer extends Person so Customer class already has
//    access to methods from Person.
//     */
////    public void pay(){
////        super.orderPaid();
////    }
////
////    public void tip(double tips){
////        super.setTips(tips);
////    }
//}