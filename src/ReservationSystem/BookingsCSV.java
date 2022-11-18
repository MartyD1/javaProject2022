package ReservationSystem;

import java.io.*;

public class BookingsCSV {

    public static void createBookingsCSV(BookingCalendar calendar) {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("bookingsRecord.csv"), "UTF-8"));

            bw.write("Date, Time, Name, Group size, Phone number, Comments");
            bw.newLine();

            for (Booking booking : calendar.getBookings()) {
                StringBuffer line = new StringBuffer();
                line.append(booking.getDate());
                line.append(", ");
                line.append(booking.getTime());
                line.append(", ");
                line.append(booking.getName());
                line.append(", ");
                line.append(booking.getNumberOfPeople());
                line.append(", ");
                line.append(booking.getPhoneNumber());
                line.append(", ");
                line.append(booking.getComments());

                bw.write(line.toString());
                bw.newLine();
            }
            bw.flush();
            bw.close();
        } catch (UnsupportedEncodingException e) {
            System.out.print(e);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void readBookingsCSV() {
        try {
            String path = "bookingsRecord.csv";
            String line = "";

            BufferedReader br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null ) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e ) {
            System.out.println(e);
        }
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



