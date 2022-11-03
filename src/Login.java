import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class Login implements ActionListener {



    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JTextField userField = new JTextField();
    JPasswordField passField = new JPasswordField();
    JLabel userFieldLabel = new JLabel("Username");
    JLabel passFieldLabel = new JLabel("Password");
    JLabel messageLabel = new JLabel("Enter YUM login details:");


    HashMap<String, String> loginInformation = new HashMap<String, String>();

    /* Receive the hashmap as a parameter,
     create a copy of our hashmap to be accessible
     by the rest of the class */
    Login(HashMap<String, String> loginCopy){

        loginInformation = loginCopy;

        userFieldLabel.setBounds(50, 100, 75, 25);
        passFieldLabel.setBounds(50, 150, 75, 25);
        messageLabel.setBounds(125, 65, 250, 35);
        userField.setBounds(125,100,200,25);
        passField.setBounds(125,150,200,25);

        loginButton.setBounds(175, 190, 75, 25);
        loginButton.addActionListener(this);

        resetButton.setBounds( 250, 190, 75, 25);
        resetButton.addActionListener(this);



        frame.add(userFieldLabel);
        frame.add(passFieldLabel);
        frame.add(messageLabel);
        frame.add(userField);
        frame.add(passField);
        frame.add(loginButton);
        frame.add(resetButton);


        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(null);
        frame.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==resetButton){
            userField.setText("");
            passField.setText("");
        }

        if(e.getSource()==loginButton){

            String userID = userField.getText();
            String password = String.valueOf(passField.getPassword());  // uses this method to get password from a JPassword Field

            if(loginInformation.containsKey(userID)){
                if(loginInformation.get(userID).equals(password)){
                    messageLabel.setForeground(Color.green);
                    messageLabel.setText("Login Success");

                    frame.dispose();
                    mainMenu mMenu = new mainMenu(userID);

                }
                else {
                    messageLabel.setForeground(Color.red);
                    messageLabel.setText("Incorrect Credentials, Try again");

                }
            } else {
                messageLabel.setForeground(Color.ORANGE);
                messageLabel.setText("Incorrect Username");
            }


        }

    }
}
