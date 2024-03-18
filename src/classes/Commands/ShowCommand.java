package classes.Commands;

import classes.Person;
import interfaces.IInput;
import interfaces.IOutput;

import java.util.Hashtable;

public class ShowCommand implements interfaces.ICommand {
    private final Hashtable<Integer, Person> persons;

    public ShowCommand(Hashtable<Integer, Person> persons) {
        this.persons = persons;
    }

    @Override
    public String getHelp() {
        return "Show all elements of the collection";
    }

    @Override
    public void execute(IInput input, IOutput output) {
        output.println("Collection:");
        persons.forEach((key, person) -> {
            output.print(key + " => ");
            output.println(person.toString());
        });
    }
}
