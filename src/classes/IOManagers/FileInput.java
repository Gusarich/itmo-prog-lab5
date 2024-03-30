package classes.IOManagers;

import interfaces.IInput;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * FileInput class implements the IInput interface.
 * It provides methods to read a line, read the next input, skip a line, and check if there is a next line from a file.
 */
public class FileInput implements IInput {
    private final Scanner scanner;

    /**
     * Constructs a new FileInput object.
     *
     * @param filename the name of the file from which input will be read
     * @throws FileNotFoundException if the file does not exist, is a directory rather than a regular file, or for some other reason cannot be opened for reading
     */
    public FileInput(String filename) throws FileNotFoundException {
        this.scanner = new Scanner(new File(filename));
    }

    /**
     * Reads a line from the file.
     *
     * @return a string containing the line read from the file
     */
    @Override
    public String readLine() {
        return scanner.nextLine().strip();
    }

    /**
     * Reads the next input from the file.
     *
     * @return a string containing the next input from the file
     */
    @Override
    public String readNext() {
        return scanner.next().strip();
    }

    /**
     * Skips a line in the file.
     */
    @Override
    public void skipLine() {
        scanner.nextLine();
    }

    /**
     * Checks if there is a next line in the file.
     *
     * @return a boolean indicating whether there is a next line in the file
     */
    public boolean hasNextLine() {
        return scanner.hasNextLine();
    }
}
