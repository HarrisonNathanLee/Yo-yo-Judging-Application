package App.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import App.Model.StateSingleton;
import App.ui.*;

public class StartOrLoad {
    private JButton startButton;
    private JButton loadButton;
    public JPanel panelStartOrLoad;
    private JFrame frame;

    public StartOrLoad(JFrame frame) {
        this.frame = frame;
        frame.setContentPane(panelStartOrLoad);
        frame.setVisible(true);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(panelStartOrLoad);
                if (StateSingleton.getInstance().getMode()){
                    frame.setContentPane(new CompetitionInformation(frame).getPanel());

                }
                else{
                    frame.setContentPane(new PickRoutineType(frame).getPanel());
                }
                frame.setVisible(true);
                StateSingleton.getInstance().setStartOrLoad(true);
            }
        });
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(panelStartOrLoad);
                if (StateSingleton.getInstance().getMode()){
                    frame.setContentPane(new CompetitionLoad(frame).getPanel());
                }
                else {
                    frame.setContentPane(new IndividualLoad(frame).getPanel());
                }
                frame.setVisible(true);
                StateSingleton.getInstance().setStartOrLoad(false);
            }
        });
    }

    public JPanel getPanel(){
        return panelStartOrLoad;
    }

}
