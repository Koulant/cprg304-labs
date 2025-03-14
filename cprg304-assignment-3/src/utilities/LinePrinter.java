package utilities;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * The LinePrinter class is responsible for displaying or printing the words, the
 * files, and the line numbers containing those words.
 */
public class LinePrinter {
    /**
     * Displays the word, the file, and line numbers containing that word.
     *
     * @param stack The stack of words.
     */
    public void display(Iterator<Word> stack) {
        printOrDisplay(stack, System.out);
    }

    /**
     * Writes to the file the value of word, the file, and line numbers containing
     * that word.
     *
     * @param stack    The stack of words.
     * @param fileName The name of the output file.
     * @throws FileNotFoundException If the specified file is not found.
     */
    public void print(Iterator<Word> stack, String fileName) throws FileNotFoundException {
        try (PrintWriter writer = new PrintWriter(fileName)) {
            printOrDisplay(stack, writer);
        }
    }

    private void printOrDisplay(Iterator<Word> stack, Appendable out) {
        while (stack.hasNext()) {
            Word word = stack.next();
            ArrayList<String> filesOccurred = word.getFilesOccured();
            for (String file : filesOccurred) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Word: '").append(word.getValue()).append("' occurred in ").append(file)
                        .append(" at lines: ");
                for (int lineNumber : word.getLineNumbers(file)) {
                    stringBuilder.append(lineNumber).append(" ");
                }
                try {
                    out.append(stringBuilder.toString()).append('\n');
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
