package App.Competition;

import App.player.*;
import App.player.Loadable;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.lang.*;

import static App.Competition.CompetitionDataAnalysis.STRINGBREAK;

public class Competition extends Loadable implements Saveable {
    protected Player player;
    private String competitionName = "";
    private String competitionDivision = "";
    private String competitionRoutineType = "";
    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<PlayerDataAnalysis> dataAnalyses = new ArrayList<>();
    private HashMap<String, Integer> hmap = new HashMap<String, Integer>();

    //MODIFIES: This
    //EFFECTS: Sets the CompetitionInformation of the competition
    public void setCompetitionName(String competitionName) {
        this.competitionName = competitionName;
    }

    //MODIFIES: THis
    //EFFECTS: Sets the return type of the competition
    public void setCompetitionRoutineType(String competitionRoutineType) {
        this.competitionRoutineType = competitionRoutineType;
    }

    public void setCompetitionDivision(String competitionDivision) {
        this.competitionDivision = competitionDivision;
    }

    public String getCompetitionDivision() {
        return competitionDivision;
    }
    //EFFECTS: Returns the return type of the competition
    public String getCompetitionRoutineType() {
        return competitionRoutineType;
    }

    //EFFECTS: Returns the CompetitionInformation of the competition
    public String getCompetitionName() {
        return competitionName;
    }

    //EFFECTS: Returns the players in the competition
    public ArrayList<Player> getPlayers() {
        return players;
    }

    //EFFECTS: Adds a App.player to a competition
    public void addPlayer(Player p){
        players.add(p);
    }

    //EFFECTS: Adds a App.player's playerDataAnalysis information to a competition
    public void addPlayerDataAnalysis(PlayerDataAnalysis data){
        dataAnalyses.add(data);
    }

    private void addPlayersToHMAP(){
        for(PlayerDataAnalysis data: dataAnalyses){
            String firstName = data.getPlayer().getFirstName();
            Double totalWeightedScore = data.getTotalWeightedScore();
            Integer roundedTotalWeightedScore = (int) Math.round(totalWeightedScore);
            hmap.put(firstName,roundedTotalWeightedScore);
        }
    }

    // Taken from https://www.geeksforgeeks.org/sorting-a-hashmap-according-to-values/

    private HashMap<String,Integer> sortByValue (HashMap<String, Integer> hm){
        List<Map.Entry<String,Integer> > list =
                new LinkedList<Map.Entry<String, Integer> > (hm.entrySet());
        Collections.sort(list, new Comparator <Map.Entry<String, Integer>>(){
                public int compare(Map.Entry<String, Integer> o1,
                                      Map.Entry<String, Integer> o2)
                {
                    return (o2.getValue()).compareTo(o1.getValue());
                }
        });
        HashMap<String,Integer> temporary = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa: list){
            temporary.put(aa.getKey(), aa.getValue());
        }
        return temporary;
    }



    public void addSortPrintHMAP(){
        addPlayersToHMAP();
        Map<String, Integer> hmap2 = sortByValue(hmap);
        int i = 1;
        System.out.println(STRINGBREAK);
        System.out.println("Competition Results:");
        for (Map.Entry<String, Integer> en: hmap2.entrySet()){
            System.out.println(i + ": " +en.getKey() + " with a rounded total weighted score of: " + en.getValue());
            i ++;
        }
        System.out.println(STRINGBREAK);
    }

    //EFFECTS: Saves the data for all players in a competition to two CSV files
    public void save(String saveLocation) throws IOException{
        PrintWriter pw1 = new PrintWriter(new FileOutputStream(saveLocation+"Players.csv", true));
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
        PrintWriter pw2 = new PrintWriter(new FileOutputStream(saveLocation+"PlayerDataAnalyses.csv", true));
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
    public void load(String saveLocation) throws IOException {
        List<String> playerLines = Files.readAllLines(Paths.get(saveLocation+"Players.csv"));
        List<String> playerDataAnalysisLines = Files.readAllLines(Paths.get(saveLocation+"PlayerDataAnalyses.csv"));
        int i = 0;
        for (String playerLine : playerLines) {
            ArrayList<String> playerPartsOfLine = splitOnComma(playerLine);
            if (playerPartsOfLine.contains("Wildcard")){
                WildcardPlayer p = new WildcardPlayer();
                WildcardPlayerDataAnalysis data = new WildcardPlayerDataAnalysis(p);
                p.printLoadOutput(playerPartsOfLine);
                readPlayerDataAnalysisLines(playerDataAnalysisLines, data, i);
                i++;
            }
            if (playerPartsOfLine.contains("Prelim") || playerPartsOfLine.contains("Semi") || playerPartsOfLine.contains("Two Minute Final")){
                PrelimTwoSemiPlayer p = new PrelimTwoSemiPlayer();
                PrelimTwoSemiPlayerDataAnalysis data = new PrelimTwoSemiPlayerDataAnalysis(p);
                p.printLoadOutput(playerPartsOfLine);
                readPlayerDataAnalysisLines(playerDataAnalysisLines, data, i);
                i++;
            }
            if (playerPartsOfLine.contains("World Final")){
                WorldFinalPlayer p = new WorldFinalPlayer();
                WorldFinalPlayerDataAnalysis data = new WorldFinalPlayerDataAnalysis(p);
                p.printLoadOutput(playerPartsOfLine);
                readPlayerDataAnalysisLines(playerDataAnalysisLines, data, i);
                i++;
            }
        }
    }

    //EFFECTS: Reads and prints an individual line of a competiton playerDataAnalysis file based on index
    private void readPlayerDataAnalysisLines(List<String> playerDataAnalysisLines, PlayerDataAnalysis data, Integer i) {
        String playerDataAnalysisLine = playerDataAnalysisLines.get(i);
        ArrayList<String> playerDataAnalysisPartsOfLine = splitOnComma(playerDataAnalysisLine);
        data.printLoadOutput(playerDataAnalysisPartsOfLine);
    }

    //TODO Figure out a way to remove the methods below

    @Override
    public void printLoadOutput(ArrayList<String> partsOfLine){
        System.out.println("nothing");
    }

    @Override
    public void loadOutput(ArrayList<String> partsOfLine) {
        System.out.println("nothing");
    }

    @Override
    public String toSaveString() {
        return null;
    }
}

