

public class Table {


    private static int tableNumber;
    private int numOfSeats;


    //create a table
    public Table(int tableNumber,int numOfSeats){
        this.tableNumber=tableNumber;
        this.numOfSeats=numOfSeats;
    }


    //get a table number
    public static int getTableNumber() {
        return tableNumber;
    }
}