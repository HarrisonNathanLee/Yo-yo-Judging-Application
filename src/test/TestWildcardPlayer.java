package test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import player.WildcardPlayer;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestWildcardPlayer {

    WildcardPlayer wildcardPlayer;

    @BeforeEach
    public void setUp(){
        wildcardPlayer = new WildcardPlayer();
    }

    @Test
    public void testNoClick(){
        wildcardPlayer.produceClickerScore();
        assertEquals(0, wildcardPlayer.getPositiveClicks());
        assertEquals(0, wildcardPlayer.getClickerScore());
        assertEquals(0, wildcardPlayer.getClicksLog().size());
    }

    @Test
    public void testAwardClick(){
        wildcardPlayer.awardClick();
        wildcardPlayer.produceClickerScore();
        assertEquals(1, wildcardPlayer.getPositiveClicks());
        assertEquals(1, wildcardPlayer.getClickerScore());
        assertEquals(1, wildcardPlayer.getClicksLog().size());
    }

    @Test
    public void testJustPositiveClicks(){
        wildcardPlayer.awardClick();
        wildcardPlayer.awardClick();
        wildcardPlayer.awardClick();
        wildcardPlayer.produceClickerScore();
        assertEquals(3, wildcardPlayer.getPositiveClicks());
        assertEquals(3, wildcardPlayer.getClickerScore());
        assertEquals(3, wildcardPlayer.getClicksLog().size());
    }

    @Test
    public void testResetOnePositiveClick() {
        wildcardPlayer.awardClick();
        wildcardPlayer.produceClickerScore();
        assertEquals(1, wildcardPlayer.getPositiveClicks());
        assertEquals(1, wildcardPlayer.getClickerScore());
        wildcardPlayer.resetClicks();
        wildcardPlayer.produceClickerScore();
        assertEquals(0, wildcardPlayer.getPositiveClicks());
        assertEquals(0, wildcardPlayer.getClickerScore());

    }
}



