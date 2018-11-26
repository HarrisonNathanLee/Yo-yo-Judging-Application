package App.ui;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame j = new JFrame();
        j.setContentPane(new MainMenu(j).getPanel());
        j.setSize(700,700);
        j.setVisible(true);

    }
}
