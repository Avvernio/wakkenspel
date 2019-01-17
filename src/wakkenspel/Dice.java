package wakkenspel;

import javax.swing.*;
import java.awt.*;

public class Dice extends JPanel {
    private int side;

    //Paint backgrounds and dice
    public void drawDice(Graphics g, int x, int y) {
        //paint dice background
        if (side >=1) {
            g.setColor(Color.WHITE);
            g.fillRoundRect(x, y, 70, 70, 25, 25);
            g.setColor(Color.BLACK);
            g.drawRoundRect(x, y, 70, 70, 25, 25);

            //fill dice with dots
            switch (side) {
                case 1:
                    g.fillOval((x+30), (y+30), 10, 10);
                    break;
                case 2:
                    g.fillOval((x+15), (y+15), 10, 10);
                    g.fillOval((x+45), (y+45), 10, 10);
                    break;
                case 3:
                    g.fillOval((x+15), (y+15), 10, 10);
                    g.fillOval((x+30), (y+30), 10, 10);
                    g.fillOval((x+45), (y+45), 10, 10);
                    break;
                case 4:
                    g.fillOval((x+15), (y+15), 10, 10);
                    g.fillOval((x+45), (y+15), 10, 10);
                    g.fillOval((x+15), (y+45), 10, 10);
                    g.fillOval((x+45), (y+45), 10, 10);
                    break;
                case 5:
                    g.fillOval((x+15), (y+15), 10, 10);
                    g.fillOval((x+45), (y+15), 10, 10);
                    g.fillOval((x+15), (y+45), 10, 10);
                    g.fillOval((x+45), (y+45), 10, 10);
                    g.fillOval((x+30), (y+30), 10, 10);
                    break;
                case 6:
                    g.fillOval((x+15), (y+15), 10, 10);
                    g.fillOval((x+45), (y+15), 10, 10);
                    g.fillOval((x+15), (y+45), 10, 10);
                    g.fillOval((x+45), (y+45), 10, 10);
                    g.fillOval((x+15), (y+30), 10, 10);
                    g.fillOval((x+45), (y+30), 10, 10);
                    break;
            }
        }
    }
    //make it an int, 6 because 6 dots, +1 because otherwise the max would be 5
    public void rollDice() {
        side = (int) (6 * Math.random() + 1);
    }

    public int holeSolution() {
        if (side == 1 || side == 3 || side == 5) {
            return 1;
        }
        else{
            return 0;
        }
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