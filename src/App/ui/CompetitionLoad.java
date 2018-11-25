package App.ui;

import App.Model.StateSingleton;

import javax.swing.*;

public class CompetitionLoad {
    private JTextField typeTheNameOfTextField;
    private JPanel panelCompetitionLoad;
    private JTextField typeTheRoutineTypeTextField;
    private JButton submitButton;
    private JFrame frame;

    public JPanel getPanel(){
        return panelCompetitionLoad;
    }

    public CompetitionLoad(JFrame frame){
        this.frame = frame;
    }

}
