package RestaurantSystem;

import java.util.StringTokenizer;

public class FoodItem {

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



    public FoodItem(char type, String name, String description, double price){
        this.type = type;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public FoodItem(String line) {
        StringTokenizer token = new StringTokenizer(line, ",");
        this.type = token.nextToken().charAt(0);
        this.name = token.nextToken();
        this.description = token.nextToken();
        this.price = Double.parseDouble(token.nextToken());
    }


    /*      Getters       */

    public char getType(){
        return type;
    }

    public String getDescription(){
        return description;
    }

    public String getName() {
        return name;
    }

    public double getPrice(){
        return price;
    }

    /*      Setters       */

    public void setType(char type){
        this.type = type;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    //override toString method
    @Override
    public String toString() {
        return String.format("\n%s: %s\n%s: %s\n%s: %s\n%s: %.2f\n\n", "Type", getType(),
                "Name", getName(), "Description", getDescription(), "Price", getPrice());
    }


}
