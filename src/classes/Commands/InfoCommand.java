package classes.Commands;

import classes.Person;
import interfaces.ICommand;

import java.util.Hashtable;
import java.util.Scanner;

public class InfoCommand implements ICommand {
    private Hashtable<Integer, Person> persons;

    public InfoCommand(Hashtable<Integer, Person> persons) {
        this.persons = persons;
    }

    @Override
    public void printHelp() {
        System.out.println("Display information about the collection");
    }

    @Override
    public void execute(Scanner scanner) {
        System.out.println("Type: Hashtable");
        System.out.println("Number of elements: " + persons.size());
    }
}
