package test;

import Competition.Competition;
import Competition.CompetitionDataAnalysis;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import player.WorldFinalPlayer;
import player.WorldFinalPlayerDataAnalysis;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCompetitionDataAnalysis {

    WorldFinalPlayer player1;
    WorldFinalPlayerDataAnalysis data1;
    WorldFinalPlayer player2;
    WorldFinalPlayerDataAnalysis data2;
    Competition competition;
    CompetitionDataAnalysis cData;

    @BeforeEach
    public void setUp(){
        player1 = new WorldFinalPlayer();
        data1 = new WorldFinalPlayerDataAnalysis(player1);
        player1.setFirstName("Harrison");
        player1.setLastName("Lee");
        player1.setDivision("1a");
        player1.setRoutineType("World Final");
        player1.setRoutineLength("World Final");
        for (int i =0; i<10; i++){
            player1.awardClick();
        }
        for (int i =0; i<5; i++){
            player1.removeClick();
        }
        player1.produceClickerScore();
        player1.setEvaluation(10, "execution");
        player1.setEvaluation(10, "control");
        player1.setEvaluation(10,"choreography");
        player1.setEvaluation(10, "bodyControl");
        player1.setEvaluation(10, "spaceUseAndEmphasis");
        player1.setEvaluation(10, "trickDiversity");
        player1.setEvaluation(10,"construction");
        player1.setEvaluation(10, "showmanship");
        data1.callAllDataAnalysis();

        player2 = new WorldFinalPlayer();
        data2 = new WorldFinalPlayerDataAnalysis(player2);
        player2.setFirstName("Allison");
        player2.setLastName("Lee");
        player2.setDivision("1a");
        player2.setRoutineType("World Final");
        player2.setRoutineLength("World Final");
        for (int i =0; i<20; i++){
            player2.awardClick();
        }
        for (int i =0; i<10; i++){
            player2.removeClick();
        }
        player2.produceClickerScore();
        player2.setEvaluation(2, "execution");
        player2.setEvaluation(2, "control");
        player2.setEvaluation(2,"choreography");
        player2.setEvaluation(2, "bodyControl");
        player2.setEvaluation(2, "spaceUseAndEmphasis");
        player2.setEvaluation(2, "trickDiversity");
        player2.setEvaluation(2,"construction");
        player2.setEvaluation(2, "showmanship");
        data2.callAllDataAnalysis();

        competition = new Competition();
        competition.addPlayer(player1);
        competition.addPlayer(player2);
        competition.addPlayerDataAnalysis(data1);
        competition.addPlayerDataAnalysis(data2);
        competition.setCompetitionName("worlds");
        cData = new CompetitionDataAnalysis(competition);
    }

    @Test
    public void testProduceAllMean (){
        cData.callAllDataAnalysis();
        assertEquals(6, cData.getMeanExecution());
        assertEquals(6, cData.getMeanControl());
        assertEquals(6, cData.getMeanTrickDiversity());
        assertEquals(6, cData.getMeanSpaceUseAndEmphasis());
        assertEquals(6, cData.getMeanChoreography());
        assertEquals(6, cData.getMeanConstruction());
        assertEquals(6, cData.getMeanBodyControl());
        assertEquals(6, cData.getMeanShowmanship());
        assertEquals(7.5, cData.getMeanClickerscore());
        assertEquals(15,cData.getMeanPositiveClicks());
        assertEquals(7.5,cData.getMeanNegativeClicks());

    }


}
