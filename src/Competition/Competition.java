package Competition;

import Exceptions.NullPlayerException;
import player.Player;
import player.PlayerDataAnalysis;
import player.Saveable;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static player.Player.splitOnComma;


public class Competition implements Saveable{
    protected Player player;
    private String competitionName = "";
    private String competitionDivision = "";
    private String competitionRoutineType = "";
    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<PlayerDataAnalysis> dataAnalyses = new ArrayList<>();


    public void addPlayer(Player p){
        players.add(p);
    }
    public void addPlayerDataAnalysis(PlayerDataAnalysis data){
        dataAnalyses.add(data);
    }


    public void save(String saveLocation) throws IOException{
        PrintWriter pw1 = new PrintWriter(new FileOutputStream(saveLocation + "Player.csv", true));
        for (Player p: players) {
            if (p == null){
                // do nothing
            }
            else {
                String pstr = p.playerToSaveString();
                pw1.write(pstr);
            }
        }
        pw1.close();
        PrintWriter pw2 = new PrintWriter(new FileOutputStream(saveLocation + "PlayerDataAnalysis.csv", true));
        for (PlayerDataAnalysis data : dataAnalyses) {
            if (data == null){
                // do nothing
            }
            else {
                String pstr = data.playerDataAnalysisToSaveString();
                pw2.write(pstr);
            }
        }
        pw2.close();

    }

//    public void read(String saveLocation) throws IOException {
//        List<String> lines = Files.readAllLines(Paths.get(saveLocation + "Player.csv"));
//        for (Player p : players) {
//            for (String line : lines) {
//                ArrayList<String> partsOfLine = splitOnComma(line);
//                p.playerPrintReadOutput(partsOfLine);
//            }
//        }
//    }


    /*
    @Override
    public void read(String saveLocation throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(saveLocation));
        if (actual type of player is  wildcard){
            for (String line: lines){
                ArrayList<String> partsOfLine = splitOnComma(line);
                this.firstName = partsOfLine.get(0);
                this.lastName = partsOfLine.get(1);
                this.division = partsOfLine.get(2);
                this.routineType = partsOfLine.get(3);
                this.positiveClicks = Double.parseDouble(partsOfLine.get(4));
                this.clickerScore = Double.parseDouble(partsOfLine.get(5));
        }
        else if ( actual type of player is prelim, semi or two minute){
            for (String line: lines){
                ArrayList<String> partsOfLine = splitOnComma(line);
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
                this.choreography = Integer.parseInt(partsOfLine.get(15));
                this.bodyControl = Integer.parseInt(partsOfLine.get(16));
            }
        else if (actual type of player is world final )   {
            for (String line: lines){
                    ArrayList<String> partsOfLine = splitOnComma(line);
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

    }

*/
    // // for save location

}

/*
            sb.append(player.getFirstName());
            sb.append(",");
            sb.append(player.getLastName());
            sb.append(",");
            sb.append(player.getDivision());
            sb.append(",");
            sb.append(player.getRoutineType());
            sb.append(",");

            if (actual type of player == wildcard){
                sb.append(player.getPositiveClicks());
                sb.append(",");
                sb.append(player.getClickerScore());
                sb.append("\n");
            }
        else if (actual type of player == prelim or semi or two minute){
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
                sb.append(player.getChoreography());
                sb.append(",");
                sb.append(player.getBodyControl());
                sb.append("\n");
            }
        else if (actual type of player == world final ){
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
            }

            */