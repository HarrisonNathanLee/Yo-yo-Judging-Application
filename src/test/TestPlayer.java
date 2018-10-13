package test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import player.PrelimPlayer;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestPlayer {

    PrelimPlayer player;

    @BeforeEach
    public void setUp(){
        player = new PrelimPlayer();
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



}


