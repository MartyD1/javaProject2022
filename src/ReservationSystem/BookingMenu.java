package ReservationSystem;

import java.awt.print.Book;
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
                String numberOfGuests = in.nextLine();

                System.out.println("Phone number: ");
                String phoneNumber = in.nextLine();

                System.out.println("Special comments: ");
                String comments = in.nextLine();

                System.out.println();

                Booking booking = new Booking(d, t, nameString, numberOfGuests, phoneNumber, comments);
                calendar.add(booking);

                System.out.println(booking);

            }
            else if (command.equals("C")) {
                System.out.println("\nEnter booking details to cancel: ");
                System.out.println("""
                                    Enter date:
                                    (yyyy-mm-dd)""");
                String line = in.nextLine();
                BookingDate cancelDate = new BookingDate(line);

                Booking cancelBooking = getChoice(calendar.getBookingsForDay(cancelDate));
                if (cancelBooking != null)
                    calendar.cancel(cancelBooking);
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

    private Booking getChoice(ArrayList<Booking> choices) {
        if (choices.size() == 0) return null;
        while (true) {
            char c = 'A';
            for (Booking choice : choices) {
                System.out.println(c + ") \n" + choice.toString());
                c++;
            }
            String input = in.nextLine();
            int n = input.toUpperCase().charAt(0) - 'A';
            if (0 <= n && n < choices.size())
                return choices.get(n);
        }
    }
}