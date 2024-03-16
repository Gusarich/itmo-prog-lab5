package classes.Commands;

import classes.Person;
import interfaces.ICommand;
import interfaces.IInputOutput;

import java.util.Hashtable;

public class UpdateCommand implements ICommand {
    private Hashtable<Integer, Person> persons;

    public UpdateCommand(Hashtable<Integer, Person> persons) {
        this.persons = persons;
    }

    @Override
    public String getHelp() {
        return "Update the value of the collection element whose id is equal to the given one";
    }

    @Override
    public void execute(IInputOutput io) {
        io.println("Enter the id:");
        int id = Integer.parseInt(io.readLine());

        if (persons.containsKey(id)) {
            Person person = Person.fromInput(io);
            persons.put(id, person);
            io.println("Element updated.");
        } else {
            io.println("Element with this id does not exist.");
        }
    }
}