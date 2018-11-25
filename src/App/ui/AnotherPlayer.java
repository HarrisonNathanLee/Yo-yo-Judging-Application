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

public class AnotherPlayer {

    private JFrame frame;
    private JPanel panelAnotherPlayer;
    private JButton yesButton;
    private JButton noButton;
    private Competition c;
    private CompetitionDataAnalysis cData;

    public AnotherPlayer(JFrame frame){
        this.frame = frame;
        yesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(panelAnotherPlayer);
                frame.setContentPane(new PlayerInformationCompetition(frame).getPanel());
                frame.setVisible(true);
            }
        });
        noButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c = StateSingleton.getInstance().getCompetition();
                cData = StateSingleton.getInstance().getCompetitionDataAnalysis();
                String playerSaveLocation = c.getCompetitionName() + "_" + c.getCompetitionRoutineType() + "_" + c.getCompetitionDivision() + "_" + "Players.csv";
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
                frame.remove(panelAnotherPlayer);
                frame.setContentPane(new CompetitionModeOutput(frame).getPanel());
                frame.setVisible(true);

            }
        });
    }

    public Container getPanel() {
        return panelAnotherPlayer;
    }
}
