package App.player;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class WildcardPlayerDataAnalysis extends PlayerDataAnalysis {

    public WildcardPlayerDataAnalysis(WildcardPlayer p) {
        super(p);
    }

    //MODIFIES: This
    //EFFECTS: Performs all App.player data analysis methods
    public void callAllDataAnalysis() {
        clicksPerSecond();
    }

    //EFFECTS: Will save data analysis information to csv file
    @Override
    public void save(String saveLocation) throws IOException {
        PrintWriter pw = new PrintWriter(new FileOutputStream(saveLocation, false));
        pw.write(toSaveString());
        pw.close();
    }

    //REQUIRES: Save location to exist in memory
    //EFFECTS: Will output App.player analysis information from saved file
    @Override
    public void load(String saveLocation) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(saveLocation));
        String line  = lines.get(0);
        ArrayList<String> partsOfLine = splitOnComma(line);
       printLoadOutput(partsOfLine);
        loadOutput(partsOfLine);

    }

    //EFFECTS: Creates a string of wildcard App.player data analysis information
    public String toSaveString(){
        StringBuilder sb = new StringBuilder();
        sb.append(player.getFirstName());
        sb.append(",");
        sb.append(player.getLastName());
        sb.append(",");
        sb.append(this.CPS);
        sb.append("\n");
        return sb.toString();
    }

    //EFFECTS: Reads wildcard App.player data analysis information from memory
    public void loadOutput(ArrayList<String> partsOfLine){
        player.setFirstName(partsOfLine.get(0));
        player.setLastName(partsOfLine.get(1));
        this.CPS = Double.parseDouble(partsOfLine.get(2));
    }

    //EFFECTS: Prints wildcard App.player data analysis information from memory
    public void printLoadOutput(ArrayList<String> partsOfLine){
        System.out.println("Player data analysis information from memory");
        System.out.println("---------------------------------------");
        System.out.println("firstName: " + partsOfLine.get(0) + " ");
        System.out.println("lastName: " + partsOfLine.get(1) + " ");
        System.out.println("CPS: " + partsOfLine.get(2) + " ");
        System.out.println("---------------------------------------");
    }

}
