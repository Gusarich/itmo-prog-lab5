package classes;

import interfaces.ICommand;
import interfaces.IInputOutput;
import java.util.HashMap;
import java.util.Hashtable;

public class Executer {
    Hashtable<Integer, Person> persons;
    HashMap<String, ICommand> commands;
    IInputOutput io;

    public Executer(Hashtable<Integer, Person> persons, HashMap<String, ICommand> commands, IInputOutput io) {
        this.persons = persons;
        this.commands = commands;
        this.io = io;
    }

    public void executeCommand(String commandName) {
        ICommand command = commands.get(commandName);
        if (command != null) {
            command.execute(io);
        } else {
            System.out.println("Unknown command. Use 'help' to get more information.");
        }
    }
}
