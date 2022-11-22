package RestaurantSystem;

import CSV.GeneralCSV;

import java.io.*;
import java.nio.Buffer;

public class MenuCSV extends GeneralCSV {
    public static void createMenuCSV(FoodItem foodItem) {
        try {
            File menuRecord = new File("menuRecord.csv");
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(menuRecord, true), "UTF-8"));

            if (menuRecord.length() == 0 ) {
                bw.write("Type, Name, Description, Price");
                bw.newLine();
            }
            StringBuffer line = new StringBuffer();
            line.append(foodItem.getType());
            line.append(",");
            line.append(foodItem.getName());
            line.append(",");
            line.append(foodItem.getDescription());
            line.append(",");
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
