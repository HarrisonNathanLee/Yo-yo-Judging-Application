package App.ui;

import App.Model.ObjectContainer;
import App.player.Player;
import App.player.PlayerDataAnalysis;
import javafx.scene.layout.Pane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerInformation extends ObjectContainer{
    private JPanel panelPlayerInformation;
    private JPanel firstPanel;
    private JTextField firstNameTextField;
    private JTextField lastNameTextField;
    private JTextField divisionTextField;
    private JButton submitButton;
    private JPanel panelWildcardClicker;
    private JPanel panelClicker;
    CardLayout card = (CardLayout)panelPlayerInformation.getLayout();

    public PlayerInformation() {
        card.addLayoutComponent(panelWildcardClicker,"card2");
        card.addLayoutComponent(panelClicker,"card3");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = firstNameTextField.getText();
                String lastName = lastNameTextField.getText();
                String division = divisionTextField.getText();
//                p.setFirstName(firstName);
//                p.setLastName(lastName);
//                p.setDivision(division);
//                String routineType = p.getRoutineType();
//                System.out.println(routineType);
                System.out.println(firstName);
                System.out.println(lastName);
                System.out.println(division);
                card.show(panelPlayerInformation, "card3");
            }
        });
    }

    public JPanel getPanel(){
        return panelPlayerInformation;
    }

    private void createUIComponents() {
        panelClicker = new Clicker().getPanel();
        panelWildcardClicker = new WildcardClicker().getPanel();
    }
}
