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

    public void run() {
        boolean cont = true;
        BookingCalendar calendar = new BookingCalendar();
        while (cont) {
            System.out.println("A)dd booking\nC)ancel booking\nS)how booking\nQ)uit system");
            String command = in.nextLine().toUpperCase(); // if user inputs lowercase command, it will still be read

            if (command.equals("A")) { // add booking function follows
                System.out.println("""
                                    Date of booking
                                    (yyyy-mm-dd)""");
                String dateString = in.nextLine();
                BookingDate d = new BookingDate(dateString);

                System.out.println("""
                                    Time of booking
                                    (hh:mm)""");
                String timeString = in.nextLine();
                BookingTime t = new BookingTime(timeString);

                System.out.println("Name of booking: "); // name could be changed to use getName() method of Customer object down the line
                String nameString = in.nextLine();

                System.out.println("Number of guests: ");
                int numberOfGuests = in.nextInt();

                System.out.println("Special comments: ");
                String comments = in.nextLine();

                System.out.println();

                Booking booking = new Booking(d, t, nameString, numberOfGuests, comments);
                calendar.add(booking);

                System.out.println(booking);

            }
            else if (command.equals("C")) {

            }
            else if (command.equals("S")) {
                System.out.println("""
                                    Display what date:
                                    (yyyy-mm-dd)""");
                String showDate = in.nextLine();
                BookingDate day = new BookingDate(showDate);

                for (Booking booking : calendar.getBookingsForDay(day)) {
                    System.out.println(booking.toString());
                }
            }
            else if (command.equals("Q")) {
                cont = false;
            }
        }
    }
}



