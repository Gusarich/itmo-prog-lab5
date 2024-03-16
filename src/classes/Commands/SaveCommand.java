package classes.Commands;

import classes.IOManagers.FileIO;
import classes.Person;
import enums.FileIOMode;
import interfaces.ICommand;
import interfaces.IInputOutput;

import java.io.*;
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
        FileIO fileIO = null;
        try {
            fileIO = new FileIO(filename, FileIOMode.WRITE);
        } catch (FileNotFoundException e) {
            io.println("Error writing to file: " + filename);
            return;
        }

        for (Person person : persons.values()) {
            fileIO.println(person.toCSV());
        }

        io.println("The collection has been saved to " + filename + ".");
    }
}