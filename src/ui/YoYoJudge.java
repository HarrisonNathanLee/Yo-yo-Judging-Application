package ui;

import Competition.Competition;
import player.*;
import java.io.IOException;
import java.util.Scanner;

public class YoYoJudge {
    Scanner scanner = new Scanner(System.in);

    public YoYoJudge() {
    }

    //EFFECTS: Starts the yo-yo judging application
    public Player start() throws IOException {
        System.out.println("Input the routine type (Wildcard, Prelim, Semi, Two Minute Final, World Final): ");
        String routineType = scanner.nextLine();
        if (routineType.equals("Wildcard")) {
            // create a helper function which allows us to re use code
            WildcardPlayer w = new WildcardPlayer();
            WildcardPlayerDataAnalysis data = new WildcardPlayerDataAnalysis(w);
            setPlayerInformation(w);
            w.setRoutineLength(30);
            wildcardClicker(w);
            System.out.println(w.getFirstName()+" "+ w.getLastName()+" positive clicks: "+w.getPositiveClicks());
            data.callAllDataAnalysis();
            System.out.println("Clicks per second: " + data.getCPS());
            System.out.println("-------------------------------------------");
            String inputPlayerName = w.getFirstName();
            callAllSave(w,data,inputPlayerName,routineType);
            return w;
        }
        else if(routineType.equals("Prelim")){
            PrelimPlayer pp = new PrelimPlayer();
            PrelimPlayerDataAnalysis data = new PrelimPlayerDataAnalysis(pp);
            setPlayerInformation(pp);
            pp.setRoutineLength(60);
            clicker(pp,data);
            printRawRoutineInformation(pp);
            setPerformanceEvals(pp);
            getPerformanceEvals(pp);
            data.callAllDataAnalysis();
            printAnalyzedRoutineInformation(data);
            String inputPlayerName = pp.getFirstName();
            callAllSave(pp,data,inputPlayerName,routineType);
            return pp;
        }
        else if(routineType.equals("Semi")){
            SemiPlayer s = new SemiPlayer();
            SemiPlayerDataAnalysis data = new SemiPlayerDataAnalysis(s);
            setPlayerInformation(s);
            s.setRoutineLength(90);
            clicker(s,data);
            printRawRoutineInformation(s);
            setPerformanceEvals(s);
            getPerformanceEvals(s);
            data.callAllDataAnalysis();
            printAnalyzedRoutineInformation(data);
            String inputPlayerName = s.getFirstName();
            callAllSave(s,data,inputPlayerName,routineType);
            return s;
        }
        else if(routineType.equals("Two Minute Final")){
            TwoMinuteFinalPlayer t = new TwoMinuteFinalPlayer();
            TwoMinuteFinalPlayerDataAnalysis data = new TwoMinuteFinalPlayerDataAnalysis(t);
            setPlayerInformation(t);
            t.setRoutineLength(120);
            clicker(t,data);
            printRawRoutineInformation(t);
            setPerformanceEvals(t);
            getPerformanceEvals(t);
            data.callAllDataAnalysis();
            printAnalyzedRoutineInformation(data);
            String inputPlayerName = t.getFirstName();
            callAllSave(t,data,inputPlayerName,routineType);
            return t;
        }
        else if(routineType.equals("World Final")){
            WorldFinalPlayer f = new WorldFinalPlayer();
            WorldFinalPlayerDataAnalysis data = new WorldFinalPlayerDataAnalysis(f);
            setPlayerInformation(f);
            f.setRoutineLength(180);
            clicker(f,data);
            printRawRoutineInformation(f);
            setWorldPerformanceEvals(f);
            getWorldPerformanceEvals(f);
            data.callAllDataAnalysis();
            printAnalyzedRoutineInformation(data);
            String inputPlayerName = f.getFirstName();
            callAllSave(f,data,inputPlayerName,routineType);
            return f;
        }
        return null;
    }

    //EFFECTS: Prints various post performance information
    public void printRawRoutineInformation(Player p){
        System.out.println(p.getFirstName()+" "+ p.getLastName()+" positive clicks: "+p.getPositiveClicks());
        System.out.println(p.getFirstName()+" "+ p.getLastName()+" negative clicks: "+p.getNegativeClicks());
        System.out.println(p.getFirstName()+" "+ p.getLastName() +" final reset score is: "+p.getRestartFinal());
        System.out.println(p.getFirstName()+" "+p.getLastName()+" final change score is: "+p.getChangeFinal());
        System.out.println(p.getFirstName()+" "+p.getLastName()+" final discard score is: " +p.getDiscardFinal());
    }

    //EFFECTS: Prints analyzed routine information of a player
    public void printAnalyzedRoutineInformation(PlayerDataAnalysis data){
        System.out.println("Fire sections in routine: " +data.getNumberOfFireSectionsInRoutine());
        System.out.println("Tilted sections in routine: " +data.getNumberOfTiltedSectionsInRoutine());
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
    public void wildcardClicker(Player p){
        String keyPress = "";
        System.out.println("Press the j key to increment the player's score.");
        System.out.println("Press the i key to reset the players clickerscore");
        System.out.println("Type stop to exit");
        while (true) {
            keyPress = scanner.nextLine();
            if (keyPress.equals("j")) {
                p.awardClick();
            }
            else if (keyPress.equals("i")) {
                p.resetClicks();
            }
            else if (keyPress.equals("stop")) {
                p.produceClickerScore();
                break;
            }
        }
    }

    //MODIFIES: This, player
    //EFFECTS: Will increase/decrease the clicker score of a player and then return the clicker score after the routine is over
    public void clicker(Player p, PlayerDataAnalysis data){
        String keyPress = "";
        System.out.println("Press the j key to increment and the f key to decrement the player's score.");
        System.out.println("Press the q key to give the player a restart");
        System.out.println("Press the w key to give the player a change");
        System.out.println("Press the e key to give the player a discard");
        System.out.println("Press the i key to reset the players clickerscore");
        System.out.println("Press the o key to reset the players major deduct score");
        System.out.println("Press the p key to reset everything");
        System.out.println("Type stop to exit");
        while (true) {
            keyPress = scanner.nextLine();
            if (keyPress.equals("f")) {
                p.removeClick();
            }
            else if (keyPress.equals("j")) {
                p.awardClick();
            }
            else if (keyPress.equals("q")) {
                p.restart();
            }
            else if (keyPress.equals("w")) {
                p.change();
            }
            else if (keyPress.equals("e")) {
                p.discard();
            }
            else if (keyPress.equals("i")){
                p.resetClicks();
                data.resetFireTilt();
            }
            else if (keyPress.equals("o")){
                p.resetMajorDeducts();
            }
            else if (keyPress.equals("p")) {
                p.resetEverything();
                data.resetFireTilt();
            }
            else if (keyPress.equals("stop")) {
                p.produceClickerScore();
                break;
            }
        }
    }

    //MODIFIES: This, player
    //EFFECTS: Records judge's performance evaluation scores for a given player
    public void setPerformanceEvals (Player p) {
        System.out.println("Execution score is: ");
        int execution = scanner.nextInt();
        System.out.println("Control score is: ");
        int control = scanner.nextInt();
        System.out.println("Music Use 1: Choreography score is: ");
        int choreograhpy = scanner.nextInt();
        System.out.println("Body Control score is: ");
        int bodyControl = scanner.nextInt();
        p.setExecution(execution);
        p.setControl(control);
        p.setChoreography(choreograhpy);
        p.setBodyControl(bodyControl);

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
    public void setWorldPerformanceEvals (Player p) {
        System.out.println("Execution score is: ");
        int execution = scanner.nextInt();
        System.out.println("Control score is: ");
        int control = scanner.nextInt();
        System.out.println("Trick Diversity score is: ");
        int trickDiversity = scanner.nextInt();
        System.out.println("Space Use & Emphasis score is: ");
        int spaceUseAndEmphasis = scanner.nextInt();
        System.out.println("Music Use 1: Choreography score is: ");
        int choreograhpy = scanner.nextInt();
        System.out.println("Music Use 2: Consruction score is: ");
        int construction = scanner.nextInt();
        System.out.println("Body Control score is: ");
        int bodyControl = scanner.nextInt();
        System.out.println("Showmanship score is: ");
        int showmanship = scanner.nextInt();
        p.setExecution(execution);
        p.setControl(control);
        p.setTrickDiversity(trickDiversity);
        p.setSpaceUseAndEmphasis(spaceUseAndEmphasis);
        p.setChoreography(choreograhpy);
        p.setConstruction(construction);
        p.setBodyControl(bodyControl);
        p.setShowmanship(showmanship);
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
    public void readFromMemory(String inputPlayerName, String inputRoutineType) throws IOException {
        if (inputRoutineType.equals("Wildcard")) {
            WildcardPlayer w = new WildcardPlayer();
            WildcardPlayerDataAnalysis data = new WildcardPlayerDataAnalysis(w);
            CallAllRead(w,data,inputPlayerName,inputRoutineType);
        }
        else if(inputRoutineType.equals("Prelim")){
            PrelimPlayer pp = new PrelimPlayer();
            PrelimPlayerDataAnalysis data = new PrelimPlayerDataAnalysis(pp);
            CallAllRead(pp,data,inputPlayerName,inputRoutineType);
        }
        else if(inputRoutineType.equals("Semi")){
            SemiPlayer s = new SemiPlayer();
            SemiPlayerDataAnalysis data = new SemiPlayerDataAnalysis(s);
            CallAllRead(s,data,inputPlayerName,inputRoutineType);
        }
        else if(inputRoutineType.equals("Two Minute Final")){
            TwoMinuteFinalPlayer t = new TwoMinuteFinalPlayer();
            TwoMinuteFinalPlayerDataAnalysis data = new TwoMinuteFinalPlayerDataAnalysis(t);
            CallAllRead(t,data,inputPlayerName,inputRoutineType);

        }
        else if(inputRoutineType.equals("World Final")){
            WorldFinalPlayer f = new WorldFinalPlayer();
            WorldFinalPlayerDataAnalysis data = new WorldFinalPlayerDataAnalysis(f);
            CallAllRead(f,data,inputPlayerName,inputRoutineType);
        }
    }

    //EFFECTS: Calls the read methods of player and playerDataAnalysis
    public void CallAllRead(Player p, PlayerDataAnalysis data, String inputPlayerName, String inputRoutineType) throws IOException {
        p.read(inputPlayerName+ "_"+inputRoutineType+"_player.csv");
        data.read(inputPlayerName+ "_"+inputRoutineType+"_playerDataAnalysis.csv");
    }

    //EFFECTS: Calls the save methods of player and playerDataAnalysis
    public void callAllSave(Player p, PlayerDataAnalysis data, String inputPlayerName, String inputRoutineType) throws IOException {
        p.setRoutineType(inputRoutineType);
        p.save(inputPlayerName+"_"+inputRoutineType+"_player.csv");
        data.save(inputPlayerName+"_"+inputRoutineType+"_playerDataAnalysis.csv");
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        YoYoJudge yyjh = new YoYoJudge();
        System.out.println("Welcome to the yo-yo judging application");
        System.out.println("Type competition to begin competition mode and individual to begin individual player mode");
        String competitionOrPlayerMode = "";
        competitionOrPlayerMode = scanner.nextLine();
        if (competitionOrPlayerMode.equals("competition")) {
            System.out.println("What type of competition is it? (Wildcard, Prelim, Semi, Two Minute Final, World Final)");
            String typeOfCompetition = scanner.nextLine();
            Competition c = new Competition();
            while (true) {
                Player p = yyjh.start(); //start method asks for the type of player
                c.addPlayer(p);
                System.out.println("Is there another player to judge in this competition yes or no");
                String anotherPlayer = "";
                anotherPlayer = scanner.nextLine();
                if (anotherPlayer.equals("no")){
                    c.save("Test_competition");
                    break;
                }
            }

        }
        else if (competitionOrPlayerMode.equals("individual")) {
            System.out.println("Type start to start judging a player");
            System.out.println("Type read to read from memory");
            String choice = "";
            String inputPlayerName = "";
            String inputRoutineType = "";
            choice = scanner.nextLine();
            if (choice.equals("start")) {
                yyjh.start();
            } else if (choice.equals("read")) {
                System.out.println("Type in the name of a player who has already been judged");
                inputPlayerName = scanner.nextLine();
                System.out.println("Type in the routine type(Wildcard, Prelim, Semi, Two Minute Final, World Final) of the player you would like to view");
                inputRoutineType = scanner.nextLine();
                yyjh.readFromMemory(inputPlayerName, inputRoutineType);
                yyjh.start();
            }
        }
    }

}

