public class Person{
    private String name;
    private String role;
    private boolean paid = false;
    private boolean orderCancelled = false;
    private double tips;

    public Person(String name, String role){
        this.name = name;
        this.role = role;
    }

    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }



    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    /* Should maybe be methods of tables class instead?
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