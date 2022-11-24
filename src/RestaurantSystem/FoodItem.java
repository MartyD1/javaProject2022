package RestaurantSystem;
//imports
import java.util.StringTokenizer;


/**
 * Class to create a fooditem
 */
public class FoodItem {

    //data fields
    private char type;
    private String name;
    private String description;
    private double price;

    /**
     * @param type -type of fooditem starter,main...etc...
     * @param name -name of food item
     * @param description -decription of fooditem
     * @param price- price of fooditem
     */
    //fooditem constructor
    public FoodItem(char type, String name, String description, double price){
        this.type = type;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    /**
     * Constructor to create a FoodItem object using StringTokenizer
     * @param line  a line containing all data to be broken down by StringTokenizer
     */
    public FoodItem(String line) {
        StringTokenizer token = new StringTokenizer(line, ",");
        this.type = token.nextToken().charAt(0);
        this.name = token.nextToken();
        this.description = token.nextToken();
        this.price = Double.parseDouble(token.nextToken());
    }


    /**
     * @return type-type of fooditem starter,main...etc...
     */
    public char getType(){
        return type;
    }

    /**
     * @return description -decription of fooditem
     */
    public String getDescription(){
        return description;
    }

    /**
     * @return name -name of food item
     */
    public String getName() {
        return name;
    }

    /**
     * @return price- price of fooditem
     */
    public double getPrice(){
        return price;
    }

    /**
     * @param name-name of food item
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     *
     * @return  String representation of a FoodItem object
     */
    @Override
    public String toString() {
        return String.format("\n%s: %s\n%s: %s\n%s: %s\n%s: %.2f\n\n", "Type", getType(),
                "Name", getName(), "Description", getDescription(), "Price", getPrice());
    }
}