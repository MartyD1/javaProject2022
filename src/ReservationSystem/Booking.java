package ReservationSystem;
//imports
import Person.Customer;
import java.io.Serializable;
import java.util.StringTokenizer;


/**
 * class that implements serializable to construct a booking
 */
public class Booking implements Serializable {
//data fields
    private BookingDate date;
    private BookingTime time;
    private Customer customer;
    private String numberOfPeople;
    private String comments;

    /**
     * booking constructor
     * @param date- date of booking
     * @param time- time of booking
     * @param customer- customer who is booking
     * @param numberOfPeople-number of people attending
     * @param comments-extra comments for booking
     */
    public Booking(BookingDate date, BookingTime time, Customer customer, String numberOfPeople,  String comments) {
        this.date = date;
        this.time = time;
        this.customer=customer;
        this.numberOfPeople = numberOfPeople;
        this.comments = comments;
    }

    public Booking(String line) {
        StringTokenizer token = new StringTokenizer(line, ",");
        this.date = new BookingDate(token.nextToken());
        this.time = new BookingTime(token.nextToken());
        this.customer =new Customer(token.nextToken(),token.nextToken());
        this.numberOfPeople = token.nextToken();
        this.comments = token.nextToken();
    }


    /**
     * @return date-date of booking
     */
    public BookingDate getDate() {
        return date;
    }

    /**
     * @return time-time of booking
     */
    public BookingTime getTime() {
        return time;
    }

    /**
     * @return name-name of customer booking
     */
    public String getName() {
        return customer.getName();
    }
    /**
     * @return  phoneNumber-phoneNumber of customer booking
     */
    public String getPhoneNumber() {return customer.getPhoneNumber();}

    /**
     * @return numberOfPeople- number of people attending booking
     */
    public String getNumberOfPeople() {
        return numberOfPeople;
    }

    /**
     * @return comments-extra comments for booking
     */
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
                Size: %s
                Phone number: %s
                Special requests: %s
                """,
                getDate().toString(), getTime().toString(),
                getName(), getNumberOfPeople(), getPhoneNumber(),
                getComments());
    }
}
