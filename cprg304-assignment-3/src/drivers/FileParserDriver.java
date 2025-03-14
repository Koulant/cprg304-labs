package drivers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import utilities.BSTree;
import utilities.FilesPrinter;
import utilities.Iterator;
import utilities.LinePrinter;
import utilities.OccurrencePrinter;
import utilities.Word;
import utilities.WordTracker;

/**
 * Driver class for parsing text files and generating reports using a Binary Search Tree (BST).
 * The program reads a serialized BST from a file, processes a text file, and generates reports
 * based on user-specified options.
 */
public class FileParserDriver {

    /**
     * Main method to execute the File Parser Driver.
     *
     * @param args Command line arguments:
     *             - args[0]: Path and filename of the text file to be processed.
     *             - args[1]: Output type flag (-pf, -pl, -po).
     *             - args[2] (Optional): Output file flag (-f) followed by the output filename in quotes (All one word, no spaces).
     *               Example input: -f"output.txt"
     */
    @SuppressWarnings("unchecked")
	public static void main(String args[]) {
        String fileName, outputType, outputFile;
        FileInputStream fileIn = null;
        ObjectInputStream in = null;
        BSTree<Word> tree = new BSTree<>();


        // Deserialize binary search tree from repository file
        try {
            fileIn = new FileInputStream("res/repository.ser");
            in = new ObjectInputStream(fileIn);
            tree = (BSTree<Word>) in.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Error: The repository file 'repository.ser' not found.");
            System.exit(-1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileIn != null) fileIn.close();
                if (in != null) in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Process the text file and generate reports based on user-specified options
        try {
            if (args.length == 2) {
                fileName = args[0];
                outputType = args[1].toUpperCase();
                WordTracker tracker = new WordTracker();
                tracker.setTree(tree);
                tracker.parseFile(fileName);
                tracker.serialize("res/repository.ser");

                Iterator<Word> inorderStack = tracker.getTree().inorderIterator();

                // Display reports based on the output type flag
                switch (outputType) {
                    case "-PF":
                        new FilesPrinter().display(inorderStack);
                        break;
                    case "-PL":
                        new LinePrinter().display(inorderStack);
                        break;
                    case "-PO":
                        new OccurrencePrinter().display(inorderStack);
                        break;
                    default:
                        throw new Exception();
                }

            } else if (args.length == 3) {
                fileName = args[0];
                outputType = args[1].toUpperCase();

                // Extract output file name from command line arguments
                if (args[2].length() > 2 && args[2].substring(0, 2).toUpperCase().equals("-F")) {
                    outputFile = args[2].substring(2).replaceAll("\"", "");
                } else {
                    throw new Exception();
                }

                WordTracker tracker = new WordTracker();
                tracker.setTree(tree);
                tracker.parseFile(fileName);
                tracker.serialize("res/repository.ser");

                Iterator<Word> inorderStack = tracker.getTree().inorderIterator();

                // Print reports to the specified output file
                switch (outputType) {
                    case "-PF":
                        new FilesPrinter().print(inorderStack, outputFile);
                        break;
                    case "-PL":
                        new LinePrinter().print(inorderStack, outputFile);
                        break;
                    case "-PO":
                        new OccurrencePrinter().print(inorderStack, outputFile);
                        break;
                    default:
                        throw new Exception();
                }

            } else {
                System.out.println("Argument length error. " + args.length + " arguments found.");
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("An unknown error has occurred. Please try again.");
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
