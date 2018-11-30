package App.ui;

import App.Model.StateSingleton;
import App.player.Player;
import App.player.PlayerDataAnalysis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static App.player.Player.*;
import static App.player.Player.CONSTRUCTIONDESCRIPTION;

public class PrelimSemiTwoEvalInput implements UpdatePanel {
    private JTextField enterExecutionScoreTextField;
    private JTextField enterControlScoreTextField;
    private JTextField enterChoreographyScoreTextField;
    private JTextField enterBodyControlScoreTextField;
    private JButton submitButton;
    private JPanel panelSemiTwoEvalInput;
    private JLabel enterExecutionScoreLabel;
    private JLabel enterControlScoreLabel;
    private JLabel enterChoreographyScoreLabel;
    private JLabel enterBodyControlScoreLabel;
    private JFrame frame;
    private Player p;
    private PlayerDataAnalysis data;
    private String errorMessage = "Please input an integer between 1 and 10";

    public Boolean getExceptionThrown() {
        return exceptionThrown;
    }

    public void setExceptionThrown(Boolean exceptionThrown) {
        this.exceptionThrown = exceptionThrown;
    }

    private Boolean exceptionThrown = false;

    @Override
    public JPanel getPanel(){
        return panelSemiTwoEvalInput;
    }

    @Override
    public void nextPanel() {
        frame.remove(panelSemiTwoEvalInput);
        frame.setContentPane(new IndividualModeOutput(frame).getPanel());
        frame.setVisible(true);
    }

    public PrelimSemiTwoEvalInput(JFrame frame){
        this.frame = frame;
        p = StateSingleton.getInstance().getPlayer();
        data = StateSingleton.getInstance().getPlayerDataAnalysis();
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int execution = Integer.parseInt(enterExecutionScoreTextField.getText());
                    p.setExecution(execution);
                }
                catch(NumberFormatException e1){
                    setExceptionThrown(true);
                    enterExecutionScoreTextField.setText(errorMessage);
                }
                try{
                    int control= Integer.parseInt(enterControlScoreTextField.getText());
                    p.setControl(control);
                }
                catch (NumberFormatException e1){
                    setExceptionThrown(true);
                    enterControlScoreTextField.setText(errorMessage);

                }
                try{
                    int choreography = Integer.parseInt(enterChoreographyScoreTextField.getText());
                    p.setChoreography(choreography);
                }
                catch (NumberFormatException e1){
                    setExceptionThrown(true);
                    enterChoreographyScoreTextField.setText(errorMessage);

                }
                try{
                    int bodyControl = Integer.parseInt(enterBodyControlScoreTextField.getText());
                    p.setBodyControl(bodyControl);
                }
                catch(NumberFormatException e1){
                    setExceptionThrown(true);
                    enterBodyControlScoreTextField.setText(errorMessage);
                }
                StateSingleton.getInstance().setPlayer(p);

                String playerSaveLocation = p.getPlayerSaveLocation();
                String dataSaveLocation = p.getDataSaveLocation();
                data.callAllDataAnalysis();
////              String playerSaveLocation = p.getFirstName() + "_" + p.getLastName() + "_" + p.getRoutineType() + "_" + "Player.csv";
//                String dataSaveLocation = p.getFirstName() + "_" + p.getLastName() + "_" + p.getRoutineType() + "_" + "PlayerDataAnalysis.csv";
                try {
                    p.save(playerSaveLocation);
                } catch (IOException e1) {
                    System.out.println(e1.getMessage());
                }
                try {
                    data.save(dataSaveLocation);
                } catch (IOException e1) {
                    System.out.println(e1.getMessage());
                }
                if (getExceptionThrown()){
                    setExceptionThrown(false);
                }
                else{
                    nextPanel();
                }
            }
        });
    }

    private void createUIComponents() {
        enterExecutionScoreLabel = new JLabel();
        enterExecutionScoreLabel.setToolTipText(EXECUTIONDESCRIPTION);
        enterControlScoreLabel = new JLabel();
        enterControlScoreLabel.setToolTipText(CONTROlDESCRIPTION);
        enterBodyControlScoreLabel = new JLabel();
        enterBodyControlScoreLabel.setToolTipText(BODYCONTROlDESCRIPTION);
        enterChoreographyScoreLabel = new JLabel();
        enterChoreographyScoreLabel.setToolTipText(CHOREOGRAPHYDESCRIPTION);
    }
}
