package App.Model;

import App.Competition.*;
import App.player.*;

public class Factory {

    //EFFECTS: Factory - creates competition data analysis subtype based on user input
    public void createCompetitionAndCompetitionDataAnalysisSubtype(String routineType, Competition c, CompetitionDataAnalysis cData){
        c = new Competition();
        if(routineType.equals("Wildcard")){
            cData = new WildcardCompetitionDataAnalysis(c);
            c.setCompetitionRoutineType("Wildcard");
            StateSingleton.getInstance().setCompetition(c);
            StateSingleton.getInstance().setCompetitionDataAnalysis(cData);
        }
        else if(routineType.equals("Prelim") || routineType.equals("Two Minute Final") || routineType.equals("Semi")){
            cData = new PrelimTwoSemiCompetitionDataAnalysis(c);
            if (routineType.equals("Prelim")){
                c.setCompetitionRoutineType("Prelim");
            }
            else if(routineType.equals("Semi")){
                c.setCompetitionRoutineType("Semi");
            }
            else if(routineType.equals("Two Minute Final")){
                c.setCompetitionRoutineType("Two Minute Final");
            }

            StateSingleton.getInstance().setCompetition(c);
            StateSingleton.getInstance().setCompetitionDataAnalysis(cData);

        }
        else if(routineType.equals("Final")){
            cData = new WorldFinalCompetitionDataAnalysis(c);
            c.setCompetitionRoutineType("World Final");
            StateSingleton.getInstance().setCompetition(c);
            StateSingleton.getInstance().setCompetitionDataAnalysis(cData);

        }
    }

    //MODIFIES: This, Player
    //EFFECTS: Creates player and playerDataAnalysis subtypes depending on user-inputted routineType
    public PlayerDataAnalysis createPlayerAndDataSubtype(String routineType) {
        if (routineType.equals("Wildcard")) {
            WildcardPlayer p = new WildcardPlayer();
            p.setRoutineType("Wildcard");
            p.setRoutineLength("Wildcard");
            WildcardPlayerDataAnalysis data = new WildcardPlayerDataAnalysis(p);
            return data;
        } else if (routineType.equals("Prelim") || routineType.equals("Semi") || routineType.equals("Two Minute Final")) {
            PrelimTwoSemiPlayer p = new PrelimTwoSemiPlayer();
            PrelimTwoSemiPlayerDataAnalysis data = new PrelimTwoSemiPlayerDataAnalysis(p);
            if (routineType.equals("Prelim")){
                p.setRoutineType("Prelim");
                p.setRoutineLength("Prelim");
            }
            else if(routineType.equals("Semi")){
                p.setRoutineType("Semi");
                p.setRoutineLength("Semi");
            }
            else if(routineType.equals("Two Minute Final")){
                p.setRoutineType("Two Minute Final");
                p.setRoutineLength("Two Minute Final");
            }
            return data;
        } else if (routineType.equals("World Final")) {
            WorldFinalPlayer p = new WorldFinalPlayer();
            p.setRoutineType("World Final");
            p.setRoutineLength("World Final");
            WorldFinalPlayerDataAnalysis data = new WorldFinalPlayerDataAnalysis(p);
            return data;
        }
        return null;
    }


    //MODIFIES: This, Player
    //EFFECTS: Creates player and playerDataAnalysis subtypes depending on user-inputted routineType
    public void createPlayerAndDataSubtype(String routineType, Player p, PlayerDataAnalysis data) {
        if (routineType.equals("Wildcard")) {
            p = new WildcardPlayer();
            p.setRoutineType("Wildcard");
            p.setRoutineLength("Wildcard");
            data = new WildcardPlayerDataAnalysis(p);
            StateSingleton.getInstance().setPlayer(p);
            StateSingleton.getInstance().setPlayerDataAnalysis(data);
        } else if (routineType.equals("Prelim") || routineType.equals("Semi") || routineType.equals("Two Minute Final")) {
            p = new PrelimTwoSemiPlayer();
            data = new PrelimTwoSemiPlayerDataAnalysis(p);
            if (routineType.equals("Prelim")){
                p.setRoutineType("Prelim");
                p.setRoutineLength("Prelim");
            }
            else if(routineType.equals("Semi")){
                p.setRoutineType("Semi");
                p.setRoutineLength("Semi");
            }
            else if(routineType.equals("Two Minute Final")){
                p.setRoutineType("Two Minute Final");
                p.setRoutineLength("Two Minute Final");
            }
            StateSingleton.getInstance().setPlayer(p);
            StateSingleton.getInstance().setPlayerDataAnalysis(data);
        } else if (routineType.equals("World Final")) {
            p = new WorldFinalPlayer();
            p.setRoutineType("World Final");
            p.setRoutineLength("World Final");
            data = new WorldFinalPlayerDataAnalysis(p);
            StateSingleton.getInstance().setPlayer(p);
            StateSingleton.getInstance().setPlayerDataAnalysis(data);
        }
    }

}
