package App.Model;

import App.player.Player;
import App.player.PlayerDataAnalysis;
import App.ui.PlayerInformation;

public class StateSingleton {
    private static StateSingleton instance;
    private Player player;
    private PlayerDataAnalysis playerDataAnalysis;

    private StateSingleton() {

    }

    public static StateSingleton getInstance() {
        if (instance == null) {
            instance = new StateSingleton();
        }
        return instance;
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
}
