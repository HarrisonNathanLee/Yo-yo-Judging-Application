package App.player;

import javax.print.DocFlavor;
import java.util.ArrayList;

public class PrelimTwoSemiPlayer extends Player {

    //EFFECTS: Creates a string of App.player information
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
        sb.append(choreography);
        sb.append(",");
        sb.append(bodyControl);
        sb.append("\n");
        return sb.toString();
    }

    //EFFECTS: Reads App.player information from memory
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
        choreography = Integer.parseInt(partsOfLine.get(15));
        bodyControl = Integer.parseInt(partsOfLine.get(16));
    }

    //EFFECTS: Prints App.player information from memory
    public void printLoadOutput(ArrayList<String> partsOfLine){
        System.out.println(SCORESFROMMEMORY);
        System.out.println(STRINGBREAK);
        System.out.println("firstName: " + partsOfLine.get(0));
        System.out.println("lastName: " + partsOfLine.get(1));
        System.out.println("division: " + partsOfLine.get(2));
        System.out.println("routineType: " + partsOfLine.get(3));
        System.out.println("positiveClicks: " + partsOfLine.get(4));
        System.out.println("negativeClicks: " + partsOfLine.get(5));
        System.out.println("clickerScore: " + partsOfLine.get(6));
        System.out.println("numberOfRestarts: " + partsOfLine.get(7));
        System.out.println("numberOfChanges: " + partsOfLine.get(8));
        System.out.println("numberOfDiscards: " + partsOfLine.get(9));
        System.out.println("restartFinal: " + partsOfLine.get(10));
        System.out.println("changeFinal: " + partsOfLine.get(11));
        System.out.println("discardFinal: " + partsOfLine.get(12));
        System.out.println("execution: " + partsOfLine.get(13));
        System.out.println("control: " + partsOfLine.get(14));
        System.out.println("choreography: " + partsOfLine.get(15));
        System.out.println("bodyControl: " + partsOfLine.get(16));
        System.out.println(STRINGBREAK);
    }


    //EFFECTS: Prints judge inputted performance evaluations
    public void getPerformanceEvals(Player p) {
        System.out.println(p.getFirstName() + " " + p.getLastName() + PERFORMANCEEVALS);
        System.out.println("Execution: " + p.getExecution());
        System.out.println("Control: " + p.getControl());
        System.out.println("Choreography: " + p.getChoreography());
        System.out.println("Body control: " + p.getBodyControl());
        System.out.println(STRINGBREAK);
    }

}
