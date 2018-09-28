package player;

public class PlayerDataAnalysis {

    private static final int TILTED = 10; //an arbitrary number for now
    private static final int FIRE = 10; //an arbitrary number for now

    private Player player;

    public PlayerDataAnalysis(Player player) {
        this.player = player;
    }

    //EFFECTS: Will count the number of FIRE(judge has awarded multiple clicks in a row) sections in a routine
    public int clicksOnFire(){
        int numberOfPositiveInRow = 0;
        int numberOfFireSectionsInRoutine = 0;
        for (String click: player.clicksLog){
            if (click.equals("positive")){
                numberOfPositiveInRow++;
            }
            else if(click.equals("negative")){
                numberOfPositiveInRow = 0;
            }
            if (numberOfPositiveInRow == FIRE){
                numberOfFireSectionsInRoutine++;
                numberOfPositiveInRow = 0;
            }
        }
        return numberOfFireSectionsInRoutine;
    }

    //EFFECTS: Will count the number of TILTED(judge has deducted multiple clicks in a row) sections in a routine
    public int clicksOnTilt(){
        int numberOfNegativeInRow = 0;
        int numberOfTiltedSectionsInRoutine = 0;
        for (String click: player.clicksLog){
            if (click.equals("negative")){
                numberOfNegativeInRow++;
            }
            else if (click.equals("positive")){
                numberOfNegativeInRow = 0;
            }

            if (numberOfNegativeInRow == TILTED){
                numberOfTiltedSectionsInRoutine++;
                numberOfNegativeInRow = 0;
            }
        }
        return numberOfTiltedSectionsInRoutine;
    }
}


//TODO: Implement when I have a UI and can get timer functionality working
    /*

    //REQUIRES:
    //MODIFIES: this
    //EFFECTS: Creates intervals of time depending on how long the routine is
    public void createIntervals(){
        return true;
    }

    //REQUIRES:
    //MODIFIES:
    //EFFECTS: Will return the number of clicks per the number of intervals in a routine
    public void clicksPerInterval(){
        return true;
    }

    //REQUIRES:
    //MODIFIES:
    //EFFECTS: Will return the number of clicks per second of a routine
    public void clicksPerSecond(){
        return true;
    }
    */