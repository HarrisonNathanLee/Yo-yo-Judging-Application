package App.ui;

import javax.swing.*;

public class PrelimSemiTwoEvalInput {
    private JTextField enterExecutionScoreTextField;
    private JTextField enterControlScoreTextField;
    private JTextField enterChoreographyScoreTextField;
    private JTextField enterBodyControlScoreTextField;
    private JButton submitButton;
    private JPanel panelSemiTwoEvalInput;
    private JFrame frame;

    public JPanel getPanel(){
        return panelSemiTwoEvalInput;
    }

    public PrelimSemiTwoEvalInput(JFrame frame){
        this.frame = frame;
    }
}
