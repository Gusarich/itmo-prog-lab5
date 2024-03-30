import classes.Commands.*;
import classes.Coordinates;
import classes.Executor;
import classes.IOManagers.CommandLineInput;
import classes.IOManagers.CommandLineOutput;
import classes.IOManagers.FileInput;
import classes.Location;
import classes.Person;
import enums.Color;
import enums.Country;
import interfaces.ICommand;
import interfaces.IOutput;

import java.io.FileNotFoundException;
import java.util.*;

/**
 * Main class of the application.
 * It contains methods to load persons from a file and to initialize and execute commands.
 */
public class Main {
    private static final Hashtable<Integer, Person> persons = new Hashtable<>();
    private static final HashMap<String, ICommand> commands = new HashMap<>();
    private static String filename;

    /**
     * Loads persons from a file.
     * It reads lines from the file, parses fields from each line, creates a Person object from the fields, and adds the person to the collection.
     *
     * @param output the output interface
     */
    public static void loadPersonsFromFile(IOutput output) {
        try {
            FileInput fileIO = new FileInput(filename);
            while (fileIO.hasNextLine()) {
                String line = fileIO.readLine();
                String[] fields = line.split(",");
                int key = Integer.parseInt(fields[0]);
                String name = fields[1];
                Coordinates coordinates = new Coordinates(Integer.parseInt(fields[2]), Integer.parseInt(fields[3]));
                int height = Integer.parseInt(fields[4]);
                Color eyeColor = Color.valueOf(fields[5].toUpperCase());
                Color hairColor = Color.valueOf(fields[6].toUpperCase());
                Country nationality = Country.valueOf(fields[7].toUpperCase());
                Location location = new Location(Float.parseFloat(fields[8]), Float.parseFloat(fields[9]), fields[10]);
                Person person = new Person(name, coordinates, height, eyeColor, hairColor, nationality, location);
                persons.put(key, person);
            }
        } catch (FileNotFoundException e) {
            output.println("File not found: " + filename);
        } catch (NumberFormatException e) {
            output.println("Error parsing number from file: " + filename);
        } catch (IllegalArgumentException e) {
            output.println("Error parsing enum value from file: " + filename);
        }
    }

    /**
     * The main method of the application.
     * It initializes the input and output interfaces, loads persons from a file if a filename is provided as a command line argument, initializes commands, and enters a loop to read and execute commands.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CommandLineInput input = new CommandLineInput();
        CommandLineOutput output = new CommandLineOutput();

        // Load data from file if command line argument is provided
        if (args.length > 0) {
            filename = args[0];
            loadPersonsFromFile(output);
            output.println("Loaded " + persons.size() + " persons from " + filename);
        } else {
            output.println("No file provided. Use command line argument to load data from file.");
        }

        Set<String> runningScripts = new HashSet<>();

        // Initialize commands
        commands.put("help", new HelpCommand(commands));
        commands.put("info", new InfoCommand(persons, commands, filename));
        commands.put("show", new ShowCommand(persons));
        commands.put("insert", new InsertCommand(persons));
        commands.put("update", new UpdateCommand(persons));
        commands.put("remove_key", new RemoveKeyCommand(persons));
        commands.put("clear", new ClearCommand(persons));
        commands.put("save", new SaveCommand(persons));
        commands.put("execute_script", new ExecuteScriptCommand(persons, commands, runningScripts));
        commands.put("exit", new ExitCommand());
        commands.put("remove_greater", new RemoveGreaterCommand(persons));
        commands.put("replace_if_greater", new ReplaceIfGreaterCommand(persons));
        commands.put("remove_lower", new RemoveLowerCommand(persons));
        commands.put("sum_of_height", new SumOfHeightCommand(persons));
        commands.put("group_counting_by_name", new GroupCountingByNameCommand(persons));
        commands.put("print_ascending", new PrintAscendingCommand(persons));

        Executor executor = new Executor(persons, commands, input, output, runningScripts);

        while (true) {
            output.print("> ");
            String commandName = input.readNext();
            try {
                executor.executeCommand(commandName);
            } catch (Exception e) {
                output.println("\nError executing command: " + e.getMessage());
            }
        }
    }
}
