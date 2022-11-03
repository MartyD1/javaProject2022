import javax.swing.*;

public class mainMenu {

    JFrame frame = new JFrame();


    mainMenu(String userID){

        JLabel text = new JLabel("Welcome " + userID);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        frame.setLayout(null);
        frame.setVisible(true);

        frame.add(text);

        text.setBounds(400, 300, 200, 30);
    }
}
