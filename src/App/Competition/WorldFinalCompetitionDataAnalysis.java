package App.Competition;

import java.util.ArrayList;

public class WorldFinalCompetitionDataAnalysis extends CompetitionDataAnalysis {

    // CONSTRUCTOR
    // EFFECTS: sets up competition data analysis for world final
    public WorldFinalCompetitionDataAnalysis (Competition competition){
        super(competition);
        middleStrings = new ArrayList<>();
        middleStrings.add("positive clicks ");
        middleStrings.add("negative clicks ");
        middleStrings.add("clickerscore ");
        middleStrings.add("execution score ");
        middleStrings.add("control score ");
        middleStrings.add("trick diversity score ");
        middleStrings.add("space use & emphasis score ");
        middleStrings.add("music use 1: choreography score ");
        middleStrings.add("music use 2: construction score ");
        middleStrings.add("body control score ");
        middleStrings.add("showmanship score ");
    }

    //MODIFIES: This
    //EFFECTS: Sets the mean for all parameters
    public void produceAllMean(){
        players = competition.getPlayers();
        meanExecution = produceMean(players, "execution");
        meanControl = produceMean(players, "control");
        meanTrickDiversity = produceMean(players, "trickDiversity");
        meanSpaceUseAndEmphasis = produceMean(players, "spaceUseAndEmphasis");
        meanChoreography = produceMean(players, "choreography");
        meanConstruction = produceMean(players, "construction");
        meanBodyControl = produceMean(players, "bodyControl");
        meanShowmanship = produceMean(players, "showmanship");
        meanPositiveClicks = produceMean(players,"positive clicks");
        meanNegativeClicks = produceMean(players, "negative clicks");
        meanClickerscore = produceMean(players, "clickerscore");
    }

    //MODIFIES: This
    //EFFECTS: Sets the variance for all parameters
    public void produceAllVariance(){
        players = competition.getPlayers();
        varianceExecution = produceVariance(players, "execution");
        varianceControl = produceVariance(players, "control");
        varianceTrickDiversity = produceVariance(players, "trickDiversity");
        varianceSpaceUseAndEmphasis = produceVariance(players, "spaceUseAndEmphasis");
        varianceChoreography = produceVariance(players, "choreography");
        varianceConstruction = produceVariance(players, "construction");
        varianceBodyControl = produceVariance(players, "bodyControl");
        varianceShowmanship = produceVariance(players, "showmanship");
        variancePositiveClicks = produceVariance(players,"positive clicks");
        varianceNegativeClicks = produceVariance(players, "negative clicks");
        varianceClickerscore = produceVariance(players, "clickerscore");
    }

    //MODIFIES: This
    //EFFECTS: Sets the standard deviation for all parameters
    public void produceAllStandardDeviation(){
        sdExecution = Math.sqrt(varianceExecution);
        sdControl = Math.sqrt(varianceControl);
        sdTrickDiversity = Math.sqrt(varianceTrickDiversity);
        sdSpaceUseAndEmphasis = Math.sqrt(varianceSpaceUseAndEmphasis);
        sdChoreography = Math.sqrt(varianceChoreography);
        sdConstruction = Math.sqrt(varianceConstruction);
        sdBodyControl = Math.sqrt(varianceBodyControl);
        sdShowmanship = Math.sqrt(varianceShowmanship);
        sdClickerscore = Math.sqrt(varianceClickerscore);
        sdPositiveClicks = Math.sqrt(variancePositiveClicks);
        sdNegativeClicks = Math.sqrt(varianceNegativeClicks);
    }

    //EFFECTS: Adds competition data analysis fields to a string
    public String toSaveString(){
        StringBuilder sb = new StringBuilder();
        sb.append(meanPositiveClicks);
        sb.append(",");
        sb.append(meanNegativeClicks);
        sb.append(",");
        sb.append(meanClickerscore);
        sb.append(",");
        sb.append(meanExecution);
        sb.append(",");
        sb.append(meanControl);
        sb.append(",");
        sb.append(meanTrickDiversity);
        sb.append(",");
        sb.append(meanSpaceUseAndEmphasis);
        sb.append(",");
        sb.append(meanChoreography);
        sb.append(",");
        sb.append(meanConstruction);
        sb.append(",");
        sb.append(meanBodyControl);
        sb.append(",");
        sb.append(meanShowmanship);
        sb.append(",");
        sb.append(variancePositiveClicks);
        sb.append(",");
        sb.append(varianceNegativeClicks);
        sb.append(",");
        sb.append(varianceClickerscore);
        sb.append(",");
        sb.append(varianceExecution);
        sb.append(",");
        sb.append(varianceControl);
        sb.append(",");
        sb.append(varianceTrickDiversity);
        sb.append(",");
        sb.append(varianceSpaceUseAndEmphasis);
        sb.append(",");
        sb.append(varianceChoreography);
        sb.append(",");
        sb.append(varianceConstruction);
        sb.append(",");
        sb.append(varianceBodyControl);
        sb.append(",");
        sb.append(varianceShowmanship);
        sb.append(",");
        sb.append(sdPositiveClicks);
        sb.append(",");
        sb.append(sdNegativeClicks);
        sb.append(",");
        sb.append(sdClickerscore);
        sb.append(",");
        sb.append(sdExecution);
        sb.append(",");
        sb.append(sdControl);
        sb.append(",");
        sb.append(sdTrickDiversity);
        sb.append(",");
        sb.append(sdSpaceUseAndEmphasis);
        sb.append(",");
        sb.append(sdChoreography);
        sb.append(",");
        sb.append(sdConstruction);
        sb.append(",");
        sb.append(sdBodyControl);
        sb.append(",");
        sb.append(sdShowmanship);
        sb.append("\n");
        return sb.toString();
    }

    //EFFECTS: Prints analyzed competition information from memory
    public void printLoadOutput(ArrayList<String> partsOfLine){
        int sp = 0;
        int ep1 = 11;
        int ep2 = 22;
        int ep3 = partsOfLine.size();
        System.out.println(ANALYSISINTROMEMORY);
        System.out.println(STRINGBREAK);
        printLoadOutputHelper(MEANSTRING,partsOfLine,sp,ep1);
        printLoadOutputHelper(VARIANCESTRING,partsOfLine,ep1,ep2);
        printLoadOutputHelper(SDSTRING, partsOfLine,ep2,ep3);
    }

    //MODIFIES: This
    //EFFECTS: Sets competition data analysis fields from memory
    public void loadOutput(ArrayList<String> partsOfLine){
        meanPositiveClicks = Double.parseDouble(partsOfLine.get(0));
        meanNegativeClicks = Double.parseDouble(partsOfLine.get(1));
        meanClickerscore = Double.parseDouble(partsOfLine.get(2));
        meanExecution = Double.parseDouble(partsOfLine.get(3));
        meanControl = Double.parseDouble(partsOfLine.get(4));
        meanTrickDiversity = Double.parseDouble(partsOfLine.get(5));
        meanSpaceUseAndEmphasis = Double.parseDouble(partsOfLine.get(6));
        meanChoreography = Double.parseDouble(partsOfLine.get(7));
        meanConstruction = Double.parseDouble(partsOfLine.get(8));
        meanBodyControl = Double.parseDouble(partsOfLine.get(9));
        meanShowmanship = Double.parseDouble(partsOfLine.get(10));
        variancePositiveClicks = Double.parseDouble(partsOfLine.get(11));
        varianceNegativeClicks = Double.parseDouble(partsOfLine.get(12));
        varianceClickerscore = Double.parseDouble(partsOfLine.get(13));
        varianceExecution = Double.parseDouble(partsOfLine.get(14));
        varianceControl = Double.parseDouble(partsOfLine.get(15));
        varianceTrickDiversity = Double.parseDouble(partsOfLine.get(16));
        varianceSpaceUseAndEmphasis = Double.parseDouble(partsOfLine.get(17));
        varianceChoreography = Double.parseDouble(partsOfLine.get(18));
        varianceConstruction = Double.parseDouble(partsOfLine.get(19));
        varianceBodyControl = Double.parseDouble(partsOfLine.get(20));
        varianceShowmanship = Double.parseDouble(partsOfLine.get(21));
        sdPositiveClicks = Double.parseDouble(partsOfLine.get(22));
        sdNegativeClicks = Double.parseDouble(partsOfLine.get(23));
        sdClickerscore = Double.parseDouble(partsOfLine.get(24));
        sdExecution = Double.parseDouble(partsOfLine.get(25));
        sdControl = Double.parseDouble(partsOfLine.get(26));
        sdTrickDiversity = Double.parseDouble(partsOfLine.get(27));
        sdSpaceUseAndEmphasis = Double.parseDouble(partsOfLine.get(28));
        sdChoreography = Double.parseDouble(partsOfLine.get(29));
        sdConstruction = Double.parseDouble(partsOfLine.get(30));
        sdBodyControl = Double.parseDouble(partsOfLine.get(31));
        sdShowmanship = Double.parseDouble(partsOfLine.get(32));
    }

    //EFFECTS: Prints analyzed competition information
    public void printAnalyzedCompetitionInformation(CompetitionDataAnalysis cdata){
        System.out.println(ANALYSISINTROCURRENT);
        System.out.println(MEANSTRING + middleStrings.get(0)+ ENDSTRING + meanPositiveClicks);
        System.out.println(MEANSTRING + middleStrings.get(1) + ENDSTRING + meanNegativeClicks);
        System.out.println(MEANSTRING + middleStrings.get(2) + ENDSTRING + meanClickerscore);
        System.out.println(MEANSTRING + middleStrings.get(3) + ENDSTRING + meanExecution);
        System.out.println(MEANSTRING + middleStrings.get(4) + ENDSTRING + meanControl);
        System.out.println(MEANSTRING + middleStrings.get(5) + ENDSTRING + meanTrickDiversity);
        System.out.println(MEANSTRING + middleStrings.get(6) + ENDSTRING + meanSpaceUseAndEmphasis);
        System.out.println(MEANSTRING + middleStrings.get(7) + ENDSTRING + meanChoreography);
        System.out.println(MEANSTRING + middleStrings.get(8) + ENDSTRING + meanConstruction);
        System.out.println(MEANSTRING + middleStrings.get(9) + ENDSTRING + meanBodyControl);
        System.out.println(MEANSTRING + middleStrings.get(10) + ENDSTRING + meanShowmanship);
        System.out.println(VARIANCESTRING + middleStrings.get(0)+ ENDSTRING + variancePositiveClicks);
        System.out.println(VARIANCESTRING + middleStrings.get(1)+ ENDSTRING + varianceNegativeClicks);
        System.out.println(VARIANCESTRING + middleStrings.get(2)+ ENDSTRING + varianceClickerscore);
        System.out.println(VARIANCESTRING + middleStrings.get(3)+ ENDSTRING + varianceExecution);
        System.out.println(VARIANCESTRING + middleStrings.get(4)+ ENDSTRING + varianceControl);
        System.out.println(VARIANCESTRING + middleStrings.get(5)+ ENDSTRING + varianceTrickDiversity);
        System.out.println(VARIANCESTRING + middleStrings.get(6)+ ENDSTRING + varianceSpaceUseAndEmphasis);
        System.out.println(VARIANCESTRING + middleStrings.get(7)+ ENDSTRING + varianceChoreography);
        System.out.println(VARIANCESTRING + middleStrings.get(8)+ ENDSTRING + varianceConstruction);
        System.out.println(VARIANCESTRING + middleStrings.get(9)+ ENDSTRING + varianceBodyControl);
        System.out.println(VARIANCESTRING + middleStrings.get(10)+ ENDSTRING + varianceShowmanship);
        System.out.println(SDSTRING + middleStrings.get(0)+ ENDSTRING + sdPositiveClicks);
        System.out.println(SDSTRING + middleStrings.get(1)+ ENDSTRING + sdNegativeClicks);
        System.out.println(SDSTRING + middleStrings.get(2)+ ENDSTRING + sdClickerscore);
        System.out.println(SDSTRING + middleStrings.get(3)+ ENDSTRING + sdExecution);
        System.out.println(SDSTRING + middleStrings.get(4)+ ENDSTRING + sdControl);
        System.out.println(SDSTRING + middleStrings.get(5)+ ENDSTRING + sdTrickDiversity);
        System.out.println(SDSTRING + middleStrings.get(6)+ ENDSTRING + sdSpaceUseAndEmphasis);
        System.out.println(SDSTRING + middleStrings.get(7)+ ENDSTRING + sdChoreography);
        System.out.println(SDSTRING + middleStrings.get(8)+ ENDSTRING + sdConstruction);
        System.out.println(SDSTRING + middleStrings.get(9)+ ENDSTRING + sdBodyControl);
        System.out.println(SDSTRING + middleStrings.get(10)+ ENDSTRING + sdShowmanship);
        System.out.println(STRINGBREAK);
    }

}
//    public void printLoadOutput(ArrayList<String> partsOfLine){
//        System.out.println("Analyzed competition information from memory");
//        System.out.println("---------------------------------------");
//        System.out.println("Mean positive clicks amongst routines: " + partsOfLine.get(0));
//        System.out.println("Mean negative clicks amongst routines: " +partsOfLine.get(1));
//        System.out.println("Mean clickerscore amongst routines: " + partsOfLine.get(2));
//        System.out.println("Mean execution score amongst routines: " + partsOfLine.get(3));
//        System.out.println("Mean control score amongst routines: " + partsOfLine.get(4));
//        System.out.println("Mean trick diversity score amongst routines: " + partsOfLine.get(5));
//        System.out.println("Mean space use & emphasis score amongst routines: " + partsOfLine.get(6));
//        System.out.println("Mean music use 1: choreography score amongst routines: " + partsOfLine.get(7));
//        System.out.println("Mean music use 2: construction score amongst routines: " + partsOfLine.get(8));
//        System.out.println("Mean body control score amongst routines: " + partsOfLine.get(9));
//        System.out.println("Mean showmanship score amongst routines: " + partsOfLine.get(10));
//        System.out.println("Variance of positive clicks amongst routines: " + partsOfLine.get(11));
//        System.out.println("Variance of negative clicks amongst routines: " +partsOfLine.get(12));
//        System.out.println("Variance of clickerscore amongst routines: " + partsOfLine.get(13));
//        System.out.println("Variance of execution score amongst routines: " + partsOfLine.get(14));
//        System.out.println("Variance of control score amongst routines: " + partsOfLine.get(15));
//        System.out.println("Variance of trick diversity score amongst routines: " + partsOfLine.get(16));
//        System.out.println("Variance of space use & emphasis score amongst routines: " + partsOfLine.get(17));
//        System.out.println("Variance of music use 1: choreography score amongst routines: " + partsOfLine.get(18));
//        System.out.println("Variance of music use 2: construction score amongst routines: " + partsOfLine.get(19));
//        System.out.println("Variance of body control score amongst routines: " + partsOfLine.get(20));
//        System.out.println("Variance of showmanship score amongst routines: " + partsOfLine.get(21));
//        System.out.println("Standard deviation of positive clicks amongst routines: " + partsOfLine.get(22));
//        System.out.println("Standard deviation of negative clicks amongst routines: " +partsOfLine.get(23));
//        System.out.println("Standard deviation of clickerscore amongst routines: " + partsOfLine.get(24));
//        System.out.println("Standard deviation of execution score amongst routines: " + partsOfLine.get(25));
//        System.out.println("Standard deviation of control score amongst routines: " + partsOfLine.get(26));
//        System.out.println("Standard deviation of trick diversity score amongst routines: " + partsOfLine.get(27));
//        System.out.println("Standard deviation of space use & emphasis score amongst routines: " + partsOfLine.get(28));
//        System.out.println("Standard deviation of music use 1: choreography score amongst routines: " + partsOfLine.get(29));
//        System.out.println("Standard deviation of music use 2: construction score amongst routines: " + partsOfLine.get(30));
//        System.out.println("Standard deviation of body control score amongst routines: " + partsOfLine.get(32));
//        System.out.println("Standard deviation of showmanship score amongst routines: " + partsOfLine.get(33));
//
//    }
