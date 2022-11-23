package RestaurantSystem;

import java.util.Scanner;

import static CSV.GeneralCSV.readCSV;


public class Table {


    private static int tableNumber;
    private static int numOfSeats;


    //create a table
    public Table(int tableNumber,int numOfSeats){
        this.tableNumber=tableNumber;
        this.numOfSeats=numOfSeats;
    }


    //get a table number
    public static int getTableNumber() {
        return tableNumber;
    }

    public static int getTableNoOfSeats(){
        return numOfSeats;
    }

    // CSV stuff here


    public void TableMenu(){

        // Scanner object
        Scanner scan = new Scanner(System.in);

        boolean cont = true;

        while(cont){


            System.out.println("(A)dd table, (R)emove table, (V)iew tables, (Q)uit");
            String command = scan.nextLine();

            if(command.equals("A")){
                System.out.println("Enter table number:");
                int num = scan.nextInt();
                System.out.println("Enter number of seats:");
                int seats = scan.nextInt();

                Table table = new Table(num, seats);

            } else if (command.equals("R")) {
                System.out.println("REMOVE TABLE PLACEHOLDER");

            } else if (command.equals("V")) {
                System.out.println("Tables: ");
                readCSV("table.csv");

            } else if (command.equals("Q")) {
                cont = false;
            }

        }
    }
}