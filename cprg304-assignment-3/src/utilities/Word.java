package utilities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;

/**
 * The Word class represents a word with its occurrences and frequency.
 * It implements the Comparable interface to allow sorting of words.
 */
public class Word implements Comparable<Word>, Serializable {
    private static final long serialVersionUID = 5349516372360608133L;
	private String value;
    private int frequency = 0;
    private Set<WordOccurrence> occurrences;

    /**
     * Default constructor for Word class.
     */
    public Word() {
    }

    /**
     * Parameterized constructor for Word class.
     *
     * @param value      The value of the word.
     * @param occurrences The set of word occurrences.
     */
    public Word(String value, Set<WordOccurrence> occurrences) {
        this.value = value;
        this.occurrences = occurrences;
    }

    /**
     * Gets the value of the word.
     *
     * @return The value of the word.
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the word.
     *
     * @param value The value of the word.
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the set of word occurrences.
     *
     * @return The set of word occurrences.
     */
    public Set<WordOccurrence> getOccurrences() {
        return occurrences;
    }

    /**
     * Sets the set of word occurrences.
     *
     * @param occurrences The set of word occurrences.
     */
    public void setOccurrences(Set<WordOccurrence> occurrences) {
        this.occurrences = occurrences;
    }

    /**
     * Gets the frequency of the word.
     *
     * @return The frequency of the word.
     */
    public int getFrequency() {
        return frequency;
    }

    /**
     * Sets the frequency of the word.
     *
     * @param frequency The frequency of the word.
     */
    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    /**
     * Adds a word occurrence to the set and increments the frequency.
     *
     * @param occurrence The word occurrence to add.
     */
    public void addOccurrence(WordOccurrence occurrence) {
        setFrequency(getFrequency() + 1);
        occurrences.add(occurrence);
    }

    /**
     * Gets the list of file names where the word occurred.
     *
     * @return The list of file names.
     */
    public ArrayList<String> getFilesOccurred() {
        ArrayList<String> filenames = new ArrayList<>();
        for (WordOccurrence occurrence : occurrences) {
            if (!filenames.contains(occurrence.getFileName())) {
                filenames.add(occurrence.getFileName());
            }
        }
        return filenames;
    }

    /**
     * Gets the list of line numbers where the word occurred in a specific file.
     *
     * @param file The file name.
     * @return The list of line numbers.
     */
    public ArrayList<Integer> getLineNumbers(String file) {
        ArrayList<Integer> lineNumbers = new ArrayList<>();
        for (WordOccurrence occurrence : occurrences) {
            if (!lineNumbers.contains(occurrence.getLineNumber()) && occurrence.getFileName().equals(file)) {
                lineNumbers.add(occurrence.getLineNumber());
            }
        }
        return lineNumbers;
    }

    @Override
    public int compareTo(Word o) {
        return value.compareTo(o.getValue());
    }

	public ArrayList<String> getFilesOccured() {
		// TODO Auto-generated method stub
		ArrayList<String> filenames = new ArrayList<>();
		for(WordOccurrence set : occurrences) {
			if(!filenames.contains(set.getFileName())) {
				filenames.add(set.getFileName());
			}
		}
		return filenames;
	}
}
