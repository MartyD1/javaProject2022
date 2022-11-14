
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;

public class RestaurantGUI extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
// Declaring constants for restaurant layout
      int screenWidth = 3000;
      int screenLength = 2000;
        //Declaring instance variables for restaurant tables
       int tablewidth = 150;
    int tablelength = 100;
        //Declaring instance variables for x and y pos
       int xPos=100;
        int yPos=100;


        // background
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0,0,screenWidth,screenLength);

        //tables
        for(int i=1; i<=12;i++) {
            JButton table = new JButton("Table" + i);
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

    public static void main(String[] args){
        JFrame frame = new JFrame("RestaurantGUI");

       RestaurantGUI layoutPanel= new RestaurantGUI();

        frame.add(layoutPanel);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); //maximise window
        frame.setVisible(true);//display frame
    }
        }