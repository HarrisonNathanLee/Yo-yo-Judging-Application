package App.ui;

import App.Competition.Competition;
import App.Model.StateSingleton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CompetitionInformation {
    private JTextField competitionNameTextField;
    private JPanel panelCompetitionInformation;
    private JButton submitButton;
    private JComboBox divisionComboBox;
    private JComboBox routineTypeComboBox;
    private JFrame frame;
    private Competition c;

    public CompetitionInformation(JFrame frame){
        this.frame = frame;
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String competitionName = competitionNameTextField.getText();
                String competitionDivision = divisionComboBox.getSelectedItem().toString();
                String routineType = routineTypeComboBox.getSelectedItem().toString();
                c = new Competition();
                c.setCompetitionName(competitionName);
                c.setCompetitionDivision(competitionDivision);
                c.setCompetitionRoutineType(routineType);
                StateSingleton.getInstance().setCompetition(c);
                frame.remove(panelCompetitionInformation);
                frame.setContentPane(new PlayerInformationCompetition(frame).getPanel());
                frame.setVisible(true);

            }
        });
    }

    public Container getPanel() {
        return panelCompetitionInformation;
    }
}

