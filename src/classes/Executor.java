package classes;

import interfaces.ICommand;
import interfaces.IInput;
import interfaces.IOutput;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Set;

public class Executor {
    Hashtable<Integer, Person> persons;
    HashMap<String, ICommand> commands;
    IInput input;
    IOutput output;
    Set<String> usedScripts;

    public Executor(Hashtable<Integer, Person> persons, HashMap<String, ICommand> commands, IInput input, IOutput output, Set<String> usedScripts) {
        this.persons = persons;
        this.commands = commands;
        this.input = input;
        this.output = output;
        this.usedScripts = usedScripts;
    }

    public void executeCommand(String commandName) {
        ICommand command = commands.get(commandName);
        if (command != null) {
            command.execute(input, output);
        } else {
            output.println("Unknown command. Use 'help' to get more information.");
        }
    }
}
