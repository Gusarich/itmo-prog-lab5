package classes.Commands;

import classes.Person;
import interfaces.IInputOutput;

import java.util.Hashtable;
import java.util.Scanner;

public class ShowCommand implements interfaces.ICommand {
    private Hashtable<Integer, Person> persons;

    public ShowCommand(Hashtable<Integer, Person> persons) {
        this.persons = persons;
    }

    @Override
    public String getHelp() {
        return "Show all elements of the collection";
    }

    @Override
    public void execute(IInputOutput io) {
        io.println("Collection:");
        persons.forEach((key, person) -> {
            io.print(key + " => ");
            io.println(person.toString());
        });
    }
}
