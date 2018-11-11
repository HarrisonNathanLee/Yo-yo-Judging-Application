
package App.player;

public class WorldFinalPlayerDataAnalysis extends PlayerDataAnalysis{

    //CONSTRUCTOR
    public WorldFinalPlayerDataAnalysis(WorldFinalPlayer p) {
        super(p);
    }

    //EFFECTS: produces the total eval score of the player
    public void produceTotalEvalScore (){
        totalEvalScore += player.getExecution();
        totalEvalScore += player.getBodyControl();
        totalEvalScore += player.getShowmanship();
        totalEvalScore += player.getControl();
        totalEvalScore += player.getSpaceUseAndEmphasis();
        totalEvalScore += player.getChoreography();
        totalEvalScore += player.getTrickDiversity();
        totalEvalScore += player.getConstruction();
    }
}

