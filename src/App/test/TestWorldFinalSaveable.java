package App.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import App.player.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestWorldFinalSaveable {

    WorldFinalPlayer player;
    WorldFinalPlayerDataAnalysis data;

    @BeforeEach
    public void setUp() {
        player = new WorldFinalPlayer();
        data = new WorldFinalPlayerDataAnalysis(player);
    }


    @Test
    public void testSaveForPlayer() throws IOException {
        player.setFirstName("Test");
        player.setLastName("Test");
        player.setDivision("1a");
        player.setRoutineType("World Final");
        player.setPositiveClicks(5);
        player.setNegativeClicks(5);
        player.produceClickerScore();
        player.setNumberOfRestarts(1);
        player.setNumberOfChanges(2);
        player.setNumberOfDiscards(3);
        player.multiplyRestart();
        player.multiplyChange();
        player.multiplyDiscard();
        player.setExecution(1);
        player.setControl(2);
        player.setTrickDiversity(3);
        player.setSpaceUseAndEmphasis(4);
        player.setChoreography(5);
        player.setConstruction(6);
        player.setBodyControl(7);
        player.setShowmanship(8);
        player.setSaveLocation(player.getFirstName() + "_testWorldFinalPlayer.csv");
        player.save(player.getSaveLocation());
        List<String> lines = Files.readAllLines(Paths.get(player.getSaveLocation()));
        String line = lines.get(0);
        ArrayList<String> partsOfLine = player.splitOnComma(line);
        assertEquals("Test", partsOfLine.get(0));
        assertEquals("Test", partsOfLine.get(1));
        assertEquals("1a", partsOfLine.get(2));
        assertEquals("World Final", partsOfLine.get(3));
        assertEquals("5.0", partsOfLine.get(4));
        assertEquals("5.0", partsOfLine.get(5));
        assertEquals("0.0", partsOfLine.get(6));
        assertEquals("1", partsOfLine.get(7));
        assertEquals("2", partsOfLine.get(8));
        assertEquals("3", partsOfLine.get(9));
        assertEquals("1", partsOfLine.get(10));
        assertEquals("6", partsOfLine.get(11));
        assertEquals("15", partsOfLine.get(12));
        assertEquals("1", partsOfLine.get(13));
        assertEquals("2", partsOfLine.get(14));
        assertEquals("3", partsOfLine.get(15));
        assertEquals("4", partsOfLine.get(16));
        assertEquals("5", partsOfLine.get(17));
        assertEquals("6", partsOfLine.get(18));
        assertEquals("7", partsOfLine.get(19));
        assertEquals("8", partsOfLine.get(20));
    }


    @Test
    public void testSaveForPlayerDataAnalysis() throws IOException {
        player.setFirstName("Test");
        player.setLastName("Test");
        for (int i = 0; i < 10; i++) {
            player.removeClick();
        }
        for (int i = 0; i < 100; i++) {
            player.awardClick();
        }
        player.setRoutineLength("World Final");
        player.produceClickerScore();
        data.callAllDataAnalysis();
        data.setSaveLocation(player.getFirstName() + "_testWorldFinalPlayerDataAnalysis.csv");
        data.save(data.getSaveLocation());
        List<String> lines = Files.readAllLines(Paths.get(data.getSaveLocation()));
        String line = lines.get(0);
        ArrayList<String> partsOfLine = data.splitOnComma(line);
        assertEquals("Test", partsOfLine.get(0)); //firstName
        assertEquals("Test", partsOfLine.get(1)); //lastName
        assertEquals("10", partsOfLine.get(2)); //numberOfFireSectionsInRoutine
        assertEquals("1", partsOfLine.get(3)); //numberOfTiltedSectionsInRoutine
        assertEquals("0.5", partsOfLine.get(4));//CPS
        assertEquals("0.1", partsOfLine.get(5));//CR
        assertEquals("120", partsOfLine.get(6));//numberIfPerfect
        assertEquals("0.6666666666666666",partsOfLine.get(7));//CIPPS

    }

}


