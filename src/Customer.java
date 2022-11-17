public class Customer extends Person{
    private String name;

    public Customer(String name){
        super(name);
        this.name=name;
    }

    public void pay(){
        super.orderPaid();
    }

    public void tip(double tips){
        super.setTips(tips);
    }
}