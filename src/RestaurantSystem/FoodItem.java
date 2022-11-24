package RestaurantSystem;

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



    public enum Allergens{
        CEREALS("C"),
        CRUSTACEANS("CR"),
        EGGS("E"),
        FISH("F"),
        PEANUTS("PN"),
        SOYBEANS("SB"),
        MILK("M"),
        NUTS("N"),
        MUSTARD("MU"),
        SESAME_SEEDS("SS"),
        SULPHUR_DIOXIDE("SD"),
        LUPIN("L"),
        MOLLUSCS("MO");


        public final String allergenCode;

        private Allergens(String allergenCode){
            this.allergenCode = allergenCode;

        }

    }


    /**
     * @param type
     * @param name
     * @param description
     * @param price
     */
    public FoodItem(char type, String name, String description, double price){
        this.type = type;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    /**
     * @param line
     */
    public FoodItem(String line) {
        StringTokenizer token = new StringTokenizer(line, ",");
        this.type = token.nextToken().charAt(0);
        this.name = token.nextToken();
        this.description = token.nextToken();
        this.price = Double.parseDouble(token.nextToken());
    }


    /*      Getters       */

    /**
     * @return type
     */
    public char getType(){
        return type;
    }

    /**
     * @return description
     */
    public String getDescription(){
        return description;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @return price
     */
    public double getPrice(){
        return price;
    }

    /*      Setters       */

    /**
     * @param type
     */
    public void setType(char type){
        this.type = type;
    }

    /**
     * @param description
     */
    public void setDescription(String description){
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    //tostring method for fooditem
    @Override
    public String toString() {
        return String.format("\n%s: %s\n%s: %s\n%s: %s\n%s: %.2f\n\n", "Type", getType(),
                "Name", getName(), "Description", getDescription(), "Price", getPrice());
    }


}
