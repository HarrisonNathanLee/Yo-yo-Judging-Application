package App.ui;

import App.Exceptions.IncorrectUserInputException;
import App.player.Player;
import App.player.PlayerDataAnalysis;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class IndividualStrategy implements AppStrategy {
    private Main yyjh;

    Scanner scanner = new Scanner(System.in);
    private JPanel panelIndividual;
    private JButton startButton;
    private JButton loadButton;

    public void panelSetUp(){
        JFrame frame = new JFrame("Yo-yo Judge Application");
        frame.setContentPane(new IndividualStrategy().panelIndividual);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public IndividualStrategy() {
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String choice = scanner.nextLine();
                String routineType = null;
                try {
                    routineType = retrieveRoutineType(choice);
                } catch (IncorrectUserInputException e1) {
                    System.out.println(e1.getMessage());
                }
                try {
                    yyjh.start(routineType);
                } catch (IOException e1) {
                    System.out.println(e1.getMessage());
                    individualMode(yyjh = new Main());
                }
            }
        });
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = retrieveJudgedPlayerName();
                String routineType = null;
                try {
                    routineType = retrieveRoutineType("load");
                } catch (IncorrectUserInputException e1) {
                    System.out.println(e1.getMessage());
                }
                try {
                    individualModeRead(firstName,routineType);
                } catch (IOException e1) {
                    System.out.println(e1.getMessage());
                }
            }
        });
    }

    public void callMode(){
        JFrame frame = new JFrame("Yo-yo Judge Application");
        frame.setContentPane(new IndividualStrategy().panelIndividual);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        individualMode(yyjh = new Main());
    }

    //MODIFIES: This, Player, PlayerDataAnalysis, App.Competition, CompetitionDataAnalysis
    //EFFECTS: Runs the application in individual mode (judge an individual player)
    public void individualMode(Main yyjh){
        System.out.println("Type start to start judging a player or load to load from memory");
        String choice = scanner.nextLine();
        if (choice.equals("start")) {
            try {
                try {
                    String routineType = retrieveRoutineType(choice);
                    yyjh.start(routineType);
                } catch (IncorrectUserInputException e) {
                    System.out.println(e.getMessage());
                    individualMode(yyjh = new Main());
                }
            } catch (IOException e) {
                System.out.println("Data save problem");
            }
        }
        else if (choice.equals("load")) {
            String firstName = retrieveJudgedPlayerName();
            String routineType = null;
            try {
                routineType = retrieveRoutineType(choice);
            } catch (IncorrectUserInputException e) {
                System.out.println(e.getMessage());
                individualMode(yyjh = new Main());
            }
            try {
                individualModeRead(firstName, routineType);
            }
            catch (IOException e) {
                System.out.println("Player name and routine type combination inputted is not saved in memory");
            }
        }
    }


    //EFFECTS: asks user for a player who has already been judged
    public String retrieveJudgedPlayerName(){
        System.out.println("Type in the name of a player who has already been judged");
        String firstName = scanner.nextLine();
        return firstName;
    }

    //EFFECTS: Reads from memory
    public void individualModeRead(String firstName, String routineType) throws IOException {
        PlayerDataAnalysis data = yyjh.createPlayerSubtype(routineType);
        Player p = data.getPlayer();
        p.load(firstName + "_" + routineType + "_player.csv");
        data.load(firstName + "_" + routineType + "_playerDataAnalysis.csv");
    }


    //EFFECTS: Will gather the routineType of the player from user input
    public String retrieveRoutineType(String choice) throws IncorrectUserInputException {
        ArrayList<String> routineTypes = new ArrayList<>();
        routineTypes.add("Wildcard");
        routineTypes.add("Prelim");
        routineTypes.add("Semi");
        routineTypes.add("Two Minute Final");
        routineTypes.add("World Final");
        if (choice.equals("start")) {
            System.out.println("Input the routine type (Wildcard, Prelim, Semi, Two Minute Final, World Final): ");
        }
        if (choice.equals("load")) {
            System.out.println("Type in the routine type(Wildcard, Prelim, Semi, Two Minute Final, World Final) of the player you would like to view");
        }
        if (choice.equals("competition")) {
            System.out.println("What type of competition is it? (Wildcard, Prelim, Semi, Two Minute Final, World Final)");
        }
        String routineChoice = scanner.nextLine();
        if(routineTypes.contains(routineChoice)) {
            return routineChoice;
        }
        else{
            throw new IncorrectUserInputException("You inputted an invalid routine type");
        }
    }
}
