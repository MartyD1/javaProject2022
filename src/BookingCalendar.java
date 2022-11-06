import java.util.ArrayList;

public class BookingCalendar  {

    private ArrayList<Booking> bookings;


    public BookingCalendar() {
        this.bookings = new ArrayList<>();
    }

    public void add(Booking booking) {
        this.bookings.add(booking);
    }


    //issue seems to be with the equals() method in the following block
    //equals() method from Object class seems to be what's used, rather than the @Override method in Booking class
    public Booking[] getBookingsForDay(BookingDate day) {
        ArrayList<Booking> bookingsForDay = new ArrayList<>(); //new ArrayList created to store bookings for the day

        for (int i = 0; i < bookings.size(); i++) {            //iterating through ArrayList that holds bookings
            BookingDate dateCheck = bookings.get(i).getDate(); //creating local variable to make code more readable

            System.out.println(bookings.get(i).getDate().toString());
            System.out.println(day.toString());

            if (dateCheck.equals(day)) {                       //checking if date in bookings ArrayList matches required date
                bookingsForDay.add(bookings.get(i));           //if condition is satisfied, add Booking object to bookingsForDay
            }
        }
        Booking[] bookingsForDayArray = new Booking[bookingsForDay.size()]; //array of Booking objects with required date
        bookingsForDay.toArray(bookingsForDayArray);
        return bookingsForDayArray;
    }
}