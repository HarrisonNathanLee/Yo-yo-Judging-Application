/*
package Competition;

import player.Player;
import player.Readable;
import player.Saveable;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;


public class Competition implements Readable, Saveable {
    protected Player player;
    private String competitionName = "";
    private String competitionDivision = "";
    private String competitionRoutineType = "";


    @Override
    public void read(String saveLocation throws IOException {
    }

    @Override
    public void save(String saveLocation) throws IOException {
        PrintWriter pw = new PrintWriter(new FileOutputStream(this.saveLocation, true));
        StringBuilder sb = new StringBuilder();

        sb.append(player.getFirstName());
        sb.append(",");
        sb.append(player.getLastName());
        sb.append(",");
        sb.append(player.getDivision());
        sb.append(",");
        sb.append(player.getRoutineType());
        sb.append(",");
        sb.append(player.getPositiveClicks());
        sb.append(",");
        sb.append(player.getNegativeClicks());
        sb.append(",");
        sb.append(player.getClickerScore());
        sb.append(",");
        sb.append(player.getNumberOfRestarts();
        sb.append(",");
        sb.append(player.getNumberOfChanges());
        sb.append(",");
        sb.append(player.getNumberOfDiscards());
        sb.append(",");
        sb.append(player.getRestartFinal());
        sb.append(",");
        sb.append(player.getChangeFinal());
        sb.append(",");
        sb.append(player.getDiscardFinal());
        sb.append(",");
        sb.append(player.getExecution());
        sb.append(",");
        sb.append(player.getControl());
        sb.append(",");
        sb.append(player.getTrickDiversity());
        sb.append(",");
        sb.append(player.getSpaceUseAndEmphasis());
        sb.append(",");
        sb.append(player.getChoreography());
        sb.append(",");
        sb.append(player.getConstruction());
        sb.append(",");
        sb.append(player.getBodyControl());
        sb.append(",");
        sb.append(player.getShowmanship());
        sb.append("\n");

        pw.write(sb.toString());
        pw.close();


    }
}
*/