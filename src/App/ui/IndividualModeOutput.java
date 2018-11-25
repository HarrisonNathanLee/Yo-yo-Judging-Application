package App.ui;

import App.Model.StateSingleton;
import App.player.Player;
import App.player.PlayerDataAnalysis;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import java.awt.*;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import static App.ui.Routine.STRINGBREAK;

public class IndividualModeOutput {
    private static final String PERFORMANCEEVALS = "'s performance evaluation scores: ";
    private JPanel panelIndividualModeOutput;
    private JTextPane outputTextPane;
    private JFrame frame;
    private Player p ;
    private PlayerDataAnalysis data;

    public IndividualModeOutput(JFrame frame){
        this.frame = frame;
        p = StateSingleton.getInstance().getPlayer();
        data = StateSingleton.getInstance().getPlayerDataAnalysis();
        data.callAllDataAnalysis();
        redirectSystemStreams();
        printRoutineClickInformation(p);
        printRoutineMajorDeductInformation(p);
        if (p.getRoutineType().equals("Prelim") ||p.getRoutineType().equals("Semi") || p.getRoutineType().equals("Two Minute Final")) {
            prelimTwoSemiPerformanceEvals(p);
        }
        else if(p.getRoutineType().equals("World Final")) {
            worldPerformanceEvals(p);
        }
        printAnalyzedRoutineInformation(data, p);

    }

    //EFFECTS: Prints judge inputted performance evaluations
    public void prelimTwoSemiPerformanceEvals(Player p) {
        System.out.println(p.getFirstName() + " " + p.getLastName() + PERFORMANCEEVALS);
        System.out.println("Execution: " + p.getExecution());
        System.out.println("Control: " + p.getControl());
        System.out.println("Choreography: " + p.getChoreography());
        System.out.println("Body control: " + p.getBodyControl());
        System.out.println(STRINGBREAK);
    }

    //EFFECTS: Prints judge inputted performance evaluations
    public void worldPerformanceEvals(Player p) {
        System.out.println(p.getFirstName() + " " + p.getLastName() + PERFORMANCEEVALS);
        System.out.println("Execution: " + p.getExecution());
        System.out.println("Control: " + p.getControl());
        System.out.println("Trick Diversity: " + p.getTrickDiversity());
        System.out.println("Space Use and Emphasis: " + p.getSpaceUseAndEmphasis());
        System.out.println("Choreography: " + p.getChoreography());
        System.out.println("Construction: " + p.getConstruction());
        System.out.println("Body control: " + p.getBodyControl());
        System.out.println("Showmanship: " + p.getShowmanship());
        System.out.println(STRINGBREAK);
    }

    //EFFECTS: Prints various post performance information
    public void printRoutineClickInformation(Player p) {
        System.out.println(p.getFirstName() + " " + p.getLastName() + "'s technical data: ");
        System.out.println("Positive clicks: " + p.getPositiveClicks());
        System.out.println("Negative clicks: " + p.getNegativeClicks());
        System.out.println("Clickerscore: " + p.getClickerScore());
        System.out.println(STRINGBREAK);

    }

    private void printRoutineMajorDeductInformation(Player p) {
        System.out.println(p.getFirstName() + " " + p.getLastName() + "'s major deduct scores: ");
        System.out.println("Number of resets: " + p.getNumberOfRestarts());
        System.out.println("Final reset score is: " + p.getRestartFinal());
        System.out.println("Number of changes: " + p.getNumberOfChanges());
        System.out.println("Final change score is: " + p.getChangeFinal());
        System.out.println("Number of discards: " + p.getNumberOfDiscards());
        System.out.println("Final discard score is: " + p.getDiscardFinal());
        System.out.println(STRINGBREAK);
    }

    //EFFECTS: Prints analyzed routine information of a player
    public void printAnalyzedRoutineInformation(PlayerDataAnalysis data, Player p) {
        System.out.println(p.getFirstName() + " " + p.getLastName() + "'s analyzed technical data:");
        System.out.println("Total majors: " + data.getTotalMajors());
        System.out.println("Total weighted score: " + data.getTotalWeightedScore());
        System.out.println("Fire sections in routine: " + data.getNumberOfFireSectionsInRoutine());
        System.out.println("Tilted sections in routine: " + data.getNumberOfTiltedSectionsInRoutine());
        System.out.println("Clicks per second: " + data.getCPS());
        System.out.println("Clicks ratio: " + data.getCR());
        System.out.println("Clicks if perfect: " + data.getNumberIfPerfect());
        System.out.println("Clicks if perfect per second:" + data.getCIPPS());
        System.out.println(STRINGBREAK);
    }

    private void updateTextPane(final String text) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Document doc = outputTextPane.getDocument();
                try {
                    doc.insertString(doc.getLength(), text, null);
                } catch (BadLocationException e) {
                    throw new RuntimeException(e);
                }
                outputTextPane.setCaretPosition(doc.getLength() - 1);
            }
        });
    }

    private void redirectSystemStreams() {
        OutputStream out = new OutputStream() {
            @Override
            public void write(final int b) throws IOException {
                updateTextPane(String.valueOf((char) b));
            }

            @Override
            public void write(byte[] b, int off, int len) throws IOException {
                updateTextPane(new String(b, off, len));
            }

            @Override
            public void write(byte[] b) throws IOException {
                write(b, 0, b.length);
            }
        };

        System.setOut(new PrintStream(out, true));
        System.setErr(new PrintStream(out, true));
    }

    public Container getPanel() {
        return panelIndividualModeOutput;
    }
}
