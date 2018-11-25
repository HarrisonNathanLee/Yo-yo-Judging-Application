package App.ui;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class StartJudging {
    private JPanel panelStartJudging;
    private JFrame frame;


    public StartJudging(JFrame frame) {
        this.frame = frame;
        panelStartJudging.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    frame.remove(panelStartJudging);
                    frame.setContentPane(new Clicker(frame).getPanel());
                    frame.setVisible(true);
                }
            }
        });
    }
}
