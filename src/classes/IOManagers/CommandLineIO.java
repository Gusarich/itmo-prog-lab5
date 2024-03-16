package classes.IOManagers;

import java.util.Scanner;

public class CommandLineIO implements interfaces.IInputOutput {
    private final Scanner scanner;

    public CommandLineIO(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void print(String message) {
        System.out.print(message);
    }

    @Override
    public void println(String message) {
        System.out.println(message);
    }

    @Override
    public String readLine() {
        return scanner.nextLine();
    }

    @Override
    public String readNext() {
        return scanner.next();
    }
}
