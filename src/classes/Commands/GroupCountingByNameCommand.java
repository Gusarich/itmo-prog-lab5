// GroupCountingByNameCommand.java
package classes.Commands;

import classes.Person;
import interfaces.ICommand;
import interfaces.IInput;
import interfaces.IOutput;

import java.util.Hashtable;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * GroupCountingByNameCommand class implements the ICommand interface.
 * It provides methods to get help and execute the command.
 * The execute method groups the collection elements by the value of the name field and prints the number of elements in each group.
 */
public class GroupCountingByNameCommand implements ICommand {
    private final Hashtable<Integer, Person> persons;

    /**
     * Constructs a new GroupCountingByNameCommand object.
     *
     * @param persons the collection of persons to be grouped
     */
    public GroupCountingByNameCommand(Hashtable<Integer, Person> persons) {
        this.persons = persons;
    }

    /**
     * Provides help information for the group counting by name command.
     *
     * @return a string containing the help information
     */
    @Override
    public String getHelp() {
        return "Group collection elements by the value of the name field, print the number of elements in each group";
    }

    /**
     * Executes the group counting by name command.
     * It groups the collection elements by the value of the name field and prints the number of elements in each group.
     *
     * @param input the input interface
     * @param output the output interface
     */
    @Override
    public void execute(IInput input, IOutput output) {
        Map<String, Long> groups = persons.values().stream()
                .collect(Collectors.groupingBy(Person::getName, Collectors.counting()));

        for (Map.Entry<String, Long> entry : groups.entrySet()) {
            output.println("Name: " + entry.getKey() + ", Count: " + entry.getValue());
        }
    }
}
