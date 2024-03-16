package classes.Commands;

import classes.Person;
import interfaces.ICommand;
import interfaces.IInputOutput;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class RemoveGreaterCommand implements ICommand {
    private Hashtable<Integer, Person> persons;

    public RemoveGreaterCommand(Hashtable<Integer, Person> persons) {
        this.persons = persons;
    }

    @Override
    public String getHelp() {
        return "Remove all elements from the collection that exceed the specified one";
    }

    @Override
    public void execute(IInputOutput io) {
        io.println("Enter the element:");
        Person element = Person.fromInput(io);

        Iterator<Map.Entry<Integer, Person>> iterator = persons.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Person> entry = iterator.next();
            if (entry.getValue().compareTo(element) > 0) {
                iterator.remove();
            }
        }
        io.println("Elements greater than the specified one have been removed.");
    }
}