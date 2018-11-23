package App.ui;

import App.player.Player;
import App.player.WildcardPlayer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class IndividualLoad {
    private JTextField firstNameTextField;
    private JTextField routineTypeTextField;
    private JButton submitButton;
    private JPanel panelIndividualLoad;

    public IndividualLoad (){
        Player p = new WildcardPlayer();

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = firstNameTextField.getText();
                String routineType = routineTypeTextField.getText();
                try {
                    p.load(firstName + "_" + routineType + "_player.csv");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }



    public JPanel getPanel(){
        return panelIndividualLoad;
    }

}
