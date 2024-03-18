package classes.Commands;

import classes.Person;
import interfaces.ICommand;
import interfaces.IInput;
import interfaces.IOutput;

import java.util.Hashtable;

public class UpdateCommand implements ICommand {
    private final Hashtable<Integer, Person> persons;

    public UpdateCommand(Hashtable<Integer, Person> persons) {
        this.persons = persons;
    }

    @Override
    public String getHelp() {
        return "Update the value of the collection element whose id is equal to the given one";
    }

    @Override
    public void execute(IInput input, IOutput output) {
        output.println("Enter the id:");
        int id = Integer.parseInt(input.readLine());

        if (persons.containsKey(id)) {
            Person person = Person.fromInput(input, output);
            persons.put(id, person);
            output.println("Element updated.");
        } else {
            output.println("Element with this id does not exist.");
        }
    }
}