package RestaurantSystem;

import java.util.ArrayList;

public class Order {

    //data fields
    private String name;
    private double finalBill;

    //order constructor
    public Order(String name, double finalBill) {
        this.name = name;
        this.finalBill = finalBill;
    }


    public Order(String line) {
        StringTokenizer token = new StringTokenizer(line, ",");
        this.name = token.nextToken();
        this.finalBill = Double.parseDouble((token.nextToken()).trim());
    }

    //get methods
    public String getName() {
        return name;
    }
    public double getFinalBill() {
        return finalBill;
    }
}






