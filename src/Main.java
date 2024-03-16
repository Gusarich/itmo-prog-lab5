import classes.Commands.*;
import classes.Person;
import interfaces.ICommand;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;

public class Main {
    private static Hashtable<Integer, Person> persons = new Hashtable<>();
    private static HashMap<String, ICommand> commands = new HashMap<>();

    public static void main(String[] args) {
        // Load data from file if command line argument is provided
        if (args.length > 0) {
            // todo
        }

        // Initialize commands
        commands.put("show", new ShowCommand(persons));
        commands.put("exit", new ExitCommand());

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("> ");
            String commandName = scanner.next();

            ICommand command = commands.get(commandName);
            if (command != null) {
                command.execute(scanner);
            } else {
                System.out.println("Unknown command. Use 'help' to get more information.");
            }
        }
    }
}