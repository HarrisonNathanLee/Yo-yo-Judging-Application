package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import player.PrelimPlayer;
import player.PrelimPlayerDataAnalysis;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPlayerDataAnalysis {

    PrelimPlayer player;
    PrelimPlayerDataAnalysis data;

    @BeforeEach
    public void setUp() {
        player = new PrelimPlayer();
        data = new PrelimPlayerDataAnalysis(player);
    }

    //Tests for clicksOnTilt and ClicksOnFire

    @Test
    public void testNoClick(){
        data.clicksOnFire();
        data.clicksOnTilt();
        assertEquals(0, data.getNumberOfFireSectionsInRoutine());
        assertEquals(0, data.getNumberOfTiltedSectionsInRoutine());
    }

    @Test
    public void testNoFireNoTilt(){
        player.awardClick();
        player.removeClick();
        data.clicksOnFire();
        data.clicksOnTilt();
        assertEquals(0, data.getNumberOfFireSectionsInRoutine());
        assertEquals(0, data.getNumberOfTiltedSectionsInRoutine());
    }

    @Test
    public void testAlternatingClicks(){
        for(int i = 0; i < 10; i++) {
            player.awardClick();
            player.removeClick();
        }
        data.clicksOnFire();
        data.clicksOnTilt();
        assertEquals(0, data.getNumberOfFireSectionsInRoutine());
        assertEquals(0, data.getNumberOfTiltedSectionsInRoutine());
    }


    @Test
    public void testAlmostOnFire(){
        for(int i = 0; i < 9; i++) {
            player.awardClick();
        }
        player.removeClick();
        data.clicksOnFire();
        assertEquals(0, data.getNumberOfFireSectionsInRoutine());
    }

    @Test
    public void testAlmostOnTilt(){
        for(int i = 0; i < 9; i++) {
            player.removeClick();
        }
        player.awardClick();
        data.clicksOnTilt();
        assertEquals(0, data.getNumberOfTiltedSectionsInRoutine());
    }

    @Test
    public void testReachedNecessaryClicksToBeOnFireOnce(){
        for(int i = 0; i < 10; i++) {
            player.awardClick();
        }
        data.clicksOnFire();
        assertEquals(1, data.getNumberOfFireSectionsInRoutine());
    }

    @Test
    public void testLostEnoughClicksToBeOnTiltOnce(){
        for(int i = 0; i < 10; i++) {
            player.removeClick();
        }
        data.clicksOnTilt();
        assertEquals(1, data.getNumberOfTiltedSectionsInRoutine());
    }

    @Test
    public void testFireOnceTiltOnce(){
        for(int i = 0; i < 10; i++) {
            player.removeClick();
        }
        for(int i = 0; i < 10; i++){
            player.awardClick();
        }
        data.clicksOnFire();
        data.clicksOnTilt();
        assertEquals(1, data.getNumberOfFireSectionsInRoutine());
        assertEquals(1, data.getNumberOfTiltedSectionsInRoutine());
    }


    @Test
    public void testReachedNecessaryClicksToBeOnFireTwice(){
        for(int i = 0; i < 20; i++) {
            player.awardClick();
        }
        data.clicksOnFire();
        assertEquals(2, data.getNumberOfFireSectionsInRoutine());
    }

    @Test
    public void testLostEnoughClicksToBeOnTiltTwice(){
        for(int i = 0; i < 20; i++) {
            player.removeClick();
        }
        data.clicksOnTilt();
        assertEquals(2, data.getNumberOfTiltedSectionsInRoutine());

    }

    @Test
    public void testAlmostReachedNecessaryClicksToBeOnFireTwice(){
        for(int i = 0; i < 19; i++) {
            player.awardClick();
        }
        data.clicksOnFire();
        assertEquals(1, data.getNumberOfFireSectionsInRoutine());
    }

    @Test
    public void testAlmostLostEnoughClicksToBeOnTiltTwice(){
        for(int i = 0; i < 19; i++) {
            player.removeClick();
        }
        data.clicksOnTilt();
        assertEquals(1, data.getNumberOfTiltedSectionsInRoutine());
    }

    @Test
    public void testAlmostFireAlmostTilt(){
        for(int i = 0; i <9; i++){
            player.awardClick();;
        }
        player.removeClick();
        player.awardClick();
        for(int i = 0; i<9; i++){
            player.removeClick();
        }
        player.awardClick();
        data.clicksOnFire();
        data.clicksOnTilt();
        assertEquals(0,data.getNumberOfFireSectionsInRoutine());
        assertEquals(0,data.getNumberOfTiltedSectionsInRoutine());
    }

    //Tests for resetting fire and tilt sections in routine count

    @Test
    public void testResetZeroFireTilt(){
        data.resetFireTilt();
        data.clicksOnFire();
        data.clicksOnTilt();
        assertEquals(0,data.getNumberOfFireSectionsInRoutine());
        assertEquals(0,data.getNumberOfTiltedSectionsInRoutine());
    }

    @Test
    public void testResetFireTilt(){
        for(int i = 0; i < 10; i++) {
            player.removeClick();
        }
        for(int i = 0; i < 10; i++){
            player.awardClick();
        }

        data.clicksOnFire();
        data.clicksOnTilt();
        assertEquals(1,data.getNumberOfFireSectionsInRoutine());
        assertEquals(1,data.getNumberOfTiltedSectionsInRoutine());
        data.resetFireTilt();
        assertEquals(0, player.getClicksLog().size());
        data.clicksOnFire();
        data.clicksOnTilt();
        assertEquals(0,data.getNumberOfFireSectionsInRoutine());
        assertEquals(0,data.getNumberOfTiltedSectionsInRoutine());

    }

    @Test
    public void testCPS(){
        int positiveClicks = 100;
        int negativeClicks = 10;
        player.setRoutineLength("Semi");
        player.setPositiveClicks(positiveClicks);
        player.setNegativeClicks(negativeClicks);
        player.produceClickerScore();
        assertEquals(90, player.getClickerScore());
        data.clicksPerSecond();
        assertEquals(1, data.getCPS());
    }


    //TODO: Create tests for clickRatio method

    @Test
    public void testNoClicksCR(){
        int positiveClicks = 0;
        int negativeClicks = 0;
        player.setPositiveClicks(positiveClicks);
        player.setNegativeClicks(negativeClicks);
        player.produceClickerScore();
        data.clickRatio();
        assertEquals(0,data.getCR());
    }

    @Test
    public void testJustPositiveCR(){
        int positiveClicks = 10;
        int negativeClicks = 0;
        player.setPositiveClicks(positiveClicks);
        player.setNegativeClicks(negativeClicks);
        player.produceClickerScore();
        data.clickRatio();
        assertEquals(0,data.getCR());
    }


    @Test
    public void testJustNegativeCR(){
        int positiveClicks = 0;
        int negativeClicks = 10;
        player.setPositiveClicks(positiveClicks);
        player.setNegativeClicks(negativeClicks);
        player.produceClickerScore();
        data.clickRatio();
        assertEquals(0,data.getCR());
    }

    @Test
    public void testSamePositiveNegativeCR(){
        int positiveClicks = 10;
        int negativeClicks = 10;
        player.setPositiveClicks(positiveClicks);
        player.setNegativeClicks(negativeClicks);
        player.produceClickerScore();
        data.clickRatio();
        assertEquals(1,data.getCR());
    }

    @Test
    public void testMoreNegativePositiveCR(){
        int positiveClicks = 5;
        int negativeClicks = 10;
        player.setPositiveClicks(positiveClicks);
        player.setNegativeClicks(negativeClicks);
        player.produceClickerScore();
        data.clickRatio();
        assertEquals(2,data.getCR());
    }


    @Test
    public void testMorePositiveNegativeCR(){
        int positiveClicks = 10;
        int negativeClicks = 5;
        player.setPositiveClicks(positiveClicks);
        player.setNegativeClicks(negativeClicks);
        player.produceClickerScore();
        data.clickRatio();
        assertEquals(0.5,data.getCR());
    }


    //TODO: write tests for clicks if perfect

    @Test
    public void testZeroClicksIfPerfect(){
        player.produceClickerScore();
        data.clicksIfPerfect();
        assertEquals(0, data.getNumberIfPerfect());
    }


    @Test
    public void testPositiveIfPerfect(){
        int positiveClicks = 1;
        player.setPositiveClicks(positiveClicks);
        data.clicksIfPerfect();
        assertEquals(1, data.getNumberIfPerfect());
    }

    @Test
    public void testNegativeIfPerfect(){
        int negativeClicks = 1;
        player.setNegativeClicks(negativeClicks);
        data.clicksIfPerfect();
        assertEquals(2, data.getNumberIfPerfect());
    }


    @Test
    public void testRandomIfPerfect(){
        int positiveClicks = 1;
        int negativeClicks = 1;
        player.setPositiveClicks(positiveClicks);
        player.setNegativeClicks(negativeClicks);
        data.clicksIfPerfect();
        assertEquals(3, data.getNumberIfPerfect());
    }

    @Test
    public void testCIPPS(){
        int positiveClicks = 10;
        int negativeClicks = 10;
        player.setPositiveClicks(positiveClicks);
        player.setNegativeClicks(negativeClicks);
        player.setRoutineLength("Prelim");
        player.produceClickerScore();
        data.clicksIfPerfect();
        assertEquals(30, data.getNumberIfPerfect());
        data.clicksIfPerfectPerSecond();
        assertEquals(0.5, data.getCIPPS());

    }



}


/*
    @Test
    public void testIntervalCreation(){

    }

    @Test
    public void testNoClicksPerSecond(){ //As clickerScore is zero

    }
*/