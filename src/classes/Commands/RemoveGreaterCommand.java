package classes.Commands;

import classes.Person;
import interfaces.ICommand;
import interfaces.IInput;
import interfaces.IOutput;

import java.util.Hashtable;

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

        persons.entrySet().removeIf(entry -> entry.getValue().compareTo(element) > 0);
        output.println("Elements greater than the specified one have been removed.");
    }
}