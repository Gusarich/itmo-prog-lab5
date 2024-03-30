package classes.Commands;

import interfaces.ICommand;
import interfaces.IInput;
import interfaces.IOutput;

import java.util.HashMap;

/**
 * HelpCommand class implements the ICommand interface.
 * It provides methods to get help and execute the command.
 * The execute method displays help information for all commands.
 */
public class HelpCommand implements ICommand {
    private final HashMap<String, ICommand> commands;

    /**
     * Constructs a new HelpCommand object.
     *
     * @param commands the collection of commands for which help information is to be displayed
     */
    public HelpCommand(HashMap<String, ICommand> commands) {
        this.commands = commands;
    }

    /**
     * Provides help information for the help command.
     *
     * @return a string containing the help information
     */
    @Override
    public String getHelp() {
        return "Display help information";
    }

    /**
     * Executes the help command.
     * It iterates over all commands and prints their help information to the output.
     *
     * @param input the input interface
     * @param output the output interface
     */
    @Override
    public void execute(IInput input, IOutput output) {
        commands.forEach((name, command) -> output.println(name + " - " + command.getHelp()));
    }
}
