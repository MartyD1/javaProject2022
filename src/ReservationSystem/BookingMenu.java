package ReservationSystem;

import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

import static ReservationSystem.BookingsCSV.*;

public class BookingMenu {
    private Scanner in; // takes user input

    /**
     * Constructs a new BookingMenu object
     */
    public BookingMenu() {
        in = new Scanner(System.in); // creates new Scanner object (keyboard)
    }

    public void run() throws IOException {
        boolean cont = true;
        BookingCalendar calendar = new BookingCalendar();
        while (cont) {
            System.out.println("A)dd booking\nC)ancel booking\nS)how booking\nQ)uit system");
            String command = in.nextLine().toUpperCase(); // if user inputs lowercase command, it will still be read

            if (command.equals("A")) {// add booking function follows
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
                createBookingsCSV(booking); // added booking to CSV file
                calendar.add(booking);
            }
            else if (command.equals("C")) {
                System.out.println("\nEnter booking details to cancel: ");
                System.out.println("""
                                    Enter date:
                                    (yyyy-mm-dd)""");
                String dateLine = in.nextLine();

                ArrayList<String> allBookings = readCSV("bookingsRecord.csv");
                ArrayList<String> choices = getBookingsForDay(dateLine);

                String cancelBooking = getChoice(choices);
                if (cancelBooking != null) {
                    allBookings.remove(cancelBooking);
                }

                clearCSV("bookingsRecord.csv");

                for (int i = 0; i < allBookings.size(); i++) {
                    Booking tempBooking = new Booking(allBookings.get(i));
                    createBookingsCSV(tempBooking);
                }
            }
            else if (command.equals("S")) {
                /* BookingsForDay now read from CSV file */
                System.out.println("""
                                    Display what date:
                                    (yyyy-mm-dd)""");
                String showDate = in.nextLine();
                ArrayList<String> bookingsForDay = getBookingsForDay(showDate);

                for (int i = 0; i < bookingsForDay.size(); i++) {
                    System.out.println(bookingsForDay.get(i));
                }
            }
            else if (command.equals("Q")) {
                cont = false;
            }
        }
    }

    private String getChoice(ArrayList<String> choices) {
        if (choices.size() == 0) return null;
        while (true) {
            char c = 'A';
            for (String choice : choices) {
                System.out.println(c + ") " + choice);
                c++;
            }
            String input = in.nextLine();
            int n = input.toUpperCase().charAt(0) - 'A';
            if (0 <= n && n < choices.size())
                return choices.get(n);
        }
    }
}
