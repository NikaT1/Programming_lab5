package commands;

import IOutils.InputAndOutput;
import collectionUtils.PriorityQueueStorage;

/**
 * Класс для команды info, которая выводит в стандартный поток вывода информацию о коллекции.
 */

public class Info extends Command {
    /**
     * Конструктор, присваивающий имя и дополнительную информацию о команде.
     */
    public Info() {
        super("info", "вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
    }

    /**
     * Метод, исполняющий команду.
     *
     * @param inputAndOutput  объект, через который производится ввод/вывод.
     * @param commandsControl объект, содержащий объекты доступных команд.
     * @param priorityQueue   хранимая коллекция.
     */
    public void doCommand(InputAndOutput inputAndOutput, CommandsControl commandsControl, PriorityQueueStorage priorityQueue) {
        inputAndOutput.output("тип: PriorityQueue");
        inputAndOutput.output("дата инициализации: " + priorityQueue.getCreationDate());
        inputAndOutput.output("количество элементов: " + priorityQueue.getCollection().size());
    }
}
