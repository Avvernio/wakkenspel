package wakkenspel;

import javax.swing.*;

public class StartUp extends JFrame {
    public static void main(String args[]){
        String version = "0.1";

        JFrame frame = new StartUp();
        frame.setSize(1000, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Wakkenspel | Versie " + version);
        JPanel panel = new Panel();
        frame.setContentPane(panel);
        frame.setVisible(true);
    }
}

/**
 * Created by Sijmen de Berg
 * 97041683
 */