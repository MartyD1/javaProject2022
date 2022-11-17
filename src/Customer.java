public class Customer extends Person{

    public Customer(String name, String role){
        super(name, role);
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