package ReservationSystem;

import java.util.ArrayList;

public class BookingCalendar  {

    private ArrayList<Booking> bookings;


    public BookingCalendar() {
        this.bookings = new ArrayList<>();
    }

    public void add(Booking booking) {
        this.bookings.add(booking);
    }

    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    /* Redundant method, bookingsForDay not read from CSV file */
    public ArrayList<Booking> getBookingsForDay(BookingDate day) {
        ArrayList<Booking> bookingsForDay = new ArrayList<>(); //new ArrayList created to store bookings for the day

        for (int i = 0; i < bookings.size(); i++) {            //iterating through ArrayList that holds bookings
            BookingDate dateCheck = bookings.get(i).getDate(); //creating local variable to make code more readable

            if (dateCheck.equals(day)) {                       //checking if date in bookings ArrayList matches required date
                bookingsForDay.add(bookings.get(i));           //if condition is satisfied, add Booking object to bookingsForDay
            }
        }
        return bookingsForDay;
    }

    public void cancel(Booking c) {
        bookings.remove(c);
    }
}