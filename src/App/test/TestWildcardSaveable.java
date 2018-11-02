package App.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import App.player.WildcardPlayer;
import App.player.WildcardPlayerDataAnalysis;
import App.player.WorldFinalPlayer;
import App.player.WorldFinalPlayerDataAnalysis;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestWildcardSaveable {

    WildcardPlayer player;
    WildcardPlayerDataAnalysis data;

    @BeforeEach
    public void setUp() {
        player = new WildcardPlayer();
        data = new WildcardPlayerDataAnalysis(player);
    }


    @Test
    public void testSaveForPlayer() throws IOException {
        player.setFirstName("Test");
        player.setLastName("Test");
        player.setDivision("1a");
        player.setRoutineType("Wildcard");
        player.setPositiveClicks(5);
        player.produceClickerScore();
        player.setClickerScore(5);
        player.setSaveLocation(player.getFirstName() + "_testWildcardPlayer.csv");
        player.save(player.getSaveLocation());
        List<String> lines = Files.readAllLines(Paths.get(player.getSaveLocation()));
        String line = lines.get(0);
        ArrayList<String> partsOfLine = player.splitOnComma(line);
        assertEquals("Test", partsOfLine.get(0));
        assertEquals("Test", partsOfLine.get(1));
        assertEquals("1a", partsOfLine.get(2));
        assertEquals("Wildcard", partsOfLine.get(3));
        assertEquals("5.0", partsOfLine.get(4));
        assertEquals("5.0", partsOfLine.get(5));
    }


    @Test
    public void testSaveForPlayerDataAnalysis() throws IOException {
        player.setFirstName("Test");
        player.setLastName("Test");
        for (int i = 0; i < 15; i++) {
            player.awardClick();
        }
        player.setRoutineLength("Wildcard");
        player.produceClickerScore();
        data.callAllDataAnalysis();
        data.setSaveLocation(player.getFirstName() + "_testWildcardPlayerDataAnalysis.csv");
        data.save(data.getSaveLocation());
        List<String> lines = Files.readAllLines(Paths.get(data.getSaveLocation()));
        String line = lines.get(0);
        ArrayList<String> partsOfLine = data.splitOnComma(line);
        assertEquals("Test", partsOfLine.get(0)); //firstName
        assertEquals("Test", partsOfLine.get(1)); //lastName
        assertEquals("0.5", partsOfLine.get(2));//CPS

    }
}
