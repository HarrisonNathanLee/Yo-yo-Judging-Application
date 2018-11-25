package App.Model;

import App.Competition.Competition;
import App.Competition.CompetitionDataAnalysis;
import App.player.Player;
import App.player.PlayerDataAnalysis;
import App.ui.PlayerInformation;

public class StateSingleton {
    private static StateSingleton instance;
    private Player player;
    private PlayerDataAnalysis playerDataAnalysis;
    private Competition competition;
    private CompetitionDataAnalysis competitionDataAnalysis;
    private Boolean mode; // <- 1 for competition, 0 for individual

    private StateSingleton() {
    }

    public static StateSingleton getInstance() {
        if (instance == null) {
            instance = new StateSingleton();
        }
        return instance;
    }


    public CompetitionDataAnalysis getCompetitionDataAnalysis() {
        return competitionDataAnalysis;
    }

    public void setCompetitionDataAnalysis(CompetitionDataAnalysis competitionDataAnalysis) {
        this.competitionDataAnalysis = competitionDataAnalysis;
    }

    public void setMode (Boolean mode){this.mode = mode;}

    public Boolean getMode(){ return mode;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setPlayerDataAnalysis(PlayerDataAnalysis playerDataAnalysis) {
        this.playerDataAnalysis = playerDataAnalysis;
    }

    public Player getPlayer() {
        return player;
    }

    public PlayerDataAnalysis getPlayerDataAnalysis() {
        return playerDataAnalysis;
    }

    public void setCompetition(Competition competition) { this.competition = competition;}

    public Competition getCompetition() {return competition;}
}
