package classes.Commands;

import classes.Person;
import interfaces.ICommand;

import java.util.Hashtable;
import java.util.Scanner;

public class UpdateCommand implements ICommand {
    private Hashtable<Integer, Person> persons;

    public UpdateCommand(Hashtable<Integer, Person> persons) {
        this.persons = persons;
    }

    @Override
    public void printHelp() {
        System.out.println("Update the value of the collection element whose id is equal to the given one");
    }

    @Override
    public void execute(Scanner scanner) {
        System.out.println("Enter the id:");
        int id = scanner.nextInt();

        if (persons.containsKey(id)) {
            Person person = Person.fromInput(scanner);
            persons.put(id, person);
            System.out.println("Element updated.");
        } else {
            System.out.println("Element with this id does not exist.");
        }
    }
}