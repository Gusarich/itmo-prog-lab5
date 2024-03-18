package classes.Commands;

import classes.Person;
import interfaces.ICommand;
import interfaces.IInput;
import interfaces.IOutput;

import java.util.Hashtable;

public class ClearCommand implements ICommand {
    private final Hashtable<Integer, Person> persons;

    public ClearCommand(Hashtable<Integer, Person> persons) {
        this.persons = persons;
    }

    @Override
    public String getHelp() {
        return "Clear the collection";
    }

    @Override
    public void execute(IInput input, IOutput output) {
        persons.clear();
        output.println("Collection cleared.");
    }
}
