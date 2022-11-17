public class Person{
    private String name;
    private double price;
    private String descr;
    private String allergies;
    private boolean paid=false;
    private boolean orderCancelled=false;
    private double tips;

    public Person(String name, double price, String descr){
        this.name=name;
        this.price=price;
        this.descr=descr;
    }

    public Person(String name, double price, String descr, String allergies){
        this(name, price, descr);
        this.allergies=allergies;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }

    public void setPrice(double price){
        this.price=price;
    }

    public double getPrice(){
        return price;
    }

    public void setDescr(String descr){
        this.descr=descr;
    }

    public String getDescr(){
        return descr;
    }

    public void setAllergies(String allergies){
        this.allergies=allergies;
    }

    public String getAllergies(){
        return allergies;
    }

    public void setTips(double tips){
        this.tips=tips;
    }


    public void orderPaid(){
        paid=true;
    }

    public void cancel(){
        orderCancelled=true;
    }

    // public String search(){
    // return toString(); /////Noel done in booking system
    // }

    public void book(String name){
        this.name=name;
    }
}