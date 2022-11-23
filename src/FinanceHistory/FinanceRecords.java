package FinanceHistory;

import java.io.*;
import java.util.ArrayList;

public class FinanceRecords {//

    private static ArrayList<BookingHistory> bookings;

    public static void main(String args[]) throws IOException {
        FinanceRecords files = new FinanceRecords(); //object of this class


        files.readFile();
        files.writeFile();

        ViewEarnings earnings = new ViewEarnings();
        earnings.setBookings(bookings );
        earnings.start();
    }

    public void readFile() {
        String path = "bookingsRecord.csv";
        String str = "";
        bookings=new  ArrayList<BookingHistory>();
        try {
            //scan file format- Date, Time, Name, Group size, Phone number, Comments

            BookingHistory bh;
            BufferedReader br = new BufferedReader(new FileReader(path));
            int lineIndex=0;
            while ((str = br.readLine()) != null) {
                lineIndex++;
                if (lineIndex != 1) {
                    String[] details = str.split(", ");
                    bh = new BookingHistory(details[0] + " " + details[1] + " " + details[2]+ " " + details[4]);
                    bookings.add(bh);

                }
            }
        } catch (FileNotFoundException f) { //catch fileReader fileNotFound
            f.printStackTrace();
        } catch (IOException i) {
            i.printStackTrace();
        }
//        //Uncomment this to add a second date into bookings so for to see if viewing multiple dates works.
//        BookingHistory egBooking = new BookingHistory("2022-12-24 09:30 Ronan 12345678910");
//        bookings.add(egBooking);


    }



    public void writeFile() throws FileNotFoundException {

        File output = new File("RecordsFinance.csv");
        PrintWriter write = new PrintWriter(output);

        write.print("Date, time, Name, phoneNumber, FinalBill\n");

        for(int a=0;a<bookings.size();a++){
            write.printf("%s, %s, %s, %s, %s\n",
                    bookings.get(a).getDay(), bookings.get(a).getBookingTime(),
                    bookings.get(a).getName(), bookings.get(a).getPhoneNumber(), bookings.get(a).getFinalBill() );

        }
        write.close();


    }
}

