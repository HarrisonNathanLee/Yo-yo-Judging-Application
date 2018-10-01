package player;

import java.util.ArrayList;

public class Player {
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

    public int getRestartFinal() {
        return restartFinal;
    }

    public int getChangeFinal() {
        return changeFinal;
    }

    public int getDiscardFinal() {
        return discardFinal;
    }

    private int restartFinal = 0;
    private int changeFinal = 0;
    private int discardFinal = 0;
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

    //EFFECTS: Returns a log of clicks
    public ArrayList<String> getClicksLog() {
        return clicksLog;
    }

    //EFFECTS: Returns the division of the player
    public String getDivision() {
        return division;
    }

    //EFFECTS: Returns the routine length
    public int getRoutineLength() {
        return routineLength;
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
        clickerScore = getPositiveClicks() - getNegativeClicks();
        System.out.println(getFirstName() + " " + getLastName() + "'s" + " final clickerscore is: " + getClickerScore());
    }

    //REQUIRES:
    //MODIFIES: This
    //EFFECTS: Adds one to number of restarts
    public void restart(){
        numberOfRestarts++;
    }

    //REQUIRES:
    //MODIFIES: This
    //EFFECTS: Returns and multiplies number of restarts by restart multiplier
    public void multiplyRestart(){
        restartFinal = getNumberOfRestarts() * getRestartMultiplier();
    }

    //REQUIRES:
    //MODIFIES: This
    //EFFECTS: Adds one to number of changes
    public void change(){
        numberOfChanges++;
    }

    //REQUIRES:
    //MODIFIES: This
    //EFFECTS: Returns and multiplies number of changes by change multiplier
    public void multiplyChange(){
        changeFinal = getNumberOfChanges() * getChangeMultiplier();
    }

    //REQUIRES:
    //MODIFIES: This
    //EFFECTS: Adds one to number of discards
    public void discard(){
       numberOfDiscards++;
    }

    //REQUIRES:
    //MODIFIES: This
    //EFFECTS: Returns and multiplies number of discards by discard multiplier
    public void multiplyDiscard(){
        discardFinal = getNumberOfDiscards() * getDiscardMultiplier();
    }

    //REQUIRES:
    //MODIFIES: This
    //EFFECTS: Sets positive clicks and negative clicks to zero
    public void resetClicks(){
        positiveClicks = 0;
        negativeClicks = 0;
    }

    // probably reset statistics too!

    //REQUIRES:
    //MODIFIES: This
    //EFFECTS: Sets all major deducts to zero
    public void resetMajorDeducts(){
        numberOfRestarts = 0;
        numberOfChanges = 0;
        numberOfDiscards = 0;
    }

    //REQUIRES:
    //MODIFIES: This
    //EFFECTS: Sets positive clicks, negative clicks, change, discard, and restart to zero
    public void resetEverything(){
        positiveClicks = 0;
        negativeClicks = 0;
        numberOfRestarts = 0;
        numberOfChanges = 0;
        numberOfDiscards = 0;
    }



}


