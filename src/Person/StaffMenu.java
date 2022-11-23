package Person;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

import static CSV.GeneralCSV.clearCSV;
import static CSV.GeneralCSV.readCSV;
import static Person.PersonCSV.createPersonCSV;
import static Person.PersonCSV.getChosenStaff;

public class StaffMenu {

    private Scanner in;

    public StaffMenu() { in = new Scanner(System.in); }

    public void StaffRun() throws IOException {
        boolean cont = true;

        while (cont) {
            System.out.println("A)dd a staff member\nR)emove a staff member\nS)how staff members\nQ)uit system");
            String command = in.nextLine().toUpperCase();

            if (command.equals("A")) {
                System.out.println("Enter name: ");
                String name = in.nextLine();

                System.out.println("Enter role: ");
                String role = in.nextLine();

                System.out.println("Enter login details: ");
                String login = in.nextLine();

                System.out.println("Enter password");
                String password = in.nextLine();

                System.out.println();

                Staff staff = new Staff(name, role, login, password);
                createPersonCSV(staff);

            }
            else if (command.equals("R")) {
                System.out.println("\nEnter staff role to remove: ");
                String role = in.nextLine();

                ArrayList<String> allStaff = readCSV("peopleRecord.csv");
                ArrayList<String> choices = getChosenStaff(role);

                String removeStaff = getChoice(choices);
                if (removeStaff != null) {
                    allStaff.remove(removeStaff);
                }

                clearCSV("peopleRecord.csv");

                for (int i = 0; i < allStaff.size(); i++) {
                    Staff tempStaff = new Staff(allStaff.get(i));
                    createPersonCSV(tempStaff);
                }
            }
            else if (command.equals("S")) {
                System.out.println("Enter desired role to view: ");
                String role = in.nextLine();
                ArrayList<String> chosenStaff = getChosenStaff(role);

                for (int i = 0; i < chosenStaff.size(); i++) {
                    System.out.println(chosenStaff.get(i));
                }
            }
            else if (command.equals("Q")) {
                cont = false;
            }
        }
    }

    private String getChoice(ArrayList<String> choices) {
        if (choices.size() == 0) return null;
        while (true) {
            char c = 'A';
            for (String choice : choices) {
                System.out.println(c + ") " + choice);
                c++;
            }
            String input = in.nextLine();
            int n = input.toUpperCase().charAt(0) - 'A';
            if (0 <= n && n < choices.size())
                return choices.get(n);
        }
    }
}
