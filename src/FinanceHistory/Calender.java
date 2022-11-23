package FinanceHistory;//

import java.util.ArrayList;
public class Calender {
    private ArrayList<DetailsBooking> bookings;

    public Calender(){
        bookings=new ArrayList<>();
    }

    public void addBooking(DetailsBooking booking){
        bookings.add(booking);
    }

    public ArrayList<DetailsBooking> BookingsOnDay(String day){

        ArrayList<DetailsBooking> schedule =new ArrayList<>();

        for(int i=0;i<bookings.size();i++) {
            if (bookings.get(i).getDay().equals(day))
                schedule.add(bookings.get(i));
        }

        return schedule;

    }

//    public void showBooking(){  //uncomment and call in ViewEarnings to see all bookings added from scan.
//        //System.out.println("bookings.size(): "+bookings.size());
//        for(int i=0;i<bookings.size();i++)
//        System.out.println("bookings.get(i).toString() #"+(i)+": "+bookings.get(i).toString());
//
//    }

}