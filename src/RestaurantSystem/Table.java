package RestaurantSystem;
//imports
import java.util.Scanner;
import java.util.StringTokenizer;
import static CSV.GeneralCSV.readCSV;
//public table class
public class Table {

//data fields
    private static String tableNumber;
    private static String numOfSeats;


    //create a table
    public Table(String tableNumber,String numOfSeats){
        this.tableNumber=tableNumber;
        this.numOfSeats=numOfSeats;
    }

    public Table(String line) {
        StringTokenizer token = new StringTokenizer(line, ",");
        this.tableNumber = token.nextToken();
        this.numOfSeats = token.nextToken();
    }


    //get a table number
    public static String getTableNumber() {
        return tableNumber;
    }
    public static String getTableNoOfSeats(){
        return numOfSeats;
    }
    // CSV stuff here


    //table menu to add,remove and view tables or quit
    public void TableMenu(){
        // Scanner object
        Scanner scan = new Scanner(System.in);
        //cont set true table menu ends when set false
        boolean cont = true;

        while(cont){


            System.out.println("(A)dd table, (R)emove table, (V)iew tables, (Q)uit");
            String command = scan.nextLine();
            //add table
            if(command.equals("A")){
                System.out.println("Enter table number:");
                String num = scan.nextLine();
                System.out.println("Enter number of seats:");
                String seats = scan.nextLine();
                Table table = new Table(num, seats);}

            //remove table
            else if (command.equals("R")) {
                System.out.println("REMOVE TABLE PLACEHOLDER");}
            //view tables
            else if (command.equals("V")) {
                System.out.println("Tables: ");
                readCSV("table.csv");}
            //quit
            else if (command.equals("Q")) {cont = false;}
        }
    }
}