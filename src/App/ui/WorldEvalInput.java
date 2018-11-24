package App.ui;

import javax.swing.*;

public class WorldEvalInput {
    private JTextField enterExecutionScoreTextField;
    private JTextField enterControlScoreTextField;
    private JTextField enterBodyControlScoreTextField;
    private JTextField enterShowmanshipScoreTextField;
    private JTextField enterSpaceUseAndTextField;
    private JTextField enterChoreographyScoreTextField;
    private JTextField enterConstructionScoreTextField;
    private JTextField enterTrickDiversityScoreTextField;
    private JPanel panelWorldEvalInput;
    private JButton submitButton;
    private JFrame frame;

    public JPanel getPanel() {
        return panelWorldEvalInput;
    }

    public WorldEvalInput (JFrame frame){
        this.frame = frame;
    }
}
