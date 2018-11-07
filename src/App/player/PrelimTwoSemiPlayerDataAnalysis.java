package App.player;

public class PrelimTwoSemiPlayerDataAnalysis extends PlayerDataAnalysis {

    public PrelimTwoSemiPlayerDataAnalysis(PrelimTwoSemiPlayer p) {
        super(p);
    }

    public void produceTotalEvalScore (){
        totalEvalScore += player.getExecution();
        totalEvalScore += player.getBodyControl();
        totalEvalScore += player.getControl();
        totalEvalScore += player.getChoreography();
    }
}
