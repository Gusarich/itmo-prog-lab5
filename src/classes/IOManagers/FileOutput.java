package classes.IOManagers;

import interfaces.IOutput;

import java.io.*;

public class FileOutput implements IOutput {
    private final PrintWriter writer;

    public FileOutput(String filename) throws FileNotFoundException {
        OutputStream os = new FileOutputStream(filename);
        BufferedOutputStream bos = new BufferedOutputStream(os);
        this.writer = new PrintWriter(new OutputStreamWriter(bos));
    }

    @Override
    public void print(String message) {
        writer.print(message);
        writer.flush();
    }

    @Override
    public void println(String message) {
        writer.println(message);
        writer.flush();
    }

    public void close() {
        writer.close();
    }
}

