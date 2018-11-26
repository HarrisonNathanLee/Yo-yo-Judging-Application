package App.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import App.Model.StateSingleton;
import App.ui.*;

public class StartOrLoad implements UpdatePanel {
    private JButton startButton;
    private JButton loadButton;
    public JPanel panelStartOrLoad;
    private JButton backButton;
    private JFrame frame;

    public StartOrLoad(JFrame frame) {
        this.frame = frame;
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StateSingleton.getInstance().setStartOrLoad(true);
                nextPanel();
            }
        });
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StateSingleton.getInstance().setStartOrLoad(false);
                nextPanel();
            }
        });
    }

    public JPanel getPanel(){
        return panelStartOrLoad;
    }

    public void nextPanel(){
        frame.remove(panelStartOrLoad);
        if(StateSingleton.getInstance().getStartOrLoad()){
            if (StateSingleton.getInstance().getMode()){
                frame.setContentPane(new CompetitionInformation(frame).getPanel());

            }
            else{
                frame.setContentPane(new PickRoutineType(frame).getPanel());
            }
        }
        else{
            if (StateSingleton.getInstance().getMode()){
                frame.setContentPane(new CompetitionLoad(frame).getPanel());
            }
            else {
                frame.setContentPane(new IndividualLoad(frame).getPanel());
            }
        }
        frame.setVisible(true);
    }

}
