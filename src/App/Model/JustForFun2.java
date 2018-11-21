package App.Model;

import App.ui.JustForFun;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JustForFun2 {
    JFrame frame = new JFrame("Yo-yo judge card layout");
    JPanel panelContainer = new JPanel();
    JPanel panelFirst = new JPanel();
    JPanel panelSecond = new JPanel();
    JPanel panelThird = new JPanel();
    JButton buttonOne = new JButton("Switch to second panel");
    JButton buttonSecond = new JButton("Switch to third panel");
    JButton buttonThird = new JButton("Switch to first panel");
    CardLayout cl = new CardLayout();


    public JustForFun2(){
        panelContainer.setLayout(cl);
        panelFirst.add(buttonOne);
        panelSecond.add(buttonSecond);
        panelThird.add(buttonThird);
        panelFirst.setBackground(Color.BLUE);
        panelSecond.setBackground(Color.GRAY);
        panelThird.setBackground(Color.GREEN);
        panelContainer.add(panelFirst,"1");
        panelContainer.add(panelSecond,"2");
        panelContainer.add(panelThird,"3");
        cl.show(panelContainer, "1");

        buttonOne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(panelContainer,"2");
            }
        });

        buttonSecond.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(panelContainer,"3");
            }
        });
        buttonThird.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(panelContainer,"1");
            }
        });
        frame.add(panelContainer);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run(){
                new JustForFun2();
            }
            });
    }
}
