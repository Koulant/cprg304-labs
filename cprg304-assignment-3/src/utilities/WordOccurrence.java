package utilities;

import java.io.Serializable;

/**
 * The WordOccurrence class represents the occurrence of a word in a file at a specific line number.
 */
public class WordOccurrence implements Serializable {
    private static final long serialVersionUID = 1L;
	private String fileName;
    private int lineNumber;

    /**
     * Default constructor for WordOccurrence class.
     */
    public WordOccurrence() {
    }

    /**
     * Parameterized constructor for WordOccurrence class.
     *
     * @param fileName   The name of the file where the word occurred.
     * @param lineNumber The line number where the word occurred.
     */
    public WordOccurrence(String fileName, int lineNumber) {
        this.fileName = fileName;
        this.lineNumber = lineNumber;
    }

    /**
     * Gets the name of the file where the word occurred.
     *
     * @return The name of the file.
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Sets the name of the file where the word occurred.
     *
     * @param fileName The name of the file.
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Gets the line number where the word occurred.
     *
     * @return The line number.
     */
    public int getLineNumber() {
        return lineNumber;
    }

    /**
     * Sets the line number where the word occurred.
     *
     * @param lineNumber The line number.
     */
    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }
}
