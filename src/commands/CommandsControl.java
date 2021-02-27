package commands;

import collection.CreationPriorityQueue;

import java.util.HashMap;

public class CommandsControl {
    private HashMap<TypeOfCommands, Commands> commands = new HashMap();
    {
        commands.put(TypeOfCommands.HELP, new Help());
        commands.put(TypeOfCommands.SHOW, new Show());
        commands.put(TypeOfCommands.INFO, new Info());
        commands.put(TypeOfCommands.ADD, new Add());
        commands.put(TypeOfCommands.UPDATEID, new UpdateId());
        commands.put(TypeOfCommands.REMOVEBYID, new RemoveById());
        commands.put(TypeOfCommands.CLEAR, new CommandClear());
        commands.put(TypeOfCommands.SAVE, new CommandSave());
        commands.put(TypeOfCommands.EXECUTESCRIPT, new ExecuteScript());
        commands.put(TypeOfCommands.EXIT, new CommandExit());
        commands.put(TypeOfCommands.REMOVEHEAD, new RemoveHead());
        commands.put(TypeOfCommands.ADDIFMAX, new AddIfMax());
        commands.put(TypeOfCommands.ADDIFMIN, new AddIfMin());
        commands.put(TypeOfCommands.AVERAGEOFMETERSABOVESEALEVEL, new AverageOfMetersAboveSeaLevel());
        commands.put(TypeOfCommands.GROUPCOUNTINGBYMETERSABOVESEALEVEL, new GroupCountingByMetersAboveSeaLevel());
        commands.put(TypeOfCommands.PRINTASCENDING, new PrintAscending());
    }
    public HashMap<TypeOfCommands, Commands> getCommands() {
        return commands;
    }
}
