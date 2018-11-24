package App.ui;

import App.Exceptions.AlreadyInCompetitionException;
import App.Model.Scraper;
import App.player.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import java.util.Scanner;


public class Main {
    //Scanner scanner = new Scanner(System.in);
    private WildcardRoutine wildcardRoutine;
    private PrelimTwoSemiRoutine prelimTwoSemiRoutine;
    private WorldFinalRoutine worldFinalRoutine;
    static AppStrategy appStrategy;
    private Scraper scrpr;
    private JPanel panelMain;
    private JButton competitionButton;
    private JButton individualButton;
    private JFrame frame;
    //CardLayout card = (CardLayout)panelMain.getLayout();


    public Main() {
//        addCard(panelStartOrLoad,"card2");
//        addCard(panelPlayerInformation,"card3");
//        addCard(panelPickRoutineType,"card4");
//        competitionButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                onCompetitionPress();
////                appStrategy = new CompetitionStrategy();
////                try {
////                    appStrategy.callMode();
////                } catch (IOException e1) {
////                    e1.printStackTrace();
////                } catch (AlreadyInCompetitionException e1) {
////                    System.out.println(e1.getMessage());
////                }
//
//            }
//        });
        individualButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onIndividualPress();
//                appStrategy = new IndividualStrategy();
//                try {
//                    appStrategy.callMode();
//                } catch (IOException e1) {
//                    e1.printStackTrace();
//                } catch (AlreadyInCompetitionException e1) {
//                    e1.printStackTrace();
//                }
            }
        });
    }

    public void onCompetitionPress(){
        //frame.setContentPane(new StartOrLoad().getPanel());
//        showCard("card2");
//        appStrategy = new CompetitionStrategy();
//        try {
//            appStrategy.callMode();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (AlreadyInCompetitionException e) {
//            e.printStackTrace();
//        }
    }
    public void onIndividualPress(){
        System.out.println("Pressed!");
        frame.remove(panelMain);
        frame.setContentPane(new StartOrLoad(frame).getPanel());
        frame.setVisible(true);
        //frame.setVisible(true);
//        showCard("card2");
//        appStrategy = new IndividualStrategy();
    }

    public void onStartPress(){
        showCard("card4");
    }

    public void addCard(JPanel panel, String cardName){
        //card.addLayoutComponent(panel,cardName);
    }

    public void showCard(String cardName){

        //card.show(panelMain,cardName);
    }

    //MODIFIES: This, Player
    //EFFECTS: Starts the yo-yo judging application
    public PlayerDataAnalysis start(String routineType) throws IOException {
        PlayerDataAnalysis data = createPlayerSubtype(routineType);
        Player p = data.getPlayer();
        if (routineType.equals("Wildcard")) {
            //return runStartAsWildcardPlayer(p, routineType, data);
            wildcardRoutine = new WildcardRoutine();
            return wildcardRoutine.judgeRoutine(p, routineType, data);
        }
        else if (routineType.equals("Prelim") || routineType.equals("Semi") || routineType.equals("Two Minute Final")) {
            //return runStartAsPrelimTwoSemiPlayer(p, routineType, data);
            prelimTwoSemiRoutine = new PrelimTwoSemiRoutine();
            return prelimTwoSemiRoutine.judgeRoutine(p,routineType,data);
        }
        else if (routineType.equals("World Final")) {
            //return runStartAsWorldFinalPlayer(p, routineType, data);
            worldFinalRoutine = new WorldFinalRoutine();
            return worldFinalRoutine.judgeRoutine(p,routineType,data);
        }
        return null;
    }

    //MODIFIES: This, Player
    //EFFECTS: Creates player and playerDataAnalysis subtypes depending on user-inputted routineType
    public PlayerDataAnalysis createPlayerSubtype(String routineType) {
        if (routineType.equals("Wildcard")) {
            WildcardPlayer p = new WildcardPlayer();
            WildcardPlayerDataAnalysis data = new WildcardPlayerDataAnalysis(p);
            return data;
        } else if (routineType.equals("Prelim") || routineType.equals("Semi") || routineType.equals("Two Minute Final")) {
            PrelimTwoSemiPlayer p = new PrelimTwoSemiPlayer();
            PrelimTwoSemiPlayerDataAnalysis data = new PrelimTwoSemiPlayerDataAnalysis(p);
            return data;
        } else if (routineType.equals("World Final")) {
            WorldFinalPlayer p = new WorldFinalPlayer();
            WorldFinalPlayerDataAnalysis data = new WorldFinalPlayerDataAnalysis(p);
            return data;
        }
        return null;
    }

//    //EFFECTS: Will return the mode - either competition or individual mode, based on user input
//    public String competitionOrPlayerMode (){
//        System.out.println("Type competition to begin competition mode and individual to begin individual player mode");
//        String competitionOrPlayerMode;
//        competitionOrPlayerMode = scanner.nextLine();
//        return competitionOrPlayerMode;
//    }

    //EFFECTS: An intro to the application, displayed at the start
    public void applicationWelcome() throws Exception {
        System.out.println("Welcome to the yo-yo judging application");
        System.out.println("Created by: Harrison Lee");
        System.out.println("Read WYYC 2018 Freestyle Rules at: ");
        System.out.println("http://iyyf.org/wyyc2018-rules/freestyle-rules-2018/");
        System.out.println("performance evaluation descriptors from above");
//        scrpr = new Scraper();
//        scrpr.scrape();
    }



    public static void main (String[]args) throws Exception{
        Main yyjh = new Main();
        yyjh.frame = new JFrame("Yo-yo Judge Application");
        yyjh.frame.setContentPane(new Main().panelMain);
        yyjh.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        yyjh.frame.setSize(400,400);
        yyjh.frame.pack();
        yyjh.frame.setVisible(true);

//        yyjh.applicationWelcome();
//        String competitionOrPlayerMode;
//        competitionOrPlayerMode = yyjh.competitionOrPlayerMode();
//        if (competitionOrPlayerMode.equals("competition")) {
//            appStrategy = new CompetitionStrategy();
//            try {
//                appStrategy.callMode();
//            } catch (AlreadyInCompetitionException e) {
//                System.out.println(e.getMessage());
//            }
//        }
//        else if (competitionOrPlayerMode.equals("individual")) {
//            appStrategy = new IndividualStrategy();
//            try {
//                appStrategy.callMode();
//            } catch (AlreadyInCompetitionException e) {
//                System.out.println(e.getMessage());
//            }
//        }
    }

    private void createUIComponents() {
//        panelStartOrLoad = new StartOrLoad().getPanel();
//        panelPickRoutineType = new PickRoutineType().getPanel();
        // TODO: place custom component creation code here
    }
}

//    ArrayList<String> performanceEvaluationQuestionsWorld = new ArrayList<>();
//    ArrayList<String> evaluationKeywordsWorld = new ArrayList<>();
//    ArrayList<String> performanceEvaluationQuestions = new ArrayList<>();
//    ArrayList<String> evaluationKeywords = new ArrayList<>();
//    //MODIFIES: This
//    //EFFECTS: Adds eval parameter questions and eval parameters to lists
//    public void setUpEvaluationQuestionLists(){
//        performanceEvaluationQuestionsWorld.add("Execution score is: ");
//        performanceEvaluationQuestionsWorld.add("Control score is: ");
//        performanceEvaluationQuestionsWorld.add("Trick diversity score is: ");
//        performanceEvaluationQuestionsWorld.add("Space Use & Emphasis score is: ");
//        performanceEvaluationQuestionsWorld.add("Music Use 1: Choreography score is: ");
//        performanceEvaluationQuestionsWorld.add("Music Use 2: Construction score is: ");
//        performanceEvaluationQuestionsWorld.add("Body Control score is: ");
//        performanceEvaluationQuestionsWorld.add("Showmanship score is: ");
//
//        evaluationKeywordsWorld.add("execution");
//        evaluationKeywordsWorld.add("control");
//        evaluationKeywordsWorld.add("trickDiversity");
//        evaluationKeywordsWorld.add("spaceUseAndEmphasis");
//        evaluationKeywordsWorld.add("choreography");
//        evaluationKeywordsWorld.add("construction");
//        evaluationKeywordsWorld.add("bodyControl");
//        evaluationKeywordsWorld.add("showmanship");
//
//        performanceEvaluationQuestions.add("Execution score is: ");
//        performanceEvaluationQuestions.add("Control score is: ");
//        performanceEvaluationQuestions.add("Music Use 1: Choreography score is: ");
//        performanceEvaluationQuestions.add("Body Control score is: ");
//
//        evaluationKeywords.add("execution");
//        evaluationKeywords.add("control");
//        evaluationKeywords.add("choreography");
//        evaluationKeywords.add("bodyControl");
//    }
//    //MODIFIES: This, Player, PlayerDataAnalysis
//    //EFFECTS: progresses through judging a routine for a Wildcard player
//    public PlayerDataAnalysis runStartAsWildcardPlayer(Player p, String routineType, PlayerDataAnalysis data) throws IOException {
//        setPlayerInformation(p);
//        p.setRoutineLength(routineType);
//        wildcardClicker(p);
//        System.out.println(p.getFirstName() + " " + p.getLastName() + " positive clicks: " + p.getPositiveClicks());
//        data.callAllDataAnalysis();
//        System.out.println("Clicks per second: " + data.getCPS());
//        System.out.println("-------------------------------------------");
//        String firstName = p.getFirstName();
//        callAllSave(p, data, firstName, routineType);
//        return data;
//    }
//
//    //MODIFIES: This, Player, PlayerDataAnalysis
//    //EFFECTS: progresses through judging a routine for a prelim,semi or two minute final player
//    public PlayerDataAnalysis runStartAsPrelimTwoSemiPlayer(Player p, String routineType, PlayerDataAnalysis data) throws IOException {
//        setPlayerInformation(p);
//        p.setRoutineLength(routineType);
//        Clicker(p,data);
//        printRoutineClickInformation(p);
//        setUpEvaluationQuestionLists();
//        setAllPerformanceEvals(p, performanceEvaluationQuestions, evaluationKeywords);
//        p.getPerformanceEvals(p);
//        data.callAllDataAnalysis();
//        printAnalyzedRoutineInformation(data);
//        String firstName = p.getFirstName();
//        callAllSave(p, data, firstName, routineType);
//        return data;
//    }
//
//
//    //MODIFIES: This, Player, PlayerDataAnalysis
//    //EFFECTS: progresses through judging a routine for a world final player
//    public PlayerDataAnalysis runStartAsWorldFinalPlayer(Player p, String routineType, PlayerDataAnalysis data) throws IOException {
//        setPlayerInformation(p);
//        p.setRoutineLength(routineType);
//        Clicker(p,data);
//        printRoutineClickInformation(p);
//        setUpEvaluationQuestionLists();
//        setAllPerformanceEvals(p, performanceEvaluationQuestionsWorld, evaluationKeywordsWorld);
//        p.getPerformanceEvals(p);
//        data.callAllDataAnalysis();
//        printAnalyzedRoutineInformation(data);
//        String firstName = p.getFirstName();
//        callAllSave(p, data, firstName, routineType);
//        return data;
//    }
//
//    //EFFECTS: Prints various post performance information
//    public void printRoutineClickInformation(Player p) {
//        System.out.println(p.getFirstName() + " " + p.getLastName() + " positive clicks: " + p.getPositiveClicks());
//        System.out.println(p.getFirstName() + " " + p.getLastName() + " negative clicks: " + p.getNegativeClicks());
//        System.out.println(p.getFirstName() + " " + p.getLastName() + " final reset score is: " + p.getRestartFinal());
//        System.out.println(p.getFirstName() + " " + p.getLastName() + " final change score is: " + p.getChangeFinal());
//        System.out.println(p.getFirstName() + " " + p.getLastName() + " final discard score is: " + p.getDiscardFinal());
//    }
//
//    //EFFECTS: Prints analyzed routine information of a player
//    public void printAnalyzedRoutineInformation(PlayerDataAnalysis data) {
//        System.out.println("Total majors: " + data.getTotalMajors());
//        System.out.println("Total weighted score: " + data.getTotalWeightedScore());
//        System.out.println("Fire sections in routine: " + data.getNumberOfFireSectionsInRoutine());
//        System.out.println("Tilted sections in routine: " + data.getNumberOfTiltedSectionsInRoutine());
//        System.out.println("Clicks per second: " + data.getCPS());
//        System.out.println("Clicks ratio: " + data.getCR());
//        System.out.println("The player's clicks if perfect: " + data.getNumberIfPerfect());
//        System.out.println("The player's clicks if perfect per second:" + data.getCIPPS());
//        System.out.println("-------------------------------------------");
//    }
//
//    //MODIFIES: This, player
//    //EFFECTS: Records information for a given player
//    public void setPlayerInformation(Player p) {
//        System.out.println("Player first name: ");
//        String firstName = scanner.nextLine();
//        System.out.println("Player last name: ");
//        String lastName = scanner.nextLine();
//        System.out.println("Player division: ");
//        String division = scanner.nextLine();
//        p.setFirstName(firstName);
//        p.setLastName(lastName);
//        p.setDivision(division);
//    }
//
//    // where the is a noun - supertype
//    //MODIFIES: This, player
//    //EFFECTS: Will increase/decrease the Clicker score of a player and then return the Clicker score after the routine is over
//    public void wildcardClicker(Player p) {
//        String keyPress = "";
//        System.out.println("Press the j key to increment the player's score.");
//        System.out.println("Press the h key to increment the player's score twice(double click)");
//        System.out.println("Press the i key to reset the players clickerscore");
//        System.out.println("Press s to stop judging the player");
//        while (true) {
//            keyPress = scanner.nextLine();
//            if (keyPress.equals("j")) {
//                p.awardClick();
//            } else if(keyPress.equals("h")){
//                p.doubleClick();
//            } else if (keyPress.equals("i")) {
//                p.resetClicks();
//            } else if (keyPress.equals("s")) {
//                p.produceClickerScore();
//                System.out.println(p.getFirstName()+ " " + p.getLastName() + "'s" + " final clickerscore is: " + p.getClickerScore());
//                break;
//            }
//        }
//    }
//
//    //MODIFIES: This, player
//    //EFFECTS: Will increase/decrease the Clicker score of a player and then return the Clicker score after the routine is over
//    public void Clicker(Player p, PlayerDataAnalysis data) {
//        String keyPress = "";
//        System.out.println("Press the j key to increment and the f key to decrement the player's score");
//        System.out.println("Press the h key to increment the player's score twice(double click)");
//        System.out.println("Press the q key to give the player a restart");
//        System.out.println("Press the w key to give the player a change");
//        System.out.println("Press the e key to give the player a discard");
//        System.out.println("Press the i key to reset the players clickerscore");
//        System.out.println("Press the o key to reset the players major deduct score");
//        System.out.println("Press the p key to reset everything");
//        System.out.println("Press s to stop judging the player");
//        while (true) {
//            keyPress = scanner.nextLine();
//            if (keyPress.equals("f")) {
//                p.removeClick();
//            } else if (keyPress.equals("j")) {
//                p.awardClick();
//            } else if (keyPress.equals("h")) {
//                p.doubleClick();
//            } else if (keyPress.equals("q")) {
//                p.restart();
//            } else if (keyPress.equals("w")) {
//                p.change();
//            } else if (keyPress.equals("e")) {
//                p.discard();
//            } else if (keyPress.equals("i")) {
//                p.resetClicks();
//                data.resetFireTilt();
//            } else if (keyPress.equals("o")) {
//                p.resetMajorDeducts();
//            } else if (keyPress.equals("p")) {
//                p.resetEverything();
//                data.resetFireTilt();
//            } else if (keyPress.equals("s")) {
//                p.produceClickerScore();
//                System.out.println(p.getFirstName()+ " " + p.getLastName() + "'s" + " final clickerscore is: " + p.getClickerScore());
//                break;
//            }
//        }
//    }
//
//    //MODIFIES: This, player
//    //EFFECTS: Records judge's performance evaluation scores for a given player
//    public void setAllPerformanceEvals(Player p, ArrayList<String> evaluationQuestionList, ArrayList<String> evaluationKeywordsList) {
//        for (int i = 0; i < evaluationQuestionList.size(); i++) {
//            try {
//                setIndividualPerformanceEval(i, p, evaluationQuestionList, evaluationKeywordsList);
//            } catch (IncorrectUserInputException e) {
//                i--;
//                System.out.println(e.getMessage());
//            }
//        }
//    }
//
//    //MODIFIES: This, player
//    //EFFECTS: Will set a single performance eval for a given player
//    public void setIndividualPerformanceEval(int i, Player p, ArrayList<String> evaluationQuestionList, ArrayList<String> evaluationKeywordsList) throws IncorrectUserInputException {
//        System.out.println(evaluationQuestionList.get(i));
//        int score = scanner.nextInt();
//        if (score > 10 || score < 0) {
//            throw new IncorrectUserInputException("Please input an integer greater than 0 but less than 10");
//        }
//        p.setEvaluation(score, evaluationKeywordsList.get(i));
//    }
//
//    //EFFECTS: Calls the save methods of player and playerDataAnalysis
//    public void callAllSave(Player p, PlayerDataAnalysis data, String firstName, String routineType) throws IOException {
//        p.setRoutineType(routineType);
//        p.save(firstName + "_" + routineType + "_player.csv");
//        data.save(firstName + "_" + routineType + "_playerDataAnalysis.csv");
//    }
