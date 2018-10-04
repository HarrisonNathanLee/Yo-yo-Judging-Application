package ui;

import player.Player;
import player.PlayerDataAnalysis;

import java.io.IOException;
import java.util.Scanner;

public class YoYoJudge {
    Scanner scanner = new Scanner(System.in);

    public YoYoJudge() {
    }

    //EFFECTS: Starts the yo-yo judging application
    public void start() throws IOException {
        Player p = new Player();
        PlayerDataAnalysis data = new PlayerDataAnalysis(p);
        setPlayerInformation(p);
        clicker(p,data);
        System.out.println(p.getFirstName()+" "+ p.getLastName()+" positive clicks: "+p.getPositiveClicks());
        System.out.println(p.getFirstName()+" "+ p.getLastName()+" negative clicks: "+p.getNegativeClicks());
        System.out.println(p.getFirstName()+" "+ p.getLastName() +" final reset score is: "+p.getRestartFinal());
        System.out.println(p.getFirstName()+" "+p.getLastName()+" final change score is: "+p.getChangeFinal());
        System.out.println(p.getFirstName()+" "+p.getLastName()+" final discard score is: " +p.getDiscardFinal());
        setPerformanceEvals(p);
        getPerformanceEvals(p);
        data.callAllDataAnalysis();
        System.out.println("Fire sections in routine: " +data.getNumberOfFireSectionsInRoutine());
        System.out.println("Tilted sections in routine: " +data.getNumberOfTiltedSectionsInRoutine());
        System.out.println("Clicks per second: " + data.getCPS());
        System.out.println("Clicks ratio: " + data.getCR());
        System.out.println("The player's clicks if perfect: " + data.getNumberIfPerfect());
        System.out.println("-------------------------------------------");
        p.save(p.getSaveLocation());
        //System.out.println("Reading saved data");
        //p.read();
        data.save(data.getSaveLocation());
        //System.out.println("Reading saved data");
        //data.read();
    }

    //MODIFIES: This, player
    //EFFECTS: Records information for a given player
    public void setPlayerInformation(Player p) {
        System.out.println("A yo-yo judging application");
        System.out.println("Player first name: ");
        String firstName = scanner.nextLine();
        System.out.println("Player last name: ");
        String lastName = scanner.nextLine();
        System.out.println("Player division: ");
        String division = scanner.nextLine();
        System.out.println("Input the length of the routine in seconds: ");
        int routineLength = scanner.nextInt();
        p.setFirstName(firstName);
        p.setLastName(lastName);
        p.setDivision(division);
        p.setRoutineLength(routineLength);
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
    public void getPerformanceEvals(Player p) {
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


    //EFFECTS: Will read from memory
    public void readFromMemory() throws IOException {
        Player p = new Player();
        PlayerDataAnalysis data = new PlayerDataAnalysis(p);
        p.read(p.getSaveLocation());
        data.read(data.getSaveLocation());
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        YoYoJudge yyjh = new YoYoJudge();
        System.out.println("Welcome to the yo-yo judging application");
        System.out.println("Type start to start judging a player");
        System.out.println("Type read to read from memory");
        String choice = "";
        choice = scanner.nextLine();
        if (choice.equals("start")){
            yyjh.start();
        }
        if (choice.equals("read")){
            yyjh.readFromMemory();
        }
    }
}

