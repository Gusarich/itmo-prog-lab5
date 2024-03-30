package classes.Commands;

import classes.Person;
import interfaces.ICommand;
import interfaces.IInput;
import interfaces.IOutput;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * PrintAscendingCommand class implements the ICommand interface.
 * It provides methods to get help and execute the command.
 * The execute method prints the collection elements in ascending order.
 */
public class PrintAscendingCommand implements ICommand {
    private final Hashtable<Integer, Person> persons;

    /**
     * Constructs a new PrintAscendingCommand object.
     *
     * @param persons the collection of persons to be sorted and printed
     */
    public PrintAscendingCommand(Hashtable<Integer, Person> persons) {
        this.persons = persons;
    }

    /**
     * Provides help information for the print ascending command.
     *
     * @return a string containing the help information
     */
    @Override
    public String getHelp() {
        return "Print collection elements in ascending order";
    }

    /**
     * Executes the print ascending command.
     * It sorts the collection elements in ascending order and prints them to the output.
     *
     * @param input the input interface
     * @param output the output interface
     */
    @Override
    public void execute(IInput input, IOutput output) {
        List<Person> sortedPersons = new ArrayList<>(persons.values());
        sortedPersons.sort(Person::compareTo);

        for (Person person : sortedPersons) {
            output.println(person.toString());
        }
    }
}
