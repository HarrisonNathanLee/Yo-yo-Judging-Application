package App.player;

import javax.print.DocFlavor;
import java.util.ArrayList;


public class WorldFinalPlayer extends Player {

    //EFFECTS: Creates a string of world final App.player information
    public String toSaveString(){
        StringBuilder sb = new StringBuilder();
        sb.append(firstName);
        sb.append(",");
        sb.append(lastName);
        sb.append(",");
        sb.append(division);
        sb.append(",");
        sb.append(routineType);
        sb.append(",");
        sb.append(positiveClicks);
        sb.append(",");
        sb.append(negativeClicks);
        sb.append(",");
        sb.append(clickerScore);
        sb.append(",");
        sb.append(numberOfRestarts);
        sb.append(",");
        sb.append(numberOfChanges);
        sb.append(",");
        sb.append(numberOfDiscards);
        sb.append(",");
        sb.append(restartFinal);
        sb.append(",");
        sb.append(changeFinal);
        sb.append(",");
        sb.append(discardFinal);
        sb.append(",");
        sb.append(execution);
        sb.append(",");
        sb.append(control);
        sb.append(",");
        sb.append(trickDiversity);
        sb.append(",");
        sb.append(spaceUseAndEmphasis);
        sb.append(",");
        sb.append(choreography);
        sb.append(",");
        sb.append(construction);
        sb.append(",");
        sb.append(bodyControl);
        sb.append(",");
        sb.append(showmanship);
        sb.append("\n");
        return sb.toString();
    }

    //EFFECTS: Reads world final App.player information from memory
    public void loadOutput(ArrayList<String> partsOfLine){
        firstName = partsOfLine.get(0);
        lastName = partsOfLine.get(1);
        division = partsOfLine.get(2);
        routineType = partsOfLine.get(3);
        positiveClicks = Double.parseDouble(partsOfLine.get(4));
        negativeClicks = Double.parseDouble(partsOfLine.get(5));
        clickerScore = Double.parseDouble(partsOfLine.get(6));
        numberOfRestarts = Integer.parseInt(partsOfLine.get(7));
        numberOfChanges = Integer.parseInt(partsOfLine.get(8));
        numberOfDiscards = Integer.parseInt(partsOfLine.get(9));
        restartFinal = Integer.parseInt(partsOfLine.get(10));
        changeFinal = Integer.parseInt(partsOfLine.get(11));
        discardFinal = Integer.parseInt(partsOfLine.get(12));
        execution = Integer.parseInt(partsOfLine.get(13));
        control = Integer.parseInt(partsOfLine.get(14));
        trickDiversity = Integer.parseInt(partsOfLine.get(15));
        spaceUseAndEmphasis = Integer.parseInt(partsOfLine.get(16));
        choreography = Integer.parseInt(partsOfLine.get(17));
        construction = Integer.parseInt(partsOfLine.get(18));
        bodyControl = Integer.parseInt(partsOfLine.get(19));
        showmanship = Integer.parseInt(partsOfLine.get(20));

    }

    //EFFECTS: prints player information from memory
    public void printLoadOutput(ArrayList<String> partsOfLine){
        System.out.println(SCORESFROMMEMORY);
        System.out.println(STRINGBREAK);
        String fullName = partsOfLine.get(0) + " " + partsOfLine.get(1) + "'s ";
        System.out.println(fullName + ROUTINEINFORMATION);
        System.out.println("Division: " + partsOfLine.get(2));
        System.out.println("Routine type: " + partsOfLine.get(3));
        System.out.println(STRINGBREAK);
        System.out.println(fullName + TECHNICALDATA);
        System.out.println("Positive Clicks: " + partsOfLine.get(4));
        System.out.println("Negative Clicks: " + partsOfLine.get(5));
        System.out.println("Clickerscore: " + partsOfLine.get(6));
        System.out.println(STRINGBREAK);
        System.out.println(fullName + MAJORDEDUCTSCORES);
        System.out.println("Number of restarts: " + partsOfLine.get(7));
        System.out.println("Final restart score: " + partsOfLine.get(10));
        System.out.println("Number of changes: " + partsOfLine.get(8));
        System.out.println("Final change score: " + partsOfLine.get(11));
        System.out.println("Number of discards: " + partsOfLine.get(9));
        System.out.println("Final discard score: " + partsOfLine.get(12));
        System.out.println(STRINGBREAK);
        System.out.println(fullName + PERFORMANCEEVALS);
        System.out.println("Execution: " + partsOfLine.get(13));
        System.out.println("Control: " + partsOfLine.get(14));
        System.out.println("Trick Diversity: " + partsOfLine.get(15));
        System.out.println("Space Use And Emphasis: " + partsOfLine.get(16));
        System.out.println("Choreography: " + partsOfLine.get(17));
        System.out.println("Body Control: " + partsOfLine.get(18));
        System.out.println("Showmanship: " + partsOfLine.get(19));
        System.out.println(STRINGBREAK);
    }

    //EFFECTS: Prints judge inputted performance evaluations
    public void getPerformanceEvals(Player p) {
        System.out.println(p.getFirstName() + " " + p.getLastName() + "'s" + PERFORMANCEEVALS);
        System.out.println("Execution: " + p.getExecution());
        System.out.println("Control: " + p.getControl());
        System.out.println("Trick Diversity: " + p.getTrickDiversity());
        System.out.println("Space Use and Emphasis: " + p.getSpaceUseAndEmphasis());
        System.out.println("Choreography: " + p.getChoreography());
        System.out.println("Construction: " + p.getConstruction());
        System.out.println("Body control: " + p.getBodyControl());
        System.out.println("Showmanship: " + p.getShowmanship());
        System.out.println(STRINGBREAK);
    }
}

