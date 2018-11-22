package App.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PickRoutineType {
    private JPanel panelPickRoutineType;
    private JButton worldFinalButton;
    private JButton prelimButton;
    private JButton wildcardButton;
    private JButton twoMinuteFinalButton;
    private JButton semiFinalButton;

    public JPanel getPanel(){
        return panelPickRoutineType;
    }

    public PickRoutineType() {
        wildcardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        prelimButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        semiFinalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        twoMinuteFinalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        worldFinalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
