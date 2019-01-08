package wakkenspel;

import javax.swing.*;
import java.awt.*;

public class Dice extends JPanel {
    private int dots, holes;

    //Paint backgrounds and dice
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(new Color(114,137,218));
        g.fillRect(0,0,75,75);
        //paint dice background
        if(dots >= 1){
            g.setColor(Color.white);
            g.fillRoundRect(0,0,70,70,25,25);
            g.setColor(Color.black);
            g.drawRoundRect(0,0,70,70,25,25);
        }
        else{
            JOptionPane.showMessageDialog(null, "Voer een geldige hoeveelheid dobbelstenen in.", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        //fill dice with dots
        switch (dots){
            case 1:
                g.fillOval(15,15,10,10);
                break;
            case 2:
                g.fillOval(15,15,10,10);
                g.fillOval(45,45,10,10);
                break;
            case 3:
                g.fillOval(15,15,10,10);
                g.fillOval(30,30,10,10);
                g.fillOval(45,45,10,10);
                break;
            case 5:
                g.fillOval(15,15,10,10);
                g.fillOval(45,15,10,10);
                g.fillOval(15,45,10,10);
                g.fillOval(45,45,10,10);
                g.fillOval(30,30,10,10);
                break;
            case 6:
                g.fillOval(15,15,10,10);
                g.fillOval(45,15,10,10);
                g.fillOval(15,45,10,10);
                g.fillOval(45,45,10,10);
                g.fillOval(15,30,10,10);
                g.fillOval(45,30,10,10);
                break;
        }
    }
        //Roll the dice!
        //make it an int, 6 because 6 dots, +1 because otherwise the max would be 5
        public int roll(){
            dots = (int)(6*Math.random()+1);
            return dots;
        }

        public int holeSolution(){
        holes = 0;
        if(dots ==1 || dots ==3 || dots ==5){
            holes = 1;
        }
        return holes;
        }

        //get the polar bears
        public int bearSolution(){
            if(holes == 3){
                return 2;
            }
            else if(holes == 5){
                return 4;
            }
            else{
                return 0;
            }
        }
        //get the pinguins
        public int pingSolution() {
            if(holes == 2){
                return 2;
            }
            else if(holes == 4){
                return 4;
            }
            else if(holes == 6){
                return 6;
            }
            else {
                return 0;
            }
    }

    public void reset(){
        holes=0;
    }
}