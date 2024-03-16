package classes.Commands;

import classes.Person;
import interfaces.ICommand;
import interfaces.IInputOutput;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Hashtable;
import java.util.Scanner;

public class SaveCommand implements ICommand {
    private Hashtable<Integer, Person> persons;

    public SaveCommand(Hashtable<Integer, Person> persons) {
        this.persons = persons;
    }

    @Override
    public String getHelp() {
        return "Save the collection to a file";
    }

    @Override
    public void execute(IInputOutput io) {
        io.println("Enter the filename:");
        String filename = io.readLine();

        try (OutputStream os = new FileOutputStream(filename);
             BufferedOutputStream bos = new BufferedOutputStream(os);
             PrintWriter writer = new PrintWriter(new OutputStreamWriter(bos))) {

            for (Person person : persons.values()) {
                writer.println(person.toCSV());
            }

            io.println("The collection has been saved to " + filename + ".");
        } catch (IOException e) {
            io.println("Error writing to file: " + filename);
        }
    }
}