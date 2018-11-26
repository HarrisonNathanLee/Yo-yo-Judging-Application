package App.ui;

import App.Model.StateSingleton;
import App.player.Player;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class ClickerTimer implements UpdatePanel{

    protected Timer stopwatch;
    protected int count;
    protected int delay = 1000;

    public void startTimer(int countPassed, JLabel labelToUpdate, Player p) {
        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (count == 0) {
                    stopwatch.stop();
                    StateSingleton.getInstance().setPlayer(p);
                    nextPanel();
                } else {
                    labelToUpdate.setText("Seconds remaining: " + count);
                    count--;
                }
            }
        };
        stopwatch = new Timer(delay, action);
        stopwatch.setInitialDelay(0);
        stopwatch.start();
        count = countPassed;
    }

}
