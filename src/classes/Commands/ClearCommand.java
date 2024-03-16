package classes.Commands;

import classes.Person;
import interfaces.ICommand;

import java.util.Hashtable;
import java.util.Scanner;

public class ClearCommand implements ICommand {
    private Hashtable<Integer, Person> persons;

    public ClearCommand(Hashtable<Integer, Person> persons) {
        this.persons = persons;
    }

    @Override
    public void printHelp() {
        System.out.println("Clear the collection");
    }

    @Override
    public void execute(Scanner scanner) {
        persons.clear();
        System.out.println("Collection cleared.");
    }
}
