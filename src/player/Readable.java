package player;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class Readable {

    //REQUIRES: File to exist in memory
    //EFFECTS: Reads file from memory
    public abstract void read(String saveLocation) throws IOException;

    //EFFECTS: Reads file from memory
    public abstract void readOutput(ArrayList<String> partsOfLine);

    //EFFECTS: Prints file information from memory
    public abstract void printReadOutput(ArrayList<String> partsOfLine);

    //EFFECTS: Forms a list by splitting on the commas between words in a string
    public static ArrayList<String> splitOnComma(String line) {
        String[] splits = line.split(",");
        return new ArrayList<>(Arrays.asList(splits));
    }
}
