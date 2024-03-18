package classes.Commands;

import classes.Person;
import interfaces.ICommand;
import interfaces.IInput;
import interfaces.IOutput;

import java.util.HashMap;
import java.util.Hashtable;

public class InfoCommand implements ICommand {
    private final Hashtable<Integer, Person> persons;
    private final HashMap<String, ICommand> commands;
    private final String filename;

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
    public void execute(IInput input, IOutput output) {
        output.println("Number of elements: " + persons.size());
        output.println("Number of commands: " + commands.size());
        output.println("Filename: " + filename);
    }
}
