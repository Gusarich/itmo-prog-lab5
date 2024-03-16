package classes.Commands;

import classes.Person;
import interfaces.ICommand;
import interfaces.IInputOutput;

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
    public String getHelp() {
        return "Display information about the collection";
    }

    @Override
    public void execute(IInputOutput io) {
        io.println("Number of elements: " + persons.size());
        io.println("Number of commands: " + commands.size());
        io.println("Filename: " + filename);
    }
}
