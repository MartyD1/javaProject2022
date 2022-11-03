import java.time.LocalDate;
import java.util.ArrayList;

public class BookingCalendar {
    private LocalDate date;
    private ArrayList<Booking> dateBookings;

    public BookingCalendar(LocalDate date) {
        this.date = date;
        this.dateBookings = new ArrayList<>();
    }

    public BookingCalendar() {
        this.date = LocalDate.now();
        this.dateBookings = new ArrayList<>();
    }

    public void add(Booking e) {
        this.dateBookings.add(e);
    }


    public ArrayList<Booking> getDateBookings() {
        return dateBookings;
    }

    public Booking[] getBookingsForDay(BookingDate date) {



        return bookingsForDay;
    }
}