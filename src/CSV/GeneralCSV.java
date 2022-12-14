package CSV;

import java.io.*;
import java.util.ArrayList;

public class GeneralCSV {

    /**
     * Method reads existing CSV file and returns the data in an ArrayList<String>
     *
     * @param path  the file path to write to
     * @return      an ArrayList of type String containing the rows of data
     */
    public static ArrayList<String> readCSV(String path) {
        ArrayList<String> rows = new ArrayList<>();
        try {
            String line = "";

            BufferedReader br = new BufferedReader(new FileReader(path));

            String headerLine = br.readLine();
            while ((line = br.readLine()) != null) {
                rows.add(line);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return rows;
    }

    /**
     * Method to clear a file and rewrite the header line
     *
     * @param path         the file path to write to
     * @throws IOException
     */
    public static void clearCSV(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        String headerLine = br.readLine();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path, false), "UTF-8"));
        bw.write(headerLine);
    }
}
