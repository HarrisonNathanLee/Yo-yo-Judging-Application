package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import player.*;

public class TestWildcardPlayerDataAnalysis {

    WildcardPlayer player;
    WildcardPlayerDataAnalysis data;

    @BeforeEach
    public void setUp() {
        player = new WildcardPlayer();
        data = new WildcardPlayerDataAnalysis(player);
    }

    @Test
    public void testCPS(){
        int positiveClicks = 90;
        int routineLength = 90;
        player.setRoutineLength(routineLength);
        player.setPositiveClicks(positiveClicks);
        player.produceClickerScore();
        assertEquals(90, player.getClickerScore());
        data.clicksPerSecond();
        assertEquals(1, data.getCPS());
    }
}
