package RestaurantSystem;

public class Table {


    private  String tableNumber;
    private String numOfSeats;


    //create a table
    public Table(String tableNumber,String numOfSeats){
        this.tableNumber=tableNumber;
        this.numOfSeats=numOfSeats;
    }


    //get a table number
    public  String getTableNumber() {
        return tableNumber;}

    public String getNumOfSeats() {
        return numOfSeats;
    }

    @Override
    public String toString(){
        return String.format("%s: %s\n%s: %s","Table Number",getTableNumber(),"Number Of Seats",getNumOfSeats());
    }
}