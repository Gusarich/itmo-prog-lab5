package classes.Commands;

import classes.IOManagers.FileOutput;
import classes.Person;
import interfaces.ICommand;
import interfaces.IInput;
import interfaces.IOutput;

import java.io.*;
import java.util.Hashtable;

public class SaveCommand implements ICommand {
    private final Hashtable<Integer, Person> persons;

    public SaveCommand(Hashtable<Integer, Person> persons) {
        this.persons = persons;
    }

    @Override
    public String getHelp() {
        return "Save the collection to a file";
    }

    @Override
    public void execute(IInput input, IOutput output) {
        output.print("Enter the filename: ");
        String filename = input.readLine();
        try {
            FileOutput fileOutput = new FileOutput(filename);
            for (Person person : persons.values()) {
                fileOutput.println(person.toCSV());
            }
            fileOutput.close();
        } catch (FileNotFoundException e) {
            output.println("Error writing to file: " + filename);
            return;
        }

        output.println("The collection has been saved to " + filename + ".");
    }
}