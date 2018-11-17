package App.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;

public class MainFrame extends JFrame {

    Scanner scanner = new Scanner(System.in);


    public MainFrame(String title) {
        super(title);

        // Set layout manager
        setLayout(new BorderLayout());

        // Create swing component
        final JTextArea textArea = new JTextArea();
        JButton button = new JButton("Press f - Increment player score by one");

        // Add Swing components to content pane
        Container c = getContentPane();
        c.add(textArea, BorderLayout.CENTER);
        c.add(button, BorderLayout.SOUTH);

        // Add behaviour

        String keyPress = "";

        button.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                // not using this method
            }
            //called when your button is clicked

        });
    }
}
