package App.Competition;

import java.util.ArrayList;

public class WildcardCompetitionDataAnalysis extends CompetitionDataAnalysis {

    public WildcardCompetitionDataAnalysis(Competition competition){
        super(competition);
    }

    //MODIFIES: This
    //EFFECTS: Sets the mean for all eval parameters
    public void produceAllMean(){
        players = competition.getPlayers();
        setMeanPositiveClicks(produceMean(players,"positive clicks"));
        setMeanClickerscore(produceMean(players, "clickerscore"));
    }

    public String toSaveString(){
        StringBuilder sb = new StringBuilder();
        sb.append(getMeanPositiveClicks());
        sb.append(",");
        sb.append(getMeanClickerscore());
        sb.append("\n");
        return sb.toString();
    }

    public void printLoadOutput(ArrayList<String> partsOfLine){
        System.out.println("Analyzed competition information from memory");
        System.out.println("---------------------------------------");
        System.out.println("Mean positive clicks amongst routines: " + partsOfLine.get(0));
        System.out.println("Mean clickerscore amongst routines: " + partsOfLine.get(1));
    }

    public void loadOutput(ArrayList<String> partsOfLine){
        setMeanPositiveClicks(Double.parseDouble(partsOfLine.get(0)));
        setMeanClickerscore(Double.parseDouble(partsOfLine.get(1)));
    }

    //EFFECTS: Prints analyzed competition information
    public void printAnalyzedCompetitionInformation(CompetitionDataAnalysis cdata) {
        System.out.println("Mean positive clicks amongst routines: " + cdata.getMeanPositiveClicks());
        System.out.println("Mean clickerscore amongst routines: " + cdata.getMeanClickerscore());
    }


}
