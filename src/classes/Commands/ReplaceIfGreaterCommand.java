// ReplaceIfGreaterCommand.java
package classes.Commands;

import classes.Person;
import interfaces.ICommand;
import interfaces.IInputOutput;

import java.util.Hashtable;
import java.util.Scanner;

public class ReplaceIfGreaterCommand implements ICommand {
    private Hashtable<Integer, Person> persons;

    public ReplaceIfGreaterCommand(Hashtable<Integer, Person> persons) {
        this.persons = persons;
    }

    @Override
    public String getHelp() {
        return "Replace the value by key if the new value is greater than the old one";
    }

    @Override
    public void execute(IInputOutput io) {
        io.println("Enter the key:");
        int key = Integer.parseInt(io.readLine());

        if (persons.containsKey(key)) {
            io.println("Enter the element:");
            Person element = Person.fromInput(io);

            if (element.compareTo(persons.get(key)) > 0) {
                persons.put(key, element);
                io.println("Element replaced.");
            } else {
                io.println("The new element is not greater than the old one.");
            }
        } else {
            io.println("Element with this key does not exist.");
        }
    }
}