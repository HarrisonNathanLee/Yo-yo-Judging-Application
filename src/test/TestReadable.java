package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import player.*;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestReadable {

    PrelimPlayer player;
    PrelimPlayerDataAnalysis data;

    @BeforeEach
    public void setUp() {
        player = new PrelimPlayer();
        data = new PrelimPlayerDataAnalysis(player);
    }

    @Test
    public void testReadForPlayer() throws IOException {
        player.read("Test_testPlayer.csv");
        assertEquals("Test",player.getFirstName());
        assertEquals("Test",player.getLastName());
        assertEquals("1a",player.getDivision());
        assertEquals("Prelim",player.getRoutineType());
        assertEquals(5.0,player.getPositiveClicks());
        assertEquals(5.0,player.getNegativeClicks());
        assertEquals(0.0,player.getClickerScore());
        assertEquals(1,player.getNumberOfRestarts());
        assertEquals(2,player.getNumberOfChanges());
        assertEquals(3,player.getNumberOfDiscards());
        assertEquals(1,player.getRestartFinal());
        assertEquals(6,player.getChangeFinal());
        assertEquals(15,player.getDiscardFinal());
        assertEquals(1,player.getExecution());
        assertEquals(2,player.getControl());
        assertEquals(3,player.getChoreography());
        assertEquals(4,player.getBodyControl());

    }

    @Test
    public void testReadForPlayerDataAnalysis() throws IOException {
        data.read("Test_testPlayerDataAnalysis.csv");
        assertEquals("Test",player.getFirstName());
        assertEquals("Test",player.getLastName()); //lastName
        assertEquals(4,data.getNumberOfFireSectionsInRoutine()); //numberOfFireSectionsInRoutine
        assertEquals(1,data.getNumberOfTiltedSectionsInRoutine()); //numberOfTiltedSectionsInRoutine
        assertEquals(0.5,data.getCPS());//CPS
        assertEquals(0.25,data.getCR());//CR
        assertEquals(60,data.getNumberIfPerfect());//numberIfPerfect
        assertEquals(1.0,data.getCIPPS());//CIPPS
    }

}
