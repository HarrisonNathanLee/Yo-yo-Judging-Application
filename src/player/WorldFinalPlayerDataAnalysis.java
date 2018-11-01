
package player;

public class WorldFinalPlayerDataAnalysis extends PlayerDataAnalysis{

    public WorldFinalPlayerDataAnalysis(WorldFinalPlayer p) {
        super(p);
    }

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

