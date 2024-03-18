package classes.Commands;

import classes.Executer;
import classes.IOManagers.FileInput;
import classes.Person;
import interfaces.ICommand;
import interfaces.IInput;
import interfaces.IOutput;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Set;

public class ExecuteScriptCommand implements ICommand {
    Hashtable<Integer, Person> persons;
    HashMap<String, ICommand> commands;
    Set<String> usedScripts;

    public ExecuteScriptCommand(Hashtable<Integer, Person> persons, HashMap<String, ICommand> commands, Set<String> usedScripts) {
        this.persons = persons;
        this.commands = commands;
        this.usedScripts = usedScripts;
    }

    public String getHelp() {
        return "Execute the script from the specified file";
    }

    public void execute(IInput input, IOutput output) {
        output.println("Enter the filename:");
        String filename = input.readLine();

        if (usedScripts.contains(filename)) {
            output.println("Recursion detected. The script cannot be executed.");
            return;
        }

        try {
            FileInput fileInput = new FileInput(filename);
            usedScripts.add(filename);
            Executer executer = new Executer(persons, commands, fileInput, output, usedScripts);
            while (fileInput.hasNextLine()) {
                String commandName = fileInput.readLine();
                executer.executeCommand(commandName);
            }
            usedScripts.remove(filename);
        } catch (FileNotFoundException e) {
            output.println("Error reading from file: " + filename);
        }
    }
}
