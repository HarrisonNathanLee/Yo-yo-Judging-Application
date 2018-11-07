package App.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import App.player.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

public class TestWorldFinalLoadable {

    WorldFinalPlayer player;
    WorldFinalPlayerDataAnalysis data;

    @BeforeEach
    public void setUp() {
        player = new WorldFinalPlayer();
        data = new WorldFinalPlayerDataAnalysis(player);
    }

    @Test
    public void testReadForPlayer() throws IOException {
        player.load("Test_testWorldFinalPlayer.csv");
        assertEquals("Test",player.getFirstName());
        assertEquals("Test",player.getLastName());
        assertEquals("1a",player.getDivision());
        assertEquals("World Final",player.getRoutineType());
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
        assertEquals(3,player.getTrickDiversity());
        assertEquals(4,player.getSpaceUseAndEmphasis());
        assertEquals(5,player.getChoreography());
        assertEquals(6,player.getConstruction());
        assertEquals(7,player.getBodyControl());
        assertEquals(8,player.getShowmanship());

    }

    @Test
    public void testReadForPlayerDataAnalysis() throws IOException {
        data.load("Test_testWorldFinalPlayerDataAnalysis.csv");
        assertEquals("Test",player.getFirstName());
        assertEquals("Test",player.getLastName()); //lastName
        assertEquals(10,data.getNumberOfFireSectionsInRoutine()); //numberOfFireSectionsInRoutine
        assertEquals(1,data.getNumberOfTiltedSectionsInRoutine()); //numberOfTiltedSectionsInRoutine
        assertEquals(0.5,data.getCPS());//CPS
        assertEquals(0.1,data.getCR());//CR
        assertEquals(120,data.getNumberIfPerfect());//numberIfPerfect
        assertEquals(0.6666666666666666,data.getCIPPS());//CIPPS
    }


}


