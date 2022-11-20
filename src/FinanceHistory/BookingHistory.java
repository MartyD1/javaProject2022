package FinanceHistory;
//
public class BookingHistory {
    private String name;
    private CalenderDate day;
    private CalenderTime bookingTime;

    private String phoneNumber;

    private double finalBill;

    public BookingHistory(String booking){
        //booking format-tableName, day, time
        String[] str=booking.split(" ");
        name=str[2];
        day=new CalenderDate( str[0] );
        bookingTime= new CalenderTime( str[1] );
        phoneNumber=str[3];
        finalBill = 0;      //Don't have any final bill
    }

    public String getName(){
        return name;
    }

    public String getDay(){
        return day.toString();
    }

    public String getBookingTime(){
        return bookingTime.toString();
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public double getFinalBill(){
        return finalBill;
    }

    public String toString(){

        return day.toString()+" "+bookingTime.toString()+" "+name+" "+phoneNumber+" "+finalBill;
    }
}