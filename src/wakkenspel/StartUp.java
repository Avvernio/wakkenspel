package wakkenspel;

import javax.swing.*;
import java.awt.*;


public class StartUp extends JFrame {

    public static void main(String args[]){
        String version = "1.0.0";

        JFrame frame = new StartUp();
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Wakkenspel | Versie " + version);
        JPanel panel = new Panel();
        frame.setContentPane(panel);
        frame.setVisible(true);
        centreWindow(frame);
    }

    //code from "https://stackoverflow.com/questions/144892/how-to-center-a-window-in-java"
    //centers the Frame
    //first set the frame.setSize, then the size of the primary display gets retrieved
    //and divided by 2. depending on the outcome it is given to use in frame.setLocation
    private static void centreWindow(Window frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }
}
/**
 * Created by Sijmen de Berg
 * 97041683
 */