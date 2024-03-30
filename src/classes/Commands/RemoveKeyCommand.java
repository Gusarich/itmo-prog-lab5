package classes.Commands;

import classes.Person;
import interfaces.ICommand;
import interfaces.IInput;
import interfaces.IOutput;

import java.util.Hashtable;

/**
 * RemoveKeyCommand class implements the ICommand interface.
 * It provides methods to get help and execute the command.
 * The execute method removes an element from the collection by its key.
 */
public class RemoveKeyCommand implements ICommand {
    private final Hashtable<Integer, Person> persons;

    /**
     * Constructs a new RemoveKeyCommand object.
     *
     * @param persons the collection of persons from which an element is to be removed
     */
    public RemoveKeyCommand(Hashtable<Integer, Person> persons) {
        this.persons = persons;
    }

    /**
     * Provides help information for the remove key command.
     *
     * @return a string containing the help information
     */
    @Override
    public String getHelp() {
        return "Remove an element from the collection by its key";
    }

    /**
     * Executes the remove key command.
     * It reads a key from the input, removes the corresponding element from the collection if it exists, and prints a message to the output.
     *
     * @param input the input interface
     * @param output the output interface
     */
    @Override
    public void execute(IInput input, IOutput output) {
        int key = Integer.parseInt(input.readLine());

        if (persons.containsKey(key)) {
            persons.remove(key);
            output.println("Element removed.");
        } else {
            output.println("Element with this key does not exist.");
        }
    }
}
