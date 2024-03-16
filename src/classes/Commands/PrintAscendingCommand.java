// PrintAscendingCommand.java
package classes.Commands;

import classes.Person;
import interfaces.ICommand;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class PrintAscendingCommand implements ICommand {
    private Hashtable<Integer, Person> persons;

    public PrintAscendingCommand(Hashtable<Integer, Person> persons) {
        this.persons = persons;
    }

    @Override
    public void printHelp() {
        System.out.println("Print collection elements in ascending order");
    }

    @Override
    public void execute(Scanner scanner) {
        List<Person> sortedPersons = new ArrayList<>(persons.values());
        sortedPersons.sort(Person::compareTo);

        for (Person person : sortedPersons) {
            System.out.println(person);
        }
    }
}