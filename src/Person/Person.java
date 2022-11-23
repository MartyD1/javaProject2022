package Person;
public class Person{
    private String name;
    private String role;
//    private boolean paid = false;               these things should probably be handled
//    private boolean orderCancelled = false;     in table class
//    private double tips;

    public Person(String name){
        this.name = name;

    }

    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }





    @Override
    public String toString() {
        return String.format("Name: %s, Role: %s", getName());
    }

    /* Should maybe be methods of table class instead?
    *  Makes more sense for a table as a whole to tip/pay/cancel
    *  rather than individual people
    */
//    public void setTips(double tips){
//        this.tips=tips;
//    }
//
//    public void orderPaid(){
//        paid=true;
//    }
//
//    public void cancel(){
//        orderCancelled=true;
//    }


    /* This function sorted in ReservationSystem */
//    public void book(String name){
//        this.name=name;
//    }
}