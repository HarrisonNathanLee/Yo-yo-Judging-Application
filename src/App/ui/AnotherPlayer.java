package App.ui;

import App.Competition.Competition;
import App.Competition.CompetitionDataAnalysis;
import App.Model.StateSingleton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class AnotherPlayer implements UpdatePanel{

    private JFrame frame;
    private JPanel panelAnotherPlayer;
    private JButton yesButton;
    private JButton noButton;
    private Competition c;
    private CompetitionDataAnalysis cData;
    private Boolean yesOrNo; // true - yes, false - no

    public void setYesOrNo(Boolean yesOrNo) {
        this.yesOrNo = yesOrNo;
    }

    public Boolean getYesOrNo() {
        return yesOrNo;
    }

    public AnotherPlayer(JFrame frame){
        this.frame = frame;
        yesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setYesOrNo(true);
                nextPanel();
            }
        });
        noButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c = StateSingleton.getInstance().getCompetition();
                cData = StateSingleton.getInstance().getCompetitionDataAnalysis();
                cData.callAllDataAnalysis();
                String playerSaveLocation = c.getCompetitionName() + "_" + c.getCompetitionRoutineType() + "_" + c.getCompetitionDivision() + "_";
                String dataSaveLocation = c.getCompetitionName() + "_" + c.getCompetitionRoutineType() + "_" + c.getCompetitionDivision() + "_" + "CompetitionDataAnalysis.csv";
                try {
                    c.save(playerSaveLocation);
                } catch (IOException e1) {
                    System.out.println(e1.getMessage());
                }
                try {
                    cData.save(dataSaveLocation);
                } catch (FileNotFoundException e1) {
                    System.out.println(e1.getMessage());
                }
                StateSingleton.getInstance().setCompetition(c);
                StateSingleton.getInstance().setCompetitionDataAnalysis(cData);
                setYesOrNo(false);
                nextPanel();

            }
        });
    }

    public JPanel getPanel() {
        return panelAnotherPlayer;
    }

    @Override
    public void nextPanel() {
        frame.remove(panelAnotherPlayer);
        if(getYesOrNo()){
            frame.setContentPane(new PlayerInformationCompetition(frame).getPanel());

        }
        else{
            frame.setContentPane(new CompetitionModeOutput(frame).getPanel());
        }
        frame.setVisible(true);
    }
}
