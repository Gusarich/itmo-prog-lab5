package classes.Commands;

import interfaces.IInputOutput;

public class ExitCommand implements interfaces.ICommand {
    public String getHelp() {
        return "Exit the program";
    }

    public void execute(IInputOutput io) {
        io.println("Exiting...");
        System.exit(0);
    }
}
