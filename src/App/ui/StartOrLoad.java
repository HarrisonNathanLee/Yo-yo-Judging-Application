package App.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import App.ui.*;

public class StartOrLoad {
    private JButton startButton;
    private JButton loadButton;
    public JPanel panelStartOrLoad;
    private JPanel firstPanel;
    private JPanel panelPickRoutineType;
    private JPanel panelIndividualLoad;
    private JPanel panelCompetitionLoad;
    CardLayout card = (CardLayout)panelStartOrLoad.getLayout();

    public StartOrLoad() {
        card.addLayoutComponent(panelPickRoutineType,"card2");
        card.addLayoutComponent(panelIndividualLoad,"card3");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.show(panelStartOrLoad,"card2");
            }
        });
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.show(panelStartOrLoad,"card3");

            }
        });
    }

    public JPanel getPanel(){
        return panelStartOrLoad;
    }

    private void createUIComponents() {
        panelPickRoutineType = new PickRoutineType().getPanel();
        panelIndividualLoad = new IndividualLoad().getPanel();
        panelCompetitionLoad = new CompetitionLoad().getPanel();

    }
}
