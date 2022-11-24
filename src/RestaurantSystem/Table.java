package RestaurantSystem;
//imports
import java.util.StringTokenizer;
/**
 * class to create a table
 */
public class Table {

//data fields
    private static String tableNumber;
    private static String numOfSeats;


    /**
     * table constructor
     * @param tableNumber - number of the table
     * @param numOfSeats- number of seats at the table
     */
    public Table(String tableNumber,String numOfSeats){
        this.tableNumber=tableNumber;
        this.numOfSeats=numOfSeats;
    }

    public Table(String line) {
        StringTokenizer token = new StringTokenizer(line, ",");
        this.tableNumber = token.nextToken();
        this.numOfSeats = token.nextToken();
    }

    /**
     * @return - number of the table
     */

    public static String getTableNumber() {
        return tableNumber;
    }

    /**
     * @return numOfSeats- number of seats at the table
     */
    public static String getTableNoOfSeats(){
        return numOfSeats;
    }
}