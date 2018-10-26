package player;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class Readable {

    public abstract void read(String saveLocation) throws IOException;

    public static ArrayList<String> splitOnComma(String line) {
        String[] splits = line.split(",");
        return new ArrayList<>(Arrays.asList(splits));
    }
}
