package Person;
//imports
import CSV.GeneralCSV;
import java.io.*;
import java.util.ArrayList;

/**
 * class extends GeneralCSV to construct a PersonCSV
 */
public class PersonCSV extends GeneralCSV {


    /**
     * Method creates/adds to a CSV to store data on People objects
     * @param person    Person object
     */
    public static void createPersonCSV(Person person) {
        try {
            File peopleRecord = new File("peopleRecord.csv");
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(peopleRecord, true), "UTF-8"));

            if (peopleRecord.length() == 0 ) {
                bw.write("Name");
                bw.newLine();
            }
            StringBuffer line = new StringBuffer();
            line.append(person.getName());

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

    /**
     * Method creates/adds to a CSV to store data on Staff objects
     * @param staff     Staff object
     */
    public static void createPersonCSV(Staff staff) {
        try {
            File peopleRecord = new File("peopleRecord.csv");
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(peopleRecord, true), "UTF-8"));

            if (peopleRecord.length() == 0 ) {
                bw.write("Name, Role, Login, Password");
                bw.newLine();
            }
            StringBuffer line = new StringBuffer();
            line.append(staff.getName());
            line.append(", ");
            line.append(staff.getRole());
            line.append(", ");
            line.append(staff.getLoginDetails());
            line.append(", ");
            line.append(staff.getPassword());


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

    /**
     * Method to iterate through Staff CSV and return specific type of Staff
     * @param role  the specified role (Server/Chef/Manager)
     * @return      ArrayList containing Staff of specified role
     */
    public static ArrayList<String> getChosenStaff(String role) {
        ArrayList<String> chosenStaff = new ArrayList<>();
        try {
            String path = "peopleRecord.csv";
            String line = "";

            BufferedReader br = new BufferedReader(new FileReader(path));

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                for (int i = 0; i < data.length; i++) {

                    if ((data[i].trim()).equals(role)) {
                        chosenStaff.add(line);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return chosenStaff;
    }
}
