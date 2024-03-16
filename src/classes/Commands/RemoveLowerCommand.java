// RemoveLowerCommand.java
package classes.Commands;

import classes.Person;
import interfaces.ICommand;
import interfaces.IInputOutput;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class RemoveLowerCommand implements ICommand {
    private Hashtable<Integer, Person> persons;

    public RemoveLowerCommand(Hashtable<Integer, Person> persons) {
        this.persons = persons;
    }

    @Override
    public String getHelp() {
        return "Remove all elements from the collection that are less than the specified one";
    }

    @Override
    public void execute(IInputOutput io) {
        io.println("Enter the element:");
        Person element = Person.fromInput(io);

        Iterator<Map.Entry<Integer, Person>> iterator = persons.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Person> entry = iterator.next();
            if (entry.getValue().compareTo(element) < 0) {
                iterator.remove();
            }
        }
        io.println("Elements less than the specified one have been removed.");
    }
}