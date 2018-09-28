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

    //EFFECTS: Returns the first name of the player
    public String getFirstName() {
        return firstName;
    }

    //EFFECTS: Returns the last name of the player
    public String getLastName() {
        return lastName;
    }

    //EFFECTS: Returns the clicker score of the player
    public double getScore() {
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

    //EFFECTS: Returns the clicker score of the player
    public double getClickerScore() {
        return clickerScore;
    }

    //EFFECTS: Returns the positive clicks of a player
    public double getPositiveClicks() {
        return positiveClicks;
    }

    //EFFECTS: Returns the negative clicks of the player
    public double getNegativeClicks() {
        return negativeClicks;
    }

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
    //EFFECTS: produces and returns the final clickerScore from the positive clicks awarded and the negative clicks deducted
    public void produceClickerScore(){
        clickerScore = getPositiveClicks() - getNegativeClicks();
        System.out.println(getFirstName() + " " + getLastName() + "'s" + " final clickerscore is: " + getClickerScore());
    }

}


