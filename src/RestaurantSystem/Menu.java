package RestaurantSystem;
//imports
import java.util.ArrayList;

/**
 * class to create a menu
 */
public class Menu  {
//arraylist holding menu items of type FoodItem
    private static ArrayList<FoodItem> menuItems = new ArrayList<>();


    /**
     * constructor for menu
     */
    public Menu(){
        menuItems=new ArrayList<>();}


    /**
     * @param a- index of fooditem from menuitems to remove from order
     */
    public void removeFromMenu(FoodItem a){
        menuItems.remove(a);}


    /**
     * @param a- index of fooditem from menuite
     */
    public void addToMenu(FoodItem a){
        menuItems.add(a);}
}