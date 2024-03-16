// GroupCountingByNameCommand.java
package classes.Commands;

import classes.Person;
import interfaces.ICommand;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GroupCountingByNameCommand implements ICommand {
    private Hashtable<Integer, Person> persons;

    public GroupCountingByNameCommand(Hashtable<Integer, Person> persons) {
        this.persons = persons;
    }

    @Override
    public void printHelp() {
        System.out.println("Group collection elements by the value of the name field, print the number of elements in each group");
    }

    @Override
    public void execute(Scanner scanner) {
        Map<String, Long> groups = persons.values().stream()
                .collect(Collectors.groupingBy(Person::getName, Collectors.counting()));

        for (Map.Entry<String, Long> entry : groups.entrySet()) {
            System.out.println("Name: " + entry.getKey() + ", Count: " + entry.getValue());
        }
    }
}