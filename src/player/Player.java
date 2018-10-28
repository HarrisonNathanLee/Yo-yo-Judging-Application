package player;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public abstract class Player extends Readable implements Saveable{
    protected String firstName = "";
    protected String lastName = "";
    protected String division = "";
    protected String routineType = "";
    protected int routineLength = 0;
    protected int execution = 0;
    protected int control = 0;
    protected int trickDiversity = 0;
    protected int spaceUseAndEmphasis = 0;
    protected int choreography = 0;
    protected int construction = 0;
    protected int bodyControl = 0;
    protected int showmanship = 0;
    protected double clickerScore = 0;
    protected double positiveClicks = 0;
    protected double negativeClicks = 0;
    protected int numberOfRestarts = 0;
    protected int numberOfChanges = 0;
    protected int numberOfDiscards = 0;
    protected int restartMultiplier = 1;
    protected int changeMultiplier = 3;
    protected int discardMultiplier = 5;
    protected int restartFinal = 0;
    protected int changeFinal = 0;
    protected int discardFinal = 0;
    protected String saveLocation = "player.csv";
    ArrayList<String> clicksLog = new ArrayList<>();

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
    public void setDivision(String division) { this.division = division; }

    //MODIFIES: This
    //EFFECTS: Retrieves the routine type of the player
    public void setRoutineType(String routineType) { this.routineType = routineType; }

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
    public void setPositiveClicks(int positiveClicks) { this.positiveClicks = positiveClicks; }

    //MODIFIES: This
    //EFFECTS: Sets the negative clicks of the player
    public void setNegativeClicks(int negativeClicks) { this.negativeClicks = negativeClicks; }

    //MODIFIES: This
    //EFFECTS: Sets the number of restarts of the player
    public void setNumberOfRestarts(int numberOfRestarts) { this.numberOfRestarts = numberOfRestarts; }

    //MODIFIES: This
    //EFFECTS: Sets the number of changes of the player
    public void setNumberOfChanges(int numberOfChanges) { this.numberOfChanges = numberOfChanges; }

    //MODIFIES: This
    //EFFECTS: Sets the number of discards of the player
    public void setNumberOfDiscards(int numberOfDiscards) { this.numberOfDiscards = numberOfDiscards; }

    //MODIFIES: This
    //EFFECTS: Sets the number of clicker score of the player
    public void setClickerScore(double clickerScore) { this.clickerScore = clickerScore; }

    //MODIFIES: This
    //EFFECTS: Sets the save location to a different location from default
    public void setSaveLocation(String saveLocation) {
        this.saveLocation = saveLocation;
    }

    //MODIFIES: This
    //EFFECTS: Sets the routineLength of the player based of the routineType
    public void setRoutineLength(String routineType) {
        if (routineType.equals("Wildcard")){
            routineLength = 30;
        }
        if (routineType.equals("Prelim")){
            routineLength = 60;
        }
        if (routineType.equals("Semi")){
            routineLength = 90;
        }
        if (routineType.equals("Two Minute Final")){
            routineLength = 120;
        }
        if (routineType.equals("World Final")){
            routineLength = 180;
        }
    }

    //MODIFIES: This
    //EFFECTS: Sets the evaluation paramter of a player depending
    public void setEvaluation(int score, String evalParameter){
        if (evalParameter.equals("execution")){
            this.execution = score;
        }
        if (evalParameter.equals("control")){
            this.control = score;
        }
        if (evalParameter.equals("trickDiversity")){
            this.trickDiversity = score;
        }
        if (evalParameter.equals("spaceUseAndEmphasis")){
            this.spaceUseAndEmphasis = score;
        }
        if (evalParameter.equals("choreography")){
            this.choreography = score;
        }
        if (evalParameter.equals("construction")){
            this.construction = score;
        }
        if (evalParameter.equals("bodyControl")){
            this.bodyControl= score;
        }
        if (evalParameter.equals("showmanship")){
            this.showmanship = score;
        }
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

    //EFFECTS: Returns the division of the player
    public String getDivision() {
        return division;
    }

    //EFFECTS: Returns the routine length
    public int getRoutineLength() {
        return routineLength;
    }

    //REQUIRES: int < 10
    //EFFECTS: Returns the execution score of the player
    public int getExecution() { return execution; }

    //REQUIRES: int < 10
    //EFFECTS: Returns the control score of the player
    public int getControl() { return control; }

    //REQUIRES: int < 10
    //EFFECTS: Returns the trick diversity score of the player
    public int getTrickDiversity() { return trickDiversity; }

    //REQUIRES: int < 10
    //EFFECTS: Returns the space use and emphasis score of the player
    public int getSpaceUseAndEmphasis() { return spaceUseAndEmphasis; }

    //REQUIRES: int < 10
    //EFFECTS: Returns the choreography score of the player
    public int getChoreography() { return choreography; }

    //REQUIRES: int < 10
    //EFFECTS: Returns the construction score of the player
    public int getConstruction() {
        return construction;
    }

    //REQUIRES: int < 10
    //EFFECTS: Returns the body control score of the player
    public int getBodyControl() { return bodyControl; }

    //REQUIRES: int < 10
    //EFFECTS: Returns the showmanship score of the player
    public int getShowmanship() { return showmanship; }

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
    public int getNumberOfDiscards() {
        return numberOfDiscards;
    }

    //EFFECTS: Returns the routine type
    public String getRoutineType() { return routineType; }

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

    public void doubleClick() {
        for (int i = 0; i<2; i++){
            positiveClicks++;
            clicksLog.add("positive");
        }
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
    }

    //MODIFIES: This
    //EFFECTS: Adds one to number of restarts
    public void restart() {
        numberOfRestarts++;
    }

    //MODIFIES: This
    //EFFECTS: Returns and multiplies number of restarts by restart multiplier
    public void multiplyRestart() {
        restartFinal = this.numberOfRestarts * this.restartMultiplier;
    }

    //MODIFIES: This
    //EFFECTS: Returns the final reset score
    public int getRestartFinal() {
        this.multiplyRestart();
        return restartFinal;
    }

    //MODIFIES: This
    //EFFECTS: Adds one to number of changes
    public void change() {
        numberOfChanges++;
    }

    //REQUIRES:
    //MODIFIES: This
    //EFFECTS: Returns and multiplies number of changes by change multiplier
    public void multiplyChange() {

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
    public void discard() {
        numberOfDiscards++;
    }

    //MODIFIES: This
    //EFFECTS: Returns and multiplies number of discards by discard multiplier
    public void multiplyDiscard() {
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
    public void resetClicks() {
        positiveClicks = 0;
        negativeClicks = 0;
    }

    //MODIFIES: This
    //EFFECTS: Sets all major deducts to zero
    public void resetMajorDeducts() {
        numberOfRestarts = 0;
        numberOfChanges = 0;
        numberOfDiscards = 0;
    }

    //MODIFIES: This
    //EFFECTS: Sets positive clicks, negative clicks, change, discard, and restart to zero
    public void resetEverything() {
        positiveClicks = 0;
        negativeClicks = 0;
        numberOfRestarts = 0;
        numberOfChanges = 0;
        numberOfDiscards = 0;
    }

    //EFFECTS: Will save judge inputted information to csv file
    @Override
    public void save(String saveLocation) throws IOException {
        PrintWriter pw = new PrintWriter(new FileOutputStream(saveLocation, false));
        pw.write(playerToSaveString());
        pw.close();
    }

    //REQUIRES: Save location to exist in memory
    //EFFECTS: Will read player information from csv file
    @Override
    public void read(String saveLocation) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(saveLocation));
        String line = lines.get(0);
        ArrayList<String> partsOfLine = splitOnComma(line);
        playerPrintReadOutput(partsOfLine);
        playerReadOutput(partsOfLine);
    }

    public String playerToSaveString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.firstName);
        sb.append(",");
        sb.append(this.lastName);
        sb.append(",");
        sb.append(this.division);
        sb.append(",");
        sb.append(this.routineType);
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
        sb.append(this.choreography);
        sb.append(",");
        sb.append(this.bodyControl);
        sb.append("\n");
        return sb.toString();
    }

    public void playerReadOutput (ArrayList<String> partsOfLine){
        this.firstName = partsOfLine.get(0);
        this.lastName = partsOfLine.get(1);
        this.division = partsOfLine.get(2);
        this.routineType = partsOfLine.get(3);
        this.positiveClicks = Double.parseDouble(partsOfLine.get(4));
        this.negativeClicks = Double.parseDouble(partsOfLine.get(5));
        this.clickerScore = Double.parseDouble(partsOfLine.get(6));
        this.numberOfRestarts = Integer.parseInt(partsOfLine.get(7));
        this.numberOfChanges = Integer.parseInt(partsOfLine.get(8));
        this.numberOfDiscards = Integer.parseInt(partsOfLine.get(9));
        this.restartFinal = Integer.parseInt(partsOfLine.get(10));
        this.changeFinal = Integer.parseInt(partsOfLine.get(11));
        this.discardFinal = Integer.parseInt(partsOfLine.get(12));
        this.execution = Integer.parseInt(partsOfLine.get(13));
        this.control = Integer.parseInt(partsOfLine.get(14));
        this.choreography = Integer.parseInt(partsOfLine.get(15));
        this.bodyControl = Integer.parseInt(partsOfLine.get(16));
    }

    public void playerPrintReadOutput(ArrayList<String> partsOfLine){
        System.out.println("Player information and raw scores from memory");
        System.out.println("---------------------------------------");
        System.out.println("firstName: " + partsOfLine.get(0) + " ");
        System.out.println("lastName: " + partsOfLine.get(1) + " ");
        System.out.println("division: " + partsOfLine.get(2) + " ");
        System.out.println("routineType: " + partsOfLine.get(3) + " ");
        System.out.println("positiveClicks: " + partsOfLine.get(4) + " ");
        System.out.println("negativeClicks: " + partsOfLine.get(5) + " ");
        System.out.println("clickerScore: " + partsOfLine.get(6) + " ");
        System.out.println("numberOfRestarts: " + partsOfLine.get(7) + " ");
        System.out.println("numberOfChanges: " + partsOfLine.get(8) + " ");
        System.out.println("numberOfDiscards: " + partsOfLine.get(9) + " ");
        System.out.println("restartFinal: " + partsOfLine.get(10) + " ");
        System.out.println("changeFinal: " + partsOfLine.get(11) + " ");
        System.out.println("discardFinal: " + partsOfLine.get(12) + " ");
        System.out.println("execution: " + partsOfLine.get(13) + " ");
        System.out.println("control: " + partsOfLine.get(14) + " ");
        System.out.println("choreography: " + partsOfLine.get(15) + " ");
        System.out.println("bodyControl: " + partsOfLine.get(16) + " ");
        System.out.println("---------------------------------------");
    }

}
