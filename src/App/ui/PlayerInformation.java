package App.ui;

import App.Model.ObjectContainer;
import App.Model.StateSingleton;
import App.player.Player;
import App.player.PlayerDataAnalysis;
import javafx.scene.layout.Pane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerInformation {
    private JPanel panelPlayerInformation;
    private JTextField firstNameTextField;
    private JTextField lastNameTextField;
    private JTextField divisionTextField;
    private JLabel firstNameJLabel;
    private JLabel lastNameJLabel;
    private JLabel divisionJLabel;
    private JButton submitButton;
    private JFrame frame;

    public PlayerInformation(JFrame frame) {
        this.frame = frame;
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Player p = StateSingleton.getInstance().getPlayer();
                String firstName = firstNameTextField.getText();
                String lastName = lastNameTextField.getText();
                String division = divisionTextField.getText();
                p.setFirstName(firstName);
                p.setLastName(lastName);
                p.setDivision(division);
                StateSingleton.getInstance().setPlayer(p);
                System.out.println(firstName);
                System.out.println(lastName);
                System.out.println(division);
                System.out.println(StateSingleton.getInstance().getPlayer().getRoutineType());
                if (p.getRoutineType().equals("Wildcard")){
                    frame.remove(panelPlayerInformation);
                    frame.setContentPane(new WildcardClicker(frame).getPanel());
                    frame.setVisible(true);
                }
                else{
                    frame.remove(panelPlayerInformation);
                    frame.setContentPane(new Clicker(frame).getPanel());
                    frame.setVisible(true);
                }
            }
        });
    }

    public JPanel getPanel() {
        return panelPlayerInformation;
    }

}


