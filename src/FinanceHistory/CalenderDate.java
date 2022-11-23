package FinanceHistory;

public class CalenderDate {//
    private int year;
    private int month;
    private int day;

    public CalenderDate(String date){
        String[] str=date.split("-");
        day=Integer.parseInt( str[2] );
        month=Integer.parseInt( str[1] );
        year=Integer.parseInt( str[0] );
    }

    public String toString(){

        return year+"-"+month+"-"+day;

    }
}