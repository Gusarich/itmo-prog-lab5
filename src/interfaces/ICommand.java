package interfaces;

public interface ICommand {
    String getHelp();
    void execute(IInput input, IOutput output);
}
