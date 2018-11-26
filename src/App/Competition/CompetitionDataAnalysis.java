package App.Competition;

import App.player.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public abstract class CompetitionDataAnalysis extends Loadable implements Saveable, DataAnalysis {
    protected ArrayList<Player> players;
    protected Competition competition;
    protected static final String ENDOFFILENAME = "DataAnalysis.csv";
    protected static final String MEANSTRING = "Mean ";
    protected static final String VARIANCESTRING = "Variance of ";
    protected static final String SDSTRING = "Standard deviation of ";
    protected static final String ENDSTRING = "amongst routines: ";
    protected static final String STRINGBREAK = "---------------------------------------";
    protected static final String ANALYSISINTROMEMORY = "Analyzed competition data from memory: ";
    protected static final String ANALYSISINTROCURRENT = "Analyzed competition data: ";
    protected ArrayList<String> middleStrings;
    protected double meanExecution = 0;
    protected double meanControl = 0;
    protected double meanTrickDiversity = 0;
    protected double meanSpaceUseAndEmphasis = 0;
    protected double meanChoreography = 0;
    protected double meanConstruction = 0;
    protected double meanBodyControl = 0;
    protected double meanShowmanship = 0;
    protected double meanClickerscore = 0;
    protected double meanPositiveClicks = 0;
    protected double meanNegativeClicks = 0;

    protected double varianceExecution = 0;
    protected double varianceControl = 0;
    protected double varianceTrickDiversity = 0;
    protected double varianceSpaceUseAndEmphasis = 0;
    protected double varianceChoreography = 0;
    protected double varianceConstruction = 0;
    protected double varianceBodyControl = 0;
    protected double varianceShowmanship = 0;
    protected double varianceClickerscore = 0;
    protected double variancePositiveClicks = 0;
    protected double varianceNegativeClicks = 0;

    protected double sdExecution = 0;
    protected double sdControl = 0;
    protected double sdTrickDiversity = 0;
    protected double sdSpaceUseAndEmphasis = 0;
    protected double sdChoreography = 0;
    protected double sdConstruction = 0;
    protected double sdBodyControl = 0;
    protected double sdShowmanship = 0;
    protected double sdClickerscore = 0;
    protected double sdPositiveClicks = 0;
    protected double sdNegativeClicks = 0;

    //EFFECTS: Returns the mean execution
    public double getMeanExecution() {
        return meanExecution;
    }

    //EFFECTS: Returns the mean control
    public double getMeanControl() {
        return meanControl;
    }

    //EFFECTS: Returns the mean trick diversity
    public double getMeanTrickDiversity() { return meanTrickDiversity; }

    //EFFECTS: Returns the mean space use and emphasis
    public double getMeanSpaceUseAndEmphasis() {
        return meanSpaceUseAndEmphasis;
    }

    //EFFECTS: Returns the mean choreography
    public double getMeanChoreography() {
        return meanChoreography;
    }

    //EFFECTS: Returns the mean construction
    public double getMeanConstruction() { return meanConstruction; }

    //EFFECTS: Returns the mean body control
    public double getMeanBodyControl() { return meanBodyControl; }

    //EFFECTS: Returns the mean showmanship
    public double getMeanShowmanship() {
        return meanShowmanship;
    }

    //EFFECTS: Returns the mean clickerscore
    public double getMeanClickerscore() {
        return meanClickerscore;
    }

    //EFFECTS: Returns the mean positive clicks
    public double getMeanPositiveClicks() {
        return meanPositiveClicks;
    }

    //EFFECTS: Returns the mean negative clicks
    public double getMeanNegativeClicks() {
        return meanNegativeClicks;
    }

    //EFFECTS: Returns the variance execution
    public double getVarianceExecution() {
        return varianceExecution;
    }

    //EFFECTS: Returns the variance control
    public double getVarianceControl() {
        return varianceControl;
    }

    //EFFECTS: Returns the variance trick diversity
    public double getVarianceTrickDiversity() {
        return varianceTrickDiversity;
    }

    //EFFECTS: Returns the variance space use and emphasis
    public double getVarianceSpaceUseAndEmphasis() {
        return varianceSpaceUseAndEmphasis;
    }

    //EFFECTS: Returns the variance choreography
    public double getVarianceChoreography() {
        return varianceChoreography;
    }

    //EFFECTS: Returns the variance construction
    public double getVarianceConstruction() {
        return varianceConstruction;
    }

    //EFFECTS: Returns the variance body control
    public double getVarianceBodyControl() {
        return varianceBodyControl;
    }

    //EFFECTS: Returns the variance showmanship
    public double getVarianceShowmanship() {
        return varianceShowmanship;
    }

    //EFFECTS: Returns the variance clickerscore
    public double getVarianceClickerscore() {
        return varianceClickerscore;
    }

    //EFFECTS: Returns the variance positive clicks
    public double getVariancePositiveClicks() {
        return variancePositiveClicks;
    }

    //EFFECTS: Returns the variance negative clicks
    public double getVarianceNegativeClicks() {
        return varianceNegativeClicks;
    }

    //EFFECTS: Returns the standard deviation execution
    public double getSdExecution() {
        return sdExecution;
    }

    //EFFECTS: Returns the standard deviation control
    public double getSdControl() {
        return sdControl;
    }

    //EFFECTS: Returns the standard deviation trick diversity
    public double getSdTrickDiversity() {
        return sdTrickDiversity;
    }

    //EFFECTS: Returns the standard deviation space use and emphasis
    public double getSdSpaceUseAndEmphasis() {
        return sdSpaceUseAndEmphasis;
    }

    //EFFECTS: Returns the standard deviation choreography
    public double getSdChoreography() {
        return sdChoreography;
    }

    //EFFECTS: Returns the standard deviation construction
    public double getSdConstruction() {
        return sdConstruction;
    }

    //EFFECTS: Returns the standard deviation body control
    public double getSdBodyControl() {
        return sdBodyControl;
    }

    //EFFECTS: Returns the standard deviation showmanship
    public double getSdShowmanship() {
        return sdShowmanship;
    }

    //EFFECTS: Returns the standard deviation clickerscore
    public double getSdClickerscore() {
        return sdClickerscore;
    }

    //EFFECTS: Returns the standard deviation positive clicks
    public double getSdPositiveClicks() {
        return sdPositiveClicks;
    }

    //EFFECTS: Returns the standard deviation negative clicks
    public double getSdNegativeClicks() {
        return sdNegativeClicks;
    }

    //MODIFIES: This
    //EFFECTS: Sets the mean of execution scores in a competition
    public void setMeanExecution(double meanExecution) {
        this.meanExecution = meanExecution;
    }

    //MODIFIES: This
    //EFFECTS: Sets the mean of control scores in a competition
    public void setMeanControl(double meanControl) {
        this.meanControl = meanControl;
    }

    //MODIFIES: This
    //EFFECTS: Sets the mean of trick diversity scores in a competition
    public void setMeanTrickDiversity(double meanTrickDiversity) {
        this.meanTrickDiversity = meanTrickDiversity;
    }

    //MODIFIES: This
    //EFFECTS: Sets the mean of space use and emphasis scores in a competition
    public void setMeanSpaceUseAndEmphasis(double meanSpaceUseAndEmphasis) { this.meanSpaceUseAndEmphasis = meanSpaceUseAndEmphasis; }

    //MODIFIES: This
    //EFFECTS: Sets the mean of choreography scores in a competition
    public void setMeanChoreography(double meanChoreography) {
        this.meanChoreography = meanChoreography;
    }

    //MODIFIES: This
    //EFFECTS: Sets the mean of construction scores in a competition
    public void setMeanConstruction(double meanConstruction) {
        this.meanConstruction = meanConstruction;
    }

    //MODIFIES: This
    //EFFECTS: Sets the mean of body control scores in a competition
    public void setMeanBodyControl(double meanBodyControl) {
        this.meanBodyControl = meanBodyControl;
    }

    //MODIFIES: This
    //EFFECTS: Sets the mean of showmanship scores in a competition
    public void setMeanShowmanship(double meanShowmanship) {
        this.meanShowmanship = meanShowmanship;
    }

    //MODIFIES: This
    //EFFECTS: Sets the mean of clickerscore in a competition
    public void setMeanClickerscore(double meanClickerscore) {
        this.meanClickerscore = meanClickerscore;
    }

    //MODIFIES: This
    //EFFECTS: Sets the mean of positiveclicks in a competition
    public void setMeanPositiveClicks(double meanPositiveClicks) {
        this.meanPositiveClicks = meanPositiveClicks;
    }

    //MODIFIES: This
    //EFFECTS: Sets the mean of negativeclicks in a competition
    public void setMeanNegativeClicks(double meanNegativeClicks) {
        this.meanNegativeClicks = meanNegativeClicks;
    }

    //MODIFIES: This
    //EFFECTS: Sets the variance execution
    public void setVarianceExecution(double varianceExecution) {
        this.varianceExecution = varianceExecution;
    }

    //MODIFIES: This
    //EFFECTS: Sets the variance control
    public void setVarianceControl(double varianceControl) {
        this.varianceControl = varianceControl;
    }

    //MODIFIES: This
    //EFFECTS: Sets the variance trick diversity
    public void setVarianceTrickDiversity(double varianceTrickDiversity) {
        this.varianceTrickDiversity = varianceTrickDiversity;
    }

    //MODIFIES: This
    //EFFECTS: Sets the variance space use and emphasis
    public void setVarianceSpaceUseAndEmphasis(double varianceSpaceUseAndEmphasis) {
        this.varianceSpaceUseAndEmphasis = varianceSpaceUseAndEmphasis;
    }

    //MODIFIES: This
    //EFFECTS: Sets the variance choreography
    public void setVarianceChoreography(double varianceChoreography) {
        this.varianceChoreography = varianceChoreography;
    }

    //MODIFIES: This
    //EFFECTS: Sets the variance construction
    public void setVarianceConstruction(double varianceConstruction) {
        this.varianceConstruction = varianceConstruction;
    }

    //MODIFIES: This
    //EFFECTS: Sets the variance body control
    public void setVarianceBodyControl(double varianceBodyControl) {
        this.varianceBodyControl = varianceBodyControl;
    }

    //MODIFIES: This
    //EFFECTS: Sets the variance showmanship
    public void setVarianceShowmanship(double varianceShowmanship) {
        this.varianceShowmanship = varianceShowmanship;
    }

    //MODIFIES: This
    //EFFECTS: Sets the variance clickerscore
    public void setVarianceClickerscore(double varianceClickerscore) {
        this.varianceClickerscore = varianceClickerscore;
    }

    //MODIFIES: This
    //EFFECTS: Sets the variance positive clicks
    public void setVariancePositiveClicks(double variancePositiveClicks) {
        this.variancePositiveClicks = variancePositiveClicks;
    }

    //MODIFIES: This
    //EFFECTS: Sets the variance negative clicks
    public void setVarianceNegativeClicks(double varianceNegativeClicks) {
        this.varianceNegativeClicks = varianceNegativeClicks;
    }

    //MODIFIES: This
    //EFFECTS: Sets the standard deviation execution
    public void setSdExecution(double sdExecution) {
        this.sdExecution = sdExecution;
    }

    //MODIFIES: This
    //EFFECTS: Sets the standard deviation control
    public void setSdControl(double sdControl) {
        this.sdControl = sdControl;
    }

    //MODIFIES: This
    //EFFECTS: Sets the standard deviation trick diversity
    public void setSdTrickDiversity(double sdTrickDiversity) {
        this.sdTrickDiversity = sdTrickDiversity;
    }

    //MODIFIES: This
    //EFFECTS: Sets the standard deviation space use and emphasis
    public void setSdSpaceUseAndEmphasis(double sdSpaceUseAndEmphasis) {
        this.sdSpaceUseAndEmphasis = sdSpaceUseAndEmphasis;
    }

    //MODIFIES: This
    //EFFECTS: Sets the standard deviation choreography
    public void setSdChoreography(double sdChoreography) {
        this.sdChoreography = sdChoreography;
    }

    //MODIFIES: This
    //EFFECTS: Sets the standard deviation construction
    public void setSdConstruction(double sdConstruction) {
        this.sdConstruction = sdConstruction;
    }

    //MODIFIES: This
    //EFFECTS: Sets the standard deviation body control
    public void setSdBodyControl(double sdBodyControl) {
        this.sdBodyControl = sdBodyControl;
    }

    //MODIFIES: This
    //EFFECTS: Sets the standard deviation showmanship
    public void setSdShowmanship(double sdShowmanship) {
        this.sdShowmanship = sdShowmanship;
    }

    //MODIFIES: This
    //EFFECTS: Sets the standard deviation clickerscore
    public void setSdClickerscore(double sdClickerscore) {
        this.sdClickerscore = sdClickerscore;
    }

    //MODIFIES: This
    //EFFECTS: Sets the standard deviation positive clicks
    public void setSdPositiveClicks(double sdPositiveClicks) {
        this.sdPositiveClicks = sdPositiveClicks;
    }

    //MODIFIES: This
    //EFFECTS: Sets the standard deviation negative clicks
    public void setSdNegativeClicks(double sdNegativeClicks) {
        this.sdNegativeClicks = sdNegativeClicks;
    }

    public CompetitionDataAnalysis (Competition competition){
        this.competition = competition;
    }

    //EFFECTS: Will get the value for a single parameter for all players in a competition
    public ArrayList<Double> getValuesForParameter(ArrayList<Player> players, String parameter) {
        ArrayList<Double> listOfParameters = new ArrayList<>();
        if (parameter.equals("execution")){
            for (Player p: players){
                Double score = Double.valueOf(p.getExecution());
                listOfParameters.add(score);
            }
        }
        else if (parameter.equals("control")){
            for (Player p: players){
                Double score = Double.valueOf(p.getControl());
                listOfParameters.add(score);
            }
        }
        else if (parameter.equals("trickDiversity")) {
            for (Player p: players){
                Double score = Double.valueOf(p.getTrickDiversity());
                listOfParameters.add(score);
            }

        }
        else if (parameter.equals("spaceUseAndEmphasis")) {
            for (Player p: players){
                Double score = Double.valueOf(p.getSpaceUseAndEmphasis());
                listOfParameters.add(score);
            }
        }

        else if (parameter.equals("choreography")){
            for (Player p: players){
                Double score = Double.valueOf(p.getChoreography());
                listOfParameters.add(score);
            }
        }

        else if (parameter.equals("construction")){
            for (Player p: players){
                Double score = Double.valueOf(p.getConstruction());
                listOfParameters.add(score);
            }

        }
        else if (parameter.equals("bodyControl")){
            for (Player p: players){
                Double score = Double.valueOf(p.getBodyControl());
                listOfParameters.add(score);
            }
        }
        else if (parameter.equals("showmanship")){
            for (Player p: players){
                Double score = Double.valueOf(p.getShowmanship());
                listOfParameters.add(score);
            }
        }
        else if (parameter.equals("clickerscore")){
            for (Player p: players){
                Double score = p.getClickerScore();
                listOfParameters.add(score);
            }
        }
        else if (parameter.equals("positive clicks")){
            for (Player p: players){
                Double score = p.getPositiveClicks();
                listOfParameters.add(score);
            }
        }
        else if (parameter.equals("negative clicks")){
            for (Player p: players){
                Double score = p.getNegativeClicks();
                listOfParameters.add(score);
            }
        }
        return listOfParameters;
    }


    //EFFECTS: Returns the sum of the elements in a list
    private Double getSum(ArrayList<Double> evalValues){
        Double sum = 0.0;
        for(Double eval: evalValues){
            sum += eval;
        }
        return sum;
    }

    //EFFECTS: Returns the number of elements in a list
    private Integer getCount(ArrayList<Player> players){
        return players.size();
    }


    //EFFECTS: Returns the sum of observation differences from the mean squared
    public Double getObservationDifferenceFromMeanSquared(ArrayList<Player> players, String parameter){
        ArrayList<Double> listOfParameter = getValuesForParameter(players,parameter);
        double sumObservationDifferenceFromMean = 0;
        if (parameter.equals("execution")){
            for (Double observation: listOfParameter){
                double mean = produceMean(players, "execution");
                double difference = observation - mean;
                double differenceSquared = difference*difference;
                sumObservationDifferenceFromMean += differenceSquared;
            }
        }
        else if (parameter.equals("control")){
            for (Double observation: listOfParameter){
                double mean = produceMean(players, "control");
                double difference = observation - mean;
                double differenceSquared = difference*difference;
                sumObservationDifferenceFromMean += differenceSquared;
            }
        }
        else if (parameter.equals("trickDiversity")) {
            for (Double p: listOfParameter){
                double mean = produceMean(players, "trickDiversity");
                double difference = p - mean;
                double differenceSquared = difference*difference;
                sumObservationDifferenceFromMean += differenceSquared;
            }

        }
        else if (parameter.equals("spaceUseAndEmphasis")) {
            for (Double p: listOfParameter){
                double mean = produceMean(players, "spaceUseAndEmphasis");
                double difference = p - mean;
                double differenceSquared = difference*difference;
                sumObservationDifferenceFromMean += differenceSquared;
            }
        }

        else if (parameter.equals("choreography")){
            for (Double p: listOfParameter){
                double mean = produceMean(players, "choreography");
                double difference = p - mean;
                double differenceSquared = difference*difference;
                sumObservationDifferenceFromMean += differenceSquared;
            }
        }

        else if (parameter.equals("construction")){
            for (Double p: listOfParameter){
                double mean = produceMean(players, "construction");
                double difference = p - mean;
                double differenceSquared = difference*difference;
                sumObservationDifferenceFromMean += differenceSquared;
            }
        }
        else if (parameter.equals("bodyControl")){
            for (Double p: listOfParameter){
                double mean = produceMean(players, "bodyControl");
                double difference = p - mean;
                double differenceSquared = difference*difference;
                sumObservationDifferenceFromMean += differenceSquared;
            }
        }
        else if (parameter.equals("showmanship")){
            for (Double p: listOfParameter){
                double mean = produceMean(players, "showmanship");
                double difference = p - mean;
                double differenceSquared = difference*difference;
                sumObservationDifferenceFromMean += differenceSquared;
            }
        }
        else if (parameter.equals("clickerscore")){
            for (Double p: listOfParameter){
                double mean = produceMean(players, "clickerscore");
                double difference = p - mean;
                double differenceSquared = difference*difference;
                sumObservationDifferenceFromMean += differenceSquared;
            }
        }
        else if (parameter.equals("positive clicks")){
            for (Double p: listOfParameter){
                double mean = produceMean(players, "positive clicks");
                double difference = p - mean;
                double differenceSquared = difference*difference;
                sumObservationDifferenceFromMean += differenceSquared;
            }
        }
        else if (parameter.equals("negative clicks")){
            for (Double p: listOfParameter){
                double mean = produceMean(players, "negative clicks");
                double difference = p - mean;
                double differenceSquared = difference*difference;
                sumObservationDifferenceFromMean += differenceSquared;
            }
        }
        return sumObservationDifferenceFromMean;

    }

    //MODIFIES: This
    //EFFECTS: Produces the mean for a single eval parameter
    public Double produceMean(ArrayList<Player> players, String parameter){
        ArrayList<Double> listOfParameter = getValuesForParameter(players,parameter);
        Double sum = getSum(listOfParameter);
        Integer count = getCount(players);
        Double mean = (double) sum/count;
        return mean;
    }

    //EFFECTS: Produces the variance for a single eval parameter
    public  Double produceVariance (ArrayList<Player> players, String parameter){
        double sumObservationDifferenceFromMean = getObservationDifferenceFromMeanSquared(players,parameter);
        Integer count = getCount(players);
        Double variance = sumObservationDifferenceFromMean /(count - 1);
        return variance;
    }
    //MODIFIES: This
    //EFFECTS: Sets the mean for all eval parameters
    public abstract void produceAllMean();

    //MODIFIES: This
    //EFFECTS: Sets the variance for all eval parameters
    public abstract void produceAllVariance();

    //MODIFIES: This
    //EFFECTS: Sets the standard deviation for all eval parameters
    public abstract void produceAllStandardDeviation();


    //MODIFIES: This
    //EFFECTS: Sets the the mean,variance,and standard deviation for all eval parameters
    public void callAllDataAnalysis(){
        produceAllMean();
        produceAllVariance();
        produceAllStandardDeviation();
    }

    //EFFECTS: Saves competition data analysis information to a csv file
    public void save(String saveLocation) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new FileOutputStream(saveLocation, false));
        pw.write(toSaveString());
        pw.close();
    }

    //EFFECTS: Loads competition data analysis from CSV file
    public void load(String saveLocation) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(saveLocation));
        String line = lines.get(0);
        ArrayList<String> partsOfLine = splitOnComma(line);
        printLoadOutput(partsOfLine);
        loadOutput(partsOfLine);
    }

    //EFFECTS: Helper method for load
    public void printLoadOutputHelper(String statType, ArrayList<String> partsOfline, int startingpoint, int endpoint){
        for (int i = startingpoint; i < endpoint; i++){
            System.out.println(statType + middleStrings.get(i-startingpoint) + ENDSTRING + partsOfline.get(i));
        }
    }
    public abstract String toSaveString();

    public abstract void loadOutput(ArrayList<String> partsOfLine);

    public abstract void printLoadOutput(ArrayList<String> partsOfLine);

    public abstract void printAnalyzedCompetitionInformation(CompetitionDataAnalysis cData);

}


