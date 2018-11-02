package App.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import App.player.*;


import static org.junit.jupiter.api.Assertions.assertEquals;

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
        String routineType = "Semi";
        player.setRoutineLength(routineType);
        player.setPositiveClicks(positiveClicks);
        player.produceClickerScore();
        assertEquals(90, player.getClickerScore());
        data.clicksPerSecond();
        assertEquals(1, data.getCPS());
    }
}
