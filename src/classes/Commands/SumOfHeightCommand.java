// SumOfHeightCommand.java
package classes.Commands;

import classes.Person;
import interfaces.ICommand;
import interfaces.IInput;
import interfaces.IOutput;

import java.util.Hashtable;

public class SumOfHeightCommand implements ICommand {
    private final Hashtable<Integer, Person> persons;

    public SumOfHeightCommand(Hashtable<Integer, Person> persons) {
        this.persons = persons;
    }

    @Override
    public String getHelp() {
        return "Print the sum of the height field values for all collection elements";
    }

    @Override
    public void execute(IInput input, IOutput output) {
        int sum = persons.values().stream().mapToInt(Person::getHeight).sum();
        output.println("The sum of the height field values is " + sum + ".");
    }
}