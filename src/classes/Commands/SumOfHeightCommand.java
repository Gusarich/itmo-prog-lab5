// SumOfHeightCommand.java
package classes.Commands;

import classes.Person;
import interfaces.ICommand;
import interfaces.IInputOutput;

import java.util.Hashtable;
import java.util.Scanner;

public class SumOfHeightCommand implements ICommand {
    private Hashtable<Integer, Person> persons;

    public SumOfHeightCommand(Hashtable<Integer, Person> persons) {
        this.persons = persons;
    }

    @Override
    public String getHelp() {
        return "Print the sum of the height field values for all collection elements";
    }

    @Override
    public void execute(IInputOutput io) {
        int sum = persons.values().stream().mapToInt(Person::getHeight).sum();
        io.println("The sum of the height field values is " + sum + ".");
    }
}