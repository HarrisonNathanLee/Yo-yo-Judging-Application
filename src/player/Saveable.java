package player;

import java.io.IOException;

public interface Saveable {

    //EFFECTS: Saves information to a CSV file
    public void save(String saveLocation) throws IOException;

    //EFFECTS: Prepares class information to be stored in a CSV file
    public String toSaveString();

}
