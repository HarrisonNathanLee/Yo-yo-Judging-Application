package App.ui;

import javax.swing.*;
import java.awt.*;

public class JustForFun {
    private JPanel JPanel;
    private JButton JButton1Button;
    private JButton JButton2Button;
    private JButton JButton3Button;
    private JPanel PanelOne;
    private JPanel panelContainer;
    private JPanel PanelTwo;
    private JPanel PanelThree;


    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable()){
            public void run(){
                new JustForFun();
                CardLayout card = (CardLayout)panelContainer.getLayout();
                card.show(panelContainer, "panelStart");
            }
        }



    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
