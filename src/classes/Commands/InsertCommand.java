package classes.Commands;

import classes.Person;

import java.util.Hashtable;
import java.util.Scanner;

public class InsertCommand implements interfaces.ICommand {
    private Hashtable<Integer, Person> persons;

    public InsertCommand(Hashtable<Integer, Person> persons) {
        this.persons = persons;
    }

    @Override
    public void printHelp() {
        System.out.println("Add a new element with the specified key");
    }

    @Override
    public void execute(Scanner scanner) {
        System.out.println("Enter the key:");
        int key = scanner.nextInt();
        scanner.nextLine();

        Person person = Person.fromInput(scanner);

        persons.put(key, person);
        System.out.println("Element added.");
    }
}