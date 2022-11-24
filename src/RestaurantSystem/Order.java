package RestaurantSystem;
//imports
import java.util.StringTokenizer;


/**
 * class to create an order
 */
public class Order {

    //data fields
    private String name;
    private double finalBill;


    /**
     * order constructor
     * @param name -name of person order is for
     * @param finalBill-final bill of order
     */
    public Order(String name, double finalBill) {
        this.name = name;
        this.finalBill = finalBill;
    }

    /**
     * Method to breakdown line into a Order object using StringTokenizer
     * @param line a line containing all data to be broken down by StringTokenizer
     */
    public Order(String line) {
        StringTokenizer token = new StringTokenizer(line, ",");
        this.name = token.nextToken();
        this.finalBill = Double.parseDouble((token.nextToken()).trim());
    }

    /**
     * @return name-name of person order is for
     */
    public String getName() {
        return name;
    }

    /**
     * @return  finalBill-final bill of order
     */
    public double getFinalBill() {
        return finalBill;
    }
}






