package ReservationSystem;
//imports
import java.io.Serializable;
import java.util.StringTokenizer;

/**
 * Class to construct a BookingTime object to store when in the day the booking takes place
 */
public class BookingTime implements Serializable {
    private int hours;
    private int minutes;


    public BookingTime(String line) {
        StringTokenizer str = new StringTokenizer(line, ":"); //converting String line into separate tokens
        this.hours = Integer.parseInt(str.nextToken().trim());             //tokens are of type String, int must be parsed
        this.minutes = Integer.parseInt(str.nextToken());
    }


    /**
     * @return hours-hours of booking
     */
    public int getHours() {
        return hours;
    }

    /**
     * @return minutes-minutes of booking
     */
    public int getMinutes() {
        return minutes;
    }

    /**
     * @return String format for bookimng time
     */
    public String toString() {
        return String.format("%d:%d", getHours(), getMinutes());
    }
}

