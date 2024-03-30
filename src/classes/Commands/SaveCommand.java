package classes.Commands;

import classes.IOManagers.FileOutput;
import classes.Person;
import interfaces.ICommand;
import interfaces.IInput;
import interfaces.IOutput;

import java.io.*;
import java.util.Hashtable;

/**
 * SaveCommand class implements the ICommand interface.
 * It provides methods to get help and execute the command.
 * The execute method saves the collection to a file.
 */
public class SaveCommand implements ICommand {
    private final Hashtable<Integer, Person> persons;

    /**
     * Constructs a new SaveCommand object.
     *
     * @param persons the collection of persons to be saved to a file
     */
    public SaveCommand(Hashtable<Integer, Person> persons) {
        this.persons = persons;
    }

    /**
     * Provides help information for the save command.
     *
     * @return a string containing the help information
     */
    @Override
    public String getHelp() {
        return "Save the collection to a file";
    }

    /**
     * Executes the save command.
     * It reads a filename from the input, saves the collection to the file, and prints a message to the output.
     *
     * @param input the input interface
     * @param output the output interface
     */
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
