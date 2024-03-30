package classes.Commands;

import classes.Person;
import interfaces.ICommand;
import interfaces.IInput;
import interfaces.IOutput;

import java.util.Hashtable;

/**
 * SumOfHeightCommand class implements the ICommand interface.
 * It provides methods to get help and execute the command.
 * The execute method calculates and prints the sum of the height field values for all collection elements.
 */
public class SumOfHeightCommand implements ICommand {
    private final Hashtable<Integer, Person> persons;

    /**
     * Constructs a new SumOfHeightCommand object.
     *
     * @param persons the collection of persons whose height field values are to be summed
     */
    public SumOfHeightCommand(Hashtable<Integer, Person> persons) {
        this.persons = persons;
    }

    /**
     * Provides help information for the sum of height command.
     *
     * @return a string containing the help information
     */
    @Override
    public String getHelp() {
        return "Print the sum of the height field values for all collection elements";
    }

    /**
     * Executes the sum of height command.
     * It calculates the sum of the height field values for all collection elements and prints the result to the output.
     *
     * @param input the input interface
     * @param output the output interface
     */
    @Override
    public void execute(IInput input, IOutput output) {
        int sum = persons.values().stream().mapToInt(Person::getHeight).sum();
        output.println("The sum of the height field values is " + sum + ".");
    }
}
