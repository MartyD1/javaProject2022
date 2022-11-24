package FinanceHistory;

import java.util.ArrayList;
public class Calender {
    private ArrayList<DetailsBooking> bookings;


    /**
     * Method calender initializes arraylist booking.
     */
    public Calender(){
        bookings=new ArrayList<>();
    }


    /**
     * Method addBooking stores new bookings
     * @param booking the new booking
     */
    public void addBooking(DetailsBooking booking){
        bookings.add(booking);
    }

    /**
     * Method BookingsOnDay returns an arraylist contains bookings on a specific date.
     * @param day the day of the bookings
     * @return the arraylist of the bookings
     */
    public ArrayList<DetailsBooking> BookingsOnDay(String day){

        ArrayList<DetailsBooking> schedule =new ArrayList<>();

        for(int i=0;i<bookings.size();i++) {
            if (bookings.get(i).getDay().equals(day))
                schedule.add(bookings.get(i));
        }

        return schedule;

    }
}