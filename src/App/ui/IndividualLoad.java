package App.ui;

import App.Competition.PrelimTwoSemiCompetitionDataAnalysis;
import App.Competition.WildcardCompetitionDataAnalysis;
import App.Model.Factory;
import App.Model.StateSingleton;
import App.player.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class IndividualLoad implements UpdatePanel{
    private JTextField firstNameTextField;
    private JButton submitButton;
    private JPanel panelIndividualLoad;
    private JTextField lastNameTextField;
    private JComboBox routineTypeComboBox;
    private JFrame frame;
    private Player p;
    private PlayerDataAnalysis data;
    private Factory f = new Factory();

    public IndividualLoad (JFrame frame){
        this.frame = frame;
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = firstNameTextField.getText();
                String lastName = lastNameTextField.getText();
                String routineType = routineTypeComboBox.getSelectedItem().toString();
                data = f.createPlayerAndDataSubtype(routineType);
                p = data.getPlayer();
                p.setFirstName(firstName);
                p.setLastName(lastName);
                StateSingleton.getInstance().setPlayer(p);
                StateSingleton.getInstance().setPlayerDataAnalysis(data);
                nextPanel();
            }
        });
    }

    public JPanel getPanel(){
        return panelIndividualLoad;
    }

    @Override
    public void nextPanel() {
        frame.remove(panelIndividualLoad);
        frame.setContentPane(new IndividualModeOutput(frame).getPanel());
        frame.setVisible(true);

    }

}
