package App.ui;

import App.Competition.*;
import App.Model.StateSingleton;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CompetitionLoad {
    private JTextField competitionNameTextField;
    private JPanel panelCompetitionLoad;
    private JButton submitButton;
    private JComboBox divisionComboBox;
    private JComboBox routineTypeComboBox;
    private JFrame frame;
    private Competition c;
    private CompetitionDataAnalysis cData;

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
                createCompetitionAndCompetitionDataAnalysisSubtype(competitionRoutineType);
                c = StateSingleton.getInstance().getCompetition();
                c.setCompetitionName(competitionName);
                c.setCompetitionDivision(competitionDivision);
                StateSingleton.getInstance().setStartOrLoad(false);
                StateSingleton.getInstance().setCompetition(c);
                frame.remove(panelCompetitionLoad);
                frame.setContentPane(new CompetitionModeOutput(frame).getPanel());
                frame.setVisible(true);
            }
        });
    }

    //EFFECTS: Factory - creates competition data analysis subtype based on user input
    public void createCompetitionAndCompetitionDataAnalysisSubtype(String routineType){
        c = new Competition();
        if(routineType.equals("Wildcard")){
            cData = new WildcardCompetitionDataAnalysis(c);
            c.setCompetitionRoutineType("Wildcard");
            StateSingleton.getInstance().setCompetition(c);
            StateSingleton.getInstance().setCompetitionDataAnalysis(cData);
        }
        else if(routineType.equals("Prelim") || routineType.equals("Two Minute Final") || routineType.equals("Semi")){
            cData = new PrelimTwoSemiCompetitionDataAnalysis(c);
            if (routineType.equals("Prelim")){
                c.setCompetitionRoutineType("Prelim");
            }
            else if(routineType.equals("Semi")){
                c.setCompetitionRoutineType("Semi");
            }
            else if(routineType.equals("Two Minute Final")){
                c.setCompetitionRoutineType("Two Minute Final");
            }

            StateSingleton.getInstance().setCompetition(c);
            StateSingleton.getInstance().setCompetitionDataAnalysis(cData);

        }
        else if(routineType.equals("Final")){
            cData = new WorldFinalCompetitionDataAnalysis(c);
            c.setCompetitionRoutineType("World Final");
            StateSingleton.getInstance().setCompetition(c);
            StateSingleton.getInstance().setCompetitionDataAnalysis(cData);

        }
    }

}
