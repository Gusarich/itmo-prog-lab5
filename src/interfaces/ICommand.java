package interfaces;

import classes.Person;

import java.util.Hashtable;
import java.util.Scanner;

public interface ICommand {
    String getHelp();
    void execute(IInputOutput io);
}
