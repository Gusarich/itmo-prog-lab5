package classes.Commands;

import classes.Person;
import interfaces.ICommand;
import interfaces.IInput;
import interfaces.IOutput;

import java.util.Hashtable;

/**
 * UpdateCommand class implements the ICommand interface.
 * It provides methods to get help and execute the command.
 * The execute method updates the value of the collection element whose id is equal to the given one.
 */
public class UpdateCommand implements ICommand {
    private final Hashtable<Integer, Person> persons;

    /**
     * Constructs a new UpdateCommand object.
     *
     * @param persons the collection of persons in which the update is to be made
     */
    public UpdateCommand(Hashtable<Integer, Person> persons) {
        this.persons = persons;
    }

    /**
     * Provides help information for the update command.
     *
     * @return a string containing the help information
     */
    @Override
    public String getHelp() {
        return "Update the value of the collection element whose id is equal to the given one";
    }

    /**
     * Executes the update command.
     * It reads an id and an element from the input, updates the value of the collection element whose id is equal to the given one, and prints a message to the output.
     *
     * @param input the input interface
     * @param output the output interface
     */
    @Override
    public void execute(IInput input, IOutput output) {
        input.skipLine();

        output.print("Enter the id: ");
        int id = Integer.parseInt(input.readLine());

        if (persons.containsKey(id)) {
            Person person = Person.fromInput(input, output);
            persons.put(id, person);
            output.println("Element updated.");
        } else {
            output.println("Element with this id does not exist.");
        }
    }
}
