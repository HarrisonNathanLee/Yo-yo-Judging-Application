package App.Competition;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;

public class PrelimTwoSemiCompetitionDataAnalysis extends CompetitionDataAnalysis {

    // CONSTRUCTOR
    // EFFECTS: sets up competition data analysis for prelim, two and semi
    public PrelimTwoSemiCompetitionDataAnalysis (Competition competition){
        super(competition);
        middleStrings = new ArrayList<>();
        middleStrings.add("positive clicks ");
        middleStrings.add("negative clicks ");
        middleStrings.add("clickerscore ");
        middleStrings.add("execution score ");
        middleStrings.add("control score ");
        middleStrings.add("music use 1: choreography score ");
        middleStrings.add("showmanship score ");
    }

    //MODIFIES: This
    //EFFECTS: Sets the mean for all eval parameters
    public void produceAllMean(){
        players = competition.getPlayers();
        meanExecution = produceMean(players, "execution");
        meanControl = produceMean(players, "control");
        meanChoreography = produceMean(players, "choreography");
        meanBodyControl = produceMean(players, "bodyControl");
        meanPositiveClicks = produceMean(players,"positive clicks");
        meanNegativeClicks = produceMean(players, "negative clicks");
        meanClickerscore = produceMean(players, "clickerscore");
    }

    //MODIFIES: This
    //EFFECTS: Sets the variance for all eval parameters
    public void produceAllVariance(){
        players = competition.getPlayers();
        varianceExecution = produceVariance(players, "execution");
        varianceControl = produceVariance(players, "control");
        varianceChoreography = produceVariance(players, "choreography");
        varianceBodyControl = produceVariance(players, "bodyControl");
        variancePositiveClicks = produceVariance(players,"positive clicks");
        varianceNegativeClicks = produceVariance(players, "negative clicks");
        varianceClickerscore = produceVariance(players, "clickerscore");
    }

    //MODIFIES: This
    //EFFECTS: Sets the standard deviation for all eval parameters
    public void produceAllStandardDeviation(){
        sdExecution = Math.sqrt(varianceExecution);
        sdControl = Math.sqrt(varianceControl);
        sdTrickDiversity = Math.sqrt(varianceTrickDiversity);
        sdChoreography = Math.sqrt(varianceChoreography);
        sdBodyControl = Math.sqrt(varianceBodyControl);
        sdPositiveClicks = Math.sqrt(variancePositiveClicks);
        sdNegativeClicks = Math.sqrt(varianceNegativeClicks);
        sdClickerscore = Math.sqrt(varianceClickerscore);
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
        sb.append(meanChoreography);
        sb.append(",");
        sb.append(meanBodyControl);
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
        sb.append(varianceChoreography);
        sb.append(",");
        sb.append(varianceBodyControl);
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
        sb.append(sdChoreography);
        sb.append(",");
        sb.append(sdBodyControl);
        sb.append(",");
        return sb.toString();
    }

    //EFFECTS: Prints analyzed competition information from memory
    public void printLoadOutput(ArrayList<String> partsOfLine){
        int sp = 0;
        int ep1 = 7;
        int ep2 = 14;
        int ep3 = partsOfLine.size();
        System.out.println(ANALYSISINTROMEMORY);
        printLoadOutputHelper(MEANSTRING,partsOfLine,sp,ep1);
        System.out.println(STRINGBREAK);
        printLoadOutputHelper(VARIANCESTRING,partsOfLine,ep1,ep2);
        System.out.println(STRINGBREAK);
        printLoadOutputHelper(SDSTRING, partsOfLine,ep2,ep3);
        System.out.println(STRINGBREAK);
    }

    //MODIFIES: This
    //EFFECTS: Sets competition data analysis fields from memory
    public void loadOutput(ArrayList<String> partsOfLine){
        meanPositiveClicks = Double.parseDouble(partsOfLine.get(0));
        meanNegativeClicks = Double.parseDouble(partsOfLine.get(1));
        meanClickerscore = Double.parseDouble(partsOfLine.get(2));
        meanExecution = Double.parseDouble(partsOfLine.get(3));
        meanControl = Double.parseDouble(partsOfLine.get(4));
        meanChoreography = Double.parseDouble(partsOfLine.get(5));
        meanBodyControl = Double.parseDouble(partsOfLine.get(6));
        variancePositiveClicks = Double.parseDouble(partsOfLine.get(7));
        varianceNegativeClicks = Double.parseDouble(partsOfLine.get(8));
        varianceClickerscore = Double.parseDouble(partsOfLine.get(9));
        varianceExecution = Double.parseDouble(partsOfLine.get(10));
        varianceControl = Double.parseDouble(partsOfLine.get(11));
        varianceChoreography = Double.parseDouble(partsOfLine.get(12));
        varianceBodyControl = Double.parseDouble(partsOfLine.get(13));
        sdPositiveClicks = Double.parseDouble(partsOfLine.get(14));
        sdNegativeClicks = Double.parseDouble(partsOfLine.get(15));
        sdClickerscore = Double.parseDouble(partsOfLine.get(16));
        sdExecution = Double.parseDouble(partsOfLine.get(17));
        sdControl = Double.parseDouble(partsOfLine.get(18));
        sdChoreography = Double.parseDouble(partsOfLine.get(19));
        sdBodyControl = Double.parseDouble(partsOfLine.get(20));
    }


    //EFFECTS: Prints analyzed competition information
    public void printAnalyzedCompetitionInformation(CompetitionDataAnalysis cdata){
        System.out.println(ANALYSISINTROCURRENT);
        System.out.println(MEANSTRING + middleStrings.get(0)+ ENDSTRING + meanPositiveClicks);
        System.out.println(MEANSTRING + middleStrings.get(1) + ENDSTRING + meanNegativeClicks);
        System.out.println(MEANSTRING + middleStrings.get(2) + ENDSTRING + meanClickerscore);
        System.out.println(MEANSTRING + middleStrings.get(3) + ENDSTRING + meanExecution);
        System.out.println(MEANSTRING + middleStrings.get(4) + ENDSTRING + meanControl);
        System.out.println(MEANSTRING + middleStrings.get(5) + ENDSTRING + meanChoreography);
        System.out.println(MEANSTRING + middleStrings.get(6) + ENDSTRING + meanBodyControl);
        System.out.println(STRINGBREAK);
        System.out.println(VARIANCESTRING + middleStrings.get(0)+ ENDSTRING + variancePositiveClicks);
        System.out.println(VARIANCESTRING + middleStrings.get(1)+ ENDSTRING + varianceNegativeClicks);
        System.out.println(VARIANCESTRING + middleStrings.get(2)+ ENDSTRING + varianceClickerscore);
        System.out.println(VARIANCESTRING + middleStrings.get(3)+ ENDSTRING + varianceExecution);
        System.out.println(VARIANCESTRING + middleStrings.get(4)+ ENDSTRING + varianceControl);
        System.out.println(VARIANCESTRING + middleStrings.get(5)+ ENDSTRING + varianceChoreography);
        System.out.println(VARIANCESTRING + middleStrings.get(6)+ ENDSTRING + varianceBodyControl);
        System.out.println(STRINGBREAK);
        System.out.println(SDSTRING + middleStrings.get(0)+ ENDSTRING + sdPositiveClicks);
        System.out.println(SDSTRING + middleStrings.get(1)+ ENDSTRING + sdNegativeClicks);
        System.out.println(SDSTRING + middleStrings.get(2)+ ENDSTRING + sdClickerscore);
        System.out.println(SDSTRING + middleStrings.get(3)+ ENDSTRING + sdExecution);
        System.out.println(SDSTRING + middleStrings.get(4)+ ENDSTRING + sdControl);
        System.out.println(SDSTRING + middleStrings.get(5)+ ENDSTRING + sdChoreography);
        System.out.println(SDSTRING + middleStrings.get(6)+ ENDSTRING + sdBodyControl);
        System.out.println(STRINGBREAK);
    }

}
