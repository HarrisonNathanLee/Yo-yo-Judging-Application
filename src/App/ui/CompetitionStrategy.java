
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

    //MODIFIES: This, Player, PlayerDataAnalysis, Competition, CompetitionDataAnalysis
    //EFFECTS: Runs the application in competition mode (judge multiple players sequentially)
    public void competitionMode(Main yyjh) throws IOException, AlreadyInCompetitionException {
        Scanner scanner = new Scanner(System.in);
        Competition c = new Competition();
        CompetitionDataAnalysis cData;
        System.out.println("Type start to start judging a competition or load to load competition data from memory");
        String startOrRead = scanner.nextLine();
        if (startOrRead.equals("start")) {
            cData = getCompetitionDataAnalysis(yyjh, c);
            String competitionName = setCompetitionNameFromUserInput(c);
            judgePlayersSequentially(c,cData,yyjh,competitionName);
        }
        else if (startOrRead.equals("load")) {
            cData = getCompetitionDataAnalysis(yyjh,c);
            String routineType = c.getCompetitionRoutineType();
            competitionModLoad(c,cData, routineType);
        }
    }

    //MODIFIES: This
    //EFFECTS: returns a specific type of competition data analysis
    private CompetitionDataAnalysis getCompetitionDataAnalysis(Main yyjh, Competition c) throws IOException, AlreadyInCompetitionException {
        CompetitionDataAnalysis cData;
        String routineType = null;
        try {
            routineType = retrieveRoutineType("competition");
            c.setCompetitionRoutineType(routineType);
        } catch (IncorrectUserInputException e) {
            System.out.println(e.getMessage());
            competitionMode(yyjh);
        }
        cData = createCompetitionDataAnalysisSubtype(routineType, c);
        return cData;
    }

    //MODIFIES: This
    //EFFECTS: sets the competition name based on user input
    public static String setCompetitionNameFromUserInput(Competition c){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the name of the competition you are judging");
        String competitionName = scanner.nextLine();
        c.setCompetitionName(competitionName);
        return competitionName;
    }

    //MODIFIES This
    //EFFECTS: loads competition information from memory
    public void competitionModLoad(Competition c, CompetitionDataAnalysis cData, String routineType) throws IOException {
        System.out.println("What competition would you like to load from memory?");
        String competitionName = scanner.nextLine();
        c.load(competitionName+routineType);
        cData.load(competitionName+routineType);
    }


    //EFFECTS: Factory - creates competition data analysis subtype based on user input
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

    //MODIFIES This, player, playerDataAnaysis, competitonDataAnalysis, competition
    //EFFECTS: will judge numerous players sequentially
    public void judgePlayersSequentially (Competition c, CompetitionDataAnalysis cData, Main yyjh, String competitionName) throws IOException {
        while (true) {
            String routineType = c.getCompetitionRoutineType();
            PlayerDataAnalysis data = yyjh.start(routineType);
            c.addPlayerDataAnalysis(data);
            Player p = data.getPlayer();
            c.addPlayer(p);
            String anotherPlayer = anotherPlayer();
            if (anotherPlayer.equals("yes")) {
            }
            if (anotherPlayer.equals("no")) {
                cData.callAllDataAnalysis();
                c.addSortPrintHMAP();
                cData.printAnalyzedCompetitionInformation(cData);
                c.save(competitionName+routineType);
                cData.save(competitionName+routineType);
                break;
            }
        }
    }

    //EFFECTS: asks user if another player still has to be judged
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
