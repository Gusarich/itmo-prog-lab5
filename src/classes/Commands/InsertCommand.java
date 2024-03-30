package classes.Commands;

import classes.Person;
import interfaces.IInput;
import interfaces.IOutput;

import java.util.Hashtable;

/**
 * InsertCommand class implements the ICommand interface.
 * It provides methods to get help and execute the command.
 * The execute method adds a new element with the specified key to the collection.
 */
public class InsertCommand implements interfaces.ICommand {
    private final Hashtable<Integer, Person> persons;

    /**
     * Constructs a new InsertCommand object.
     *
     * @param persons the collection of persons to which a new element is to be added
     */
    public InsertCommand(Hashtable<Integer, Person> persons) {
        this.persons = persons;
    }

    /**
     * Provides help information for the insert command.
     *
     * @return a string containing the help information
     */
    @Override
    public String getHelp() {
        return "Add a new element with the specified key";
    }

    /**
     * Executes the insert command.
     * It reads a key from the input, creates a new person from the input, adds the person to the collection with the specified key, and prints a message to the output.
     *
     * @param input the input interface
     * @param output the output interface
     */
    @Override
    public void execute(IInput input, IOutput output) {
        input.skipLine();

        output.print("Enter the key: ");
        int key = Integer.parseInt(input.readLine());

        Person person = Person.fromInput(input, output);

        persons.put(key, person);
        output.println("Element added.");
    }
}
