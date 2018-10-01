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

    //Tests for Major deducts

    @Test
    public void testOneRestart(){
        dummyPlayer.restart();
        dummyPlayer.multiplyRestart();
        assertEquals(1, dummyPlayer.getRestartFinal());
    }

    @Test
    public void testTwoRestart(){
        dummyPlayer.restart();
        dummyPlayer.restart();
        dummyPlayer.multiplyRestart();
        assertEquals(2, dummyPlayer.getRestartFinal());
    }

    @Test
    public void testOneChange(){
        dummyPlayer.change();
        dummyPlayer.multiplyChange();
        assertEquals(3, dummyPlayer.getChangeFinal());
    }

    @Test
    public void testTwoChange(){
        dummyPlayer.change();
        dummyPlayer.change();
        dummyPlayer.multiplyChange();
        assertEquals(6, dummyPlayer.getChangeFinal());
    }

    @Test
    public void testOneDiscard(){
        dummyPlayer.discard();
        dummyPlayer.multiplyDiscard();
        assertEquals(5, dummyPlayer.getDiscardFinal());
    }

    @Test
    public void testTwoDiscard(){
        dummyPlayer.discard();
        dummyPlayer.discard();
        dummyPlayer.multiplyDiscard();
        assertEquals(10, dummyPlayer.getDiscardFinal());
    }

    //Tests for resetting clickers

    @Test
    public void testResetZeroClicks(){
       dummyPlayer.resetClicks();
       dummyPlayer.produceClickerScore();
       assertEquals(0, dummyPlayer.getPositiveClicks());
       assertEquals(0, dummyPlayer.getNegativeClicks());
       assertEquals(0,dummyPlayer.getClickerScore());
    }

    @Test
    public void testResetOnePositiveClick() {
        dummyPlayer.awardClick();
        dummyPlayer.produceClickerScore();
        assertEquals(1, dummyPlayer.getPositiveClicks());
        assertEquals(1, dummyPlayer.getClickerScore());
        dummyPlayer.resetClicks();
        dummyPlayer.produceClickerScore();
        assertEquals(0, dummyPlayer.getPositiveClicks());
        assertEquals(0, dummyPlayer.getClickerScore());

    }
    @Test
    public void testResetOneNegativeClick () {
        dummyPlayer.removeClick();
        dummyPlayer.produceClickerScore();
        assertEquals(1, dummyPlayer.getNegativeClicks());
        assertEquals(-1, dummyPlayer.getClickerScore());
        dummyPlayer.resetClicks();
        dummyPlayer.produceClickerScore();
        assertEquals(0, dummyPlayer.getNegativeClicks());
        assertEquals(0, dummyPlayer.getClickerScore());
    }

    @Test
    public void testResetNetZero() {
        dummyPlayer.awardClick();
        dummyPlayer.removeClick();
        dummyPlayer.produceClickerScore();
        assertEquals(1, dummyPlayer.getPositiveClicks());
        assertEquals(1, dummyPlayer.getNegativeClicks());
        assertEquals(0, dummyPlayer.getClickerScore());
        dummyPlayer.resetClicks();
        dummyPlayer.produceClickerScore();
        assertEquals(0, dummyPlayer.getPositiveClicks());
        assertEquals(0, dummyPlayer.getNegativeClicks());
        assertEquals(0, dummyPlayer.getClickerScore());
    }


    @Test
    public void testResetRandomNetNegative() {
        dummyPlayer.removeClick();
        dummyPlayer.removeClick();
        dummyPlayer.removeClick();
        dummyPlayer.removeClick();
        dummyPlayer.removeClick();
        dummyPlayer.awardClick();
        dummyPlayer.produceClickerScore();
        assertEquals(1, dummyPlayer.getPositiveClicks());
        assertEquals(5, dummyPlayer.getNegativeClicks());
        assertEquals(-4, dummyPlayer.getClickerScore());
        dummyPlayer.resetClicks();
        dummyPlayer.produceClickerScore();
        assertEquals(0, dummyPlayer.getPositiveClicks());
        assertEquals(0, dummyPlayer.getNegativeClicks());
        assertEquals(0, dummyPlayer.getClickerScore());
    }

    //Tests for resetting major deducts

    @Test
    public void testResetZeroDeducts(){
        dummyPlayer.resetMajorDeducts();
        assertEquals(0, dummyPlayer.getNumberOfRestarts());
        assertEquals(0,dummyPlayer.getNumberOfChanges());
        assertEquals(0,dummyPlayer.getNumberOfDiscards());
    }
    @Test
    public void testResetMajors(){
        dummyPlayer.restart();
        dummyPlayer.restart();
        dummyPlayer.discard();
        dummyPlayer.discard();
        dummyPlayer.change();
        dummyPlayer.change();
        assertEquals(2,dummyPlayer.getNumberOfRestarts());
        assertEquals(2,dummyPlayer.getNumberOfChanges());
        assertEquals(2,dummyPlayer.getNumberOfDiscards());
        dummyPlayer.resetMajorDeducts();
        assertEquals(0,dummyPlayer.getNumberOfRestarts());
        assertEquals(0,dummyPlayer.getNumberOfChanges());
        assertEquals(0,dummyPlayer.getNumberOfDiscards());
    }



}


