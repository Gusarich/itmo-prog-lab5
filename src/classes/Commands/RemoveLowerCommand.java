package classes.Commands;

import classes.Person;
import interfaces.ICommand;
import interfaces.IInput;
import interfaces.IOutput;

import java.util.Hashtable;

/**
 * RemoveLowerCommand class implements the ICommand interface.
 * It provides methods to get help and execute the command.
 * The execute method removes all elements from the collection that are less than the specified one.
 */
public class RemoveLowerCommand implements ICommand {
    private final Hashtable<Integer, Person> persons;

    /**
     * Constructs a new RemoveLowerCommand object.
     *
     * @param persons the collection of persons from which elements are to be removed
     */
    public RemoveLowerCommand(Hashtable<Integer, Person> persons) {
        this.persons = persons;
    }

    /**
     * Provides help information for the remove lower command.
     *
     * @return a string containing the help information
     */
    @Override
    public String getHelp() {
        return "Remove all elements from the collection that are less than the specified one";
    }

    /**
     * Executes the remove lower command.
     * It reads an element from the input, removes all elements from the collection that are less than the specified one, and prints a message to the output.
     *
     * @param input the input interface
     * @param output the output interface
     */
    @Override
    public void execute(IInput input, IOutput output) {
        input.skipLine();

        output.println("Enter the element...");
        Person element = Person.fromInput(input, output);

        persons.entrySet().removeIf(entry -> entry.getValue().compareTo(element) < 0);
        output.println("Elements less than the specified one have been removed.");
    }
}
