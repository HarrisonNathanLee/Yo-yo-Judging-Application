package App.ui;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class ConsoleToUI {
    protected static final String STRINGBREAK  = "---------------------------------------";


    private void updateTextPane(final String text, JTextPane textPane) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Document doc = textPane.getDocument();
                try {
                    doc.insertString(doc.getLength(), text, null);
                } catch (BadLocationException e) {
                    throw new RuntimeException(e);
                }
                textPane.setCaretPosition(doc.getLength() - 1);
            }
        });
    }

    protected void redirectSystemStreams(JTextPane textPane) {
        OutputStream out = new OutputStream() {
            @Override
            public void write(final int b) throws IOException {
                updateTextPane(String.valueOf((char) b),textPane);
            }

            @Override
            public void write(byte[] b, int off, int len) throws IOException {
                updateTextPane(new String(b, off, len),textPane);
            }

            @Override
            public void write(byte[] b) throws IOException {
                write(b, 0, b.length);
            }
        };

        System.setOut(new PrintStream(out, true));
        System.setErr(new PrintStream(out, true));
    }
}
