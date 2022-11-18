import java.util.ArrayList;

public class Order {


 // Arraylist orders to hold ordered items of type FoodItem
  private ArrayList<FoodItem> Orders;




    //Creating an Order for a table
    public Order(Table table){

        Orders = new ArrayList<>();

    }
    // add to order using index of item from menuItems
    public void addToOrder(int itemIndex) {
        FoodItem m = Menu.getMenu().get(itemIndex);
        Orders.add(m);
    }

    //remove from order using index of item from menuItems
    public void removeFromOrder(int itemIndex) {
        FoodItem m = Menu.getMenu().get(itemIndex);
        Orders.remove(m);}

    //cancel orders using order object name
    public void cancelOrder(){
        Orders.clear();}

    //get price of order by iterating through order array and getting price of each item
    public double getOrderPrice( ){
        double sum=0;
        for(int i=0;i<Orders.size();i++){
            sum=Orders.get(i).getPrice() + sum;
        }
        return sum;
    }


//to string
    @Override
    public String  toString(){
       return String.format("\n%s: %s\n%s: %s\n%s: %.2f\n","Table Number",Table.getTableNumber(),"Order",Orders,"Total Price",getOrderPrice());
    }








}






