package App.ui;

import App.Exceptions.IncorrectUserInputException;
import App.player.Player;
import App.player.PlayerDataAnalysis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Routine {
    Scanner scanner = new Scanner(System.in);
    protected ArrayList<String> performanceEvaluationQuestions;
    protected ArrayList<String> evaluationKeywords;

    //MODIFIES: This, Player, PlayerDataAnalysis
    //EFFECTS: progresses through judging a routine for a prelim,semi or two minute final player
    public PlayerDataAnalysis judgeRoutine(Player p, String routineType, PlayerDataAnalysis data) throws IOException {
        setPlayerInformation(p);
        p.setRoutineLength(routineType);
        clicker(p,data);
        printRawRoutineInformation(p);
        setUpEvaluationQuestionLists();
        setAllPerformanceEvals(p, performanceEvaluationQuestions, evaluationKeywords);
        p.getPerformanceEvals(p);
        data.callAllDataAnalysis();
        printAnalyzedRoutineInformation(data);
        String firstName = p.getFirstName();
        callAllSave(p, data, firstName, routineType);
        return data;
    }

    public abstract void setUpEvaluationQuestionLists();


    //EFFECTS: Calls the save methods of player and playerDataAnalysis
    public void callAllSave(Player p, PlayerDataAnalysis data, String firstName, String routineType) throws IOException {
        p.setRoutineType(routineType);
        p.save(firstName + "_" + routineType + "_player.csv");
        data.save(firstName + "_" + routineType + "_playerDataAnalysis.csv");
    }

    //MODIFIES: This, player
    //EFFECTS: Will increase/decrease the clicker score of a player and then return the clicker score after the routine is over
    public void clicker(Player p, PlayerDataAnalysis data) {
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
                System.out.println(p.getFirstName()+ " " + p.getLastName() + "'s" + " final clickerscore is: " + p.getClickerScore());
                break;
            }
        }
    }

    //EFFECTS: Prints various post performance information
    public void printRawRoutineInformation(Player p) {
        System.out.println(p.getFirstName() + " " + p.getLastName() + " positive clicks: " + p.getPositiveClicks());
        System.out.println(p.getFirstName() + " " + p.getLastName() + " negative clicks: " + p.getNegativeClicks());
        System.out.println(p.getFirstName() + " " + p.getLastName() + " final reset score is: " + p.getRestartFinal());
        System.out.println(p.getFirstName() + " " + p.getLastName() + " final change score is: " + p.getChangeFinal());
        System.out.println(p.getFirstName() + " " + p.getLastName() + " final discard score is: " + p.getDiscardFinal());
    }

    //EFFECTS: Prints analyzed routine information of a player
    public void printAnalyzedRoutineInformation(PlayerDataAnalysis data) {
        System.out.println("Total majors: " + data.getTotalMajors());
        System.out.println("Total weighted score: " + data.getTotalWeightedScore());
        System.out.println("Fire sections in routine: " + data.getNumberOfFireSectionsInRoutine());
        System.out.println("Tilted sections in routine: " + data.getNumberOfTiltedSectionsInRoutine());
        System.out.println("Clicks per second: " + data.getCPS());
        System.out.println("Clicks ratio: " + data.getCR());
        System.out.println("The player's clicks if perfect: " + data.getNumberIfPerfect());
        System.out.println("The player's clicks if perfect per second:" + data.getCIPPS());
        System.out.println("-------------------------------------------");
    }

    //MODIFIES: This, player
    //EFFECTS: Records information for a given player
    public void setPlayerInformation(Player p) {
        System.out.println("Player first name: ");
        String firstName = scanner.nextLine();
        System.out.println("Player last name: ");
        String lastName = scanner.nextLine();
        System.out.println("Player division: ");
        String division = scanner.nextLine();
        p.setFirstName(firstName);
        p.setLastName(lastName);
        p.setDivision(division);
    }

    //MODIFIES: This, player
    //EFFECTS: Records judge's performance evaluation scores for a given player
    public void setAllPerformanceEvals(Player p, ArrayList<String> evaluationQuestionList, ArrayList<String> evaluationKeywordsList) {
        for (int i = 0; i < evaluationQuestionList.size(); i++) {
            try {
                setIndividualPerformanceEval(i, p, evaluationQuestionList, evaluationKeywordsList);
            } catch (IncorrectUserInputException e) {
                i--;
                System.out.println(e.getMessage());
            }
        }
    }

    //MODIFIES: This, player
    //EFFECTS: Will set a single performance eval for a given player
    public void setIndividualPerformanceEval(int i, Player p, ArrayList<String> evaluationQuestionList, ArrayList<String> evaluationKeywordsList) throws IncorrectUserInputException {
        System.out.println(evaluationQuestionList.get(i));
        int score = scanner.nextInt();
        if (score > 10 || score < 0) {
            throw new IncorrectUserInputException("Please input an integer greater than 0 but less than 10");
        }
        p.setEvaluation(score, evaluationKeywordsList.get(i));
    }

}
