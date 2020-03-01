package mackansw.spammer;

import javax.swing.*;
import java.awt.*;

public class Spammer {

    //Image resource, only needs to be declared once and then added by each buildGui window
    private ImageIcon cow = new ImageIcon(new ImageIcon(getClass().getResource("cow.jpg")).getImage().getScaledInstance(420, 205, Image.SCALE_DEFAULT));

    //Returns the windows X and Y coordinates on screen
    private int screenX, screenY;

    //Returns the amount of windows that should be opened
    private int amount;

    /**
     * Constructor with amount parameter
      * @param amount how many windows that should be opened
     */
    public Spammer (int amount) {
        this.amount = amount;
        for(int i = 0; i < this.amount; i++) {
            buildGui(screenX, screenY);
            screenX+=10;
            screenY+=5;
        }
    }

    /**
     * Builds a window when called
     * @param posX the windows X coordinate
     * @param posY the windows Y coordinate
     */
    private void buildGui(int posX, int posY) {
        JFrame window = new JFrame("Kohagen anfaller!");
        window.setResizable(false);
        window.setSize(450,280);
        window.setLocation(posX,posY);
        window.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        JPanel background = new JPanel();
        background.setBackground(Color.darkGray);

        JLabel imageContainer = new JLabel(cow);
        background.add(imageContainer);

        JButton surrender = new JButton("Ge upp!");
        background.add(surrender);
        surrender.setBackground(Color.gray);
        surrender.setForeground(Color.white);
        surrender.addActionListener(e -> {
            new Spammer(amount);
        });

        //adds background panel and makes window visible after panel has added its child components
        window.add(background);
        window.setVisible(true);
    }

    /**
     * Main method
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        switch(args.length) {
            case 1:
                new Spammer(Integer.valueOf(args[0]));
                break;
            default:
                new Spammer(10000);
                break;
        }
    }
}