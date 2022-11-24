package FinanceHistory;

public class DetailsBooking {
    private final String name;
    private final String day;
    private final String bookingTime;

    private final String phoneNumber;

    private double finalBill;


    /**
     * Method DetailsBooking sets paramters of data of booking.
     * @param booking String containing data
     */
    public DetailsBooking(String booking){
        //booking format-tableName, day, time
        String[] str=booking.split(" ");
        name=str[2];
        day= str[0] ;
        bookingTime= str[1] ;
        phoneNumber=str[3];
    }


    /**
     * Method getName returns the name of the booking
     * @return name
     */
    public String getName(){
        return name;
    }


    /**
     * Method getDay returns the day of a booking
     * @return day
     */
    public String getDay(){
        return day;
    }


    /**
     * Method getBookingTime returns the booking time of a booking
     * @return the booking time
     */
    public String getBookingTime(){
        return bookingTime;
    }


    /**
     * Method getPhoneNumber returns the phone number given for a booking
     * @return the phone number
     */
    public String getPhoneNumber(){
        return phoneNumber;
    }


    /**
     *  Method getFinalBill sets the final bill of a booking
     * @param finalBill the final bill
     */
    public void setFinalBill(double finalBill){
        this.finalBill=finalBill;
    }


    /**
     * Method getFinalBill returns the final bill for a booking
     * @return the final bill
     */
    public double getFinalBill(){
        return finalBill;
    }

    /**
     * Method toString() returns the instance variable together.
     * @return String including: day, booking time, name, phone number, final bill
     */
    public String toString(){

        return day+" "+bookingTime+" "+name+" "+phoneNumber+" "+finalBill;
    }
}