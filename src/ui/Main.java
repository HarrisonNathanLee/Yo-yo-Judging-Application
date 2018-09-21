package ui;

import java.util.Scanner;
import player.Player;

class YoYoJudge {
    Scanner scanner = new Scanner(System.in);
    Player p = new Player();
    public int clickerscore = 0;

    public YoYoJudge(){
    }

    public void start() {
        p.getPlayerInformation();
        String keyPress = "";
        System.out.println("Press the j key to increment and the f key to decrement the player's score. Type stop to exit.");
        while (true) {
            keyPress = scanner.nextLine();
            if (keyPress.equals("f")) {
                p.removeClick();
            }
            else if (keyPress.equals("j")) {
                p.awardClick();
            }
            else if (keyPress.equals("stop")) {
                System.out.println(p.getFirstName() + " " + p.getLastName() + "'s" + " final clickerscore is: " + p.getScore());
                break;
            }
        }
        p.getPerformanceEvals();
        System.out.println(p.getFirstName() + " " + p.getLastName() + "'s performance evaluation scores are: ");
        System.out.println("Execution: " + p.getExecution());
        System.out.println("Control: " + p.getControl());
        System.out.println("Trick Diversity: " + p.getTrickDiversity());
        System.out.println("Space Use and Emphasis: " + p.getSpaceUseAndEmphasis());
        System.out.println("Choreography: " + p.getChoreography());
        System.out.println("Construction: " + p.getConstruction());
        System.out.println("Body control: " + p.getBodyControl());
        System.out.println("Showmanship: " + p.getShowmanship());

    }
    public static void main(String[] args) {
        YoYoJudge yyjh = new YoYoJudge();
        yyjh.start();
    }
}

