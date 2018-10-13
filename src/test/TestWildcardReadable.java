package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import player.WildcardPlayer;
import player.WildcardPlayerDataAnalysis;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestWildcardReadable {

    WildcardPlayer player;
    WildcardPlayerDataAnalysis data;

    @BeforeEach
    public void setUp() {
        player = new WildcardPlayer();
        data = new WildcardPlayerDataAnalysis(player);
    }

    @Test
    public void testReadForPlayer() throws IOException {
        player.read("Test_testWildcardPlayer.csv");
        assertEquals(player.getFirstName(), "Test");
        assertEquals(player.getLastName(), "Test");
        assertEquals(player.getDivision(), "1a");
        assertEquals(player.getRoutineType(), "Wildcard");
        assertEquals(player.getPositiveClicks(),5.0);
        assertEquals(player.getClickerScore(), 5.0);
    }

    @Test
    public void testReadForPlayerDataAnalysis() throws IOException {
        data.read("Test_testWildcardPlayerDataAnalysis.csv");
        assertEquals(player.getFirstName(),"Test");
        assertEquals(player.getLastName(), "Test"); //lastName
        assertEquals(data.getCPS(), 0.1);//CPS
    }

}
