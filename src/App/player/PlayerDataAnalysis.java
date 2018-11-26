package App.player;

import App.Exceptions.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static App.player.Player.ANALYZEDDATA;
import static App.player.Player.NEGATIVE;
import static App.player.Player.POSITIVE;

public abstract class PlayerDataAnalysis extends Loadable implements Saveable, DataAnalysis{

    protected Player player;
    protected static final int TILTED = 10; //an arbitrary number for now -> will vary depending on the routine length in the future
    protected static final int FIRE = 10; //an arbitrary number for now
    protected static final double TECHWEIGHT = 0.6;
    protected static final double EVALWEIGHT = 0.4;
    protected static final String STRINGBREAK  = "---------------------------------------";
    protected static final String SCORESFROMMEMORY  = "Player data analysis information from memory";
    protected int numberOfFireSectionsInRoutine = 0;
    protected int numberOfTiltedSectionsInRoutine = 0;
    protected double CPS = 0;
    protected double CR = 0;
    protected int numberIfPerfect = 0;
    protected double CIPPS = 0;
    protected double totalMajors = 0;
    protected double totalEvalScore = 0;
    protected double totalWeightedScore = 0;
    protected String saveLocation = "playerDataAnalysis.csv";


    //CONSTRUCTOR
    public PlayerDataAnalysis(Player player) {
        this.player = player;
    }

    //MODIFIES: This
    //EFFECTS: Sets the save location to a different location from default
    public void setSaveLocation(String saveLocation) {
        this.saveLocation = saveLocation;
    }

    //EFFECTS: Returns the App.player
    public Player getPlayer() { return player; }
    //EFFECTS: Returns the save location
    public String getSaveLocation() {
        return saveLocation;
    }

    //EFFECTS: Returns the number if perfect
    public int getNumberIfPerfect() {
        return numberIfPerfect;
    }

    //EFFECTS: Returns the number of fire sections in the routine
    public int getNumberOfFireSectionsInRoutine() {
        return numberOfFireSectionsInRoutine;
    }

    //EFFECTS: Returns the number of tilted sections in the routine
    public int getNumberOfTiltedSectionsInRoutine() {
        return numberOfTiltedSectionsInRoutine;
    }

    //EFFECTS: Returns the total majors of the routine
    public double getTotalMajors() { return totalMajors; }

    //EFFECTS: Returns the total weighted score fo the routine
    public double getTotalWeightedScore() { return totalWeightedScore; }

    //EFFECTS: Returns the CPS of the App.player
    public double getCPS() {
        return CPS;
    }

    //EFFECTS: Returns the CR of the App.player
    public double getCR() { return CR; }

    //EFFECTS: Returns the CIPPS of the App.player
    public double getCIPPS() { return CIPPS; }

    public void setNumberOfFireSectionsInRoutine(int numberOfFireSectionsInRoutine) {
        this.numberOfFireSectionsInRoutine = numberOfFireSectionsInRoutine;
    }

    public void setNumberOfTiltedSectionsInRoutine(int numberOfTiltedSectionsInRoutine) {
        this.numberOfTiltedSectionsInRoutine = numberOfTiltedSectionsInRoutine;
    }

    //EFFECTS: Will count the number of FIRE or TILTED sections in a routine
    public int clicksOnFireOrTilt(String determiner, String other, int comparator){
        int numberOfPositiveOrNegativeInRow  = 0;
        int numberOfSectionsInRoutine = 0;
        for (String click: player.clicksLog){
            if (click.equals(determiner)){
                numberOfPositiveOrNegativeInRow++;
            }
            else if (click.equals(other)){
                numberOfPositiveOrNegativeInRow = 0;
            }
            if (numberOfPositiveOrNegativeInRow == comparator){
                numberOfSectionsInRoutine++;
                numberOfPositiveOrNegativeInRow = 0;
            }
        }
        return numberOfSectionsInRoutine;
    }

    //MODIFIES: This, App.player
    //EFFECTS: Clears the clicks log and sets the number of titled and fire sections in the routine to zero
    public void resetFireTilt() {
        player.getClicksLog().clear();
        numberOfTiltedSectionsInRoutine = 0;
        numberOfFireSectionsInRoutine = 0;
    }

    //REQUIRES: RoutineLength > 0
    //MODIFIES: This
    //EFFECTS: Will return the number of clicks per second of a routine
    public void clicksPerSecond() {
        CPS = player.getClickerScore() / player.getRoutineLength();
    }

    //MODIFIES: This
    //EFFECTS: Returns the click ratio (negative to positive clicks) of the App.player
    public void clickRatio() throws DataCalculationException {
        if (player.getPositiveClicks() == 0 & player.getNegativeClicks() > 0) {
            CR = 0;
            throw new DataCalculationException(player.getFirstName() + " just had negative clicks, cannot produce a click ratio score");
        } else if (player.getPositiveClicks() == 0 & player.getNegativeClicks() == 0) {
            CR = 0;
        } else {
            CR = player.getNegativeClicks() / player.getPositiveClicks();
        }
    }

    //MODIFIES: This
    //EFFECTS: produces the total eval score
    public void produceTotalEvalScore (){
        totalEvalScore += player.getExecution();
        totalEvalScore += player.getBodyControl();
        totalEvalScore += player.getControl();
        totalEvalScore += player.getChoreography();
    }

    //MODIFIES: This
    //EFFECTS: produces the total eval score based off of IYYF rulings
    public void produceTotalWeightedScore (){
        produceTotalEvalScore();
        totalWeightedScore = (totalEvalScore * EVALWEIGHT) + (player.clickerScore * TECHWEIGHT);
    }

    //MODIFIES: This
    //EFFECTS: produces the total majors based off of IYYF rulings
    public void produceTotalMajors (){
        totalMajors += player.getChangeFinal();
        totalMajors += player.getDiscardFinal();
        totalMajors += player.getRestartFinal();
    }


    //MODIFIES: This
    //EFFECTS: Returns a predicted Clicker score value if the App.player had zero mistakes
    public void clicksIfPerfect (){
        numberIfPerfect = (int) (player.getPositiveClicks() + (2 * player.getNegativeClicks()));
    }

    //MODIFIES: This
    //EFFECTS: Returns the clicks if perfect per second
    public void clicksIfPerfectPerSecond(){
        this.clicksIfPerfect();
        CIPPS = (double)this.numberIfPerfect/player.getRoutineLength();
    }

    //MODIFIES: This
    //EFFECTS: Performs all App.player data analysis methods
    public void callAllDataAnalysis() {
        numberOfFireSectionsInRoutine = clicksOnFireOrTilt(POSITIVE,NEGATIVE,FIRE);
        numberOfTiltedSectionsInRoutine = clicksOnFireOrTilt(NEGATIVE,POSITIVE,TILTED);
        clicksPerSecond();
        try {
            clickRatio();
        } catch (DataCalculationException e) {
            System.out.println(e.getMessage());
        }
        clicksIfPerfect();
        clicksIfPerfectPerSecond();
        produceTotalWeightedScore();
        produceTotalMajors();
    }

    //EFFECTS: Will save data analysis information to csv file
    @Override
    public void save(String saveLocation) throws IOException {
        PrintWriter pw = new PrintWriter(new FileOutputStream(saveLocation, false));
        pw.write(toSaveString());
        pw.close();

    }

    //REQUIRES: Save location to exist in memory
    //EFFECTS: Will output App.player analysis information from saved file
    @Override
    public void load(String saveLocation) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(saveLocation));
        String line  = lines.get(0);
        ArrayList<String> partsOfLine = splitOnComma(line);
        printLoadOutput(partsOfLine);
        loadOutput(partsOfLine);
        System.out.println(STRINGBREAK);
    }

    //EFFECTS: Creates a string of App.player data analysis information
    public String toSaveString(){
        StringBuilder sb = new StringBuilder();
        sb.append(player.getFirstName());
        sb.append(",");
        sb.append(player.getLastName());
        sb.append(",");
        sb.append(numberOfFireSectionsInRoutine);
        sb.append(",");
        sb.append(numberOfTiltedSectionsInRoutine);
        sb.append(",");
        sb.append(CPS);
        sb.append(",");
        sb.append(CR);
        sb.append(",");
        sb.append(numberIfPerfect);
        sb.append(",");
        sb.append(CIPPS);
        sb.append(",");
        sb.append(totalWeightedScore);
        sb.append("\n");
        return sb.toString();
    }

    //EFFECTS: Prints App.player data analysis information from memory
    public void printLoadOutput(ArrayList<String> partsOfLine){
        System.out.println(STRINGBREAK);
        String fullName = partsOfLine.get(0) + " " + partsOfLine.get(1) + "'s ";
        System.out.println(fullName + ANALYZEDDATA );
        System.out.println("total weighted score: " + partsOfLine.get(7));
        System.out.println("Fire sections in routine: " + partsOfLine.get(2));
        System.out.println("Tilted sections in routine: " + partsOfLine.get(3));
        System.out.println("Clicks per second: " + partsOfLine.get(4));
        System.out.println("Click ratio: " + partsOfLine.get(5));
        System.out.println("Clicks if perfect: " + partsOfLine.get(6));
    }

    //EFFECTS: Reads App.player data analysis information from memory
    public void loadOutput(ArrayList<String> partsOfLine){
        player.setFirstName(partsOfLine.get(0));
        player.setLastName(partsOfLine.get(1));
        numberOfFireSectionsInRoutine = Integer.parseInt(partsOfLine.get(2));
        numberOfTiltedSectionsInRoutine = Integer.parseInt(partsOfLine.get(3));
        CPS = Double.parseDouble(partsOfLine.get(4));
        CR = Double.parseDouble(partsOfLine.get(5));
        numberIfPerfect = Integer.parseInt(partsOfLine.get(6));
        CIPPS = Double.parseDouble(partsOfLine.get(7));
    }

    //EFFECTS: Prints analyzed routine information of a player
    public void printAnalyzedRoutineInformation(PlayerDataAnalysis data, Player p) {
        System.out.println(p.getFirstName() + " " + p.getLastName() + "'s analyzed technical data:");
        System.out.println("Total majors: " + data.getTotalMajors());
        System.out.println("Total weighted score: " + data.getTotalWeightedScore());
        System.out.println("Fire sections in routine: " + data.getNumberOfFireSectionsInRoutine());
        System.out.println("Tilted sections in routine: " + data.getNumberOfTiltedSectionsInRoutine());
        System.out.println("Clicks per second: " + data.getCPS());
        System.out.println("Clicks ratio: " + data.getCR());
        System.out.println("Clicks if perfect: " + data.getNumberIfPerfect());
        System.out.println("Clicks if perfect per second:" + data.getCIPPS());
        System.out.println(STRINGBREAK);
    }

}
