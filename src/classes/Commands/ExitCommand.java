package classes.Commands;

public class ExitCommand implements interfaces.ICommand {
    public void printHelp() {
        System.out.println("Exit the program");
    }

    public void execute(java.util.Scanner scanner) {
        System.out.println("Exiting...");
        System.exit(0);
    }
}
