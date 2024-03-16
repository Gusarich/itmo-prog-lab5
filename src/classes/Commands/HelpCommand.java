package classes.Commands;

import interfaces.ICommand;

import java.util.HashMap;
import java.util.Scanner;

public class HelpCommand implements ICommand {
    private HashMap<String, ICommand> commands;

    public HelpCommand(HashMap<String, ICommand> commands) {
        this.commands = commands;
    }

    @Override
    public void printHelp() {
        System.out.println("Display help information");
    }

    @Override
    public void execute(Scanner scanner) {
        commands.forEach((name, command) -> {
            System.out.print(name + " - ");
            command.printHelp();
        });
    }
}
