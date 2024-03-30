package classes.IOManagers;

import interfaces.IOutput;
import java.io.*;

/**
 * FileOutput class implements the IOutput interface.
 * It provides methods to print a message and print a message with a new line to a file.
 */
public class FileOutput implements IOutput {
    private final PrintWriter writer;

    /**
     * Constructs a new FileOutput object.
     *
     * @param filename the name of the file to which output will be written
     * @throws FileNotFoundException if the file does not exist, is a directory rather than a regular file, or for some other reason cannot be opened for reading
     */
    public FileOutput(String filename) throws FileNotFoundException {
        OutputStream os = new FileOutputStream(filename);
        BufferedOutputStream bos = new BufferedOutputStream(os);
        this.writer = new PrintWriter(new OutputStreamWriter(bos));
    }

    /**
     * Prints a message to the file.
     *
     * @param message the message to be printed
     */
    @Override
    public void print(String message) {
        writer.print(message);
        writer.flush();
    }

    /**
     * Prints a message to the file, followed by a new line.
     *
     * @param message the message to be printed
     */
    @Override
    public void println(String message) {
        writer.println(message);
        writer.flush();
    }

    /**
     * Closes the PrintWriter.
     */
    public void close() {
        writer.close();
    }
}
