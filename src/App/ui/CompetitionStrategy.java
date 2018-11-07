
package App.ui;

import App.Competition.*;
import App.Exceptions.AlreadyInCompetitionException;
import App.Exceptions.IncorrectUserInputException;
import App.player.Player;
import App.player.PlayerDataAnalysis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CompetitionStrategy implements AppStrategy {
    Scanner scanner = new Scanner(System.in);
    private Main yyjh;

    @Override
    public void callMode() throws IOException, AlreadyInCompetitionException {
        competitionMode(yyjh = new Main());

    }

    //MODIFIES: This, Player, PlayerDataAnalysis, App.Competition, CompetitionDataAnalysis
    //EFFECTS: Runs the application in competition mode (judge multiple players sequentially)
    public void competitionMode(Main yyjh) throws IOException, AlreadyInCompetitionException {
        Scanner scanner = new Scanner(System.in);
        Competition c = new Competition();
        CompetitionDataAnalysis cData;
        System.out.println("Type start to start judging a competition or load to load competition data from memory");
        String startOrRead = scanner.nextLine();
        if (startOrRead.equals("start")) {
            String routineType = null;
            try {
                routineType = retrieveRoutineType("competition");
            } catch (IncorrectUserInputException e) {
                System.out.println(e.getMessage());
                competitionMode(yyjh);
            }
            cData = createCompetitionDataAnalysisSubtype(routineType, c);
            String competitionName = setCompetitionNameFromUserInput(c);
            judgePlayersSequentially(c,cData,yyjh,competitionName,routineType);
        }
        else if (startOrRead.equals("load")) {
            String routineType = null;
            try {
                routineType = retrieveRoutineType("competition");
            } catch (IncorrectUserInputException e) {
                System.out.println(e.getMessage());
                competitionMode(yyjh);
            }
            cData = createCompetitionDataAnalysisSubtype(routineType, c);
            competitionModeRead(c,cData);
        }
    }


    public static String setCompetitionNameFromUserInput(Competition c){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the name of the competition you are judging");
        String competitionName = scanner.nextLine();
        c.setCompetitionName(competitionName);
        return competitionName;
    }

    public void competitionModeRead(Competition c, CompetitionDataAnalysis cData) throws IOException {
        System.out.println("What competition would you like to load from memory?");
        String competitionName = scanner.nextLine();
        c.load(competitionName);
        cData.load(competitionName);
    }


    public CompetitionDataAnalysis createCompetitionDataAnalysisSubtype(String routineType, Competition competition){
        if(routineType.equals("Wildcard")){
            WildcardCompetitionDataAnalysis cData = new WildcardCompetitionDataAnalysis(competition);
            return cData;
        }
        else if(routineType.equals("Prelim") || routineType.equals("Two Minute Final") || routineType.equals("Semi")){
            PrelimTwoSemiCompetitionDataAnalysis cData = new PrelimTwoSemiCompetitionDataAnalysis(competition);
            return cData;
        }

        else if(routineType.equals("Final")){
            WorldFinalCompetitionDataAnalysis cData = new WorldFinalCompetitionDataAnalysis(competition);
            return cData;
        }
        return null;
    }

    public void judgePlayersSequentially (Competition c, CompetitionDataAnalysis cData, Main yyjh, String competitionName, String routineType) throws IOException {
        while (true) {
            PlayerDataAnalysis data = yyjh.start(routineType);
            c.addPlayerDataAnalysis(data);
            Player p = data.getPlayer();
            c.addPlayer(p);
            String anotherPlayer = anotherPlayer();
            if (anotherPlayer.equals("yes")) {
            }
            if (anotherPlayer.equals("no")) {
                c.save(competitionName);
                cData.save(competitionName);
                cData.callAllDataAnalysis();
                cData.printAnalyzedCompetitionInformation(cData);
                break;
            }
        }
    }

    public String anotherPlayer(){
        System.out.println("Is there another player to judge in this competition yes or no");
        String anotherPlayer = scanner.nextLine();
        return anotherPlayer;
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
