package FinanceHistory;

public class CalenderTime {
    private int hours;
    private int minutes;

    public CalenderTime(String time) {
        String[] str = time.split(":");
        hours = Integer.parseInt(str[0]);
        minutes = Integer.parseInt(str[1]);
    }

    public String toString(){
        return hours+":"+minutes;
    }



}
