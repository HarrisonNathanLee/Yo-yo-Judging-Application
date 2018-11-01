package Competition;

import player.DataAnalysis;
import player.Player;
import player.PlayerDataAnalysis;
import player.Saveable;
import player.Readable;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CompetitionDataAnalysis extends Readable implements DataAnalysis, Saveable {
    private ArrayList<Player> players;
    private Competition competition;

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
    public double getMeanConstruction() {
        return meanConstruction;
    }

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

    private double meanExecution = 0;
    private double meanControl = 0;
    private double meanTrickDiversity = 0;
    private double meanSpaceUseAndEmphasis = 0;
    private double meanChoreography = 0;
    private double meanConstruction = 0;
    private double meanBodyControl = 0;
    private double meanShowmanship = 0;
    private double meanClickerscore = 0;
    private double meanPositiveClicks = 0;
    private double meanNegativeClicks = 0;


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
    public void setMeanSpaceUseAndEmphasis(double meanSpaceUseAndEmphasis) {
        this.meanSpaceUseAndEmphasis = meanSpaceUseAndEmphasis;
    }

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
    public Double getSum(ArrayList<Double> evalValues){
        Double sum = 0.0;
        for(Double eval: evalValues){
            sum += eval;
        }
        return sum;
    }

    //EFFFECTS: Returns the number of elements in a list
    public Integer getCount(ArrayList<Player> players){
        return players.size();
    }


    //MODIFIES: This
    //EFFECTS: Produces the mean for a single eval parameters
    public Double produceMean(ArrayList<Player> players, String parameter){
        ArrayList<Double> listOfParameter = getValuesForParameter(players,parameter);
        Double sum = getSum(listOfParameter);
        Integer count = getCount(players);
        Double mean = (double) sum/count;
        return mean;
    }

    //MODIFIES: This
    //EFFECTS: Sets the mean for all eval parameters
    public void produceAllMean(){
       players = competition.getPlayers();
       setMeanExecution(produceMean(players, "execution"));
       setMeanControl(produceMean(players, "control"));
       setMeanTrickDiversity(produceMean(players, "trickDiversity"));
       setMeanSpaceUseAndEmphasis(produceMean(players, "spaceUseAndEmphasis"));
       setMeanChoreography(produceMean(players, "choreography"));
       setMeanConstruction(produceMean(players, "construction"));
       setMeanBodyControl(produceMean(players, "bodyControl"));
       setMeanShowmanship(produceMean(players, "showmanship"));
       setMeanPositiveClicks(produceMean(players,"positive clicks"));
       setMeanNegativeClicks(produceMean(players, "negative clicks"));
       setMeanClickerscore(produceMean(players, "clickerscore"));
    }

    public void callAllDataAnalysis(){
        produceAllMean();
    }

    public void save(String saveLocation) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new FileOutputStream(saveLocation + "DataAnalysis.csv", false));
        pw.write(toSaveString());
        pw.close();
        
    }

    public void read(String saveLocation) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(saveLocation+ "DataAnalysis.csv"));
        String line = lines.get(0);
        ArrayList<String> partsOfLine = splitOnComma(line);
        printReadOutput(partsOfLine);
        readOutput(partsOfLine);
    }
    public String toSaveString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.meanPositiveClicks);
        sb.append(",");
        sb.append(this.meanNegativeClicks);
        sb.append(",");
        sb.append(this.meanClickerscore);
        sb.append(",");
        sb.append(this.meanExecution);
        sb.append(",");
        sb.append(this.meanControl);
        sb.append(",");
        sb.append(this.meanTrickDiversity);
        sb.append(",");
        sb.append(this.meanSpaceUseAndEmphasis);
        sb.append(",");
        sb.append(this.meanChoreography);
        sb.append(",");
        sb.append(this.meanConstruction);
        sb.append(",");
        sb.append(this.meanBodyControl);
        sb.append(",");
        sb.append(this.meanShowmanship);
        sb.append("\n");
        return sb.toString();
    }

    public void readOutput (ArrayList<String> partsOfLine){
        this.meanPositiveClicks = Double.parseDouble(partsOfLine.get(0));
        this.meanNegativeClicks = Double.parseDouble(partsOfLine.get(1));
        this.meanClickerscore = Double.parseDouble(partsOfLine.get(2));
        this.meanExecution = Double.parseDouble(partsOfLine.get(3));
        this.meanControl = Double.parseDouble(partsOfLine.get(4));
        this.meanTrickDiversity = Double.parseDouble(partsOfLine.get(5));
        this.meanSpaceUseAndEmphasis = Double.parseDouble(partsOfLine.get(6));
        this.meanChoreography= Double.parseDouble(partsOfLine.get(7));
        this.meanConstruction = Double.parseDouble(partsOfLine.get(8));
        this.meanBodyControl = Double.parseDouble(partsOfLine.get(9));
        this.meanShowmanship = Double.parseDouble(partsOfLine.get(10));

    }

    public void printReadOutput(ArrayList<String> partsOfLine){
        System.out.println("Analyzed competition information from memory");
        System.out.println("---------------------------------------");
        System.out.println("Mean positive clicks amongst routines: " + partsOfLine.get(0));
        System.out.println("Mean negative clicks amongst routines: " +partsOfLine.get(1));
        System.out.println("Mean clickerscore amongst routines: " + partsOfLine.get(2));
        System.out.println("Mean execution score amongst routines: " + partsOfLine.get(3));
        System.out.println("Mean control score amongst routines: " + partsOfLine.get(4));
        System.out.println("Mean trick diversity score amongst routines: " + partsOfLine.get(5));
        System.out.println("Mean space use & emphasis score amongst routines: " + partsOfLine.get(6));
        System.out.println("Mean music use 1: choreography score amongst routines: " + partsOfLine.get(7));
        System.out.println("Mean music use 2: construction score amongst routines: " + partsOfLine.get(8));
        System.out.println("Mean body control score amongst routines: " + partsOfLine.get(9));
        System.out.println("Mean showmanship score amongst routines: " + partsOfLine.get(10));

    }

}


