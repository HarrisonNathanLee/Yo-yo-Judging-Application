package player;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class WorldFinalPlayer extends Player {

    //EFFECTS: Will save judge inputted information to csv file
    @Override
    public void save(String saveLocation) throws IOException {
        PrintWriter pw = new PrintWriter(new FileOutputStream(saveLocation, false));
        pw.write(toSaveString());
        pw.close();
    }

    //REQUIRES: Save location to exist in memory
    //EFFECTS: Will read player information from csv file
    @Override
    public void read(String saveLocation) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(saveLocation));
        String line = lines.get(0);
        ArrayList<String> partsOfLine = splitOnComma(line);
        playerDataAnalysisPrintReadOutput(partsOfLine);
        readOutput(partsOfLine);

    }

    //EFFECTS: Creates a string of world final player information
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
        sb.append(this.negativeClicks);
        sb.append(",");
        sb.append(this.clickerScore);
        sb.append(",");
        sb.append(this.numberOfRestarts);
        sb.append(",");
        sb.append(this.numberOfChanges);
        sb.append(",");
        sb.append(this.numberOfDiscards);
        sb.append(",");
        sb.append(this.restartFinal);
        sb.append(",");
        sb.append(this.changeFinal);
        sb.append(",");
        sb.append(this.discardFinal);
        sb.append(",");
        sb.append(this.execution);
        sb.append(",");
        sb.append(this.control);
        sb.append(",");
        sb.append(this.trickDiversity);
        sb.append(",");
        sb.append(this.spaceUseAndEmphasis);
        sb.append(",");
        sb.append(this.choreography);
        sb.append(",");
        sb.append(this.construction);
        sb.append(",");
        sb.append(this.bodyControl);
        sb.append(",");
        sb.append(this.showmanship);
        sb.append("\n");
        return sb.toString();
    }

    //EFFECTS: Reads world final player information from memory
    public void readOutput(ArrayList<String> partsOfLine){
        this.firstName = partsOfLine.get(0);
        this.lastName = partsOfLine.get(1);
        this.division = partsOfLine.get(2);
        this.routineType = partsOfLine.get(3);
        this.positiveClicks = Double.parseDouble(partsOfLine.get(4));
        this.negativeClicks = Double.parseDouble(partsOfLine.get(5));
        this.clickerScore = Double.parseDouble(partsOfLine.get(6));
        this.numberOfRestarts = Integer.parseInt(partsOfLine.get(7));
        this.numberOfChanges = Integer.parseInt(partsOfLine.get(8));
        this.numberOfDiscards = Integer.parseInt(partsOfLine.get(9));
        this.restartFinal = Integer.parseInt(partsOfLine.get(10));
        this.changeFinal = Integer.parseInt(partsOfLine.get(11));
        this.discardFinal = Integer.parseInt(partsOfLine.get(12));
        this.execution = Integer.parseInt(partsOfLine.get(13));
        this.control = Integer.parseInt(partsOfLine.get(14));
        this.trickDiversity = Integer.parseInt(partsOfLine.get(15));
        this.spaceUseAndEmphasis = Integer.parseInt(partsOfLine.get(16));
        this.choreography = Integer.parseInt(partsOfLine.get(17));
        this.construction = Integer.parseInt(partsOfLine.get(18));
        this.bodyControl = Integer.parseInt(partsOfLine.get(19));
        this.showmanship = Integer.parseInt(partsOfLine.get(20));

    }

    public void playerDataAnalysisPrintReadOutput(ArrayList<String> partsOfLine){
        System.out.println("Player information and raw scores from memory");
        System.out.println("---------------------------------------");
        System.out.println("firstName: " + partsOfLine.get(0) + " ");
        System.out.println("lastName: " + partsOfLine.get(1) + " ");
        System.out.println("division: " + partsOfLine.get(2) + " ");
        System.out.println("routineType: " + partsOfLine.get(3) + " ");
        System.out.println("positiveClicks: " + partsOfLine.get(4) + " ");
        System.out.println("negativeClicks: " + partsOfLine.get(5) + " ");
        System.out.println("clickerScore: " + partsOfLine.get(6) + " ");
        System.out.println("numberOfRestarts: " + partsOfLine.get(7) + " ");
        System.out.println("numberOfChanges: " + partsOfLine.get(8) + " ");
        System.out.println("numberOfDiscards: " + partsOfLine.get(9) + " ");
        System.out.println("restartFinal: " + partsOfLine.get(10) + " ");
        System.out.println("changeFinal: " + partsOfLine.get(11) + " ");
        System.out.println("discardFinal: " + partsOfLine.get(12) + " ");
        System.out.println("execution: " + partsOfLine.get(13) + " ");
        System.out.println("control: " + partsOfLine.get(14) + " ");
        System.out.println("trickDiversity: " + partsOfLine.get(15) + " ");
        System.out.println("spaceUseAndEmphasis: " + partsOfLine.get(16) + " ");
        System.out.println("choreography: " + partsOfLine.get(17) + " ");
        System.out.println("bodyControl: " + partsOfLine.get(18) + " ");
        System.out.println("showmanship: " + partsOfLine.get(19) + " ");
        System.out.println("---------------------------------------");
    }
}

