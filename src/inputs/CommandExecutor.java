package inputs;

import modals.Command;

public interface CommandExecutor {
    public Boolean validator(Command command);
    public void executor(Command command);
}
