package interfaces;

/**
 * IOutput interface represents an output destination.
 * It provides methods to print a message and print a message with a new line.
 */
public interface IOutput {

    /**
     * Prints a message to the output destination.
     *
     * @param message the message to be printed
     */
    void print(String message);

    /**
     * Prints a message to the output destination, followed by a new line.
     *
     * @param message the message to be printed
     */
    void println(String message);
}
