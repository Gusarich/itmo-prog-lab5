import classes.Commands.*;
import classes.Coordinates;
import classes.Executer;
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

public class Main {
    private static Hashtable<Integer, Person> persons = new Hashtable<>();
    private static HashMap<String, ICommand> commands = new HashMap<>();
    private static String filename;

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

    public static void main(String[] args) {
        CommandLineInput input = new CommandLineInput();
        CommandLineOutput output = new CommandLineOutput();

        // Load data from file if command line argument is provided
        if (args.length > 0) {
            filename = args[0];
            loadPersonsFromFile(output);
            System.out.println("Loaded " + persons.size() + " persons from " + filename);
        } else {
            System.out.println("No file provided. Use command line argument to load data from file.");
        }

        Set<String> usedScripts = new HashSet<String>();

        // Initialize commands
        commands.put("help", new HelpCommand(commands));
        commands.put("info", new InfoCommand(persons, commands, filename));
        commands.put("show", new ShowCommand(persons));
        commands.put("insert", new InsertCommand(persons));
        commands.put("update", new UpdateCommand(persons));
        commands.put("remove_key", new RemoveKeyCommand(persons));
        commands.put("clear", new ClearCommand(persons));
        commands.put("save", new SaveCommand(persons));
        commands.put("execute_script", new ExecuteScriptCommand(persons, commands, usedScripts));
        commands.put("exit", new ExitCommand());
        commands.put("remove_greater", new RemoveGreaterCommand(persons));
        commands.put("replace_if_greater", new ReplaceIfGreaterCommand(persons));
        commands.put("remove_lower", new RemoveLowerCommand(persons));
        commands.put("sum_of_height", new SumOfHeightCommand(persons));
        commands.put("group_counting_by_name", new GroupCountingByNameCommand(persons));
        commands.put("print_ascending", new PrintAscendingCommand(persons));

        Executer executer = new Executer(persons, commands, input, output, usedScripts);

        while (true) {
            output.print("> ");
            String commandName = input.readLine();
            executer.executeCommand(commandName);
        }
    }
}