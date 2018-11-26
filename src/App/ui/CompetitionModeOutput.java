package App.ui;

import App.Competition.Competition;
import App.Competition.CompetitionDataAnalysis;
import App.Model.StateSingleton;

import javax.swing.*;
import javax.swing.plaf.nimbus.State;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.io.IOException;

public class CompetitionModeOutput extends ConsoleToUI {

    private JFrame frame;
    private JTextPane outputTextPane;
    private JPanel panelCompetitionModeOutput;
    private JButton continueButton;
    private Competition c;
    private CompetitionDataAnalysis cData;

    public CompetitionModeOutput(JFrame frame){
        this.frame = frame;
        if (StateSingleton.getInstance().getStartOrLoad()){
            c = StateSingleton.getInstance().getCompetition();
            cData = StateSingleton.getInstance().getCompetitionDataAnalysis();
            redirectSystemStreams(outputTextPane);
            c.addSortPrintHMAP();
            cData.printAnalyzedCompetitionInformation(cData);
        }
        else {
            c = StateSingleton.getInstance().getCompetition();
            cData = StateSingleton.getInstance().getCompetitionDataAnalysis();
            String playerSaveLocation = c.getCompetitionName() + "_" + c.getCompetitionRoutineType() + "_" + c.getCompetitionDivision() + "_";
            String dataSaveLocation = c.getCompetitionName() + "_" + c.getCompetitionRoutineType() + "_" + c.getCompetitionDivision() + "_" + "CompetitionDataAnalysis.csv";
            redirectSystemStreams(outputTextPane);
            try {
                c.load(playerSaveLocation);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            try {
                cData.load(dataSaveLocation);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(panelCompetitionModeOutput);
                frame.setContentPane(new MainMenu(frame).getPanel());
                frame.setVisible(true);
            }
        });
    }

    public JPanel getPanel(){
        return panelCompetitionModeOutput;
    }

    private void createUIComponents() {
        panelCompetitionModeOutput = new JPanel();

        // TODO: place custom component creation code here
    }
}
