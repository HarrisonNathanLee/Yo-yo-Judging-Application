
package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import player.Readable;
import player.Player;
import player.PlayerDataAnalysis;

import java.io.IOException;

public class TestReadable {

    Player player;
    PlayerDataAnalysis data;

    @BeforeEach
    public void setUp() {
        player = new Player();
        data = new PlayerDataAnalysis(player);
    }

    @Test
    public void testReadForPlayer() throws IOException {
        player.read("testPlayer.csv");


    }

    @Test
    public void testReadForPlayerDataAnalysis() throws IOException {
        data.read("testPlayerDataAnalysis.csv");
    }


}

