package RestaurantSystem;

//imports
import Person.Owner;
import Person.Staff;
import java.util.ArrayList;

//public restaurant class
public class Restaurant {

    // data fields
    private static String location;
    private ArrayList<Staff> employees;
    private ArrayList<Table> tables;
    private static Owner owner;
    private ArrayList<FoodItem> menu;

    //restaurant constructor, creates new arrays for restaurant in constructor
    public Restaurant(String location, Owner owner) {
        this.location = location;
        employees = new ArrayList<>();
        tables = new ArrayList<>();
        this.owner = owner;
        menu = new ArrayList<>();
    }

    //get methods
    public static String getLocation() { return location;}
    public static Owner getOwner() {return owner;}
    //add employee
    public void addEmployee(Staff emp) {employees.add(emp);}
    //remove employee
    public void removeEmployee(Staff emp) {employees.remove(emp);}
    //add table
    public void addTable(Table table) {tables.add(table);}
    //remove table
    public void removeTable(Table table) {tables.remove(table);}
}