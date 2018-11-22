package App.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import App.ui.*;

public class StartOrLoad {
    private JButton startButton;
    private JButton loadButton;
    public JPanel panelStartOrLoad;

    public StartOrLoad() {
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public JPanel getPanel(){
        return panelStartOrLoad;
    }
}
