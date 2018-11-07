package App.Competition;

import java.util.ArrayList;

public class WorldFinalCompetitionDataAnalysis extends CompetitionDataAnalysis {

    public WorldFinalCompetitionDataAnalysis (Competition competition){
        super(competition);
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

    public String toSaveString(){
        StringBuilder sb = new StringBuilder();
        sb.append(getMeanPositiveClicks());
        sb.append(",");
        sb.append(getMeanNegativeClicks());
        sb.append(",");
        sb.append(getMeanClickerscore());
        sb.append(",");
        sb.append(getMeanExecution());
        sb.append(",");
        sb.append(getMeanControl());
        sb.append(",");
        sb.append(getMeanTrickDiversity());
        sb.append(",");
        sb.append(getMeanSpaceUseAndEmphasis());
        sb.append(",");
        sb.append(getMeanChoreography());
        sb.append(",");
        sb.append(getMeanConstruction());
        sb.append(",");
        sb.append(getMeanBodyControl());
        sb.append(",");
        sb.append(getMeanShowmanship());
        sb.append("\n");
        return sb.toString();
    }

    public void printLoadOutput(ArrayList<String> partsOfLine){
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

    public void loadOutput(ArrayList<String> partsOfLine){
        setMeanPositiveClicks(Double.parseDouble(partsOfLine.get(0)));
        setMeanNegativeClicks(Double.parseDouble(partsOfLine.get(1)));
        setMeanClickerscore(Double.parseDouble(partsOfLine.get(2)));
        setMeanExecution(Double.parseDouble(partsOfLine.get(3)));
        setMeanControl(Double.parseDouble(partsOfLine.get(4)));
        setMeanTrickDiversity(Double.parseDouble(partsOfLine.get(5)));
        setMeanSpaceUseAndEmphasis(Double.parseDouble(partsOfLine.get(6)));
        setMeanChoreography(Double.parseDouble(partsOfLine.get(7)));
        setMeanConstruction(Double.parseDouble(partsOfLine.get(8)));
        setMeanBodyControl(Double.parseDouble(partsOfLine.get(9)));
        setMeanShowmanship(Double.parseDouble(partsOfLine.get(10)));

    }

    //EFFECTS: Prints analyzed competition information
    public void printAnalyzedCompetitionInformation(CompetitionDataAnalysis cdata){
        System.out.println("Mean positive clicks amongst routines: " + cdata.getMeanPositiveClicks());
        System.out.println("Mean negative clicks amongst routines: " +cdata.getMeanNegativeClicks());
        System.out.println("Mean clickerscore amongst routines: " + cdata.getMeanClickerscore());
        System.out.println("Mean execution score amongst routines: " + cdata.getMeanExecution());
        System.out.println("Mean control score amongst routines: " + cdata.getMeanControl());
        System.out.println("Mean trick diversity score amongst routines: " + cdata.getMeanTrickDiversity());
        System.out.println("Mean space use & emphasis score amongst routines: " + cdata.getMeanSpaceUseAndEmphasis());
        System.out.println("Mean music use 1: choreography score amongst routines: " + cdata.getMeanChoreography());
        System.out.println("Mean music use 2: construction score amongst routines: " + cdata.getMeanConstruction());
        System.out.println("Mean body control score amongst routines: " + cdata.getMeanBodyControl());
        System.out.println("Mean showmanship score amongst routines: " + cdata.getMeanShowmanship());
    }

}
