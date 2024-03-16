package classes.Commands;

import classes.Person;
import interfaces.ICommand;
import interfaces.IInputOutput;

import java.util.Hashtable;
import java.util.Scanner;

public class RemoveKeyCommand implements ICommand {
    private Hashtable<Integer, Person> persons;

    public RemoveKeyCommand(Hashtable<Integer, Person> persons) {
        this.persons = persons;
    }

    @Override
    public String getHelp() {
        return "Remove an element from the collection by its key";
    }

    @Override
    public void execute(IInputOutput io) {
        io.println("Enter the key:");
        int key = Integer.parseInt(io.readLine());

        if (persons.containsKey(key)) {
            persons.remove(key);
            io.println("Element removed.");
        } else {
            io.println("Element with this key does not exist.");
        }
    }
}