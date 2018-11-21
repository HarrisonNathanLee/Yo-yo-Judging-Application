package App.ui;

import App.Exceptions.AlreadyInCompetitionException;

import java.io.IOException;

public interface AppStrategy {
    public void callMode() throws IOException, AlreadyInCompetitionException;


}
