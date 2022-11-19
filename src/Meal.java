//import java.util.ArrayList;
//
//public class Meal extends Order{
//    String MealName;
//    double price;
//    String descr;
//    String allergies="None";
//
//    private final String[] status={"Starter","Main Course","Dessert"};
//    int orderNum;
//    private String mealStatus="";
//    //private boolean mealCancelled=false;
//    private ArrayList<String> foods=new ArrayList<String>();
//    private ArrayList<String> prices=new ArrayList<String>();
//    private ArrayList<String> descriptions=new ArrayList<String>();
//
//      public Meal(String mealName){
//        assignFoodsInfo(mealName);
//
//    }
//
//    public Meal(String mealName, String allergies){
//        this(mealName);
//        this.allergies=allergies;
//    }
//
//    public Meal(int orderNum, String mealName){
//        this(mealName);
//        this.orderNum=orderNum;
//        mealStatus=status[orderNum];
//    }
//
//    public Meal(int orderNum, String MealName, String allergies){
//        this(MealName, allergies);
//        this.orderNum=orderNum;
//        mealStatus=status[orderNum];
//    }
//
//    // public void setMealName(String MealName){
//    // this.MealName=MealName;
//    // }
//
//    public String getMealName(){
//        return MealName;
//    }
//
//    // public void setPrice(double price){
//    // this.price=price;
//    // }
//
//    public double getPrice(){
//        return price;
//    }
//
//    // public void setDescr(String descr){
//    // this.descr=descr;
//    // }
//
//    public String getDescr(){
//        return descr;
//    }
//
//    // public void setAllergies(String allergies){
//    // this.allergies=allergies;
//    // }
//
//    // public String getAllergies(){
//    // return allergies;
//    // }
//
//    public void assignFoodsInfo(String name){
//        setFood();
//        setPrice();
//        setDescr();
//
//        int positionArray=0;
//        for(int i=0;i<foods.size();i++){
//            if(name==foods.get(i) )
//                positionArray=i;}
//
//        MealName=foods.get( positionArray );
//        price=Double.valueOf( prices.get(positionArray) );
//        descr=descriptions.get( positionArray );
//
//    }
//
//    public void setFood(){
//        foods.add("Pizza");
//        foods.add("Beef");
//        foods.add("Briege");
//        foods.add("Soup");
//        foods.add("Volivant");
//        foods.add("Guiness");
//        foods.add("Tea");
//        foods.add("Toast");
//    }
//
//    public void setPrice(){
//        prices.add("10");
//        prices.add("15");
//        prices.add("5");
//        prices.add("4");
//        prices.add("5");
//        prices.add("5");
//        prices.add("1");
//        prices.add("1");
//    }
//
//    public void setDescr(){
//        descriptions.add("Cheese Pizza");
//        descriptions.add("Potatoes, carrots, beef, gravy");
//        descriptions.add("breaded roast cheese");
//        descriptions.add("Veg, Chicken");
//        descriptions.add("Chicken volivant and sauce");
//        descriptions.add("Point of guinness");
//        descriptions.add("Black Tea and Milk");
//        descriptions.add("Toast and butter");
//    }
//
//    public String toString(){
//        String str="";
//        str+="Name: "+MealName;
//        if( ! (mealStatus.equals("") ) )
//            str+="\nMeal Status: "+mealStatus;
//        str+="\nPrice: "+price;
//        str+="\nDescription: "+descr;
//        str+="\nAllergies: "+allergies;
//        return str;
//    }
//
//}