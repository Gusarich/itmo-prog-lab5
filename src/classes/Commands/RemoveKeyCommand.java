package classes.Commands;

import classes.Person;
import interfaces.ICommand;
import interfaces.IInput;
import interfaces.IOutput;

import java.util.Hashtable;

public class RemoveKeyCommand implements ICommand {
    private final Hashtable<Integer, Person> persons;

    public RemoveKeyCommand(Hashtable<Integer, Person> persons) {
        this.persons = persons;
    }

    @Override
    public String getHelp() {
        return "Remove an element from the collection by its key";
    }

    @Override
    public void execute(IInput input, IOutput output) {
        output.println("Enter the key:");
        int key = Integer.parseInt(input.readLine());

        if (persons.containsKey(key)) {
            persons.remove(key);
            output.println("Element removed.");
        } else {
            output.println("Element with this key does not exist.");
        }
    }
}