package FinanceHistory;//

import java.io.*;
import java.util.ArrayList;

public class SetFinanceRecords {

    private ArrayList<DetailsBooking> bookings;

    public static void main(String args[]) throws IOException {
        SetFinanceRecords files = new SetFinanceRecords(); //object of this class


        files.readFile();
        files.writeFile();
        files.runViewEarnings();

    }

    public void readFile() {
        String path = "bookingsRecord.csv";
        String str = "";
        bookings=new  ArrayList<DetailsBooking>();
        try {
            //scan file format- Date, Time, Name, Group size, Phone number, Comments

            DetailsBooking db;
            BufferedReader br = new BufferedReader(new FileReader(path));
            int lineIndex=0;
            while ((str = br.readLine()) != null) {
                lineIndex++;
                if (lineIndex != 1) {
                    String[] details = str.split(",");
                    for(int i=0;i<details.length;i++){
                        details[i]=details[i].trim();
                    }
                    db = new DetailsBooking(details[0] + " " + details[1] + " " + details[2]+ " " + details[4]);
                    bookings.add(db);

                }
            }
        } catch (FileNotFoundException f) { //catch fileReader fileNotFound
            f.printStackTrace();
        } catch (IOException i) {
            i.printStackTrace();
        }


    }



    public void writeFile() throws FileNotFoundException {

        File output = new File("FinanceRecord.csv");
        PrintWriter write = new PrintWriter(output);

        write.print("Date, time, Name, phoneNumber, FinalBill\n");

        for(int a=0;a<bookings.size();a++){
            write.printf("%s, %s, %s, %s, %s\n",
                    bookings.get(a).getDay(), bookings.get(a).getBookingTime(),
                    bookings.get(a).getName(), bookings.get(a).getPhoneNumber(), bookings.get(a).getFinalBill() );

        }
        write.close();


    }

    public void runViewEarnings(){

        ViewEarnings earnings = new ViewEarnings();

        earnings.setBookings(bookings );
        earnings.start();

    }



}

