package ReservationSystem;
//imports
import java.util.ArrayList;

/**
 * class to construct a booking calendar
 */
public class BookingCalendar  {

    //datafields
    private ArrayList<Booking> bookings;


    /**
     * constructor for bookingCalendar
     */
    public BookingCalendar() {
        this.bookings = new ArrayList<>();
    }


    /**
     * @param booking-booking to be added to Arraylist bookings
     */
    public void add(Booking booking) {
        this.bookings.add(booking);
    }
}