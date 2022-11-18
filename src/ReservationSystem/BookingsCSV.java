package ReservationSystem;

import java.io.*;

public class BookingsCSV {



        public static void createBookingsCSV(BookingCalendar calendar) throws IOException {
            /* First attempt at writing objects to a CSV file */
        FileOutputStream fout = new FileOutputStream("BookingRecords.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fout);

        for(Booking booking : calendar.getBookings()) {
            oos.writeObject(booking);
        }
        oos.flush();
        oos.close();
    }


    /* Redundant method for now, may need later */
    private String fullString(Booking booking) {
        StringBuilder finalString = new StringBuilder();

        finalString.append(booking.getDate().toString());
        finalString.append(",");
        finalString.append(booking.getTime().toString());
        finalString.append(",");
        finalString.append(booking.getName());
        finalString.append(",");
        finalString.append(booking.getNumberOfPeople());
        finalString.append(",");
        finalString.append(booking.getPhoneNumber());
        finalString.append(",");
        finalString.append(booking.getComments());
        finalString.append("\n");

        return finalString.toString();
    }
}


