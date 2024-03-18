package classes.Commands;

import interfaces.ICommand;
import interfaces.IInput;
import interfaces.IOutput;

import java.util.HashMap;

public class HelpCommand implements ICommand {
    private final HashMap<String, ICommand> commands;

    public HelpCommand(HashMap<String, ICommand> commands) {
        this.commands = commands;
    }

    @Override
    public String getHelp() {
        return "Display help information";
    }

    @Override
    public void execute(IInput input, IOutput output) {
        commands.forEach((name, command) -> {
            output.println(name + " - " + command.getHelp());
        });
    }
}
