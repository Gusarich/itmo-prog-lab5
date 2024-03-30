package classes.Commands;

import interfaces.IInput;
import interfaces.IOutput;

/**
 * ExitCommand class implements the ICommand interface.
 * It provides methods to get help and execute the command.
 * The execute method exits the program.
 */
public class ExitCommand implements interfaces.ICommand {

    /**
     * Provides help information for the exit command.
     *
     * @return a string containing the help information
     */
    public String getHelp() {
        return "Exit the program";
    }

    /**
     * Executes the exit command.
     * It prints a message to the output and exits the program.
     *
     * @param input the input interface
     * @param output the output interface
     */
    public void execute(IInput input, IOutput output) {
        output.println("Exiting...");
        System.exit(0);
    }
}
