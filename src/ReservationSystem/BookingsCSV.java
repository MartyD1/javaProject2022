package ReservationSystem;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class BookingsCSV {
    public static void createBookingsCSV(Booking booking) {
        try {
            File bookingsRecord = new File("bookingsRecord.csv");
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(bookingsRecord, true), "UTF-8"));

            if (bookingsRecord.length() == 0 ) {
                bw.write("Date, Time, Name, Group size, Phone number, Comments");
                bw.newLine();
            }
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

            bw.flush();
            bw.close();
        } catch (UnsupportedEncodingException e) {
            System.out.print(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static ArrayList<String> readBookingsCSV() {
        ArrayList<String> rows = new ArrayList<>();
        try {
            String path = "bookingsRecord.csv";
            String line = "";

            BufferedReader br = new BufferedReader(new FileReader(path));

            String headerLine = br.readLine();
            while ((line = br.readLine()) != null) {
                rows.add(line);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return rows;
    }

    public static void clearCSV() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("bookingsRecord.csv", false), "UTF-8"));
        bw.write("Date, Time, Name, Group size, Phone number, Comments");
    }

    public static ArrayList<String> getBookingsForDay(String lineDate) {
        ArrayList<String> bookingsForDay = new ArrayList<>();
        try {
            String path = "bookingsRecord.csv";
            String line = "";

            BufferedReader br = new BufferedReader(new FileReader(path));

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                for (int i = 0; i < data.length; i++) {

                    if (data[i].equals(lineDate)) {
                        bookingsForDay.add(line);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return bookingsForDay;
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

