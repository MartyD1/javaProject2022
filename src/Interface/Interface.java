package Interface;

import java.util.Scanner;

public class Interface {
    Scanner scan = new Scanner(System.in);
    Interface() {
        System.out.println();
        System.out.println("Are you a (C)ustomer, (S)taff or (M)anagement? ");
        String inputBefore = scan.nextLine();


    }
}
