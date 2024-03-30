package interfaces;

/**
 * ICommand interface represents a command that can be executed.
 * It provides methods to get help information and to execute the command.
 */
public interface ICommand {

    /**
     * Returns a string containing help information for the command.
     *
     * @return a string containing help information for the command
     */
    String getHelp();

    /**
     * Executes the command using the provided input and output interfaces.
     *
     * @param input the input interface
     * @param output the output interface
     */
    void execute(IInput input, IOutput output);
}
