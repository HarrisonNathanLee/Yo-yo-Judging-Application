package App.player;

import App.Model.Subject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class Loadable  {

    //REQUIRES: File to exist in memory
    //EFFECTS: Reads file from memory
    public abstract void load(String saveLocation) throws IOException;

    //EFFECTS: Reads file from memory
    public abstract void loadOutput(ArrayList<String> partsOfLine);

    //EFFECTS: Prints file information from memory
    public abstract void printLoadOutput(ArrayList<String> partsOfLine);

    //EFFECTS: Forms a list by splitting on the commas between words in a string
    public static ArrayList<String> splitOnComma(String line) {
        String[] splits = line.split(",");
        return new ArrayList<>(Arrays.asList(splits));
    }
}
