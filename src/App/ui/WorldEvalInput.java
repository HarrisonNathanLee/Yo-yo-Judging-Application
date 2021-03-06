package App.ui;

import App.Model.StateSingleton;
import App.player.Player;
import App.player.PlayerDataAnalysis;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static App.player.Player.*;

public class WorldEvalInput implements UpdatePanel{
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
    private JLabel enterExecutionScoreLabel;
    private JLabel enterControlScoreLabel;
    private JLabel enterTrickDiversityScoreLabel;
    private JLabel enterSpaceUseAndLabel;
    private JLabel enterChoreographyScoreLabel;
    private JLabel enterConstructionScoreLabel;
    private JLabel enterBodyControlScoreLabel;
    private JLabel enterShowmanshipScoreLabel;
    private JFrame frame;
    private String errorMessage = "Please input an integer between 1 and 10";

    public Boolean getExceptionThrown() {
        return exceptionThrown;
    }

    public void setExceptionThrown(Boolean exceptionThrown) {
        this.exceptionThrown = exceptionThrown;
    }

    private Boolean exceptionThrown = false;
    public JPanel getPanel() {
        return panelWorldEvalInput;
    }

    public WorldEvalInput (JFrame frame){
        this.frame = frame;
        Player p = StateSingleton.getInstance().getPlayer();
        PlayerDataAnalysis data = StateSingleton.getInstance().getPlayerDataAnalysis();
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int execution = Integer.parseInt(enterExecutionScoreTextField.getText());
                    p.setExecution(execution);

                }
                catch(NumberFormatException e1){
                    setExceptionThrown(true);
                    enterExecutionScoreTextField.setText(errorMessage);

                }
                try{
                    int control = Integer.parseInt(enterControlScoreTextField.getText());
                    p.setControl(control);
                }
                catch(NumberFormatException e1){
                    setExceptionThrown(true);
                    enterControlScoreTextField.setText(errorMessage);


                }
                try{
                    int bodyControl = Integer.parseInt(enterBodyControlScoreTextField.getText());
                    p.setBodyControl(bodyControl);
                }
                catch(NumberFormatException e1){
                    setExceptionThrown(true);
                    enterBodyControlScoreTextField.setText(errorMessage);

                }
                try{
                    int showmanship = Integer.parseInt(enterShowmanshipScoreTextField.getText());
                    p.setShowmanship(showmanship);

                }
                catch(NumberFormatException e1){
                    setExceptionThrown(true);
                    enterShowmanshipScoreTextField.setText(errorMessage);

                }
                try{
                    int spaceUseAndEmphasis = Integer.parseInt(enterSpaceUseAndTextField.getText());
                    p.setSpaceUseAndEmphasis(spaceUseAndEmphasis);

                }
                catch(NumberFormatException e1){
                    setExceptionThrown(true);
                    enterSpaceUseAndTextField.setText(errorMessage);

                }
                try{
                    int choreograhpy = Integer.parseInt(enterChoreographyScoreTextField.getText());
                    p.setChoreography(choreograhpy);

                }
                catch(NumberFormatException e1){
                    setExceptionThrown(true);
                    enterChoreographyScoreTextField.setText(errorMessage);

                }
                try{
                    int construction = Integer.parseInt(enterConstructionScoreTextField.getText());
                    p.setConstruction(construction);

                }
                catch(NumberFormatException e1){
                    setExceptionThrown(true);
                    enterConstructionScoreTextField.setText(errorMessage);

                }
                try{
                    int trickDiversity = Integer.parseInt(enterTrickDiversityScoreTextField.getText());
                    p.setTrickDiversity(trickDiversity);

                }
                catch(NumberFormatException e1){
                    setExceptionThrown(true);
                    enterTrickDiversityScoreTextField.setText(errorMessage);

                }
                StateSingleton.getInstance().setPlayer(p);
                String playerSaveLocation = p.getPlayerSaveLocation();
                String dataSaveLocation = p.getDataSaveLocation();
                data.callAllDataAnalysis();
//                String playerSaveLocation = p.getFirstName() + "_" + p.getLastName() + "_" + p.getRoutineType() + "_" + "Player.csv";
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
                if(exceptionThrown){
                   setExceptionThrown(false);
                }
                else{
                    nextPanel();
                }
            }
        });
    }

    public void nextPanel(){
        frame.remove(panelWorldEvalInput);
        frame.setContentPane(new IndividualModeOutput(frame).getPanel());
        frame.setVisible(true);
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
        enterShowmanshipScoreLabel = new JLabel();
        enterShowmanshipScoreLabel.setToolTipText(SHOWMANSHIPDESCRIPTION);
        enterSpaceUseAndLabel = new JLabel();
        enterSpaceUseAndLabel.setToolTipText(SPACEUSEANDEMPHASISDESCRIPTION);
        enterTrickDiversityScoreLabel = new JLabel();
        enterTrickDiversityScoreLabel.setToolTipText(TRICKDIVERSITYDESCRIPTION);
        enterConstructionScoreLabel = new JLabel();
        enterConstructionScoreLabel.setToolTipText(CONSTRUCTIONDESCRIPTION);
    }
}
