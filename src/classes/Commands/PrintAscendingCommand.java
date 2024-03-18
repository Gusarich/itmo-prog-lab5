// PrintAscendingCommand.java
package classes.Commands;

import classes.Person;
import interfaces.ICommand;
import interfaces.IInput;
import interfaces.IOutput;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class PrintAscendingCommand implements ICommand {
    private final Hashtable<Integer, Person> persons;

    public PrintAscendingCommand(Hashtable<Integer, Person> persons) {
        this.persons = persons;
    }

    @Override
    public String getHelp() {
        return "Print collection elements in ascending order";
    }

    @Override
    public void execute(IInput input, IOutput output) {
        List<Person> sortedPersons = new ArrayList<>(persons.values());
        sortedPersons.sort(Person::compareTo);

        for (Person person : sortedPersons) {
            output.println(person.toString());
        }
    }
}