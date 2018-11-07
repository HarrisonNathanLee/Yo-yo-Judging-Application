package App.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import App.player.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSaveable {

    PrelimTwoSemiPlayer player;
    PrelimTwoSemiPlayerDataAnalysis data;

    @BeforeEach
    public void setUp() {
        player = new PrelimTwoSemiPlayer();
        data = new PrelimTwoSemiPlayerDataAnalysis(player);
    }


    @Test
    public void testSaveForPlayer() throws IOException {
        player.setFirstName("Test");
        player.setLastName("Test");
        player.setDivision("1a");
        player.setRoutineType("Prelim");
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
        player.setChoreography(3);
        player.setBodyControl(4);
        player.setSaveLocation(player.getFirstName() + "_testPlayer.csv");
        player.save(player.getSaveLocation());
        List<String> lines = Files.readAllLines(Paths.get(player.getSaveLocation()));
        String line = lines.get(0);
        ArrayList<String> partsOfLine = player.splitOnComma(line);
        assertEquals("Test", partsOfLine.get(0));
        assertEquals("Test", partsOfLine.get(1));
        assertEquals("1a", partsOfLine.get(2));
        assertEquals("Prelim", partsOfLine.get(3));
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
    }


    @Test
    public void testSaveForPlayerDataAnalysis() throws IOException {
        player.setFirstName("Test");
        player.setLastName("Test");
        for (int i = 0; i < 10; i++) {
            player.removeClick();
        }
        for (int i = 0; i < 40; i++) {
            player.awardClick();
        }
        player.setRoutineLength("Prelim");
        player.produceClickerScore();
        data.callAllDataAnalysis();
        data.setSaveLocation(player.getFirstName() + "_testPlayerDataAnalysis.csv");
        data.save(data.getSaveLocation());
        List<String> lines = Files.readAllLines(Paths.get(data.getSaveLocation()));
        String line = lines.get(0);
        ArrayList<String> partsOfLine = data.splitOnComma(line);
        assertEquals("Test", partsOfLine.get(0)); //firstName
        assertEquals("Test", partsOfLine.get(1)); //lastName
        assertEquals("4", partsOfLine.get(2)); //numberOfFireSectionsInRoutine
        assertEquals("1", partsOfLine.get(3)); //numberOfTiltedSectionsInRoutine
        assertEquals("0.5", partsOfLine.get(4));//CPS
        assertEquals("0.25", partsOfLine.get(5));//CR
        assertEquals("60", partsOfLine.get(6));//numberIfPerfect
        assertEquals("1.0",partsOfLine.get(7));//CIPPS

    }
}
