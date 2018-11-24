package App.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import App.ui.*;

public class StartOrLoad {
    private JButton startButton;
    private JButton loadButton;
    public JPanel panelStartOrLoad;
    private JFrame frame;
    //CardLayout card = (CardLayout)panelStartOrLoad.getLayout();

    public StartOrLoad(JFrame frame) {
        this.frame = frame;
        frame.setContentPane(panelStartOrLoad);
        frame.setVisible(true);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(panelStartOrLoad);
                frame.setContentPane(new PickRoutineType(frame).getPanel());
                frame.setVisible(true);
            }
        });
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(panelStartOrLoad);
                frame.setContentPane(new IndividualLoad(frame).getPanel());
                frame.setVisible(true);

            }
        });
    }

    public JPanel getPanel(){
        return panelStartOrLoad;
    }

}
