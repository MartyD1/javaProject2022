import java.time.LocalDate;
import java.time.LocalDateTime;

public class Booking extends BookingDate {
    private int numberOfPeople;
    private String description;

    public Booking(LocalDate date, String startingTime, String endingTime, int numberOfPeople, String description) {
        super(date, startingTime, endingTime);
        this.numberOfPeople = numberOfPeople;
        this.description = description;
    }




}
