package player;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public abstract class PlayerDataAnalysis implements Saveable, Readable{
    protected Player player;
    protected static final int TILTED = 10; //an arbitrary number for now -> will vary depending on the routine length in the future
    protected static final int FIRE = 10; //an arbitrary number for now
    protected int numberOfFireSectionsInRoutine = 0;
    protected int numberOfTiltedSectionsInRoutine = 0;
    protected double CPS = 0;
    protected double CR = 0;
    protected int numberIfPerfect = 0;
    protected double CIPPS = 0;
    protected String saveLocation = "playerDataAnalysis.csv";

    public PlayerDataAnalysis(Player player) {
        this.player = player;
    }

    //MODIFIES: This
    //EFFECTS: Sets the save location to a different location from default
    public void setSaveLocation(String saveLocation) {
        this.saveLocation = saveLocation;
    }

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

    //EFFECTS: Returns the CPS of the player
    public double getCPS() {
        return CPS;
    }

    //EFFECTS: Returns the CR of the player
    public double getCR() { return CR; }

    //EFFECTS: Returns the CIPPS of the player
    public double getCIPPS() { return CIPPS; }


    //EFFECTS: Will count the number of FIRE(judge has awarded multiple clicks in a row) sections in a routine
    public void clicksOnFire() {
        int numberOfPositiveInRow = 0;
        for (String click : player.clicksLog) {
            if (click.equals("positive")) {
                numberOfPositiveInRow++;
            } else if (click.equals("negative")) {
                numberOfPositiveInRow = 0;
            }
            if (numberOfPositiveInRow == FIRE) {
                this.numberOfFireSectionsInRoutine++;
                numberOfPositiveInRow = 0;
            }
        }
    }

    //EFFECTS: Will count the number of TILTED(judge has deducted multiple clicks in a row) sections in a routine
    public void clicksOnTilt() {
        int numberOfNegativeInRow = 0;
        for (String click : player.clicksLog) {
            if (click.equals("negative")) {
                numberOfNegativeInRow++;
            } else if (click.equals("positive")) {
                numberOfNegativeInRow = 0;
            }

            if (numberOfNegativeInRow == TILTED) {
                this.numberOfTiltedSectionsInRoutine++;
                numberOfNegativeInRow = 0;
            }
        }
    }

    //MODIFIES: This, player
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
    //EFFECTS: Returns the click ratio (negative to positive clicks) of the player
    public void clickRatio() {
        if (player.getPositiveClicks() == 0 & player.getNegativeClicks() > 0) {
            CR = 0;
            System.out.println(player.getFirstName() + " just had negative clicks, cannot produce a click ratio score");
        } else if (player.getPositiveClicks() == 0 & player.getNegativeClicks() == 0) {
            CR = 0;
        } else {
            CR = player.getNegativeClicks() / player.getPositiveClicks();
        }
    }

    //MODIFIES: This
    //EFFECTS: Returns a predicted clicker score value if the player had zero mistakes
    public void clicksIfPerfect (){
        numberIfPerfect = (int) (player.getPositiveClicks() + (2 * player.getNegativeClicks()));
    }

    //MODIFIES: This
    //EFFECTS: Returns the clicks if perfect per second
    public void clicksIfPerfectPerSecond(){
        this.clicksIfPerfect();
        this.CIPPS = (double)this.numberIfPerfect/player.getRoutineLength();
    }

    //MODIFIES: This
    //EFFECTS: Performs all player data analysis methods
    public void callAllDataAnalysis() {
        this.clicksOnFire();
        this.clicksOnTilt();
        this.clicksPerSecond();
        this.clickRatio();
        this.clicksIfPerfect();
        this.clicksIfPerfectPerSecond();
    }

    //EFFECTS: Will save data analysis information to csv file
    @Override
    public void save(String saveLocation) throws IOException {
        PrintWriter pw = new PrintWriter(new FileOutputStream(saveLocation, false));
        pw.write(playerDataAnalysisToSaveString());
        pw.close();

    }

    //REQUIRES: Save location to exist in memory
    //EFFECTS: Will output player analysis information from saved file
    @Override
    public void read(String saveLocation) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(saveLocation));
        String line  = lines.get(0);
        ArrayList<String> partsOfLine = splitOnComma(line);
        System.out.println("Player data analysis information from memory");
        System.out.println("---------------------------------------");
        System.out.println("firstName: " + partsOfLine.get(0) + " ");
        System.out.println("lastName: " + partsOfLine.get(1) + " ");
        System.out.println("numberOfFireSectionsInRoutine: " + partsOfLine.get(2) + " ");
        System.out.println("numberOfTiltedSectionsInRoutine: " + partsOfLine.get(3) + " ");
        System.out.println("CPS: " + partsOfLine.get(4) + " ");
        System.out.println("CR: " + partsOfLine.get(5) + " ");
        System.out.println("numberIfPerfect: " + partsOfLine.get(6) + " ");
        playerDataAnalysisReadOutput(partsOfLine);
        System.out.println("---------------------------------------");
        }

    public static ArrayList<String> splitOnComma(String line) {
        String[] splits = line.split(",");
        return new ArrayList<>(Arrays.asList(splits));
    }

    public String playerDataAnalysisToSaveString(){
        StringBuilder sb = new StringBuilder();
        sb.append(player.getFirstName());
        sb.append(",");
        sb.append(player.getLastName());
        sb.append(",");
        sb.append(this.numberOfFireSectionsInRoutine);
        sb.append(",");
        sb.append(this.numberOfTiltedSectionsInRoutine);
        sb.append(",");
        sb.append(this.CPS);
        sb.append(",");
        sb.append(this.CR);
        sb.append(",");
        sb.append(this.numberIfPerfect);
        sb.append(",");
        sb.append(this.CIPPS);
        sb.append("\n");
        return sb.toString();
    }

    public void playerDataAnalysisReadOutput(ArrayList<String> partsOfLine){
        player.setFirstName(partsOfLine.get(0));
        player.setLastName(partsOfLine.get(1));
        this.numberOfFireSectionsInRoutine = Integer.parseInt(partsOfLine.get(2));
        this.numberOfTiltedSectionsInRoutine = Integer.parseInt(partsOfLine.get(3));
        this.CPS = Double.parseDouble(partsOfLine.get(4));
        this.CR = Double.parseDouble(partsOfLine.get(5));
        this.numberIfPerfect = Integer.parseInt(partsOfLine.get(6));
        this.CIPPS = Double.parseDouble(partsOfLine.get(7));
    }

}

//TODO: Implement when I have a UI and can get timer functionality working
    /*

    //REQUIRES:
    //MODIFIES: this
    //EFFECTS: Creates intervals of time depending on how long the routine is
    public void createIntervals(){
        return true;
    }

    //REQUIRES:
    //MODIFIES: this
    //EFFECTS: Generates a value for titled and fire depending on how long the routine is
    public void createTiltedFire(){
        return true;
    }

    //REQUIRES:
    //MODIFIES:
    //EFFECTS: Will return the number of clicks per the number of intervals in a routine
    public void clicksPerInterval(){
        return true;
    }

    //REQUIRES:
    //MODIFIES:
    //EFFECTS: Will assign each click to the time the click was pressed throughout the duration of the routine
    public void mapClicksToTime (){
        return true;
    }
    */