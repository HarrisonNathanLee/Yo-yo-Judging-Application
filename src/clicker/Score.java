package clicker;

public class Score {
    private float clickerScore = 0f;

    public float getScore(){
        return clickerScore;
    }

    public void awardClick() {
        clickerScore++;

    }
    public  void removeClick (){
        clickerScore--;

    }
}
