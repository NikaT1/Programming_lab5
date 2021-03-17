package commands;

import IOutils.InputAndOutput;
import collectionUtils.PriorityQueueStorage;

/**
 * Класс для команды clear, которая очищает коллекцию.
 */

public class CommandClear extends Command {
    /**
     * Конструктор, присваивающий имя и дополнительную информацию о команде.
     */
    public CommandClear() {
        super("clear", "очистить коллекцию");
    }

    /**
     * Метод, исполняющий команду.
     *
     * @param inputAndOutput  объект, через который производится ввод/вывод.
     * @param commandsControl объект, содержащий объекты доступных команд.
     * @param priorityQueue   хранимая коллекция.
     */
    public void doCommand(InputAndOutput inputAndOutput, CommandsControl commandsControl, PriorityQueueStorage priorityQueue) {
        priorityQueue.getCollection().clear();
        inputAndOutput.output("Коллекция успешно очищена");
    }
}
