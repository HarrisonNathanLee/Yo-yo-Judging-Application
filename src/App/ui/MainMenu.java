package App.ui;

import App.Model.StateSingleton;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu {
    private JButton Competition;
    private JButton Individual;
    private JPanel panelCompetitionOrIndividual;
    private JFrame frame;

    public MainMenu(JFrame frame) {
        this.frame = frame;
        Individual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(panelCompetitionOrIndividual);
                frame.setContentPane(new StartOrLoad(frame).getPanel());
                frame.setVisible(true);
                StateSingleton.getInstance().setMode(false);
            }
        });
        Competition.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(panelCompetitionOrIndividual);
                frame.setContentPane(new StartOrLoad(frame).getPanel());
                frame.setVisible(true);
                StateSingleton.getInstance().setMode(true);
            }
        });
    }

    public JPanel getPanel(){
        return panelCompetitionOrIndividual;
    }
}
