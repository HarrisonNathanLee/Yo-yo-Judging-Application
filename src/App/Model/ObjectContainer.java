package App.Model;

import App.player.Player;
import App.player.PlayerDataAnalysis;

public abstract class ObjectContainer {
    protected Player p;
    protected PlayerDataAnalysis data;

    public Player getP() {
        return p;
    }

    public void setP(Player p) {
        this.p = p;
    }

    public PlayerDataAnalysis getData() {
        return data;
    }

    public void setData(PlayerDataAnalysis data) {
        this.data = data;
    }



}
