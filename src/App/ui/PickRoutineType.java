package App.ui;

import App.Competition.*;
import App.Model.StateSingleton;
import App.player.*;

import App.player.PlayerDataAnalysis;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import App.Model.Factory;

public class PickRoutineType implements UpdatePanel{
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
    private Factory f = new Factory();


    public PickRoutineType(JFrame frame) {
        this.frame = frame;
        frame.setContentPane(panelPickRoutineType);
        frame.setVisible(true);
        wildcardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (StateSingleton.getInstance().getMode()){
                    f.createCompetitionAndCompetitionDataAnalysisSubtype("Wildcard",c,cData);
                }
                else {
                    f.createPlayerAndDataSubtype("Wildcard",p,data);
                }
                nextPanel();
            }
        });
        prelimButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (StateSingleton.getInstance().getMode()){
                    f.createCompetitionAndCompetitionDataAnalysisSubtype("Prelim",c,cData);
                }
                else{
                    f.createPlayerAndDataSubtype("Prelim",p,data);
                }
                nextPanel();

            }
        });
        semiFinalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (StateSingleton.getInstance().getMode()){
                    f.createCompetitionAndCompetitionDataAnalysisSubtype("Semi",c,cData);
                }
                else{
                    f.createPlayerAndDataSubtype("Semi",p,data);
                }
                nextPanel();
            }
        });
        twoMinuteFinalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (StateSingleton.getInstance().getMode()){
                    f.createCompetitionAndCompetitionDataAnalysisSubtype("Two Minute Final",c,cData);
                }
                else{
                    f.createPlayerAndDataSubtype("Two Minute Final",p,data);
                }
                nextPanel();
            }
        });
        worldFinalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (StateSingleton.getInstance().getMode()){
                    f.createCompetitionAndCompetitionDataAnalysisSubtype("World Final",c,cData);
                }
                else{
                    f.createPlayerAndDataSubtype("World Final",p,data);
                }
                nextPanel();
            }
        });
    }

    public JPanel getPanel(){
        return panelPickRoutineType;
    }


    public void nextPanel(){
        if(StateSingleton.getInstance().getMode()){
            frame.remove(panelPickRoutineType);
            frame.setContentPane(new PlayerInformationCompetition(frame).getPanel());
            frame.setVisible(true);
        }
        else{
            frame.remove(panelPickRoutineType);
            frame.setContentPane(new PlayerInformation(frame).getPanel());
            frame.setVisible(true);
        }
    }

}
