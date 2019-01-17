package wakkenspel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel extends JPanel {
    //making JButtons variables
    private JButton roll, guess, reset, solve, help;
    //Making textfields variables
    private JTextField amount, ping, bear, hole, guesses, guessesRight, guessesWrong;
    //Making JLabel variables
    private JLabel amountLabel, pingLabel, bearLabel, holeLabel, guessesLabel, guessesRightLabel, guessesWrongLabel, madeBy;
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
        help = new JButton("Help");

        //Filling the JTextfields
        amount = new JTextField("");
        ping = new JTextField("");
        bear = new JTextField("");
        hole = new JTextField("");
        guesses = new JTextField("0");
        guessesRight = new JTextField("0");
        guessesWrong = new JTextField("0");
        ;

        //filling the JLabels
        amountLabel = new JLabel("Amount of dice.");
        pingLabel = new JLabel("Guess the amount of pinguins.");
        bearLabel = new JLabel("Guess the amount of polarbears.");
        holeLabel = new JLabel("Guess the amount of holes.");
        guessesLabel = new JLabel("number of guesses.");
        guessesRightLabel = new JLabel("Correct guesses.");
        guessesWrongLabel = new JLabel("Wrong guesses.");
        madeBy = new JLabel("Made By Sijmen de Berg");

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
        help.setBounds(50, 534, 100, 25);

        //instantiating Handlers for buttons
        roll.addActionListener(new rollHandler());
        guess.addActionListener(new guessHandler());
        solve.addActionListener(new solveHandler());
        reset.addActionListener(new resetHandler());
        help.addActionListener(new helpHandler());

        //bounds for labels
        amountLabel.setBounds(20, 290, 100, 25);
        pingLabel.setBounds(20, 370, 200, 25);
        bearLabel.setBounds(20, 410, 200, 25);
        holeLabel.setBounds(20, 450, 200, 25);
        guessesLabel.setBounds(400, 370, 200, 25);
        guessesRightLabel.setBounds(400, 410, 200, 25);
        guessesWrongLabel.setBounds(400, 450, 200, 25);
        madeBy.setBounds(200, 534, 200, 25);

        madeBy.setFont(new Font("Quicksand", Font.BOLD, 12));

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
        add(help);

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
        add(madeBy);

        //adding input fields
        add(amount);
        add(ping);
        add(bear);
        add(hole);
        add(guesses);
        add(guessesRight);
        add(guessesWrong);

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
    class resetHandler implements ActionListener{
        public void actionPerformed(ActionEvent e){

            //reset the dice values.
            dice1.reset();
            dice2.reset();
            dice3.reset();
            dice4.reset();
            dice5.reset();
            dice6.reset();
            dice7.reset();
            dice8.reset();
            dice9.reset();
            dice11.reset();
            dice12.reset();

            //enable and disable buttons.
            guess.setEnabled(false);
            solve.setEnabled(false);
            reset.setEnabled(false);
            roll.setEnabled(true);
            amount.setEditable(true);
            ping.setEditable(false);
            bear.setEditable(false);
            hole.setEditable(false);

            //empty fields
            amount.setText("");
            ping.setText("");
            bear.setText("");
            hole.setText("");

            //repaint the dice.
            repaint();
        }
    }
    class guessHandler implements ActionListener{
        public void actionPerformed(ActionEvent e){

            int[] array = getValues();
            if(Integer.parseInt(ping.getText()) == array[2] && Integer.parseInt(bear.getText()) == array[1] && Integer.parseInt(hole.getText()) == array[0]){
                JOptionPane.showMessageDialog(null, "Congrats you have answered correct.");

                ping.setText("");
                bear.setText("");
                hole.setText("");

                guesses.setText(String.valueOf(Integer.parseInt(guesses.getText())+1));
                guessesRight.setText(String.valueOf(Integer.parseInt(guessesRight.getText())+1));

                dice1.reset();
                dice2.reset();
                dice3.reset();
                dice4.reset();
                dice5.reset();
                dice6.reset();
                dice7.reset();
                dice8.reset();
                dice9.reset();
                dice10.reset();
                dice11.reset();
                dice12.reset();

                guess.setEnabled(false);
                solve.setEnabled(false);
                reset.setEnabled(false);
                roll.setEnabled(true);
                amount.setEditable(true);
                ping.setEditable(false);
                bear.setEditable(false);
                hole.setEditable(false);

                //empty fields
                amount.setText("");
                ping.setText("");
                bear.setText("");
                hole.setText("");

                repaint();
            }else{
                guessesWrong.setText(String.valueOf(Integer.parseInt(guessesWrong.getText())+1));

                JOptionPane.showMessageDialog(null, "Unfortunatly the asnwer was wrong.");
            }
        }
    }
    class solveHandler implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int solve = JOptionPane.showConfirmDialog(null,"Do you want to solve this game? WARNING pressing yes will get you 5 wrong guesses.","Solution",JOptionPane.YES_NO_OPTION);

            if(solve == 0){
                //Java magic, basically this gets,converts to an int and adds 1 or 5, and then converts back to a string from guessesWrong or guesses JTextFields.
                guessesWrong.setText(String.valueOf(Integer.parseInt(String.valueOf(guessesWrong.getText()))+5));

                //returns array [allHoles, allBears, allPings}
                int[] array = getValues();

                //fill in the JText fields so it can be properly solved.
                ping.setText(String.valueOf(array[2]));
                bear.setText(String.valueOf(array[1]));
                hole.setText(String.valueOf(array[0]));
            }
        }
    }
    class helpHandler implements ActionListener{
        public void actionPerformed(ActionEvent e){
            JOptionPane.showMessageDialog(null, "Press guess to check if your answer is correct.");
            JOptionPane.showMessageDialog(null,"Press solve to automatically solve the game (this gets you 5 wrong guesses.");
            JOptionPane.showMessageDialog(null,"Press reset to empty the playing field.");
            JOptionPane.showMessageDialog(null,"A dot in the middle means that there's a hole there.");
            JOptionPane.showMessageDialog(null,"Polar bears like to go near holes.");
            JOptionPane.showMessageDialog(null,"Pinguings dont like to go near Polar bears");
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
                dice1.rollDice();
                dice2.rollDice();
                dice3.rollDice();
                break;

                case 4:
                    dice1.rollDice();
                    dice2.rollDice();
                    dice3.rollDice();
                    dice4.rollDice();
                    break;

                case 5:
                    dice1.rollDice();
                    dice2.rollDice();
                    dice3.rollDice();
                    dice4.rollDice();
                    dice5.rollDice();
                    break;

                case 6:
                    dice1.rollDice();
                    dice2.rollDice();
                    dice3.rollDice();
                    dice4.rollDice();
                    dice5.rollDice();
                    dice6.rollDice();
                    break;

                case 7:
                    dice1.rollDice();
                    dice2.rollDice();
                    dice3.rollDice();
                    dice4.rollDice();
                    dice5.rollDice();
                    dice6.rollDice();
                    dice7.rollDice();
                    break;

                case 8:
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

        //Paint the dice
        switch(rollInt){
            case 3:

                dice1.drawDice(g, 115, 70);
                dice2.drawDice(g, 215, 70);
                dice3.drawDice(g, 315, 70);
                break;

            case 4:
                dice1.drawDice(g, 115, 70);
                dice2.drawDice(g, 215, 70);
                dice3.drawDice(g, 315, 70);
                dice4.drawDice(g, 415, 70);
                break;

            case 5:
                dice1.drawDice(g, 115, 70);
                dice2.drawDice(g, 215, 70);
                dice3.drawDice(g, 315, 70);
                dice4.drawDice(g, 415, 70);
                dice5.drawDice(g, 515, 70);
                break;

            case 6:
                dice1.drawDice(g, 115, 70);
                dice2.drawDice(g, 215, 70);
                dice3.drawDice(g, 315, 70);
                dice4.drawDice(g, 415, 70);
                dice5.drawDice(g, 515, 70);
                dice6.drawDice(g, 615, 70);
                break;

            case 7:
                dice1.drawDice(g, 115, 70);
                dice2.drawDice(g, 215, 70);
                dice3.drawDice(g, 315, 70);
                dice4.drawDice(g, 415, 70);
                dice5.drawDice(g, 515, 70);
                dice6.drawDice(g, 615, 70);
                dice7.drawDice(g, 115, 150);
                break;

            case 8:
                dice1.drawDice(g, 115, 70);
                dice2.drawDice(g, 215, 70);
                dice3.drawDice(g, 315, 70);
                dice4.drawDice(g, 415, 70);
                dice5.drawDice(g, 515, 70);
                dice6.drawDice(g, 615, 70);
                dice7.drawDice(g, 115, 150);
                dice8.drawDice(g, 215, 150);
                break;

            case 9:
                dice1.drawDice(g, 115, 70);
                dice2.drawDice(g, 215, 70);
                dice3.drawDice(g, 315, 70);
                dice4.drawDice(g, 415, 70);
                dice5.drawDice(g, 515, 70);
                dice6.drawDice(g, 615, 70);
                dice7.drawDice(g, 115, 150);
                dice8.drawDice(g, 215, 150);
                dice9.drawDice(g, 315, 150);
                break;

            case 10:
                dice1.drawDice(g, 115, 70);
                dice2.drawDice(g, 215, 70);
                dice3.drawDice(g, 315, 70);
                dice4.drawDice(g, 415, 70);
                dice5.drawDice(g, 515, 70);
                dice6.drawDice(g, 615, 70);
                dice7.drawDice(g, 115, 150);
                dice8.drawDice(g, 215, 150);
                dice9.drawDice(g, 315, 150);
                dice10.drawDice(g, 415, 150);
                break;

            case 11:
                dice1.drawDice(g, 115, 70);
                dice2.drawDice(g, 215, 70);
                dice3.drawDice(g, 315, 70);
                dice4.drawDice(g, 415, 70);
                dice5.drawDice(g, 515, 70);
                dice6.drawDice(g, 615, 70);
                dice7.drawDice(g, 115, 150);
                dice8.drawDice(g, 215, 150);
                dice9.drawDice(g, 315, 150);
                dice10.drawDice(g, 415, 150);
                dice11.drawDice(g, 515, 150);
                break;

            case 12:
                dice1.drawDice(g, 115, 70);
                dice2.drawDice(g, 215, 70);
                dice3.drawDice(g, 315, 70);
                dice4.drawDice(g, 415, 70);
                dice5.drawDice(g, 515, 70);
                dice6.drawDice(g, 615, 70);
                dice7.drawDice(g, 115, 150);
                dice8.drawDice(g, 215, 150);
                dice9.drawDice(g, 315, 150);
                dice10.drawDice(g, 415, 150);
                dice11.drawDice(g, 515, 150);
                dice12.drawDice(g, 615, 150);
                break;
        }
    }

    private int[] getValues(){

        int allHoles = (dice1.holeSolution()+dice2.holeSolution()+dice3.holeSolution()+dice4.holeSolution()+dice5.holeSolution()+dice6.holeSolution()+dice7.holeSolution()+dice8.holeSolution()+dice9.holeSolution()+dice10.holeSolution()+dice11.holeSolution()+dice12.holeSolution());
        int allBears = (dice1.bearSolution()+dice2.bearSolution()+dice3.bearSolution()+dice4.bearSolution()+dice5.bearSolution()+dice6.bearSolution()+dice7.bearSolution()+dice8.bearSolution()+dice9.bearSolution()+dice10.bearSolution()+dice11.bearSolution()+dice12.bearSolution());
        int allPings = (dice1.pingSolution()+dice2.pingSolution()+dice3.pingSolution()+dice4.pingSolution()+dice5.pingSolution()+dice6.pingSolution()+dice7.pingSolution()+dice8.pingSolution()+dice9.pingSolution()+dice10.pingSolution()+dice11.pingSolution()+dice12.pingSolution());
        int[] solution = {allHoles, allBears, allPings};
        return solution;
    }
}