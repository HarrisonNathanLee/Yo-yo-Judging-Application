package App.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import App.player.WildcardPlayer;
import App.player.WildcardPlayerDataAnalysis;

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
        assertEquals("Test",player.getFirstName());
        assertEquals("Test",player.getLastName());
        assertEquals("1a",player.getDivision());
        assertEquals("Wildcard",player.getRoutineType());
        assertEquals(5.0,player.getPositiveClicks());
        assertEquals(5.0,player.getClickerScore());
    }

    @Test
    public void testReadForPlayerDataAnalysis() throws IOException {
        data.read("Test_testWildcardPlayerDataAnalysis.csv");
        assertEquals("Test",player.getFirstName());
        assertEquals("Test", player.getLastName()); //lastName
        assertEquals(0.5,data.getCPS());//CPS
    }

}
