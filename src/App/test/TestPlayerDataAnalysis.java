package App.test;

import App.Exceptions.DataCalculationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import App.player.PrelimTwoSemiPlayer;
import App.player.PrelimTwoSemiPlayerDataAnalysis;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TestPlayerDataAnalysis {

    PrelimTwoSemiPlayer player;
    PrelimTwoSemiPlayerDataAnalysis data;
    int TILTED;
    int FIRE;
    String POSITIVE;
    String NEGATIVE;

    @BeforeEach
    public void setUp() {
        player = new PrelimTwoSemiPlayer();
        data = new PrelimTwoSemiPlayerDataAnalysis(player);
        POSITIVE = "positive";
        NEGATIVE = "negative";
        TILTED = 10;
        FIRE = 10;


    }

    //Tests for clicksOnTilt and ClicksOnFire

    @Test
    public void testNoClick(){
        data.setNumberOfFireSectionsInRoutine(data.clicksOnFireOrTilt(POSITIVE,NEGATIVE,FIRE));
        data.setNumberOfTiltedSectionsInRoutine(data.clicksOnFireOrTilt(NEGATIVE,POSITIVE,TILTED));
        assertEquals(0, data.getNumberOfFireSectionsInRoutine());
        assertEquals(0, data.getNumberOfTiltedSectionsInRoutine());
    }

    @Test
    public void testNoFireNoTilt(){
        player.awardClick();
        player.removeClick();
        data.setNumberOfFireSectionsInRoutine(data.clicksOnFireOrTilt(POSITIVE,NEGATIVE,FIRE));
        data.setNumberOfTiltedSectionsInRoutine(data.clicksOnFireOrTilt(NEGATIVE,POSITIVE,TILTED));
        assertEquals(0, data.getNumberOfFireSectionsInRoutine());
        assertEquals(0, data.getNumberOfTiltedSectionsInRoutine());
    }

    @Test
    public void testAlternatingClicks(){
        for(int i = 0; i < 10; i++) {
            player.awardClick();
            player.removeClick();
        }
        data.setNumberOfFireSectionsInRoutine(data.clicksOnFireOrTilt(POSITIVE,NEGATIVE,FIRE));
        data.setNumberOfTiltedSectionsInRoutine(data.clicksOnFireOrTilt(NEGATIVE,POSITIVE,TILTED));
        assertEquals(0, data.getNumberOfFireSectionsInRoutine());
        assertEquals(0, data.getNumberOfTiltedSectionsInRoutine());
    }


    @Test
    public void testAlmostOnFire(){
        for(int i = 0; i < 9; i++) {
            player.awardClick();
        }
        player.removeClick();
        data.setNumberOfFireSectionsInRoutine(data.clicksOnFireOrTilt(POSITIVE,NEGATIVE,FIRE));
        assertEquals(0, data.getNumberOfFireSectionsInRoutine());
    }

    @Test
    public void testAlmostOnTilt(){
        for(int i = 0; i < 9; i++) {
            player.removeClick();
        }
        player.awardClick();
        data.setNumberOfTiltedSectionsInRoutine(data.clicksOnFireOrTilt(NEGATIVE,POSITIVE,TILTED));
        assertEquals(0, data.getNumberOfTiltedSectionsInRoutine());
    }

    @Test
    public void testReachedNecessaryClicksToBeOnFireOnce(){
        for(int i = 0; i < 10; i++) {
            player.awardClick();
        }
        data.setNumberOfFireSectionsInRoutine(data.clicksOnFireOrTilt(POSITIVE,NEGATIVE,FIRE));
        assertEquals(1, data.getNumberOfFireSectionsInRoutine());
    }

    @Test
    public void testLostEnoughClicksToBeOnTiltOnce(){
        for(int i = 0; i < 10; i++) {
            player.removeClick();
        }
        data.setNumberOfTiltedSectionsInRoutine(data.clicksOnFireOrTilt(NEGATIVE,POSITIVE,TILTED));
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
        data.setNumberOfFireSectionsInRoutine(data.clicksOnFireOrTilt(POSITIVE,NEGATIVE,FIRE));
        data.setNumberOfTiltedSectionsInRoutine(data.clicksOnFireOrTilt(NEGATIVE,POSITIVE,TILTED));
        assertEquals(1, data.getNumberOfFireSectionsInRoutine());
        assertEquals(1, data.getNumberOfTiltedSectionsInRoutine());
    }


    @Test
    public void testReachedNecessaryClicksToBeOnFireTwice(){
        for(int i = 0; i < 20; i++) {
            player.awardClick();
        }
        data.setNumberOfFireSectionsInRoutine(data.clicksOnFireOrTilt(POSITIVE,NEGATIVE,FIRE));
        assertEquals(2, data.getNumberOfFireSectionsInRoutine());
    }

    @Test
    public void testLostEnoughClicksToBeOnTiltTwice(){
        for(int i = 0; i < 20; i++) {
            player.removeClick();
        }
        data.setNumberOfTiltedSectionsInRoutine(data.clicksOnFireOrTilt(NEGATIVE,POSITIVE,TILTED));
        assertEquals(2, data.getNumberOfTiltedSectionsInRoutine());

    }

    @Test
    public void testAlmostReachedNecessaryClicksToBeOnFireTwice(){
        for(int i = 0; i < 19; i++) {
            player.awardClick();
        }
        data.setNumberOfFireSectionsInRoutine(data.clicksOnFireOrTilt(POSITIVE,NEGATIVE,FIRE));
        assertEquals(1, data.getNumberOfFireSectionsInRoutine());
    }

    @Test
    public void testAlmostLostEnoughClicksToBeOnTiltTwice(){
        for(int i = 0; i < 19; i++) {
            player.removeClick();
        }
        data.setNumberOfTiltedSectionsInRoutine(data.clicksOnFireOrTilt(NEGATIVE,POSITIVE,TILTED));
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
        data.setNumberOfFireSectionsInRoutine(data.clicksOnFireOrTilt(POSITIVE,NEGATIVE,FIRE));
        data.setNumberOfTiltedSectionsInRoutine(data.clicksOnFireOrTilt(NEGATIVE,POSITIVE,TILTED));
        assertEquals(0,data.getNumberOfFireSectionsInRoutine());
        assertEquals(0,data.getNumberOfTiltedSectionsInRoutine());
    }

    //Tests for resetting fire and tilt sections in routine count

    @Test
    public void testResetZeroFireTilt(){
        data.resetFireTilt();
        data.setNumberOfFireSectionsInRoutine(data.clicksOnFireOrTilt(POSITIVE,NEGATIVE,FIRE));
        data.setNumberOfTiltedSectionsInRoutine(data.clicksOnFireOrTilt(NEGATIVE,POSITIVE,TILTED));
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

        data.setNumberOfFireSectionsInRoutine(data.clicksOnFireOrTilt(POSITIVE,NEGATIVE,FIRE));
        data.setNumberOfTiltedSectionsInRoutine(data.clicksOnFireOrTilt(NEGATIVE,POSITIVE,TILTED));
        assertEquals(1,data.getNumberOfFireSectionsInRoutine());
        assertEquals(1,data.getNumberOfTiltedSectionsInRoutine());
        data.resetFireTilt();
        assertEquals(0, player.getClicksLog().size());
        data.setNumberOfFireSectionsInRoutine(data.clicksOnFireOrTilt(POSITIVE,NEGATIVE,FIRE));
        data.setNumberOfTiltedSectionsInRoutine(data.clicksOnFireOrTilt(NEGATIVE,POSITIVE,TILTED));
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


    @Test
    public void testNoClicksCR() throws DataCalculationException {
        int positiveClicks = 0;
        int negativeClicks = 0;
        player.setPositiveClicks(positiveClicks);
        player.setNegativeClicks(negativeClicks);
        player.produceClickerScore();
        data.clickRatio();
        assertEquals(0,data.getCR());
    }

    @Test
    public void testJustPositiveCR() throws DataCalculationException {
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
        try {
            data.clickRatio();
            fail("I was not expecting to reach this line of code!");
        } catch (DataCalculationException e) {
            System.out.println("Player just had negative clicks");
        }
        assertEquals(0,data.getCR());
    }

    @Test
    public void testSamePositiveNegativeCR() {
        int positiveClicks = 10;
        int negativeClicks = 10;
        player.setPositiveClicks(positiveClicks);
        player.setNegativeClicks(negativeClicks);
        player.produceClickerScore();
        try {
            data.clickRatio();
        } catch (DataCalculationException e) {
            fail("I was not expecting to catch a DataCalculationException");
        }
        assertEquals(1,data.getCR());
    }

    @Test
    public void testMoreNegativePositiveCR() {
        int positiveClicks = 5;
        int negativeClicks = 10;
        player.setPositiveClicks(positiveClicks);
        player.setNegativeClicks(negativeClicks);
        player.produceClickerScore();
        try {
            data.clickRatio();
        } catch (DataCalculationException e) {
            fail("I was not expecting to catch a DataCalculationException");
        }
        assertEquals(2,data.getCR());
    }


    @Test
    public void testMorePositiveNegativeCR() {
        int positiveClicks = 10;
        int negativeClicks = 5;
        player.setPositiveClicks(positiveClicks);
        player.setNegativeClicks(negativeClicks);
        player.produceClickerScore();
        try {
            data.clickRatio();
        } catch (DataCalculationException e) {
            fail("I was not expecting to catch a DataCalculationException");
        }
        assertEquals(0.5,data.getCR());
    }


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

