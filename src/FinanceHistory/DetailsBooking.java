package FinanceHistory;//

public class DetailsBooking {
    private final String name;
    private final String day;
    private final String bookingTime;

    private final String phoneNumber;

    private final double finalBill;

    public DetailsBooking(String booking){
        //booking format-tableName, day, time
        String[] str=booking.split(" ");
        name=str[2];
        day= str[0] ;
        bookingTime= str[1] ;
        phoneNumber=str[3];
        finalBill = 0;      //Don't have any final bill
    }

    public String getName(){
        return name;
    }

    public String getDay(){
        return day;
    }

    public String getBookingTime(){
        return bookingTime;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public double getFinalBill(){
        return finalBill;
    }

    public String toString(){

        return day+" "+bookingTime+" "+name+" "+phoneNumber+" "+finalBill;
    }
}