package classes.Commands;

import interfaces.IInput;
import interfaces.IOutput;

public class ExitCommand implements interfaces.ICommand {
    public String getHelp() {
        return "Exit the program";
    }

    public void execute(IInput input, IOutput output) {
        output.println("Exiting...");
        System.exit(0);
    }
}
