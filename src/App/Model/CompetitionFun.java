package App.Model;


import java.util.ArrayList;

public class CompetitionFun extends Subject {
    private String competitionName;
    private ArrayList<PlayerFun> players = new ArrayList<>();

    public CompetitionFun(String competitionName){
        this.competitionName = competitionName;
        observers = new ArrayList<>();
    }

    public void addPlayer(PlayerFun p){
        players.add(p);
        if (players.size() >1){
            notifyObserver(p);
        }
    }

    public static void main(String[] args) {
        PlayerFun harrison = new PlayerFun("Harrison");
        PlayerFun allison = new PlayerFun("Allison");
        PlayerFun harry = new PlayerFun("Harry");
        PlayerFun elaine = new PlayerFun("Elaine");
        CompetitionFun familyComp = new CompetitionFun("Family Feud");
        familyComp.addObserver(harrison);
        familyComp.addObserver(allison);
        familyComp.addObserver(harry);
        familyComp.addObserver(elaine);
        familyComp.addPlayer(harrison);
        familyComp.addPlayer(allison);
        familyComp.addPlayer(harry);
        familyComp.addPlayer(elaine);


    }
}
