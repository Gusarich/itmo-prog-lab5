package interfaces;

import classes.Person;

import java.util.Hashtable;
import java.util.Scanner;
import java.util.Set;

public interface ICommand {
    String getHelp();
    void execute(IInput input, IOutput output);
}
