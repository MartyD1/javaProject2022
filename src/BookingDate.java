import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class BookingDate {
    private LocalDate date;
    private String startingTime;
    private String endingTime;

    public BookingDate(LocalDate date, String startingTime, String endingTime) {
        this.date = date;
        this.startingTime = startingTime;
        this.endingTime = endingTime;
    }

    public BookingDate(LocalDate date) {
        this.date = date;
    }





}
