package App.ui;

import App.Competition.*;
import App.Model.StateSingleton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import App.Model.Factory;
import com.sun.xml.internal.ws.util.xml.CDATA;

public class CompetitionLoad implements UpdatePanel{
    private JTextField competitionNameTextField;
    private JPanel panelCompetitionLoad;
    private JButton submitButton;
    private JComboBox divisionComboBox;
    private JComboBox routineTypeComboBox;
    private JFrame frame;
    private Competition c;
    private CompetitionDataAnalysis cData;
    private Factory f = new Factory();

    public JPanel getPanel(){

        return panelCompetitionLoad;
    }

    public CompetitionLoad(JFrame frame){
        this.frame = frame;
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String competitionName = competitionNameTextField.getText();
                String competitionDivision = divisionComboBox.getSelectedItem().toString();
                String competitionRoutineType = routineTypeComboBox.getSelectedItem().toString();
                f.createCompetitionAndCompetitionDataAnalysisSubtype(competitionRoutineType,c, cData);
                c = StateSingleton.getInstance().getCompetition();
                c.setCompetitionName(competitionName);
                c.setCompetitionDivision(competitionDivision);
                StateSingleton.getInstance().setStartOrLoad(false);
                StateSingleton.getInstance().setCompetition(c);
                nextPanel();
            }
        });
    }

    @Override
    public void nextPanel() {
        frame.remove(panelCompetitionLoad);
        JPanel panel = new CompetitionModeOutput(frame).getPanel();
        frame.setContentPane(panel);
        frame.setVisible(true);



    }

}
