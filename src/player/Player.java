package player;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Player implements Saveable, Readable {
    private String firstName = "";
    private String lastName = "";
    private String division = "";
    private int routineLength = 0;
    private int execution = 0;
    private int control = 0;
    private int trickDiversity = 0;
    private int spaceUseAndEmphasis = 0;
    private int choreography = 0;
    private int construction = 0;
    private int bodyControl = 0;
    private int showmanship = 0;
    private double clickerScore = 0;
    private double positiveClicks = 0;
    private double negativeClicks = 0;
    private int numberOfRestarts = 0;
    private int numberOfChanges = 0;
    private int numberOfDiscards = 0;
    private int restartMultiplier = 1;
    private int changeMultiplier = 3;
    private int discardMultiplier = 5;
    private int restartFinal = 0;
    private int changeFinal = 0;
    private int discardFinal = 0;
    private String saveLocation = "player.csv";
    ArrayList<String> clicksLog = new ArrayList<String>();

    //MODIFIES: This
    //EFFECTS: Retrieves the first name of the player
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //MODIFIES: This
    //EFFECTS: Retrieves the last name of the player
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //MODIFIES: This
    //EFFECTS: Retrieves the division of the player
    public void setDivision(String division) {
        this.division = division;
    }

    //MODIFIES: This
    //EFFECTS: Retrieves the routine length of the player
    public void setRoutineLength(int routineLength) {
        this.routineLength = routineLength;
    }

    //MODIFIES: This
    //EFFECTS: Retrieves the execution score of the player
    public void setExecution(int execution) {
        this.execution = execution;
    }

    //MODIFIES: This
    //EFFECTS: Retrieves the control score of the player
    public void setControl(int control) {
        this.control = control;
    }

    //MODIFIES: This
    //EFFECTS: Retrieves the trick diversity score of the player
    public void setTrickDiversity(int trickDiversity) {
        this.trickDiversity = trickDiversity;
    }

    //MODIFIES: This
    //EFFECTS: Retrieves the space use and emphasis score of the player
    public void setSpaceUseAndEmphasis(int spaceUseAndEmphasis) {
        this.spaceUseAndEmphasis = spaceUseAndEmphasis;
    }

    //MODIFIES: This
    //EFFECTS: Retrieves the choreography score of the player
    public void setChoreography(int choreography) {
        this.choreography = choreography;
    }

    //MODIFIES: This
    //EFFECTS: Retrieves the construction score of the player
    public void setConstruction(int construction) {
        this.construction = construction;
    }

    //MODIFIES: This
    //EFFECTS: Retrieves the body control score of the player
    public void setBodyControl(int bodyControl) {
        this.bodyControl = bodyControl;
    }

    //MODIFIES: This
    //EFFECTS: Retrieves the showmanship score of the player
    public void setShowmanship(int showmanship) {
        this.showmanship = showmanship;
    }

    //MODIFIES: This
    //EFFECTS: Sets the positive clicks of the player
    public void setPositiveClicks(int positiveClicks) {this.positiveClicks = positiveClicks; }

    //MODIFIES: This
    //EFFECTS: Sets the negative clicks of the player
    public void setNegativeClicks(int negativeClicks) {this.negativeClicks = negativeClicks; }

    //MODIFIES: This
    //EFFECTS: Sets the number of restarts of the player
    public void setNumberOfRestarts(int numberOfRestarts) {this.numberOfRestarts = numberOfRestarts; }

    //MODIFIES: This
    //EFFECTS: Sets the number of changes of the player
    public void setNumberOfChanges(int numberOfChanges) {this.numberOfChanges = numberOfChanges; }

    //MODIFIES: This
    //EFFECTS: Sets the number of discards of the player
    public void setNumberOfDiscards(int numberOfDiscards) { this.numberOfDiscards = numberOfDiscards; }

    //MODIFIES: This
    //EFFECTS: Sets the number of clicker score of the player
    public void setClickerScore(double clickerScore) {
        this.clickerScore = clickerScore;
    }

    //MODIFIES: This
    //EFFECTS: Sets the save location to a different location from default
    public void setSaveLocation(String saveLocation) {
        this.saveLocation = saveLocation;
    }

    //EFFECTS: Returns the first name of the player
    public String getFirstName() {
        return firstName;
    }

    //EFFECTS: Returns the last name of the player
    public String getLastName() {
        return lastName;
    }

    //EFFECTS: Returns the clicker score of the player
    public double getClickerScore() {
        return clickerScore;
    }

    //EFFECTS: Returns the execution score of the player
    public int getExecution(){
        return execution;
    }

    //EFFECTS: Returns the control score of the player
    public int getControl(){
        return control;
    }

    //EFFECTS: Returns the trick diversity score of the player
    public int getTrickDiversity(){
        return trickDiversity;
    }

    //EFFECTS: Returns the space use and emphasis score of the player
    public int getSpaceUseAndEmphasis(){
        return spaceUseAndEmphasis;
    }

    //EFFECTS: Returns the choreography score of the player
    public int getChoreography(){
        return choreography;
    }

    //EFFECTS: Returns the construction score of the player
    public int getConstruction() {
        return construction;
    }

    //EFFECTS: Returns the body control score of the player
    public int getBodyControl (){
        return bodyControl;
    }

    //EFFECTS: Returns the showmanship score of the player
    public int getShowmanship (){
        return showmanship;
    }

    //EFFECTS: Returns the positive clicks of a player
    public double getPositiveClicks() {
        return positiveClicks;
    }

    //EFFECTS: Returns the negative clicks of the player
    public double getNegativeClicks() {
        return negativeClicks;
    }

    //EFFECTS: Returns the number of restarts of the player
    public int getNumberOfRestarts() { return numberOfRestarts; }

    //EFFECTS: Returns the number of changes of the player
    public int getNumberOfChanges() { return numberOfChanges; }

    //EFFECTS: Returns the number of discards of the player
    public int getNumberOfDiscards() { return numberOfDiscards; }

    //EFFECTS: Returns the restart multiplier
    public int getRestartMultiplier() { return restartMultiplier; }

    //EFFECTS: Returns the change multiplier
    public int getChangeMultiplier() {
        return changeMultiplier;
    }

    //EFFECTS: Returns the discard multiplier
    public int getDiscardMultiplier() { return discardMultiplier; }

    //EFFECTS: Returns the division of the player
    public String getDivision() {
        return division;
    }

    //EFFECTS: Returns the routine length
    public int getRoutineLength() {
        return routineLength;
    }


    //EFFECTS: Returns the save location
    public String getSaveLocation() {
        return saveLocation;
    }

    //EFFECTS: Returns a log of clicks
    public ArrayList<String> getClicksLog() {
        return clicksLog;
    }

    //MODIFIES: This
    //EFFECTS: Adds one to positive clicks and logs the click to clicksLog
    public void awardClick() {
        positiveClicks++;
        clicksLog.add("positive");
    }

    //MODIFIES: This
    //EFFECTS: Adds one to negative clicks and logs the click to clicksLog
    public void removeClick() {
        negativeClicks++;
        clicksLog.add("negative");
    }

    //MODIFIES: This
    //EFFECTS: Produces and returns the final clickerScore from the positive clicks awarded and the negative clicks deducted
    public void produceClickerScore(){
        clickerScore = this.positiveClicks - this.negativeClicks;
        System.out.println(this.firstName + " " + this.lastName + "'s" + " final clickerscore is: " + this.clickerScore);
    }

    //MODIFIES: This
    //EFFECTS: Adds one to number of restarts
    public void restart(){
        numberOfRestarts++;
    }

    //MODIFIES: This
    //EFFECTS: Returns and multiplies number of restarts by restart multiplier
    public void multiplyRestart(){ restartFinal = this.numberOfRestarts * this.restartMultiplier;
    }

    //MODIFIES: This
    //EFFECTS: Returns the final reset score
    public int getRestartFinal() {
        this.multiplyRestart();
        return restartFinal;
    }

    //MODIFIES: This
    //EFFECTS: Adds one to number of changes
    public void change(){
        numberOfChanges++;
    }

    //REQUIRES:
    //MODIFIES: This
    //EFFECTS: Returns and multiplies number of changes by change multiplier
    public void multiplyChange(){
        changeFinal = this.numberOfChanges * this.changeMultiplier;
    }

    //MODIFIES: This
    //EFFECTS: Returns the final change score
    public int getChangeFinal() {
        this.multiplyChange();
        return changeFinal;
    }

    //MODIFIES: This
    //EFFECTS: Adds one to number of discards
    public void discard(){
       numberOfDiscards++;
    }

    //MODIFIES: This
    //EFFECTS: Returns and multiplies number of discards by discard multiplier
    public void multiplyDiscard(){
        discardFinal = this.numberOfDiscards * this.discardMultiplier;
    }

    //MODIFIES: This
    //EFFECTS: Returns the final discard score
    public int getDiscardFinal() {
        this.multiplyDiscard();
        return discardFinal;
    }

    //MODIFIES: This
    //EFFECTS: Sets positive clicks and negative clicks to zero
    public void resetClicks(){
        positiveClicks = 0;
        negativeClicks = 0;
    }

    //MODIFIES: This
    //EFFECTS: Sets all major deducts to zero
    public void resetMajorDeducts(){
        numberOfRestarts = 0;
        numberOfChanges = 0;
        numberOfDiscards = 0;
    }

    //MODIFIES: This
    //EFFECTS: Sets positive clicks, negative clicks, change, discard, and restart to zero
    public void resetEverything(){
        positiveClicks = 0;
        negativeClicks = 0;
        numberOfRestarts = 0;
        numberOfChanges = 0;
        numberOfDiscards = 0;
    }

    //EFFECTS: Will save judge inputted information to csv file
    @Override
    public void save(String saveLocation) throws IOException{
        PrintWriter pw = new PrintWriter(new FileOutputStream(this.saveLocation, true));
        StringBuilder sb = new StringBuilder();
        /*
        sb.append("firstName");
        sb.append(",");
        sb.append("lastName");
        sb.append(",");
        sb.append("division");
        sb.append(",");
        sb.append("routineLength");
        sb.append(",");
        sb.append("positiveClicks");
        sb.append(",");
        sb.append("negativeClicks");
        sb.append(",");
        sb.append("clickerScore");
        sb.append(",");
        sb.append("numberOfRestarts");
        sb.append(",");
        sb.append("numberOfChanges");
        sb.append(",");
        sb.append("numberOfDiscards");
        sb.append(",");
        sb.append("restartFinal");
        sb.append(",");
        sb.append("changeFinal");
        sb.append(",");
        sb.append("discardFinal");
        sb.append(",");
        sb.append("execution");
        sb.append(",");
        sb.append("control");
        sb.append(",");
        sb.append("trickDiversity");
        sb.append(",");
        sb.append("spaceUseAndEmphasis");
        sb.append(",");
        sb.append("choreography");
        sb.append(",");
        sb.append("construction");
        sb.append(",");
        sb.append("bodyControl");
        sb.append(",");
        sb.append("showmanship");
        sb.append("\n");
        */

        sb.append(this.firstName);
        sb.append(",");
        sb.append(this.lastName);
        sb.append(",");
        sb.append(this.division);
        sb.append(",");
        sb.append(this.routineLength);
        sb.append(",");
        sb.append(this.positiveClicks);
        sb.append(",");
        sb.append(this.negativeClicks);
        sb.append(",");
        sb.append(this.clickerScore);
        sb.append(",");
        sb.append(this.numberOfRestarts);
        sb.append(",");
        sb.append(this.numberOfChanges);
        sb.append(",");
        sb.append(this.numberOfDiscards);
        sb.append(",");
        sb.append(this.restartFinal);
        sb.append(",");
        sb.append(this.changeFinal);
        sb.append(",");
        sb.append(this.discardFinal);
        sb.append(",");
        sb.append(this.execution);
        sb.append(",");
        sb.append(this.control);
        sb.append(",");
        sb.append(this.trickDiversity);
        sb.append(",");
        sb.append(this.spaceUseAndEmphasis);
        sb.append(",");
        sb.append(this.choreography);
        sb.append(",");
        sb.append(this.construction);
        sb.append(",");
        sb.append(this.bodyControl);
        sb.append(",");
        sb.append(this.showmanship);
        sb.append("\n");

        pw.write(sb.toString());
        pw.close();
    }

    //EFFECTS: Will read player information from csv file
    @Override
    public void read(String saveLocation) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(this.saveLocation));
        for (String line: lines){
            ArrayList<String> partsOfLine = splitOnComma(line);
            System.out.println("firstName: "+ partsOfLine.get(0)+" ");
            System.out.println("lastName: "+ partsOfLine.get(1)+" ");
            System.out.println("division: "+ partsOfLine.get(2)+" ");
            System.out.println("routineLength: "+ partsOfLine.get(3)+" ");
            System.out.println("positiveClicks: "+ partsOfLine.get(4)+" ");
            System.out.println("negativeClicks: "+ partsOfLine.get(5)+" ");
            System.out.println("clickerScore: "+ partsOfLine.get(6)+" ");
            System.out.println("numberOfRestarts: "+ partsOfLine.get(7)+" ");
            System.out.println("numberOfChanges: "+ partsOfLine.get(8)+" ");
            System.out.println("numberOfDiscards: "+ partsOfLine.get(9)+" ");
            System.out.println("restartFinal: "+ partsOfLine.get(10)+" ");
            System.out.println("changeFinal: "+ partsOfLine.get(11)+" ");
            System.out.println("discardFinal: "+ partsOfLine.get(12)+" ");
            System.out.println("execution: "+ partsOfLine.get(13)+" ");
            System.out.println("control: "+ partsOfLine.get(14)+" ");
            System.out.println("trickDiversity: "+ partsOfLine.get(15)+" ");
            System.out.println("spaceUseAndEmphasis: "+ partsOfLine.get(16)+" ");
            System.out.println("choreography: "+ partsOfLine.get(17)+" ");
            System.out.println("bodyControl: "+ partsOfLine.get(18)+" ");
            System.out.println("showmanship: "+ partsOfLine.get(19)+" ");
            Player p1 = new Player();
            //already set
            Player listO
            //add individual to list
            System.out.println("---------------------------------------");
        }

    }

    public static ArrayList<String> splitOnComma(String line){
        String[] splits = line.split(",");
        return new ArrayList<>(Arrays.asList(splits));
    }
}

/*
    @Override
    public void save() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("inputouptfile.txt"));
        PrintWriter writer = new PrintWriter("inputoutputfile.txt","UTF-8");
        lines.add(this.firstName);
        for (String line: lines){
            ArrayList<String> partsOfLine = splitOnComma(line);
            writer.println(line);
        }
        writer.close();
    }

    */


