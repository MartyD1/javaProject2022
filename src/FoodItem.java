

import java.util.ArrayList;

public class FoodItem {

    private char type;
    private String name;
    private String description;
    private double price;


    public FoodItem(char type, String name, String description, double price) {

        this.type = type;
        this.name = name;
        this.description = description;
        this.price = price;

    }


    /*      Getters       */

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /*      Setters       */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //override toString method
    @Override
    public String toString() {
        return String.format("\n%s: %s,  %s: %s, %s: %s, %s: %.2f\n", "Type", getType(),
                "Name", getName(), "Description", getDescription(), "Price", getPrice());
    }




}