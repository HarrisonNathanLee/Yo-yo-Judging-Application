package App.ui;

import App.Competition.Competition;
import App.Model.StateSingleton;
import App.player.*;

import javax.swing.*;
import javax.swing.plaf.nimbus.State;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerInformationCompetition {

    private JFrame frame;
    private JPanel panelPlayerInformationCompetition;
    private JTextField firstNameTextField;
    private JTextField lastNameTextField;
    private JButton submitButton;
    private Player p;
    private PlayerDataAnalysis data;
    private Competition c;

    public PlayerInformationCompetition(JFrame frame){
        this.frame = frame;
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = firstNameTextField.getText();
                String lastName = lastNameTextField.getText();
                String routineType = StateSingleton.getInstance().getCompetition().getCompetitionRoutineType();
                String division = StateSingleton.getInstance().getCompetition().getCompetitionDivision();
                createPlayerAndDataSubtype(routineType);
                p = StateSingleton.getInstance().getPlayer();
                data = StateSingleton.getInstance().getPlayerDataAnalysis();
                c = StateSingleton.getInstance().getCompetition();
                c.addPlayer(p);
                c.addPlayerDataAnalysis(data);
                p.setFirstName(firstName);
                p.setLastName(lastName);
                p.setRoutineType(routineType);
                p.setDivision(division);
                StateSingleton.getInstance().setPlayer(p);
                if (routineType.equals("Wildcard")){
                    frame.remove(panelPlayerInformationCompetition);
                    frame.setContentPane(new WildcardClicker(frame).getPanel());
                    frame.setVisible(true);
                }
                else {
                    frame.remove(panelPlayerInformationCompetition);
                    frame.setContentPane(new Clicker(frame).getPanel());
                    frame.setVisible(true);
                }

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

    public Container getPanel() {
        return panelPlayerInformationCompetition;
    }
}
