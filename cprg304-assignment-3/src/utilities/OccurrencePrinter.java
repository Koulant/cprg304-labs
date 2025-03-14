package utilities;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * The OccurrencePrinter class is responsible for displaying or printing the words,
 * the files containing those words, and the frequency of each word in the file.
 */
public class OccurrencePrinter {
    /**
     * Displays the word, file containing that word, and frequency of that word in
     * the file.
     *
     * @param inorderStack The stack of words.
     */
    public void display(Iterator<Word> inorderStack) {
        printOrDisplay(inorderStack, System.out);
    }

    /**
     * Writes to the file the value of word, file containing that word, and
     * frequency of that word in the file.
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
                stringBuilder.append("'").append(word.getValue()).append("' has occurred ").append(word.getFrequency())
                        .append(" times");
                try {
                    out.append(stringBuilder.toString()).append('\n');
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
