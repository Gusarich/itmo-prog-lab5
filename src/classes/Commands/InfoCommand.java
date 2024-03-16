package classes.Commands;

import classes.Person;
import interfaces.ICommand;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;

public class InfoCommand implements ICommand {
    private Hashtable<Integer, Person> persons;
    private HashMap<String, ICommand> commands;
    private String filename;

    public InfoCommand(Hashtable<Integer, Person> persons, HashMap<String, ICommand> commands, String filename) {
        this.persons = persons;
        this.commands = commands;
        this.filename = filename;
    }

    @Override
    public void printHelp() {
        System.out.println("Display information about the collection");
    }

    @Override
    public void execute(Scanner scanner) {
        System.out.println("Number of elements: " + persons.size());
        System.out.println("Number of commands: " + commands.size());
        System.out.println("Filename: " + filename);
    }
}
