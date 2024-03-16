package classes.IOManagers;

import interfaces.IInputOutput;

import java.io.*;
import java.util.Scanner;

public class FileIO implements IInputOutput {
    private Scanner scanner;
    private PrintWriter writer;
    private String filename;

    public FileIO(String filename) throws FileNotFoundException {
        this.filename = filename;
        this.scanner = new Scanner(new File(filename));
        OutputStream os = new FileOutputStream(filename);
        BufferedOutputStream bos = new BufferedOutputStream(os);
        this.writer = new PrintWriter(new OutputStreamWriter(bos));
    }

    @Override
    public void print(String message) {
        writer.print(message);
    }

    @Override
    public void println(String message) {
        writer.println(message);
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
