package ReservationSystem;
//imports
import java.io.Serializable;
import java.util.StringTokenizer; //StringTokenizer splits a String into separate tokens


/**
 * class that implements Serializable to construct a booking date
 */
public class BookingDate implements Serializable {

    //datafields
    private int year;
    private int month;
    private int day;


    /**
     * Constructor to break down a line of data to create a BookingDate object
     * @param line  a line containing all data to be broken down by StringTokenizer
     */
    public BookingDate(String line) { //remember line format is (yyyy-mm-dd)
        StringTokenizer str = new StringTokenizer(line, "-"); //converting String line into separate tokens
        this.year = Integer.parseInt(str.nextToken()); //tokens are of type String, int must be parsed
        this.month = Integer.parseInt(str.nextToken());
        this.day = Integer.parseInt(str.nextToken());
    }

    /**
     * @return year-year of booking
     */
    public int getYear() {return year;}

    /**
     * @return month- month of booking
     */
    public int getMonth() {return month;}

    /**
     * @return day-day of booking
     */
    public int getDay() {return day;}

    /**
     * Method to compare two objects, returns true if both the same
     * @param obj   Object to be compared to other
     * @return      boolean - whether or not two Objects are the same
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof BookingDate)) return false;

        BookingDate otherDate = (BookingDate)obj;
        if (this.year != otherDate.getYear())
            return false;
        if (this.month != otherDate.getMonth())
            return false;
        if (this.day != otherDate.getDay())
            return false;

        return true;
    }

    /**
     * @return String format forbooking date
     */
    @Override
    public String toString() {
        return String.format("%d-%d-%d", getYear(), getMonth(), getDay());
    }
}


