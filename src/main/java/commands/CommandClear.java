package commands;
import collection.CreationPriorityQueue;
import IOutils.InputAndOutput;

/**
 * Класс для команды clear, которая очищает коллекцию.
 */

public class CommandClear extends Commands {
    public CommandClear() {
        super("clear", "очистить коллекцию");
    }
    public void doCommand(InputAndOutput inputAndOutput, CommandsControl commandsControl, CreationPriorityQueue priorityQueue) {
        priorityQueue.getPriorityQueue().clear();
        inputAndOutput.output("Коллекция успешно очищена");
    }
}
