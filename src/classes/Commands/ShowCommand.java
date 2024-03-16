package classes.Commands;

import classes.Person;

import java.util.Hashtable;
import java.util.Scanner;

public class ShowCommand implements interfaces.ICommand {
    private Hashtable<Integer, Person> persons;

    public ShowCommand(Hashtable<Integer, Person> persons) {
        this.persons = persons;
    }

    @Override
    public void printHelp() {
        System.out.println("Show all elements of the collection");
    }

    @Override
    public void execute(Scanner scanner) {
        System.out.println("Collection:");
        for (Person person : persons.values()) {
            System.out.println(person);
        }
    }
}
