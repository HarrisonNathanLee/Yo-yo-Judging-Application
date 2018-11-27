package App.ui;
import App.Model.StateSingleton;
import App.player.Player;
import App.player.PlayerDataAnalysis;

import javax.swing.*;
import javax.swing.plaf.nimbus.State;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.security.Key;

import static java.awt.event.KeyEvent.*;
import javax.swing.KeyStroke;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.Action;

public class Clicker extends ClickerTimer implements UpdatePanel{
    private JPanel panelClicker;
    private JLabel numberPositiveClicksJLabel;
    private JLabel numberNegativeClicksJLabel;
    private JLabel positiveClicksJLabel;
    private JLabel numberRestartsJLabel;
    private JLabel restartsJLabel;
    private JLabel changesJLabel;
    private JLabel discardsJLabel;
    private JLabel numberChangesJLabel;
    private JLabel numberDiscardsJLabel;
    private JLabel timeRemainingLabel;
    private JFrame frame;
    private Player p;
    private PlayerDataAnalysis data;

    public Clicker(JFrame frame) {
        this.frame = frame;
        p = StateSingleton.getInstance().getPlayer();
        data = StateSingleton.getInstance().getPlayerDataAnalysis();
        startTimer(p.getRoutineLength(),timeRemainingLabel, p);
        panelClicker.setFocusable(true);
        panelClicker.isDisplayable();
        panelClicker.setVisible(true);
        panelClicker.requestFocus();
        panelClicker.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_F) {
                    p.removeClick();
                    numberNegativeClicksJLabel.setText(String.valueOf(p.getNegativeClicks()));
                    StateSingleton.getInstance().setPlayer(p);
                    System.out.println("+1");
                } else if (e.getKeyCode() == KeyEvent.VK_J) {
                    p.awardClick();
                    numberPositiveClicksJLabel.setText(String.valueOf(p.getPositiveClicks()));
                    StateSingleton.getInstance().setPlayer(p);
                    System.out.println("-1");
                } else if (e.getKeyCode() == KeyEvent.VK_H) {
                    p.doubleClick();
                    numberPositiveClicksJLabel.setText(String.valueOf(p.getPositiveClicks()));
                    StateSingleton.getInstance().setPlayer(p);
                } else if (e.getKeyCode() == KeyEvent.VK_Q) {
                    p.restart();
                    numberRestartsJLabel.setText(String.valueOf(p.getNumberOfRestarts()));
                    StateSingleton.getInstance().setPlayer(p);
                } else if (e.getKeyCode() == KeyEvent.VK_W) {
                    p.change();
                    numberChangesJLabel.setText(String.valueOf(p.getNumberOfChanges()));
                    StateSingleton.getInstance().setPlayer(p);
                } else if (e.getKeyCode() == KeyEvent.VK_E) {
                    p.discard();
                    numberDiscardsJLabel.setText(String.valueOf(p.getNumberOfDiscards()));
                    StateSingleton.getInstance().setPlayer(p);
                } else if (e.getKeyCode() == KeyEvent.VK_I) {
                    p.resetClicks();
                    data.resetFireTilt();
                    numberNegativeClicksJLabel.setText(String.valueOf(p.getNegativeClicks()));
                    numberPositiveClicksJLabel.setText(String.valueOf(p.getPositiveClicks()));
                    StateSingleton.getInstance().setPlayer(p);
                    StateSingleton.getInstance().setPlayerDataAnalysis(data);
                } else if (e.getKeyCode() == KeyEvent.VK_O) {
                    p.resetMajorDeducts();
                    numberRestartsJLabel.setText(String.valueOf(p.getNumberOfRestarts()));
                    numberChangesJLabel.setText(String.valueOf(p.getNumberOfChanges()));
                    numberDiscardsJLabel.setText(String.valueOf(p.getNumberOfDiscards()));
                    StateSingleton.getInstance().setPlayer(p);
                    StateSingleton.getInstance().setPlayerDataAnalysis(data);
                } else if (e.getKeyCode() == KeyEvent.VK_P) {
                    p.resetEverything();
                    data.resetFireTilt();
                    numberNegativeClicksJLabel.setText(String.valueOf(p.getNegativeClicks()));
                    numberPositiveClicksJLabel.setText(String.valueOf(p.getPositiveClicks()));
                    numberRestartsJLabel.setText(String.valueOf(p.getNumberOfRestarts()));
                    numberChangesJLabel.setText(String.valueOf(p.getNumberOfChanges()));
                    numberDiscardsJLabel.setText(String.valueOf(p.getNumberOfDiscards()));
                    StateSingleton.getInstance().setPlayer(p);
                    StateSingleton.getInstance().setPlayerDataAnalysis(data);
                } else if (e.getKeyCode() == KeyEvent.VK_S) {
                    p.produceClickerScore();
                    System.out.println(p.getClickerScore());
                    StateSingleton.getInstance().setPlayer(p);
                    nextPanel();

                }
            }
        });

    }


    public JPanel getPanel() {
        return panelClicker;
    }

    public void nextPanel(){
        p = StateSingleton.getInstance().getPlayer();
        if (p.getRoutineType().equals("World Final")) {
            frame.remove(panelClicker);
            frame.setContentPane(new WorldEvalInput(frame).getPanel());
            frame.setVisible(true);

        } else {
            frame.remove(panelClicker);
            frame.setContentPane(new PrelimSemiTwoEvalInput(frame).getPanel());
            frame.setVisible(true);
        }
    }

}
