package classes.Commands;

import classes.Executer;
import classes.IOManagers.FileIO;
import classes.Person;
import interfaces.ICommand;
import interfaces.IInputOutput;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Hashtable;

public class ExecuteScriptCommand implements ICommand {
    Hashtable<Integer, Person> persons;
    HashMap<String, ICommand> commands;

    public ExecuteScriptCommand(Hashtable<Integer, Person> persons, HashMap<String, ICommand> commands) {
        this.persons = persons;
        this.commands = commands;
    }

    public String getHelp() {
        return "Execute the script from the specified file";
    }

    public void execute(IInputOutput io) {
        io.println("Enter the filename:");
        String filename = io.readLine();

        try {
            FileIO fileIO = new FileIO(filename, enums.FileIOMode.READ);
            Executer executer = new Executer(persons, commands, io);
            while (fileIO.hasNextLine()) {
                String commandName = fileIO.readLine();
                executer.executeCommand(commandName);
            }
        } catch (FileNotFoundException e) {
            io.println("Error reading from file: " + filename);
        }
    }
}
