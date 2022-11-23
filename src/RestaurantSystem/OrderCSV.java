package RestaurantSystem;

import CSV.GeneralCSV;

import java.io.*;

public class  OrderCSV extends GeneralCSV {
    public static void createOrderCSV(FoodItem foodItem) {
        try {
            File orderRecord = new File("orderRecord.csv");
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(orderRecord, true), "UTF-8"));

            if (orderRecord.length() == 0 ) {
                bw.write("Type, Name, Description, Price");
                bw.newLine();
            }
            StringBuffer line = new StringBuffer();
            line.append(foodItem.getType());
            line.append(", ");
            line.append(foodItem.getName());
            line.append(", ");
            line.append(foodItem.getDescription());
            line.append(", ");
            line.append(foodItem.getPrice());

            bw.write(line.toString());
            bw.newLine();

            bw.flush();
            bw.close();
        } catch (UnsupportedEncodingException e) {
            System.out.println(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}