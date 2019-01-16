package wakkenspel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel extends JPanel {
    //making JButtons variables
    private JButton roll, guess, reset, solve;
    //Making textfields variables
    private JTextField amount, ping, bear, hole, guesses, guessesRight, guessesWrong;
    //Making JLabel variables
    private JLabel amountLabel, pingLabel, bearLabel, holeLabel, guessesLabel, guessesRightLabel, guessesWrongLabel;
    //create dice variables
    private Dice dice1, dice2, dice3, dice4, dice5, dice6, dice7, dice8, dice9, dice10, dice11, dice12;
    //create int
    private int rollInt;

    //creating the panel
    public Panel() {
        setLayout(null);
        setBackground(new Color(255, 255, 145));

        //Filling the JButtons
        roll = new JButton("Roll Dice");
        guess = new JButton("Guess");
        reset = new JButton("Reset");
        solve = new JButton("Solve");

        //Filling the JTextfields
        amount = new JTextField("");
        ping = new JTextField("");
        bear = new JTextField("");
        hole = new JTextField("");
        guesses = new JTextField("0");
        guessesRight = new JTextField("0");
        guessesWrong = new JTextField("0");

        //filling the JLabels
        amountLabel = new JLabel("Amount of dice.");
        pingLabel = new JLabel("Guess the amount of pinguins.");
        bearLabel = new JLabel("Guess the amount of polarbears.");
        holeLabel = new JLabel("Guess the amount of holes.");
        guessesLabel = new JLabel("number of guesses.");
        guessesRightLabel = new JLabel("Correct guesses.");
        guessesWrongLabel = new JLabel("Guesses wrong.");


        dice1 = new Dice();
        dice2 = new Dice();
        dice3 = new Dice();
        dice4 = new Dice();
        dice5 = new Dice();
        dice6 = new Dice();
        dice7 = new Dice();
        dice8 = new Dice();
        dice9 = new Dice();
        dice10 = new Dice();
        dice11 = new Dice();
        dice12 = new Dice();

        //bounds for buttons
        roll.setBounds(255, 290, 100, 25);
        guess.setBounds(255, 370, 100, 25);
        solve.setBounds(255, 410, 100, 25);
        reset.setBounds(255, 450, 100, 25);

        //adding Handlers for buttons
        roll.addActionListener(new rollHandler());
        guess.addActionListener(new guessHandler());
        solve.addActionListener(new solveHandler());
        reset.addActionListener(new resetHandler());

        //bounds for labels
        amountLabel.setBounds(20, 290, 100, 25);
        pingLabel.setBounds(20, 370, 200, 25);
        bearLabel.setBounds(20, 410, 200, 25);
        holeLabel.setBounds(20, 450, 200, 25);
        guessesLabel.setBounds(400, 370, 200, 25);
        guessesRightLabel.setBounds(400, 410, 200, 25);
        guessesWrongLabel.setBounds(400, 450, 200, 25);

        //bounds for input fields
        amount.setBounds(215, 290, 30, 30);
        ping.setBounds(215, 370, 30, 30);
        bear.setBounds(215, 410, 30, 30);
        hole.setBounds(215, 450, 30, 30);
        guesses.setBounds(555, 370, 30, 30);
        guessesRight.setBounds(555, 410, 30, 30);
        guessesWrong.setBounds(555, 450, 30, 30);

        //adding buttons
        add(roll);
        add(guess);
        add(reset);
        add(solve);

        //disabling certain inputs and buttons
        guesses.setEditable(false);
        guessesWrong.setEditable(false);
        guessesRight.setEditable(false);
        guess.setEnabled(false);
        solve.setEnabled(false);
        reset.setEnabled(false);

        //adding labels
        add(amountLabel);
        add(pingLabel);
        add(bearLabel);
        add(holeLabel);
        add(guessesLabel);
        add(guessesRightLabel);
        add(guessesWrongLabel);

        //adding input fields
        add(amount);
        add(ping);
        add(bear);
        add(hole);
        add(guesses);
        add(guessesRight);
        add(guessesWrong);

    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        System.out.println("test");

        g.setColor(Color.GRAY);
        g.fillRect(0, 275, 800, 450);

        g.setColor(new Color(153,170,181));
        g.fillRect(0, 530, 800, 35);

        g.setColor(new Color(44,47,51));
        g.setFont(new Font("SansSerif", Font.BOLD, 25));
        g.drawString("Het Wakkenspel", 300, 30);
    }

    class rollHandler implements ActionListener {
        public void actionPerformed(ActionEvent e){
            String amountString = amount.getText();

            try{
                rollInt = Integer.parseInt(amountString);
                if(rollInt < 3 || rollInt > 12) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number higher or equal then 3 and lower or equal to 12");
                }else{
                    roll(rollInt);
                }
            }
            catch(NumberFormatException ex){
                amount.setText("");
                JOptionPane.showMessageDialog(null, "Please enter a valid number higher or equal then 3 and lower or equal to 12/ catch failed");
            }
        }
    }
    private void roll(int rollInt){
        //enabling buttons guess, solve & reset.
        //disabling roll
        //disable editing amount input field.
        guess.setEnabled(true);
        solve.setEnabled(true);
        reset.setEnabled(true);
        roll.setEnabled(false);
        amount.setEditable(false);

            switch (rollInt){
            case 3:
                dice1.setBounds(115, 70, 72, 72);
                dice2.setBounds(0,0,72,72);
                dice3.setBounds(0,0,72,72);
                dice4.setBounds(0, 0, 72, 72);
                dice5.setBounds(0, 0, 72, 72);
                dice6.setBounds(0, 0, 72, 72);
                dice7.setBounds(0, 0, 72, 72);
                dice8.setBounds(0, 0, 72, 72);
                dice9.setBounds(0, 0, 72, 72);
                dice10.setBounds(0, 0, 72, 72);
                dice11.setBounds(0, 0, 72, 72);
                dice12.setBounds(0, 0, 72, 72);

                dice1.rollDice();
                break;

                case 4:
                    dice1.setBounds(115, 70, 72, 72);
                    dice2.setBounds(215,70,72,72);
                    dice3.setBounds(315,70,72,72);
                    dice4.setBounds(415, 70, 72, 72);
                    dice5.setBounds(0, 0, 72, 72);
                    dice6.setBounds(0, 0, 72, 72);
                    dice7.setBounds(0, 0, 72, 72);
                    dice8.setBounds(0, 0, 72, 72);
                    dice9.setBounds(0, 0, 72, 72);
                    dice10.setBounds(0, 0, 72, 72);
                    dice11.setBounds(0, 0, 72, 72);
                    dice12.setBounds(0, 0, 72, 72);

                    dice1.rollDice();
                    dice2.rollDice();
                    dice3.rollDice();
                    dice4.rollDice();
                    break;

                case 5:
                    dice1.setBounds(115, 70, 72, 72);
                    dice2.setBounds(215,70,72,72);
                    dice3.setBounds(315,70,72,72);
                    dice4.setBounds(415, 70, 72, 72);
                    dice5.setBounds(515, 70, 72, 72);

                    dice1.rollDice();
                    dice2.rollDice();
                    dice3.rollDice();
                    dice4.rollDice();
                    dice5.rollDice();
                    break;

                case 6:
                    dice1.setBounds(115, 70, 72, 72);
                    dice2.setBounds(215,70,72,72);
                    dice3.setBounds(315,70,72,72);
                    dice4.setBounds(415, 70, 72, 72);
                    dice5.setBounds(515, 70, 72, 72);
                    dice6.setBounds(615, 70, 72, 72);

                    dice1.rollDice();
                    dice2.rollDice();
                    dice3.rollDice();
                    dice4.rollDice();
                    dice5.rollDice();
                    dice6.rollDice();
                    break;

                case 7:
                    dice1.setBounds(115, 70, 72, 72);
                    dice2.setBounds(215,70,72,72);
                    dice3.setBounds(315,70,72,72);
                    dice4.setBounds(415, 70, 72, 72);
                    dice5.setBounds(515, 70, 72, 72);
                    dice6.setBounds(615, 70, 72, 72);
                    dice7.setBounds(115, 140, 72, 72);

                    dice1.rollDice();
                    dice2.rollDice();
                    dice3.rollDice();
                    dice4.rollDice();
                    dice5.rollDice();
                    dice6.rollDice();
                    dice7.rollDice();
                    break;

                case 8:
                    dice1.setBounds(115, 70, 72, 72);
                    dice2.setBounds(215,70,72,72);
                    dice3.setBounds(315,70,72,72);
                    dice4.setBounds(415, 70, 72, 72);
                    dice5.setBounds(515, 70, 72, 72);
                    dice6.setBounds(615, 70, 72, 72);
                    dice7.setBounds(115, 140, 72, 72);
                    dice8.setBounds(215, 140, 72, 72);

                    dice1.rollDice();
                    dice2.rollDice();
                    dice3.rollDice();
                    dice4.rollDice();
                    dice5.rollDice();
                    dice6.rollDice();
                    dice7.rollDice();
                    dice8.rollDice();
                    break;

                case 9:
                    dice1.setBounds(115, 70, 72, 72);
                    dice2.setBounds(215,70,72,72);
                    dice3.setBounds(315,70,72,72);
                    dice4.setBounds(415, 70, 72, 72);
                    dice5.setBounds(515, 70, 72, 72);
                    dice6.setBounds(615, 70, 72, 72);
                    dice7.setBounds(115, 140, 72, 72);
                    dice8.setBounds(215, 140, 72, 72);
                    dice9.setBounds(315, 140, 72, 72);

                    dice1.rollDice();
                    dice2.rollDice();
                    dice3.rollDice();
                    dice4.rollDice();
                    dice5.rollDice();
                    dice6.rollDice();
                    dice7.rollDice();
                    dice8.rollDice();
                    dice9.rollDice();
                    break;

                case 10:
                    dice1.setBounds(115, 70, 72, 72);
                    dice2.setBounds(215,70,72,72);
                    dice3.setBounds(315,70,72,72);
                    dice4.setBounds(415, 70, 72, 72);
                    dice5.setBounds(515, 70, 72, 72);
                    dice6.setBounds(615, 70, 72, 72);
                    dice7.setBounds(115, 140, 72, 72);
                    dice8.setBounds(215, 140, 72, 72);
                    dice9.setBounds(315, 140, 72, 72);
                    dice10.setBounds(415, 140, 72, 72);

                    dice1.rollDice();
                    dice2.rollDice();
                    dice3.rollDice();
                    dice4.rollDice();
                    dice5.rollDice();
                    dice6.rollDice();
                    dice7.rollDice();
                    dice8.rollDice();
                    dice9.rollDice();
                    dice10.rollDice();
                    break;

                case 11:
                    dice1.setBounds(115, 70, 72, 72);
                    dice2.setBounds(215,70,72,72);
                    dice3.setBounds(315,70,72,72);
                    dice4.setBounds(415, 70, 72, 72);
                    dice5.setBounds(515, 70, 72, 72);
                    dice6.setBounds(615, 70, 72, 72);
                    dice7.setBounds(115, 140, 72, 72);
                    dice8.setBounds(215, 140, 72, 72);
                    dice9.setBounds(315, 140, 72, 72);
                    dice10.setBounds(415, 140, 72, 72);
                    dice11.setBounds(515, 140, 72, 72);

                    dice1.rollDice();
                    dice2.rollDice();
                    dice3.rollDice();
                    dice4.rollDice();
                    dice5.rollDice();
                    dice6.rollDice();
                    dice7.rollDice();
                    dice8.rollDice();
                    dice9.rollDice();
                    dice10.rollDice();
                    dice11.rollDice();
                    break;

                case 12:
                    dice1.setBounds(115, 70, 72, 72);
                    dice2.setBounds(215,70,72,72);
                    dice3.setBounds(315,70,72,72);
                    dice4.setBounds(415, 70, 72, 72);
                    dice5.setBounds(515, 70, 72, 72);
                    dice6.setBounds(615, 70, 72, 72);
                    dice7.setBounds(115, 140, 72, 72);
                    dice8.setBounds(215, 140, 72, 72);
                    dice9.setBounds(315, 140, 72, 72);
                    dice10.setBounds(415, 140, 72, 72);
                    dice11.setBounds(515, 140, 72, 72);
                    dice12.setBounds(615, 140, 72, 72);

                    dice1.rollDice();
                    dice2.rollDice();
                    dice3.rollDice();
                    dice4.rollDice();
                    dice5.rollDice();
                    dice6.rollDice();
                    dice7.rollDice();
                    dice8.rollDice();
                    dice9.rollDice();
                    dice10.rollDice();
                    dice11.rollDice();
                    dice12.rollDice();

            }
        repaint();
    }


    class resetHandler implements ActionListener{
        public void actionPerformed(ActionEvent e){

        }
    }

    class guessHandler implements ActionListener{
        public void actionPerformed(ActionEvent e){

        }
    }

    class solveHandler implements ActionListener{
        public void actionPerformed(ActionEvent e){

        }
    }
}
