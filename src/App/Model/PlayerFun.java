package App.Model;

import App.player.Player;

public class PlayerFun implements Observer {

    private String name;

    public PlayerFun(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    @Override
    public void update(PlayerFun p) {
        System.out.println(getName() + ": I have another competitor!");
    }
}
