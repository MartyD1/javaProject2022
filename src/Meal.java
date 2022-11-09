public class Meal extends Order{
    String name;
    double price;
    String descr;
    String allergies="None";

    private final String[] status={"Starter","Main Course","Dessert"};
    int orderNum;
    private String mealStatus="";
    //private boolean mealCancelled=false;

    public Meal(String name, double price, String descr){
        this.name=name;
        this.price=price;
        this.descr=descr;
    }

    public Meal(String name, double price, String descr, String allergies){
        this(name, price, descr);
        this.allergies=allergies;
    }

    public Meal(int orderNum, String name, double price, String descr){
        this(name, price, descr);
        this.orderNum=orderNum;
        mealStatus=status[orderNum];
    }

    public Meal(int orderNum, String name, double price, String descr, String allergies){
        this(name, price, descr, allergies);
        this.orderNum=orderNum;
        mealStatus=status[orderNum];
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

    // public void cancelMeal(){
    // mealCancelled=true;
    // }

    public String toString(){
        String str="";
        str+="Name: "+name;
        if( ! (mealStatus.equals("") ) )
            str+="\nMeal Status: "+mealStatus;
        str+="\nPrice: "+price;
        str+="\nDescription: "+descr;
        str+="\nAllergies: "+allergies;
        return str;
    }


}