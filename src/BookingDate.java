import java.util.StringTokenizer; //StringTokenizer splits a String into separate tokens

/**
 * Class to construct a BookingDate object that stores the day, month and year of the booking
 */

public class BookingDate {

    private int year;
    private int month;
    private int day;

    public BookingDate(int year, int month, int day) { // redundant constructor, may be used for testing
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public BookingDate(String line) { //remember line format is (yyyy-mm-dd)
        StringTokenizer str = new StringTokenizer(line, "-"); //converting String line into separate tokens
        this.year = Integer.parseInt(str.nextToken()); //tokens are of type String, int must be parsed
        this.month = Integer.parseInt(str.nextToken());
        this.day = Integer.parseInt(str.nextToken());
    }

    public int getYear() {
        return year;
    }
    public int getMonth() {
        return month;
    }
    public int getDay() {
        return day;
    }

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

    @Override
    public String toString() {
        return String.format("%d-%d-%d", getYear(), getMonth(), getDay());
    }
}


