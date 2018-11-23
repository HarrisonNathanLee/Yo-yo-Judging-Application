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
    private JPanel firstPanel;
    private JLabel positiveClicksLabel;
    private JLabel negativeClicksLabel;
    private JButton button1;
    private JPanel next;
    CardLayout card = (CardLayout)panelClicker.getLayout();

    public Clicker(){

        firstPanel.setFocusable(true);
        firstPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                Player p = StateSingleton.getInstance().getPlayer();

                if (e.getKeyCode()== KeyEvent.VK_F) {
                    p.removeClick();
                    negativeClicksLabel.setText(String.valueOf(p.getNegativeClicks()));
                    StateSingleton.getInstance().setPlayer(p);
                    System.out.println("+1");
                } else if (e.getKeyCode() == KeyEvent.VK_J) {
                    p.awardClick();
                    positiveClicksLabel.setText(String.valueOf(p.getPositiveClicks()));
                    StateSingleton.getInstance().setPlayer(p);
                    System.out.println("-1");
                } else if (e.getKeyCode() == KeyEvent.VK_H) {
                    p.doubleClick();
                    positiveClicksLabel.setText(String.valueOf(p.getPositiveClicks()));
                    StateSingleton.getInstance().setPlayer(p);
                } else if (e.getKeyCode() == KeyEvent.VK_Q) {
                    p.restart();
                    StateSingleton.getInstance().setPlayer(p);
                } else if (e.getKeyCode() == KeyEvent.VK_W) {
                    p.change();
                    StateSingleton.getInstance().setPlayer(p);
                } else if (e.getKeyCode() == KeyEvent.VK_E) {
                    p.discard();
                    StateSingleton.getInstance().setPlayer(p);
                } else if (e.getKeyCode() == KeyEvent.VK_I) {
                    p.resetClicks();
                    data.resetFireTilt();
                    negativeClicksLabel.setText(String.valueOf(p.getNegativeClicks()));
                    positiveClicksLabel.setText(String.valueOf(p.getPositiveClicks()));
                    StateSingleton.getInstance().setPlayer(p);
                    StateSingleton.getInstance().setPlayerDataAnalysis(data);
                } else if (e.getKeyCode() == KeyEvent.VK_O) {
                    p.resetMajorDeducts();
                    StateSingleton.getInstance().setPlayer(p);
                    StateSingleton.getInstance().setPlayerDataAnalysis(data);
                } else if (e.getKeyCode() == KeyEvent.VK_P) {
                    p.resetEverything();
                    data.resetFireTilt();
                    negativeClicksLabel.setText(String.valueOf(p.getNegativeClicks()));
                    positiveClicksLabel.setText(String.valueOf(p.getPositiveClicks()));
                    StateSingleton.getInstance().setPlayer(p);
                    StateSingleton.getInstance().setPlayerDataAnalysis(data);
                } else if (e.getKeyCode() == KeyEvent.VK_S) {
                    p.produceClickerScore();
                    System.out.println(p.getClickerScore());
                    StateSingleton.getInstance().setPlayer(p);
                }
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                next = new PlayerInformation().getPanel();
                card.addLayoutComponent(next,"card4");
                card.show(panelClicker,"card4");
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
    private void createUIComponents() {
        positiveClicksLabel = new JLabel();
        negativeClicksLabel = new JLabel();
      //next = new PlayerInformation().getPanel();
    }
}
