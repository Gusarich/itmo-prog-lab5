package classes.IOManagers;

import java.util.Scanner;

/**
 * CommandLineInput class implements the IInput interface.
 * It provides methods to read a line, read the next input, and skip a line from the command line.
 */
public class CommandLineInput implements interfaces.IInput {
    private final Scanner scanner;

    /**
     * Constructs a new CommandLineInput object.
     */
    public CommandLineInput() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Reads a line from the command line.
     *
     * @return a string containing the line read from the command line
     */
    @Override
    public String readLine() {
        return scanner.nextLine().strip();
    }

    /**
     * Reads the next input from the command line.
     *
     * @return a string containing the next input from the command line
     */
    @Override
    public String readNext() {
        return scanner.next().strip();
    }

    /**
     * Skips a line in the command line.
     */
    @Override
    public void skipLine() {
        scanner.nextLine();
    }
}
