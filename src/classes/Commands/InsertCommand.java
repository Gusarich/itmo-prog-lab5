package classes.Commands;

import classes.Person;
import interfaces.IInput;
import interfaces.IOutput;

import java.util.Hashtable;

public class InsertCommand implements interfaces.ICommand {
    private final Hashtable<Integer, Person> persons;

    public InsertCommand(Hashtable<Integer, Person> persons) {
        this.persons = persons;
    }

    @Override
    public String getHelp() {
        return "Add a new element with the specified key";
    }

    @Override
    public void execute(IInput input, IOutput output) {
        input.skipLine();

        output.print("Enter the key: ");
        int key = Integer.parseInt(input.readLine());

        Person person = Person.fromInput(input, output);

        persons.put(key, person);
        output.println("Element added.");
    }
}