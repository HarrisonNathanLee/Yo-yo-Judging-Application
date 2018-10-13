package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import player.*;

import java.io.IOException;

public class TestWorldFinalReadable {

    WorldFinalPlayer player;
    WorldFinalPlayerDataAnalysis data;

    @BeforeEach
    public void setUp() {
        player = new WorldFinalPlayer();
        data = new WorldFinalPlayerDataAnalysis(player);
    }

    @Test
    public void testReadForPlayer() throws IOException {
        player.read("Test_testWorldFinalPlayer.csv");
        assertEquals(player.getFirstName(), "Test");
        assertEquals(player.getLastName(), "Test");
        assertEquals(player.getDivision(), "1a");
        assertEquals(player.getRoutineType(), "World Final");
        assertEquals(player.getPositiveClicks(),5.0);
        assertEquals(player.getNegativeClicks(), 5.0);
        assertEquals(player.getClickerScore(), 0.0);
        assertEquals(player.getNumberOfRestarts(), 1);
        assertEquals(player.getNumberOfChanges(), 2);
        assertEquals(player.getNumberOfDiscards(), 3);
        assertEquals(player.getRestartFinal(), 1);
        assertEquals(player.getChangeFinal(), 6);
        assertEquals(player.getDiscardFinal(),15);
        assertEquals(player.getExecution(), 1);
        assertEquals(player.getControl(), 2);
        assertEquals(player.getTrickDiversity(), 3);
        assertEquals(player.getSpaceUseAndEmphasis(), 4);
        assertEquals(player.getChoreography(), 5);
        assertEquals(player.getConstruction(), 6);
        assertEquals(player.getBodyControl(), 7);
        assertEquals(player.getShowmanship(), 8);

    }

    @Test
    public void testReadForPlayerDataAnalysis() throws IOException {
        data.read("Test_testWorldFinalPlayerDataAnalysis.csv");
        assertEquals(player.getFirstName(),"Test");
        assertEquals(player.getLastName(), "Test"); //lastName
        assertEquals(data.getNumberOfFireSectionsInRoutine(), 2); //numberOfFireSectionsInRoutine
        assertEquals(data.getNumberOfTiltedSectionsInRoutine(), 1); //numberOfTiltedSectionsInRoutine
        assertEquals(data.getCPS(), 0.1);//CPS
        assertEquals(data.getCR(),0.5);//CR
        assertEquals(data.getNumberIfPerfect(), 40);//numberIfPerfect
        assertEquals(data.getCIPPS(),0.4);//CIPPS
    }


}


