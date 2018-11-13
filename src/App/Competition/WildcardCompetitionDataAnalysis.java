package App.Competition;

import java.util.ArrayList;

public class WildcardCompetitionDataAnalysis extends CompetitionDataAnalysis {

    // CONSTRUCTOR
    // EFFECTS: sets up competition data analysis for wildcard
    public WildcardCompetitionDataAnalysis(Competition competition){
        super(competition);
        middleStrings = new ArrayList<>();
        middleStrings.add("positive clicks ");
        middleStrings.add("clickerscore ");
    }

    //MODIFIES: This
    //EFFECTS: Sets the mean for all parameters
    public void produceAllMean(){
        players = competition.getPlayers();
        meanPositiveClicks = produceMean(players,"positive clicks");
        meanClickerscore = produceMean(players, "clickerscore");
    }

    //MODIFIES: This
    //EFFECTS: Sets the variance for all parameters
    public void produceAllVariance(){
        players = competition.getPlayers();
        variancePositiveClicks = produceVariance(players,"positive clicks");
        varianceClickerscore = produceVariance(players, "clickerscore");
    }

    //MODIFIES: This
    //EFFECTS: Sets the standard deviation for all parameters
    public void produceAllStandardDeviation(){
        sdPositiveClicks = Math.sqrt(variancePositiveClicks);
        sdClickerscore = Math.sqrt(varianceClickerscore);
    }

    //EFFECTS: Adds competition data analysis fields to a string
    public String toSaveString(){
        StringBuilder sb = new StringBuilder();
        sb.append(meanPositiveClicks);
        sb.append(",");
        sb.append(meanClickerscore);
        sb.append(",");
        sb.append(variancePositiveClicks);
        sb.append(",");
        sb.append(varianceClickerscore);
        sb.append(",");
        sb.append(sdPositiveClicks);
        sb.append(",");
        sb.append(sdClickerscore);
        sb.append("\n");
        return sb.toString();
    }

    //EFFECTS: Prints analyzed competition information from memory
    public void printLoadOutput(ArrayList<String> partsOfLine){
        int sp = 0;
        int ep1 = 2;
        int ep2 = 4;
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
        meanClickerscore = Double.parseDouble(partsOfLine.get(1));
        variancePositiveClicks = Double.parseDouble(partsOfLine.get(2));
        varianceClickerscore = Double.parseDouble(partsOfLine.get(3));
        sdPositiveClicks = Double.parseDouble(partsOfLine.get(4));
        sdClickerscore = Double.parseDouble(partsOfLine.get(5));
    }

    //EFFECTS: Prints analyzed competition information
    public void printAnalyzedCompetitionInformation(CompetitionDataAnalysis cdata){
        System.out.println(ANALYSISINTROCURRENT);
        System.out.println(MEANSTRING + middleStrings.get(0)+ ENDSTRING + meanPositiveClicks);
        System.out.println(MEANSTRING + middleStrings.get(2) + ENDSTRING + meanClickerscore);
        System.out.println(VARIANCESTRING + middleStrings.get(0)+ ENDSTRING + variancePositiveClicks);
        System.out.println(VARIANCESTRING + middleStrings.get(2)+ ENDSTRING + varianceClickerscore);
        System.out.println(SDSTRING + middleStrings.get(0)+ ENDSTRING + sdPositiveClicks);
        System.out.println(SDSTRING + middleStrings.get(2)+ ENDSTRING + sdClickerscore);
        System.out.println(STRINGBREAK);
    }

}

//    public void printLoadOutput(ArrayList<String> partsOfLine){
//        System.out.println("Analyzed competition information from memory");
//        System.out.println("---------------------------------------");
//        System.out.println("Mean positive clicks amongst routines: " + partsOfLine.get(0));
//        System.out.println("Mean clickerscore amongst routines: " + partsOfLine.get(1));
//        System.out.println("Variance positive clicks amongst routines: " + partsOfLine.get(2));
//        System.out.println("Variance clickerscore amongst routines: " + partsOfLine.get(3));
//        System.out.println("Standard deviation of positive clicks amongst routines: " + partsOfLine.get(4));
//        System.out.println("Standard deviation of clickerscore amongst routines: " + partsOfLine.get(5));
//
//    }
