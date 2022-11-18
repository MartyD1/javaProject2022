package ReservationSystem;


import java.io.*;

public class BookingsCSV implements Serializable {



        public static void createBookingsCSV(Booking booking) throws IOException {

            /* Example code for basic CSV file creation */
//        FileWriter csvWriter = new FileWriter("BookingRecords.csv");
//        csvWriter.append("Date");
//        csvWriter.append(",");
//        csvWriter.append("Time");
//        csvWriter.append(",");
//        csvWriter.append("Name");
//        csvWriter.append(",");
//        csvWriter.append("Party size");
//        csvWriter.append(",");
//        csvWriter.append("Contact details");
//        csvWriter.append(",");
//        csvWriter.append("Comments");
//        csvWriter.append("\n");
//        for (Booking booking : bookings.getBookings()) {
//
//
//            csvWriter.append(String.join(",", booking.toString()));
//            csvWriter.append("\n");
//        }
//        csvWriter.flush();
//        csvWriter.close();
//    }


            /* First attempt at writing objects to a CSV file */
        FileOutputStream csvWriter = new FileOutputStream("BookingRecords.txt");
        ObjectOutputStream oos = new ObjectOutputStream(csvWriter);

        oos.writeObject(booking);
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


