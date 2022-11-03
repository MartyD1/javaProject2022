import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;

public class RestaurantGUI extends JPanel {
// Declaring constants for restaurant layout
    private final int screenWidth = 3000;
    private final int screenLength = 2000;
    //Declaring instance variables for restaurant tables
    private  int tablewidth = 150;
    private  int tablelength = 100;
    //Decalring instance variables for x and y pos
    private int xPos=100;
    private int yPos=100;
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);



        // background
        g.setColor(Color.BLACK);
        g.fillRect(0,0,screenWidth,screenLength);

        //tables
        for(int i=1; i<=5;i++){
            g.setColor(Color.GREEN);
            g.fillRect(xPos * 3*i, yPos, tablewidth, tablelength);
        }

        JButton table1= new JButton("Table 1");
        table1.setBounds(xPos*3,yPos,tablewidth-20,tablelength-20);
        add(table1);


    }

    public static void main(String args[]){
        JFrame frame = new JFrame("RestaurantGUI");

       RestaurantGUI layoutPanel= new RestaurantGUI();

        frame.add(layoutPanel);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); //maximise window
        frame.setVisible(true);//display frame
    }
}