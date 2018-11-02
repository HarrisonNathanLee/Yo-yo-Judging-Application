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
        clickerScore = this.positiveClicks;
    }

    //MODIFIES: This
    //EFFECTS: Sets positive clicks and negative clicks to zero
    public void resetClicks() {
        positiveClicks = 0;
    }

    //EFFECTS: Will save judge inputted information to csv file
    @Override
    public void save(String saveLocation) throws IOException {
        PrintWriter pw = new PrintWriter(new FileOutputStream(saveLocation, false));
        pw.write(toSaveString());
        pw.close();
    }

    //REQUIRES: Save location must exist in memory
    //EFFECTS: Will read App.player information from csv file
    @Override
    public void read(String saveLocation) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(saveLocation));
        String line = lines.get(0);
        ArrayList<String> partsOfLine = splitOnComma(line);
        printReadOutput(partsOfLine);
        readOutput(partsOfLine);
    }


    //EFFECTS: Creates a string of wildcard App.player information
    public String toSaveString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.firstName);
        sb.append(",");
        sb.append(this.lastName);
        sb.append(",");
        sb.append(this.division);
        sb.append(",");
        sb.append(this.routineType);
        sb.append(",");
        sb.append(this.positiveClicks);
        sb.append(",");
        sb.append(this.clickerScore);
        sb.append("\n");
        return sb.toString();
    }

    //EFFECTS: Reads wildcard App.player information from memory
    public void readOutput(ArrayList<String> partsOfLine){
        this.firstName = partsOfLine.get(0);
        this.lastName = partsOfLine.get(1);
        this.division = partsOfLine.get(2);
        this.routineType = partsOfLine.get(3);
        this.positiveClicks = Double.parseDouble(partsOfLine.get(4));
        this.clickerScore = Double.parseDouble(partsOfLine.get(5));
    }

    //EFFECTS: Prints world final App.player information from memory
    public void printReadOutput(ArrayList<String> partsOfLine){
        System.out.println("Player information and raw scores from memory");
        System.out.println("---------------------------------------");
        System.out.println("firstName: " + partsOfLine.get(0) + " ");
        System.out.println("lastName: " + partsOfLine.get(1) + " ");
        System.out.println("division: " + partsOfLine.get(2) + " ");
        System.out.println("routineType: " + partsOfLine.get(3) + " ");
        System.out.println("positiveClicks: " + partsOfLine.get(4) + " ");
        System.out.println("clickerScore: " + partsOfLine.get(5) + " ");
        System.out.println("---------------------------------------");
    }
}


