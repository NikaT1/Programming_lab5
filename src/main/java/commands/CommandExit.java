package commands;

import IOutils.InputAndOutput;
import collectionUtils.PriorityQueueStorage;

/**
 * Класс для команды exit, которая завершает программу без сохранения в файл коллекции.
 */

public class CommandExit extends Commands {
    /**
     * Конструктор, присваивающий имя и дополнительную информацию о команде.
     */
    public CommandExit() {
        super("exit", "завершить программу (без сохранения в файл)");
    }

    /**
     * Метод, исполняющий команду.
     *
     * @param inputAndOutput  объект, через который производится ввод/вывод.
     * @param commandsControl объект, содержащий объекты доступных команд.
     * @param priorityQueue   хранимая коллекция.
     */
    public void doCommand(InputAndOutput inputAndOutput, CommandsControl commandsControl, PriorityQueueStorage priorityQueue) {
        if (inputAndOutput.readAnswer("Вы уверены, что хотите выйти без сохранения коллекции? (yes/no)"))
            System.exit(0);
        else inputAndOutput.output("Выход не выполнен");
    }
}
