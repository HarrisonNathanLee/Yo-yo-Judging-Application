package App.player;

public class PrelimTwoSemiPlayerDataAnalysis extends PlayerDataAnalysis {

    //CONSTRUCTOR
    public PrelimTwoSemiPlayerDataAnalysis(PrelimTwoSemiPlayer p) {
        super(p);
    }

    //EFFECTS: produces the total eval score
    public void produceTotalEvalScore (){
        totalEvalScore += player.getExecution();
        totalEvalScore += player.getBodyControl();
        totalEvalScore += player.getControl();
        totalEvalScore += player.getChoreography();
    }
}
