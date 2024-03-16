package classes.Commands;

import interfaces.ICommand;
import interfaces.IInputOutput;

import javax.imageio.stream.IIOByteBuffer;
import java.util.HashMap;
import java.util.Scanner;

public class HelpCommand implements ICommand {
    private HashMap<String, ICommand> commands;

    public HelpCommand(HashMap<String, ICommand> commands) {
        this.commands = commands;
    }

    @Override
    public String getHelp() {
        return "Display help information";
    }

    @Override
    public void execute(IInputOutput io) {
        commands.forEach((name, command) -> {
            io.println(name + " - " + command.getHelp());
        });
    }
}
