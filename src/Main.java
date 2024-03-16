import classes.Commands.*;
import classes.Coordinates;
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
                String name = fields[0];
                Coordinates coordinates = new Coordinates(Integer.parseInt(fields[1]), Integer.parseInt(fields[2]));
                int height = Integer.parseInt(fields[3]);
                Color eyeColor = Color.valueOf(fields[4].toUpperCase());
                Color hairColor = Color.valueOf(fields[5].toUpperCase());
                Country nationality = Country.valueOf(fields[6].toUpperCase());
                Location location = new Location(Float.parseFloat(fields[7]), Float.parseFloat(fields[8]), fields[9]);
                Person person = new Person(name, coordinates, height, eyeColor, hairColor, nationality, location);
                persons.put(person.getId(), person);
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
        // commands.put("execute_script", new ExecuteScriptCommand(persons, commands)
        commands.put("exit", new ExitCommand());
        commands.put("remove_greater", new RemoveGreaterCommand(persons));
        commands.put("replace_if_greater", new ReplaceIfGreaterCommand(persons));
        commands.put("remove_lower", new RemoveLowerCommand(persons));
        commands.put("sum_of_height", new SumOfHeightCommand(persons));
        commands.put("group_counting_by_name", new GroupCountingByNameCommand(persons));
        commands.put("print_ascending", new PrintAscendingCommand(persons));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("> ");
            String commandName = scanner.nextLine();

            ICommand command = commands.get(commandName);
            if (command != null) {
                command.execute(scanner);
            } else {
                System.out.println("Unknown command. Use 'help' to get more information.");
            }
        }
    }
}