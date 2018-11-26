package App.ui;

import App.Model.StateSingleton;
import App.player.Player;
import App.player.PlayerDataAnalysis;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class WildcardClicker extends ClickerTimer implements UpdatePanel{
    private JPanel panelWildcardClicker;
    private JLabel numberPositiveClicksJLabel;
    private JLabel timeRemainingLabel;
    private JFrame frame;
    private Player p;
    private PlayerDataAnalysis data;

    public WildcardClicker(JFrame frame){
        this.frame = frame;
        p = StateSingleton.getInstance().getPlayer();
        data = StateSingleton.getInstance().getPlayerDataAnalysis();
        startTimer(p.getRoutineLength(),timeRemainingLabel,p);
        panelWildcardClicker.setFocusable(true);
        panelWildcardClicker.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_J) {
                    p.awardClick();
                    numberPositiveClicksJLabel.setText(String.valueOf(p.getPositiveClicks()));
                    StateSingleton.getInstance().setPlayer(p);
                    System.out.println("+1");
                } else if (e.getKeyCode() == KeyEvent.VK_H) {
                    p.doubleClick();
                    numberPositiveClicksJLabel.setText(String.valueOf(p.getPositiveClicks()));
                    StateSingleton.getInstance().setPlayer(p);
                } else if (e.getKeyCode() == KeyEvent.VK_I) {
                    p.resetClicks();
                    data.resetFireTilt();
                    numberPositiveClicksJLabel.setText(String.valueOf(p.getPositiveClicks()));
                    StateSingleton.getInstance().setPlayer(p);
                    StateSingleton.getInstance().setPlayerDataAnalysis(data);
                } else if (e.getKeyCode() == KeyEvent.VK_S) {
                    p.produceClickerScore();
                    System.out.println(p.getClickerScore());
                    StateSingleton.getInstance().setPlayer(p);
                    String playerSaveLocation = p.getPlayerSaveLocation();
                    String dataSaveLocation = p.getDataSaveLocation();
//                    String playerSaveLocation = p.getFirstName() + "_" + p.getLastName() + "_" + p.getRoutineType() + "_" + "Player.csv";
//                    String dataSaveLocation = p.getFirstName() + "_" + p.getLastName() + "_" + p.getRoutineType() + "_" + "PlayerDataAnalysis.csv";
                    try {
                        p.save(playerSaveLocation);
                    } catch (IOException e1) {
                        System.out.println(e1.getMessage());
                    }
                    try {
                        data.save(dataSaveLocation);
                    } catch (IOException e1) {
                        System.out.println(e1.getMessage());
                    }
                    nextPanel();
                }
            }
        });
    }


    @Override
    public JPanel getPanel() {
        return panelWildcardClicker;
    }

    @Override
    public void nextPanel(){
        frame.remove(panelWildcardClicker);
        frame.setContentPane(new IndividualModeOutput(frame).getPanel());
        frame.setVisible(true);

    }
}
