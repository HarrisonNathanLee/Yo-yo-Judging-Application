package App.player;


import java.io.FileOutputStream;
import java.util.ArrayList;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

public abstract class Player extends Loadable implements Saveable{
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
    protected static final String STRINGBREAK  = "---------------------------------------";
    protected static final String SCORESFROMMEMORY = "Player data from memory";
    protected static final String PERFORMANCEEVALS = "performance evaluation scores: ";
    protected static final String POSITIVE = "positive";
    protected static final String NEGATIVE = "negative";
    protected static final String TECHNICALDATA = "technical data:";
    protected static final String ROUTINEINFORMATION = "routine information:";
    protected static final String MAJORDEDUCTSCORES = "major deduct scores:";
    protected static final String ANALYZEDDATA = "analyzed technical data:";
    public static final String EXECUTIONDESCRIPTION = "Success Rate of Tricks, Success, Less mistakes, Completion";
    public static final String CONTROlDESCRIPTION = "Control of Yo-Yo/String, Line of String, Trajectory of Yo-Yo, Smooth landings and flowing transitions";
    public static final String TRICKDIVERSITYDESCRIPTION = "Trick Choice, Trick Mix, Trick Order and Trick Presentation";
    public static final String SPACEUSEANDEMPHASISDESCRIPTION = "Size of expression, moves, performance, Effective use of stage and space, and/or focusing on/into a subject effectively";
    public static final String CHOREOGRAPHYDESCRIPTION = "Music Use concentrating on hitting sounds, beats, cues, etc.;";
    public static final String CONSTRUCTIONDESCRIPTION = "Music Use concentrating on mood, tone, routine, theme, etc.";
    public static final String BODYCONTROlDESCRIPTION = "Stage Manners, Posture, Stage Professionalism, Attitude";
    public static final String SHOWMANSHIPDESCRIPTION = "Theme/Story, Enjoyment, Entertainment, Overall Impression of Show";


    ArrayList<String> clicksLog = new ArrayList<>();

    //MODIFIES: This
    //EFFECTS: Retrieves the first name of the App.player
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //MODIFIES: This
    //EFFECTS: Retrieves the last name of the App.player
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //MODIFIES: This
    //EFFECTS: Retrieves the division of the App.player
    public void setDivision(String division) { this.division = division; }

    //MODIFIES: This
    //EFFECTS: Retrieves the routine type of the App.player
    public void setRoutineType(String routineType) {
        this.routineType = routineType; }

    //MODIFIES: This
    //EFFECTS: Retrieves the execution score of the App.player
    public void setExecution(int execution) {
        this.execution = execution;
    }

    //MODIFIES: This
    //EFFECTS: Retrieves the control score of the App.player
    public void setControl(int control) {
        this.control = control;
    }

    //MODIFIES: This
    //EFFECTS: Retrieves the trick diversity score of the App.player
    public void setTrickDiversity(int trickDiversity) {
        this.trickDiversity = trickDiversity;
    }

    //MODIFIES: This
    //EFFECTS: Retrieves the space use and emphasis score of the App.player
    public void setSpaceUseAndEmphasis(int spaceUseAndEmphasis) {
        this.spaceUseAndEmphasis = spaceUseAndEmphasis;
    }

    //MODIFIES: This
    //EFFECTS: Retrieves the choreography score of the App.player
    public void setChoreography(int choreography) {
        this.choreography = choreography;
    }

    //MODIFIES: This
    //EFFECTS: Retrieves the construction score of the App.player
    public void setConstruction(int construction) {
        this.construction = construction;
    }

    //MODIFIES: This
    //EFFECTS: Retrieves the body control score of the App.player
    public void setBodyControl(int bodyControl) {
        this.bodyControl = bodyControl;
    }

    //MODIFIES: This
    //EFFECTS: Retrieves the showmanship score of the App.player
    public void setShowmanship(int showmanship) {
        this.showmanship = showmanship;
    }

    //MODIFIES: This
    //EFFECTS: Sets the positive clicks of the App.player
    public void setPositiveClicks(int positiveClicks) { this.positiveClicks = positiveClicks; }

    //MODIFIES: This
    //EFFECTS: Sets the negative clicks of the App.player
    public void setNegativeClicks(int negativeClicks) { this.negativeClicks = negativeClicks; }

    //MODIFIES: This
    //EFFECTS: Sets the number of restarts of the App.player
    public void setNumberOfRestarts(int numberOfRestarts) { this.numberOfRestarts = numberOfRestarts; }

    //MODIFIES: This
    //EFFECTS: Sets the number of changes of the App.player
    public void setNumberOfChanges(int numberOfChanges) { this.numberOfChanges = numberOfChanges; }

    //MODIFIES: This
    //EFFECTS: Sets the number of discards of the App.player
    public void setNumberOfDiscards(int numberOfDiscards) { this.numberOfDiscards = numberOfDiscards; }

    //MODIFIES: This
    //EFFECTS: Sets the number of Clicker score of the App.player
    public void setClickerScore(double clickerScore) { this.clickerScore = clickerScore; }

    //MODIFIES: This
    //EFFECTS: Sets the save location to a different location from default
    public void setSaveLocation(String saveLocation) {
        this.saveLocation = saveLocation;
    }

    //MODIFIES: This
    //EFFECTS: Sets the routineLength of the App.player based of the routineType
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
    //EFFECTS: Sets the evaluation paramter of a App.player depending
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

    public String getPlayerSaveLocation(){
        return getFirstName() + "_" + getLastName() + "_" + getRoutineType() + "_" + "Player.csv";
    }

    public String getDataSaveLocation(){
        return getFirstName() + "_" + getLastName() + "_" + getRoutineType() + "_" + "PlayerDataAnalysis.csv";
    }

    //EFFECTS: Returns the first name of the App.player
    public String getFirstName() {
        return firstName;
    }

    //EFFECTS: Returns the last name of the App.player
    public String getLastName() {
        return lastName;
    }

    //EFFECTS: Returns the Clicker score of the App.player
    public double getClickerScore() {
        return clickerScore;
    }

    //EFFECTS: Returns the division of the App.player
    public String getDivision() {
        return division;
    }

    //EFFECTS: Returns the routine length
    public int getRoutineLength() {
        return routineLength;
    }

    //EFFECTS: Returns the execution score of the App.player
    public int getExecution() { return execution; }

    //EFFECTS: Returns the control score of the App.player
    public int getControl() { return control; }

    //EFFECTS: Returns the trick diversity score of the App.player
    public int getTrickDiversity() { return trickDiversity; }

    //EFFECTS: Returns the space use and emphasis score of the App.player
    public int getSpaceUseAndEmphasis() { return spaceUseAndEmphasis; }

    //EFFECTS: Returns the choreography score of the App.player
    public int getChoreography() { return choreography; }

    //EFFECTS: Returns the construction score of the App.player
    public int getConstruction() {
        return construction;
    }

    //EFFECTS: Returns the body control score of the App.player
    public int getBodyControl() { return bodyControl; }

    //EFFECTS: Returns the showmanship score of the App.player
    public int getShowmanship() { return showmanship; }

    //EFFECTS: Returns the positive clicks of a App.player
    public double getPositiveClicks() {
        return positiveClicks;
    }

    //EFFECTS: Returns the negative clicks of the App.player
    public double getNegativeClicks() {
        return negativeClicks;
    }

    //EFFECTS: Returns the number of restarts of the App.player
    public int getNumberOfRestarts() { return numberOfRestarts; }

    //EFFECTS: Returns the number of changes of the App.player
    public int getNumberOfChanges() { return numberOfChanges; }

    //EFFECTS: Returns the number of discards of the App.player
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
        clicksLog.add(POSITIVE);
    }

    //MODIFIES: This
    //EFFECTS: Adds two positive clicks and logs the clicks to clicksLog
    public void doubleClick() {
        for (int i = 0; i<2; i++){
            positiveClicks++;
            clicksLog.add(POSITIVE);
        }
    }

    //MODIFIES: This
    //EFFECTS: Adds one to negative clicks and logs the click to clicksLog
    public void removeClick() {
        negativeClicks++;
        clicksLog.add(NEGATIVE);
    }

    //MODIFIES: This
    //EFFECTS: Produces and returns the final clickerScore from the positive clicks awarded and the negative clicks deducted
    public void produceClickerScore(){
        clickerScore = positiveClicks - negativeClicks;
    }

    //MODIFIES: This
    //EFFECTS: Adds one to number of restarts
    public void restart() {
        numberOfRestarts++;
    }

    //MODIFIES: This
    //EFFECTS: Returns and multiplies number of restarts by restart multiplier
    public void multiplyRestart() {
        restartFinal = numberOfRestarts * restartMultiplier;
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
        changeFinal = numberOfChanges * changeMultiplier;
    }

    //MODIFIES: This
    //EFFECTS: Returns the final change score
    public int getChangeFinal() {
        multiplyChange();
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
        discardFinal = numberOfDiscards * discardMultiplier;
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
       resetClicks();
       resetMajorDeducts();
    }

    //EFFECTS: Will save judge inputted information to csv file
    @Override
    public void save(String saveLocation) throws IOException {
        PrintWriter pw = new PrintWriter(new FileOutputStream(saveLocation, false));
        pw.write(toSaveString());
        pw.close();
    }

    //REQUIRES: Save location to exist in memory
    //EFFECTS: Will load App.player information from csv file
    @Override
    public void load(String saveLocation) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(saveLocation));
        String line = lines.get(0);
        ArrayList<String> partsOfLine = splitOnComma(line);
        printLoadOutput(partsOfLine);
        loadOutput(partsOfLine);
    }


    //EFFECTS: Prints judge inputted performance evaluations
    public abstract void getPerformanceEvals(Player p);

    //EFFECTS: Prints various post performance information
    public void printRoutineClickInformation(Player p) {
        System.out.println(p.getFirstName() + " " + p.getLastName() + "'s technical data: ");
        System.out.println("Positive clicks: " + p.getPositiveClicks());
        System.out.println("Negative clicks: " + p.getNegativeClicks());
        System.out.println("Clickerscore: " + p.getClickerScore());
        System.out.println(STRINGBREAK);
    }

    public void printRoutineMajorDeductInformation(Player p) {
        System.out.println(p.getFirstName() + " " + p.getLastName() + "'s major deduct scores: ");
        System.out.println("Number of resets: " + p.getNumberOfRestarts());
        System.out.println("Final reset score is: " + p.getRestartFinal());
        System.out.println("Number of changes: " + p.getNumberOfChanges());
        System.out.println("Final change score is: " + p.getChangeFinal());
        System.out.println("Number of discards: " + p.getNumberOfDiscards());
        System.out.println("Final discard score is: " + p.getDiscardFinal());
        System.out.println(STRINGBREAK);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(firstName, player.firstName) &&
                Objects.equals(lastName, player.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }


}
