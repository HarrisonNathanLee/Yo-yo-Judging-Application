package App.ui;

import App.Model.StateSingleton;
import App.player.Player;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        Player p = StateSingleton.getInstance().getPlayer();
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int execution = Integer.parseInt(enterExecutionScoreTextField.getText());
                int control= Integer.parseInt(enterControlScoreTextField.getText());
                int chhoreography = Integer.parseInt(enterChoreographyScoreTextField.getText());
                int bodyControl = Integer.parseInt(enterBodyControlScoreTextField.getText());
                p.setExecution(execution);
                p.setControl(control);
                p.setChoreography(chhoreography);
                p.setBodyControl(bodyControl);
                StateSingleton.getInstance().setPlayer(p);
                frame.remove(panelSemiTwoEvalInput);
                frame.setContentPane(new IndividualModeOutput(frame).getPanel());
                frame.setVisible(true);
            }
        });
    }
}
