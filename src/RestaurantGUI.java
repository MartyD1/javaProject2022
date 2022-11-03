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
    //Declaring instance variables for x and y pos
    private int xPos=100;
    private int yPos=100;
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);



        // background
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0,0,screenWidth,screenLength);

        //tables
        for(int i=1; i<=12;i++) {
            JButton table = new JButton("Table" + i);
            table = new JButton("Table" + i);
            if(i<5) {
               table.setBounds(xPos * i *3, yPos, tablewidth, tablelength);
            }
            table.setBackground(Color.GREEN);
            add(table);
            if((i>=5)&&(i<9)){
               table = new JButton("Table" + (i));
               table.setBounds(xPos*(i-4) *3 , yPos*3, tablewidth, tablelength);
            }
            table.setBackground(Color.GREEN);
            add(table);
            if(i>=9){

                table = new JButton("Table" + ( i));
                table.setBounds(xPos*(i-8)*3 , yPos * 5, tablewidth, tablelength * 2);

            }
            table.setBackground(Color.GREEN);
            add(table);
        }

    }

    public static void main(String args[]){
        JFrame frame = new JFrame("RestaurantGUI");

       RestaurantGUI layoutPanel= new RestaurantGUI();

        frame.add(layoutPanel);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); //maximise window
        frame.setVisible(true);//display frame
    }
        }