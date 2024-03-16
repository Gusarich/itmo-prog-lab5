package classes.IOManagers;

import enums.FileIOMode;
import interfaces.IInputOutput;

import java.io.*;
import java.util.Scanner;

public class FileIO implements IInputOutput {
    private Scanner scanner;
    private PrintWriter writer;
    private FileIOMode mode;

    public FileIO(String filename, FileIOMode mode) throws FileNotFoundException {
        if (mode == FileIOMode.READ || mode == FileIOMode.READ_WRITE) {
            this.scanner = new Scanner(new File(filename));
        }
        if (mode == FileIOMode.WRITE || mode == FileIOMode.READ_WRITE) {
            OutputStream os = new FileOutputStream(filename);
            BufferedOutputStream bos = new BufferedOutputStream(os);
            this.writer = new PrintWriter(new OutputStreamWriter(bos));
        }
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
