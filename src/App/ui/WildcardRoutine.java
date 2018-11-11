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
        System.out.println(p.getFirstName() + " " + p.getLastName() + " positive clicks: " + p.getPositiveClicks());
        data.callAllDataAnalysis();
        System.out.println("Clicks per second: " + data.getCPS());
        System.out.println("-------------------------------------------");
        String firstName = p.getFirstName();
        callAllSave(p, data, firstName, routineType);
        return data;
    }

    // where the is a noun - supertype
    //MODIFIES: This, player
    //EFFECTS: Will increase/decrease the clicker score of a player and then return the clicker score after the routine is over
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
                System.out.println(p.getFirstName()+ " " + p.getLastName() + "'s" + " final clickerscore is: " + p.getClickerScore());
                break;
            }
        }
    }

    public void setUpEvaluationQuestionLists(){
        System.out.println("does nothing");
    }
}
