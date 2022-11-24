package ReservationSystem;

import Person.Customer;
import RestaurantSystem.Table;

import java.io.Serializable;
import java.util.StringTokenizer;

/**
 * Class to create a booking object
 */
public class Booking implements Serializable {

    private BookingDate date;
    private BookingTime time;

    private Customer customer;
    private String numberOfPeople;
    private String comments;

    public Booking(BookingDate date, BookingTime time, Customer customer, String numberOfPeople, String comments) {
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

    public BookingDate getDate() {
        return date;
    }
    public BookingTime getTime() {
        return time;
    }
    public String getName() {
        return customer.getName();
    }
    public String getPhoneNumber() {return customer.getPhoneNumber();}
    public String getNumberOfPeople() {
        return numberOfPeople;
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
                Size: %s
                Phone number: %s
                Special requests: %s
                """,
                getDate().toString(), getTime().toString(),
                getName(), getNumberOfPeople(), getPhoneNumber(),
                getComments());
    }
}
