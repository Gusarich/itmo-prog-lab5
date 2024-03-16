package classes.Commands;

import classes.Person;
import interfaces.IInputOutput;

import java.util.Hashtable;
import java.util.Scanner;

public class InsertCommand implements interfaces.ICommand {
    private Hashtable<Integer, Person> persons;

    public InsertCommand(Hashtable<Integer, Person> persons) {
        this.persons = persons;
    }

    @Override
    public String getHelp() {
        return "Add a new element with the specified key";
    }

    @Override
    public void execute(IInputOutput io) {
        io.println("Enter the key:");
        int key = Integer.parseInt(io.readLine());

        Person person = Person.fromInput(io);

        persons.put(key, person);
        io.println("Element added.");
    }
}