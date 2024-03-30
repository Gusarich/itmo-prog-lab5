package classes.Commands;

import classes.Person;
import interfaces.IInput;
import interfaces.IOutput;

import java.util.Hashtable;

/**
 * ShowCommand class implements the ICommand interface.
 * It provides methods to get help and execute the command.
 * The execute method displays all elements of the collection.
 */
public class ShowCommand implements interfaces.ICommand {
    private final Hashtable<Integer, Person> persons;

    /**
     * Constructs a new ShowCommand object.
     *
     * @param persons the collection of persons to be displayed
     */
    public ShowCommand(Hashtable<Integer, Person> persons) {
        this.persons = persons;
    }

    /**
     * Provides help information for the show command.
     *
     * @return a string containing the help information
     */
    @Override
    public String getHelp() {
        return "Show all elements of the collection";
    }

    /**
     * Executes the show command.
     * It prints all elements of the collection to the output.
     *
     * @param input the input interface
     * @param output the output interface
     */
    @Override
    public void execute(IInput input, IOutput output) {
        output.println("Collection:");
        persons.forEach((key, person) -> {
            output.print(key + " => ");
            output.println(person.toString());
        });
    }
}
