package classes.Commands;

import classes.Person;
import interfaces.ICommand;
import interfaces.IInput;
import interfaces.IOutput;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public class RemoveGreaterCommand implements ICommand {
    private final Hashtable<Integer, Person> persons;

    public RemoveGreaterCommand(Hashtable<Integer, Person> persons) {
        this.persons = persons;
    }

    @Override
    public String getHelp() {
        return "Remove all elements from the collection that exceed the specified one";
    }

    @Override
    public void execute(IInput input, IOutput output) {
        output.println("Enter the element:");
        Person element = Person.fromInput(input, output);

        Iterator<Map.Entry<Integer, Person>> iterator = persons.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Person> entry = iterator.next();
            if (entry.getValue().compareTo(element) > 0) {
                iterator.remove();
            }
        }
        output.println("Elements greater than the specified one have been removed.");
    }
}