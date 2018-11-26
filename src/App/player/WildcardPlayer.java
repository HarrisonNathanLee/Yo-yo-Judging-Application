package App.player;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class WildcardPlayer extends Player {

    //MODIFIES: This
    //EFFECTS: Produces and returns the final clickerScore from the positive clicks awarded and the negative clicks deducted
    public void produceClickerScore() {
        clickerScore = positiveClicks;
    }

    //MODIFIES: This
    //EFFECTS: Sets positive clicks and negative clicks to zero
    public void resetClicks() {
        positiveClicks = 0;
    }

    //EFFECTS: Creates a string of wildcard App.player information
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
        sb.append(clickerScore);
        sb.append("\n");
        return sb.toString();
    }

    //EFFECTS: Reads wildcard App.player information from memory
    public void loadOutput(ArrayList<String> partsOfLine){
        firstName = partsOfLine.get(0);
        lastName = partsOfLine.get(1);
        division = partsOfLine.get(2);
        routineType = partsOfLine.get(3);
        positiveClicks = Double.parseDouble(partsOfLine.get(4));
        clickerScore = Double.parseDouble(partsOfLine.get(5));
    }

    //EFFECTS: Prints world final App.player information from memory
    public void printLoadOutput(ArrayList<String> partsOfLine){
        System.out.println(SCORESFROMMEMORY);
        System.out.println(STRINGBREAK);
        String fullName = partsOfLine.get(0) + " " + partsOfLine.get(1) + "'s ";
        System.out.println(fullName + "routine information:");
        System.out.println("Division: " + partsOfLine.get(2));
        System.out.println("Routine Type: " + partsOfLine.get(3));
        System.out.println(STRINGBREAK);
        System.out.println(fullName + "technical data:");
        System.out.println("Positive clicks: " + partsOfLine.get(4));
        System.out.println("Clickerscore: " + partsOfLine.get(5));
    }


    public void getPerformanceEvals(Player p){
        System.out.println("return nothing");
    }


    @Override
    public void printRoutineClickInformation(Player p) {
        System.out.println(p.getFirstName() + " " + p.getLastName() + "'s technical data: ");
        System.out.println("Positive clicks: " + p.getPositiveClicks());
        System.out.println("Clickerscore: " + p.getClickerScore());
        System.out.println(STRINGBREAK);
    }
}


