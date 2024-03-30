package classes.Commands;

import classes.Person;
import interfaces.ICommand;
import interfaces.IInput;
import interfaces.IOutput;

import java.util.Hashtable;

/**
 * ClearCommand class implements the ICommand interface.
 * It provides methods to get help and execute the command.
 * The execute method clears the collection of persons.
 */
public class ClearCommand implements ICommand {
    private final Hashtable<Integer, Person> persons;

    /**
     * Constructs a new ClearCommand object.
     *
     * @param persons the collection of persons to be cleared
     */
    public ClearCommand(Hashtable<Integer, Person> persons) {
        this.persons = persons;
    }

    /**
     * Provides help information for the clear command.
     *
     * @return a string containing the help information
     */
    @Override
    public String getHelp() {
        return "Clear the collection";
    }

    /**
     * Executes the clear command.
     * It clears the collection of persons and prints a message to the output.
     *
     * @param input the input interface
     * @param output the output interface
     */
    @Override
    public void execute(IInput input, IOutput output) {
        persons.clear();
        output.println("Collection cleared.");
    }
}
