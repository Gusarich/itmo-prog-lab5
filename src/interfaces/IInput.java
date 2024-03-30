package interfaces;

/**
 * IInput interface represents an input source.
 * It provides methods to read a line, read the next input, and skip a line.
 */
public interface IInput {

    /**
     * Reads a line from the input source.
     *
     * @return a string containing the line read from the input source
     */
    String readLine();

    /**
     * Reads the next input from the input source.
     *
     * @return a string containing the next input from the input source
     */
    String readNext();

    /**
     * Skips a line in the input source.
     */
    void skipLine();
}
