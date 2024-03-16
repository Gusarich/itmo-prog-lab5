package interfaces;

import classes.Person;

import java.util.Hashtable;
import java.util.Scanner;

public interface ICommand {
    void printHelp();
    void execute(Scanner scanner);
}
