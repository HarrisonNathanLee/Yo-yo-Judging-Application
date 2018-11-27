package App.ui;

import App.Model.StateSingleton;
import App.player.Player;
import App.player.PlayerDataAnalysis;
import javafx.scene.layout.Pane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerInformation implements UpdatePanel{
    private JPanel panelPlayerInformation;
    private JTextField firstNameTextField;
    private JTextField lastNameTextField;
    private JLabel firstNameJLabel;
    private JLabel lastNameJLabel;
    private JButton submitButton;
    private JComboBox divisionComboBox;
    private JFrame frame;

    public PlayerInformation(JFrame frame) {
        this.frame = frame;
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Player p = StateSingleton.getInstance().getPlayer();
                String firstName = firstNameTextField.getText();
                String lastName = lastNameTextField.getText();
                String division = divisionComboBox.getSelectedItem().toString();
                p.setFirstName(firstName);
                p.setLastName(lastName);
                p.setDivision(division);
                StateSingleton.getInstance().setPlayer(p);
                System.out.println(firstName);
                System.out.println(lastName);
                System.out.println(division);
                System.out.println(StateSingleton.getInstance().getPlayer().getRoutineType());
                nextPanel();
            }
        });
    }

    public JPanel getPanel() {
        return panelPlayerInformation;
    }

    @Override
    public void nextPanel() {
        JPanel panel;
        if (StateSingleton.getInstance().getPlayer().getRoutineType().equals("Wildcard")){
            panel = new WildcardClicker(frame).getPanel();

        }
        else{
            panel = new Clicker(frame).getPanel();
        }
        frame.remove(panelPlayerInformation);
        frame.setContentPane(panel);
        panel.grabFocus();
        frame.setVisible(true);

    }

}


