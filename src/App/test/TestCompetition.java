package App.test;

import App.Competition.Competition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import App.player.PrelimTwoSemiPlayer;
import App.player.PrelimTwoSemiPlayerDataAnalysis;

import java.io.IOException;


public class TestCompetition {
    PrelimTwoSemiPlayer player1;
    PrelimTwoSemiPlayerDataAnalysis data1;
    PrelimTwoSemiPlayer player2;
    PrelimTwoSemiPlayerDataAnalysis data2;
    Competition competition;

    @BeforeEach
    public void setUp(){
        player1 = new PrelimTwoSemiPlayer();
        data1 = new PrelimTwoSemiPlayerDataAnalysis(player1);
        player1.setFirstName("Harrison");
        player1.setLastName("Lee");
        player1.setDivision("1a");
        player1.setRoutineType("Prelim");
        player1.setRoutineLength("Prelim");
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
        data1.callAllDataAnalysis();

        player2 = new PrelimTwoSemiPlayer();
        data2 = new PrelimTwoSemiPlayerDataAnalysis(player2);
        player2.setFirstName("Allison");
        player2.setLastName("Lee");
        player2.setDivision("1a");
        player2.setRoutineType("Prelim");
        player2.setRoutineLength("Prelim");
        for (int i =0; i<20; i++){
            player2.awardClick();
        }
        for (int i =0; i<10; i++){
            player2.removeClick();
        }
        player2.produceClickerScore();
        player2.setEvaluation(1, "execution");
        player2.setEvaluation(1, "control");
        player2.setEvaluation(1,"choreography");
        player2.setEvaluation(1, "bodyControl");
        data2.callAllDataAnalysis();

        competition = new Competition();
        competition.addPlayer(player1);
        competition.addPlayer(player2);
        competition.addPlayerDataAnalysis(data1);
        competition.addPlayerDataAnalysis(data2);

        competition.setCompetitionName("worlds");

    }

    @Test
    public void testCompetitionSave() throws IOException {
        competition.save(competition.getCompetitionName());
    }

    @Test
    public void testCompetitionRead() throws IOException {
        competition.load(competition.getCompetitionName());
    }

}
