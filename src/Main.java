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
        commands.put("help", new HelpCommand(commands));
        commands.put("info", new InfoCommand(persons));
        commands.put("show", new ShowCommand(persons));
        commands.put("insert", new InsertCommand(persons));
        commands.put("update", new UpdateCommand(persons));
        commands.put("remove_key", new RemoveKeyCommand(persons));
        commands.put("clear", new ClearCommand(persons));
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