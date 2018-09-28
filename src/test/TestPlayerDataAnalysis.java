package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import player.Player;
import player.PlayerDataAnalysis;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestPlayerDataAnalysis {

    Player player;
    PlayerDataAnalysis data;

    @BeforeEach
    public void setUp() {
        player = new Player();
        data = new PlayerDataAnalysis(player);
    }

    @Test
    public void testNoClick(){
        assertEquals(0, data.clicksOnFire());
        assertEquals(0, data.clicksOnTilt());
    }

    @Test
    public void testNoFireNoTilt(){
        player.awardClick();
        player.removeClick();
        assertEquals(0, data.clicksOnFire());
        assertEquals(0, data.clicksOnTilt());
    }

    @Test
    public void testAlternatingClicks(){
        for(int i = 0; i < 10; i++) {
            player.awardClick();
            player.removeClick();
        }
        assertEquals(0, data.clicksOnFire());
        assertEquals(0, data.clicksOnTilt());
    }


    @Test
    public void testAlmostOnFire(){
        for(int i = 0; i < 9; i++) {
            player.awardClick();
        }
        player.removeClick();
        assertEquals(0, data.clicksOnFire());
    }

    @Test
    public void testAlmostOnTilt(){
        for(int i = 0; i < 9; i++) {
            player.removeClick();
        }
        player.awardClick();
        assertEquals(0, data.clicksOnTilt());
    }

    @Test
    public void testReachedNecessaryClicksToBeOnFireOnce(){
        for(int i = 0; i < 10; i++) {
            player.awardClick();
        }
        assertEquals(1, data.clicksOnFire());
    }

    @Test
    public void testLostEnoughClicksToBeOnTiltOnce(){
        for(int i = 0; i < 10; i++) {
            player.removeClick();
        }
        assertEquals(1, data.clicksOnTilt());
    }

    @Test
    public void testFireOnceTiltOnce(){
        for(int i = 0; i < 10; i++) {
            player.removeClick();
        }
        for(int i = 0; i < 10; i++){
            player.awardClick();
        }
        assertEquals(1, data.clicksOnFire());
        assertEquals(1, data.clicksOnTilt());
    }


    @Test
    public void testReachedNecessaryClicksToBeOnFireTwice(){
        for(int i = 0; i < 20; i++) {
            player.awardClick();
        }
        assertEquals(2, data.clicksOnFire());
    }

    @Test
    public void testLostEnoughClicksToBeOnTiltTwice(){
        for(int i = 0; i < 20; i++) {
            player.removeClick();
        }
        assertEquals(2, data.clicksOnTilt());

    }

    @Test
    public void testAlmostReachedNecessaryClicksToBeOnFireTwice(){
        for(int i = 0; i < 19; i++) {
            player.awardClick();
        }
        assertEquals(1, data.clicksOnFire());
    }

    @Test
    public void testAlmostLostEnoughClicksToBeOnTiltTwice(){
        for(int i = 0; i < 19; i++) {
            player.removeClick();
        }
        assertEquals(1, data.clicksOnTilt());
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
        assertEquals(0,data.clicksOnTilt());
        assertEquals(0,data.clicksOnFire());
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