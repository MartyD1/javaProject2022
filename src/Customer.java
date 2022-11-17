public class Customer extends Person{
    private String name;
    private double price;
    private String descr;
    private String allergies;

    public Customer(String name, double price, String descr){
        super(name, price, descr);
    }

    public Customer(String name, double price, String descr, String allergies){
        super(name, price, descr, allergies);
        this.allergies=allergies;
    }

    public void pay(){
        super.orderPaid();
    }

    public void tip(double tips){
        super.setTips(tips);
    }
}