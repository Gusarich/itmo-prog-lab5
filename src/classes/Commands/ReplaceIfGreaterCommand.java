// ReplaceIfGreaterCommand.java
package classes.Commands;

import classes.Person;
import interfaces.ICommand;
import interfaces.IInput;
import interfaces.IOutput;

import java.util.Hashtable;

public class ReplaceIfGreaterCommand implements ICommand {
    private final Hashtable<Integer, Person> persons;

    public ReplaceIfGreaterCommand(Hashtable<Integer, Person> persons) {
        this.persons = persons;
    }

    @Override
    public String getHelp() {
        return "Replace the value by key if the new value is greater than the old one";
    }

    @Override
    public void execute(IInput input, IOutput output) {
        output.println("Enter the key:");
        int key = Integer.parseInt(input.readLine());

        if (persons.containsKey(key)) {
            output.println("Enter the element:");
            Person element = Person.fromInput(input, output);

            if (element.compareTo(persons.get(key)) > 0) {
                persons.put(key, element);
                output.println("Element replaced.");
            } else {
                output.println("The new element is not greater than the old one.");
            }
        } else {
            output.println("Element with this key does not exist.");
        }
    }
}