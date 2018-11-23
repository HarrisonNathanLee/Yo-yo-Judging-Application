package App.ui;

import App.Model.ObjectContainer;
import App.Model.StateSingleton;
import App.player.*;

import App.player.PlayerDataAnalysis;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PickRoutineType{
    private JPanel panelPickRoutineType;
    private JButton worldFinalButton;
    private JButton prelimButton;
    private JButton wildcardButton;
    private JButton twoMinuteFinalButton;
    private JButton semiFinalButton;
    private JPanel panelPlayerInformation;
    private Player p;
    private PlayerDataAnalysis data;
    CardLayout card = (CardLayout)panelPickRoutineType.getLayout();

    public JPanel getPanel(){
        return panelPickRoutineType;
    }


    public PickRoutineType() {
        card.addLayoutComponent(panelPlayerInformation,"card2");
        wildcardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                data = createPlayerSubtype("Wildcard");
                p = data.getPlayer();
                p.setRoutineType("Wildcard");
                StateSingleton.getInstance().setPlayer(p);
                card.show(panelPickRoutineType,"card2");
            }
        });
        prelimButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                data = createPlayerSubtype("Prelim");
                p = data.getPlayer();
                p.setRoutineType("Prelim");
                StateSingleton.getInstance().setPlayer(p);
                card.show(panelPickRoutineType,"card2");

            }
        });
        semiFinalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                data = createPlayerSubtype("Semi");
                p = data.getPlayer();
                p.setRoutineType("Semi");
                StateSingleton.getInstance().setPlayer(p);
                card.show(panelPickRoutineType,"card2");

            }
        });
        twoMinuteFinalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                data = createPlayerSubtype("Two Minute Final");
                p = data.getPlayer();
                p.setRoutineType("Two Minute Final");
                StateSingleton.getInstance().setPlayer(p);
                card.show(panelPickRoutineType,"card2");

            }
        });
        worldFinalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                data = createPlayerSubtype("World Final");
                p = data.getPlayer();
                p.setRoutineType("World Final");
                StateSingleton.getInstance().setPlayer(p);
                card.show(panelPickRoutineType,"card2");
            }
        });
    }

    //MODIFIES: This, Player
    //EFFECTS: Creates player and playerDataAnalysis subtypes depending on user-inputted routineType
    public PlayerDataAnalysis createPlayerSubtype(String routineType) {
        if (routineType.equals("Wildcard")) {
            WildcardPlayer p = new WildcardPlayer();
            WildcardPlayerDataAnalysis data = new WildcardPlayerDataAnalysis(p);
            return data;
        } else if (routineType.equals("Prelim") || routineType.equals("Semi") || routineType.equals("Two Minute Final")) {
            PrelimTwoSemiPlayer p = new PrelimTwoSemiPlayer();
            PrelimTwoSemiPlayerDataAnalysis data = new PrelimTwoSemiPlayerDataAnalysis(p);
            return data;
        } else if (routineType.equals("World Final")) {
            WorldFinalPlayer p = new WorldFinalPlayer();
            WorldFinalPlayerDataAnalysis data = new WorldFinalPlayerDataAnalysis(p);
            return data;
        }
        return null;
    }


    private void createUIComponents() {
        panelPlayerInformation = new PlayerInformation().getPanel();
    }
}
