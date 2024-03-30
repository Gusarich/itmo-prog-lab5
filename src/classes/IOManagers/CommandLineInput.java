package classes.IOManagers;

import java.util.Scanner;

public class CommandLineInput implements interfaces.IInput {
    private final Scanner scanner;

    public CommandLineInput() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String readLine() {
        return scanner.nextLine().strip();
    }

    @Override
    public String readNext() {
        return scanner.next().strip();
    }

    @Override
    public void skipLine() {
        scanner.nextLine();
    }
}
