package App.ui;

import App.player.Player;
import App.player.PlayerDataAnalysis;

import java.io.IOException;

public class WildcardRoutine extends Routine{

    //MODIFIES: This, Player, PlayerDataAnalysis
    //EFFECTS: progresses through judging a routine for a Wildcard player
    @Override
    public PlayerDataAnalysis judgeRoutine(Player p, String routineType, PlayerDataAnalysis data) throws IOException {
        setPlayerInformation(p);
        p.setRoutineLength(routineType);
        clicker(p,data);
        data.callAllDataAnalysis();
        printRoutineClickInformation(p);
        printAnalyzedRoutineInformation(data,p);
        String firstName = p.getFirstName();
        callAllSave(p, data, firstName, routineType);
        return data;
    }

    public void printRoutineClickInformation(Player p) {
        System.out.println(p.getFirstName() + " " + p.getLastName() + "'s technical data: ");
        System.out.println("Positive clicks: " + p.getPositiveClicks());
        System.out.println("Clickerscore: " + p.getClickerScore());
        System.out.println(STRINGBREAK);
    }
    public void printAnalyzedRoutineInformation(PlayerDataAnalysis data, Player p){
        System.out.println(p.getFirstName() + " " + p.getLastName() + "'s analyzed technical data");
        System.out.println("Clicks per second: " + data.getCPS());
        System.out.println(STRINGBREAK);

    }

    //MODIFIES: This, player
    //EFFECTS: Will increase/decrease the Clicker score of a player and then return the Clicker score after the routine is over
    @Override
    public void clicker(Player p, PlayerDataAnalysis data) {
        String keyPress = "";
        System.out.println("Press the j key to increment the player's score.");
        System.out.println("Press the h key to increment the player's score twice(double click)");
        System.out.println("Press the i key to reset the players clickerscore");
        System.out.println("Press s to stop judging the player");
        while (true) {
            keyPress = scanner.nextLine();
            if (keyPress.equals("j")) {
                p.awardClick();
            } else if(keyPress.equals("h")){
                p.doubleClick();
            } else if (keyPress.equals("i")) {
                p.resetClicks();
            } else if (keyPress.equals("s")) {
                p.produceClickerScore();
                break;
            }
        }
    }

    public void setUpEvaluationQuestionLists(){
        System.out.println("does nothing");
    }
}
