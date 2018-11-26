package App.ui;

import App.Model.StateSingleton;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu implements UpdatePanel{
    private JButton Competition;
    private JButton Individual;
    private JPanel panelCompetitionOrIndividual;
    private JLabel theYoYoJudgingLabel;
    private JFrame frame;

    public MainMenu(JFrame frame){
        this.frame = frame;
        Individual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StateSingleton.getInstance().setMode(false);
                nextPanel();
            }
        });
        Competition.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StateSingleton.getInstance().setMode(true);
                nextPanel();
            }
        });
    }

    public JPanel getPanel(){
        return panelCompetitionOrIndividual;
    }

    @Override
    public void nextPanel() {
        frame.remove(panelCompetitionOrIndividual);
        frame.setContentPane(new StartOrLoad(frame).getPanel());
        frame.setVisible(true);
    }

}
