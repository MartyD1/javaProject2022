import java.util.ArrayList;
import java.util.List;

public class Order{
    private final String[] status={"S","M","D"};
    int orderNum=0;
    private String mealStatus=status[ orderNum ];
    private boolean orderCancelled=false;

    private ArrayList <Meal> dinners;

    public Order(){
        dinners=new ArrayList<Meal>();
    }

    public void addDinner(Meal m){
        dinners.add(m);
    }

    public void removeDinner(Meal m){
        for(int i=0;i<dinners.size();i++){
            if(dinners.get(i).getMealName()==m.getMealName() &&
                    dinners.get(i).getPrice()==m.getPrice() &&
                    dinners.get(i).getDescr()==m.getDescr()
            )
                dinners.remove(i);}
    }

    public void cancelDinners(){
        dinners.clear();
    }

    public double orderPrice(){   //This is for Table
        int value=0;
        for(int i=0;i<dinners.size();i++){
            value+=dinners.get(i).getPrice();}
        return value;
    }

    // public void changeStatus(int mealNum){ //Whats this for?
    // orderNum=mealNum;
    // mealStatus=status[orderNum];

    // }

    // public void nextMealNum(){
    // orderNum++;
    // mealStatus=status[orderNum];
    // }


    public String toString(){
        String str="";
        for(int i=0;i<dinners.size();i++)
            str+=dinners.get(i).toString()+"\n\n";;
        return str;
    }
}