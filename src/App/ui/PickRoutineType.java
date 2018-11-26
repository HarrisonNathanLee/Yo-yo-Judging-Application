package App.ui;

import App.Competition.*;
import App.Model.StateSingleton;
import App.player.*;

import App.player.PlayerDataAnalysis;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PickRoutineType{
    private JPanel panelPickRoutineType;
    private JButton worldFinalButton;
    private JButton prelimButton;
    private JButton wildcardButton;
    private JButton twoMinuteFinalButton;
    private JButton semiFinalButton;
    private Player p;
    private PlayerDataAnalysis data;
    private CompetitionDataAnalysis cData;
    private Competition c;
    private JFrame frame;


    public PickRoutineType(JFrame frame) {
        this.frame = frame;
        frame.setContentPane(panelPickRoutineType);
        frame.setVisible(true);
        wildcardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (StateSingleton.getInstance().getMode()){
                    createCompetitionAndCompetitionDataAnalysisSubtype("Wildcard");
                    nextCompetitionPanel();
                }
                else {
                    createPlayerAndDataSubtype("Wildcard");
                    nextIndividualPanel();
                }
            }
        });
        prelimButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (StateSingleton.getInstance().getMode()){
                    createCompetitionAndCompetitionDataAnalysisSubtype("Prelim");
                    nextCompetitionPanel();
                }
                else{
                    createPlayerAndDataSubtype("Prelim");
                    nextIndividualPanel();
                }

            }
        });
        semiFinalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (StateSingleton.getInstance().getMode()){
                    createCompetitionAndCompetitionDataAnalysisSubtype("Semi");
                    nextCompetitionPanel();

                }
                else{
                    createPlayerAndDataSubtype("Semi");
                    nextIndividualPanel();
                }
            }
        });
        twoMinuteFinalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (StateSingleton.getInstance().getMode()){
                    createCompetitionAndCompetitionDataAnalysisSubtype("Two Minute Final");
                    nextCompetitionPanel();
                }
                else{
                    createPlayerAndDataSubtype("Two Minute Final");
                    nextIndividualPanel();
                }
            }
        });
        worldFinalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (StateSingleton.getInstance().getMode()){
                    createCompetitionAndCompetitionDataAnalysisSubtype("World Final");
                    nextCompetitionPanel();
                }
                else{
                    createPlayerAndDataSubtype("World Final");
                    nextIndividualPanel();
                }
            }
        });
    }

    //MODIFIES: This, Player
    //EFFECTS: Creates player and playerDataAnalysis subtypes depending on user-inputted routineType
    public void createPlayerAndDataSubtype(String routineType) {
        if (routineType.equals("Wildcard")) {
            p = new WildcardPlayer();
            p.setRoutineType("Wildcard");
            p.setRoutineLength("Wildcard");
            data = new WildcardPlayerDataAnalysis(p);
            StateSingleton.getInstance().setPlayer(p);
            StateSingleton.getInstance().setPlayerDataAnalysis(data);
        } else if (routineType.equals("Prelim") || routineType.equals("Semi") || routineType.equals("Two Minute Final")) {
            p = new PrelimTwoSemiPlayer();
            data = new PrelimTwoSemiPlayerDataAnalysis(p);
            if (routineType.equals("Prelim")){
                p.setRoutineType("Prelim");
                p.setRoutineLength("Prelim");
            }
            else if(routineType.equals("Semi")){
                p.setRoutineType("Semi");
                p.setRoutineLength("Semi");
            }
            else if(routineType.equals("Two Minute Final")){
                p.setRoutineType("Two Minute Final");
                p.setRoutineLength("Two Minute Final");
            }
            StateSingleton.getInstance().setPlayer(p);
            StateSingleton.getInstance().setPlayerDataAnalysis(data);
        } else if (routineType.equals("World Final")) {
            p = new WorldFinalPlayer();
            p.setRoutineType("World Final");
            p.setRoutineLength("World Final");
            data = new WorldFinalPlayerDataAnalysis(p);
            StateSingleton.getInstance().setPlayer(p);
            StateSingleton.getInstance().setPlayerDataAnalysis(data);
        }
    }

    //EFFECTS: Factory - creates competition data analysis subtype based on user input
    public void createCompetitionAndCompetitionDataAnalysisSubtype(String routineType){
        c = StateSingleton.getInstance().getCompetition();
        if(routineType.equals("Wildcard")){
            cData = new WildcardCompetitionDataAnalysis(c);
            c.setCompetitionRoutineType("Wildcard");
            StateSingleton.getInstance().setCompetition(c);
            StateSingleton.getInstance().setCompetitionDataAnalysis(cData);
        }
        else if(routineType.equals("Prelim") || routineType.equals("Two Minute Final") || routineType.equals("Semi")){
            cData = new PrelimTwoSemiCompetitionDataAnalysis(c);
            if (routineType.equals("Prelim")){
                c.setCompetitionRoutineType("Prelim");
            }
            else if(routineType.equals("Semi")){
                c.setCompetitionRoutineType("Semi");
            }
            else if(routineType.equals("Two Minute Final")){
                c.setCompetitionRoutineType("Two Minute Final");
            }

            StateSingleton.getInstance().setCompetition(c);
            StateSingleton.getInstance().setCompetitionDataAnalysis(cData);

        }
        else if(routineType.equals("Final")){
            cData = new WorldFinalCompetitionDataAnalysis(c);
            c.setCompetitionRoutineType("World Final");
            StateSingleton.getInstance().setCompetition(c);
            StateSingleton.getInstance().setCompetitionDataAnalysis(cData);

        }
    }

    public JPanel getPanel(){
        return panelPickRoutineType;
    }

    public void nextIndividualPanel(){
        frame.remove(panelPickRoutineType);
        frame.setContentPane(new PlayerInformation(frame).getPanel());
        frame.setVisible(true);
    }

    public void nextCompetitionPanel(){
        frame.remove(panelPickRoutineType);
        frame.setContentPane(new PlayerInformationCompetition(frame).getPanel());
        frame.setVisible(true);
    }

}
