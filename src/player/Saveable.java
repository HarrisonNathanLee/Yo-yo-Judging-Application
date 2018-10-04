package player;

import java.io.IOException;

public interface Saveable {

    public void save(String saveLocation) throws IOException;
}
