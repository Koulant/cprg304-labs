package exceptions;

/**
 * Custom exception class for tree-related exceptions.
 */
public class TreeException extends Exception {

    private static final long serialVersionUID = 1L;

	/**
     * Constructs a TreeException with the specified detail message.
     *
     * @param message The detail message for the exception.
     */
    public TreeException(String message) {
        super(message);
    }
}
