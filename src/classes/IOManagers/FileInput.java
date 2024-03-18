package classes.IOManagers;

import interfaces.IInput;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileInput implements IInput {
    private Scanner scanner;

    public FileInput(String filename) throws FileNotFoundException {
        this.scanner = new Scanner(new File(filename));
    }

    @Override
    public String readLine() {
        return scanner.nextLine();
    }

    @Override
    public String readNext() {
        return scanner.next();
    }

    public boolean hasNextLine() {
        return scanner.hasNextLine();
    }
}
