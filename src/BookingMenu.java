import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.ArrayList;

public class BookingMenu {
    private Scanner in; // takes user input

    /**
     * Constructs a new BookingMenu object
     */
    public BookingMenu() {
        in = new Scanner(System.in); // creates new Scanner object (keyboard)
    }
    /**
     * Runs the system
     */
    public void run() {
        boolean cont = true; // system will keep running while this is true
        BookingCalendar calendar = new BookingCalendar();

        while (cont) {
            System.out.println("A)dd booking\nC)ancel booking\nS)how bookings\nQ)uit booking system\nEnter command: ");

            String command = in.nextLine().toUpperCase();

            if(command.equals('A')) {
                System.out.println("Choose date for booking: (dd-mm-yyyy)");
                String dateString = in.nextLine();
                LocalDate date = stringToDate(dateString);

                System.out.println("Choose starting time for booking: (hh:mm)");
                String startTime = in.nextLine();

                System.out.println("Choose ending time for booking: (hh:mm)");
                String endTime = in.nextLine();

                System.out.println("How many people for the booking: ");
                int amountPeople = in.nextInt();

                System.out.println("Special comments for booking: ");
                String comments = in.nextLine();

                Booking a = new Booking(date, startTime, endTime, amountPeople, comments);
                calendar.add(a);
            }
            if(command.equals('C')) {
                System.out.println("Date of unwanted booking: (dd-mm-yyyy)");
                String cancelDate = in.nextLine();

                System.out.println("Start time of unwanted booking: (hh:mm)");
                String cancelStartTime = in.nextLine();

                System.out.println("End time of unwanted booking: (hh:mm)");
                String cancelEndTime = in.nextLine();


            }
            if(command.equals('S')) {
                System.out.println("Bookings for what date: (dd-mm-yyyy)");
                String line = in.nextLine();

                LocalDate lineDate = stringToDate(line);
                BookingDate date = new BookingDate(lineDate); // this is the date you want to see bookings from

                for (Booking booking : calendar.getAppointmentsForDay(day));
                System.out.println("" + booking);

            }
            if(command.equals('Q')) {
                cont = false;
            }
        }
    }

    public LocalDate stringToDate(String command) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        LocalDate date = LocalDate.parse(command, formatter);
        return date;
    }
}



