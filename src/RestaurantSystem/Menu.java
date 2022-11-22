package RestaurantSystem;

import RestaurantSystem.FoodItem;

import java.util.ArrayList;
//public class menu to create and get a menu for restaurants
public class Menu  {
//arraylist holding menu items of type FoodItem
    private static ArrayList<FoodItem> menuItems = new ArrayList<>();

//creates new menu
    public Menu(){
        menuItems=new ArrayList<>();}

    //remove item from menu
    public void removeFromMenu(FoodItem a){
        menuItems.remove(a);}


    // add fooditem to menu
    public void addToMenu(FoodItem a){
        menuItems.add(a);}


    //to get the menu
    public static ArrayList<FoodItem> getMenu() {
        return menuItems;
    }
}



