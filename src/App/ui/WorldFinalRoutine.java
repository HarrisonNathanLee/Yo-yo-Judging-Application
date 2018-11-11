package App.ui;

import java.util.ArrayList;

public class WorldFinalRoutine extends Routine {
    //MODIFIES: This
    //EFFECTS: Adds eval parameter questions and eval parameters to lists
    public void setUpEvaluationQuestionLists(){
        performanceEvaluationQuestions = new ArrayList<>();
        evaluationKeywords = new ArrayList<>();
        performanceEvaluationQuestions.add("Execution score is: ");
        performanceEvaluationQuestions.add("Control score is: ");
        performanceEvaluationQuestions.add("Trick diversity score is: ");
        performanceEvaluationQuestions.add("Space Use & Emphasis score is: ");
        performanceEvaluationQuestions.add("Music Use 1: Choreography score is: ");
        performanceEvaluationQuestions.add("Music Use 2: Construction score is: ");
        performanceEvaluationQuestions.add("Body Control score is: ");
        performanceEvaluationQuestions.add("Showmanship score is: ");

        evaluationKeywords.add("execution");
        evaluationKeywords.add("control");
        evaluationKeywords.add("trickDiversity");
        evaluationKeywords.add("spaceUseAndEmphasis");
        evaluationKeywords.add("choreography");
        evaluationKeywords.add("construction");
        evaluationKeywords.add("bodyControl");
        evaluationKeywords.add("showmanship");
    }
}
