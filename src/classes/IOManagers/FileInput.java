package classes.IOManagers;

import interfaces.IInput;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileInput implements IInput {
    private final Scanner scanner;

    public FileInput(String filename) throws FileNotFoundException {
        this.scanner = new Scanner(new File(filename));
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

    public boolean hasNextLine() {
        return scanner.hasNextLine();
    }
}
