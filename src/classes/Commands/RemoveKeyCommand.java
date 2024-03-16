package classes.Commands;

import classes.Person;
import interfaces.ICommand;

import java.util.Hashtable;
import java.util.Scanner;

public class RemoveKeyCommand implements ICommand {
    private Hashtable<Integer, Person> persons;

    public RemoveKeyCommand(Hashtable<Integer, Person> persons) {
        this.persons = persons;
    }

    @Override
    public void printHelp() {
        System.out.println("Remove an element from the collection by its key");
    }

    @Override
    public void execute(Scanner scanner) {
        System.out.println("Enter the key:");
        int key = scanner.nextInt();

        if (persons.containsKey(key)) {
            persons.remove(key);
            System.out.println("Element removed.");
        } else {
            System.out.println("Element with this key does not exist.");
        }
    }
}