package classes.IOManagers;

import java.util.Scanner;

public class CommandLineOutput implements interfaces.IOutput {
    public CommandLineOutput() {
    }

    @Override
    public void print(String message) {
        System.out.print(message);
    }

    @Override
    public void println(String message) {
        System.out.println(message);
    }
}
