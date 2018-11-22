package App.ui;

import App.player.Player;
import App.player.PlayerDataAnalysis;

import javax.swing.*;

public class Clicker {
    private JPanel panelClicker;
    private JTextField playerPositiveClicksTextField;
    private JTextField playerNegativeClicksTextField;

    public Clicker(){
    }

    public JPanel getPanel(){
        return panelClicker;
    }

    //MODIFIES: This, player
    //EFFECTS: Will increase/decrease the Clicker score of a player and then return the Clicker score after the routine is over
    public void clicker(int KeyCode) {
        String keyPress = "";
        System.out.println("Press the j key to increment and the f key to decrement the player's score");
        System.out.println("Press the h key to increment the player's score twice(double click)");
        System.out.println("Press the q key to give the player a restart");
        System.out.println("Press the w key to give the player a change");
        System.out.println("Press the e key to give the player a discard");
        System.out.println("Press the i key to reset the players clickerscore");
        System.out.println("Press the o key to reset the players major deduct score");
        System.out.println("Press the p key to reset everything");
        System.out.println("Press s to stop judging the player");
        while (true) {
            keyPress = scanner.nextLine();
            if (keyPress.equals("f")) {
                p.removeClick();
            } else if (keyPress.equals("j")) {
                p.awardClick();
            } else if (keyPress.equals("h")) {
                p.doubleClick();
            } else if (keyPress.equals("q")) {
                p.restart();
            } else if (keyPress.equals("w")) {
                p.change();
            } else if (keyPress.equals("e")) {
                p.discard();
            } else if (keyPress.equals("i")) {
                p.resetClicks();
                data.resetFireTilt();
            } else if (keyPress.equals("o")) {
                p.resetMajorDeducts();
            } else if (keyPress.equals("p")) {
                p.resetEverything();
                data.resetFireTilt();
            } else if (keyPress.equals("s")) {
                p.produceClickerScore();
                break;
            }
        }
    }
}
