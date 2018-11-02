package App.Competition;

import App.player.*;
import App.player.Loadable;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class Competition extends Loadable implements Saveable {
    protected Player player;
    private String competitionName = "";
    private String competitionDivision = "";
    private String competitionRoutineType = "";
    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<PlayerDataAnalysis> dataAnalyses = new ArrayList<>();

    //MODIFIES: This
    //EFFECTS: Sets the competitionName of the competition
    public void setCompetitionName(String competitionName) {
        this.competitionName = competitionName;
    }

    //EFFECTS: Returns the competitionName of the competition
    public String getCompetitionName() {
        return competitionName;
    }

    //EFFECTS: Returns the players in the competition
    public ArrayList<Player> getPlayers() {
        return players;
    }

//    //EFFECTS: Adds a App.player to a competition
//    public void addPlayer(Player p){
//        players.add(p);
//    }

    //EFFECTS: Adds a App.player to a competition
    public void addPlayer(Player p){
        if(!players.contains(p)) {
            players.add(p);
            p.addCompetition(this);
        }
    }

    public void removePlayer (Player p){
        if(players.contains(p)) {
            players.remove(p);
            p.removeCompetition(this);
        }
    }
    //EFFECTS: Adds a App.player's playerDataAnalysis information to a competition
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
                String pstr = p.toSaveString();
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
                String pstr = data.toSaveString();
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
                p.printReadOutput(playerPartsOfLine);
                readPlayerDataAnalysisLines(playerDataAnalysisLines, data, i);
                i++;
            }
            if (playerPartsOfLine.contains("Prelim")){
                PrelimPlayer p = new PrelimPlayer();
                PrelimPlayerDataAnalysis data = new PrelimPlayerDataAnalysis(p);
                p.printReadOutput(playerPartsOfLine);
                readPlayerDataAnalysisLines(playerDataAnalysisLines, data, i);
                i++;
            }
            if (playerPartsOfLine.contains("Semi")){
                SemiPlayer p = new SemiPlayer();
                SemiPlayerDataAnalysis data = new SemiPlayerDataAnalysis(p);
                p.printReadOutput(playerPartsOfLine);
                readPlayerDataAnalysisLines(playerDataAnalysisLines, data, i);
                i++;
            }
            if (playerPartsOfLine.contains("Two Minute Final")){
                TwoMinuteFinalPlayer p = new TwoMinuteFinalPlayer();
                TwoMinuteFinalPlayerDataAnalysis data = new TwoMinuteFinalPlayerDataAnalysis(p);
                p.printReadOutput(playerPartsOfLine);
                readPlayerDataAnalysisLines(playerDataAnalysisLines, data, i);
                i++;
            }
            if (playerPartsOfLine.contains("World Final")){
                WorldFinalPlayer p = new WorldFinalPlayer();
                WorldFinalPlayerDataAnalysis data = new WorldFinalPlayerDataAnalysis(p);
                p.printReadOutput(playerPartsOfLine);
                readPlayerDataAnalysisLines(playerDataAnalysisLines, data, i);
                i++;
            }


            }
        }


    //EFFECTS: Reads and prints an individual line of a competiton playerDataAnalysis file based on index
    private void readPlayerDataAnalysisLines(List<String> playerDataAnalysisLines, PlayerDataAnalysis data, Integer i) {
        String playerDataAnalysisLine = playerDataAnalysisLines.get(i);
        ArrayList<String> playerDataAnalysisPartsOfLine = splitOnComma(playerDataAnalysisLine);
        data.printReadOutput(playerDataAnalysisPartsOfLine);
    }

    //TODO Figure out a way to remove the methods below

    @Override
    public void printReadOutput(ArrayList<String> partsOfLine){
        System.out.println("nothing");
    }

    @Override
    public void readOutput(ArrayList<String> partsOfLine) {
        System.out.println("nothing");
    }

    @Override
    public String toSaveString() {
        return null;
    }
}

