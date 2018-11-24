package App.ui;

import javax.swing.*;

public class Main2 {

    public static void main(String[] args) {
        JFrame j = new JFrame();

        j.setContentPane(new MainMenu(j).getPanel());
        j.setSize(500,500);
        j.setVisible(true);

    }
}
