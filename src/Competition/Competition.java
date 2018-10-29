package Competition;

import player.*;
import player.Readable;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class Competition extends Readable implements Saveable {
    protected Player player;
    private String competitionName = "";
    private String competitionDivision = "";
    private String competitionRoutineType = "";
    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<PlayerDataAnalysis> dataAnalyses = new ArrayList<>();


    public void setCompetitionName(String competitionName) {
        this.competitionName = competitionName;
    }

    public String getCompetitionName() {
        return competitionName;
    }

    public void addPlayer(Player p){
        players.add(p);
    }
    public void addPlayerDataAnalysis(PlayerDataAnalysis data){
        dataAnalyses.add(data);
    }


    //EFFECTS: Saves the data for all players in a competition to two CSV files
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


    //EFFECTS: Reads data from competition files
    public void read(String saveLocation) throws IOException {
        List<String> playerLines = Files.readAllLines(Paths.get(saveLocation + "Player.csv"));
        List<String> playerDataAnalysisLines = Files.readAllLines(Paths.get(saveLocation + "PlayerDataAnalysis.csv"));
        int i = 0;
        for (String playerLine : playerLines) {
            ArrayList<String> playerPartsOfLine = splitOnComma(playerLine);
            if (playerPartsOfLine.contains("Wildcard")){
                WildcardPlayer p = new WildcardPlayer();
                WildcardPlayerDataAnalysis data = new WildcardPlayerDataAnalysis(p);
                p.playerPrintReadOutput(playerPartsOfLine);
                readPlayerDataAnalysisLines(playerDataAnalysisLines, data, i);
                i++;
            }
            if (playerPartsOfLine.contains("Prelim")){
                PrelimPlayer p = new PrelimPlayer();
                PrelimPlayerDataAnalysis data = new PrelimPlayerDataAnalysis(p);
                p.playerPrintReadOutput(playerPartsOfLine);
                readPlayerDataAnalysisLines(playerDataAnalysisLines, data, i);
                i++;
            }
            if (playerPartsOfLine.contains("Semi")){
                SemiPlayer p = new SemiPlayer();
                SemiPlayerDataAnalysis data = new SemiPlayerDataAnalysis(p);
                p.playerPrintReadOutput(playerPartsOfLine);
                readPlayerDataAnalysisLines(playerDataAnalysisLines, data, i);
                i++;
            }
            if (playerPartsOfLine.contains("Two Minute Final")){
                TwoMinuteFinalPlayer p = new TwoMinuteFinalPlayer();
                TwoMinuteFinalPlayerDataAnalysis data = new TwoMinuteFinalPlayerDataAnalysis(p);
                p.playerPrintReadOutput(playerPartsOfLine);
                readPlayerDataAnalysisLines(playerDataAnalysisLines, data, i);
                i++;
            }
            if (playerPartsOfLine.contains("World Final")){
                WorldFinalPlayer p = new WorldFinalPlayer();
                WorldFinalPlayerDataAnalysis data = new WorldFinalPlayerDataAnalysis(p);
                p.playerPrintReadOutput(playerPartsOfLine);
                readPlayerDataAnalysisLines(playerDataAnalysisLines, data, i);
                i++;
            }


            }
        }


    //EFFECTS: Reads and prints an individual line of a competiton playerDataAnalysis file based on index
    private void readPlayerDataAnalysisLines(List<String> playerDataAnalysisLines, PlayerDataAnalysis data, Integer i) {
        String playerDataAnalysisLine = playerDataAnalysisLines.get(i);
        ArrayList<String> playerDataAnalysisPartsOfLine = splitOnComma(playerDataAnalysisLine);
        data.playerDataAnalysisPrintReadOutput(playerDataAnalysisPartsOfLine);
        }

}

