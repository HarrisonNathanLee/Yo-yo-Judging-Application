package App.ui;

import App.Model.ObjectContainer;
import App.Model.StateSingleton;
import App.player.Player;
import App.player.PlayerDataAnalysis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static java.awt.event.KeyEvent.*;

public class Clicker extends ObjectContainer {
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
    private JFrame frame;

    public Clicker(JFrame frame){
        this.frame = frame;
        panelClicker.setFocusable(true);
        panelClicker.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                Player p = StateSingleton.getInstance().getPlayer();
                PlayerDataAnalysis data = StateSingleton.getInstance().getPlayerDataAnalysis();
                if (e.getKeyCode()== KeyEvent.VK_F) {
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
                    if (p.getRoutineType().equals("World Final")){
                        frame.remove(panelClicker);
                        frame.setContentPane(new WorldEvalInput(frame).getPanel());
                        frame.setVisible(true);

                    }
                    else {
                        frame.remove(panelClicker);
                        frame.setContentPane(new PrelimSemiTwoEvalInput(frame).getPanel());
                        frame.setVisible(true);
                    }
                }
            }
        });

    }

    public JPanel getPanel(){
        return panelClicker;
    }

    public void startRoutine(int n) {
        int timeDelay = 50; // msecs delay
        new Timer(timeDelay , new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("anything");
            }
        }).start();
    }
    
}
