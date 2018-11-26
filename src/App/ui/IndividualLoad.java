package App.ui;

import App.Competition.PrelimTwoSemiCompetitionDataAnalysis;
import App.Competition.WildcardCompetitionDataAnalysis;
import App.Model.StateSingleton;
import App.player.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class IndividualLoad {
    private JTextField firstNameTextField;
    private JButton submitButton;
    private JPanel panelIndividualLoad;
    private JTextField lastNameTextField;
    private JComboBox routineTypeComboBox;
    private JFrame frame;
//    private Player p;
//    private PlayerDataAnalysis data;

    public IndividualLoad (JFrame frame){
        this.frame = frame;
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = firstNameTextField.getText();
                String lastName = lastNameTextField.getText();
                String routineType = routineTypeComboBox.getSelectedItem().toString();
                PlayerDataAnalysis data = createPlayerAndDataSubtype(routineType);
                Player p = data.getPlayer();
                p.setFirstName(firstName);
                p.setLastName(lastName);
                StateSingleton.getInstance().setPlayer(p);
                StateSingleton.getInstance().setPlayerDataAnalysis(data);
                frame.remove(panelIndividualLoad);
                frame.setContentPane(new IndividualModeOutput(frame).getPanel());
                frame.setVisible(true);

            }
        });
    }

    //MODIFIES: This, Player
    //EFFECTS: Creates player and playerDataAnalysis subtypes depending on user-inputted routineType
    public PlayerDataAnalysis createPlayerAndDataSubtype(String routineType) {
        if (routineType.equals("Wildcard")) {
            WildcardPlayer p = new WildcardPlayer();
            p.setRoutineType("Wildcard");
            p.setRoutineLength("Wildcard");
            WildcardPlayerDataAnalysis data = new WildcardPlayerDataAnalysis(p);
            return data;
        } else if (routineType.equals("Prelim") || routineType.equals("Semi") || routineType.equals("Two Minute Final")) {
            PrelimTwoSemiPlayer p = new PrelimTwoSemiPlayer();
            PrelimTwoSemiPlayerDataAnalysis data = new PrelimTwoSemiPlayerDataAnalysis(p);
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
            return data;
        } else if (routineType.equals("World Final")) {
            WorldFinalPlayer p = new WorldFinalPlayer();
            p.setRoutineType("World Final");
            p.setRoutineLength("World Final");
            WorldFinalPlayerDataAnalysis data = new WorldFinalPlayerDataAnalysis(p);
            return data;
        }
        return null;
    }

    public JPanel getPanel(){
        return panelIndividualLoad;
    }

}
