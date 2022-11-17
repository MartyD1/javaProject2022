public class Person{
    private String name;
    private boolean paid=false;
    private boolean orderCancelled=false;
    private double tips;

    public Person(String name){
        this.name=name;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return name;
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

    public void book(String name){
        this.name=name;
    }
}