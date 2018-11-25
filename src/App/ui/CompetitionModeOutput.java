package App.ui;

import App.Competition.Competition;
import App.Competition.CompetitionDataAnalysis;
import App.Model.StateSingleton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CompetitionModeOutput extends ConsoleToUI {

    private JFrame frame;
    private JTextPane outputTextPane;
    private JPanel panelCompetitionModeOutput;
    private JButton continueButton;
    private Competition c;
    private CompetitionDataAnalysis cData;

    public CompetitionModeOutput(JFrame frame){
        this.frame = frame;
        redirectSystemStreams(outputTextPane);
        c = StateSingleton.getInstance().getCompetition();
        cData = StateSingleton.getInstance().getCompetitionDataAnalysis();
        c.addSortPrintHMAP();
        cData.callAllDataAnalysis();
        cData.printAnalyzedCompetitionInformation(cData);
        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(panelCompetitionModeOutput);
                frame.setContentPane(new MainMenu(frame).getPanel());
                frame.setVisible(true);
            }
        });
    }

    public Container getPanel() {
        return panelCompetitionModeOutput;
    }
}
