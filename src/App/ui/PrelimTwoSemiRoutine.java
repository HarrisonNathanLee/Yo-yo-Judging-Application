package App.ui;

import App.player.Player;
import App.player.PlayerDataAnalysis;

import java.io.IOException;
import java.util.ArrayList;

public class PrelimTwoSemiRoutine extends Routine{

    //MODIFIES: This
    //EFFECTS: Adds eval parameter questions and eval parameters to lists
    @Override
    public void setUpEvaluationQuestionLists(){
        performanceEvaluationQuestions = new ArrayList<>();
        evaluationKeywords = new ArrayList<>();
        performanceEvaluationQuestions.add("Execution score is: ");
        performanceEvaluationQuestions.add("Control score is: ");
        performanceEvaluationQuestions.add("Music Use 1: Choreography score is: ");
        performanceEvaluationQuestions.add("Body Control score is: ");

        evaluationKeywords.add("execution");
        evaluationKeywords.add("control");
        evaluationKeywords.add("choreography");
        evaluationKeywords.add("bodyControl");
    }


}
