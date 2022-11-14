package ReservationSystem;

/**
 * Class to create a booking object
 */
public class Booking {

    private BookingDate date;
    private BookingTime time;
    private String name;
    private int numberOfPeople;
    private String phoneNumber;
    private String comments;

    public Booking(BookingDate date, BookingTime time, String name, int numberOfPeople, String phoneNumber, String comments) {
        this.date = date;
        this.time = time;
        this.name = name;
        this.numberOfPeople = numberOfPeople;
        this.phoneNumber = phoneNumber;
        this.comments = comments;
    }

    public BookingDate getDate() {
        return date;
    }
    public BookingTime getTime() {
        return time;
    }
    public String getName() {
        return name;
    }
    public int getNumberOfPeople() {
        return numberOfPeople;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getComments() {
        return comments;
    }


    /**
     * Typical toString method
     * @return  String representation of Booking object
     */
    @Override
    public String toString() {
        return String.format("""
                Date: %s
                Time: %s
                Name: %s
                Size: %d
                Phone number: %s
                Special requests: %s
                """,
                getDate().toString(), getTime().toString(),
                getName(), getNumberOfPeople(), getPhoneNumber(),
                getComments());
    }
}
