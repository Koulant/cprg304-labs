package utilities;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * The FilesPrinter class is responsible for displaying or printing the words and
 * the files containing those words.
 */
public class FilesPrinter {
    /**
     * Displays the word and the files containing that word.
     *
     * @param stack The stack of words.
     */
    public void display(Iterator<Word> stack) {
        printOrDisplay(stack, System.out);
    }

    /**
     * Writes to the file the word and the files containing that word.
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
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Word: '").append(word.getValue()).append("' occurred in files: ");
            for (String file : filesOccurred) {
                stringBuilder.append(file).append(" ");
            }
            try {
                out.append(stringBuilder.toString()).append('\n');
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
