package classes.Commands;

import classes.Person;
import interfaces.ICommand;

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
    public void printHelp() {
        System.out.println("Save the collection to a file");
    }

    @Override
    public void execute(Scanner scanner) {
        System.out.println("Enter the filename:");
        String filename = scanner.nextLine();

        try (OutputStream os = new FileOutputStream(filename);
             BufferedOutputStream bos = new BufferedOutputStream(os);
             PrintWriter writer = new PrintWriter(new OutputStreamWriter(bos))) {

            for (Person person : persons.values()) {
                writer.println(person.toCSV());
            }

            System.out.println("The collection has been saved to " + filename + ".");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + filename);
        }
    }
}