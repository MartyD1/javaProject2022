package FinanceHistory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;


public class ViewEarnings {        //class to see output in terminal to view profits of day(s)
    private Scanner scan;
    private int numOfPeople=1;

    Calender calender=new Calender();


    /**
     * Constructor ViewEarnings initializes Scanner object scan.
     */
    public ViewEarnings(){
        scan=new Scanner(System.in);
    }


    /**
     * Method start asks the user between what dates they would like to see information on previous bookings and prints.
     */
    public void start() {

        boolean view = true;

        while (view) {
            System.out.println("S)how Earnings\nC)lose");
            String action = scan.nextLine().toUpperCase();

            if (action.equals("S")) {
                System.out.println("Enter Dates (from to) (yyyy-mm-dd) :");
                String breakUp = scan.nextLine();
                String[] dates = breakUp.split(" ");
                String from = dates[0];
                String to = dates[1];

                int[] dateArrayFrom=getIntDate(from); //getIntDate()- method to return int array of date from string of date .

                numOfPeople=1;

                if(from.equals(to)){
                    double madeOnDay =billOnDay(dateArrayFrom[0], dateArrayFrom[1], dateArrayFrom[2]);

                    System.out.println("Gross Profit $"+madeOnDay);
                    System.out.println("Date, time, Name, phoneNumber, FinalBill");
                    printDate(dateArrayFrom[0], dateArrayFrom[1], dateArrayFrom[2]);
                }
                else {
                    String[] numsFrom=from.split("-"); //split up from date into numsFrom[] dd mm yyyy
                    String[] numsTo=to.split("-");


                    int fDay=Integer.parseInt( numsFrom[2] ); // from this day
                    int tDay=Integer.parseInt( numsTo[2] ); //to this day
                    int fMonth=Integer.parseInt( numsFrom[1] );
                    int tMonth=Integer.parseInt( numsTo[1] );
                    int fYear=Integer.parseInt( numsFrom[0] );
                    int tYear=Integer.parseInt( numsTo[0] );

                    LocalDate fDate;fDate= LocalDate.of(fYear, fMonth, fDay);
                    LocalDate tDate=LocalDate.of(tYear, tMonth, tDay);

                    ArrayList<LocalDate> inbetweenDates=new ArrayList<>();
                    while(!(fDate.equals(tDate))){                          //try .equals()
                        inbetweenDates.add(fDate);
                        fDate=fDate.plusDays(1);
                    }
                    inbetweenDates.add(tDate);

                    String localDateString;
                    String[] splitUp;
                    DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd MM yyyy");

                    double madeOverDays=0;
                    for (LocalDate inbetweenDate : inbetweenDates) {
                        localDateString = inbetweenDate.format(formatter);
                        splitUp = localDateString.split(" ");
                        madeOverDays += billOnDay(
                                Integer.parseInt(splitUp[2]),
                                Integer.parseInt(splitUp[1]),
                                Integer.parseInt(splitUp[0]));
                    }
                    System.out.println("Gross Profit $"+madeOverDays);
                    System.out.println("Date, time, Name, phoneNumber, FinalBill");


                    for (LocalDate inbetweenDate : inbetweenDates) {
                        localDateString = inbetweenDate.format(formatter);
                        //System.out.println("localDateString: "+localDateString);
                        splitUp = localDateString.split(" ");
                        printDate(
                                Integer.parseInt(splitUp[2]),
                                Integer.parseInt(splitUp[1]),
                                Integer.parseInt(splitUp[0]));

                    }

                }
            }
            else
                view = false;
        }


    }

    /**
     * Method printDate prints the information on the date given in parameters.
     * @param y Year
     * @param m Month
     * @param d Day
     */
    public void printDate(int y, int m, int d){
        String date=getStringDate(y, m, d);

        for (DetailsBooking history : calender.BookingsOnDay(date)) {
            System.out.println(numOfPeople + ") " + history.toString());
            numOfPeople++;
        }
    }


    /**
     * Method getStringDate returns a date in String.
     * @param y Year
     * @param m Month
     * @param d Day
     * @return the date in format yyyy-MM-dd
     */
    public String getStringDate(int y, int m, int d){ //day, month, year
        String sDay=Integer.toString(d); //StringDay
        String sMonth=Integer.toString(m);
        String sYear=Integer.toString(y);

        return sYear+"-"+sMonth+"-"+sDay;
    }


    /**
     * Method getIntDate takes a string of date and returns an array of the date.
     * @param date String date
     * @return array holding int values of the string date entered.
     */
    public int[]  getIntDate(String date){
        String[] stringNum=date.split("-");
        int[] intNums=new int[3];
        intNums[0]=Integer.parseInt(stringNum[0]);
        intNums[1]=Integer.parseInt(stringNum[1]);
        intNums[2]=Integer.parseInt(stringNum[2]);
        return intNums;

    }


    /**
     * Method setBookings stores the data collecetd in Calender class.
     * @param records ArrayList holding details if booking
     */
    public void setBookings(ArrayList<DetailsBooking> records) {

        for (DetailsBooking record : records) {
            calender.addBooking(record);
        }
    }


    /**
     * Method billOnDay calculates the money made in a day
     * @param y Year
     * @param m Month
     * @param d Day
     * @return the total amount of money made that day.
     */
    public double billOnDay(int y, int m, int d){
        String date=getStringDate(y, m, d);
        double madeOnDay=0;
        for (DetailsBooking history : calender.BookingsOnDay(date))
            madeOnDay+=history.getFinalBill();

        return madeOnDay;

    }


}
