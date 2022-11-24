package FinanceHistory;

import java.io.*;
import java.util.ArrayList;

public class SetFinanceRecords {

    private ArrayList<DetailsBooking> bookings;


    /**
     * Method to read two csv files to obtain information of booking information and final bill.
     * Passes information read into arraylist.
     */
    public void readFile() {
        String[] path = {"bookingsRecord.csv", "orderRecord.csv"};
        String str = "";
        bookings=new  ArrayList<DetailsBooking>();
       for(int pathNum=0;pathNum<path.length;pathNum++) {
           try {
               //scan file format- Date, Time, Name, Group size, Phone number, Comments

               DetailsBooking detailsBooking;
               BufferedReader br = new BufferedReader(new FileReader(path[pathNum]));
               int lineIndex = 0;
               while ((str = br.readLine()) != null) {
                   lineIndex++;
                   if (lineIndex != 1) {
                       String[] details = str.split(",");
                       for (int i = 0; i < details.length; i++) {
                           details[i] = details[i].trim();}

                           if (pathNum == 0) {
                               detailsBooking = new DetailsBooking(details[0] + " " + details[1] + " " + details[2] + " " + details[4]);
                           bookings.add(detailsBooking);
                       }
                           else if(pathNum==1){
                               String name=details[0];
                               double finalBill= Double.parseDouble(details[1]);

                               for(int a=0;a<bookings.size();a++){
                                if (name.equals(bookings.get(a).getName() ))
                               bookings.get(a).setFinalBill(finalBill);



                                }

                           }
                   }}
           } catch (FileNotFoundException f) { //catch fileReader fileNotFound
               f.printStackTrace();
           } catch (IOException i) {
               i.printStackTrace();
           }
       }
}


    /**
     * Method to write a csv file including information of each booking and final bill.
     * @throws FileNotFoundException
     */
    public void writeFile() throws FileNotFoundException {

        File output = new File("FinanceRecord.csv");
        PrintWriter write = new PrintWriter(output);

        write.print("Date, time, Name, phoneNumber, FinalBill\n");

        for(int a=0;a<bookings.size();a++){
            write.printf("%s, %s, %s, %s, %4.2f \n",
                    bookings.get(a).getDay(), bookings.get(a).getBookingTime(),
                    bookings.get(a).getName(), bookings.get(a).getPhoneNumber(), bookings.get(a).getFinalBill() );

        }
        write.close();


    }

    /**
     * Method to pass the data collected from csvs into viewEarnings to be processed/stored. Runs start method in Earnings.
     */
    public void runViewEarnings(){

        ViewEarnings earnings = new ViewEarnings();

        earnings.setBookings(bookings );
        earnings.start();


    }



}

