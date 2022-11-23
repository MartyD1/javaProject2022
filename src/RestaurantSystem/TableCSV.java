package RestaurantSystem;

import CSV.GeneralCSV;
import java.io.*;

public class TableCSV extends GeneralCSV {


    public static void createTableCSV(Table table) {
        try {
            File tableRecord = new File("table.csv");
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tableRecord, true), "UTF-8"));
            //append = true so it doesn't overwrite, just add (append) to the comma separated value file

            if (tableRecord.length() == 0 ) {
                bw.write("TableNumber, NumOfSeats");        // if the CSV is empty it will create the header line
                bw.newLine();
            }
            StringBuffer line = new StringBuffer();
            line.append(Table.getTableNumber());
            line.append(", ");
            line.append(Table.getTableNoOfSeats());


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



}

