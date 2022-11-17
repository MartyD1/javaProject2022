public class Staff extends Person{
    String name=super.getName();
    double price=super.getPrice();
    String descr=super.getDescr();
    String allergies=super.getAllergies();

    public Staff(String name, double price, String descr){
        super(name, price, descr);
    }

    public Staff(String name, double price, String descr, String allergies){
        super(name, price, descr, allergies);
        this.allergies=allergies;
    }

    public void order(){

    }

    public void changeStatus(){

    }
}