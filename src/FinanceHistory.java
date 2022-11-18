import java.io.*;
import java.util.Formatter;
import java.util.Scanner;
public class FinanceHistory {
    private Scanner input;

    public static void main(String args[]) throws IOException {

       FinanceHistory files = new FinanceHistory(); //object of this class


        //file.readString();
        files.writeFile();
    }

    public void readString(String str){
     String[] array=str.split("Order:");
     String orderSummary=array[0];
     String orderDetails=array[1];

    }



    public void writeFile() throws IOException{
        try{
            Formatter output = new Formatter("Output2.txt");
            // output.format("Bedrock exam %s\n", description);

             output.close();
             System.out.println("Created Output2 text");
        }
        catch(FileNotFoundException a){
            System.err.println("Unable to create file: Output2.txt");
        }

    }
}


