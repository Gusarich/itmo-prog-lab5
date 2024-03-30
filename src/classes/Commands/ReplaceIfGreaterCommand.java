package classes.Commands;

import classes.Person;
import interfaces.ICommand;
import interfaces.IInput;
import interfaces.IOutput;

import java.util.Hashtable;

/**
 * ReplaceIfGreaterCommand class implements the ICommand interface.
 * It provides methods to get help and execute the command.
 * The execute method replaces the value by key if the new value is greater than the old one.
 */
public class ReplaceIfGreaterCommand implements ICommand {
    private final Hashtable<Integer, Person> persons;

    /**
     * Constructs a new ReplaceIfGreaterCommand object.
     *
     * @param persons the collection of persons in which the replacement is to be made
     */
    public ReplaceIfGreaterCommand(Hashtable<Integer, Person> persons) {
        this.persons = persons;
    }

    /**
     * Provides help information for the replace if greater command.
     *
     * @return a string containing the help information
     */
    @Override
    public String getHelp() {
        return "Replace the value by key if the new value is greater than the old one";
    }

    /**
     * Executes the replace if greater command.
     * It reads a key and an element from the input, replaces the value by key in the collection if the new value is greater than the old one, and prints a message to the output.
     *
     * @param input the input interface
     * @param output the output interface
     */
    @Override
    public void execute(IInput input, IOutput output) {
        input.skipLine();

        output.print("Enter the key: ");
        int key = Integer.parseInt(input.readLine());

        if (persons.containsKey(key)) {
            output.print("Enter the element ");
            Person element = Person.fromInput(input, output);

            if (element.compareTo(persons.get(key)) > 0) {
                persons.put(key, element);
                output.println("Element replaced.");
            } else {
                output.println("The new element is not greater than the old one.");
            }
        } else {
            output.println("Element with this key does not exist.");
        }
    }
}
