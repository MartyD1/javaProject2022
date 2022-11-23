package FinanceHistory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class ViewEarnings {        //class to see output in terminal to view profits of day(s)
    private Scanner scan;
    private LocalDate fDate;
   private  LocalDate tDate;

    private int numOfPeople=1;

    Calender calender=new Calender();
    public ViewEarnings(){
        scan=new Scanner(System.in);
    }

    public void start() {

        boolean view = true;

        while (view) {
            System.out.println("V)iew Records\nE)xit");
            String action = scan.nextLine().toUpperCase();

            if (action.equals("V")) {
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

                    fDate= LocalDate.of(fYear, fMonth, fDay);
                    tDate=LocalDate.of(tYear, tMonth, tDay);

                    ArrayList<LocalDate> imbetweenDates=new ArrayList<>();
                    while(!(fDate.equals(tDate))){                          //try .equals()
                        imbetweenDates.add(fDate);
                        fDate=fDate.plusDays(1);
                    }
                    imbetweenDates.add(tDate);

                    String localDateString;
                    String[] splitUp;
                    DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd MM yyyy");

                    double madeOverDays=0;
                    for(int i=0;i<imbetweenDates.size();i++){
                        localDateString=imbetweenDates.get(i).format( formatter );
                        splitUp=localDateString.split(" ");
                        madeOverDays+=billOnDay(
                                Integer.parseInt( splitUp[2]),
                                Integer.parseInt( splitUp[1]),
                                Integer.parseInt( splitUp[0]));
                    }
                    System.out.println("Gross Profit $"+madeOverDays);
                    System.out.println("Date, time, Name, phoneNumber, FinalBill");



                    for(int i=0;i<imbetweenDates.size();i++) {
                        localDateString=imbetweenDates.get(i).format( formatter );
                        //System.out.println("localDateString: "+localDateString);
                        splitUp=localDateString.split(" ");
                        printDate(
                                Integer.parseInt( splitUp[2] ),
                                Integer.parseInt( splitUp[1] ),
                                Integer.parseInt( splitUp[0] ));

                    }

                }
            }
            else
                view = false;
        }


    }

    public void printDate(int y, int m, int d){
        String date=getStringDate(y, m, d);
        CalenderDate dateObject = new CalenderDate(date);

        for (BookingHistory history : calender.BookingsOnDay(dateObject)) {
            System.out.println(numOfPeople + ") " + history.toString());
            numOfPeople++;
        }
    }

    public String getStringDate(int y, int m, int d){ //day, month, year
        String sDay=Integer.toString(d); //StringDay
        String sMonth=Integer.toString(m);
        String sYear=Integer.toString(y);

        return sYear+"-"+sMonth+"-"+sDay;
    }

    public int[]  getIntDate(String date){
        String[] stringNum=date.split("-");
        int[] intNums=new int[3];
        intNums[0]=Integer.parseInt(stringNum[0]);
        intNums[1]=Integer.parseInt(stringNum[1]);
        intNums[2]=Integer.parseInt(stringNum[2]);
        return intNums;

    }

    public void setBookings(ArrayList<BookingHistory> records) {

        for (int i = 0; i < records.size(); i++) {
            calender.addBooking(records.get(i));
        }
        //calender.showBooking(); //uncomment method from Calender class  and call to see all bookings added
    }

    public double billOnDay(int y, int m, int d){
        String date=getStringDate(y, m, d);
        CalenderDate dateObject = new CalenderDate(date);
        double madeOnDay=0;
        for (BookingHistory history : calender.BookingsOnDay(dateObject))
            madeOnDay+=history.getFinalBill();

        return madeOnDay;

    }

}
