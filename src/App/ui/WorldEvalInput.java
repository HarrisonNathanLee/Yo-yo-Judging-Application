package App.ui;

import App.Model.StateSingleton;
import App.player.Player;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        Player p = StateSingleton.getInstance().getPlayer();
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int execution = Integer.parseInt(enterExecutionScoreTextField.getText());
                int control = Integer.parseInt(enterControlScoreTextField.getText());
                int bodyControl = Integer.parseInt(enterBodyControlScoreTextField.getText());
                int showmanship = Integer.parseInt(enterShowmanshipScoreTextField.getText());
                int spaceUseAndEmphasis= Integer.parseInt(enterSpaceUseAndTextField.getText());
                int choreograhpy = Integer.parseInt(enterChoreographyScoreTextField.getText());
                int construction = Integer.parseInt(enterConstructionScoreTextField.getText());
                int trickDiversity = Integer.parseInt(enterTrickDiversityScoreTextField.getText());
                p.setExecution(execution);
                p.setControl(control);
                p.setBodyControl(bodyControl);
                p.setShowmanship(showmanship);
                p.setSpaceUseAndEmphasis(spaceUseAndEmphasis);
                p.setChoreography(choreograhpy);
                p.setConstruction(construction);
                p.setTrickDiversity(trickDiversity);
                StateSingleton.getInstance().setPlayer(p);
                frame.remove(panelWorldEvalInput);
                frame.setContentPane(new IndividualModeOutput(frame).getPanel());
                frame.setVisible(true);
            }
        });
    }
}
