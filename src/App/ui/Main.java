//own judging algorithm, necessary fields and methods. One per style of judging. Have a field inside of a judge which insantiates the algorithm. state something - 310
// judge algorithm interface. if novice - insantiate novice judging rules...
// competition and individual
// declare mode into one class - instantiate

package App.ui;

import App.Exceptions.*;
import App.player.*;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    Scanner scanner = new Scanner(System.in);
    ArrayList<String> performanceEvaluationQuestionsWorld = new ArrayList<>();
    ArrayList<String> evaluationKeywordsWorld = new ArrayList<>();
    ArrayList<String> performanceEvaluationQuestions = new ArrayList<>();
    ArrayList<String> evaluationKeywords = new ArrayList<>();
    ArrayList<String> routineTypes = new ArrayList<>();
    static AppStrategy appStrategy;


    // Constructor
    //MODIFIES: This
    //EFFECTS: Adds eval parameter questions and eval parameters to lists
    public Main() {
        performanceEvaluationQuestionsWorld.add("Execution score is: ");
        performanceEvaluationQuestionsWorld.add("Control score is: ");
        performanceEvaluationQuestionsWorld.add("Trick diversity score is: ");
        performanceEvaluationQuestionsWorld.add("Space Use & Emphasis score is: ");
        performanceEvaluationQuestionsWorld.add("Music Use 1: Choreography score is: ");
        performanceEvaluationQuestionsWorld.add("Music Use 2: Construction score is: ");
        performanceEvaluationQuestionsWorld.add("Body Control score is: ");
        performanceEvaluationQuestionsWorld.add("Showmanship score is: ");

        evaluationKeywordsWorld.add("execution");
        evaluationKeywordsWorld.add("control");
        evaluationKeywordsWorld.add("trickDiversity");
        evaluationKeywordsWorld.add("spaceUseAndEmphasis");
        evaluationKeywordsWorld.add("choreography");
        evaluationKeywordsWorld.add("construction");
        evaluationKeywordsWorld.add("bodyControl");
        evaluationKeywordsWorld.add("showmanship");

        performanceEvaluationQuestions.add("Execution score is: ");
        performanceEvaluationQuestions.add("Control score is: ");
        performanceEvaluationQuestions.add("Music Use 1: Choreography score is: ");
        performanceEvaluationQuestions.add("Body Control score is: ");

        evaluationKeywords.add("execution");
        evaluationKeywords.add("control");
        evaluationKeywords.add("choreography");
        evaluationKeywords.add("bodyControl");

        routineTypes.add("Wildcard");
        routineTypes.add("Prelim");
        routineTypes.add("Semi");
        routineTypes.add("Two Minute Final");
        routineTypes.add("World Final");

    }

    //MODIFIES: This, Player
    //EFFECTS: Starts the yo-yo judging application
    public PlayerDataAnalysis start(String routineType) throws IOException {
        PlayerDataAnalysis data = createPlayerSubtype(routineType);
        Player p = data.getPlayer();
        if (routineType.equals("Wildcard"))
            return runStartAsWildcardPlayer(p, routineType, data);
        else if (routineType.equals("Prelim") || routineType.equals("Semi") || routineType.equals("Two Minute Final"))
            return runStartAsPrelimTwoSemiPlayer(p, routineType, data);
        else if (routineType.equals("World Final")) {
            return runStartAsWorldFinalPlayer(p, routineType, data);
        }
        return null;
    }


    //MODIFIES: This, Player, PlayerDataAnalysis
    //EFFECTS: progresses through judging a routine for a Wildcard player
    public PlayerDataAnalysis runStartAsWildcardPlayer(Player p, String routineType, PlayerDataAnalysis data) throws IOException {
        setPlayerInformation(p);
        p.setRoutineLength(routineType);
        wildcardClicker(p);
        System.out.println(p.getFirstName() + " " + p.getLastName() + " positive clicks: " + p.getPositiveClicks());
        data.callAllDataAnalysis();
        System.out.println("Clicks per second: " + data.getCPS());
        System.out.println("-------------------------------------------");
        String firstName = p.getFirstName();
        callAllSave(p, data, firstName, routineType);
        return data;
    }

    //MODIFIES: This, Player, PlayerDataAnalysis
    //EFFECTS: progresses through judging a routine for a prelim,semi or two minute final player
    public PlayerDataAnalysis runStartAsPrelimTwoSemiPlayer(Player p, String routineType, PlayerDataAnalysis data) throws IOException {
        setPlayerInformation(p);
        p.setRoutineLength(routineType);
        clicker(p, data);
        printRawRoutineInformation(p);
        setAllPerformanceEvals(p, performanceEvaluationQuestions, evaluationKeywords);
        p.getPerformanceEvals(p);
        data.callAllDataAnalysis();
        printAnalyzedRoutineInformation(data);
        String firstName = p.getFirstName();
        callAllSave(p, data, firstName, routineType);
        return data;
    }


    //MODIFIES: This, Player, PlayerDataAnalysis
    //EFFECTS: progresses through judging a routine for a world final player
    public PlayerDataAnalysis runStartAsWorldFinalPlayer(Player p, String routineType, PlayerDataAnalysis data) throws IOException {
        setPlayerInformation(p);
        p.setRoutineLength(routineType);
        clicker(p, data);
        printRawRoutineInformation(p);
        setAllPerformanceEvals(p, performanceEvaluationQuestionsWorld, evaluationKeywordsWorld);
        p.getPerformanceEvals(p);
        data.callAllDataAnalysis();
        printAnalyzedRoutineInformation(data);
        String firstName = p.getFirstName();
        callAllSave(p, data, firstName, routineType);
        return data;
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

    // where the is a noun - supertype
    //MODIFIES: This, player
    //EFFECTS: Will increase/decrease the clicker score of a player and then return the clicker score after the routine is over
    public void wildcardClicker(Player p) {
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


//    //MODIFIES: This, Player
//    //EFFECTS: Creates player and playerDataAnalysis subtypes depending on user-inputted routineType
//    public PlayerDataAnalysis createPlayerSubtype(String routineType) {
//        if (routineType.equals("Wildcard")) {
//            WildcardPlayer p = new WildcardPlayer();
//            WildcardPlayerDataAnalysis data = new WildcardPlayerDataAnalysis(p);
//            return data;
//        } else if (routineType.equals("Prelim")) {
//            PrelimTwoSemiPlayer p = new PrelimTwoSemiPlayer();
//            PrelimTwoSemiPlayerDataAnalysis data = new PrelimTwoSemiPlayerDataAnalysis(p);
//            return data;
//        } else if (routineType.equals("Semi")) {
//            SemiPlayer p = new SemiPlayer();
//            SemiPlayerDataAnalysis data = new SemiPlayerDataAnalysis(p);
//            return data;
//        } else if (routineType.equals("Two Minute Final")) {
//            TwoMinuteFinalPlayer p = new TwoMinuteFinalPlayer();
//            TwoMinuteFinalPlayerDataAnalysis data = new TwoMinuteFinalPlayerDataAnalysis(p);
//            return data;
//        } else if (routineType.equals("World Final")) {
//            WorldFinalPlayer p = new WorldFinalPlayer();
//            WorldFinalPlayerDataAnalysis data = new WorldFinalPlayerDataAnalysis(p);
//            return data;
//        }
//        return null;
//    }


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

    //EFFECTS: Calls the save methods of player and playerDataAnalysis
    public void callAllSave(Player p, PlayerDataAnalysis data, String firstName, String routineType) throws IOException {
        p.setRoutineType(routineType);
        p.save(firstName + "_" + routineType + "_player.csv");
        data.save(firstName + "_" + routineType + "_playerDataAnalysis.csv");
    }

    public String competitionOrPlayerMode (){
        System.out.println("Type competition to begin competition mode and individual to begin individual player mode");
        String competitionOrPlayerMode;
        competitionOrPlayerMode = scanner.nextLine();
        return competitionOrPlayerMode;
    }

    public void applicationWelcome(){
        System.out.println("Welcome to the yo-yo judging application");
        System.out.println("Created by: Harrison Lee");
    }

        public static void main (String[]args) throws IOException {
            Main yyjh = new Main();
            yyjh.applicationWelcome();
            String competitionOrPlayerMode;
            competitionOrPlayerMode = yyjh.competitionOrPlayerMode();
            if (competitionOrPlayerMode.equals("competition")) {
                appStrategy = new CompetitionStrategy();
                try {
                    appStrategy.callMode();
                } catch (AlreadyInCompetitionException e) {
                    System.out.println(e.getMessage());
                }
//                try {
//                    yyjh.competitionMode(yyjh,competitionOrPlayerMode);
//                } catch (AlreadyInCompetitionException e) {
//                    System.out.println(e.getMessage());
//                }
            }
            else if (competitionOrPlayerMode.equals("individual")) {
                appStrategy = new IndividualStrategy();
                try {
                    appStrategy.callMode();
                } catch (AlreadyInCompetitionException e) {
                    System.out.println(e.getMessage());
                }
//                yyjh.individualMode(yyjh);

            }
        }
    }


//        //MODIFIES: This, Player, PlayerDataAnalysis, App.Competition, CompetitionDataAnalysis
//        //EFFECTS: Runs the application in competition mode (judge multiple players sequentially)
//        public static void competitionMode(Main yyjh, String choice) throws IOException, AlreadyInCompetitionException {
//            Scanner scanner = new Scanner(System.in);
//            Competition c = new Competition();
//            CompetitionDataAnalysis cData = new CompetitionDataAnalysis(c);
//            System.out.println("Type start to start judging a competition or load to load competition data from memory");
//            String startOrRead = scanner.nextLine();
//            if (startOrRead.equals("start")) {
//                String routineType = null;
//                try {
//                    routineType = yyjh.retrieveRoutineType(choice);
//                } catch (IncorrectUserInputException e) {
//                    System.out.println(e.getMessage());
//                    competitionMode(yyjh,choice);
//                }
//                String competitionName = setCompetitionNameFromUserInput(c);
//                yyjh.judgePlayersSequentially(c,cData,yyjh,competitionName,routineType);
//            }
//            else if (startOrRead.equals("load")) {
//                yyjh.competitionModeRead(c,cData);
//
//            }
//        }

//        public static String setCompetitionNameFromUserInput(Competition c){
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("What is the name of the competition you are judging");
//            String competitionName = scanner.nextLine();
//            c.setCompetitionName(competitionName);
//            return competitionName;
//        }
//
//        public void competitionModeRead(Competition c, CompetitionDataAnalysis cData) throws IOException {
//            System.out.println("What competition would you like to load from memory?");
//            String competitionName = scanner.nextLine();
//            c.load(competitionName);
//            cData.load(competitionName);
//        }
//
//        public void judgePlayersSequentially (Competition c, CompetitionDataAnalysis cData, Main yyjh, String competitionName, String routineType) throws IOException {
//            while (true) {
//                PlayerDataAnalysis data = yyjh.start(routineType);
//                c.addPlayerDataAnalysis(data);
//                Player p = data.getPlayer();
//                c.addPlayer(p);
//                String anotherPlayer = anotherPlayer();
//                if (anotherPlayer.equals("yes")) {
//                }
//                if (anotherPlayer.equals("no")) {
//                    c.save(competitionName);
//                    cData.save(competitionName);
//                    cData.callAllDataAnalysis();
//                    yyjh.printAnalyzedCompetitionInformation(cData);
//                    break;
//                }
//            }
//        }
//
//        public String anotherPlayer(){
//            System.out.println("Is there another player to judge in this competition yes or no");
//            String anotherPlayer = scanner.nextLine();
//            return anotherPlayer;
//        }

//        //MODIFIES: This, Player, PlayerDataAnalysis, App.Competition, CompetitionDataAnalysis
//        //EFFECTS: Runs the application in individual mode (judge an individual player)
//        public void individualMode(Main yyjh){
//            System.out.println("Type start to start judging a player or load to load from memory");
//            String choice = scanner.nextLine();
//            if (choice.equals("start")) {
//                try {
//                    try {
//                        String routineType = retrieveRoutineType(choice);
//                        start(routineType);
//                    } catch (IncorrectUserInputException e) {
//                        System.out.println(e.getMessage());
//                        individualMode(yyjh);
//                    }
//                } catch (IOException e) {
//                    System.out.println("Data save problem");
//                }
//            }
//            else if (choice.equals("load")) {
//                String firstName = retrieveJudgedPlayerName();
//                String routineType = null;
//                try {
//                    routineType = retrieveRoutineType(choice);
//                } catch (IncorrectUserInputException e) {
//                    System.out.println(e.getMessage());
//                    individualMode(yyjh);
//                }
//                try {
//                    individualModeRead(firstName, routineType);
//                }
//                catch (IOException e) {
//                    System.out.println("Player name and routine type combination inputted is not saved in memory");
//                }
//            }
//        }

//        public String retrieveJudgedPlayerName(){
//            System.out.println("Type in the name of a player who has already been judged");
//            String firstName = scanner.nextLine();
//            return firstName;
//        }
//
//        //EFFECTS: Reads from memory
//        public void individualModeRead(String firstName, String routineType) throws IOException {
//            PlayerDataAnalysis data = createPlayerSubtype(routineType);
//            Player p = data.getPlayer();
//            p.load(firstName + "_" + routineType + "_player.csv");
//            data.load(firstName + "_" + routineType + "_playerDataAnalysis.csv");
//        }
