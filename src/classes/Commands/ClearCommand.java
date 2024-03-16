package classes.Commands;

import classes.Person;
import interfaces.ICommand;
import interfaces.IInputOutput;

import java.util.Hashtable;
import java.util.Scanner;

public class ClearCommand implements ICommand {
    private Hashtable<Integer, Person> persons;

    public ClearCommand(Hashtable<Integer, Person> persons) {
        this.persons = persons;
    }

    @Override
    public String getHelp() {
        return "Clear the collection";
    }

    @Override
    public void execute(IInputOutput io) {
        persons.clear();
        io.println("Collection cleared.");
    }
}
