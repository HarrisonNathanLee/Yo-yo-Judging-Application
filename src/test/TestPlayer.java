package test.tests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import player.Player;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestPlayer {

    Player dummyPlayer;

    @BeforeEach
    public void setUp(){
        dummyPlayer = new Player();
    }

    @Test
    public void testNoClick(){
        dummyPlayer.produceClickerScore();
        assertEquals(0, dummyPlayer.getPositiveClicks());
        assertEquals(0, dummyPlayer.getNegativeClicks());
        assertEquals(0, dummyPlayer.getClickerScore());
        assertEquals(0, dummyPlayer.getClicksLog().size());
    }

    @Test
    public void testAwardClick(){
        dummyPlayer.awardClick();
        dummyPlayer.produceClickerScore();
        assertEquals(1, dummyPlayer.getPositiveClicks());
        assertEquals(0, dummyPlayer.getNegativeClicks());
        assertEquals(1,dummyPlayer.getClickerScore());
        assertEquals(1, dummyPlayer.getClicksLog().size());
    }

    @Test
    public void testRemoveClick() {
        dummyPlayer.removeClick();
        dummyPlayer.produceClickerScore();
        assertEquals(0, dummyPlayer.getPositiveClicks());
        assertEquals(1, dummyPlayer.getNegativeClicks());
        assertEquals(-1,dummyPlayer.getClickerScore());
        assertEquals(1, dummyPlayer.getClicksLog().size());
    }



    @Test
    public void testJustPositiveClicks(){
        dummyPlayer.awardClick();
        dummyPlayer.awardClick();
        dummyPlayer.awardClick();
        dummyPlayer.produceClickerScore();
        assertEquals(3,dummyPlayer.getPositiveClicks());
        assertEquals(0,dummyPlayer.getNegativeClicks());
        assertEquals(3,dummyPlayer.getClickerScore());
        assertEquals(3, dummyPlayer.getClicksLog().size());
    }

    @Test
    public void testJustNegativeClicks(){
        dummyPlayer.removeClick();
        dummyPlayer.removeClick();
        dummyPlayer.removeClick();
        dummyPlayer.produceClickerScore();
        assertEquals(0,dummyPlayer.getPositiveClicks());
        assertEquals(3,dummyPlayer.getNegativeClicks());
        assertEquals(-3,dummyPlayer.getClickerScore());
        assertEquals(3,dummyPlayer.getClicksLog().size());
    }

    @Test
    public void testNetZeroPart1(){
        dummyPlayer.awardClick();
        dummyPlayer.removeClick();
        dummyPlayer.produceClickerScore();
        assertEquals(1,dummyPlayer.getPositiveClicks());
        assertEquals(1,dummyPlayer.getNegativeClicks());
        assertEquals(0,dummyPlayer.getClickerScore());
        assertEquals(2,dummyPlayer.getClicksLog().size());
    }

    @Test
    public void testNetZeroPart2(){
        dummyPlayer.removeClick();
        dummyPlayer.awardClick();
        dummyPlayer.produceClickerScore();
        assertEquals(1,dummyPlayer.getPositiveClicks());
        assertEquals(1,dummyPlayer.getNegativeClicks());
        assertEquals(0,dummyPlayer.getClickerScore());
        assertEquals(2,dummyPlayer.getClicksLog().size());
    }
}

/*
    @Test
    public void testStopImmediatelyZeroClicks(){
        int routineLength = 30;
        dummyPlayer.clicker();
        String keyPress = "stop";
        keyPress.equals("stop");
        assertEquals(dummyPlayer.clickerScore == 0);

    }

    @Test
    public void testPositiveClicksOnly(){
        Player dummyPlayer = new Player();
        int routineLength = 30;
        dummyPlayer.clicker();
        String keyPress = "j";
        keyPress.equals("j");
        // have a positive value for clicker score
        assertEquals(dummyPlayer.clickerScore == 1);

    }

    @Test
    public void testNegativeClicksOnly(){
        Player dummyPlayer = new Player();
        int routineLength = 30;
        dummyPlayer.clicker();
        String keyPress = "f";
        keyPress.equals("f");
        // have a negative value for clicker score
        assertEquals(dummyPlayer.clickerScore == -1);
    }


    @Test
    public void testZeroClick(){
        Player dummyPlayer = new Player();
        int routineLength = 30;
        dummyPlayer.clicker();
        // will subtract positive value and negative value and return a value of zero for clicker score
        assertEquals(dummyPlayer.clickerScore ==0);
    }

*/
