package classes.IOManagers;

/**
 * CommandLineOutput class implements the IOutput interface.
 * It provides methods to print a message and print a message with a new line to the command line.
 */
public class CommandLineOutput implements interfaces.IOutput {

    /**
     * Constructs a new CommandLineOutput object.
     */
    public CommandLineOutput() {
    }

    /**
     * Prints a message to the command line.
     *
     * @param message the message to be printed
     */
    @Override
    public void print(String message) {
        System.out.print(message);
    }

    /**
     * Prints a message to the command line, followed by a new line.
     *
     * @param message the message to be printed
     */
    @Override
    public void println(String message) {
        System.out.println(message);
    }
}
