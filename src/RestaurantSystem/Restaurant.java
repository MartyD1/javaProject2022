package RestaurantSystem;

//imports
import Person.Owner;
import Person.Staff;
import java.util.ArrayList;


/**
 * class to create a restaurant
 */
public class Restaurant {

    // data fields
    private static String location;
    private ArrayList<Staff> employees;
    private ArrayList<Table> tables;
    private static Owner owner;
    private ArrayList<FoodItem> menu;


    /**
     * restaurant constructor
     * @param location- location of restaurant
     * @param owner-owner of restaurant
     */
    public Restaurant(String location, Owner owner) {
        this.location = location;
        employees = new ArrayList<>();
        tables = new ArrayList<>();
        this.owner = owner;
        menu = new ArrayList<>();
    }

}