package App.ui;

import App.Competition.Competition;
import App.Exceptions.AlreadyInCompetitionException;
import App.Model.StateSingleton;
import App.player.*;

import javax.swing.*;
import javax.swing.plaf.nimbus.State;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import App.Model.Factory;

public class PlayerInformationCompetition implements UpdatePanel {

    private JFrame frame;
    private JPanel panelPlayerInformationCompetition;
    private JTextField firstNameTextField;
    private JTextField lastNameTextField;
    private JButton submitButton;
    private Player p;
    private PlayerDataAnalysis data;
    private Competition c;
    private Factory f = new Factory();
    private String playerAlreadyInComp = "Inputted player has already been judged";

    public Boolean getExceptionThrown() {
        return exceptionThrown;
    }

    public void setExceptionThrown(Boolean exceptionThrown) {
        this.exceptionThrown = exceptionThrown;
    }

    private Boolean exceptionThrown = false;

    public PlayerInformationCompetition(JFrame frame){
        this.frame = frame;
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c = StateSingleton.getInstance().getCompetition();
                String firstName = firstNameTextField.getText();
                String lastName = lastNameTextField.getText();
                try {
                    alreadyInCompetitionCheck(c,firstName,lastName);
                } catch (AlreadyInCompetitionException e1) {
                    setExceptionThrown(true);
                    firstNameTextField.setText(playerAlreadyInComp);
                    lastNameTextField.setText(playerAlreadyInComp);
                }
                String routineType = StateSingleton.getInstance().getCompetition().getCompetitionRoutineType();
                String division = StateSingleton.getInstance().getCompetition().getCompetitionDivision();
                data = f.createPlayerAndDataSubtype(routineType);
                p = data.getPlayer();
                c.addPlayer(p);
                c.addPlayerDataAnalysis(data);
                p.setFirstName(firstName);
                p.setLastName(lastName);
                p.setRoutineType(routineType);
                p.setDivision(division);
                StateSingleton.getInstance().setPlayer(p);
                StateSingleton.getInstance().setPlayerDataAnalysis(data);
                if(getExceptionThrown()){
                    setExceptionThrown(false);
                }
                else{
                    nextPanel();
                }
            }
        });
    }



    public JPanel getPanel() {
        return panelPlayerInformationCompetition;
    }

    public void alreadyInCompetitionCheck(Competition c, String firstName, String lastName) throws AlreadyInCompetitionException {
        for (Player p: c.getPlayers()){
            if(p.getFirstName().equals(firstName)& p.getLastName().equals(lastName)){
                throw new AlreadyInCompetitionException("Player has already been judged");
            }
        }
    }

    @Override
    public void nextPanel() {
        if (StateSingleton.getInstance().getPlayer().getRoutineType().equals("Wildcard")){
            frame.remove(panelPlayerInformationCompetition);
            frame.setContentPane(new WildcardClicker(frame).getPanel());
            frame.setVisible(true);
        }
        else {
            frame.remove(panelPlayerInformationCompetition);
            frame.setContentPane(new Clicker(frame).getPanel());
            frame.setVisible(true);
        }

    }
}
