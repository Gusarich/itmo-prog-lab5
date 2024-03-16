import classes.Commands.*;
import classes.Coordinates;
import classes.Executer;
import classes.IOManagers.CommandLineIO;
import classes.Location;
import classes.Person;
import enums.Color;
import enums.Country;
import interfaces.ICommand;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;

public class Main {
    private static Hashtable<Integer, Person> persons = new Hashtable<>();
    private static HashMap<String, ICommand> commands = new HashMap<>();
    private static String filename;

    public static void loadPersonsFromFile() {
        File file = new File(filename);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
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
            System.out.println("File not found: " + filename);
        } catch (NumberFormatException e) {
            System.out.println("Error parsing number from file: " + filename);
        } catch (IllegalArgumentException e) {
            System.out.println("Error parsing enum value from file: " + filename);
        }
    }

    public static void main(String[] args) {
        // Load data from file if command line argument is provided
        if (args.length > 0) {
            filename = args[0];
            loadPersonsFromFile();
            System.out.println("Loaded " + persons.size() + " persons from " + filename);
        } else {
            System.out.println("No file provided. Use command line argument to load data from file.");
        }

        // Initialize commands
        commands.put("help", new HelpCommand(commands));
        commands.put("info", new InfoCommand(persons, commands, filename));
        commands.put("show", new ShowCommand(persons));
        commands.put("insert", new InsertCommand(persons));
        commands.put("update", new UpdateCommand(persons));
        commands.put("remove_key", new RemoveKeyCommand(persons));
        commands.put("clear", new ClearCommand(persons));
        commands.put("save", new SaveCommand(persons));
        commands.put("execute_script", new ExecuteScriptCommand(persons, commands));
        commands.put("exit", new ExitCommand());
        commands.put("remove_greater", new RemoveGreaterCommand(persons));
        commands.put("replace_if_greater", new ReplaceIfGreaterCommand(persons));
        commands.put("remove_lower", new RemoveLowerCommand(persons));
        commands.put("sum_of_height", new SumOfHeightCommand(persons));
        commands.put("group_counting_by_name", new GroupCountingByNameCommand(persons));
        commands.put("print_ascending", new PrintAscendingCommand(persons));

        Scanner scanner = new Scanner(System.in);
        CommandLineIO io = new CommandLineIO(scanner);

        Executer executer = new Executer(persons, commands, io);

        while (true) {
            System.out.print("> ");
            String commandName = scanner.nextLine();
            executer.executeCommand(commandName);
        }
    }
}