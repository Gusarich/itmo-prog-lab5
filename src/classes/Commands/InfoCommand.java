package classes.Commands;

import classes.Person;
import interfaces.ICommand;
import interfaces.IInput;
import interfaces.IOutput;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * InfoCommand class implements the ICommand interface.
 * It provides methods to get help and execute the command.
 * The execute method displays information about the collection.
 */
public class InfoCommand implements ICommand {
    private final Hashtable<Integer, Person> persons;
    private final HashMap<String, ICommand> commands;
    private final String filename;

    /**
     * Constructs a new InfoCommand object.
     *
     * @param persons the collection of persons
     * @param commands the collection of commands
     * @param filename the filename of the collection
     */
    public InfoCommand(Hashtable<Integer, Person> persons, HashMap<String, ICommand> commands, String filename) {
        this.persons = persons;
        this.commands = commands;
        this.filename = filename;
    }

    /**
     * Provides help information for the info command.
     *
     * @return a string containing the help information
     */
    @Override
    public String getHelp() {
        return "Display information about the collection";
    }

    /**
     * Executes the info command.
     * It prints the number of elements in the collection, the number of commands, and the filename to the output.
     *
     * @param input the input interface
     * @param output the output interface
     */
    @Override
    public void execute(IInput input, IOutput output) {
        output.println("Number of elements: " + persons.size());
        output.println("Number of commands: " + commands.size());
        output.println("Filename: " + filename);
    }
}
