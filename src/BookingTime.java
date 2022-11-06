import java.util.StringTokenizer;

/**
 * Class to construct a BookingTime object to store when in the day the booking takes place
 */
public class BookingTime {
    private int hours;
    private int minutes;

    BookingTime(int hours, int minutes) { // redundant constructor, may be used for testing
        this.hours = hours;
        this.minutes = minutes;
    }

    BookingTime(String line) {
        StringTokenizer str = new StringTokenizer(line, ":"); //converting String line into separate tokens
        this.hours = Integer.parseInt(str.nextToken());             //tokens are of type String, int must be parsed
        this.minutes = Integer.parseInt(str.nextToken());
    }

    public int getHours() {
        return hours;
    }
    public int getMinutes() {
        return minutes;
    }

    public String toString() {
        return String.format("%d:%d", getHours(), getMinutes());
    }
}

