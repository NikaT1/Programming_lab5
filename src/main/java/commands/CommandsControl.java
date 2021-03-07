package commands;

import java.util.HashMap;

/**
 * Класс для создания объектов комманд и их хранения.
 */

public class CommandsControl {
    private HashMap<TypeOfCommands, Commands> commands = new HashMap();

    {
        commands.put(TypeOfCommands.HELP, new Help());
        commands.put(TypeOfCommands.SHOW, new Show());
        commands.put(TypeOfCommands.INFO, new Info());
        commands.put(TypeOfCommands.ADD, new Add());
        commands.put(TypeOfCommands.UPDATE_ID, new UpdateId());
        commands.put(TypeOfCommands.REMOVE_BY_ID, new RemoveById());
        commands.put(TypeOfCommands.CLEAR, new CommandClear());
        commands.put(TypeOfCommands.SAVE, new CommandSave());
        commands.put(TypeOfCommands.EXECUTE_SCRIPT, new ExecuteScript());
        commands.put(TypeOfCommands.EXIT, new CommandExit());
        commands.put(TypeOfCommands.REMOVE_HEAD, new RemoveHead());
        commands.put(TypeOfCommands.ADD_IF_MAX, new AddIfMax());
        commands.put(TypeOfCommands.ADD_IF_MIN, new AddIfMin());
        commands.put(TypeOfCommands.AVERAGE_OF_METERS_ABOVE_SEA_LEVEL, new AverageOfMetersAboveSeaLevel());
        commands.put(TypeOfCommands.GROUP_COUNTING_BY_METERS_ABOVE_SEA_LEVEL, new GroupCountingByMetersAboveSeaLevel());
        commands.put(TypeOfCommands.PRINT_ASCENDING, new PrintAscending());
    }

    public HashMap<TypeOfCommands, Commands> getCommands() {
        return commands;
    }
}
