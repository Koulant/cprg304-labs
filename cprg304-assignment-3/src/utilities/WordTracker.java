package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Scanner;

import exceptions.TreeException;

/**
 * The WordTracker class is responsible for tracking the occurrences of words in a text file and maintaining a binary search tree of unique words.
 */
public class WordTracker {
    private BSTree<Word> tree = new BSTree<>();

    /**
     * Serializes the binary search tree and writes it to a file.
     *
     * @param filePath The path to the file where the binary search tree will be serialized.
     * @throws IOException If an I/O error occurs during serialization.
     */
    public void serialize(String filePath) throws IOException {
        try (FileOutputStream fileOut = new FileOutputStream(filePath);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(tree);
        }
    }

    /**
     * Parses a text file, extracts words, and updates the binary search tree with word occurrences.
     *
     * @param fileName The path to the text file to be parsed.
     * @throws FileNotFoundException If the specified file is not found.
     * @throws TreeException           If an error occurs while updating the binary search tree.
     */
    public void parseFile(String fileName) throws FileNotFoundException, TreeException {
        File file = new File(fileName);
        try (Scanner lineReader = new Scanner(file)) {
            int lineNumber = 1;
            while (lineReader.hasNextLine()) {
                String line = lineReader.nextLine().replaceAll("\\p{Punct}", "").toLowerCase();
                String[] wordArray = line.split("\\s+");
                for (String word : wordArray) {
                    if (word.equals("")) {
                        continue;
                    }
                    Word newEntry = new Word(word, new HashSet<>());
                    if (!tree.isEmpty()) {
                        if (tree.contains(newEntry)) {
                            BSTreeNode<Word> wordNode = tree.search(newEntry);
                            wordNode.getElement().addOccurrence(new WordOccurrence(fileName, lineNumber));
                        } else {
                            newEntry.addOccurrence(new WordOccurrence(fileName, lineNumber));
                            tree.add(newEntry);
                        }
                    } else {
                        newEntry.addOccurrence(new WordOccurrence(fileName, lineNumber));
                            tree.add(newEntry);
                    }
                }
                lineNumber++;
            }
        }
    }

    /**
     * Sets the binary search tree with a provided tree.
     *
     * @param tree The binary search tree to set.
     */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void setTree(BSTree tree) {
        this.tree = tree;
    }

    /**
     * Gets the binary search tree.
     *
     * @return The binary search tree.
     */
    public BSTree<Word> getTree() {
        return tree;
    }
}
