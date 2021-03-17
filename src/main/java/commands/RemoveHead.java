package commands;

import IOutils.InputAndOutput;
import collectionUtils.PriorityQueueStorage;

/**
 * Класс для команды remove_head, которая выводит и удаляет первый элемент из коллекции.
 */

public class RemoveHead extends Command {
    /**
     * Конструктор, присваивающий имя и дополнительную информацию о команде.
     */
    public RemoveHead() {
        super("remove_head", "вывести первый элемент коллекции и удалить его");
    }

    /**
     * Метод, исполняющий команду.
     *
     * @param inputAndOutput  объект, через который производится ввод/вывод.
     * @param commandsControl объект, содержащий объекты доступных команд.
     * @param priorityQueue   хранимая коллекция.
     */
    public void doCommand(InputAndOutput inputAndOutput, CommandsControl commandsControl, PriorityQueueStorage priorityQueue) {
        if (priorityQueue.getCollection().isEmpty()) inputAndOutput.output("Коллекция пуста");
        else {
            inputAndOutput.output(priorityQueue.pollFromQueue().toString());
            inputAndOutput.output("удаление элемента успешно завершено");
        }
    }
}
