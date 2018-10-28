package ui;

import Competition.Competition;
import Exceptions.IncorrectUserInputException;
import player.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class YoYoJudge {
    Scanner scanner = new Scanner(System.in);
    ArrayList<String> performanceEvaluationQuestionsWorld = new ArrayList<>();
    ArrayList<String> evaluationKeywordsWorld = new ArrayList<>();
    ArrayList<String> performanceEvaluationQuestions = new ArrayList<>();
    ArrayList<String> evaluationKeywords = new ArrayList<>();
    ArrayList<String> routineTypes = new ArrayList<>();


    public YoYoJudge() {
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
        evaluationKeywordsWorld.add("construction ");
        evaluationKeywordsWorld.add("bodyControl");
        evaluationKeywordsWorld.add("Showmanship");

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

    //EFFECTS: Starts the yo-yo judging application
    public PlayerDataAnalysis start(String routineType) throws IOException {
        if (routineType.equals("Wildcard")) {
            WildcardPlayer w = new WildcardPlayer();
            WildcardPlayerDataAnalysis data = new WildcardPlayerDataAnalysis(w);
            return runStartAsWildcardPlayer(w, routineType, data);
        } else if (routineType.equals("Prelim")) {
            PrelimPlayer pp = new PrelimPlayer();
            PrelimPlayerDataAnalysis data = new PrelimPlayerDataAnalysis(pp);
            return runStartAsPrelimSemiTwoMinutePlayer(pp, routineType, data);
        } else if (routineType.equals("Semi")) {
            SemiPlayer s = new SemiPlayer();
            SemiPlayerDataAnalysis data = new SemiPlayerDataAnalysis(s);
            return runStartAsPrelimSemiTwoMinutePlayer(s, routineType, data);
        } else if (routineType.equals("Two Minute Final")) {
            TwoMinuteFinalPlayer t = new TwoMinuteFinalPlayer();
            TwoMinuteFinalPlayerDataAnalysis data = new TwoMinuteFinalPlayerDataAnalysis(t);
            return runStartAsPrelimSemiTwoMinutePlayer(t, routineType, data);
        } else if (routineType.equals("World Final")) {
            WorldFinalPlayer f = new WorldFinalPlayer();
            WorldFinalPlayerDataAnalysis data = new WorldFinalPlayerDataAnalysis(f);
            return runStartAsWorldFinalPlayer(f, routineType, data);
        }
        return null;
    }

    public PlayerDataAnalysis runStartAsPrelimSemiTwoMinutePlayer(Player p, String routineType, PlayerDataAnalysis data) throws IOException {
        setPlayerInformation(p);
        p.setRoutineLength(routineType);
        clicker(p, data);
        printRawRoutineInformation(p);
        setAllPerformanceEvals(p, performanceEvaluationQuestions, evaluationKeywords);
        getPerformanceEvals(p);
        data.callAllDataAnalysis();
        printAnalyzedRoutineInformation(data);
        String firstName = p.getFirstName();
        callAllSave(p, data, firstName, routineType);
        return data;
    }

    public PlayerDataAnalysis runStartAsWorldFinalPlayer(Player p, String routineType, PlayerDataAnalysis data) throws IOException {
        setPlayerInformation(p);
        p.setRoutineLength(routineType);
        clicker(p, data);
        printRawRoutineInformation(p);
        setAllPerformanceEvals(p, performanceEvaluationQuestionsWorld, evaluationKeywordsWorld);
        getWorldPerformanceEvals(p);
        data.callAllDataAnalysis();
        printAnalyzedRoutineInformation(data);
        String firstName = p.getFirstName();
        callAllSave(p, data, firstName, routineType);
        return data;
    }

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


    //EFFECTS: Prints judge inputted performance evaluations
    public void getPerformanceEvals(Player p) {
        System.out.println(p.getFirstName() + " " + p.getLastName() + "'s performance evaluation scores are: ");
        System.out.println("Execution: " + p.getExecution());
        System.out.println("Control: " + p.getControl());
        System.out.println("Choreography: " + p.getChoreography());
        System.out.println("Body control: " + p.getBodyControl());
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

    public void setIndividualPerformanceEval(int i, Player p, ArrayList<String> evaluationQuestionList, ArrayList<String> evaluationKeywordsList) throws IncorrectUserInputException {
        System.out.println(evaluationQuestionList.get(i));
        int score = scanner.nextInt();
        if (score > 10 || score < 0) {
            throw new IncorrectUserInputException("Please input an integer greater than 0 but less than 10");
        }
        p.setEvaluation(score, evaluationKeywordsList.get(i));
    }

    //EFFECTS: Prints judge inputted performance evaluations
    public void getWorldPerformanceEvals(Player p) {
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

    //EFFECTS: Reads from memory
    public void readFromMemory(String firstName, String routineType) throws IOException {
        if (routineType.equals("Wildcard")) {
            WildcardPlayer w = new WildcardPlayer();
            WildcardPlayerDataAnalysis data = new WildcardPlayerDataAnalysis(w);
            CallAllRead(w, data, firstName, routineType);
        }
        else if (routineType.equals("Prelim")) {
            PrelimPlayer pp = new PrelimPlayer();
            PrelimPlayerDataAnalysis data = new PrelimPlayerDataAnalysis(pp);
            CallAllRead(pp, data, firstName, routineType);
        }
        else if (routineType.equals("Semi")) {
            SemiPlayer s = new SemiPlayer();
            SemiPlayerDataAnalysis data = new SemiPlayerDataAnalysis(s);
            CallAllRead(s, data, firstName, routineType);
        }
        else if (routineType.equals("Two Minute Final")) {
            TwoMinuteFinalPlayer t = new TwoMinuteFinalPlayer();
            TwoMinuteFinalPlayerDataAnalysis data = new TwoMinuteFinalPlayerDataAnalysis(t);
            CallAllRead(t, data, firstName, routineType);

        }
        else if (routineType.equals("World Final")) {
            WorldFinalPlayer f = new WorldFinalPlayer();
            WorldFinalPlayerDataAnalysis data = new WorldFinalPlayerDataAnalysis(f);
            CallAllRead(f, data, firstName, routineType);
        }
    }

    //EFFECTS: Calls the read methods of player and playerDataAnalysis
    public void CallAllRead(Player p, PlayerDataAnalysis data, String firstName, String routineType) throws IOException {
        p.read(firstName + "_" + routineType + "_player.csv");
        data.read(firstName + "_" + routineType + "_playerDataAnalysis.csv");
    }

    //EFFECTS: Calls the save methods of player and playerDataAnalysis
    public void callAllSave(Player p, PlayerDataAnalysis data, String firstName, String routineType) throws IOException {
        p.setRoutineType(routineType);
        p.save(firstName + "_" + routineType + "_player.csv");
        data.save(firstName + "_" + routineType + "_playerDataAnalysis.csv");
    }

    public String retrieveRoutineType(String choice) throws IncorrectUserInputException {
        if (choice.equals("start")) {
            System.out.println("Input the routine type (Wildcard, Prelim, Semi, Two Minute Final, World Final): ");
        }
        if (choice.equals("read")) {
            System.out.println("Type in the routine type(Wildcard, Prelim, Semi, Two Minute Final, World Final) of the player you would like to view");
        }
        if (choice.equals("competition")) {
            System.out.println("What type of competition is it? (Wildcard, Prelim, Semi, Two Minute Final, World Final)");
        }
        String routineChoice = scanner.nextLine();
        if(routineTypes.contains(routineChoice)) {
            return routineChoice;
        }
        else{
            throw new IncorrectUserInputException("You inputted an invalid routine type");
        }
    }

    public static void competitionMode(YoYoJudge yyjh, String choice) throws IOException {
            Scanner scanner = new Scanner(System.in);
            Competition c = new Competition();
            System.out.println("Type start to start judging a competition or read to read competition data from memory");
            String startOrRead = scanner.nextLine();
            if (startOrRead.equals("start")) {
                String routineType = null;
                try {
                    routineType = yyjh.retrieveRoutineType(choice);
                } catch (IncorrectUserInputException e) {
                    System.out.println(e.getMessage());
                    competitionMode(yyjh,choice);
                }
                System.out.println("What is the name of the competition you are judging");
                String competitionName = scanner.nextLine();
                while (true) {
                    PlayerDataAnalysis data = yyjh.start(routineType);
                    c.addPlayerDataAnalysis(data);
                    c.addPlayer(data.getPlayer());
                    System.out.println("Is there another player to judge in this competition yes or no");
                    String anotherPlayer = scanner.nextLine();
                    String space = scanner.nextLine();
                    if (anotherPlayer.equals("no")) {
                        c.save(competitionName);
                        break;
                    }
                }
            }
            else if (startOrRead.equals("read")) {
                System.out.println("What competition would you like to read from memory?");
                String competitionName = scanner.next();
                c.read(competitionName);
            }
        }

        public void individualMode(YoYoJudge yyjh){
            System.out.println("Type start to start judging a player or read to read from memory");
            String choice = scanner.nextLine();
            if (choice.equals("start")) {
                try {
                    try {
                        start(yyjh.retrieveRoutineType(choice));
                    } catch (IncorrectUserInputException e) {
                        System.out.println(e.getMessage());
                        individualMode(yyjh);
                    }
                } catch (IOException e) {
                    System.out.println("Data save problem");
                }
            } else if (choice.equals("read")) {
                System.out.println("Type in the name of a player who has already been judged");
                String firstName = scanner.nextLine();
                String routineType = null;
                try {
                    routineType = retrieveRoutineType(choice);
                } catch (IncorrectUserInputException e) {
                    System.out.println(e.getMessage());
                    individualMode(yyjh);
                }
                try {
                    readFromMemory(firstName, routineType);
                }
                catch (IOException e) {
                    System.out.println("Player name and routine type combination inputted is not saved in memory");
                }
            }
        }

        public static void main (String[]args) throws IOException {
            Scanner scanner = new Scanner(System.in);
            YoYoJudge yyjh = new YoYoJudge();
            System.out.println("Welcome to the yo-yo judging application");
            System.out.println("Type competition to begin competition mode and individual to begin individual player mode");
            String competitionOrPlayerMode;
            competitionOrPlayerMode = scanner.nextLine();
            if (competitionOrPlayerMode.equals("competition")) {
                competitionMode(yyjh,competitionOrPlayerMode);
            }
            else if (competitionOrPlayerMode.equals("individual")) {
                yyjh.individualMode(yyjh);

            }
        }
    }
