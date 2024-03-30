package classes;

import interfaces.ICommand;
import interfaces.IInput;
import interfaces.IOutput;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Set;

/**
 * Executor class is responsible for executing commands.
 * It maintains a list of persons, commands, used scripts and handles input and output.
 */
public class Executor {
    // Hashtable storing persons with their IDs as keys
    Hashtable<Integer, Person> persons;
    // HashMap storing commands with their names as keys
    HashMap<String, ICommand> commands;
    // Input interface
    IInput input;
    // Output interface
    IOutput output;
    // Set storing used scripts
    Set<String> usedScripts;

    /**
     * Constructs a new Executor with the given attributes.
     *
     * @param persons Hashtable of persons
     * @param commands HashMap of commands
     * @param input Input interface
     * @param output Output interface
     * @param usedScripts Set of used scripts
     */
    public Executor(Hashtable<Integer, Person> persons, HashMap<String, ICommand> commands, IInput input, IOutput output, Set<String> usedScripts) {
        this.persons = persons;
        this.commands = commands;
        this.input = input;
        this.output = output;
        this.usedScripts = usedScripts;
    }

    /**
     * Executes the command with the given name.
     * If the command does not exist, it prints an error message.
     *
     * @param commandName the name of the command to execute
     */
    public void executeCommand(String commandName) {
        ICommand command = commands.get(commandName);
        if (command != null) {
            command.execute(input, output);
        } else {
            output.println("Unknown command. Use 'help' to get more information.");
        }
    }
}