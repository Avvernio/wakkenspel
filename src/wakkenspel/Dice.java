package wakkenspel;

import javax.swing.*;
import java.awt.*;

public class Dice extends JPanel {
    private int side, holes;

    //Paint backgrounds and dice
//    public void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        g.setColor(new Color(114, 137, 218));
//        g.fillRect(0, 0, 75, 75);
//        System.out.println("We get in paintcomponent");
//
//        //paint dice background
//        if (dots != 0) {
//            System.out.println("Dots is higher then 1");
//            g.setColor(Color.WHITE);
//            g.fillRoundRect(0, 0, 70, 70, 25, 25);
//            g.setColor(Color.BLACK);
//            g.drawRoundRect(0, 0, 70, 70, 25, 25);
//        }
//        //fill dice with dots
//        switch (dots) {
//            case 1:
//                g.fillOval(15, 15, 10, 10);
//                break;
//            case 2:
//                g.fillOval(15, 15, 10, 10);
//                g.fillOval(45, 45, 10, 10);
//                break;
//            case 3:
//                g.fillOval(15, 15, 10, 10);
//                g.fillOval(30, 30, 10, 10);
//                g.fillOval(45, 45, 10, 10);
//                break;
//            case 5:
//                g.fillOval(15, 15, 10, 10);
//                g.fillOval(45, 15, 10, 10);
//                g.fillOval(15, 45, 10, 10);
//                g.fillOval(45, 45, 10, 10);
//                g.fillOval(30, 30, 10, 10);
//                break;
//            case 6:
//                g.fillOval(15, 15, 10, 10);
//                g.fillOval(45, 15, 10, 10);
//                g.fillOval(15, 45, 10, 10);
//                g.fillOval(45, 45, 10, 10);
//                g.fillOval(15, 30, 10, 10);
//                g.fillOval(45, 30, 10, 10);
//                break;
//        }
//        repaint();
//    }

    public void paintComponent(Graphics q){
        if(side != 0){
            q.setColor( Color.WHITE );
            q.fillRoundRect(0, 0, 70, 70, 20, 20);
            q.setColor( Color.BLACK );
            q.drawRoundRect(0, 0, 70, 70, 20, 20);
        }
        if (side == 1){
            q.fillOval(30, 30, 10, 10);
        }
        else if (side == 2){
            q.fillOval(15, 15, 10, 10);
            q.fillOval(45, 45, 10, 10);
        }
        else if (side == 3){
            q.fillOval(15, 15, 10, 10);
            q.fillOval(30, 30, 10, 10);
            q.fillOval(45, 45, 10, 10);
        }
        else if (side == 4){
            q.fillOval(15, 15, 10, 10);
            q.fillOval(45, 15, 10, 10);
            q.fillOval(15, 45, 10, 10);
            q.fillOval(45, 45, 10, 10);
        }
        else if (side == 5){
            q.fillOval(15, 15, 10, 10);
            q.fillOval(45, 15, 10, 10);
            q.fillOval(15, 45, 10, 10);
            q.fillOval(45, 45, 10, 10);
            q.fillOval(30, 30, 10, 10);
        }
        else if (side == 6){
            q.fillOval(15, 15, 10, 10);
            q.fillOval(45, 15, 10, 10);
            q.fillOval(15, 45, 10, 10);
            q.fillOval(45, 45, 10, 10);
            q.fillOval(15, 30, 10, 10);
            q.fillOval(45, 30, 10, 10);
        }
    }


    //Roll the dice!
    //make it an int, 6 because 6 dots, +1 because otherwise the max would be 5
    public void rollDice() {
        side = (int) (6 * Math.random() + 1);
        //return dots;
        System.out.println("Dots is: " + side);
        repaint();
        System.out.println("repaint rollDice");
    }

    public int sideSolution() {
        holes = 0;
        if (side == 1 || side == 3 || side == 5) {
            side = 1;
        }
        return side;
    }

    //get the polar bears
    public int bearSolution() {
        if (side == 3) {
            return 2;
        } else if (side == 5) {
            return 4;
        } else {
            return 0;
        }
    }

    //get the pinguins
    public int pingSolution() {
        if (side == 2) {
            return 2;
        } else if (side == 4) {
            return 4;
        } else if (side == 6) {
            return 6;
        } else {
            return 0;
        }
    }

    public void reset() {
        side = 0;
    }
}