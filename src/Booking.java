/**
 * Class to create a booking object
 */
public class Booking {

    private BookingDate date;
    private BookingTime time;
    private String name;
    private int numberOfPeople;
    private String comments;

    public Booking(BookingDate date, BookingTime time, String name, int numberOfPeople, String comments) {
        this.date = date;
        this.time = time;
        this.name = name;
        this.numberOfPeople = numberOfPeople;
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
                Special requests: %s
                """,
                getDate().toString(), getTime().toString(),
                getName(), getNumberOfPeople(), getComments());
    }

//    @Override
//    public boolean equals(Object obj) {
//        if (obj == null) return false;
//        if (obj == this) return true;
//        if (!(obj instanceof BookingDate)) return false;
//
//        BookingDate otherDate = (BookingDate)obj;
//        if (this.date != otherDate) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int hash = 3;
//        hash = 53 * hash + (this.date != null ? this.date.hashCode() : 0);
//        return hash;
//    }
}
