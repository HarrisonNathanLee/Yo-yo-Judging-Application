package App.test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import App.player.PrelimPlayer;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestPlayer {

    PrelimPlayer player;


    @BeforeEach
    public void setUp(){
        player = new PrelimPlayer();
    }

    @Test
    public void testSetExecution(){
        player.setEvaluation(10, "execution");
        assertEquals(10, player.getExecution());
    }

    @Test
    public void testSetControl(){
        player.setEvaluation(10, "control");
        assertEquals(10, player.getControl());
    }

    @Test
    public void testTrickDiversity(){
        player.setEvaluation(10, "trickDiversity");
        assertEquals(10, player.getTrickDiversity());
    }

    @Test
    public void testSetSpaceUseAndEmphasis(){
        player.setEvaluation(10, "spaceUseAndEmphasis");
        assertEquals(10, player.getSpaceUseAndEmphasis());
    }

    @Test
    public void testSetChoreograhpy(){
        player.setEvaluation(10, "choreography");
        assertEquals(10, player.getChoreography());
    }

    @Test
    public void testSetConstruction(){
        player.setEvaluation(10, "construction");
        assertEquals(10, player.getConstruction());
    }

    @Test
    public void testSetBodyControl(){
        player.setEvaluation(10, "bodyControl");
        assertEquals(10, player.getBodyControl());
    }

    @Test
    public void testSetShowmanship(){
        player.setEvaluation(10, "showmanship");
        assertEquals(10, player.getShowmanship());
    }

    @Test
    public void testNoClick(){
        player.produceClickerScore();
        assertEquals(0, player.getPositiveClicks());
        assertEquals(0, player.getNegativeClicks());
        assertEquals(0, player.getClickerScore());
        assertEquals(0, player.getClicksLog().size());
    }

    @Test
    public void testAwardClick(){
        player.awardClick();
        player.produceClickerScore();
        assertEquals(1, player.getPositiveClicks());
        assertEquals(0, player.getNegativeClicks());
        assertEquals(1, player.getClickerScore());
        assertEquals(1, player.getClicksLog().size());
    }

    @Test
    public void testDoubleClick(){
        player.doubleClick();
        player.produceClickerScore();
        assertEquals(2,player.getPositiveClicks());
        assertEquals(0,player.getNegativeClicks());
        assertEquals(2,player.getClickerScore());
        assertEquals(2, player.getClicksLog().size());
    }

    @Test
    public void testRemoveClick() {
        player.removeClick();
        player.produceClickerScore();
        assertEquals(0, player.getPositiveClicks());
        assertEquals(1, player.getNegativeClicks());
        assertEquals(-1, player.getClickerScore());
        assertEquals(1, player.getClicksLog().size());
    }


    @Test
    public void testJustPositiveClicks(){
        player.awardClick();
        player.awardClick();
        player.awardClick();
        player.produceClickerScore();
        assertEquals(3, player.getPositiveClicks());
        assertEquals(0, player.getNegativeClicks());
        assertEquals(3, player.getClickerScore());
        assertEquals(3, player.getClicksLog().size());
    }

    @Test
    public void testJustNegativeClicks(){
        player.removeClick();
        player.removeClick();
        player.removeClick();
        player.produceClickerScore();
        assertEquals(0, player.getPositiveClicks());
        assertEquals(3, player.getNegativeClicks());
        assertEquals(-3, player.getClickerScore());
        assertEquals(3, player.getClicksLog().size());
    }

    @Test
    public void testNetZeroPart1(){
        player.awardClick();
        player.removeClick();
        player.produceClickerScore();
        assertEquals(1, player.getPositiveClicks());
        assertEquals(1, player.getNegativeClicks());
        assertEquals(0, player.getClickerScore());
        assertEquals(2, player.getClicksLog().size());
    }

    @Test
    public void testNetZeroPart2(){
        player.removeClick();
        player.awardClick();
        player.produceClickerScore();
        assertEquals(1, player.getPositiveClicks());
        assertEquals(1, player.getNegativeClicks());
        assertEquals(0, player.getClickerScore());
        assertEquals(2, player.getClicksLog().size());
    }

    //Tests for Major deducts

    @Test
    public void testOneRestart(){
        player.restart();
        player.multiplyRestart();
        assertEquals(1, player.getRestartFinal());
    }

    @Test
    public void testTwoRestart(){
        player.restart();
        player.restart();
        player.multiplyRestart();
        assertEquals(2, player.getRestartFinal());
    }

    @Test
    public void testOneChange(){
        player.change();
        player.multiplyChange();
        assertEquals(3, player.getChangeFinal());
    }

    @Test
    public void testTwoChange(){
        player.change();
        player.change();
        player.multiplyChange();
        assertEquals(6, player.getChangeFinal());
    }

    @Test
    public void testOneDiscard(){
        player.discard();
        player.multiplyDiscard();
        assertEquals(5, player.getDiscardFinal());
    }

    @Test
    public void testTwoDiscard(){
        player.discard();
        player.discard();
        player.multiplyDiscard();
        assertEquals(10, player.getDiscardFinal());
    }

    //Tests for resetting clickers

    @Test
    public void testResetZeroClicks(){
       player.resetClicks();
       player.produceClickerScore();
       assertEquals(0, player.getPositiveClicks());
       assertEquals(0, player.getNegativeClicks());
       assertEquals(0, player.getClickerScore());
    }

    @Test
    public void testResetOnePositiveClick() {
        player.awardClick();
        player.produceClickerScore();
        assertEquals(1, player.getPositiveClicks());
        assertEquals(1, player.getClickerScore());
        player.resetClicks();
        player.produceClickerScore();
        assertEquals(0, player.getPositiveClicks());
        assertEquals(0, player.getClickerScore());

    }
    @Test
    public void testResetOneNegativeClick () {
        player.removeClick();
        player.produceClickerScore();
        assertEquals(1, player.getNegativeClicks());
        assertEquals(-1, player.getClickerScore());
        player.resetClicks();
        player.produceClickerScore();
        assertEquals(0, player.getNegativeClicks());
        assertEquals(0, player.getClickerScore());
    }

    @Test
    public void testResetNetZero() {
        player.awardClick();
        player.removeClick();
        player.produceClickerScore();
        assertEquals(1, player.getPositiveClicks());
        assertEquals(1, player.getNegativeClicks());
        assertEquals(0, player.getClickerScore());
        player.resetClicks();
        player.produceClickerScore();
        assertEquals(0, player.getPositiveClicks());
        assertEquals(0, player.getNegativeClicks());
        assertEquals(0, player.getClickerScore());
    }


    @Test
    public void testResetRandomNetNegative() {
        player.removeClick();
        player.removeClick();
        player.removeClick();
        player.removeClick();
        player.removeClick();
        player.awardClick();
        player.produceClickerScore();
        assertEquals(1, player.getPositiveClicks());
        assertEquals(5, player.getNegativeClicks());
        assertEquals(-4, player.getClickerScore());
        player.resetClicks();
        player.produceClickerScore();
        assertEquals(0, player.getPositiveClicks());
        assertEquals(0, player.getNegativeClicks());
        assertEquals(0, player.getClickerScore());
    }

    //Tests for resetting major deducts

    @Test
    public void testResetZeroDeducts(){
        player.resetMajorDeducts();
        assertEquals(0, player.getNumberOfRestarts());
        assertEquals(0, player.getNumberOfChanges());
        assertEquals(0, player.getNumberOfDiscards());
    }


    @Test
    public void testResetMajors(){
        player.restart();
        player.restart();
        player.discard();
        player.discard();
        player.change();
        player.change();
        assertEquals(2, player.getNumberOfRestarts());
        assertEquals(2, player.getNumberOfChanges());
        assertEquals(2, player.getNumberOfDiscards());
        player.resetMajorDeducts();
        assertEquals(0, player.getNumberOfRestarts());
        assertEquals(0, player.getNumberOfChanges());
        assertEquals(0, player.getNumberOfDiscards());
    }


    @Test
    public void testResetEverything(){
        player.removeClick();
        player.removeClick();
        player.removeClick();
        player.removeClick();
        player.removeClick();
        player.awardClick();
        player.restart();
        player.restart();
        player.discard();
        player.discard();
        player.change();
        player.change();
        player.produceClickerScore();
        assertEquals(1, player.getPositiveClicks());
        assertEquals(5, player.getNegativeClicks());
        assertEquals(-4, player.getClickerScore());
        assertEquals(2, player.getNumberOfRestarts());
        assertEquals(2, player.getNumberOfChanges());
        assertEquals(2, player.getNumberOfDiscards());
        player.resetEverything();
        player.produceClickerScore();
        assertEquals(0, player.getPositiveClicks());
        assertEquals(0, player.getNegativeClicks());
        assertEquals(0, player.getClickerScore());
        assertEquals(0, player.getNumberOfRestarts());
        assertEquals(0, player.getNumberOfChanges());
        assertEquals(0, player.getNumberOfDiscards());
    }



}


