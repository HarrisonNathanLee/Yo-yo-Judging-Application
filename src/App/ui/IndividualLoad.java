package App.ui;

import App.Model.StateSingleton;
import App.player.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class IndividualLoad {
    private JTextField firstNameTextField;
    private JTextField routineTypeTextField;
    private JButton submitButton;
    private JPanel panelIndividualLoad;
    private JFrame frame;
    private Player p;
    private PlayerDataAnalysis data;

    public IndividualLoad (JFrame frame){
        this.frame = frame;
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = firstNameTextField.getText();
                String routineType = routineTypeTextField.getText();
                createPlayerAndDataSubtype("Wildcard");
                frame.remove(panelIndividualLoad);
                frame.setContentPane(new IndividualModeOutput(frame).getPanel());
                frame.setVisible(true);
            }
        });
    }

    //MODIFIES: This, Player
    //EFFECTS: Creates player and playerDataAnalysis subtypes depending on user-inputted routineType
    public void createPlayerAndDataSubtype(String routineType) {
        if (routineType.equals("Wildcard")) {
            p = new WildcardPlayer();
            p.setRoutineType("Wildcard");
            p.setRoutineLength("Wildcard");
            data = new WildcardPlayerDataAnalysis(p);
            StateSingleton.getInstance().setPlayer(p);
            StateSingleton.getInstance().setPlayerDataAnalysis(data);
        } else if (routineType.equals("Prelim") || routineType.equals("Semi") || routineType.equals("Two Minute Final")) {
            p = new PrelimTwoSemiPlayer();
            data = new PrelimTwoSemiPlayerDataAnalysis(p);
            if (routineType.equals("Prelim")){
                p.setRoutineType("Prelim");
                p.setRoutineLength("Prelim");
            }
            else if(routineType.equals("Semi")){
                p.setRoutineType("Semi");
                p.setRoutineLength("Semi");
            }
            else if(routineType.equals("Two Minute Final")){
                p.setRoutineType("Two Minute Final");
                p.setRoutineLength("Two Minute Final");
            }
            StateSingleton.getInstance().setPlayer(p);
            StateSingleton.getInstance().setPlayerDataAnalysis(data);
        } else if (routineType.equals("World Final")) {
            p = new WorldFinalPlayer();
            p.setRoutineType("World Final");
            p.setRoutineLength("World Final");
            data = new WorldFinalPlayerDataAnalysis(p);
            StateSingleton.getInstance().setPlayer(p);
            StateSingleton.getInstance().setPlayerDataAnalysis(data);
        }
    }

    public JPanel getPanel(){
        return panelIndividualLoad;
    }

}
