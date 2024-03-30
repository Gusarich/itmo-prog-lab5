package classes.Commands;

import classes.Executor;
import classes.IOManagers.FileInput;
import classes.Person;
import interfaces.ICommand;
import interfaces.IInput;
import interfaces.IOutput;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Set;

/**
 * ExecuteScriptCommand class implements the ICommand interface.
 * It provides methods to get help and execute the command.
 * The execute method executes a script from a specified file.
 */
public class ExecuteScriptCommand implements ICommand {
    Hashtable<Integer, Person> persons;
    HashMap<String, ICommand> commands;
    Set<String> runningScripts;

    /**
     * Constructs a new ExecuteScriptCommand object.
     *
     * @param persons the collection of persons
     * @param commands the collection of commands
     * @param runningScripts the set of used scripts
     */
    public ExecuteScriptCommand(Hashtable<Integer, Person> persons, HashMap<String, ICommand> commands, Set<String> runningScripts) {
        this.persons = persons;
        this.commands = commands;
        this.runningScripts = runningScripts;
    }

    /**
     * Provides help information for the execute script command.
     *
     * @return a string containing the help information
     */
    @Override
    public String getHelp() {
        return "Execute the script from the specified file";
    }

    /**
     * Executes the execute script command.
     * It reads a filename from the input, checks for recursion, and executes the script from the file.
     *
     * @param input the input interface
     * @param output the output interface
     */
    @Override
    public void execute(IInput input, IOutput output) {
        String filename = input.readLine();

        output.println("Executing script " + filename);

        if (runningScripts.contains(filename)) {
            throw new IllegalArgumentException("Recursion detected in " + filename);
        }

        try {
            FileInput fileInput = new FileInput(filename);
            runningScripts.add(filename);
            Executor executor = new Executor(persons, commands, fileInput, output, runningScripts);
            while (fileInput.hasNextLine()) {
                String commandName = fileInput.readNext();
                executor.executeCommand(commandName);
            }
            runningScripts.remove(filename);
        } catch (FileNotFoundException e) {
            output.println("Error reading from file: " + filename);
        } catch (Exception e) {
            output.println("Error executing script: " + filename);
            output.println(e.getMessage());
        }
    }
}
