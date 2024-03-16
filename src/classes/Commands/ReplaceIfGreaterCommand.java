// ReplaceIfGreaterCommand.java
package classes.Commands;

import classes.Person;
import interfaces.ICommand;

import java.util.Hashtable;
import java.util.Scanner;

public class ReplaceIfGreaterCommand implements ICommand {
    private Hashtable<Integer, Person> persons;

    public ReplaceIfGreaterCommand(Hashtable<Integer, Person> persons) {
        this.persons = persons;
    }

    @Override
    public void printHelp() {
        System.out.println("Replace the value by key if the new value is greater than the old one");
    }

    @Override
    public void execute(Scanner scanner) {
        System.out.println("Enter the key:");
        int key = scanner.nextInt();

        if (persons.containsKey(key)) {
            System.out.println("Enter the element:");
            Person element = Person.fromInput(scanner);

            if (element.compareTo(persons.get(key)) > 0) {
                persons.put(key, element);
                System.out.println("Element replaced.");
            } else {
                System.out.println("The new element is not greater than the old one.");
            }
        } else {
            System.out.println("Element with this key does not exist.");
        }
    }
}