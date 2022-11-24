package RestaurantSystem;
//imports
import CSV.GeneralCSV;
import java.io.*;
import java.util.ArrayList;

//ordercsv extends generalCSV
public class  OrderCSV extends GeneralCSV {
    public static void createOrderCSV(Order order) {
        try {
            File orderRecord = new File("orderRecord.csv");
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(orderRecord, true), "UTF-8"));

            if (orderRecord.length() == 0 ) {
                bw.write("Name, Final bill");
                bw.newLine();
            }
            StringBuffer line = new StringBuffer();
            line.append(order.getName());
            line.append(", ");
            line.append(order.getFinalBill());

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

    public static ArrayList<String> getFoodType(String foodType) {
        ArrayList<String> chosenFoodType = new ArrayList<>();
        try {
            String path = "menuRecord.csv";
            String line = "";

            BufferedReader br = new BufferedReader(new FileReader(path));

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                for (int i = 0; i < data.length; i++) {

                    if (data[i].equals(foodType)) {
                        chosenFoodType.add(line);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return chosenFoodType;
    }
}